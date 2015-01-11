package com.eaw1805.data.managers.test;

import com.eaw1805.data.HibernateUtil;
import com.eaw1805.data.managers.beans.FieldBattleMapManagerBean;
import com.eaw1805.data.managers.field.FieldBattleMapManager;
import com.eaw1805.data.model.battles.field.FieldBattleMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestFieldBattleMapManager {

    private static final Logger LOGGER = LogManager.getLogger(TestFieldBattleMapManager.class);

    /**
     * Setup the Tester.
     */
    @Before
    public void setUp() {
        // Set the session factories to all stores
        HibernateUtil.connectEntityManagers(HibernateUtil.DB_S1);
    }

    @Test
    public void addTest() {
        // Make sure we have an active transaction
        final Session thatSession = HibernateUtil.getInstance().getSessionFactory(HibernateUtil.DB_S1).getCurrentSession();
        final Transaction thatTrans = thatSession.beginTransaction();

        try {
            FieldBattleMapManagerBean fieldBattleMapManager = FieldBattleMapManager.getInstance();

            FieldBattleMap fbMap = new FieldBattleMap(6, 6);
            fieldBattleMapManager.add(fbMap);
        } catch (Exception ex) {
            LOGGER.fatal(ex.getMessage(), ex);
        }

//        ScenarioInitializer scenarioInitializer = new ScenarioInitializer(HibernateUtil.DB_S1);
//        scenarioInitializer.initialize();

        thatTrans.rollback();
    }

    @Test
    public void getTest() {
        // Make sure we have an active transaction
        final Session thatSession = HibernateUtil.getInstance().getSessionFactory(HibernateUtil.DB_S1).getCurrentSession();
        final Transaction thatTrans = thatSession.beginTransaction();

        FieldBattleMapManagerBean fieldBattleMapManager = FieldBattleMapManager.getInstance();

        FieldBattleMap fbMap = fieldBattleMapManager.getByID(10);
        assertEquals(36, fbMap.getSectorsSet().size());

        thatTrans.rollback();
    }

//	@After
//	public void tearDown() {
//		// Set the session factories to all stores
//		SessionFactory sf = HibernateUtil.getInstance().createSessionFactory();
//		Session session = sf.openSession();
//		session.close();
//		sf.close();
//	}
}
