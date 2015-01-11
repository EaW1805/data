package com.eaw1805.data.managers.test;

import com.eaw1805.data.HibernateUtil;
import com.eaw1805.data.managers.GameManager;
import com.eaw1805.data.managers.army.BattalionManager;
import com.eaw1805.data.managers.map.RegionManager;
import com.eaw1805.data.model.Nation;
import com.eaw1805.data.model.army.Battalion;
import com.eaw1805.data.model.map.Position;
import com.eaw1805.data.model.map.Sector;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

/**
 * Test cases for the Battalion Manager.
 */
public class TestBattalionManager {

    /**
     * a log4j logger to print messages.
     */
    private static final Logger LOGGER = LogManager.getLogger(TestBattalionManager.class);

    /**
     * Setup the Tester.
     */
    @Before
    public void setUp() {
        // Do nothing for now
        HibernateUtil.connectEntityManagers(HibernateUtil.DB_S1);
    }

    /**
     * Tests count Battalions.
     */
    @Test
    public void testCountBattalions() {
        final Transaction trans = HibernateUtil.getInstance().getSessionFactory(HibernateUtil.DB_S1).getCurrentSession().beginTransaction();
        final Position thisPosition = new Position();
        thisPosition.setGame(GameManager.getInstance().getByID(-1));
        thisPosition.setRegion(RegionManager.getInstance().getByID(1));
        thisPosition.setX(34);
        thisPosition.setY(26);
        final Map<Nation, BigInteger> countMap = BattalionManager.getInstance().countBattalionsByOwner(thisPosition);
        for (final Map.Entry<Nation, BigInteger> entry : countMap.entrySet()) {
            LOGGER.debug(entry.getKey().getName() + " - " + entry.getValue());
        }
        trans.rollback();
    }

    /**
     * Tests list LC Battalions.
     */
    @Test
    public void testListLCBattalions() {
        final Transaction trans = HibernateUtil.getInstance().getSessionFactory(HibernateUtil.DB_S1).getCurrentSession().beginTransaction();
        final Map<Nation, Map<Sector, BigInteger>> listLC = BattalionManager.getInstance().listLCBattalions(GameManager.getInstance().getByID(-1));
        for (final Map.Entry<Nation, Map<Sector, BigInteger>> entry : listLC.entrySet()) {
            for (final Map.Entry<Sector, BigInteger> sector : listLC.get(entry.getKey()).entrySet()) {
                LOGGER.debug(entry.getKey().getName() + " - "
                        + sector.getKey().getPosition().getRegion().getName() + ", "
                        + sector.getKey().getPosition().toString() + " - "
                        + sector.getValue());
            }
        }
        trans.rollback();
    }

    /**
     * Tests count Battalions.
     */
    @Test
    public void testListSmall() {
        final Transaction trans = HibernateUtil.getInstance().getSessionFactory(HibernateUtil.DB_S1).getCurrentSession().beginTransaction();
        final List<Battalion> listBattalions = BattalionManager.getInstance().listSmallByGame(GameManager.getInstance().getByID(1));
        for (Battalion listBattalion : listBattalions) {
            LOGGER.debug(listBattalion.getId() + " - " + listBattalion.getHeadcount());
        }
        trans.rollback();
    }

    /**
     * Tests count Battalions.
     */
    @Test
    public void testResetCounters() {
        final Transaction trans = HibernateUtil.getInstance().getSessionFactory(HibernateUtil.DB_S1).getCurrentSession().beginTransaction();
        BattalionManager.getInstance().removeHasMovedFlag(GameManager.getInstance().getByID(2));
        trans.commit();
    }

}
