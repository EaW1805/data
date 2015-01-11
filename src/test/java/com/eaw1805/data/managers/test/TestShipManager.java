package com.eaw1805.data.managers.test;

import com.eaw1805.data.HibernateUtil;
import com.eaw1805.data.managers.GameManager;
import com.eaw1805.data.managers.fleet.ShipManager;
import com.eaw1805.data.managers.map.RegionManager;
import com.eaw1805.data.model.Nation;
import com.eaw1805.data.model.map.Position;
import junit.framework.TestCase;
import org.apache.logging.log4j.*;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;
import java.util.Map;

/**
 * Test cases for the Sector Manager.
 */
public class TestShipManager extends TestCase {

    /**
     * a log4j logger to print messages.
     */
    private static final Logger LOGGER = LogManager.getLogger(TestShipManager.class);

    /**
     * Setup the Tester.
     */
    @Before
    public void setUp() {
        // Do nothing for now
        HibernateUtil.connectEntityManagers(HibernateUtil.DB_S1);
    }

    /**
     * Tests count Ships.
     */
    @Test
    public void testCountBattalions() {
        final Transaction trans = HibernateUtil.getInstance().getSessionFactory(HibernateUtil.DB_S1).getCurrentSession().beginTransaction();
        final Position thisPosition = new Position();
        thisPosition.setGame(GameManager.getInstance().getByID(-1));
        thisPosition.setRegion(RegionManager.getInstance().getByID(1));
        thisPosition.setX(32);
        thisPosition.setY(18);
        LOGGER.debug("Merchant ships:");
        final Map<Nation, BigInteger> countMap = ShipManager.getInstance().countShipsByOwner(thisPosition, true);
        for (final Map.Entry<Nation, BigInteger> entry : countMap.entrySet()) {
            LOGGER.debug(entry.getKey().getName() + " - " + entry.getValue());
        }

        LOGGER.debug("War ships:");
        final Map<Nation, BigInteger> countWMap = ShipManager.getInstance().countShipsByOwner(thisPosition, false);
        for (final Map.Entry<Nation, BigInteger> entry : countWMap.entrySet()) {
            LOGGER.debug(entry.getKey().getName() + " - " + entry.getValue());
        }
        trans.rollback();
    }

}
