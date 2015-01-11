package com.eaw1805.data.constants;

/**
 * Constants for all Player Profile entries.
 */
public interface ProfileConstants {

    /**
     * CREDITS won.
     */
    String CREDITS = "credits";

    /**
     * VP sum of all games. If a game winner, double the VP sum for player profile purposes.
     */
    String VPS = "vps";

    /**
     * Sum of all achievement points.
     */
    String ACHIEVEMENTS = "achievements";

    /**
     * Counter for the number of alliances made.
     */
    String ALLIANCES_MADE = "alliances.made";

    /**
     * Counter for the number of responds to calls from allies made.
     */
    String RESPOND_CALLALLIES = "respond.callallies";

    /**
     * Counter for the number of times refused a calls from an ally.
     */
    String REFUSE_CALLALLIES = "refuse.callallies";

    /**
     * Counter for the number of wars he declared.
     */
    String WARS_DECLARED = "wars.declared";

    /**
     * Counter for the number of wars that were declared upon him.
     */
    String WARS_RECEIVED = "wars.received";

    /**
     * Counter for the number he has gone to peace.
     */
    String PEACE_MADE = "peace.made";

    /**
     * Counter for the times he surrendered.
     */
    String SURRENDERS_MADE = "surrenders.made";

    /**
     * Counter for the times other players surrendered to him.
     */
    String SURRENDERS_ACCEPTED = "surrenders.accepted";

    /**
     * Reports the number of capitals conquered.
     */
    String CAPITAL_CONQUERED = "capital.conquered";

    /**
     * Reports the number of trade cities conquered.
     */
    String TCITY_CONQUERED = "tcity.conquered";

    /**
     * Reports the number of Level 2+ fortress conquered.
     */
    String FORTRESS_CONQUERED = "fortress.conquered";

    /**
     * Reports the number of Level 2+ fortress built.
     */
    String FORTRESS_BUILT = "fortress.built";

    /**
     * Reports the number of colonies setup.
     */
    String STARTUP_COLONY = "startup.colony";

    /**
     * Reports the number of Empires played.
     */
    String EMPIRES_PLAYED = "empires.played";

    /**
     * Reports the number of Empires that were declared dead while at war with his com.eaw1805.
     */
    String EMPIRES_DESTROYED = "empires.destroyed";

    /**
     * Reports the largest income the player made in a single turn (taxation).
     */
    String INCOME_HIGHEST = "income.highest";

    /**
     * Reports the largest income the player made in a single turn (trading).
     */
    String TRADE_HIGHEST = "trade.highest";

    /**
     * Reports the total number of battalions build by this player ever.
     */
    String BATT_HIGHEST = "batt.highest";

    /**
     * The largest infantry force this player ever made (battalions).
     */
    String FORCE_INFANTRY = "force.infantry";

    /**
     * The largest cavalry force this player ever made (battalions).
     */
    String FORCE_CAVALRY = "force.cavalry";

    /**
     * The largest artillery force this player ever made (battalions).
     */
    String FORCE_ARTILLERY = "force.artillery";

    /**
     * The largest number of class XXX ships employed by this player.
     */
    String FORCE_SHIP = "force.ship.";

    /**
     * The largest number of class 1 ships employed by this player.
     */
    String FORCE_SHIP_1 = "force.ship.1";

    /**
     * The largest number of class 2 ships employed by this player.
     */
    String FORCE_SHIP_2 = "force.ship.2";

    /**
     * The largest number of class 1 ships employed by this player.
     */
    String FORCE_SHIP_3 = "force.ship.3";

    /**
     * The largest number of class 4 ships employed by this player.
     */
    String FORCE_SHIP_4 = "force.ship.4";

    /**
     * The largest number of class 5 ships employed by this player.
     */
    String FORCE_SHIP_5 = "force.ship.5";

    /**
     * The total of all land battles he engaged in every game he was in.
     */
    String BATTLES_TACTICAL = "battles.tactical";

    /**
     * The total of all sea battles he engaged in every game he was in.
     */
    String BATTLES_NAVAL = "battles.naval";

    /**
     * The total of all field battles he engaged in every game he was in.
     */
    String BATTLES_FIELD = "battles.field";

    /**
     * The total of all land battles he engaged in every game he was in.
     */
    String BATTLES_TACTICAL_WON = "battles.tactical.won";

    /**
     * The total of all sea battles he engaged in every game he was in.
     */
    String BATTLES_NAVAL_WON = "battles.naval.won";

    /**
     * The total of all field battles he engaged in every game he was in.
     */
    String BATTLES_FIELD_WON = "battles.field.won";

    /**
     * The total of all land battles he engaged in every game he was in.
     */
    String BATTLES_TACTICAL_LOST = "battles.tactical.lost";

    /**
     * The total of all sea battles he engaged in every game he was in.
     */
    String BATTLES_NAVAL_LOST = "battles.naval.lost";

    /**
     * The total of all field battles he engaged in every game he was in.
     */
    String BATTLES_FIELD_LOST = "battles.field.lost";

    /**
     * The total of all land battles he engaged in every game that were indecisive.
     */
    String BATTLES_TACTICAL_DRAW = "battles.tactical.draw";

    /**
     * The total of all sea battles he engaged in every game that were indecisive.
     */
    String BATTLES_NAVAL_DRAW = "battles.naval.draw";

    /**
     * The total of all field battles he engaged in every game that were indecisive.
     */
    String BATTLES_FIELD_DRAW = "battles.field.draw";

    /**
     * The total of all casualties he inflicted in tactical or field battles.
     */
    String ENEMY_KILLED_ALL = "battles.killed.all";

    /**
     * The total of all infantry casualties he inflicted in tactical or field battles.
     */
    String ENEMY_KILLED_INF = "battles.killed.inf";

    /**
     * The total of all cavalry casualties he inflicted in tactical or field battles.
     */
    String ENEMY_KILLED_CAV = "battles.killed.cav";

    /**
     * The total of all artillery casualties he inflicted in tactical or field battles.
     */
    String ENEMY_KILLED_ENG = "battles.killed.eng";

    /**
     * The total of all marines casualties he inflicted in naval battles.
     */
    String ENEMY_KILLED_MAR = "battles.killed.mar";

    /**
     * The total of all enemy commanders killed or captured in all games.
     */
    String ENEMY_KILLED_COM = "battles.killed.com";

    /**
     * The total of all prisoners of war this player has captured in all games.
     */
    String ENEMY_PRISONERS = "battles.prisoners";

    /**
     * The total of all ships sunk or captured.
     */
    String ENEMY_SUNK_ALL = "battles.sunk.all";

    /**
     * The total of all merchant ships sunk or captured.
     */
    String ENEMY_SUNK_0 = "battles.sunk.0";

    /**
     * The total of all class 1 ships sunk or captured.
     */
    String ENEMY_SUNK_1 = "battles.sunk.1";

    /**
     * The total of all class 2 ships sunk or captured.
     */
    String ENEMY_SUNK_2 = "battles.sunk.2";

    /**
     * The total of all class 3 ships sunk or captured.
     */
    String ENEMY_SUNK_3 = "battles.sunk.3";

    /**
     * The total of all class 4 ships sunk or captured.
     */
    String ENEMY_SUNK_4 = "battles.sunk.4";

    /**
     * The total of all class 5 ships sunk or captured.
     */
    String ENEMY_SUNK_5 = "battles.sunk.5";

    /**
     * Reports all eponymous newsletter written.
     */
    String NEWSLETTER_EPONYMOUS = "newsletter.eponymous";

    /**
     * Reports all eponymous newsletter written.
     */
    String FORUM_POSTS = "forum.posts";

    /**
     * Your Empire fights until Civil Disorder.
     */
    int FIGHT_UNTIL_CD = 50;

    /**
     * Declared "Survivor" in a finished game: +150 VPs.
     */
    int SURVIVOR = 50;

    /**
     * Declared "Runner up" in a finished game: +200 VPs.
     */
    int RUNNERUP = 200;

    /**
     * Declared "Winner" or "Co-Winner" in a finished game: +250 VPs.
     */
    int WINNER = 250;

    /**
     * Number of turns played.
     */
    String TURNS_PLAYED = "turns.played";

    /**
     * Number of solo turns played.
     */
    String TURNS_PLAYED_SOLO = "turns.played.solo";

}
