package com.eaw1805.data.managers.beans;

import com.eaw1805.data.model.Game;
import com.eaw1805.data.model.User;
import com.eaw1805.data.model.WatchGame;

import java.util.List;

/**
 * CRUD operations for WatchGame objects.
 */
public interface WatchGameManagerBean extends EntityBean {

    /**
     * get the WatchGame from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    WatchGame getByID(int entityID);

    /**
     * adding a new entry into the database, according to the input object it
     * receives.
     *
     * @param value the User tha we want to add.
     */
    void add(final WatchGame value);

    /**
     * updating an entry into the database, according to the input object it
     * receives.
     *
     * @param value the User tha we want to update.
     */
    void update(final WatchGame value);

    /**
     * Delete the input WatchGame from the database.
     *
     * @param entity the WatchGame tha we want to delete
     */
    void delete(WatchGame entity);

    /**
     * Listing all the WatchGames from the database.
     *
     * @return a list of all the Users that exist inside the table Avatar.
     */
    List<WatchGame> list();

    /**
     * Listing all WatchGame objects from the database that the user watches.
     *
     * @param user the user to search the watchGame objects.
     * @return a list WatchGame objects for the corresponding user.
     */
    List<WatchGame> listByUser(final User user);

    /**
     * Listing all WatchGame objects from the database for the current game.
     *
     * @param game the game to search the watchGame objects.
     * @return a list WatchGame objects for the corresponding game.
     */
    List<WatchGame> listByGame(final Game game);

    /**
     * Listing all WatchGame objects from the database for the current user and game.
     *
     * @param user the user to search the watchGame objects.
     * @param game the game to search the watchGame objects.
     * @return a list WatchGame objects for the corresponding game.
     */
    List<WatchGame> listByUserGame(final User user, final Game game);

    void delete(final User user);

}
