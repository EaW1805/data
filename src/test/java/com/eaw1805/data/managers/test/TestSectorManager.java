package com.eaw1805.data.managers.test;

import com.eaw1805.data.HibernateUtil;
import com.eaw1805.data.dto.common.SectorDTO;
import com.eaw1805.data.dto.converters.SectorConverter;
import com.eaw1805.data.managers.GameManager;
import com.eaw1805.data.managers.NationManager;
import com.eaw1805.data.managers.map.RegionManager;
import com.eaw1805.data.managers.map.SectorManager;
import com.eaw1805.data.model.Game;
import com.eaw1805.data.model.Nation;
import com.eaw1805.data.model.map.Region;
import com.eaw1805.data.model.map.Sector;
import junit.framework.TestCase;
import org.apache.logging.log4j.*;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.zip.GZIPOutputStream;

/**
 * Test cases for the Sector Manager.
 */
public class TestSectorManager extends TestCase {

    /**
     * a log4j logger to print messages.
     */
    private static final Logger LOGGER = LogManager.getLogger(TestSectorManager.class);

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
    public void testBarracksByGameNation() {
        final Transaction trans = HibernateUtil.getInstance().getSessionFactory(HibernateUtil.DB_S1).getCurrentSession().beginTransaction();
        final Nation thisNation = NationManager.getInstance().getByID(-1);
        final Game thisGame = GameManager.getInstance().getByID(1);
        final List<Sector> sectorList = SectorManager.getInstance().listBarracksByGameNation(thisGame, thisNation);
        for (Sector sector : sectorList) {
            LOGGER.debug(sector);
        }
        trans.rollback();
    }

    public void testTotalSize() {
        final Transaction trans = HibernateUtil.getInstance().getSessionFactory(HibernateUtil.DB_S1).getCurrentSession().beginTransaction();
        final Game thisGame = GameManager.getInstance().getByID(1);
        final Region thisRegion = RegionManager.getInstance().getByID(1);
        final List<Sector> lstSectors = SectorManager.getInstance().listByGameRegion(thisGame, thisRegion);
        final List<SectorDTO> lstSectorDTO = SectorConverter.convert(lstSectors);

        // Save analytical results
        try {
            final ByteArrayOutputStream baos = new ByteArrayOutputStream();
            final GZIPOutputStream zos = new GZIPOutputStream(baos);
            final ObjectOutputStream os = new ObjectOutputStream(zos);
            os.writeObject(lstSectorDTO);
            os.close();
            zos.close();
            baos.close();

            LOGGER.debug("Total Sectors: " + lstSectors.size());
            LOGGER.debug("Total Size: " + baos.toByteArray().length);

        } catch (Exception ex) {
            LOGGER.fatal(ex);
        }
        trans.rollback();
    }

}
