package com.eaw1805.data.managers.battles;

import com.eaw1805.data.managers.AbstractManager;
import com.eaw1805.data.managers.beans.NavalBattleReportManagerBean;
import com.eaw1805.data.model.Game;
import com.eaw1805.data.model.Nation;
import com.eaw1805.data.model.battles.NavalBattleReport;
import com.eaw1805.data.model.fleet.comparators.NavalBattleOrder;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * CRUD operations for NavalBattleReport objects.
 */
public class NavalBattleReportManager
        extends AbstractManager<NavalBattleReport>
        implements NavalBattleReportManagerBean {

    /**
     * static instance(ourInstance) initialized as null.
     */
    private static NavalBattleReportManagerBean ourInstance = null;

    /**
     * Public constructor .
     */
    public NavalBattleReportManager() {
        // Does nothing
        super();
    }

    /**
     * GameManager is loaded on the first execution of NavalBattleReportManager.getInstance()
     * or the first access to NavalBattleReportManager.ourInstance, not before.
     *
     * @return ourInstance
     */
    public static NavalBattleReportManagerBean getInstance() {
        synchronized (NavalBattleReportManager.class) {
            if (ourInstance == null) {
                ourInstance = new NavalBattleReportManager();
            }
        }

        return ourInstance;
    }

    /**
     * Set the global instance of the manager. Used for the integration with Spring.
     *
     * @param thisInstance the manager bean.
     */
    public static void setInstance(final NavalBattleReportManagerBean thisInstance) {
        ourInstance = thisInstance;
    }

    /**
     * get the NavalBattleReport from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    public NavalBattleReport getByID(final int entityID) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(NavalBattleReport.class);
        criteria.add(Restrictions.eq("battleId", entityID));
        return (NavalBattleReport)criteria.uniqueResult();
    }

    /**
     * Delete the input NavalBattleReport entry from the database.
     *
     * @param entry the NavalBattleReport entry tha we want to delete.
     */
    public void delete(final NavalBattleReport entry) {
        super.delete(entry, entry.getBattleId());
    }

    /**
     * Listing all NavalBattleReport from the database.
     *
     * @return a list of all the NavalBattleReport entries that exist inside the table NavalBattleReport.
     */
    public List<NavalBattleReport> list() {
        return super.list(new NavalBattleReport());
    }

    @SuppressWarnings("unchecked")
    public List<NavalBattleReport> listGame(final Game thisGame) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(NavalBattleReport.class);
        criteria.add(Restrictions.eq("position.game", thisGame));
        criteria.addOrder(Order.asc("position.region"));
        criteria.addOrder(Order.asc("position.y"));
        criteria.addOrder(Order.asc("position.x"));
        criteria.addOrder(Order.asc("battleId"));
        return criteria.list();
    }

    /**
     * Listing all NavalBattleReport from the database owned by the specific nation.
     *
     * @param thisGame the game to select.
     * @param nation   the nation to select.
     * @return a list of all the Armies.
     */
    @SuppressWarnings("unchecked")
    public List<NavalBattleReport> listGameNation(final Game thisGame, final Nation nation) {
        final Session session = getSessionFactory().getCurrentSession();
        final List<NavalBattleReport> list = new ArrayList<NavalBattleReport>();

        final Criteria criteria1 = session.createCriteria(NavalBattleReport.class);
        criteria1.add(Restrictions.eq("position.game", thisGame));
        criteria1.createCriteria("side1").add(Restrictions.eq("id", nation.getId()));
        criteria1.addOrder(Order.desc("turn"));
        criteria1.addOrder(Order.asc("position.region"));
        criteria1.addOrder(Order.asc("position.y"));
        criteria1.addOrder(Order.asc("position.x"));
        criteria1.addOrder(Order.asc("battleId"));
        for (final NavalBattleReport report : (List<NavalBattleReport>) criteria1.list()) {
            list.add(report);
        }

        final Criteria criteria2 = session.createCriteria(NavalBattleReport.class);
        criteria2.add(Restrictions.eq("position.game", thisGame));
        criteria2.createCriteria("side2").add(Restrictions.eq("id", nation.getId()));
        criteria2.addOrder(Order.desc("turn"));
        criteria2.addOrder(Order.asc("position.region"));
        criteria2.addOrder(Order.asc("position.y"));
        criteria2.addOrder(Order.asc("position.x"));
        criteria2.addOrder(Order.asc("battleId"));
        for (final NavalBattleReport report : (List<NavalBattleReport>) criteria2.list()) {
            list.add(report);
        }

        java.util.Collections.sort(list, new NavalBattleOrder());
        return list;
    }

    @SuppressWarnings("unchecked")
    public List<NavalBattleReport> listGameNationTurn(final Game thisGame, final Nation nation, final int turn) {
        final Session session = getSessionFactory().getCurrentSession();
        final List<NavalBattleReport> list = new ArrayList<NavalBattleReport>();

        final Criteria criteria1 = session.createCriteria(NavalBattleReport.class);
        criteria1.add(Restrictions.eq("position.game", thisGame));
        criteria1.createCriteria("side1").add(Restrictions.eq("id", nation.getId()));
        criteria1.add(Restrictions.eq("turn", turn));
        criteria1.addOrder(Order.asc("position.region"));
        criteria1.addOrder(Order.asc("position.y"));
        criteria1.addOrder(Order.asc("position.x"));
        criteria1.addOrder(Order.asc("battleId"));
        for (final NavalBattleReport report : (List<NavalBattleReport>) criteria1.list()) {
            list.add(report);
        }

        final Criteria criteria2 = session.createCriteria(NavalBattleReport.class);
        criteria2.add(Restrictions.eq("position.game", thisGame));
        criteria2.createCriteria("side2").add(Restrictions.eq("id", nation.getId()));
        criteria2.add(Restrictions.eq("turn", turn));
        criteria2.addOrder(Order.asc("position.region"));
        criteria2.addOrder(Order.asc("position.y"));
        criteria2.addOrder(Order.asc("position.x"));
        criteria2.addOrder(Order.asc("battleId"));
        for (final NavalBattleReport report : (List<NavalBattleReport>) criteria2.list()) {
            list.add(report);
        }

        return list;
    }

    /**
     * Count the number of reports issued.
     *
     * @return reports counts.
     */
    @SuppressWarnings("unchecked")
    public Object countReportsPerGame(final int gameId) {
        final Session session = getSessionFactory().getCurrentSession();
        final String thisQuery = "SELECT count(*) " +
                "FROM `BATTLES_NAVAL` WHERE GAME_ID=" + gameId +
                " GROUP BY GAME_ID";

        return session.createSQLQuery(thisQuery).uniqueResult();
    }

}

