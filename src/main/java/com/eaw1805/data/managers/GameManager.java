package com.eaw1805.data.managers;

import com.eaw1805.data.constants.GameConstants;
import com.eaw1805.data.managers.beans.GameManagerBean;
import com.eaw1805.data.model.Game;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.Calendar;
import java.util.List;

/**
 * CRUD operations for Game objects.
 */
public class GameManager
        extends AbstractManager<Game>
        implements GameManagerBean, GameConstants {

    /**
     * static instance(ourInstance) initialized as null.
     */
    private static GameManagerBean ourInstance = null;

    /**
     * Public constructor .
     */
    public GameManager() {
        // Does nothing
        super();
    }

    /**
     * GameManager is loaded on the first execution of GameManager.getInstance()
     * or the first access to GameManager.ourInstance, not before.
     *
     * @return ourInstance
     */
    public static GameManagerBean getInstance() {
        synchronized (GameManager.class) {
            if (ourInstance == null) {
                ourInstance = new GameManager();
            }
        }

        return ourInstance;
    }

    /**
     * Set the global instance of the manager. Used for the integration with Spring.
     *
     * @param thisInstance the manager bean.
     */
    public static void setInstance(final GameManagerBean thisInstance) {
        ourInstance = thisInstance;
    }

    /**
     * get the Game from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    public Game getByID(final int entityID) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Game.class);
        criteria.add(Restrictions.eq("gameId", entityID));
        return (Game) criteria.uniqueResult();
    }

    /**
     * Delete the input Game from the database.
     *
     * @param game the game tha we want to delete
     */
    public void delete(final Game game) {
        super.delete(game, game.getGameId());
    }

    /**
     * Listing all the Games from the database.
     *
     * @return a list of all the Avatars that exist inside the table Avatar.
     */
    public List<Game> list() {
        return super.list(new com.eaw1805.data.model.Game());
    }

    /**
     * Listing all the Games from the database that are ready to be processed.
     *
     * @return a list of games ready to be processed.
     */
    @SuppressWarnings("unchecked")
    public List<Game> listReady() {
        final Calendar thisCal = Calendar.getInstance();
        thisCal.set(Calendar.HOUR, 0);
        thisCal.set(Calendar.MINUTE, 0);
        thisCal.add(Calendar.DATE, -1);

        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Game.class);
        criteria.add(Restrictions.ge("gameId", 1));
        criteria.add(Restrictions.ne("status", GAME_PROC));
        criteria.add(Restrictions.ne("status", GAME_WAIT));
        criteria.add(Restrictions.ne("status", GAME_POST));
        criteria.add(Restrictions.eq("ended", false));
        criteria.add(Restrictions.or(Restrictions.eq("status", GAME_SCHED),
                Restrictions.and(Restrictions.ge("scenarioId", 1), Restrictions.lt("dateNextProc", thisCal.getTime()))
        ));
        criteria.addOrder(Order.asc("dateNextProc"));

        return criteria.list();
    }

    /**
     * Listing all the Games from the database that will be processed in the next 24 hours.
     *
     * @return a list of games that will be processed in the next 24 hours.
     */
    @SuppressWarnings("unchecked")
    public List<Game> listAlmostReady() {
        final Calendar thisCal = Calendar.getInstance();
        thisCal.add(Calendar.HOUR_OF_DAY, 24);

        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Game.class);
        criteria.add(Restrictions.ge("gameId", 0));
        criteria.add(Restrictions.ge("turn", 1));
        criteria.add(Restrictions.ne("status", GAME_PROC));
        criteria.add(Restrictions.ne("status", GAME_WAIT));
        criteria.add(Restrictions.ne("status", GAME_POST));
        criteria.add(Restrictions.eq("ended", false));
        criteria.add(Restrictions.or(Restrictions.eq("status", GAME_SCHED), Restrictions.lt("dateNextProc", thisCal.getTime())));
        criteria.addOrder(Order.asc("dateNextProc"));

        return criteria.list();
    }


    /**
     * Listing all the Games that are being processed.
     *
     * @return a list of games that are being processed.
     */
    @SuppressWarnings("unchecked")
    public List<Game> listProcessed() {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Game.class);
        criteria.add(Restrictions.ge("gameId", 0));
        criteria.add(Restrictions.eq("status", GAME_PROC));
        return criteria.list();
    }

    public List<Game> listUnderConstruction() {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Game.class);
        criteria.add(Restrictions.ge("gameId", 0));
        criteria.add(Restrictions.eq("status", GAME_CREATE));
        return criteria.list();
    }

    /**
     * Inserts an entry to the database with ID = -1.
     *
     * @param scenarioId the Identity of the scenario.
     */
    public void addNegativeGameID(final int scenarioId) {
        final Session session = getSessionFactory().getCurrentSession();
        session.createSQLQuery("INSERT INTO GAMES(GAME_ID, scenarioId, turn, dateStart, dateLastProc, dateNextProc, status, schedule, ended, winners, discount, forum_id, description) VALUES(-1, " + scenarioId + ", 0, NOW(), NOW(), NOW(), \"\", 0, 0, \"\", 0, 0, 'Scenario Game');").executeUpdate();
    }

    /**
     * Listing all the New Games from the database.
     *
     * @return a list of new games .
     */
    @SuppressWarnings("unchecked")
    public List<Game> listNewGames() {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Game.class);
        criteria.add(Restrictions.ge("gameId", 0));
        criteria.add(Restrictions.eq("turn", 0));
        return criteria.list();
    }

    /**
     * Delete all records associated to a specific game.
     *
     * @param gameId the Identity of the game to delete.
     */
    public void deleteGame(final int gameId) {
        final Session session = getSessionFactory().getCurrentSession();

        session.createSQLQuery("DELETE FROM BATTLES_FIELD WHERE GAME_ID = " + gameId + ";").executeUpdate();
        session.createSQLQuery("DELETE FROM BATTLES_TACTICAL_SIDE1 WHERE BATTLES_TACTICAL_SIDE1.BATTLE_ID IN (SELECT BATTLE_ID FROM BATTLES_TACTICAL WHERE GAME_ID = " + gameId + ");").executeUpdate();
        session.createSQLQuery("DELETE FROM BATTLES_TACTICAL_SIDE2 WHERE BATTLES_TACTICAL_SIDE2.BATTLE_ID IN (SELECT BATTLE_ID FROM BATTLES_TACTICAL WHERE GAME_ID = " + gameId + ");").executeUpdate();
        session.createSQLQuery("DELETE FROM BATTLES_TACTICAL WHERE GAME_ID = " + gameId + ";").executeUpdate();
        session.createSQLQuery("DELETE FROM BATTLES_NAVAL_SIDE1 WHERE BATTLES_NAVAL_SIDE1.BATTLE_ID IN (SELECT BATTLE_ID FROM BATTLES_NAVAL WHERE GAME_ID = " + gameId + ");").executeUpdate();
        session.createSQLQuery("DELETE FROM BATTLES_NAVAL_SIDE2 WHERE BATTLES_NAVAL_SIDE2.BATTLE_ID IN (SELECT BATTLE_ID FROM BATTLES_NAVAL WHERE GAME_ID = " + gameId + ");").executeUpdate();
        session.createSQLQuery("DELETE FROM BATTLES_NAVAL WHERE GAME_ID = " + gameId + ";").executeUpdate();
        session.createSQLQuery("DELETE FROM ORDERS_GOODS WHERE ORDERS_GOODS.ORDER_ID IN (SELECT ORDER_ID FROM ORDERS WHERE GAME_ID = " + gameId + ");").executeUpdate();
        session.createSQLQuery("DELETE FROM ORDERS WHERE GAME_ID = " + gameId + ";").executeUpdate();
        session.createSQLQuery("DELETE FROM TRADECITIES_GOODS WHERE TRADECITIES_GOODS.CITY_ID IN (SELECT CITY_ID FROM TRADECITIES WHERE GAME_ID = " + gameId + ");").executeUpdate();
        session.createSQLQuery("DELETE FROM TRADECITIES WHERE GAME_ID = " + gameId + ";").executeUpdate();
        session.createSQLQuery("DELETE FROM WAREHOUSE_GOODS WHERE WAREHOUSE_GOODS.WAREHOUSE_ID IN (SELECT WAREHOUSE_ID FROM WAREHOUSES WHERE GAME_ID = " + gameId + ");").executeUpdate();
        session.createSQLQuery("DELETE FROM WAREHOUSES WHERE GAME_ID = " + gameId + ";").executeUpdate();
        session.createSQLQuery("DELETE FROM BAGGAGETRAINS_GOODS WHERE BAGGAGETRAINS_GOODS.BAGGAGETRAIN_ID IN (SELECT BAGGAGETRAIN_ID FROM BAGGAGETRAINS WHERE GAME_ID = " + gameId + ");").executeUpdate();
        session.createSQLQuery("DELETE FROM BAGGAGETRAINS WHERE GAME_ID = " + gameId + ";").executeUpdate();
        session.createSQLQuery("DELETE FROM BARRACKS WHERE GAME_ID = " + gameId + ";").executeUpdate();
        session.createSQLQuery("DELETE FROM BATTALIONS WHERE BATTALIONS.BRIGADE_ID IN (SELECT BRIGADE_ID FROM BRIGADES WHERE GAME_ID = " + gameId + ");").executeUpdate();
        session.createSQLQuery("DELETE FROM BRIGADES WHERE GAME_ID = " + gameId + ";").executeUpdate();
        session.createSQLQuery("DELETE FROM CORPS WHERE GAME_ID = " + gameId + ";").executeUpdate();
        session.createSQLQuery("DELETE FROM ARMIES WHERE GAME_ID = " + gameId + ";").executeUpdate();
        session.createSQLQuery("DELETE FROM COMMANDERS WHERE GAME_ID = " + gameId + ";").executeUpdate();
        session.createSQLQuery("DELETE FROM SHIPS_GOODS WHERE SHIPS_GOODS.SHIP_ID IN (SELECT SHIP_ID FROM SHIPS WHERE GAME_ID = " + gameId + ");").executeUpdate();
        session.createSQLQuery("DELETE FROM SHIPS WHERE GAME_ID = " + gameId + ";").executeUpdate();
        session.createSQLQuery("DELETE FROM FLEETS WHERE GAME_ID = " + gameId + ";").executeUpdate();
        session.createSQLQuery("DELETE FROM SPIES WHERE GAME_ID = " + gameId + ";").executeUpdate();
        session.createSQLQuery("DELETE FROM SECTORS WHERE GAME_ID = " + gameId + ";").executeUpdate();
        session.createSQLQuery("DELETE FROM REPORTS WHERE GAME_ID = " + gameId + ";").executeUpdate();
        session.createSQLQuery("DELETE FROM RELATIONS WHERE GAME_ID = " + gameId + ";").executeUpdate();
        session.createSQLQuery("DELETE FROM NEWS WHERE GAME_ID = " + gameId + ";").executeUpdate();
        session.createSQLQuery("DELETE FROM WATCH_GAMES WHERE GAME_ID = " + gameId + ";").executeUpdate();
        session.createSQLQuery("DELETE FROM USERS_GAMES WHERE GAME_ID = " + gameId + ";").executeUpdate();
        session.createSQLQuery("DELETE FROM GAME_SETTINGS WHERE GAME_ID = " + gameId + ";").executeUpdate();
        session.createSQLQuery("DELETE FROM GAMES WHERE GAME_ID = " + gameId + ";").executeUpdate();
    }

    /**
     * Retrieve the last inserted game.
     *
     * @return The last inserted game.
     */
    public List<Game> getLastGame() {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Game.class);
        criteria.add(Restrictions.ge("gameId", 0));
        criteria.add(Restrictions.eq("turn", 0));
        criteria.addOrder(Order.desc("gameId"));
        return criteria.setMaxResults(1).list();
    }

    /**
     * List all games owned by a specific user.
     *
     * @param userId The user to lists the games.
     * @return A list of games.
     */
    public List<Game> listByOwner(final int userId) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Game.class);
        criteria.add(Restrictions.ge("gameId", 0));
        criteria.add(Restrictions.eq("userId", userId));
        criteria.addOrder(Order.desc("gameId"));
        return criteria.list();
    }

    /**
     * List all games not owned by a specific user.
     *
     * @param userId The user to lists the games.
     * @return A list of games.
     */
    public List<Game> listByNotOwner(final int userId) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Game.class);
        criteria.add(Restrictions.ge("gameId", 0));
        criteria.add(Restrictions.ne("userId", userId));
        criteria.addOrder(Order.desc("gameId"));
        return criteria.list();
    }
}
