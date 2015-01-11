package com.eaw1805.data.managers.test;

import com.eaw1805.data.HibernateUtil;
import com.eaw1805.data.managers.GameManager;
import com.eaw1805.data.managers.RelationsManager;
import com.eaw1805.data.model.Game;
import com.eaw1805.data.model.NationsRelation;
import junit.framework.TestCase;
import org.apache.logging.log4j.*;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;


/**
 * Test cases for the Relations Manager.
 */
public class TestRelationsManager extends TestCase {

    /**
     * a log4j logger to print messages.
     */
    private static final Logger LOGGER = LogManager.getLogger(TestRelationsManager.class);

    /**
     * Setup the Tester.
     */
    @Before
    public void setUp() {
        // Do nothing for now
        HibernateUtil.connectEntityManagers(HibernateUtil.DB_S1);
    }

    /**
     * Tests list Barracks.
     */
    @Test
    public void testRelationsById() {
        final Transaction trans = HibernateUtil.getInstance().getSessionFactory(HibernateUtil.DB_S1).getCurrentSession().beginTransaction();
        final Game thisGame = GameManager.getInstance().getByID(1);
        final NationsRelation relation = RelationsManager.getInstance().getByNations(thisGame, 1, 2);
        LOGGER.debug(relation);
        trans.rollback();
    }

}
