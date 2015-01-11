package com.eaw1805.data.constants;

/**
 * Constants related to game status and scheduling.
 */
public interface GameConstants {

    /**
     * Game is ready.
     */
    String GAME_READY = "ready";

    /**
     * Game is being processed.
     */
    String GAME_PROC = "being processed";

    /**
     * Waiting for players.
     */
    String GAME_WAIT = "waiting for players";

    /**
     * Game is scheduled to be processed.
     */
    String GAME_SCHED = "scheduled to be processed";

    /**
     * Processing is Postponed.
     */
    String GAME_POST = "postponed";

    /**
     * Generating Game
     */
    String GAME_CREATE = "under construction";

    /**
     * Short duration -30% VPs to complete.
     */
    public static final int DURATION_SHORT = -1;

    /**
     * Normal duration.
     */
    public static final int DURATION_NORMAL = 0;

    /**
     * Long duration +30% VPs to complete.
     */
    public static final int DURATION_LONG = 1;

}
