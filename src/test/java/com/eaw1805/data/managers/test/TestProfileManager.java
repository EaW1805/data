package com.eaw1805.data.managers.test;

import com.eaw1805.data.HibernateUtil;
import com.eaw1805.data.constants.ProfileConstants;
import com.eaw1805.data.managers.ProfileManager;
import com.eaw1805.data.model.Profile;
import junit.framework.TestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Test Cases for Profile Manager.
 */
public class TestProfileManager extends TestCase {

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

    /**
     * Tests list by key.
     */
    @Test
    public void testListByKey() {
        final Transaction trans = HibernateUtil.getInstance().getSessionFactory(HibernateUtil.DB_S1).getCurrentSession().beginTransaction();
        final List<Profile> vps = ProfileManager.getInstance().listByKey(ProfileConstants.VPS);
        LOGGER.info(vps.size());
        final List<Profile> battlesNavalWon = ProfileManager.getInstance().listByKey(ProfileConstants.BATTLES_TACTICAL_WON);
        LOGGER.info(battlesNavalWon.size());
        final List<Profile> battlesFieldWon = ProfileManager.getInstance().listByKey(ProfileConstants.BATTLES_FIELD_WON);
        LOGGER.info(battlesFieldWon.size());
        final List<Profile> enemyKilledAll = ProfileManager.getInstance().listByKey(ProfileConstants.ENEMY_KILLED_ALL);
        LOGGER.info(enemyKilledAll.size());


        trans.commit();
    }

}
