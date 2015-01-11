package com.eaw1805.data.managers.test;

import com.eaw1805.data.HibernateUtil;
import com.eaw1805.data.managers.beans.FieldBattleSectorManagerBean;
import com.eaw1805.data.managers.field.FieldBattleSectorManager;
import com.eaw1805.data.model.battles.field.FieldBattleSector;
import org.apache.logging.log4j.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;

public class TestFieldBattleSectorManager {

    private static final Logger LOGGER = LogManager.getLogger(TestFieldBattleSectorManager.class);

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
            FieldBattleSectorManagerBean fieldBattleSectorManager = FieldBattleSectorManager.getInstance();

            FieldBattleSector fbSector = new FieldBattleSector();
            fbSector.setX(5);
            fbSector.setY(6);

            fbSector.setAltitude(3);
            fbSector.setBush(true);
            fbSector.setForest(true);
            fbSector.setFortificationInterior(true);
            fbSector.setLake(true);
            fbSector.setMinorRiver(true);
            fbSector.setRoad(true);

            fbSector.setWall(123);
            fbSector.setVillage(23);
            fbSector.setTown(123);
            fbSector.setBridge(34);
            fbSector.setChateau(123);
            fbSector.setEntrenchment(35);

            fieldBattleSectorManager.add(fbSector);


//            VillageManager.getInstance().add(village);
        } catch (Exception ex) {
            LOGGER.fatal(ex.getMessage(), ex);
        }

        thatTrans.rollback();
    }

}
