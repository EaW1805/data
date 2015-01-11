package com.eaw1805.data.managers.beans;

import com.eaw1805.data.model.Game;

import java.util.List;

/**
 * Defines the interface for managing for CRUD operations of the entity objects.
 */
public interface GameManagerBean extends EntityBean {

    /**
     * get the Game from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    Game getByID(int entityID);

    /**
     * adding a new entry into the database, according to the input object it
     * receives.
     *
     * @param value the Game tha we want to add.
     */
    void add(final Game value);

    /**
     * updating an entry into the database, according to the input object it
     * receives.
     *
     * @param value the Game tha we want to update.
     */
    void update(final Game value);

    /**
     * Delete the input Game from the database.
     *
     * @param entity the Game tha we want to delete
     */
    void delete(Game entity);

    /**
     * Listing all the Games from the database.
     *
     * @return a list of all the Games that exist inside the table Avatar.
     */
    List<Game> list();

    /**
     * Listing all the Games from the database that are ready to be processed.
     *
     * @return a list of games ready to be processed.
     */
    List<Game> listReady();

    /**
     * Listing all the Games from the database that will be processed in the next 48 hours.
     *
     * @return a list of games that will be processed in the next 48 hours.
     */
    List<Game> listAlmostReady();

    /**
     * Listing all the Games that are being processed.
     *
     * @return a list of games that are being processed.
     */
    List<Game> listProcessed();

    /**
     * Listing all games that are under construction.
     *
     * @return a list of games pending to be constructed.
     */
    List<Game> listUnderConstruction();

    /**
     * Inserts an entry to the database with ID = -1.
     *
     * @param scenarioId the Identity of the scenario.
     */
    void addNegativeGameID(int scenarioId);

    /**
     * Listing all the New Games from the database.
     *
     * @return a list of new games .
     */
    List<Game> listNewGames();

    /**
     * Delete all records associated to a specific game.
     *
     * @param gameId the Identity of the game to delete.
     */
    void deleteGame(int gameId);

    /**
     * Retrieve the last inserted game.
     *
     * @return The last inserted game.
     */
    List<Game> getLastGame();

    /**
     * List all games owned by a specific user.
     *
     * @param userId The user to lists the games.
     * @return A list of games.
     */
    List<Game> listByOwner(final int userId);

    /**
     * List all games not owned by a specific user.
     *
     * @param userId The user to lists the games.
     * @return A list of games.
     */
    List<Game> listByNotOwner(final int userId);

}
