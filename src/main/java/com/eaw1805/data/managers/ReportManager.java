package com.eaw1805.data.managers;

import com.eaw1805.data.managers.beans.ReportManagerBean;
import com.eaw1805.data.model.Game;
import com.eaw1805.data.model.Nation;
import com.eaw1805.data.model.Report;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * CRUD operations for Report objects.
 */
public class ReportManager
        extends AbstractManager<Report>
        implements ReportManagerBean {

    /**
     * static instance(ourInstance) initialized as null.
     */
    private static ReportManagerBean ourInstance = null;

    /**
     * Private constructor suppresses generation of a (public)
     * default constructor.
     */
    public ReportManager() {
        // Does nothing
        super();
    }

    /**
     * ReportManager is loaded on the first execution of
     * ReportManager.getInstance() or the first access to
     * ReportManager.ourInstance, not before.
     *
     * @return ourInstance
     */
    public static ReportManagerBean getInstance() {
        synchronized (ReportManager.class) {
            if (ourInstance == null) {
                ourInstance = new ReportManager();
            }
        }

        return ourInstance;
    }

    /**
     * Set the global instance of the manager. Used for the integration with Spring.
     *
     * @param thisInstance the manager bean.
     */
    public static void setInstance(final ReportManagerBean thisInstance) {
        ourInstance = thisInstance;
    }

    /**
     * get the Report from the database that corresponds to the input id.
     *
     * @param entityID the id of the Report object.
     * @return an Report object.
     */
    public Report getByID(final int entityID) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Report.class);
        criteria.add(Restrictions.eq("id", entityID));
        return (Report) criteria.uniqueResult();
    }

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
    public Report getByOwnerTurnKey(final Nation owner, final Game game, final int turn, final String key) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Report.class);
        criteria.add(Restrictions.eq("nation", owner));
        criteria.add(Restrictions.eq("game", game));
        criteria.add(Restrictions.eq("turn", turn));
        criteria.add(Restrictions.eq("key", key));

        List<Report> results = criteria.list();

        if (results == null || results.isEmpty()) {
            return null;
        }

        return results.get(0);
    }

    /**
     * Delete the input report from the database.
     *
     * @param report the report tha we want to delete
     */
    public void delete(final Report report) {
        super.delete(report, report.getId());
    }

    /**
     * Listing all the Reports from the database.
     *
     * @return a list of all the Reports.
     */
    public List<Report> list() {
        return super.list(new Report());
    }

    /**
     * List al the Report from the database that corresponds to the input
     * parameters.
     *
     * @param owner the Owner of the Report object.
     * @param game  the Game of the Report object.
     * @param key   the Key of the Report object.
     * @return an Entity object.
     */
    @SuppressWarnings("unchecked")
    public List<Report> listByOwnerKey(final Nation owner, final Game game, final String key) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Report.class);
        criteria.add(Restrictions.eq("nation", owner));
        criteria.add(Restrictions.eq("game", game));
        criteria.add(Restrictions.eq("key", key));
        criteria.addOrder(Order.asc("turn"));

        return criteria.list();
    }

    /**
     * List al the Report from the database that corresponds to the input
     * parameters.
     *
     * @param owner the Owner of the Report object.
     * @param game  the Game of the Report object.
     * @param turn  the Turn of the Report object.
     * @param key   the Key of the Report object.
     * @return an Entity object.
     */
    @SuppressWarnings("unchecked")
    public List<Report> listByOwnerTurnKey(final Nation owner, final Game game, final int turn, final String key) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Report.class);
        criteria.add(Restrictions.eq("nation", owner));
        criteria.add(Restrictions.eq("game", game));
        criteria.add(Restrictions.eq("turn", turn));
        criteria.add(Restrictions.like("key", key));
        criteria.addOrder(Order.asc("key"));

        return criteria.list();
    }

    /**
     * List al the Report from the database that corresponds to the input
     * parameters.
     *
     * @param game the Game of the Report object.
     * @param turn the Turn of the Report object.
     * @param key  the Key of the Report object.
     * @return an Entity object.
     */
    @SuppressWarnings("unchecked")
    public List<Report> listByTurnKey(final Game game, final int turn, final String key) {
        final Session session = getSessionFactory().getCurrentSession();
        final String thisQuery = "SELECT REPORT_ID " +
                "FROM `REPORTS` " +
                "WHERE GAME_ID = " + game.getGameId() +
                " AND turn = " + turn +
                " AND REPORT_KEY LIKE '" + key + "%'";

        final List<Object> lstResults = session.createSQLQuery(thisQuery).list();

        // construct map
        final List<Report> theMap = new ArrayList<Report>();

        // Iterate through results and populate map
        for (Object lstResult : lstResults) {
            theMap.add((Report) session.get(Report.class, (Integer) lstResult));
        }

        return theMap;
    }

    /**
     * List al the Report from the database that corresponds to the input
     * parameters.
     *
     * @param game the Game of the Report object.
     * @param turn the Turn of the Report object.
     * @param key  the Key of the Report object.
     * @return an Entity object.
     */
    @SuppressWarnings("unchecked")
    public List<Report> listByTurnKeyFixed(final Game game, final int turn, final String key) {
        final Session session = getSessionFactory().getCurrentSession();
        final String thisQuery = "SELECT REPORT_ID " +
                "FROM `REPORTS` " +
                "WHERE GAME_ID = " + game.getGameId() +
                " AND turn = " + turn +
                " AND REPORT_KEY LIKE '" + key + "'";

        final List<Object> lstResults = session.createSQLQuery(thisQuery).list();

        // construct map
        final List<Report> theMap = new ArrayList<Report>();

        // Iterate through results and populate map
        for (Object lstResult : lstResults) {
            theMap.add((Report) session.get(Report.class, (Integer) lstResult));
        }

        return theMap;
    }

    /**
     * List al the Report from the database that corresponds to the input
     * parameters.
     *
     * @param game the Game of the Report object.
     * @param key  the Key of the Report object.
     * @return an Entity object.
     */
    @SuppressWarnings("unchecked")
    public List<Report> listByKey(final Game game, final String key) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Report.class);
        criteria.add(Restrictions.eq("game", game));
        criteria.add(Restrictions.like("key", key));
        criteria.addOrder(Order.asc("nation"));
        criteria.addOrder(Order.asc("key"));

        return criteria.list();
    }

    /**
     * Rank reports for Hall of Fame purposes for particular game and turn.
     *
     * @param key      the key to use for sorting the nations.
     * @param thisGame the game to inspect.
     * @param thisTurn the turn to inspect.
     * @return a list of nations ordered by the the value.
     */
    @SuppressWarnings("unchecked")
    public List<Nation> rankNations(final String key, final Game thisGame, final int thisTurn) {
        final Session session = getSessionFactory().getCurrentSession();
        final String thisQuery = "SELECT NATION_ID " +
                "FROM `REPORTS` " +
                "WHERE GAME_ID = " + thisGame.getGameId() +
                " AND turn = " + thisTurn +
                " AND REPORT_KEY LIKE '" + key + "%'" +
                " AND NATION_ID > 0" +
                " GROUP BY NATION_ID " +
                " ORDER BY SUM(CAST( REPORT_VALUE AS DECIMAL )) DESC";

        final List<Object> lstResults = session.createSQLQuery(thisQuery).list();

        // construct map
        final List<Nation> theMap = new ArrayList<Nation>();

        // Iterate through results and populate map
        for (Object lstResult : lstResults) {
            theMap.add((Nation) session.get(Nation.class, (Integer) lstResult));
        }

        return theMap;
    }

    /**
     * Rank reports for Hall of Fame purposes for particular game and turn.
     *
     * @param key      the key to use for sorting the nations.
     * @param thisGame the game to inspect.
     * @param thisTurn the turn to inspect.
     * @param limit    the number of entries to retrieve.
     * @return a list of nations ordered by the the value.
     */
    @SuppressWarnings("unchecked")
    public List<Nation> rankNations(final String key, final Game thisGame, final int thisTurn, final int limit) {
        final Session session = getSessionFactory().getCurrentSession();
        final String thisQuery = "SELECT NATION_ID " +
                "FROM `REPORTS` " +
                "WHERE GAME_ID = " + thisGame.getGameId() +
                " AND turn = " + thisTurn +
                " AND REPORT_KEY LIKE '" + key + "%'" +
                " AND NATION_ID > 0" +
                " GROUP BY NATION_ID " +
                " ORDER BY SUM(CAST( REPORT_VALUE AS DECIMAL )) DESC " +
                " LIMIT 0, " + limit;

        final List<Object> lstResults = session.createSQLQuery(thisQuery).list();

        // construct map
        final List<Nation> theMap = new ArrayList<Nation>();

        // Iterate through results and populate map
        for (Object lstResult : lstResults) {
            theMap.add((Nation) session.get(Nation.class, (Integer) lstResult));
        }

        return theMap;
    }

    /**
     * Rank reports for Hall of Fame purposes for particular game and turn.
     *
     * @param key      the key to use for sorting the nations.
     * @param thisGame the game to inspect.
     * @param thisTurn the turn to inspect.
     * @param limit    the number of entries to retrieve.
     * @return a list of nations ordered by the the value.
     */
    @SuppressWarnings("unchecked")
    public List<Nation> rankNationsFixed(final String key, final Game thisGame, final int thisTurn, final int limit) {
        final Session session = getSessionFactory().getCurrentSession();
        final String thisQuery = "SELECT NATION_ID " +
                "FROM `REPORTS` " +
                "WHERE GAME_ID = " + thisGame.getGameId() +
                " AND turn = " + thisTurn +
                " AND REPORT_KEY LIKE '" + key + "'" +
                " AND NATION_ID > 0" +
                " GROUP BY NATION_ID " +
                " ORDER BY SUM(CAST( REPORT_VALUE AS DECIMAL )) DESC " +
                " LIMIT 0, " + limit;

        final List<Object> lstResults = session.createSQLQuery(thisQuery).list();

        // construct map
        final List<Nation> theMap = new ArrayList<Nation>();

        // Iterate through results and populate map
        for (Object lstResult : lstResults) {
            theMap.add((Nation) session.get(Nation.class, (Integer) lstResult));
        }

        return theMap;
    }

}
