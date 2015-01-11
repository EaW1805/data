package com.eaw1805.data.managers.test;

import com.eaw1805.data.HibernateUtil;
import com.eaw1805.data.managers.GameManager;
import com.eaw1805.data.managers.army.BrigadeManager;
import com.eaw1805.data.managers.map.RegionManager;
import com.eaw1805.data.model.Nation;
import com.eaw1805.data.model.army.Brigade;
import com.eaw1805.data.model.battles.field.FieldBattlePosition;
import com.eaw1805.data.model.battles.field.Order;
import com.eaw1805.data.model.battles.field.enumerations.ArmEnum;
import com.eaw1805.data.model.battles.field.enumerations.FormationEnum;
import com.eaw1805.data.model.battles.field.enumerations.MoraleStatusEnum;
import com.eaw1805.data.model.battles.field.enumerations.OrdersEnum;
import com.eaw1805.data.model.map.Position;
import junit.framework.TestCase;
import org.apache.logging.log4j.*;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;
import java.util.Map;

/**
 * Test cases for the Brigade Manager.
 */
public class TestBrigadeManager extends TestCase {

    /**
     * a log4j logger to print messages.
     */
    private static final Logger LOGGER = LogManager.getLogger(TestBrigadeManager.class);

    /**
     * Setup the Tester.
     */
    @Before
    public void setUp() {
        // Do nothing for now
        HibernateUtil.connectEntityManagers(HibernateUtil.DB_S1);
    }

    /**
     * Tests count Brigades.
     */
    @Test
    public void testAddBrigade() {
        final Transaction trans = HibernateUtil.getInstance().getSessionFactory(HibernateUtil.DB_S1).getCurrentSession().beginTransaction();
        Brigade brigade = new Brigade();
        brigade.setArmTypeEnum(ArmEnum.CAVALRY);
        brigade.setFieldBattlePosition(new FieldBattlePosition(4, 4));
        brigade.setFormationEnum(FormationEnum.LINE);
        brigade.setMoraleStatusEnum(MoraleStatusEnum.ROUTING);

        Order order1 = new Order();
        order1.setActivationRound(0);
        order1.setOwnSideCapturedEnemyStrategicPoint(true);
        order1.setOrderTypeEnum(OrdersEnum.DEFEND_POSITION);
        brigade.setBasicOrder(order1);

        Order order2 = new Order();
        order2.setActivationRound(0);
        order2.setOwnSideCapturedEnemyStrategicPoint(true);
        order2.setOrderTypeEnum(OrdersEnum.HEAVY_CAVALRY_CHARGE);
        brigade.setAdditionalOrder(order2);

        BrigadeManager.getInstance().add(brigade);

        trans.rollback();
    }


    /**
     * Tests count Brigades.
     */
    @Test
    public void testCountBrigades() {
        final Transaction trans = HibernateUtil.getInstance().getSessionFactory(HibernateUtil.DB_S1).getCurrentSession().beginTransaction();
        final Position thisPosition = new Position();
        thisPosition.setGame(GameManager.getInstance().getByID(-1));
        thisPosition.setRegion(RegionManager.getInstance().getByID(1));
        thisPosition.setX(34);
        thisPosition.setY(25);
        final Map<Nation, BigInteger> countMap = BrigadeManager.getInstance().countBrigadesByOwner(thisPosition);
        for (final Map.Entry<Nation, BigInteger> entry : countMap.entrySet()) {
            LOGGER.debug(entry.getKey().getName() + " - " + entry.getValue());
        }
        trans.rollback();
    }

}
