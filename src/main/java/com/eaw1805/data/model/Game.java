package com.eaw1805.data.model;


import com.eaw1805.data.HibernateUtil;
import com.eaw1805.data.constants.GameConstants;

import java.io.Serializable;
import java.util.Date;

/**
 * Game object holds all meta-data for the game itself.
 */
public class Game implements Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD

    public static final int BET_SHARING_WINNERS = 1;
    public static final int BET_SHARING_WINNERS_RUNNERUPS = 2;
    public static final int BET_SHARING_SURVIVORS = 3;

    public static final int TYPE_SHORT = -1;
    public static final int TYPE_NORMAL = 0;
    public static final int TYPE_EPIC = 1;

    /**
     * Game's ID.
     */
    private int gameId;

    /**
     * Scenario ID.
     */
    private int scenarioId;

    /**
     * The current turn of the game.
     */
    private int turn;

    /**
     * The date the game started.
     */
    private Date dateStart;

    /**
     * The date of the last process.
     */
    private Date dateLastProc;

    /**
     * The date of the next process.
     */
    private Date dateNextProc;

    /**
     * The status of the game.
     */
    private String status;

    /**
     * The schedule as periodicity in number of days.
     */
    private int schedule;

    /**
     * The schedule as a cron expression.
     */
    private String cronSchedule;

    /**
     * The description of the schedule as a cron expression.
     */
    private String cronScheduleDescr;

    /**
     * If the game has ended.
     */
    private boolean ended;

    /**
     * The winning nations.
     */
    private String winners;

    /**
     * The co-winning nations.
     */
    private String coWinners;

    /**
     * The runner-up nations.
     */
    private String runnerUp;

    /**
     * The discount ALL nations have for this game.
     * Default 0%.
     */
    private int discount;

    /**
     * The forum for this game.
     */
    private int forumId;

    /**
     * The description of the game.
     */
    private String description;

    /**
     * The creator of the game.
     */
    private int userId;

    /**
     * The VPs each player has to bet in order to play.
     */
    private int bet;

    /**
     * Indicator about who will win the bet.
     * 1: Only the winners share the bet.
     * 2: Winners and runner ups share the bet.
     * 3: Winner, runner ups and survivors share the bet.
     */
    private int betSharing;

    /**
     * Indicator if field battles are enabled in this game.
     */
    private boolean fieldBattle;

    /**
     * Indicator if random events are enabled in this game.
     */
    private boolean randomEvents;

    /**
     * Indicator if fog of war is enabled in this game.
     */
    private boolean fogOfWar;

    /**
     * Indicator if the game is private or public.
     * True if the game is private.
     */
    private boolean privateGame;

    /**
     * The VPs required for a player to join a game.
     */
    private int vpsToJoin;

    /**
     * The name of the game.
     */
    private String name;

    /**
     * Indicator for the length of the game.
     * Values:
     * -1: SHORT
     * 0 : NORMAL
     * +1: EPIC
     */
    private int type;

    /**
     * Indicator if the taxation is boosted or normal.
     * Values:
     * false : normal taxation.
     * true : boosted taxation.
     */
    private boolean boostedTaxation;

    /**
     * Indicator if the production is boosted or normal.
     * Values:
     * false : normal production.
     * true : boosted production.
     */
    private boolean boostedProduction;

    /**
     * Indicator if the population growth is fast or normal.
     * Values:
     * false : normal population growth.
     * true : fast population growth.
     */
    private boolean fastPopulationGrowth;

    /**
     * Indicator if the command and admin points are boosted or normal.
     * Values :
     * false : normal command and admin points.
     * true : boosted command and admin points.
     */
    private boolean boostedCAPoints;

    /**
     * Indicator if the casualties in battles are fierce or normal.
     * Values:
     * false : normal casualties.
     * true : fierce casualties.
     */
    private boolean fierceCasualties;


    /**
     * Indicator if the appointment of commanders is fast or normal.
     * Values:
     * false : normal appointment of commanders.
     * true : fast appointment of commanders.
     */
    private boolean fastAppointmentOfCommanders;

    /**
     * Indicator if the arrival of commanders is extended or normal.
     * Values:
     * false : normal arrival of commanders.
     * true : extended arrival of commanders.
     */
    private boolean extendedArrivalOfCommanders;

    /**
     * Indicator if mps at colonies are full or half.
     * Values :
     * false : half mps at colonies.
     * true : full mps at colonies.
     */
    private boolean fullMpsAtColonies;

    /**
     * Indicator if the weather is always summer or standard.
     * Values:
     * false : the weather is standard.
     * true : the weather is always summer, no storms.
     */
    private boolean alwaysSummerWeather;

    /**
     * Indicator of ship construction is fast or normal.
     * Values :
     * false : normal ship construction.
     * true : fast ship construction.
     */
    private boolean fastShipConstruction;

    /**
     * Indicator if the espionage is extended or standard.
     * Values :
     * false : standard espionage.
     * true : extended espionage.
     */
    private boolean extendedEspionage;

    /**
     * Indicator if fortress construction is fast or standard.
     * Values :
     * false : standard fortress construction.
     * true : fast fortress construction (1 turn).
     */
    private boolean fastFortressConstruction;

    /**
     * Indicator if rumors are enabled or not.
     */
    private boolean rumorsEnabled;

    /**
     * Indicator if costs are doubled for land forces.
     */
    private boolean doubleCostsArmy;

    /**
     * Indicator if costs are doubled for naval forces.
     */
    private boolean doubleCostsNavy;

    /**
     * Get the Identification number of the game.
     *
     * @return the identification number of the game.
     */
    public int getGameId() {
        return gameId;
    }

    /**
     * Set the identification number of the game.
     *
     * @param identity the identification number of the game.
     */
    public void setGameId(final int identity) {
        this.gameId = identity;
    }

    /**
     * Get the Scenario ID.
     *
     * @return the Scenario ID.
     */
    public int getScenarioId() {
        return scenarioId;
    }


    /**
     * Get the scenarios id string representation.
     *
     * @return The string representation of scenario id.
     */
    public String getScenarioIdToString() {
        if (scenarioId == HibernateUtil.DB_FREE) {
            return "1804";

        } else if (scenarioId == HibernateUtil.DB_S1) {
            return "1802";

        } else if (scenarioId == HibernateUtil.DB_S2) {
            return "1805";

        } else if (scenarioId == HibernateUtil.DB_S3) {
            return "1808";

        }
        return "1805";
    }

    /**
     * Set the Scenario ID.
     *
     * @param value the Scenario ID.
     */
    public void setScenarioId(final int value) {
        this.scenarioId = value;
    }

    /**
     * The current turn number.
     *
     * @return the turn number of the game.
     */
    public int getTurn() {
        return turn;
    }

    /**
     * Set the turn number of the game.
     *
     * @param thisTurn the number of the turn.
     */
    public void setTurn(final int thisTurn) {
        this.turn = thisTurn;
    }

    /**
     * Get the date the game started.
     *
     * @return the date the game started.
     */
    public Date getDateStart() {
        return dateStart;
    }

    /**
     * Set the date the game started.
     *
     * @param value the date the game started.
     */
    public void setDateStart(final Date value) {
        this.dateStart = value;
    }

    /**
     * Get the date of the last processing.
     *
     * @return the date of the last processing.
     */
    public Date getDateLastProc() {
        return dateLastProc;
    }

    /**
     * Set the date of the last processing.
     *
     * @param value the date of the last processing.
     */
    public void setDateLastProc(final Date value) {
        this.dateLastProc = value;
    }

    /**
     * Get the date of the next processing.
     *
     * @return the date of the next processing.
     */
    public Date getDateNextProc() {
        return dateNextProc;
    }

    /**
     * Set the date of the next processing.
     *
     * @param value the date of the next processing.
     */
    public void setDateNextProc(final Date value) {
        this.dateNextProc = value;
    }

    /**
     * Get the status of the game.
     *
     * @return the status of the game.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Set the status of the game.
     *
     * @param value the status of the game.
     */
    public void setStatus(final String value) {
        this.status = value;
    }


    /**
     * Get the schedule as periodicity in number of days.
     *
     * @return the schedule as periodicity in number of days.
     */
    public int getSchedule() {
        return schedule;
    }

    /**
     * Set the schedule as periodicity in number of days.
     *
     * @param value the schedule as periodicity in number of days.
     */
    public void setSchedule(final int value) {
        this.schedule = value;
    }

    /**
     * Get the schedule as a cron expression.
     *
     * @return the schedule as a cron expression.
     */
    public String getCronSchedule() {
        return cronSchedule;
    }

    /**
     * Set the schedule as a cron expression.
     *
     * @param value the schedule as a cron expression.
     */
    public void setCronSchedule(final String value) {
        this.cronSchedule = value;
    }

    /**
     * Get the description of the schedule as a cron expression.
     *
     * @return the description of the schedule as a cron expression.
     */
    public String getCronScheduleDescr() {
        return cronScheduleDescr;
    }

    /**
     * Set the description of the schedule as a cron expression.
     *
     * @param value the description of the schedule as a cron expression.
     */
    public void setCronScheduleDescr(final String value) {
        this.cronScheduleDescr = value;
    }

    /**
     * Get the game has ended flag.
     *
     * @return the game has ended flag.
     */
    public boolean getEnded() {
        return ended;
    }

    /**
     * Set the game has ended flag.
     *
     * @param value the game has ended flag.
     */
    public void setEnded(final boolean value) {
        this.ended = value;
    }

    /**
     * Get the winning nations as a comma separated string.
     *
     * @return the winning nations as a comma separated string.
     */
    public String getWinners() {
        return winners;
    }

    /**
     * Set the winning nations as a comma separated string.
     *
     * @param value the winning nations as a comma separated string.
     */
    public void setWinners(final String value) {
        this.winners = value;
    }

    /**
     * Get the co-winning nations as a comma separated string.
     *
     * @return the co-winning nations as a comma separated string.
     */
    public String getCoWinners() {
        return coWinners;
    }

    /**
     * Set the co-winning nations as a comma separated string.
     *
     * @param value the co-winning nations as a comma separated string.
     */
    public void setCoWinners(final String value) {
        this.coWinners = value;
    }

    /**
     * Get the runners-up nations as a comma separated string.
     *
     * @return the runners-up nations as a comma separated string.
     */
    public String getRunnerUp() {
        return runnerUp;
    }

    /**
     * Set the runners-up nations as a comma separated string.
     *
     * @param value the runners-up nations as a comma separated string.
     */
    public void setRunnerUp(final String value) {
        this.runnerUp = value;
    }

    /**
     * Get the game wide discount.
     *
     * @return the game wide discount.
     */
    public int getDiscount() {
        return discount;
    }

    /**
     * The game wide discount.
     *
     * @param value the game wide discount.
     */
    public void setDiscount(final int value) {
        discount = value;
    }

    /**
     * Get the forum for this game.
     *
     * @return the forum for this game.
     */
    public int getForumId() {
        return forumId;
    }

    /**
     * Set the forum for this game.
     *
     * @param value the forum for this game.
     */
    public void setForumId(final int value) {
        this.forumId = value;
    }

    /**
     * Get the description of the game.
     *
     * @return the description of the game.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the description of the game.
     *
     * @param value the description of the game.
     */
    public void setDescription(final String value) {
        this.description = value;
    }

    /**
     * Get the creator of the game.
     *
     * @return The creator.
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Set the creator of the game.
     *
     * @param value The value to set.
     */
    public void setUserId(final int value) {
        this.userId = value;
    }

    /**
     * Get the number of VPs the player has to bet in order to play in this game.
     *
     * @return The number of VPs to bet.
     */
    public int getBet() {
        return bet;
    }

    /**
     * Set the number of VPs the player has to bet in order to play in this game.
     *
     * @param value The value to set.
     */
    public void setBet(final int value) {
        this.bet = value;
    }

    /**
     * Get the indicator about who will share the VPs.
     *
     * @return Who will share the vps.
     */
    public int getBetSharing() {
        return betSharing;
    }

    /**
     * Set the indicator about who will share the VPs.
     *
     * @param value The value to set.
     */
    public void setBetSharing(final int value) {
        this.betSharing = value;
    }


    /**
     * Get if field battle is enabled for this game.
     *
     * @return True if field battle is enabled.
     */
    public boolean isFieldBattle() {
        return fieldBattle;
    }

    /**
     * Set if field battle is enabled for this game.
     *
     * @param value The value to set.
     */
    public void setFieldBattle(final boolean value) {
        this.fieldBattle = value;
    }

    /**
     * Get if random events are enabled for this game.
     *
     * @return True if field battle is enabled.
     */
    public boolean isRandomEvents() {
        return randomEvents;
    }

    /**
     * Set if random events are enabled for this game.
     *
     * @param value The value to set.
     */
    public void setRandomEvents(final boolean value) {
        this.randomEvents = value;
    }

    /**
     * Get if fog of war is enabled for this game.
     *
     * @return True if field battle is enabled.
     */
    public boolean isFogOfWar() {
        return fogOfWar;
    }

    /**
     * Set if fog of war is enabled for this game.
     *
     * @param value The value to set.
     */
    public void setFogOfWar(final boolean value) {
        this.fogOfWar = value;
    }

    /**
     * Get if the game is private.
     *
     * @return True if the game is private.
     */
    public boolean isPrivateGame() {
        return privateGame;
    }

    /**
     * Set if the game is private.
     *
     * @param value The value to set.
     */
    public void setPrivateGame(final boolean value) {
        this.privateGame = value;
    }

    /**
     * Get the points required for a player to join.
     *
     * @return The minimum vps to join.
     */
    public int getVpsToJoin() {
        return vpsToJoin;
    }

    /**
     * Set the minimum VPs required for players to join the game.
     *
     * @param value The value to set.
     */
    public void setVpsToJoin(final int value) {
        this.vpsToJoin = value;
    }

    /**
     * Get the name of the game.
     *
     * @return The name of the game.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the game.
     *
     * @param value The value to set.
     */
    public void setName(final String value) {
        this.name = value;
    }

    /**
     * Get the type of the game.
     *
     * @return The type of the game.
     */
    public int getType() {
        return type;
    }

    /**
     * Set the type of the game.
     *
     * @param value The value to set.
     */
    public void setType(final int value) {
        this.type = value;
    }

    /**
     * Get if taxation is boosted.
     *
     * @return If taxation is boosted.
     */
    public boolean isBoostedTaxation() {
        return boostedTaxation;
    }

    /**
     * Set if taxation is boosted.
     *
     * @param value The value to set.
     */
    public void setBoostedTaxation(final boolean value) {
        this.boostedTaxation = value;
    }

    /**
     * Get if production is boosted.
     *
     * @return If production is boosted.
     */
    public boolean isBoostedProduction() {
        return boostedProduction;
    }

    /**
     * Set if production is boosted.
     *
     * @param value The value to set.
     */
    public void setBoostedProduction(final boolean value) {
        this.boostedProduction = value;
    }

    /**
     * Get if population growth is fast.
     *
     * @return If population growth is fast.
     */
    public boolean isFastPopulationGrowth() {
        return fastPopulationGrowth;
    }

    /**
     * Set if population growth is fast.
     *
     * @param value The value to set.
     */
    public void setFastPopulationGrowth(final boolean value) {
        this.fastPopulationGrowth = value;
    }

    /**
     * Get if A/C points are boosted.
     *
     * @return If A/C points are boosted.
     */
    public boolean isBoostedCAPoints() {
        return boostedCAPoints;
    }

    /**
     * Set if A/C points are boosted.
     *
     * @param value The value to set.
     */
    public void setBoostedCAPoints(final boolean value) {
        this.boostedCAPoints = value;
    }

    /**
     * Get if casulaties are fierce.
     *
     * @return If casualties are fierce.
     */
    public boolean isFierceCasualties() {
        return fierceCasualties;
    }

    /**
     * Set if casualties are fierce.
     *
     * @param value The value to set.
     */
    public void setFierceCasualties(final boolean value) {
        this.fierceCasualties = value;
    }

    /**
     * Get if appointment of commanders is fast.
     *
     * @return If appointment of commanders is fast.
     */
    public boolean isFastAppointmentOfCommanders() {
        return fastAppointmentOfCommanders;
    }

    /**
     * Set if appointment of commanders is fast.
     *
     * @param value The value to set.
     */
    public void setFastAppointmentOfCommanders(final boolean value) {
        this.fastAppointmentOfCommanders = value;
    }

    /**
     * Get if arrival of commanders is extended.
     *
     * @return If arrival of commanders is extended;
     */
    public boolean isExtendedArrivalOfCommanders() {
        return extendedArrivalOfCommanders;
    }

    /**
     * Set if arrival of commanders is extended.
     *
     * @param value The value to set.
     */
    public void setExtendedArrivalOfCommanders(final boolean value) {
        this.extendedArrivalOfCommanders = value;
    }

    /**
     * Get if Mps at colonies are full or half.
     *
     * @return If mps at colonies are full.
     */
    public boolean isFullMpsAtColonies() {
        return fullMpsAtColonies;
    }

    /**
     * Set if mps at colonies are full.
     *
     * @param value The value to set.
     */
    public void setFullMpsAtColonies(final boolean value) {
        this.fullMpsAtColonies = value;
    }

    /**
     * Get if weather is always summer.
     *
     * @return If weather is always summer.
     */
    public boolean isAlwaysSummerWeather() {
        return alwaysSummerWeather;
    }

    /**
     * Set if weather is always summer.
     *
     * @param value The value to set.
     */
    public void setAlwaysSummerWeather(final boolean value) {
        this.alwaysSummerWeather = value;
    }

    /**
     * Get if ship construction is fast.
     *
     * @return If ship construction is fast.
     */
    public boolean isFastShipConstruction() {
        return fastShipConstruction;
    }

    /**
     * Get if ship construction is fast.
     *
     * @param value The value to set.
     */
    public void setFastShipConstruction(final boolean value) {
        this.fastShipConstruction = value;
    }

    /**
     * Get if espionage is extended.
     *
     * @return If espionage is extended.
     */
    public boolean isExtendedEspionage() {
        return extendedEspionage;
    }

    /**
     * Set if espionage is extended.
     *
     * @param value The value to set.
     */
    public void setExtendedEspionage(final boolean value) {
        this.extendedEspionage = value;
    }

    /**
     * Get if fortress construction is fast.
     *
     * @return If fortress construction is fast.
     */
    public boolean isFastFortressConstruction() {
        return fastFortressConstruction;
    }

    /**
     * Set if fortress construction is fast.
     *
     * @param value The value to set.
     */
    public void setFastFortressConstruction(final boolean value) {
        this.fastFortressConstruction = value;
    }

    /**
     * Get if rumors are enabled.
     *
     * @return If rumors are enabled.
     */
    public boolean isRumorsEnabled() {
        return rumorsEnabled;
    }

    /**
     * Set if rumors are enabled.
     *
     * @param value The value to set.
     */
    public void setRumorsEnabled(final boolean value) {
        this.rumorsEnabled = value;
    }

    /**
     * Get if costs are doubled for army.
     *
     * @return if costs are doubled for army.
     */
    public boolean isDoubleCostsArmy() {
        return doubleCostsArmy;
    }

    /**
     * Set if costs are doubled for army.
     *
     * @param value if costs are doubled for army.
     */
    public void setDoubleCostsArmy(final boolean value) {
        this.doubleCostsArmy = value;
    }

    /**
     * Get if costs are doubled for naval forces.
     *
     * @return if costs are doubled for naval forces.
     */
    public boolean isDoubleCostsNavy() {
        return doubleCostsNavy;
    }

    /**
     * Set if costs are doubled for naval forces.
     *
     * @param value if costs are doubled for naval forces.
     */
    public void setDoubleCostsNavy(final boolean value) {
        this.doubleCostsNavy = value;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     * The <code>equals</code> method implements an equivalence relation
     * on non-null object references:
     * <ul>
     * <li>It is <i>reflexive</i>: for any non-null reference value
     * <code>x</code>, <code>x.equals(x)</code> should return
     * <code>true</code>.
     * <li>It is <i>symmetric</i>: for any non-null reference values
     * <code>x</code> and <code>y</code>, <code>x.equals(y)</code>
     * should return <code>true</code> if and only if
     * <code>y.equals(x)</code> returns <code>true</code>.
     * <li>It is <i>transitive</i>: for any non-null reference values
     * <code>x</code>, <code>y</code>, and <code>z</code>, if
     * <code>x.equals(y)</code> returns <code>true</code> and
     * <code>y.equals(z)</code> returns <code>true</code>, then
     * <code>x.equals(z)</code> should return <code>true</code>.
     * <li>It is <i>consistent</i>: for any non-null reference values
     * <code>x</code> and <code>y</code>, multiple invocations of
     * <tt>x.equals(y)</tt> consistently return <code>true</code>
     * or consistently return <code>false</code>, provided no
     * information used in <code>equals</code> comparisons on the
     * objects is modified.
     * <li>For any non-null reference value <code>x</code>,
     * <code>x.equals(null)</code> should return <code>false</code>.
     * </ul>
     * The <tt>equals</tt> method for class <code>Object</code> implements
     * the most discriminating possible equivalence relation on objects;
     * that is, for any non-null reference values <code>x</code> and
     * <code>y</code>, this method returns <code>true</code> if and only
     * if <code>x</code> and <code>y</code> refer to the same object
     * (<code>x == y</code> has the value <code>true</code>).
     * Note that it is generally necessary to override the <tt>hashCode</tt>
     * method whenever this method is overridden, so as to maintain the
     * general contract for the <tt>hashCode</tt> method, which states
     * that equal objects must have equal hash codes.
     *
     * @param obj the reference object with which to compare.
     * @return <code>true</code> if this object is the same as the obj
     * argument; <code>false</code> otherwise.
     * @see #hashCode()
     * @see java.util.Hashtable
     */
    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Game)) {
            return false;
        }

        final Game game = (Game) obj;

        if (gameId != game.gameId) {
            return false;
        }

        if (turn != game.turn) {
            return false;
        }

        return true;
    }

    /**
     * Indicator for the length of the game.
     * Values:
     * -1: SHORT
     * 0 : NORMAL
     * +1: EPIC
     */
    public String getTypeToString() {
        switch (type) {
            case TYPE_SHORT:
                return "Short";

            case TYPE_NORMAL:
                return "Normal";

            case TYPE_EPIC:
                return "Epic";
        }
        return "";
    }

    /**
     * Indicator about who will win the bet.
     * 1: Only the winners share the bet.
     * 2: Winners and runner ups share the bet.
     * 3: Winner, runner ups and survivors share the bet.
     */
    public String getBetSharingToString() {
        switch (betSharing) {
            case BET_SHARING_WINNERS:
                return "Winners";

            case BET_SHARING_WINNERS_RUNNERUPS:
                return "Winners and runner ups";

            case BET_SHARING_SURVIVORS:
                return "Survivors";
        }
        return "";
    }

    public boolean isWaitingForPlayers() {
        return GameConstants.GAME_WAIT.equals(status);
    }

    /**
     * Returns a hash code value for the object. This method is
     * supported for the benefit of hashtables such as those provided by
     * <code>java.util.Hashtable</code>.
     * The general contract of <code>hashCode</code> is:
     * <ul>
     * <li>Whenever it is invoked on the same object more than once during
     * an execution of a Java application, the <tt>hashCode</tt> method
     * must consistently return the same integer, provided no information
     * used in <tt>equals</tt> comparisons on the object is modified.
     * This integer need not remain consistent from one execution of an
     * application to another execution of the same application.
     * <li>If two objects are equal according to the <tt>equals(Object)</tt>
     * method, then calling the <code>hashCode</code> method on each of
     * the two objects must produce the same integer result.
     * <li>It is <em>not</em> required that if two objects are unequal
     * according to the {@link java.lang.Object#equals(java.lang.Object)}
     * method, then calling the <tt>hashCode</tt> method on each of the
     * two objects must produce distinct integer results.  However, the
     * programmer should be aware that producing distinct integer results
     * for unequal objects may improve the performance of hashtables.
     * </ul>
     * As much as is reasonably practical, the hashCode method defined by
     * class <tt>Object</tt> does return distinct integers for distinct
     * objects. (This is typically implemented by converting the internal
     * address of the object into an integer, but this implementation
     * technique is not required by the
     * Java<font size="-2"><sup>TM</sup></font> programming language.)
     *
     * @return a hash code value for this object.
     * @see java.lang.Object#equals(java.lang.Object)
     * @see java.util.Hashtable
     */
    @Override
    public int hashCode() {
        int result = gameId;
        result = 3100 * result + turn;
        return result;
    }
}
