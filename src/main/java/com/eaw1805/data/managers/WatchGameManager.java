package com.eaw1805.data.managers;

import com.eaw1805.data.managers.beans.WatchGameManagerBean;
import com.eaw1805.data.model.Game;
import com.eaw1805.data.model.User;
import com.eaw1805.data.model.WatchGame;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * CRUD operations for WatchGame objects.
 */
public class WatchGameManager extends AbstractManager<WatchGame>
        implements WatchGameManagerBean {
    /**
     * static instance(ourInstance) initialized as null.
     */
    private static WatchGameManagerBean ourInstance = null;

    /**
     * Private constructor suppresses generation of a (public) default constructor.
     */
    public WatchGameManager() {
        // Does nothing
        super();
    }

    /**
     * WatchGameManager is loaded on the first execution of WatchGameManager.getInstance()
     * or the first access to WatchGameManager.ourInstance, not before.
     *
     * @return ourInstance
     */
    public static WatchGameManagerBean getInstance() {
        synchronized (WatchGameManager.class) {
            if (ourInstance == null) {
                ourInstance = new WatchGameManager();
            }
        }

        return ourInstance;
    }

    /**
     * Set the global instance of the manager. Used for the integration with Spring.
     *
     * @param thisInstance the manager bean.
     */
    public static void setInstance(final WatchGameManagerBean thisInstance) {
        ourInstance = thisInstance;
    }

    /**
     * get the WatchGame from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    public WatchGame getByID(final int entityID) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(WatchGame.class);
        criteria.add(Restrictions.eq("watchGameId", entityID));
        return (WatchGame)criteria.uniqueResult();

    }

    /**
     * Delete the input WatchGame from the database.
     *
     * @param watchGame the user tha we want to delete
     */
    public void delete(final WatchGame watchGame) {
        super.delete(watchGame, watchGame.getWatchGameId());
    }

    /**
     * Listing all the WatchGame from the database.
     *
     * @return a list of all the Avatars that exist inside the table Users.
     */
    public List<WatchGame> list() {
        return super.list(new WatchGame());
    }

    /**
     * Listing all WatchGame objects from the database that the user watches.
     *
     * @param user the user to search the watchGame objects.
     * @return a list WatchGame objects for the corresponding user.
     */
    @SuppressWarnings("unchecked")
    public List<WatchGame> listByUser(final User user) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(WatchGame.class);
        criteria.add(Restrictions.eq("userId", user.getUserId()));
        criteria.addOrder(Order.asc("game"));
        return criteria.list();
    }

    /**
     * Listing all WatchGame objects from the database for the current game.
     *
     * @param game the game to search the watchGame objects.
     * @return a list WatchGame objects for the corresponding game.
     */
    @SuppressWarnings("unchecked")
    public List<WatchGame> listByGame(final Game game) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(WatchGame.class);
        criteria.add(Restrictions.eq("game", game));
        criteria.addOrder(Order.asc("userId"));
        return criteria.list();
    }

    /**
     * Listing all WatchGame objects from the database for the current user and game.
     *
     * @param user the user to search the watchGame objects.
     * @param game the game to search the watchGame objects.
     * @return a list WatchGame objects for the corresponding game.
     */
    @SuppressWarnings("unchecked")
    public List<WatchGame> listByUserGame(final User user, final Game game) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(WatchGame.class);
        criteria.add(Restrictions.eq("userId", user.getUserId()));
        criteria.add(Restrictions.eq("game", game));
        return criteria.list();
    }

    public void delete(final User user) {
        final Session session = getSessionFactory().getCurrentSession();
        final String thisQuery = "DELETE " +
                "FROM `WATCH_GAMES` WHERE USER_ID=" + user.getUserId();

        session.createSQLQuery(thisQuery).executeUpdate();
    }

}
