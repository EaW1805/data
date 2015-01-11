package com.eaw1805.data.constants;

/**
 * Constants related to Reporting.
 */
public interface ReportConstants {

    /**
     * Constant for reporting army statistics.
     */
    String A_TOT_MONEY = "armies.totalMoney";

    /**
     * Constant for reporting army statistics.
     */
    String A_TOT_FOOD = "armies.totalFood.region.";

    /**
     * Constant for reporting army statistics.
     */
    String A_TOT_BAT = "armies.battalions.total";

    /**
     * Constant for reporting army statistics.
     */
    String A_TOT_BAT_UNPD = "armies.battalions.unpaid.";

    /**
     * Constant for reporting army statistics.
     */
    String A_TOT_SOLDIERS = "armies.soldiers.total";

    /**
     * Constant for reporting army statistics.
     */
    String A_TOT_SLDR_REG = "armies.soldiers.total.region.";

    /**
     * Constant for reporting army statistics.
     */
    String A_TOT_SLDR_TPE = "armies.soldiers.total.type.";

    /**
     * Constant for reporting army statistics.
     */
    String A_TOT_STARV_QTE = "armies.soldiers.starving.qte";

    /**
     * Constant for reporting army statistics.
     */
    String A_TOT_STARV_DES = "armies.soldiers.starving.deserted";

    /**
     * Constant for reporting army statistics.
     */
    String A_TOT_UNPAID = "armies.soldiers.unpaid";

    /**
     * Constant for reporting army statistics.
     */
    String A_TOT_KILLS = "armies.kill";

    /**
     * Constant for reporting army statistics.
     */
    String A_TOT_DEATHS = "armies.deaths";

    /**
     * Constant for reporting army statistics.
     */
    String A_BRIGADE = ".brigade.";

    /**
     * Constant for reporting army statistics.
     */
    String A_TYPE = ".type.";

    /**
     * Constant for reporting army statistics.
     */
    String A_UNPAID = ".unpaid.";

    /**
     * Constant for reporting ship statistics.
     */
    String S_TOT_MARINES = "ships.marines.total";

    /**
     * Constant for reporting ship statistics.
     */
    String S_TOT_SHIPS = "ships.total";

    /**
     * Constant for reporting ship statistics.
     */
    String S_TOT_UNPD = "ships.unpaid";

    /**
     * Constant for reporting ship statistics.
     */
    String S_TOT_UNPD_REP = "ships.unpaid.";

    /**
     * Constant for reporting ship statistics.
     */
    String S_TOT_UNPD_NAME = ".name.";

    /**
     * Constant for reporting ship statistics.
     */
    String S_TOT_UNPD_TPE = ".type.";

    /**
     * Constant for reporting ship statistics.
     */
    String S_TOT_CANNONS = "ships.cannons";

    /**
     * Constant for reporting ship statistics.
     */
    String S_TOT_MONEY = "ships.totalMoney";

    /**
     * Constant for reporting ship statistics.
     */
    String S_TOT_WINE = "ships.totalWine.region.";

    /**
     * Constant for reporting ship statistics.
     */
    String S_SOBMRNS_QTE = "ships.soberMarines.total";

    /**
     * Constant for reporting ship statistics.
     */
    String S_SOBMRNS_COST = "ships.soberMarines.cost";

    /**
     * Constant for reporting sinked ships (casualties received).
     */
    String S_SINKED = "ships.sinked";

    /**
     * Constant for reporting ship statistics (casualites inflicted).
     */
    String S_SINKS = "ships.sinks";

    /**
     * Constant for reporting number of sectors per region.
     */
    String E_SEC_SIZE_TOT = "sectors.size";

    /**
     * Constant for reporting number of sectors per region.
     */
    String E_SEC_SIZE = "sectors.size.region.";

    /**
     * Constant for reporting total population per type.
     */
    String E_POP_TYPE = "population.size.type.";

    /**
     * Constant for reporting total population per region.
     */
    String E_POP_SIZE = "population.size.region.";

    /**
     * Constant for reporting population increase per region.
     */
    String E_POP_INC = "population.increase.region.";

    /**
     * Constant for reporting food required by the population per region.
     */
    String E_POP_FOOD = "population.totalFood.region.";

    /**
     * Constant for reporting the sectors that were not properly fed per region.
     */
    String E_POP_STRV = "population.starving.region.";

    /**
     * Constant for reporting sectors that were reduced per region.
     */
    String E_POP_RDC = "population.reduced.region.";

    /**
     * Constant for reporting warehouses per region.
     */
    String W_REGION = "warehouse.region.";

    /**
     * Constant for reporting warehouse goods.
     */
    String W_GOOD = ".good.";

    /**
     * Constant for reporting dead empires.
     */
    String N_ALIVE = "nation.alive";

    /**
     * Constant for reporting VPs.
     */
    String N_VP = "nation.vp";

    /**
     * Constant for reporting army statistics.
     */
    String P_TOT = "prisoners";

    /**
     * Constant for food cost.
     */
    String P_NATION = ".nation.";

    /**
     * Constant for food cost.
     */
    String P_FOOD = ".food";

    /**
     * Constant for random event -- booming economy.
     */
    String RE_BOOM = "random.event.booming";

    /**
     * Constant for random event -- Corruption in military.
     */
    String RE_CORR = "random.event.corruption";

    /**
     * Constant for random event -- Diplomatic Crisis.
     */
    String RE_CRIS = "random.event.cris";

    /**
     * Constant for random event -- Culture.
     */
    String RE_CULT = "random.event.culture";

    /**
     * Constant for random event -- A Notable has died.
     */
    String RE_DEAT = "random.event.death";

    /**
     * Constant for random event -- Trade Deficit.
     */
    String RE_DEFI = "random.event.deficit";

    /**
     * Constant for random event -- Desertions.
     */
    String RE_DESE = "random.event.desertions";

    /**
     * Constant for random event -- Enlightment.
     */
    String RE_ENLI = "random.event.enlightment";

    /**
     * Constant for random event -- Excellent harvest.
     */
    String RE_HARV = "random.event.harvest";

    /**
     * Constant for random event -- Nationalism.
     */
    String RE_NATI = "random.event.nationalism";

    /**
     * Constant for random event -- Persia attacks.
     */
    String RE_PERS = "random.event.persia";

    /**
     * Constant for random event -- Natives Raid.
     */
    String RE_RAID = "random.event.raid";

    /**
     * Constant for random event -- Natives Royalists Revolt.
     */
    String RE_REVO = "random.event.revolt";

    /**
     * Constant for random event -- Political Scandal.
     */
    String RE_SCAN = "random.event.scandal";

    /**
     * Constant for random event -- Manpower shortage.
     */
    String RE_SHOR = "random.event.shortage";

    /**
     * Constant for random event -- Sickness.
     */
    String RE_SICK = "random.event.sick";

    /**
     * Constant for random event -- Workers on strike.
     */
    String RE_STRI = "random.event.strike";

    /**
     * Constant for random event -- Trade Surplus.
     */
    String RE_SURP = "random.event.surplus";

    /**
     * Constant for random event -- US at war.
     */
    String RE_US = "random.event.us";

    /**
     * Constant for reporting trade statistics.
     */
    String TRADE_TOT_MONEY = "trade.totalMoney";

}
