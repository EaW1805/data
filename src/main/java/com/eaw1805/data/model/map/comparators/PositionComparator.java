package com.eaw1805.data.model.map.comparators;

import com.eaw1805.data.constants.RegionConstants;
import com.eaw1805.data.managers.NationManager;
import com.eaw1805.data.managers.map.RegionManager;
import com.eaw1805.data.managers.map.SectorManager;
import com.eaw1805.data.model.Game;
import com.eaw1805.data.model.Nation;
import com.eaw1805.data.model.map.Position;
import com.eaw1805.data.model.map.Region;
import com.eaw1805.data.model.map.Sector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Used to sort entities based on their distance from the nearest trade city if in Europe, otherwise randomly if in the
 * colonies.
 */
public class PositionComparator
        implements RegionConstants {

    /**
     * Keep track of all the trade cities of each nation.
     */
    private final Map<Nation, List<Position>> citiesEurope;

    /**
     * Random generator.
     */
    protected final Random randomGen;

    /**
     * Default Constructor.
     *
     * @param thisGame  the game to sort.
     * @param generator the random number generator.
     */
    public PositionComparator(final Game thisGame, final Random generator) {
        citiesEurope = new HashMap<Nation, List<Position>>();
        randomGen = generator;

        final Region europe = RegionManager.getInstance().getByID(EUROPE);
        final List<Nation> lstNation = NationManager.getInstance().list();
        for (final Nation nation : lstNation) {
            // Initialize list
            final List<Position> lstPositions = new ArrayList<Position>();

            // Retrieve trade cities for this nation
            final List<Sector> lstCities = SectorManager.getInstance().listByGameRegionNation(thisGame, europe, nation, true);
            for (final Sector sector : lstCities) {
                lstPositions.add(sector.getPosition());
            }

            citiesEurope.put(nation, lstPositions);
        }
    }

    /**
     * Compare the two positions based on their location.
     *
     * @param pos1   the position of the 1st entity.
     * @param pos2   the position of the 2nd entity.
     * @param owner1 the owner of the 1st entity.
     * @param owner2 the owner of the 2nd entity.
     * @return -1 if the 1st entity is ordered first, 1 if the 2nd entity is order first, 0 if both at same distance.
     */
    protected final int comparePositions(final Position pos1, final Position pos2, final Nation owner1, final Nation owner2) {
        int comparison;
        // First check region
        if (pos1.getRegion().getId() < pos2.getRegion().getId()) {
            comparison = 1;

        } else if (pos1.getRegion().getId() > pos2.getRegion().getId()) {
            comparison = -1;

        } else {
            // Entities at Europe are sorted based on distance from nearest trade city
            if (pos1.getRegion().getId() == EUROPE) {
                // Locate closer trade city for each brigade
                final double dist1 = locateClosestCity(pos1, owner1);
                final double dist2 = locateClosestCity(pos2, owner2);

                if (dist1 < dist2) {
                    comparison = 1;

                } else if (dist1 > dist2) {
                    comparison = -1;

                } else {
                    // Random ordering
                    if (pos1.getRandomOrder() == 0) {
                        pos1.setRandomOrder(randomGen.nextInt());
                    }

                    if (pos2.getRandomOrder() == 0) {
                        pos2.setRandomOrder(randomGen.nextInt());
                    }

                    if (pos1.getRandomOrder() < pos2.getRandomOrder()) {
                        comparison = -1;

                    } else {
                        comparison = 1;
                    }
                }

            } else {
                // Random ordering
                if (pos1.getRandomOrder() == 0) {
                    pos1.setRandomOrder(randomGen.nextInt());
                }

                if (pos2.getRandomOrder() == 0) {
                    pos2.setRandomOrder(randomGen.nextInt());
                }

                if (pos1.getRandomOrder() < pos2.getRandomOrder()) {
                    comparison = -1;

                } else {
                    comparison = 1;
                }
            }
        }
        return comparison;
    }

    /**
     * Identify the closest trade city for the given entity.
     *
     * @param pos   the position of the entity.
     * @param owner the nation owning the entity.
     * @return the distance to the nearest trade city.
     */
    protected final double locateClosestCity(final Position pos, final Nation owner) {
        final List<Position> lstCities = citiesEurope.get(owner);
        double distance = Double.MAX_VALUE;
        if (!lstCities.isEmpty()) {
            for (final Position thisCity : lstCities) {
                final double thisDistance = pos.distance(thisCity);
                distance = Math.min(distance, thisDistance);
            }
        }
        return distance;
    }

}
