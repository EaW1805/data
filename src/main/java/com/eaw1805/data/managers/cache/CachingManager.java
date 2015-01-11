package com.eaw1805.data.managers.cache;


import com.eaw1805.data.model.Game;
import org.apache.logging.log4j.*;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Manages the Caches.
 */
public class CachingManager {

    /**
     * a log4j logger to print messages.
     */
    private static final Logger LOGGER = LogManager.getLogger(CachingManager.class);

    /**
     * Our instance of the CachingManager.
     */
    private static CachingManager ourInstance = null;

    /**
     * Returns the CachingManager instance.
     *
     * @return the CachingManager
     */
    public static CachingManager getInstance() {
        if (ourInstance == null) {
            ourInstance = new CachingManager();
        }
        return ourInstance;
    }

    /**
     * Default Constructor.
     */
    public CachingManager() {
        //Nothing
    }

    /**
     * Clear the cache for a specific game.
     *
     * @param game the game.
     */
    public void clearGame(final Game game) {
        final ArrayList<String> keys = new ArrayList<String>(
                Arrays.asList("com.eaw1805.webapp.controllers.game.ShowGameInfo.prepareReport-" + game.hashCode(),
                        "com.eaw1805.webapp.controllers.cache.helper.GameHelperBean.getAllFreePlayedNations-",
                        "com.eaw1805.webapp.controllers.cache.helper.GameHelperBean.getAllNewFreeNations-",
                        "com.eaw1805.webapp.controllers.cache.helper.GameHelperBean.prepareGamesList-"));
//        System.out.println("Inside clear game!!");
//        for (final String cacheName : CacheManager.getInstance().getCacheNames()) {
//            final Cache thisCache = CacheManager.getInstance().getCache(cacheName);
//            for (final String key : keys) {
//                if (thisCache.getKeys().contains(key)) {
//                    thisCache.remove(key);
//                }
//            }
//        }
    }

    /**
     * Default main.
     *
     * @param args String arguments.
     */

    public static void main(final String[] args) {
        Game game = new Game();
        game.setGameId(1);
        LOGGER.debug(game.hashCode());
    }

}
