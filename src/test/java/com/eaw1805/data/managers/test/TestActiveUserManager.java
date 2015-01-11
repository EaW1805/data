package com.eaw1805.data.managers.test;

import com.eaw1805.data.HibernateUtil;
import com.eaw1805.data.managers.ActiveUserManager;
import com.eaw1805.data.managers.PlayerOrderManager;
import com.eaw1805.data.model.ActiveUser;
import junit.framework.TestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Test Cases for ActiveUser Manager.
 */
public class TestActiveUserManager extends TestCase {

    /**
     * a log4j logger to print messages.
     */
    private static final Logger LOGGER = LogManager.getLogger(TestProfileManager.class);

    /**
     * Setup the Tester.
     */
    @Before
    public void setUp() {
        // Do nothing for now
        HibernateUtil.connectEntityManagers(HibernateUtil.DB_S1);
    }

    @Test
    public void testStats() throws Exception {
        final Transaction trans = HibernateUtil.getInstance().beginTransaction(HibernateUtil.DB_S1);
        final List<Long> stats = PlayerOrderManager.getInstance().countOrdersPerGameNation(1, 10);
        for (Long stat : stats) {
            LOGGER.debug(stat);
        }
        trans.rollback();
    }

    /**
     * Tests list by key.
     */
    public void testCountActiveUsers() {
        final Transaction trans = HibernateUtil.getInstance().beginTransaction(HibernateUtil.DB_MAIN);
        final List<ActiveUser> activeUsers = ActiveUserManager.getInstance().list();
        LOGGER.info(activeUsers.size());
        ActiveUserManager.getInstance().delete("aaaTiNH1bXodXhtg7PZQt");
        trans.commit();
    }

}
