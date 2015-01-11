package com.eaw1805.data.constants;

/**
 * Constants related to Maintenance.
 */
public interface MaintenanceConstants {

    /**
     * The number of soldiers fed by 1 food unit.
     */
    double FOOD_RATE_SOL = 800d;

    /**
     * The number of people fed by 1 food unit.
     */
    double FOOD_RATE_CIV = 1000d;

    /**
     * The number of prisoners fed by 1 food unit.
     */
    double FOOD_RATE_PRI = 2000d;

    /**
     * The number of marines fed by 1 wine unit.
     */
    double WINE_RATE = 1000d;

    /**
     * Maximum number of workers to calculate attrition.
     */
    int MAX_WORKERS = 1500;

    /**
     * Rate for paying starving marines.
     */
    int STARVING_COST = 10000;

}
