package com.eaw1805.data.managers.test;

import com.eaw1805.data.HibernateUtil;
import com.eaw1805.data.managers.beans.FieldBattleTerrainManagerBean;
import com.eaw1805.data.managers.field.FieldBattleTerrainManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestFieldBattleTerrainManager {

    private static final Logger LOGGER = LogManager.getLogger(TestFieldBattleTerrainManager.class);

    /**
     * Setup the Tester.
     */
    @Before
    public void setUp() {
        // Set the session factories to all stores
        HibernateUtil.connectEntityManagers(HibernateUtil.DB_S1);
    }

    @Test
    public void test() {
        // Make sure we have an active transaction
        final Session thatSession = HibernateUtil.getInstance().getSessionFactory(HibernateUtil.DB_S1).getCurrentSession();
        final Transaction thatTrans = thatSession.beginTransaction();

        try {
            FieldBattleTerrainManagerBean fieldBattleSectorManager = FieldBattleTerrainManager.getInstance();
            assertEquals(6, fieldBattleSectorManager.list().size());
        } catch (Exception ex) {
            LOGGER.fatal(ex.getMessage(), ex);
        }

        thatTrans.rollback();
    }

}
