package com.eaw1805.data.constants;

/**
 * Constants related to Regions.
 */
public interface RegionConstants {

    /**
     * The identity for europe.
     */
    int EUROPE = 1;

    /**
     * The identity for caribbean.
     */
    int CARIBBEAN = 2;

    /**
     * The identity for indies.
     */
    int INDIES = 3;

    /**
     * The identity for africa.
     */
    int AFRICA = 4;

    /**
     * The first region.
     */
    int REGION_FIRST = 1;

    /**
     * The first region.
     */
    int REGION_COL_FRST = 2;

    /**
     * The last region.
     */
    int REGION_LAST = 4;

    /**
     * Scenario 1804: Home region sectors - percentage of citizens received from population reduction.
     */
    int REGION_1804_SIZE_X[] = {36, 40, 40, 40};
    int REGION_1804_SIZE_Y[] = {38, 30, 30, 30};

    int REGION_1804_MAX_X = 40;
    int REGION_1804_MAX_Y = 38;

    int MAP_1804_DIMENSIONS[][] = {
            {0, 2112, 2560, 0, 0},
            {0, 2432, 1920, 0, 0}
    };

    /**
     * Scenario 1805: Home region sectors - percentage of citizens received from population reduction.
     */
    int REGION_1805_SIZE_X[] = {82, 40, 40, 40};
    int REGION_1805_SIZE_Y[] = {77, 30, 30, 30};

    int REGION_1805_MAX_X = 82;
    int REGION_1805_MAX_Y = 77;

    int MAP_1805_DIMENSIONS[][] = {
            {0, 5248, 2560, 2560, 2560},
            {0, 4928, 1920, 1920, 1920}
    };


    /**
     * Scenario 1808: Home region sectors - percentage of citizens received from population reduction.
     */
    int REGION_1808_SIZE_X[] = {50, 0, 0, 0};
    int REGION_1808_SIZE_Y[] = {40, 0, 0, 0};

    int REGION_1808_MAX_X = 50;
    int REGION_1808_MAX_Y = 40;

    int MAP_1808_DIMENSIONS[][] = {
            {0, 3200, 0, 0, 0},
            {0, 2560, 0, 0, 0}
    };

}
