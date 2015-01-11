package com.eaw1805.data.managers.test;

import com.eaw1805.data.HibernateUtil;
import com.eaw1805.data.managers.GameManager;
import com.eaw1805.data.managers.NationManager;
import com.eaw1805.data.managers.map.BarrackManager;
import com.eaw1805.data.model.Game;
import com.eaw1805.data.model.Nation;
import com.eaw1805.data.model.map.Barrack;
import junit.framework.TestCase;
import org.apache.logging.log4j.*;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Test BarrackManager functionality.
 */
public class TestBarrackManager extends TestCase {

    /**
     * a log4j logger to print messages.
     */
    private static final Logger LOGGER = LogManager.getLogger(TestBarrackManager.class);

    /**
     * Setup the Tester.
     */
    @Before
    public void setUp() {
        // Do nothing for now
        HibernateUtil.connectEntityManagers(HibernateUtil.DB_S1);
    }

    /**
     * Tests process sector.
     */
    @Test
    public void testListGameNation() {
        // simple test
        final Transaction trans = HibernateUtil.getInstance().getSessionFactory(HibernateUtil.DB_S1).getCurrentSession().beginTransaction();
        final Game thisGame = GameManager.getInstance().getByID(-1);
        final Nation thisNation = NationManager.getInstance().getByID(1);
        final List<Barrack> list = BarrackManager.getInstance().listByGameNation(thisGame, thisNation);
        for (Barrack barrack : list) {
            LOGGER.debug(barrack);
        }
        trans.rollback();
    }

}
