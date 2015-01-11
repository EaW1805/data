package com.eaw1805.data.dto.web.army;

import com.eaw1805.data.dto.web.CargoUnitDTO;

import java.io.Serializable;

/**
 * Models an Army/Corp Commander.
 */
public class CommanderDTO
        extends CargoUnitDTO
        implements com.google.gwt.user.client.rpc.IsSerializable, Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 33L; //NOPMD

    /**
     * The unique identifier of the commander.
     */
    private int id; // NOPMD

    /**
     * Commander's rank.
     */
    private int rankId;

    /**
     * Commander's rank.
     */
    private RankDTO rank;

    /**
     * The name of the commander.
     */
    private String name;

    /**
     * The original name of the commander as is stored in the db.
     */
    private String originalName;

    /**
     * the available movement points.
     */
    private int mps;

    /**
     * the command capability in battles.
     */
    private int comc;

    /**
     * the strategic capability in battles.
     */
    private int strc;

    /**
     * The corp of the commander.
     */
    private int corp;

    /**
     * The army id in which the brigade started this turn
     */
    private int startCorp = 0;

    /**
     * The army of the commander.
     */
    private int army;

    /**
     * The army id in which the brigade started this turn
     */
    private int startArmy = 0;

    /**
     * The state of the commander
     */
    private boolean inTransit = false;

    /**
     * The placement of the commander
     */
    private boolean pool = false;

    /**
     * The state of the commander in the beginning
     * of the turn
     */
    private boolean startInPool = false;

    /**
     * The nation that this commander belongs to.
     */
    private int nationId;

    /**
     * The internal id of the commander.
     */
    private int intId;

    /**
     * The commander has died this turn.
     */
    private boolean dead;

    /**
     * Indicates that this is the supreme commander.
     */
    private boolean supreme;

    /**
     * Counter of months remaining until sickness is cured.
     */
    private int sick;

    /**
     * The nation that has captured this commander.
     */
    private int captured;

    /**
     * Indicates number of turns required to reach assigned unit.
     */
    private int transit;

    /**
     * Default constructor.
     */
    public CommanderDTO() {
        // empty constructor
    }

    /**
     * Get the unique identifier of the commander.
     *
     * @return the unique identifier of the commander.
     */
    public int getId() {
        return id;
    }

    /**
     * Set the unique identifier of the commander.
     *
     * @param identity the unique identifier of the commander.
     */
    public void setId(final int identity) {
        this.id = identity;
    }

    /**
     * Get the rank of the commander.
     *
     * @return the rank of the commander.
     */
    public int getRankId() {
        return rankId;
    }

    /**
     * Set the rank of the commander.
     *
     * @param value the rank of the commander.
     */
    public void setRankId(final int value) {
        rankId = value;
    }

    /**
     * Get the rank of the commander.
     *
     * @return the rank of the commander.
     */
    public RankDTO getRank() {
        return rank;
    }

    /**
     * Set the rank of the commander.
     *
     * @param value the rank of the commander.
     */
    public void setRank(final RankDTO value) {
        this.rank = value;
    }

    /**
     * Get the name of the commander.
     *
     * @return the name of the commander.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the thisName of the commander.
     *
     * @param thisName the name of the commander.
     */
    public void setName(final String thisName) {
        this.name = thisName;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    /**
     * Get the available movement points.
     *
     * @return the available movement points.
     */
    public int getMps() {
        return mps;
    }

    /**
     * Set the available movement points.
     *
     * @param thisMps the available movement points.
     */
    public void setMps(final int thisMps) {
        this.mps = thisMps;
    }

    /**
     * Get the command capability in battles.
     *
     * @return the command capability in battles.
     */
    public int getComc() {
        return comc;
    }

    /**
     * Set the command capability in battles.
     *
     * @param thisComC the command capability in battles.
     */
    public void setComc(final int thisComC) {
        this.comc = thisComC;
    }

    /**
     * Get the corp of the commander.
     *
     * @return the corp of the commander.
     */
    public int getCorp() {
        return corp;
    }

    /**
     * Set the corp of the commander.
     *
     * @param thisFed the corp of the commander.
     */
    public void setCorp(final int thisFed) {
        this.corp = thisFed;
    }

    /**
     * Get the army of the commander.
     *
     * @return the army of the commander.
     */
    public int getArmy() {
        return army;
    }

    /**
     * Set the army of the commander.
     *
     * @param thisArmy the army of the commander.
     */
    public void setArmy(final int thisArmy) {
        this.army = thisArmy;
    }

    /**
     * Get the transit state of the commander.
     *
     * @return true if the commander is in transit
     */
    public boolean getInTransit() {
        return inTransit;
    }

    /**
     * Set the transit state of the commander.
     *
     * @param inTransit the state of the commander.
     */
    public void setInTransit(final boolean inTransit) {
        this.inTransit = inTransit;
    }

    /**
     * Get the starting placement of the commander.
     *
     * @return true if the commander is in pool
     */
    public boolean getInPool() {
        return pool;
    }

    /**
     * Set the pool state of the commander.
     *
     * @param pool the pool state of the commander.
     */
    public void setPool(final boolean pool) {
        this.pool = pool;
    }

    /**
     * Get the starting transit state of the commander.
     *
     * @return true if the commander is in pool at the beginning of the turn
     */
    public boolean getStartInPool() {
        return startInPool;
    }

    /**
     * Set the starting pool state of the commander.
     *
     * @param startInPool the pool state of the commander.
     */
    public void setStartInPool(final boolean startInPool) {
        this.startInPool = startInPool;
    }

    /**
     * Get the nation this army type belongs to.
     *
     * @return the nation this army type belongs to.
     */
    public int getNationId() {
        return nationId;
    }

    /**
     * Set the nation this army type belongs to.
     *
     * @param param The nation this army type belongs to.
     */
    public void setNationId(final int param) {
        this.nationId = param;
    }

    /**
     * Get the internal id of the commander.
     *
     * @return the internal id of the commander.
     */
    public int getIntId() {
        return intId;
    }

    /**
     * Set the internal id of the commander.
     *
     * @param value the internal id of the commander.
     */
    public void setIntId(final int value) {
        intId = value;
    }

    /**
     * Get the strategic capability.
     *
     * @return the strategic capability.
     */
    public int getStrc() {
        return strc;
    }

    /**
     * Set the strategic capability.
     *
     * @param value the strategic capability.
     */
    public void setStrc(final int value) {
        this.strc = value;
    }

    /**
     * Get if the commander has died this turn.
     *
     * @return true, if the commander has died this turn.
     */
    public boolean getDead() {
        return dead;
    }

    /**
     * Set if the commander has died this turn.
     *
     * @param value true, if the commander has died this turn.
     */
    public void setDead(final boolean value) {
        dead = value;
    }

    /**
     * Get the indicator if this is the supreme commander.
     *
     * @return the indicator if this is the supreme commander.
     */
    public boolean getSupreme() {
        return supreme;
    }

    /**
     * Set the indicator if this is the supreme commander.
     *
     * @param value the indicator if this is the supreme commander.
     */
    public void setSupreme(final boolean value) {
        this.supreme = value;
    }

    /**
     * Get the counter of months remaining until sickness is cured.
     *
     * @return the counter of months remaining until sickness is cured.
     */
    public int getSick() {
        return sick;
    }

    /**
     * Set the counter of months remaining until sickness is cured.
     *
     * @param value the counter of months remaining until sickness is cured.
     */
    public void setSick(final int value) {
        sick = value;
    }

    /**
     * Get the army in which the commander started.
     *
     * @return the armyId in which the commander started
     */
    public int getStartArmy() {
        return startArmy;
    }

    /**
     * Set the army in which the commander started.
     *
     * @param value the armyId in which the commander started
     */
    public void setStartArmy(final int value) {
        this.startArmy = value;
    }

    /**
     * Get the corp in which the commander started.
     *
     * @return the corpId in which the commander started
     */
    public int getStartCorp() {
        return startCorp;
    }

    /**
     * Set the corp in which the commander started.
     *
     * @param value corpId in which the commander started
     */
    public void setStartCorp(final int value) {
        this.startCorp = value;
    }

    /**
     * Get the nation that has captured this commander.
     * @return the nation that has captured this commander.
     */
    public int getCaptured() {
        return captured;
    }

    /**
     * Set the nation that has captured this commander.
     * @param value the nation that has captured this commander.
     */
    public void setCaptured(final int value) {
        this.captured = value;
    }

    public boolean isCaptured() {
        return nationId != captured;
    }

    /**
     * Get the number of turns required to reach assigned unit.
     *
     * @return number of turns required to reach assigned unit.
     */
    public int getTransit() {
        return transit;
    }

    /**
     * Set the number of turns required to reach assigned unit.
     *
     * @param value the number of turns required to reach assigned unit.
     */
    public void setTransit(final int value) {
        this.transit = value;
    }

}
