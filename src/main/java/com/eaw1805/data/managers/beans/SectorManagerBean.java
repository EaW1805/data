package com.eaw1805.data.managers.beans;

import com.eaw1805.data.model.Game;
import com.eaw1805.data.model.Nation;
import com.eaw1805.data.model.map.Position;
import com.eaw1805.data.model.map.Region;
import com.eaw1805.data.model.map.Sector;

import java.util.List;

/**
 * The interface of the SectorManagerBean.
 */
public interface SectorManagerBean extends EntityBean {

    /**
     * get the Sector from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    Sector getByID(int entityID);

    /**
     * Get the sector from the database that corresponds to the input entity.
     *
     * @param entity the coordinates.
     * @return an Entity object.
     */
    Sector getByPosition(final Position entity);

    /**
     * Get the sector from the database that corresponds to the input position.
     *
     * @param entity the Region.
     * @return an Entity object.
     */
    Sector getByRegion(final Region entity);

    /**
     * adding a new entry into the database, according to the input object it
     * receives.
     *
     * @param value the Sector tha we want to add.
     */
    void add(final Sector value);

    /**
     * updating an entry into the database, according to the input object it
     * receives.
     *
     * @param value the Sector tha we want to update.
     */
    void update(final Sector value);

    /**
     * Delete the input Sector from the database.
     *
     * @param entity the Sector tha we want to delete
     */
    void delete(Sector entity);

    /**
     * Listing all the Sectors from the database.
     *
     * @return a list of all the Sectors that exist inside the table Avatar.
     */
    List<Sector> list();

    /**
     * Listing all the Sectors from the database.
     *
     * @param thisGame the game to select.
     * @return a list of all the Sectors.
     */
    List<Sector> listByGame(final Game thisGame);

    /**
     * Listing all sea Sectors from the database that with fish and without storms
     *
     * @param thisGame the game to select.
     * @return a list of all the Sectors.
     */
    List<Sector> listSeaByGame(final Game thisGame);

    /**
     * Listing all the Sectors from the database.
     *
     * @param thisGame   the game to select.
     * @param thisRegion the region to select.
     * @return a list of all the Sectors.
     */
    List<Sector> listByGameRegion(final Game thisGame, final Region thisRegion);

    /**
     * Listing all land Sectors from the database.
     *
     * @param thisGame   the game to select.
     * @param thisRegion the region to select.
     * @return a list of all the Sectors.
     */
    List<Sector> listLandByGameRegion(final Game thisGame, final Region thisRegion);

    /**
     * Listing all sea Sectors from the database that have not any storm on them.
     *
     * @param thisGame      the game to select.
     * @param thisRegion    the region to select.
     * @param includeStorms to include sectors affected by storms.
     * @return a list of all the Sectors.
     */
    List<Sector> listSeaByGameRegion(final Game thisGame, final Region thisRegion, boolean includeStorms);

    /**
     * Listing all sea Sectors adjacent to a sector.
     *
     * @param thisPosition the position to select.
     * @return a list of all the Sectors.
     */
    public List<Sector> listAdjacentSea(final Position thisPosition);

    /**
     * Listing all land Sectors adjacent to a sector.
     *
     * @param thisPosition the position to select.
     * @return a list of all the Sectors.
     */
    public List<Sector> listAdjacentLand(final Position thisPosition);

    /**
     * Listing all arctic sea Sectors from the database that have not any storm on them.
     *
     * @param thisGame the game to select.
     * @return a list of all the Sectors.
     */
    List<Sector> listArcSeaByGame(final Game thisGame);

    /**
     * Listing all central sea Sectors from the database that have not any storm on them.
     *
     * @param thisGame the game to select.
     * @return a list of all the Sectors.
     */
    List<Sector> listCentralSeaByGame(final Game thisGame);

    /**
     * Listing all mediterranean sea Sectors from the database that have not any storm on them.
     *
     * @param thisGame the game to select.
     * @return a list of all the Sectors.
     */
    List<Sector> listMedSeaByGame(final Game thisGame);

    /**
     * Listing all the Sectors from the database.
     *
     * @param thisGame   the game to select.
     * @param thisRegion the region to select.
     * @param minX       the top-left X coordinate.
     * @param minY       the top-left Y coordinate.
     * @param maxX       the bottom-right X coordinate.
     * @param maxY       the bottom-right Y coordinate.
     * @return a list of all the Sectors.
     */
    @SuppressWarnings("unchecked")
    public List<Sector> listByGameRegion(final Game thisGame, final Region thisRegion,
                                         final int minX, final int minY,
                                         final int maxX, final int maxY);

    /**
     * Listing all land Sectors from the database.
     *
     * @param thisGame   the game to select.
     * @param thisRegion the region to select.
     * @param minX       the top-left X coordinate.
     * @param minY       the top-left Y coordinate.
     * @param maxX       the bottom-right X coordinate.
     * @param maxY       the bottom-right Y coordinate.
     * @return a list of all the Sectors.
     */
    @SuppressWarnings("unchecked")
    public List<Sector> listLandByGameRegion(final Game thisGame, final Region thisRegion,
                                             final int minX, final int minY,
                                             final int maxX, final int maxY);

    /**
     * Listing all the Sectors from the database.
     *
     * @param thisGame   the game to select.
     * @param thisNation the owner of the sector.
     * @return a list of all the Sectors.
     */
    List<Sector> listByGameNation(final Game thisGame,
                                  final Nation thisNation);

    /**
     * Listing all the Sectors from the database.
     *
     * @param thisGame   the game to select.
     * @param thisRegion the region to select.
     * @param thisNation the owner of the sector.
     * @param tradeCity  if the sector is a economy city.
     * @return a list of all the Sectors.
     */
    List<Sector> listByGameRegionNation(final Game thisGame,
                                        final Region thisRegion,
                                        final Nation thisNation,
                                        final boolean tradeCity);

    /**
     * Listing all the Sectors from the database.
     *
     * @param thisGame   the game to select.
     * @param thisRegion the region to select.
     * @param thisNation the owner of the sector.
     * @return a list of all the Sectors.
     */
    List<Sector> listByGameRegionNation(final Game thisGame,
                                        final Region thisRegion,
                                        final Nation thisNation);

    /**
     * Listing all the Sectors from the database that contain a barrack or ship yard..
     *
     * @param thisGame   the game to select.
     * @param thisRegion the region to select.
     * @param thisNation the nation to select.
     * @return a list of all the Sectors.
     */
    List<Sector> listBarracksByGameRegionNation(final Game thisGame,
                                                final Region thisRegion,
                                                final Nation thisNation);

    /**
     * Listing all the Sectors from the database that contain a barrack or ship yard..
     *
     * @param thisGame   the game to select.
     * @param thisNation the nation to select.
     * @return a list of all the Sectors.
     */
    List<Sector> listBarracksByGameNation(final Game thisGame, final Nation thisNation);

    /**
     * Remove all the conquer counters from a specific game.
     *
     * @param thisGame the game to select.
     */
    void removeConquer(final Game thisGame);

    /**
     * Remove all the epidemics and rebellions from a specific game.
     *
     * @param thisGame the game to select.
     */
    void removeEpidemics(final Game thisGame);

    /**
     * Listing all the Storm centers from the database.
     *
     * @param thisGame the game to select.
     * @return a list of all the Sectors.
     */
    List<Sector> listStormsByGame(final Game thisGame);

    /**
     * Listing all the arctic Storm centers from the database.
     *
     * @param thisGame the game to select.
     * @return a list of all the Sectors.
     */
    List<Sector> listArcStormsByGame(final Game thisGame);

    /**
     * Listing all the central Storm centers from the database.
     *
     * @param thisGame the game to select.
     * @return a list of all the Sectors.
     */
    List<Sector> listCentralStormsByGame(final Game thisGame);

    /**
     * Listing all the Mediterranean Storm centers from the database.
     *
     * @param thisGame the game to select.
     * @return a list of all the Sectors.
     */
    List<Sector> listMedStormsByGame(final Game thisGame);

    /**
     * Listing all the Storm centers from the database.
     *
     * @param thisGame   the game to select.
     * @param thisRegion the region to select.
     * @return a list of all the Sectors.
     */
    List<Sector> listStormsByGameRegion(final Game thisGame, final Region thisRegion);

    /**
     * Remove all the storms from a specific game except the storm centers.
     *
     * @param thisGame the game to select.
     */
    void removeStorms(final Game thisGame);

    /**
     * Remove all fog of war elements for a particular game.
     *
     * @param thisGame the game to select.
     */
    void removeFOW(final Game thisGame);

    /**
     * Determine if the given position is adjacent to a coastal tile owned by the given nation.
     *
     * @param thisPosition the position.
     * @param thisNation   the nation.
     * @return if the given position is next to a coastal tile or not.
     */
    boolean checkNationCoastal(final Position thisPosition, final Nation thisNation);

    /**
     * Determine if the given position is a coastal tile.
     *
     * @param thisPosition the position.
     * @return if the given position is a coastal tile.
     */
    boolean checkCoastal(final Position thisPosition);

    /**
     * List all sectors conquered by another nation.
     *
     * @param thisGame the game.
     * @return a list of sectors.
     */
    List<Sector> listConquered(final Game thisGame);

    /**
     * List all home sectors.
     *
     * @param thisGame   the game.
     * @param thisNation the nation.
     * @return a list of sectors.
     */
    List<Sector> listHomeSectors(final Game thisGame, final Nation thisNation);

}
