package com.eaw1805.data.constants;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Central point for definition of website cache manager constants.
 */
public interface CacheConstants {

    /**
     * Home url.
     */
    static final String EAW_HOME_URL = "http://www.eaw1805.com/login";

    /**
     * Evict Cache Url.
     */
    static final String EAW_CLEAR_CACHE_URL = "http://www.eaw1805.com/cache/evict/";

    /**
     * Fixed Pages.
     */
    static final ArrayList<String> STATIC_PAGES =
            new ArrayList<String>(Arrays.asList("http://www.eaw1805.com/home",
                    "http://www.eaw1805.com/listgames",
                    "http://www.eaw1805.com/hallOfFame",
                    "http://www.eaw1805.com/scenario/list"));

    /**
     * Fixed Public Pages.
     */
    static final String[] PUBLIC_PAGES = {
            "http://www.eaw1805.com/home",
            "http://www.eaw1805.com/news",
            "http://www.eaw1805.com/about",
            "http://www.eaw1805.com/terms",
            "http://www.eaw1805.com/privacy",
            "http://www.eaw1805.com/scenario/list",
            "http://www.eaw1805.com/scenario/1802/info",
            "http://www.eaw1805.com/scenario/1805/info",
            "http://www.eaw1805.com/scenario/1805/nation/1",
            "http://www.eaw1805.com/scenario/1805/nation/2",
            "http://www.eaw1805.com/scenario/1805/nation/3",
            "http://www.eaw1805.com/scenario/1805/nation/4",
            "http://www.eaw1805.com/scenario/1805/nation/5",
            "http://www.eaw1805.com/scenario/1805/nation/6",
            "http://www.eaw1805.com/scenario/1805/nation/7",
            "http://www.eaw1805.com/scenario/1805/nation/8",
            "http://www.eaw1805.com/scenario/1805/nation/9",
            "http://www.eaw1805.com/scenario/1805/nation/10",
            "http://www.eaw1805.com/scenario/1805/nation/11",
            "http://www.eaw1805.com/scenario/1805/nation/12",
            "http://www.eaw1805.com/scenario/1805/nation/13",
            "http://www.eaw1805.com/scenario/1805/nation/14",
            "http://www.eaw1805.com/scenario/1805/nation/15",
            "http://www.eaw1805.com/scenario/1805/nation/16",
            "http://www.eaw1805.com/scenario/1805/nation/17",
            "http://www.eaw1805.com/help/introduction",
            "http://www.eaw1805.com/help/economy",
            "http://www.eaw1805.com/help/trade",
            "http://www.eaw1805.com/help/politics",
            "http://www.eaw1805.com/help/units",
            "http://www.eaw1805.com/help/navy",
            "http://www.eaw1805.com/help/movement",
            "http://www.eaw1805.com/help/warfare",
            "http://www.eaw1805.com/help/espionage",
            "http://www.eaw1805.com/help/other"};

    /**
     * Scenario Pages.
     */
    static final String SCENARIO_PAGES = "http://www.eaw1805.com/scenario/1802/nation/";

    /**
     * Game Specific URL.
     */
    static final String GAME_URL = "http://www.eaw1805.com/scenario/xxx/game/yyy/info";

    /**
     * Game Specific URL.
     */
    static final String[] CLIENT_URL = {
            "http://www.eaw1805.com/cache/scenario/xxx/game/yyy/nation/zzz",
            "http://www.eaw1805.com/report/scenario/xxx/game/yyy/nation/zzz/overview",
            "http://www.eaw1805.com/report/scenario/xxx/game/yyy/nation/zzz/newsletter"};

    /**
     * The Generic Game Cache Name.
     */
    public static final String CACHE_NAME = "gameCache";

    /**
     * The User Cache.
     */
    public static final String USER_CACHE_NAME = "userCache";

    /**
     * The Game Cache.
     */
    public static final String GAME_CACHE_NAME = "game";

    /**
     * The Client Cache.
     */
    public static final String CLIENT_CACHE_NAME = "client";

    /**
     * Username.
     */
    public static final String USERNAME = "engine";

    /**
     * Password.
     */
    static final String PASSWORD = "eaw1805";


}
