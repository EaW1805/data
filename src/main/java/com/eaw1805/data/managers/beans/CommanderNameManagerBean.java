package com.eaw1805.data.managers.beans;

import com.eaw1805.data.model.Game;
import com.eaw1805.data.model.Nation;
import com.eaw1805.data.model.army.CommanderName;

import java.util.List;

/**
 * Manages for CRUD operations for the entity objects.
 */
public interface CommanderNameManagerBean extends EntityBean {

    /**
     * get the CommanderName from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    CommanderName getByID(final int entityID);

    /**
     * adding a new entry into the database, according to the input object it
     * receives.
     *
     * @param value the CommanderName tha we want to add.
     */
    void add(final CommanderName value);

    /**
     * updating an entry into the database, according to the input object it
     * receives.
     *
     * @param value the CommanderName tha we want to update.
     */
    void update(final CommanderName value);

    /**
     * Delete the input CommanderName from the database.
     *
     * @param value the CommanderName tha we want to delete.
     */
    void delete(final CommanderName value);

    /**
     * Listing all the CommanderNames from the database.
     *
     * @return a list of all the CommanderNames that exist inside the table.
     */
    List<CommanderName> list();

    /**
     * Listing all the CommanderNames from the database owned by the specific nation.
     *
     * @param nation the nation to select.
     * @return a list of all the CommanderNames.
     */
    List<CommanderName> listNation(final Nation nation);

    /**
     * Listing all the CommanderNames from the database owned by the specific game.
     *
     * @param game the game to select.
     * @return a list of all the CommanderNames.
     */
    List<CommanderName> listGame(final Game game);

}
