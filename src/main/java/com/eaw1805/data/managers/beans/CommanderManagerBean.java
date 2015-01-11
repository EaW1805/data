package com.eaw1805.data.managers.beans;

import com.eaw1805.data.model.Game;
import com.eaw1805.data.model.Nation;
import com.eaw1805.data.model.army.Commander;
import com.eaw1805.data.model.map.Position;
import com.eaw1805.data.model.map.Region;

import java.util.List;

/**
 * Manages for CRUD operations for the entity objects.
 */
public interface CommanderManagerBean extends EntityBean {

    /**
     * get the Commander from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    Commander getByID(final int entityID);

    List<Commander> getByGameNationIntId(final Game thisGame, final Nation thisNation, final int intId);

    /**
     * adding a new entry into the database, according to the input object it
     * receives.
     *
     * @param value the Commander tha we want to add.
     */
    void add(final Commander value);

    /**
     * updating an entry into the database, according to the input object it
     * receives.
     *
     * @param value the Commander tha we want to update.
     */
    void update(final Commander value);

    /**
     * Delete the input Commander from the database.
     *
     * @param value the Commander tha we want to delete.
     */
    void delete(final Commander value);

    /**
     * Inserts an entry to the database with ID = -1.
     */
    void addNegativeCommanderID();

    /**
     * Listing all the Commanders from the database.
     *
     * @return a list of all the Commanders that exist inside the table.
     */
    List<Commander> list();

    /**
     * Listing all the Commanders from the database.
     *
     * @param thisGame the game to select.
     * @return a list of all the Commanders.
     */
    public List<Commander> listByGame(final Game thisGame);

    /**
     * Listing all the Commanders from the database members of the specific corp.
     *
     * @param thisGame the game to select.
     * @param corpId   the corp to select.
     * @return a list of all the Commanders.
     */
    public List<Commander> listByCorp(final Game thisGame, final int corpId);

    /**
     * Listing all the Commanders from the database members of the specific army.
     *
     * @param thisGame the game to select.
     * @param armyId   the army to select.
     * @return a list of all the Commanders.
     */
    public List<Commander> listByArmy(final Game thisGame, final int armyId);

    /**
     * Listing all the Commanders from the database at the specific position.
     *
     * @param thisGame the game to select.
     * @param nation   the nation to select.
     * @return a list of all the Commanders.
     */
    public List<Commander> listGameNation(final Game thisGame, final Nation nation);

    /**
     * Listing all the alive Commanders from the database at the specific position.
     *
     * @param thisGame the game to select.
     * @param nation   the nation to select.
     * @return a list of all the Commanders.
     */
    List<Commander> listGameNationAlive(final Game thisGame, final Nation nation);

    /**
     * Listing all the Commanders from the database at the specific position.
     *
     * @param thisGame the game to select.
     * @param nation   the nation to select.
     * @param region   the region to select.
     * @return a list of all the Commanders.
     */
    public List<Commander> listGameNationRegion(final Game thisGame, final Nation nation, final Region region);

    /**
     * Listing all the Commanders from the database at the specific position owned by the specific nation.
     *
     * @param thisPosition the position to select.
     * @param nation       the nation to select.
     * @return a list of all the Commanders.
     */
    List<Commander> listByPositionNation(final Position thisPosition, final Nation nation);

    /**
     * List all Commanders positioned at a given sector.
     *
     * @param thisPosition the position to check.
     * @return the list of Commanders.
     */
    List<Commander> listAllByPosition(final Position thisPosition);

    List<Commander> listCapturedByGameNation(final Game thisGame, final Nation thisNation);
}
