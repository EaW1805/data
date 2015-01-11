package com.eaw1805.data.managers.beans;

import com.eaw1805.data.model.Game;
import com.eaw1805.data.model.Nation;
import com.eaw1805.data.model.army.Army;
import com.eaw1805.data.model.map.Position;
import com.eaw1805.data.model.map.Region;

import java.util.List;

/**
 * Defines the interface for managing for CRUD operations of the entity objects.
 */
public interface ArmyManagerBean
        extends EntityBean {

    /**
     * get the Army from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    Army getByID(final int entityID);

    /**
     * adding a new entry into the database, according to the input object it
     * receives.
     *
     * @param value the Army tha we want to add.
     */
    void add(final Army value);

    /**
     * updating an entry into the database, according to the input object it
     * receives.
     *
     * @param value the Army tha we want to update.
     */
    void update(final Army value);

    /**
     * Delete the input Army from the database.
     *
     * @param value the Army tha we want to delete.
     */
    void delete(final Army value);

    /**
     * Listing all the Armies from the database.
     *
     * @return a list of all the Corps that exist inside the table.
     */
    List<Army> list();

    /**
     * Listing all the Armies from the database for a specific game.
     *
     * @param thisGame the game to select.
     * @return a list of all the Armies.
     */
    List<Army> listGame(final Game thisGame);

    /**
     * Listing all the Armies from the database owned by the specific nation.
     *
     * @param thisGame the game to select.
     * @param nation   the nation to select.
     * @return a list of all the Armies.
     */
    List<Army> listGameNation(final Game thisGame, final Nation nation);

    /**
     * Listing all the Armies from the database owned by the specific nation.
     *
     * @param thisGame the game to select.
     * @param nation   the nation to select.
     * @param region   the region to select.
     * @return a list of all the Armies.
     */
    List<Army> listGameNationRegion(final Game thisGame, final Nation nation, final Region region);

    /**
     * Listing all the Armies from the database located in the colonies.
     *
     * @param thisGame the game to select.
     * @return a list of all the Armies.
     */
    public List<Army> listColonies(final Game thisGame);

    /**
     * List all Armies positioned at a given sector.
     *
     * @param thisPosition the position to check.
     * @return the list of Armies.
     */
    List<Army> listAllBySector(final Position thisPosition);

}
