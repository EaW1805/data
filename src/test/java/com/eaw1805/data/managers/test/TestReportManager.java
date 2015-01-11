package com.eaw1805.data.managers.test;

import com.eaw1805.data.HibernateUtil;
import com.eaw1805.data.managers.GameManager;
import com.eaw1805.data.managers.NationManager;
import com.eaw1805.data.managers.ReportManager;
import com.eaw1805.data.managers.battles.TacticalBattleReportManager;
import com.eaw1805.data.model.Game;
import com.eaw1805.data.model.Nation;
import com.eaw1805.data.model.battles.TacticalBattleReport;
import junit.framework.TestCase;
import org.apache.logging.log4j.*;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * Test cases for report manager.
 */
public class TestReportManager extends TestCase {

    /**
     * a log4j logger to print messages.
     */
    private static final Logger LOGGER = LogManager.getLogger(TestReportManager.class);

    /**
     * Setup the Tester.
     */
    @Before
    public void setUp() {
        // Do nothing for now
        HibernateUtil.connectEntityManagers(HibernateUtil.DB_S1);
    }

    /**
     * Tests battle reports.
     *
     * @throws Exception in case a db error occurs.
     */
    @SuppressWarnings("unchecked")
    @Test
    public void testBattleReportsList() throws Exception {
        final Transaction trans = HibernateUtil.getInstance().getSessionFactory(HibernateUtil.DB_S1).getCurrentSession().beginTransaction();
        final Game thisGame = GameManager.getInstance().getByID(5);
        final Nation thisNation = NationManager.getInstance().getByID(2);
        final List<TacticalBattleReport> battleReportList = TacticalBattleReportManager.getInstance().listGameNation(thisGame, thisNation);
        for (TacticalBattleReport tacticalBattleReport : battleReportList) {
            LOGGER.debug(tacticalBattleReport.toString());
        }
        trans.rollback();
    }

    /**
     * Tests sort reports.
     *
     * @throws Exception in case a db error occurs.
     */
    @Test
    public void testSortReports() throws Exception {
        final Transaction trans = HibernateUtil.getInstance().getSessionFactory(HibernateUtil.DB_S1).getCurrentSession().beginTransaction();
        final Game thisGame = GameManager.getInstance().getByID(5);

        LOGGER.debug("Largest population:");
        final List<Nation> rankedPop = ReportManager.getInstance().rankNations("population.size", thisGame, thisGame.getTurn() - 1);
        int rank = 1;
        for (final Nation nation : rankedPop) {
            LOGGER.debug(rank + " - " + nation.getName());
            rank++;
        }

        LOGGER.debug("Largest population in Europe:");
        final List<Nation> rankedPopEurope = ReportManager.getInstance().rankNations("population.size.region.1", thisGame, thisGame.getTurn() - 1);
        rank = 1;
        for (final Nation nation : rankedPopEurope) {
            LOGGER.debug(rank + " - " + nation.getName());
            rank++;
        }

        LOGGER.debug("----------------------");
        LOGGER.debug("Largest population in Caribbean:");
        final List<Nation> rankedPopCarib = ReportManager.getInstance().rankNations("population.size.region.2", thisGame, thisGame.getTurn() - 1);
        rank = 1;
        for (final Nation nation : rankedPopCarib) {
            LOGGER.debug(rank + " - " + nation.getName());
            rank++;
        }

        LOGGER.debug("----------------------");
        LOGGER.debug("Largest army size:");
        final List<Nation> rankedArmy = ReportManager.getInstance().rankNations("armies.soldiers.total", thisGame, thisGame.getTurn() - 1);
        rank = 1;
        for (final Nation nation : rankedArmy) {
            LOGGER.debug(rank + " - " + nation.getName());
            rank++;
        }

        LOGGER.debug("----------------------");
        LOGGER.debug("Largest fleet:");
        final List<Nation> rankedFleet = ReportManager.getInstance().rankNations("ships.total", thisGame, thisGame.getTurn() - 1);
        rank = 1;
        for (final Nation nation : rankedFleet) {
            LOGGER.debug(rank + " - " + nation.getName());
            rank++;
        }

        LOGGER.debug("----------------------");
        LOGGER.debug("Richest country:");
        final List<Nation> rankedMoney = ReportManager.getInstance().rankNations("goods.region.1.good.1", thisGame, thisGame.getTurn() - 1);
        rank = 1;
        for (final Nation nation : rankedMoney) {
            LOGGER.debug(rank + " - " + nation.getName());
            rank++;
        }

        trans.commit();
    }
}
