package com.eaw1805.data.managers.beans;

import com.eaw1805.data.model.Game;
import com.eaw1805.data.model.Nation;
import com.eaw1805.data.model.army.Commander;
import com.eaw1805.data.model.army.Corp;
import com.eaw1805.data.model.map.Position;
import com.eaw1805.data.model.map.Region;

import java.util.List;

/**
 * Manages for CRUD operations for the entity objects.
 */
public interface CorpManagerBean extends EntityBean {

    /**
     * get the Corp from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    Corp getByID(final int entityID);

    /**
     * adding a new entry into the database, according to the input object it
     * receives.
     *
     * @param value the Corp tha we want to add.
     */
    void add(final Corp value);

    /**
     * updating an entry into the database, according to the input object it
     * receives.
     *
     * @param value the Corp tha we want to update.
     */
    void update(final Corp value);

    /**
     * Delete the input Corp from the database.
     *
     * @param value the Corp tha we want to delete.
     */
    void delete(final Corp value);

    /**
     * Listing all the Corps from the database.
     *
     * @return a list of all the Corps that exist inside the table.
     */
    List<Corp> list();

    /**
     * Listing all the Corps from the database for a specific game.
     *
     * @param thisGame the game to select.
     * @return a list of all the Corps.
     */
    List<Corp> listGame(final Game thisGame);

    /**
     * Listing all the Corps from the database owned by the specific nation.
     *
     * @param thisGame the game to select.
     * @param nation   the nation to select.
     * @return a list of all the Corps.
     */
    List<Corp> listGameNation(final Game thisGame, final Nation nation);

    /**
     * Listing all the free Corps from the database in a specific game..
     *
     * @param thisGame the game to select.
     * @return a list of all free Corps.
     */
    List<Corp> listFreeByGame(final Game thisGame);

    /**
     * Listing all the free Corps from the database owned by the specific nation..
     *
     * @param thisGame the game to select.
     * @param nation   the nation to select.
     * @return a list of all free Corps.
     */
    List<Corp> listFreeByGameNation(final Game thisGame, final Nation nation);

    /**
     * Listing all the free Corps from the database owned by the specific nation..
     *
     * @param thisGame the game to select.
     * @param nation   the nation to select.
     * @param region   the region to select.
     * @return a list of all free Corps.
     */
    List<Corp> listFreeByGameNationRegion(final Game thisGame, final Nation nation, final Region region);

    /**
     * Listing all Corps from the database members of the specific army.
     *
     * @param thisGame the game to select.
     * @param armyId   the army to select.
     * @return a list of all the Commanders.
     */
    List<Corp> listByArmy(final Game thisGame, final int armyId);

    /**
     * List all corps with a specific commander.
     *
     * @param thisGame  the game to select.
     * @param commander The commander to get the corps.
     * @return The list of corps with the given commander.
     */
    List<Corp> listByCommander(final Game thisGame, final Commander commander);

    /**
     * List all corps positioned at a given sector.
     *
     * @param thisPosition the position to check.
     * @return the list of corps.
     */
    List<Corp> listAllBySector(final Position thisPosition);
}
