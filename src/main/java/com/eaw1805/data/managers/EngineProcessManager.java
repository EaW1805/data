package com.eaw1805.data.managers;

import com.eaw1805.data.managers.beans.EngineProcessManagerBean;
import com.eaw1805.data.model.EngineProcess;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.math.BigInteger;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * CRUD operations for EngineProcess objects.
 */
public class EngineProcessManager
        extends AbstractManager<EngineProcess>
        implements EngineProcessManagerBean {

    /**
     * static instance(ourInstance) initialized as null.
     */
    private static EngineProcessManager ourInstance = null;

    /**
     * Public constructor .
     */
    public EngineProcessManager() {
        // Does nothing
        super();
    }

    /**
     * GameManager is loaded on the first execution of GameManager.getInstance()
     * or the first access to GameManager.ourInstance, not before.
     *
     * @return ourInstance
     */
    public static EngineProcessManager getInstance() {
        synchronized (EngineProcessManager.class) {
            if (ourInstance == null) {
                ourInstance = new EngineProcessManager();
            }
        }

        return ourInstance;
    }

    /**
     * Set the global instance of the manager. Used for the integration with Spring.
     *
     * @param thisInstance the manager bean.
     */
    public static void setInstance(final EngineProcessManager thisInstance) {
        ourInstance = thisInstance;
    }

    /**
     * get the Game from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    public EngineProcess getByID(final int entityID) {
        return super.getByID(new com.eaw1805.data.model.EngineProcess(), entityID);
    }

    /**
     * Delete the input Game from the database.
     *
     * @param game the game tha we want to delete
     */
    public void delete(final EngineProcess game) {
        super.delete(game, game.getProcId());
    }

    /**
     * Listing all the Games from the database.
     *
     * @return a list of all the Avatars that exist inside the table Avatar.
     */
    public List<EngineProcess> list() {
        return super.list(new com.eaw1805.data.model.EngineProcess());
    }

    /**
     * Listing all the processes for a particular Game from the database that are ready to be processed.
     *
     * @param gameId     the game ID to look up.
     * @param scenarioID the scenario ID to look up.
     * @return a list of processes related to the particular game.
     */
    @SuppressWarnings("unchecked")
    public List<EngineProcess> listGame(final int gameId, final int scenarioID) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(EngineProcess.class);
        criteria.add(Restrictions.eq("gameId", gameId));
        criteria.add(Restrictions.eq("scenarioId", scenarioID));
        criteria.addOrder(Order.asc("procId"));

        return criteria.list();
    }

    /**
     * Listing all the processes for a particular Game from the database that are ready to be processed
     * within the ongoing week.
     *
     * @param gameId     the game ID to look up.
     * @param scenarioID the scenario ID to look up.
     * @return a list of processes related to the particular game.
     */
    @SuppressWarnings("unchecked")
    public List<EngineProcess> listGameWeekly(final int gameId, final int scenarioID) {
        // Find first day of week
        final Calendar thisCal = Calendar.getInstance();
        thisCal.add(Calendar.DATE, -thisCal.get(Calendar.DAY_OF_WEEK));
        thisCal.set(Calendar.HOUR, 0);
        thisCal.set(Calendar.MINUTE, 0);

        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(EngineProcess.class);
        criteria.add(Restrictions.eq("gameId", gameId));
        criteria.add(Restrictions.eq("scenarioId", scenarioID));
        criteria.add(Restrictions.ge("dateStart", thisCal.getTime()));
        criteria.addOrder(Order.asc("procId"));

        return criteria.list();
    }

    /**
     * get the latest EngineProcess from the database that corresponds to the input id.
     *
     * @param gameId     the game ID to look up.
     * @param scenarioID the scenario ID to look up.
     * @return an Entity object.
     */
    public EngineProcess getLatest(final int gameId, final int scenarioID) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(EngineProcess.class);
        criteria.add(Restrictions.eq("gameId", gameId));
        criteria.add(Restrictions.eq("scenarioId", scenarioID));
        criteria.addOrder(Order.desc("procId"));
        criteria.setMaxResults(1);

        final List<EngineProcess> results = criteria.list();
        if (results.isEmpty()) {
            return null;
        }
        return results.get(0);
    }

    /**
     * Inserts an entry to the database with ID = -1.
     */
    public void addNegativeProcID() {
        final Session session = getSessionFactory().getCurrentSession();
        session.createSQLQuery("INSERT INTO ENGINE(PROC_ID, GAME_ID, scenarioId, turn, dateStart, duration, processName) VALUES(-1, -1, 0, 0, NOW(), 0, \"\");").executeUpdate();
    }

    /**
     * Update the entry of the database with ID = -1.
     */
    public void updateNegativeProcID() {
        final Session session = getSessionFactory().getCurrentSession();
        session.createSQLQuery("UPDATE ENGINE set dateStart=NOW() WHERE PROC_ID=-1;").executeUpdate();
    }

    /**
     * Count the number of processes per each week of the year.
     *
     * @return a mapping of engine processing count to years/weeks.
     */
    @SuppressWarnings("unchecked")
    public Map<Integer, Map<Integer, Long>> countByWeek() {
        final Session session = getSessionFactory().getCurrentSession();
        final String thisQuery = "SELECT year( dateStart ) , week( dateStart ) , count( * ) " +
                "FROM `ENGINE` " +
                "GROUP BY year( dateStart ) , week( dateStart )";

        final List<Object[]> lstResults = session.createSQLQuery(thisQuery).list();

        // construct map
        final Map<Integer, Map<Integer, Long>> theMap = new TreeMap<Integer, Map<Integer, Long>>();

        // Iterate through results and populate map
        for (Object[] lstResult : lstResults) {
            final int year = (Integer) lstResult[0];
            final int week = (Integer) lstResult[1];
            final long users = ((BigInteger) lstResult[2]).longValue();
            final Map<Integer, Long> yearMap;
            if (!theMap.containsKey(year)) {
                yearMap = new TreeMap<Integer, Long>();
                theMap.put(year, yearMap);

            } else {
                yearMap = theMap.get(year);
            }

            yearMap.put(week, users);
        }

        return theMap;
    }

    /**
     * Count the number of orders issued per each week of the year.
     *
     * @return a mapping of orders count to years/weeks.
     */
    @SuppressWarnings("unchecked")
    public Map<Integer, Map<Integer, Long>> countByWeek(final int scenarioId) {
        final Session session = getSessionFactory().getCurrentSession();
        final String thisQuery = "SELECT year( dateStart ) , week( dateStart ) , count( * ) " +
                "FROM `ENGINE` AS engine, " +
                "`empire-s" + scenarioId + "`.ORDERS AS orders " +
                "WHERE engine.scenarioID = " + scenarioId + " " +
                "AND engine.GAME_ID = orders.GAME_ID " +
                "AND engine.turn = orders.turn " +
                "GROUP BY year( dateStart ) , week( dateStart )";

        final List<Object[]> lstResults = session.createSQLQuery(thisQuery).list();

        // construct map
        final Map<Integer, Map<Integer, Long>> theMap = new TreeMap<Integer, Map<Integer, Long>>();

        // Iterate through results and populate map
        for (Object[] lstResult : lstResults) {
            final int year = (Integer) lstResult[0];
            final int week = (Integer) lstResult[1];
            final long users = ((BigInteger) lstResult[2]).longValue();
            final Map<Integer, Long> yearMap;
            if (!theMap.containsKey(year)) {
                yearMap = new TreeMap<Integer, Long>();
                theMap.put(year, yearMap);

            } else {
                yearMap = theMap.get(year);
            }

            yearMap.put(week, users);
        }

        return theMap;
    }

}
