package com.eaw1805.data.managers.battles;

import com.eaw1805.data.managers.AbstractManager;
import com.eaw1805.data.managers.beans.TacticalBattleReportManagerBean;
import com.eaw1805.data.model.Game;
import com.eaw1805.data.model.Nation;
import com.eaw1805.data.model.army.comparators.TacticalBattleOrder;
import com.eaw1805.data.model.battles.TacticalBattleReport;
import com.eaw1805.data.model.map.Position;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * CRUD operations for TacticalBattleReport objects.
 */
public class TacticalBattleReportManager
        extends AbstractManager<TacticalBattleReport>
        implements TacticalBattleReportManagerBean {

    /**
     * static instance(ourInstance) initialized as null.
     */
    private static TacticalBattleReportManagerBean ourInstance = null;

    /**
     * Public constructor .
     */
    public TacticalBattleReportManager() {
        // Does nothing
        super();
    }

    /**
     * GameManager is loaded on the first execution of TacticalBattleReportManager.getInstance()
     * or the first access to TacticalBattleReportManager.ourInstance, not before.
     *
     * @return ourInstance
     */
    public static TacticalBattleReportManagerBean getInstance() {
        synchronized (TacticalBattleReportManager.class) {
            if (ourInstance == null) {
                ourInstance = new TacticalBattleReportManager();
            }
        }

        return ourInstance;
    }

    /**
     * Set the global instance of the manager. Used for the integration with Spring.
     *
     * @param thisInstance the manager bean.
     */
    public static void setInstance(final TacticalBattleReportManagerBean thisInstance) {
        ourInstance = thisInstance;
    }

    /**
     * get the TacticalBattleReport from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    public TacticalBattleReport getByID(final int entityID) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(TacticalBattleReport.class);
        criteria.add(Restrictions.eq("battleId", entityID));
        return (TacticalBattleReport) criteria.uniqueResult();
    }

    /**
     * get the TacticalBattleReport from the database that corresponds to the input id.
     *
     * @param position the Position of the battle.
     * @param turn     the turn the battle was conducted.
     * @return an Entity object.
     */
    public TacticalBattleReport getByPositionTurn(final Position position, final int turn) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(TacticalBattleReport.class);
        criteria.add(Restrictions.eq("position", position));
        criteria.add(Restrictions.eq("turn", turn));
        return (TacticalBattleReport) criteria.uniqueResult();
    }

    /**
     * Delete the input TacticalBattleReport entry from the database.
     *
     * @param entry the TacticalBattleReport entry tha we want to delete.
     */
    public void delete(final TacticalBattleReport entry) {
        super.delete(entry, entry.getBattleId());
    }

    /**
     * Listing all TacticalBattleReport from the database.
     *
     * @return a list of all the TacticalBattleReport entries that exist inside the table TacticalBattleReport.
     */
    public List<TacticalBattleReport> list() {
        return super.list(new TacticalBattleReport());
    }

    /**
     * Listing all TacticalBattleReport from the database owned by the specific nation.
     *
     * @param thisGame the game to select.
     * @return a list of all the Armies.
     */
    @SuppressWarnings("unchecked")
    public List<TacticalBattleReport> listGame(final Game thisGame) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(TacticalBattleReport.class);
        criteria.add(Restrictions.eq("position.game", thisGame));
        criteria.addOrder(Order.desc("turn"));
        criteria.addOrder(Order.asc("position.region"));
        criteria.addOrder(Order.asc("position.y"));
        criteria.addOrder(Order.asc("position.x"));
        criteria.addOrder(Order.asc("battleId"));
        return criteria.list();
    }

    /**
     * Listing all TacticalBattleReport from the database owned by the specific nation.
     *
     * @param thisGame the game to select.
     * @param nation   the nation to select.
     * @return a list of all the Armies.
     */
    @SuppressWarnings("unchecked")
    public List<TacticalBattleReport> listGameNation(final Game thisGame, final Nation nation) {
        final Session session = getSessionFactory().getCurrentSession();
        final List<TacticalBattleReport> list = new ArrayList<TacticalBattleReport>();

        final Criteria criteria1 = session.createCriteria(TacticalBattleReport.class);
        criteria1.add(Restrictions.eq("position.game", thisGame));
        criteria1.createCriteria("side1").add(Restrictions.eq("id", nation.getId()));
        criteria1.addOrder(Order.desc("turn"));
        criteria1.addOrder(Order.asc("position.region"));
        criteria1.addOrder(Order.asc("position.y"));
        criteria1.addOrder(Order.asc("position.x"));
        criteria1.addOrder(Order.asc("battleId"));
        for (final TacticalBattleReport report : (List<TacticalBattleReport>) criteria1.list()) {
            list.add(report);
        }

        final Criteria criteria2 = session.createCriteria(TacticalBattleReport.class);
        criteria2.add(Restrictions.eq("position.game", thisGame));
        criteria2.createCriteria("side2").add(Restrictions.eq("id", nation.getId()));
        criteria2.addOrder(Order.desc("turn"));
        criteria2.addOrder(Order.asc("position.region"));
        criteria2.addOrder(Order.asc("position.y"));
        criteria2.addOrder(Order.asc("position.x"));
        criteria2.addOrder(Order.asc("battleId"));
        for (final TacticalBattleReport report : (List<TacticalBattleReport>) criteria2.list()) {
            list.add(report);
        }

        java.util.Collections.sort(list, new TacticalBattleOrder());
        return list;
    }

    @SuppressWarnings("unchecked")
    public List<TacticalBattleReport> listGameNationTurn(final Game thisGame, final Nation nation, final int turn) {
        final Session session = getSessionFactory().getCurrentSession();
        final List<TacticalBattleReport> list = new ArrayList<TacticalBattleReport>();

        final Criteria criteria1 = session.createCriteria(TacticalBattleReport.class);
        criteria1.add(Restrictions.eq("position.game", thisGame));
        criteria1.createCriteria("side1").add(Restrictions.eq("id", nation.getId()));
        criteria1.add(Restrictions.eq("turn", turn));
        criteria1.addOrder(Order.asc("position.region"));
        criteria1.addOrder(Order.asc("position.y"));
        criteria1.addOrder(Order.asc("position.x"));
        criteria1.addOrder(Order.asc("battleId"));
        for (final TacticalBattleReport report : (List<TacticalBattleReport>) criteria1.list()) {
            list.add(report);
        }

        final Criteria criteria2 = session.createCriteria(TacticalBattleReport.class);
        criteria2.add(Restrictions.eq("position.game", thisGame));
        criteria2.createCriteria("side2").add(Restrictions.eq("id", nation.getId()));
        criteria2.add(Restrictions.eq("turn", turn));
        criteria2.addOrder(Order.asc("position.region"));
        criteria2.addOrder(Order.asc("position.y"));
        criteria2.addOrder(Order.asc("position.x"));
        criteria2.addOrder(Order.asc("battleId"));
        for (final TacticalBattleReport report : (List<TacticalBattleReport>) criteria2.list()) {
            list.add(report);
        }

        java.util.Collections.sort(list, new TacticalBattleOrder());
        return list;
    }

    /**
     * Count the number of reports issued.
     *
     * @return report count.
     */
    @SuppressWarnings("unchecked")
    public Object countReportsPerGame(final int gameId) {
        final Session session = getSessionFactory().getCurrentSession();
        final String thisQuery = "SELECT count(*) " +
                "FROM `BATTLES_TACTICAL` WHERE GAME_ID=" + gameId +
                " GROUP BY GAME_ID";

        return session.createSQLQuery(thisQuery).uniqueResult();
    }

}

