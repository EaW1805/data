package com.eaw1805.data.managers.beans;

import com.eaw1805.data.model.Game;
import com.eaw1805.data.model.Nation;
import com.eaw1805.data.model.army.Battalion;
import com.eaw1805.data.model.army.Brigade;
import com.eaw1805.data.model.map.Position;
import com.eaw1805.data.model.map.Sector;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

/**
 * The interface of the BattalionManager.
 */
public interface BattalionManagerBean extends EntityBean {

    /**
     * get the Battalion from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    Battalion getByID(int entityID);

    /**
     * adding a new entry into the database, according to the input object it
     * receives.
     *
     * @param value the Battalion tha we want to add.
     */
    void add(final Battalion value);

    /**
     * updating an entry into the database, according to the input object it
     * receives.
     *
     * @param value the Battalion tha we want to update.
     */
    void update(final Battalion value);

    /**
     * Delete the input Battalion from the database.
     *
     * @param entity the Battalion tha we want to delete
     */
    void delete(Battalion entity);

    /**
     * Listing all the Battalions from the database.
     *
     * @return a list of all the Battalions that exist inside the table Avatar.
     */
    List<Battalion> list();

    /**
     * Listing all the battalions from the database for the specific game that have less than 50 headcount.
     *
     * @param thisGame the game to select.
     * @return a list of all the battalions.
     */
    List<Battalion> listSmallByGame(final Game thisGame);

    /**
     * Listing all the battalions from the database with same type.
     *
     * @param thisBattalion the battalion to select.
     * @return a list of all the battalions.
     */
    List<Battalion> listByType(final Battalion thisBattalion);

    /**
     * Get all battalions that belong in one of the given brigades.
     *
     * @param brigades The brigades to search battalions for.
     * @return A list with Battalions.
     */
    List<Battalion> listByBrigades(final List<Brigade> brigades);

    /**
     * Get all battalions in the specific position.
     *
     * @param position The position to search for battalions.
     * @return The list of battalions being in the specific position.
     */
    List<Battalion> listByGamePosition(final Position position);

    /**
     * Get all battalions in the specific position.
     *
     * @param position The position to search for battalions.
     * @param owner    The owner of the battalions.
     * @return The list of battalions being in the specific position.
     */
    List<Battalion> listByGamePosition(final Position position, final Nation owner);

    /**
     * Count the number of battalions at the given position based on their owner.
     *
     * @param thisPosition the position.
     * @return a mapping of battalion count to nations.
     */
    Map<Nation, BigInteger> countBattalionsByOwner(final Position thisPosition);

    /**
     * List the number of battalions per sector and nation.
     *
     * @param thisGame the Game .
     * @return a mapping of battalion count to nations.
     */
    Map<Sector, BigInteger> listBattalions(final Game thisGame);

    /**
     * List the number of LC battalions per sector and nation.
     *
     * @param thisGame the Game .
     * @return a mapping of battalion count to nations.
     */
    Map<Nation, Map<Sector, BigInteger>> listLCBattalions(final Game thisGame);

    /**
     * List the number of battalions per sector for particular nation.
     *
     *
     * @param thisGame   the Game .
     * @param thisNation the Nation owner.
     * @param limit      the headcount limit for taking into account a battalion.
     * @param notLost
     * @return a mapping of battalion count to sectors.
     */
    Map<Sector, BigInteger> countBattalions(final Game thisGame, final Nation thisNation, final int limit, boolean notLost);

    /**
     * Remove all the flags signifying movement.
     *
     * @param thisGame the game to select.
     */
    void removeHasMovedFlag(final Game thisGame);

    /**
     * Remove all the flags signifying losing a battle.
     *
     * @param thisGame the game to select.
     */
    void removeHasLostFlag(final Game thisGame);

}
