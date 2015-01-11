package com.eaw1805.data.managers.beans;

import com.eaw1805.data.model.Game;
import com.eaw1805.data.model.Nation;
import com.eaw1805.data.model.fleet.Fleet;
import com.eaw1805.data.model.map.Position;
import com.eaw1805.data.model.map.Region;

import java.util.List;

/**
 * Defines the interface for managing for CRUD operations of the entity objects.
 */
public interface FleetManagerBean extends EntityBean {

    /**
     * get the Fleet from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    Fleet getByID(final int entityID);

    /**
     * adding a new entry into the database, according to the input object it
     * receives.
     *
     * @param value the Fleet tha we want to add.
     */
    void add(final Fleet value);

    /**
     * updating an entry into the database, according to the input object it
     * receives.
     *
     * @param value the Fleet tha we want to update.
     */
    void update(final Fleet value);

    /**
     * Delete the input Fleet from the database.
     *
     * @param value the Fleet tha we want to delete.
     */
    void delete(final Fleet value);

    /**
     * Listing all the Fleets from the database.
     *
     * @return a list of all the Corps that exist inside the table.
     */
    List<Fleet> list();

    /**
     * Listing all the Fleets from the database for a specific game.
     *
     * @param thisGame the game to select.
     * @return a list of all the Fleets.
     */
    List<Fleet> listGame(final Game thisGame);

    /**
     * Listing all the Fleets from the database owned by the specific nation.
     *
     * @param thisGame the game to select.
     * @param nation   the nation to select.
     * @return a list of all the Fleets.
     */
    List<Fleet> listGameNation(final Game thisGame, final Nation nation);

    /**
     * List all fleets positioned at a given sector.
     *
     * @param position the position to check.
     * @return the list of fleets.
     */
    List<Fleet> listAllByPosition(final Position position);

    /**
     * List all fleets in the game.
     *
     * @param game the game to check.
     * @return the list of fleets.
     */
    List<Fleet> listByGame(final Game game);

    /**
     * Listing all the Fleets from the database owned by the specific nation.
     *
     * @param thisGame the game to select.
     * @param region   the region to select.
     * @param nation   the nation to select.
     * @return a list of all the Fleets.
     */
    List<Fleet> listGameNationRegion(final Game thisGame, final Nation nation, final Region region);

}
