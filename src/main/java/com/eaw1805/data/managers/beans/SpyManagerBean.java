package com.eaw1805.data.managers.beans;

import com.eaw1805.data.model.Game;
import com.eaw1805.data.model.Nation;
import com.eaw1805.data.model.army.Spy;
import com.eaw1805.data.model.map.Position;
import com.eaw1805.data.model.map.Region;

import java.util.List;

/**
 * Manages for CRUD operations for the entity objects.
 */
public interface SpyManagerBean extends EntityBean {

    /**
     * get the Spy from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    Spy getByID(final int entityID);

    /**
     * adding a new entry into the database, according to the input object it
     * receives.
     *
     * @param value the Spy tha we want to add.
     */
    void add(final Spy value);

    /**
     * updating an entry into the database, according to the input object it
     * receives.
     *
     * @param value the Spy tha we want to update.
     */
    void update(final Spy value);

    /**
     * Delete the input Spy from the database.
     *
     * @param value the Spy tha we want to delete.
     */
    void delete(final Spy value);

    /**
     * Listing all the Spies from the database.
     *
     * @return a list of all the Spies that exist inside the table.
     */
    List<Spy> list();

    /**
     * Listing all the Spies from the database.
     *
     * @param thisGame the game to select.
     * @return a list of all the Spies.
     */
    public List<Spy> listByGame(final Game thisGame);

    /**
     * Listing all the Spies from the database at the specific position.
     *
     * @param thisGame the game to select.
     * @param nation   the nation to select.
     * @return a list of all the Spies.
     */
    public List<Spy> listGameNation(final Game thisGame, final Nation nation);

    /**
     * Listing all the Spies from the database at the specific position.
     *
     * @param thisGame the game to select.
     * @param region   the region to select.
     * @param nation   the nation to select.
     * @return a list of all the Spies.
     */
    public List<Spy> listGameRegionNation(final Game thisGame, final Region region, final Nation nation);

    /**
     * List all Spies positioned at a given sector.
     *
     * @param thisPosition the position to check.
     * @return the list of Spies.
     */
    public List<Spy> listAllByPosition(final Position thisPosition);
}
