package com.eaw1805.data.managers.beans;

import com.eaw1805.data.model.Game;
import com.eaw1805.data.model.Nation;
import com.eaw1805.data.model.Report;

import java.util.List;

/**
 * Defines the interface for managing for CRUD operations of the entity objects.
 */
public interface ReportManagerBean extends EntityBean {

    /**
     * get the Report from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    Report getByID(int entityID);

    /**
     * Get the Report from the database that corresponds to the input
     * parameters.
     *
     * @param owner the Owner of the Report object.
     * @param game  the Game of the Report object.
     * @param turn  the Turn of the Report object.
     * @param key   the Key of the Report object.
     * @return an Entity object.
     */
    Report getByOwnerTurnKey(final Nation owner, final Game game, final int turn, final String key);

    /**
     * adding a new entry into the database, according to the input object it
     * receives.
     *
     * @param value the Report tha we want to add.
     */
    void add(final Report value);

    /**
     * updating an entry into the database, according to the input object it
     * receives.
     *
     * @param value the Report tha we want to update.
     */
    void update(final Report value);

    /**
     * Delete the input Report from the database.
     *
     * @param entity the Report tha we want to delete
     */
    void delete(Report entity);

    /**
     * Listing all the Reports from the database.
     *
     * @return a list of all the Reports that exist inside the table Avatar.
     */
    List<Report> list();

    /**
     * List al the Report from the database that corresponds to the input
     * parameters.
     *
     * @param owner the Owner of the Report object.
     * @param game  the Game of the Report object.
     * @param key   the Key of the Report object.
     * @return an Entity object.
     */
    List<Report> listByOwnerKey(final Nation owner, final Game game, final String key);

    /**
     * List all the Report from the database that corresponds to the input
     * parameters.
     *
     * @param owner the Owner of the Report object.
     * @param game  the Game of the Report object.
     * @param turn  the Turn of the Report object.
     * @param key   the Key of the Report object.
     * @return an Entity object.
     */
    List<Report> listByOwnerTurnKey(final Nation owner, final Game game, final int turn, final String key);

    /**
     * List all the Report from the database that corresponds to the input
     * parameters.
     *
     * @param game the Game of the Report object.
     * @param turn the Turn of the Report object.
     * @param key  the Key of the Report object.
     * @return an Entity object.
     */
    List<Report> listByTurnKey(final Game game, final int turn, final String key);

    /**
     * List all the Report from the database that corresponds to the input
     * parameters.
     *
     * @param game the Game of the Report object.
     * @param turn the Turn of the Report object.
     * @param key  the Key of the Report object.
     * @return an Entity object.
     */
    List<Report> listByTurnKeyFixed(final Game game, final int turn, final String key);

    /**
     * List all the Report from the database that corresponds to the input
     * parameters.
     *
     * @param game the Game of the Report object.
     * @param key  the Key of the Report object.
     * @return an Entity object.
     */
    List<Report> listByKey(final Game game, final String key);

    /**
     * Rank reports for Hall of Fame purposes for particular game and turn.
     *
     * @param key      the key to use for sorting the nations.
     * @param thisGame the game to inspect.
     * @param thisTurn the turn to inspect.
     * @return a list of nations ordered by the the value.
     */
    List<Nation> rankNations(final String key, final Game thisGame, final int thisTurn);

    /**
     * Rank reports for Hall of Fame purposes for particular game and turn.
     *
     * @param key      the key to use for sorting the nations.
     * @param thisGame the game to inspect.
     * @param thisTurn the turn to inspect.
     * @param limit    the number of entries to retrieve.
     * @return a list of nations ordered by the the value.
     */
    public List<Nation> rankNations(final String key, final Game thisGame, final int thisTurn, final int limit);

    /**
     * Rank reports for Hall of Fame purposes for particular game and turn.
     *
     * @param key      the key to use for sorting the nations.
     * @param thisGame the game to inspect.
     * @param thisTurn the turn to inspect.
     * @param limit    the number of entries to retrieve.
     * @return a list of nations ordered by the the value.
     */
    public List<Nation> rankNationsFixed(final String key, final Game thisGame, final int thisTurn, final int limit);

}
