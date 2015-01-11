package com.eaw1805.data.managers;

import com.eaw1805.data.managers.beans.UserGameManagerBean;
import com.eaw1805.data.model.Game;
import com.eaw1805.data.model.Nation;
import com.eaw1805.data.model.User;
import com.eaw1805.data.model.UserGame;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * CRUD operations for UserGame objects.
 */
public class UserGameManager
        extends AbstractManager<UserGame>
        implements UserGameManagerBean {

    /**
     * static instance(ourInstance) initialized as null.
     */
    private static UserGameManagerBean ourInstance = null;

    /**
     * Public constructor .
     */
    public UserGameManager() {
        // Does nothing
        super();
    }

    /**
     * GameManager is loaded on the first execution of GameManager.getInstance()
     * or the first access to GameManager.ourInstance, not before.
     *
     * @return ourInstance
     */
    public static UserGameManagerBean getInstance() {
        synchronized (UserGameManager.class) {
            if (ourInstance == null) {
                ourInstance = new UserGameManager();
            }
        }

        return ourInstance;
    }

    /**
     * Set the global instance of the manager. Used for the integration with Spring.
     *
     * @param thisInstance the manager bean.
     */
    public static void setInstance(final UserGameManagerBean thisInstance) {
        ourInstance = thisInstance;
    }

    /**
     * get the User from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    public UserGame getByID(final int entityID) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(UserGame.class);
        criteria.add(Restrictions.eq("id", entityID));
        return (UserGame) criteria.uniqueResult();
    }

    /**
     * Delete the input UserGame from the database.
     *
     * @param userGame the UserGame tha we want to delete
     */
    public void delete(final UserGame userGame) {
        super.delete(userGame, userGame.getId());
    }

    /**
     * Adding a new UserGame into the database,
     *
     * @param entity a UserGame object.
     */

    public void add(final UserGame entity) {
        super.add(entity);
//        CachingManager.getInstance().clearGame(entity.getGame());
    }

    /**
     * updating the UserGame into the database.
     *
     * @param entity a UserGame object.
     */
    public void update(final UserGame entity) {
        super.update(entity);
//        CachingManager.getInstance().clearGame(entity.getGame());
    }

    /**
     * Listing all the UserGames from the database.
     *
     * @return a list of all the UserGames that exist inside the table UserGames.
     */
    public List<UserGame> list() {
        return super.list(new UserGame());
    }

    /**
     * Listing all the UserGame from the database.
     *
     * @param owner the User object to filter records.
     * @return a list of all the UserGames that exist inside the table UserGames.
     */
    @SuppressWarnings("unchecked")
    public List<UserGame> list(final User owner) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(UserGame.class);
        criteria.add(Restrictions.eq("current", true));
        criteria.add(Restrictions.eq("userId", owner.getUserId()));
        criteria.addOrder(Order.asc("game"));
        criteria.addOrder(Order.asc("nation"));
        return criteria.list();
    }

    /**
     * Listing all the UserGame from the database.
     *
     * @param owner the User object to filter records.
     * @return a list of all the UserGames that exist inside the table UserGames.
     */
    @SuppressWarnings("unchecked")
    public List<UserGame> listAll(final User owner) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(UserGame.class);
        criteria.add(Restrictions.eq("userId", owner.getUserId()));
        criteria.addOrder(Order.asc("game"));
        criteria.addOrder(Order.asc("nation"));
        return criteria.list();
    }

    /**
     * Lists all games that the user has accepted.
     *
     * @param owner The user.
     * @return A list of user game objects.
     */
    public List<UserGame> listAccepted(final User owner) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(UserGame.class);
        criteria.add(Restrictions.eq("userId", owner.getUserId()));
        criteria.add(Restrictions.eq("current", true));
        criteria.add(Restrictions.eq("accepted", true));
        criteria.addOrder(Order.asc("game"));
        criteria.addOrder(Order.asc("nation"));
        return criteria.list();
    }

    /**
     * Lists all games that the user has to accept or reject.
     *
     * @param owner The user.
     * @return A list of user game objects.
     */
    public List<UserGame> listPending(final User owner) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(UserGame.class);
        criteria.add(Restrictions.eq("current", true));
        criteria.add(Restrictions.eq("userId", owner.getUserId()));
        criteria.add(Restrictions.eq("accepted", false));
        criteria.addOrder(Order.asc("game"));
        criteria.addOrder(Order.asc("nation"));
        return criteria.list();
    }

    /**
     * Listing all the UserGame from the database.
     *
     * @param game the Game object to filter records.
     * @return a list of all the UserGames that exist inside the table UserGames.
     */
    @SuppressWarnings("unchecked")
    public List<UserGame> list(final Game game) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(UserGame.class);
        criteria.add(Restrictions.eq("game", game));
        criteria.add(Restrictions.eq("current", true));
        return criteria.list();
    }

    /**
     * Listing all the UserGame from the database.
     *
     * @param game   the Game object to filter records.
     * @param nation the Nation object to filter records.
     * @return a list of all the UserGames that exist inside the table UserGames.
     */
    @SuppressWarnings("unchecked")
    public List<UserGame> list(final Game game, final Nation nation) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(UserGame.class);
        criteria.add(Restrictions.eq("current", true));
        criteria.add(Restrictions.eq("game", game));
        criteria.add(Restrictions.eq("nation", nation));
        return criteria.list();
    }

    /**
     * Listing all the UserGame from the database.
     *
     * @param game   the Game object to filter records.
     * @param nation the Nation object to filter records.
     * @return a list of all the UserGames that exist inside the table UserGames.
     */
    public List<UserGame> listAll(final Game game, final Nation nation) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(UserGame.class);
        criteria.add(Restrictions.eq("game", game));
        criteria.add(Restrictions.eq("nation", nation));
        return criteria.list();
    }

    /**
     * Listing all the UserGame from the database.
     *
     * @param user the User object to filter records.
     * @param game the Game object to filter records.
     * @return a list of all the UserGames that exist inside the table UserGames.
     */
    @SuppressWarnings("unchecked")
    public List<UserGame> list(final User user, final Game game) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(UserGame.class);
        criteria.add(Restrictions.eq("current", true));
        criteria.add(Restrictions.eq("userId", user.getUserId()));
        criteria.add(Restrictions.eq("game", game));
        criteria.addOrder(Order.asc("id"));
        return criteria.list();
    }

    /**
     * Listing all the UserGame from the database.
     *
     * @param user   the User object to filter records.
     * @param game   the Game object to filter records.
     * @param nation the Nation object to filter records.
     * @return a list of all the UserGames that exist inside the table UserGames.
     */
    @SuppressWarnings("unchecked")
    public List<UserGame> list(final User user, final Game game, final Nation nation) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(UserGame.class);
        criteria.add(Restrictions.eq("current", true));
        criteria.add(Restrictions.eq("userId", user.getUserId()));
        criteria.add(Restrictions.eq("game", game));
        criteria.add(Restrictions.eq("nation", nation));
        return criteria.list();
    }

    /**
     * Listing all the UserGame from the database.
     *
     * @param user   the User object to filter records.
     * @param game   the Game object to filter records.
     * @param nation the Nation object to filter records.
     * @return a list of all the UserGames that exist inside the table UserGames.
     */
    @SuppressWarnings("unchecked")
    public List<UserGame> listActive(final User user, final Game game, final Nation nation) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(UserGame.class);
        criteria.add(Restrictions.eq("current", true));
        criteria.add(Restrictions.eq("userId", user.getUserId()));
        criteria.add(Restrictions.eq("game", game));
        criteria.add(Restrictions.eq("nation", nation));
        criteria.add(Restrictions.or(Restrictions.eq("active", true), Restrictions.eq("alive", false)));
        return criteria.list();
    }

    /**
     * Listing all the active nations been played by the corresponding user and game.
     *
     * @param user The user to search for active games.
     * @param game The game to search for active games.
     * @return A list with UserGames.
     */
    public List<UserGame> listActive(final User user, final Game game) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(UserGame.class);
        criteria.add(Restrictions.eq("current", true));
        criteria.add(Restrictions.eq("userId", user.getUserId()));
        criteria.add(Restrictions.eq("game", game));
        criteria.add(Restrictions.eq("active", true));
        return criteria.list();
    }

    /**
     * Listing all the UserGame that the nation controlled is alive from the database.
     *
     * @param user the User object to filter records.
     * @return a list of all the UserGames that exist inside the table UserGames.
     */
    @SuppressWarnings("unchecked")
    public List<UserGame> listActive(final User user) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(UserGame.class);
        criteria.add(Restrictions.eq("current", true));
        criteria.add(Restrictions.eq("userId", user.getUserId()));
        criteria.add(Restrictions.eq("active", true));
        criteria.addOrder(Order.asc("game"));
        criteria.addOrder(Order.asc("nation"));
        return criteria.list();
    }

    /**
     * Listing all inactive UserGame records from the database.
     *
     * @param game   the Game object to filter records.
     * @param nation the Nation object to filter records.
     * @return a list of all inactive UserGames that exist inside the table UserGames.
     */
    @SuppressWarnings("unchecked")
    public List<UserGame> listInActive(final Game game, final Nation nation) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(UserGame.class);
        criteria.add(Restrictions.eq("current", false));
        criteria.add(Restrictions.eq("game", game));
        criteria.add(Restrictions.eq("nation", nation));
        criteria.addOrder(Order.asc("turnPickUp"));
        return criteria.list();
    }

    /**
     * Listing all inactive UserGame records for a given user from the database.
     *
     * @param user the user object to filter records.
     * @return a list of all inactive UserGames that exist inside the table UserGames.
     */
    public List<UserGame> listInActive(final User user) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(UserGame.class);
        criteria.add(Restrictions.eq("current", false));
        criteria.add(Restrictions.eq("userId", user.getUserId()));
        criteria.addOrder(Order.asc("game"));
        criteria.addOrder(Order.asc("nation"));
        return criteria.list();
    }

    /**
     * Listing all Games that the input user has played.
     *
     * @param user the User object to filter records.
     * @return a list of all the Game IDs that exist inside the table UserGames.
     */
    @SuppressWarnings("unchecked")
    public List<Integer> listPlayedGames(final User user) {
        final Session session = getSessionFactory().getCurrentSession();
        final String thisQuery = "SELECT distinct `GAME_ID` " +
                "FROM `USERS_GAMES` WHERE `USER_ID`= " + user.getUserId();

        final List<Integer> lstResults = session.createSQLQuery(thisQuery).list();
        return lstResults;
    }

    /**
     * Listing all UserGames that the input user has played.
     *
     * @param user the User object to filter records.
     * @return a list of all the Game IDs that exist inside the table UserGames.
     */
    @SuppressWarnings("unchecked")
    public List<UserGame> listPlayedUserGames(final User user) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(UserGame.class);
        criteria.add(Restrictions.eq("userId", user.getUserId()));
        criteria.addOrder(Order.desc("id"));
        return criteria.list();
    }

    /**
     * Listing all Users played games  for a specific game which not include the given nation.
     *
     * @param user   the User object to filter records.
     * @param game   the Game object to filter records.
     * @param nation the Nation object to filter records.
     * @return a List with the UserGames
     */
    @SuppressWarnings("unchecked")
    public List<UserGame> listPlayedUserGames(final User user, final Game game, final Nation nation) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(UserGame.class);
        criteria.add(Restrictions.eq("userId", user.getUserId()));
        criteria.add(Restrictions.ne("nation", nation));
        criteria.add(Restrictions.eq("game", game));
        criteria.addOrder(Order.desc("id"));
        return criteria.list();
    }
}

