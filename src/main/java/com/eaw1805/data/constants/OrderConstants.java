package com.eaw1805.data.constants;

/**
 * Constants related to Orders.
 */
public interface OrderConstants {

    /**
     * Home region sectors - percentage of citizens received from population reduction.
     */
    double HOME = 0.8d;

    /**
     * Home region sectors - percentage of citizens received from population reduction.
     */
    double SPHERE = 0.3d;

    /**
     * Foreign sectors - percentage of citizens received from population reduction.
     */
    double FOREIGN = 0.1d;

    /**
     * Colonial sectors - percentage of citizens received from population reduction.
     */
    double COLONIAL = 0.3d;

    /**
     * Harsh taxation.
     */
    int TAX_HARSH = 1;

    /**
     * Low taxation.
     */
    int TAX_LOW = -1;

    // ************************************
    // 1. RENAME
    // ************************************

    /**
     * Sequence of Order Rename Brigade.
     */
    int ORDER_REN_BRIG = 51;

    /**
     * Sequence of Order Rename Commander.
     */
    int ORDER_REN_COMM = 52;

    /**
     * Sequence of Order Rename Ship.
     */
    int ORDER_REN_SHIP = 53;

    /**
     * Sequence of Order Rename Army.
     */
    int ORDER_REN_ARMY = 54;

    /**
     * Sequence of Order Rename Corp.
     */
    int ORDER_REN_CORP = 55;

    /**
     * Sequence of Order Rename Fleet.
     */
    int ORDER_REN_FLT = 56;

    /**
     * Sequence of Order Rename Spy.
     */
    int ORDER_REN_SPY = 57;

    /**
     * Sequence of Order Rename Barrack.
     */
    int ORDER_REN_BARRACK = 58;

    /**
     * Sequence of Order rename baggage train.
     */
    int ORDER_REN_BTRAIN = 59;


    // ************************************
    // 2. Organize ARMY & FLEET
    // ************************************

    /**
     * Sequence of Order Commander hire from the pool.
     * (This is only for the client).
     */
    int ORDER_HIRE_COM = 198;

    /**
     * Sequence of Order Commander hire from the pool.
     */
    int ORDER_HIRE_COM_COL = 199;

    /**
     * Sequence of Order Demolish Corp.
     */
    int ORDER_D_CORP = 201;

    /**
     * Sequence of Order Build Corp.
     */
    int ORDER_B_CORP = 202;

    /**
     * Sequence of Order Add Brigade to Corp.
     */
    int ORDER_ADDTO_CORP = 203;

    /**
     * Sequence of Order Commander Join Corp.
     */
    int ORDER_CORP_COM = 204;

    /**
     * Sequence of Order Demolish Army.
     */
    int ORDER_D_ARMY = 211;

    /**
     * Sequence of Order Build Army.
     */
    int ORDER_B_ARMY = 212;

    /**
     * Sequence of Order Add Corp to Army.
     */
    int ORDER_ADDTO_ARMY = 213;

    /**
     * Sequence of Order Commander Join Army.
     */
    int ORDER_ARMY_COM = 214;

    /**
     * Sequence of Order Commander leave Army or Corp.
     */
    int ORDER_LEAVE_COM = 223;

    /**
     * Sequence of Order Commander Dismiss to the pool.
     */
    int ORDER_DISS_COM = 224;

    /**
     * Sequence of Order Add Battalion to Brigade, aka, Exchange Battalions between Brigades.
     */
    int ORDER_ADDTO_BRIGADE = 231;

    /**
     * Sequence of Order Demolish Fleet.
     */
    int ORDER_D_FLT = 241;

    /**
     * Build Fleet
     */
    int ORDER_B_FLT = 242;

    /**
     * Sequence of Order Ship Join Fleet.
     */
    int ORDER_ADDTO_FLT = 243;

    // ************************************
    // 3. Increase Population
    // ************************************

    /**
     * Sequence of Order Increase Population Density.
     */
    int ORDER_INC_POP = 301;

    // ************************************
    // 4. Decrease Population
    // ************************************

    /**
     * Sequence of Order Decrease Population Density.
     */
    int ORDER_DEC_POP = 401;

    // ************************************
    // 5. Build production site
    // ************************************

    /**
     * Sequence of Order Build Production Site.
     */
    int ORDER_B_PRODS = 501;

    // ************************************
    // 6. Demolish production site
    // ************************************

    /**
     * Sequence of Order Demolish Production Site.
     */
    int ORDER_D_PRODS = 601;


    // ************************************
    // 7. Troop Maintenance
    // ************************************

    /**
     * Sequence of Order Merge Battalions.
     */
    int ORDER_MRG_BATT = 701;

    /**
     * Sequence of Order Increase Headcount for brigades.
     */
    int ORDER_INC_HEADCNT = 702;

    /**
     * Sequence of Order Increase Experience.
     */
    int ORDER_INC_EXP = 703;

    /**
     * Sequence of Order Increase Headcount to all brigades in a Corps.
     */
    int ORDER_INC_HEADCNT_CORPS = 712;

    /**
     * Sequence of Order Increase Experience.
     */
    int ORDER_INC_EXP_CORPS = 713;

    /**
     * Sequence of Order Increase Headcount to all brigades in an Army.
     */
    int ORDER_INC_HEADCNT_ARMY = 722;

    /**
     * Sequence of Order Increase Experience.
     */
    int ORDER_INC_EXP_ARMY = 723;

    /**
     * Sequence of Order Build Additional Battalion.
     */
    int ORDER_ADD_BATT = 731;

    /**
     * Sequence of Order Build Battalion for brigade.
     */
    int ORDER_B_BATT = 751;

    /**
     * Sequence of Order Build Battalion for brigade at the colonies.
     */
    int ORDER_B_BATT_COL = 752;

    // ************************************
    // 8. Build baggage trains
    // ************************************

    /**
     * Sequence of Order Build Baggage Train.
     */
    int ORDER_B_BTRAIN = 801;

    // ************************************
    // 9. Build Ships
    // ************************************

    /**
     * Sequence of Order Build Ship.
     */
    int ORDER_B_SHIP = 901;

    // ************************************
    // 10. Repair ships & baggage trains
    // ************************************

    /**
     * Sequence of Order Repair Ship.
     */
    int ORDER_R_SHP = 1001;

    /**
     * Sequence of Order Repair Baggage Train.
     */
    int ORDER_R_BTRAIN = 1002;

    /**
     * Sequence of Order Repair Fleet.
     */
    int ORDER_R_FLT = 1003;

    // ************************************
    // 11. Disband troops/ships/trains
    // ************************************

    /**
     * Sequence of Order Scuttle Baggage Train.
     */
    int ORDER_SCUTTLE_BTRAIN = 1101;

    /**
     * Sequence of Order Scuttle Ship.
     */
    int ORDER_SCUTTLE_SHIP = 1102;

    /**
     * Sequence of Order Demolish Battalion.
     */
    int ORDER_D_BATT = 1103;

    /**
     * Sequence of Order Demolish Brigade.
     */
    int ORDER_D_BRIG = 1104;

    // ************************************
    // 12. LOAD UNLOAD TROOPS FIRST PHASE
    // ************************************

    /**
     * Sequence of Order Load Troops.
     */
    int ORDER_LOAD_TROOPSF = 1201;

    /**
     * Sequence of Order UnLoad Troops.
     */
    int ORDER_UNLOAD_TROOPSF = 1202;

    // ************************************
    // 13. TRADE FIRST PHASE
    // ************************************

    /**
     * Sequence of Order Load/Unload/Buy/Sell goods in the first phase.
     */
    int ORDER_EXCHF = 1301;

    // ************************************
    // 14. MOVEMENT
    // ************************************

    /**
     * Sequence of Order movement for all units.
     */
    int ORDER_M_UNIT = 1400;

    /**
     * Sequence of Order Movement for Brigades.
     */
    int ORDER_M_BRIG = 1401;

    /**
     * Sequence of Order Movement for Brigades (Forced March).
     */
    int ORDER_FM_BRIG = 1402;

    /**
     * Sequence of Order Movement for Corps.
     */
    int ORDER_M_CORP = 1403;

    /**
     * Sequence of Order Movement for Corps (Forced March).
     */
    int ORDER_FM_CORP = 1404;

    /**
     * Sequence of Order Movement for Armies.
     */
    int ORDER_M_ARMY = 1405;

    /**
     * Sequence of Order Movement for Armies (Forced March).
     */
    int ORDER_FM_ARMY = 1406;

    /**
     * Sequence of Order Movement for Commanders.
     */
    int ORDER_M_COMM = 1407;

    /**
     * Sequence of Order Movement for Spies.
     */
    int ORDER_M_SPY = 1408;

    /**
     * Sequence of Order Movement for Baggage Trains.
     */
    int ORDER_M_BTRAIN = 1409;

    /**
     * Sequence of Order Movement for Merchant Ships.
     */
    int ORDER_M_MSHIP = 1410;

    /**
     * Sequence of Order Movement for Ships.
     */
    int ORDER_M_SHIP = 1411;

    /**
     * Sequence of Order Movement for Fleets.
     */
    int ORDER_M_FLEET = 1412;

    /**
     * Sequence of Patrol Movement for Ships.
     */
    int ORDER_P_SHIP = 1413;

    /**
     * Sequence of Patrol Movement for Fleets.
     */
    int ORDER_P_FLEET = 1414;

    // ************************************
    // 16. LOAD UNLOAD TROOPS SECOND PHASE
    // ************************************

    /**
     * Sequence of Order Load Troops.
     */
    int ORDER_LOAD_TROOPSS = 1601;

    /**
     * Sequence of Order UnLoad Troops.
     */
    int ORDER_UNLOAD_TROOPSS = 1602;

    // ************************************
    // 17. TRADE SECOND PHASE
    // ************************************

    /**
     * Sequence of Order Load/Unload/Buy/Sell goods in the second phase.
     */
    int ORDER_EXCHS = 1701;

    // ************************************
    // 18. Handover
    // ************************************

    /**
     * Sequence of Order Handover Sector.
     */
    int ORDER_HOVER_SEC = 1801;

    /**
     * Sequence of Order Handover Ship.
     */
    int ORDER_HOVER_SHIP = 1802;

    // ************************************
    // 19. POLITICS
    // ************************************

    /**
     * Sequence of Order Change Political Relations.
     */
    int ORDER_POLITICS = 1901;

    // ************************************
    // 20. Taxation
    // ************************************

    /**
     * Sequence of Order Change Taxation.
     */
    int ORDER_TAXATION = 2001;

}
