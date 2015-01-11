package com.eaw1805.data.managers.test;

import com.eaw1805.data.model.battles.field.enumerations.OrdersEnum;
import com.eaw1805.data.HibernateUtil;
import com.eaw1805.data.managers.field.FieldBattleOrderManager;
import com.eaw1805.data.model.battles.field.FieldBattlePosition;
import com.eaw1805.data.model.battles.field.Order;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;

public class TestFieldBattleOrderManager {

    private static final Logger LOGGER = LogManager.getLogger(TestFieldBattleOrderManager.class);

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
            FieldBattleOrderManager orderManager = FieldBattleOrderManager.getInstance();

            Order order = new Order();
            order.setCheckpoint1(new FieldBattlePosition(1, 1));
            order.setCheckpoint2(new FieldBattlePosition(2, 2));
            order.setCheckpoint3(new FieldBattlePosition(3, 3));
            order.setReachedCheckpoint1(true);
            order.setReachedCheckpoint2(true);
            order.setReachedCheckpoint3(true);
            order.setActivationRound(4);
            order.setHeadCountThreshold(4);
            order.setLastDestinationReached(true);
            order.setOwnSideCapturedEnemyStrategicPoint(true);
            order.setEnemySideCapturedOwnStrategicPoint(true);
            order.setCustomStrategicPoint1(new FieldBattlePosition(5, 5));
            order.setCustomStrategicPoint2(new FieldBattlePosition(6, 6));
            order.setCustomStrategicPoint3(new FieldBattlePosition(7, 7));
            order.setOrderTypeEnum(OrdersEnum.BUILD_PONTOON_BRIDGE);
            order.setConstructionCounter(2);
            orderManager.add(order);

        } catch (Exception ex) {
            LOGGER.fatal(ex.getMessage(), ex);
        }

        thatTrans.rollback();
    }

//    @Test
//    public void getTest() {
//        final Session thatSession = HibernateUtil.getInstance().getSessionFactory(HibernateUtil.DB_S1).getCurrentSession();
//        final Transaction thatTrans = thatSession.beginTransaction();
//
//        Order order = OrderManager.getInstance().getByID(1);
//        assertEquals(OrdersEnum.BUILD_PONTOON_BRIDGE, order.getOrderTypeEnum());
//
//        thatTrans.rollback();
//    }

//	@After
//	public void tearDown() {
//		// Set the session factories to all stores
//		SessionFactory sf = HibernateUtil.getInstance().createSessionFactory();
//		Session session = sf.openSession();
//		session.close();
//		sf.close();
//	}
}
