package com.eaw1805.data.managers.battles;

import com.eaw1805.data.managers.AbstractManager;
import com.eaw1805.data.managers.beans.FieldBattleReportManagerBean;
import com.eaw1805.data.model.Game;
import com.eaw1805.data.model.Nation;
import com.eaw1805.data.model.army.comparators.FieldBattleOrder;
import com.eaw1805.data.model.battles.FieldBattleReport;
import com.eaw1805.data.model.map.Position;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * CRUD operations for FieldBattleReport objects.
 */
public class FieldBattleReportManager
        extends AbstractManager<FieldBattleReport>
        implements FieldBattleReportManagerBean {

    /**
     * static instance(ourInstance) initialized as null.
     */
    private static FieldBattleReportManagerBean ourInstance = null;

    /**
     * Public constructor .
     */
    public FieldBattleReportManager() {
        // Does nothing
        super();
    }

    /**
     * GameManager is loaded on the first execution of FieldBattleReportManager.getInstance()
     * or the first access to FieldBattleReportManager.ourInstance, not before.
     *
     * @return ourInstance
     */
    public static FieldBattleReportManagerBean getInstance() {
        synchronized (FieldBattleReportManager.class) {
            if (ourInstance == null) {
                ourInstance = new FieldBattleReportManager();
            }
        }

        return ourInstance;
    }

    /**
     * Set the global instance of the manager. Used for the integration with Spring.
     *
     * @param thisInstance the manager bean.
     */
    public static void setInstance(final FieldBattleReportManagerBean thisInstance) {
        ourInstance = thisInstance;
    }

    /**
     * get the FieldBattleReport from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    public FieldBattleReport getByID(final int entityID) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(FieldBattleReport.class);
        criteria.add(Restrictions.eq("battleId", entityID));
        return (FieldBattleReport) criteria.uniqueResult();
    }

    /**
     * Delete the input FieldBattleReport entry from the database.
     *
     * @param entry the FieldBattleReport entry tha we want to delete.
     */
    public void delete(final FieldBattleReport entry) {
        super.delete(entry, entry.getBattleId());
    }

    /**
     * Listing all FieldBattleReport from the database.
     *
     * @return a list of all the FieldBattleReport entries that exist inside the table FieldBattleReport.
     */
    public List<FieldBattleReport> list() {
        return super.list(new FieldBattleReport());
    }

    /**
     * Listing all FieldBattleReport from the database owned by the specific nation.
     *
     * @param thisGame the game to select.
     * @return a list of all the Armies.
     */
    @SuppressWarnings("unchecked")
    public List<FieldBattleReport> listGame(final Game thisGame) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(FieldBattleReport.class);
        criteria.add(Restrictions.eq("position.game", thisGame));
        criteria.addOrder(Order.desc("turn"));
        criteria.addOrder(Order.asc("position.region"));
        criteria.addOrder(Order.asc("position.y"));
        criteria.addOrder(Order.asc("position.x"));
        criteria.addOrder(Order.asc("battleId"));
        return criteria.list();
    }

    /**
     * Listing all FieldBattleReport from the database owned by the specific nation.
     *
     * @param thisGame the game to select.
     * @return a list of all the Armies.
     */
    @SuppressWarnings("unchecked")
    public List<FieldBattleReport> listScenario() {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(FieldBattleReport.class);
        criteria.add(Restrictions.eq("scenarioBattle", true));
        criteria.addOrder(Order.asc("battleId"));
        return criteria.list();
    }

    /**
     * Listing all FieldBattleReport from the database owned by the specific nation.
     *
     * @param thisGame the game to select.
     * @param nation   the nation to select.
     * @return a list of all the Armies.
     */
    @SuppressWarnings("unchecked")
    public List<FieldBattleReport> listGameNation(final Game thisGame, final Nation nation) {
        final Session session = getSessionFactory().getCurrentSession();
        final List<FieldBattleReport> list = new ArrayList<FieldBattleReport>();

        final Criteria criteria1 = session.createCriteria(FieldBattleReport.class);
        criteria1.add(Restrictions.eq("position.game", thisGame));
        criteria1.createCriteria("side1").add(Restrictions.eq("id", nation.getId()));
        criteria1.addOrder(Order.desc("turn"));
        criteria1.addOrder(Order.asc("position.region"));
        criteria1.addOrder(Order.asc("position.y"));
        criteria1.addOrder(Order.asc("position.x"));
        criteria1.addOrder(Order.asc("battleId"));
        for (final FieldBattleReport report : (List<FieldBattleReport>) criteria1.list()) {
            list.add(report);
        }

        final Criteria criteria2 = session.createCriteria(FieldBattleReport.class);
        criteria2.add(Restrictions.eq("position.game", thisGame));
        criteria2.createCriteria("side2").add(Restrictions.eq("id", nation.getId()));
        criteria2.addOrder(Order.desc("turn"));
        criteria2.addOrder(Order.asc("position.region"));
        criteria2.addOrder(Order.asc("position.y"));
        criteria2.addOrder(Order.asc("position.x"));
        criteria2.addOrder(Order.asc("battleId"));
        for (final FieldBattleReport report : (List<FieldBattleReport>) criteria2.list()) {
            list.add(report);
        }

        java.util.Collections.sort(list, new FieldBattleOrder());
        return list;
    }

    @SuppressWarnings("unchecked")
    public List<FieldBattleReport> listGameNationTurn(final Game thisGame, final Nation nation, final int turn) {
        final Session session = getSessionFactory().getCurrentSession();
        final List<FieldBattleReport> list = new ArrayList<FieldBattleReport>();

        final Criteria criteria1 = session.createCriteria(FieldBattleReport.class);
        criteria1.add(Restrictions.eq("position.game", thisGame));
        criteria1.createCriteria("side1").add(Restrictions.eq("id", nation.getId()));
        criteria1.add(Restrictions.eq("turn", turn));
        criteria1.addOrder(Order.asc("position.region"));
        criteria1.addOrder(Order.asc("position.y"));
        criteria1.addOrder(Order.asc("position.x"));
        criteria1.addOrder(Order.asc("battleId"));
        for (final FieldBattleReport report : (List<FieldBattleReport>) criteria1.list()) {
            list.add(report);
        }

        final Criteria criteria2 = session.createCriteria(FieldBattleReport.class);
        criteria2.add(Restrictions.eq("position.game", thisGame));
        criteria2.createCriteria("side2").add(Restrictions.eq("id", nation.getId()));
        criteria2.add(Restrictions.eq("turn", turn));
        criteria2.addOrder(Order.asc("position.region"));
        criteria2.addOrder(Order.asc("position.y"));
        criteria2.addOrder(Order.asc("position.x"));
        criteria2.addOrder(Order.asc("battleId"));
        for (final FieldBattleReport report : (List<FieldBattleReport>) criteria2.list()) {
            list.add(report);
        }

        java.util.Collections.sort(list, new FieldBattleOrder());
        return list;
    }

    /**
     * Count the number of reports issued.
     *
     * @return report count.
     */
    public Object countReportsPerGame(final int gameId) {
        final Session session = getSessionFactory().getCurrentSession();
        final String thisQuery = "SELECT count(*) " +
                "FROM `BATTLES_TACTICAL` WHERE GAME_ID=" + gameId +
                " GROUP BY GAME_ID";

        return session.createSQLQuery(thisQuery).uniqueResult();
    }

    @Override
    public FieldBattleReport listPositionTurn(Position position, int turn) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(FieldBattleReport.class);
        criteria.add(Restrictions.eq("position", position));
        criteria.add(Restrictions.eq("turn", turn));
        return (FieldBattleReport) criteria.uniqueResult();
    }

}

