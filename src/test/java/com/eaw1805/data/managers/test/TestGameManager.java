package com.eaw1805.data.managers.test;

import com.eaw1805.data.HibernateUtil;
import com.eaw1805.data.managers.GameManager;
import com.eaw1805.data.model.Game;
import junit.framework.TestCase;
import org.apache.logging.log4j.*;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

/**
 * Test GameManager CRUD operations.
 */
public class TestGameManager extends TestCase {

    /**
     * a log4j logger to print messages.
     */
    private static final Logger LOGGER = LogManager.getLogger(TestGameManager.class);

    /**
     * Setup the Tester.
     */
    @Before
    public void setUp() {
        // Do nothing for now
        HibernateUtil.connectEntityManagers(HibernateUtil.DB_FREE);
    }

    /**
     * Tests list by key.
     */
    @Test
    public void testDeleteGame() {
        final int gameId = 3;

        final Transaction trans = HibernateUtil.getInstance().beginTransaction(HibernateUtil.DB_FREE);
        final Game thisGame = GameManager.getInstance().getByID(gameId);

        if (thisGame != null) {
            GameManager.getInstance().deleteGame(thisGame.getGameId());
            trans.commit();

            // Create the directory of this game
            final File gameDir = new File("/srv/eaw1805/images/maps/s" + thisGame.getScenarioId() + "/" + thisGame.getGameId());
            if (gameDir.exists()) {
                final boolean result = deleteDir(gameDir);
                if (result) {
                    LOGGER.info("Delete Game directory.");
                } else {
                    LOGGER.error("Failed to delete Game directory. ");
                }
            }
        }
    }

    /**
     * Deletes all files and sub directories under dir.
     * If a deletion fails, the method stops attempting to delete and returns false.
     *
     * @param dir the directory to delete.
     * @return true if all deletions were successful.
     */

    private boolean deleteDir(final File dir) {
        if (dir.isDirectory()) {
            for (final String aChildren : dir.list()) {
                if (!deleteDir(new File(dir, aChildren))) {
                    return false;
                }
            }
        }

        // The directory is now empty so delete it
        return dir.delete();
    }

}
