package com.eaw1805.data.managers.beans;

import com.eaw1805.data.model.Game;
import com.eaw1805.data.model.Nation;
import com.eaw1805.data.model.fleet.Ship;
import com.eaw1805.data.model.map.Position;
import com.eaw1805.data.model.map.Region;
import com.eaw1805.data.model.map.Sector;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

/**
 * The interface of the ShipManagerBean.
 */
public interface ShipManagerBean extends EntityBean {

    /**
     * get the Ship from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    Ship getByID(int entityID);

    /**
     * adding a new entry into the database, according to the input object it
     * receives.
     *
     * @param value the Ship tha we want to add.
     */
    void add(final Ship value);

    /**
     * updating an entry into the database, according to the input object it
     * receives.
     *
     * @param value the Ship tha we want to update.
     */
    void update(final Ship value);

    /**
     * Delete the input Ship from the database.
     *
     * @param entity the Ship tha we want to delete
     */
    void delete(Ship entity);

    /**
     * Listing all the Ships from the database.
     *
     * @return a list of all the Ships that exist inside the table Avatar.
     */
    List<Ship> list();

    /**
     * Listing all the Ships from the database for the specific game.
     *
     * @param thisGame the game to select.
     * @return a list of all the Ships.
     */
    List<Ship> listByGame(final Game thisGame);

    /**
     * Listing all the Ships from the database members of the specific fleet.
     *
     * @param thisGame the game to select.
     * @param fleet    the fleet to select.
     * @return a list of all the Ships.
     */
    List<Ship> listByFleet(final Game thisGame, final int fleet);

    /**
     * Listing all the Ships from the database at the specific position owned by the specific nation.
     *
     * @param thisPosition the position to select.
     * @param nation       the nation to select.
     * @return a list of all the Ships.
     */
    List<Ship> listByPositionNation(final Position thisPosition, final Nation nation);

    /**
     * Listing all the ships from the database that belongs in the specific game and nation.
     *
     * @param thisGame   The Game.
     * @param thisNation The Nation.
     * @return A list of all the Ships.
     */
    List<Ship> listGameNation(final Game thisGame, final Nation thisNation);

    /**
     * Listing all the Ships from the database at the specific position.
     *
     * @param thisGame the game to select.
     * @param nation   the nation to select.
     * @param region   the region to select.
     * @return a list of all the Ships.
     */
    List<Ship> listGameNationRegion(final Game thisGame, final Nation nation, final Region region);

    /**
     * List all ships in the specific position and game.
     *
     * @param position The position to list the ships that are on it.
     * @return A list of ships.
     */
    List<Ship> listByGamePosition(final Position position);

    /**
     * Listing all the free Ships from the database for a specific game.
     *
     * @param thisGame the game to select.
     * @return a list of all free Ships.
     */
    List<Ship> listFreeByGame(final Game thisGame);

    /**
     * Listing all the free Ships from the database owned by the specific nation..
     *
     * @param thisGame the game to select.
     * @param nation   the nation to select.
     * @return a list of all free Ships.
     */
    List<Ship> listFreeByGameNation(final Game thisGame, final Nation nation);

    /**
     * Listing all the free Ships from the database owned by the specific nation..
     *
     * @param thisGame the game to select.
     * @param nation   the nation to select.
     * @param region   the region to select.
     * @return a list of all free Ships.
     */
    List<Ship> listFreeByGameNationRegion(final Game thisGame, final Nation nation, final Region region);

    /**
     * Listing sectors with ships belonging to more than 1 owner.
     *
     * @param thisGame the game to select.
     * @return a list of all the sectors.
     */
    List<Sector> listMultiOwners(final Game thisGame);

    /**
     * List all nations that have ships in the given position.
     *
     * @param thisPosition the position.
     * @return a list of nations.
     */
    List<Nation> listOwners(final Position thisPosition);

    /**
     * List the number of ships per sector for particular nation.
     *
     * @param thisGame   the Game .
     * @param thisNation the Nation owner.
     * @return a mapping of ship count to sectors.
     */
    Map<Sector, BigInteger> countShips(final Game thisGame, final Nation thisNation);

    /**
     * Count the number of ships at the given position based on their owner.
     *
     * @param thisPosition the position.
     * @param onlyMerchant true, count only Merchant, false count only warships.
     * @return a mapping of ships count to nations.
     */
    Map<Nation, BigInteger> countShipsByOwner(final Position thisPosition, final boolean onlyMerchant);

    /**
     * Count the number of ships at the given position based on their owner.
     *
     * @param thisPosition the position.
     * @return a mapping of ships count to nations.
     */
    Map<Nation, BigInteger> countNearbyShipsByOwner(final Position thisPosition);

    /**
     * Remove all the flags signifying participation in a naval battle.
     *
     * @param thisGame the game to select.
     */
    void removeNavalFlag(final Game thisGame);

    /**
     * Remove all the flags signifying movement.
     *
     * @param thisGame the game to select.
     */
    void removeHasMovedFlag(final Game thisGame);

    /**
     * List all ships positioned at a given sector.
     *
     * @param position the position to check.
     * @return the list of ships.
     */
    List<Ship> listAllBySector(final Position position);
}
