package com.eaw1805.data.managers.beans;

import com.eaw1805.data.cache.EvictCache;
import com.eaw1805.data.model.Game;
import com.eaw1805.data.model.Nation;
import com.eaw1805.data.model.User;
import com.eaw1805.data.model.UserGame;

import java.util.List;

/**
 * Defines the interface for managing for CRUD operations of the entity objects.
 */
public interface UserGameManagerBean extends EntityBean {

    /**
     * get the UserGame from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    UserGame getByID(int entityID);

    /**
     * adding a new entry into the database, according to the input object it
     * receives.
     *
     * @param value the UserGame tha we want to add.
     */
    @EvictCache(cacheName = "userGame")
    void add(final UserGame value);

    /**
     * updating an entry into the database, according to the input object it
     * receives.
     *
     * @param value the UserGame tha we want to update.
     */
    @EvictCache(cacheName = "userGame")
    void update(final UserGame value);

    /**
     * Delete the input UserGame from the database.
     *
     * @param entity the UserGame tha we want to delete
     */
    void delete(UserGame entity);

    /**
     * Listing all the UserGames from the database.
     *
     * @return a list of all the UserGames that exist inside the table UserGames.
     */
    List<UserGame> list();

    /**
     * Listing all the UserGame from the database.
     *
     * @param owner the User object to filter records.
     * @return a list of all the UserGames that exist inside the table UserGames.
     */
    List<UserGame> list(final User owner);

    /**
     * Listing all the UserGame from the database.
     *
     * @param owner the User object to filter records.
     * @return a list of all the UserGames that exist inside the table UserGames.
     */
    List<UserGame> listAll(final User owner);

    /**
     * Lists all games that the user has accepted.
     *
     * @param owner The user.
     * @return A list of user game objects.
     */
    List<UserGame> listAccepted(final User owner);

    /**
     * Lists all games that the user has to accept or reject.
     *
     * @param owner The user.
     * @return A list of user game objects.
     */
    List<UserGame> listPending(final User owner);

    /**
     * Listing all the UserGame from the database.
     *
     * @param game the Game object to filter records.
     * @return a list of all the UserGames that exist inside the table UserGames.
     */
    List<UserGame> list(final Game game);

    /**
     * Listing all the UserGame from the database.
     *
     * @param game   the Game object to filter records.
     * @param nation the Nation object to filter records.
     * @return a list of all the UserGames that exist inside the table UserGames.
     */
    List<UserGame> list(final Game game, final Nation nation);

    /**
     * Listing all the UserGame from the database.
     *
     * @param game   the Game object to filter records.
     * @param nation the Nation object to filter records.
     * @return a list of all the UserGames that exist inside the table UserGames.
     */
    List<UserGame> listAll(final Game game, final Nation nation);

    /**
     * Listing all the UserGame from the database.
     *
     * @param user the User object to filter records.
     * @param game the Game object to filter records.
     * @return a list of all the UserGames that exist inside the table UserGames.
     */
    List<UserGame> list(final User user, final Game game);

    /**
     * Listing all the UserGame from the database.
     *
     * @param user   the User object to filter records.
     * @param game   the Game object to filter records.
     * @param nation the Nation object to filter records.
     * @return a list of all the UserGames that exist inside the table UserGames.
     */
    List<UserGame> list(final User user, final Game game, final Nation nation);

    /**
     * Listing all active UserGame from the database.
     *
     * @param user   the User object to filter records.
     * @param game   the Game object to filter records.
     * @param nation the Nation object to filter records.
     * @return a list of all the UserGames that exist inside the table UserGames.
     */
    List<UserGame> listActive(final User user, final Game game, final Nation nation);

    /**
     * Listing all the active nations been played by the corresponding user and game.
     *
     * @param user The user to search for active games.
     * @param game The game to search for active games.
     * @return A list with UserGames.
     */
    List<UserGame> listActive(final User user, final Game game);

    /**
     * Listing all the UserGame that the nation controlled is alive from the database.
     *
     * @param user the User object to filter records.
     * @return a list of all the UserGames that exist inside the table UserGames.
     */
    List<UserGame> listActive(final User user);

    /**
     * Listing all inactive UserGame records from the database.
     *
     * @param game   the Game object to filter records.
     * @param nation the Nation object to filter records.
     * @return a list of all inactive UserGames that exist inside the table UserGames.
     */
    List<UserGame> listInActive(final Game game, final Nation nation);

    /**
     * Listing all inactive UserGame records for a given user from the database.
     *
     * @param user the user object to filter records.
     * @return a list of all inactive UserGames that exist inside the table UserGames.
     */
    List<UserGame> listInActive(final User user);

    /**
     * Listing all Games that the input user has played.
     *
     * @param user the User object to filter records.
     * @return a list of all the Game IDs that exist inside the table UserGames.
     */

    List<Integer> listPlayedGames(final User user);

    /**
     * Listing all UserGames that the input user has played.
     *
     * @param user the User object to filter records.
     * @return a list of all the Game IDs that exist inside the table UserGames.
     */
    List<UserGame> listPlayedUserGames(final User user);

    /**
     * Listing all Users played games  for a specific game which not include the given nation.
     *
     * @param user   the User object to filter records.
     * @param game   the Game object to filter records.
     * @param nation the Nation object to filter records.
     * @return a List with the UserGames
     */
    List<UserGame> listPlayedUserGames(final User user, final Game game, final Nation nation);
}
