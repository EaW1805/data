package com.eaw1805.data.constants;

/**
 * Constants for VP constants.
 */
public interface VPConstants {

    /**
     * Empires that signed an alliance.
     */
    int POLITICS_ALLIANCE = 4;

    /**
     * Empires that break an alliance.
     */
    int POLITICS_ALLIANCE_BREAK = -5;

    /**
     * Empires that declare war lose 12 VPs.
     */
    int POLITICS_WAR = -12;

    /**
     * Empires that declares war due to a call to Allies.
     */
    int POLITICS_WAR_CALL = -6;

    /**
     * Empires that refuses a call to Allies.
     */
    int POLITICS_WAR_CALL_REFUSE = -5;

    /**
     * Empires that make peace gain 4 VPs.
     */
    int POLITICS_PEACE = 6;

    /**
     * Empires that surrenders loses 15 VPs.
     */
    int POLITICS_SURRENDER = -15;

    /**
     * Empires that accepts surrender gains 30 VPs.
     */
    int POLITICS_SURRENDER_ACCEPT = 30;

    /**
     * Empires that accepts surrender when an ally still at war with same power lose 4VP/ally.
     */
    int POLITICS_SURRENDER_ACCEPT_OTHERS = -4;

    /**
     * Being at war for 8 months or more with an empire that goes into civil disorder..
     */
    int ENEMY_ENTERS_CD = 30;

    /**
     * Winning a large naval battle. per fleet involved (max 16).
     */
    int NB_MAJOR_WIN = 4;

    /**
     * Losing a large naval battle (also for allied fleets).
     * per fleet involved (max -16).
     */
    int NB_MAJOR_LOSE = -4;

    /**
     * Maximum fleet count for calculating VPs.
     */
    int NB_MAJOR_MAX = 4;

    /**
     * Winning a small naval battle. per fleet involved (max 8).
     */
    int NB_MINOR_WIN = 2;

    /**
     * Losing a small naval battle (also for allied fleets).
     * per fleet involved (max -8).
     */
    int NB_MINOR_LOSE = -2;

    /**
     * Maximum fleet count for calculating VPs.
     */
    int NB_MINOR_MAX = 4;

    /**
     * Winning a tactical battle (also for allied armies).
     * per corps involved (max 5).
     */
    int TB_WIN = 1;

    /**
     * Winning a tactical battle (also for allied armies).
     * per corps involved (max 5).
     */
    int TB_MAX = 5;

    /**
     * Losing a tactical battle (also for allied armies).
     * per corps involved (max 5).
     */
    int TB_LOSE = -1;

    /**
     * Commander makes it to max skill level.
     */
    int COMM_MAX_SKILL = 3;

    /**
     * Commander killed enemy during battle.
     */
    int COMM_KILL_OPPONENT = 1;

    /**
     * Commander lost during battle.
     */
    int COMM_LOST = -1;

    /**
     * Build Fortresses huge.
     */
    int BUILD_HUGE = 15;

    /**
     * Conquering Fortresses huge.
     */
    int CONQUER_HUGE = 4;

    /**
     * Conquering Fortresses large.
     */
    int CONQUER_LARGE = 2;

    /**
     * Losing Fortresses huge.
     */
    int LOSE_HUGE = -4;

    /**
     * Losing Fortresses large.
     */
    int LOSE_LARGE = -2;

    /**
     * Defend Fortresses huge.
     */
    int DEFEND_HUGE = 2;

    /**
     * Defend Fortresses huge.
     */
    int DEFEND_LARGE = 1;

    /**
     * Conquering an enemy capitol.
     */
    int CONQUER_CAPITAL = 4;

    /**
     * Regain capitol.
     */
    int RECONQUER_CAPITAL = 5;

    /**
     * Losing the capitol.
     */
    int LOSE_CAPITAL = -6;

    /**
     * Losing a foreign capitol.
     */
    int LOSE_F_CAPITAL = -4;

    /**
     * Conquering a trade city.
     */
    int CONQUER_TCITY = 3;

    /**
     * Losing a trade city.
     */
    int LOSE_TCITY = -3;

    /**
     * For each 2,000,000 Pounds aid received.
     */
    int TRANS_MONEY = -1;

    /**
     * For each 2,000,000 worth of materials received .
     */
    int TRANS_GOODS = -1;

    /**
     * Per 10,000,000 Pounds spend on populace.
     */
    int SPEND_MONEY = 1;

    /**
     * per 10,000 Industrial points spend on populace.
     */
    int SPEND_INDPT = 1;

    /**
     * per 500 Colonial Goods spend on populace.
     */
    int SPEND_COLONIAL = 1;

    /**
     * For each coordinate above 3 population handed over.
     */
    int SECTOR_HANDOVER = -1;

    /**
     * For each type 4 class ship handed over.
     */
    int SHIP_HANDOVER_4 = -1;

    /**
     * For each type 5 class ship handed over.
     */
    int SHIP_HANDOVER_5 = -3;

    /**
     * For each type 4 class ship scuttled.
     */
    int SHIP_SCUTTLED_4 = -1;

    /**
     * For each type 5 class ship scuttled.
     */
    int SHIP_SCUTTLED_5 = -3;

    /**
     * For every 40 non-neutral coordinates conquered beyond your home nation in europe.
     */
    int CONQUER_40_EUROPE = 1;

    /**
     * For every 90 neutral coordinates conquered beyond your home nation in europe.
     */
    int CONQUER_90_NEUTRAL = 1;

    /**
     * For every 60 colonial coordinates conquered.
     */
    int CONQUER_60_COLONIES = 1;

    /**
     * Conquer 2 enemy capitals.
     */
    int CONQUER_2_CAPITALS = 12;

    /**
     * Conquer 3 enemy capitals.
     */
    int CONQUER_3_CAPITALS = 24;

    /**
     * Conquer 4 enemy capitals.
     */
    int CONQUER_4_CAPITALS = 40;

    /**
     * Double coordinates (from starting coordinates) in Europe bonus (once only).
     */
    int DOUBLE_EUROPE = 8;

    /**
     * Triple coordinates (from starting coordinates) in Europe bonus (once only).
     */
    int TRIPLE_EUROPE = 18;

    /**
     * Start up a colony.
     */
    int STARTUP_COLONY = 8;

    /**
     * Kill 300,000 enemy troops in battles.
     */
    int KILL_300 = 7;

    /**
     * Kill 700,000 enemy troops in battles.
     */
    int KILL_700 = 16;

    /**
     * Kill 1,500,000 enemy troops in battles.
     */
    int KILL_1500 = 40;

    /**
     * Destroy/capture 30 enemy warships.
     */
    int SUNK_30 = 7;

    /**
     * Destroy/capture 70 enemy warships.
     */
    int SUNK_70 = 16;

    /**
     * Destroy/capture 150 enemy warships.
     */
    int SUNK_150 = 40;

    /**
     * Culture random event;
     */
    int VP_RE_CULT = 4;

    /**
     * US random event;
     */
    int VP_RE_DEAT = -3;

    /**
     * Enlightment random event;
     */
    int VP_RE_ENLI = 5;

    /**
     * Persia random event;
     */
    int VP_RE_PERS = -8;

    /**
     * Revolt random event;
     */
    int VP_RE_REVO = -8;

    /**
     * Scandal random event;
     */
    int VP_RE_SCAN = -4;

    /**
     * US random event;
     */
    int VP_RE_US = -8;
}
