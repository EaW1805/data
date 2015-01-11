package com.eaw1805.data.model.army;

import com.eaw1805.data.model.MapElement;
import com.eaw1805.data.model.Nation;
import com.eaw1805.data.model.map.CarrierInfo;
import com.eaw1805.data.model.map.Position;

import java.io.Serializable;

/**
 * Models an Army/Corp Commander.
 */
public class Commander
        implements Serializable, MapElement {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD

    /**
     * The unique identifier of the commander.
     */
    private int id; // NOPMD

    /**
     * Commander's relative coordinates.
     */
    private Position position;

    /**
     * Commander's rank.
     */
    private Rank rank;

    /**
     * The name of the commander.
     */
    private String name;

    /**
     * the available movement points.
     */
    private int mps;

    /**
     * the tactical capability in battles.
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
     * The army of the commander.
     */
    private int army;

    /**
     * The nation that this commander belongs to.
     */
    private Nation nation;

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
     * Indicates the transit state of the commander (in transit to or from pool)
     */
    private boolean inTransit;

    /**
     * Indicates the pool state of the commander
     */
    private boolean pool;

    /**
     * Indicates number of turns required to reach assigned unit.
     */
    private int transit;

    /**
     * Indicates whether this commander is a cavalry leader.
     */
    private boolean cavalryLeader;

    /**
     * Indicates whether this commander is a artillery leader.
     */
    private boolean artilleryLeader;

    /**
     * Indicates whether this commander is a stout defender.
     */
    private boolean stoutDefender;

    /**
     * Indicates whether this commander is a fearless attacker.
     */
    private boolean fearlessAttacker;

    /**
     * Indicates whether this commander is a legendary commander.
     */
    private boolean legendaryCommander;

    /**
     * The unit that is transferring the commander.
     */
    private CarrierInfo carrierInfo;

    /**
     * The nation that has captured this commander.
     */
    private Nation captured;

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
     * Get the relative position of the commander.
     *
     * @return the relative position of the commander.
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Set the relative thisPosition of the commander.
     *
     * @param thisPosition the relative thisPosition of the commander.
     */
    public void setPosition(final Position thisPosition) {
        this.position = thisPosition;
    }

    /**
     * Get the rank of the commander.
     *
     * @return the rank of the commander.
     */
    public Rank getRank() {
        return rank;
    }

    /**
     * Set the rank of the commander.
     *
     * @param thisRank the rank of the commander.
     */
    public void setRank(final Rank thisRank) {
        this.rank = thisRank;
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
     * Get the nation this army type belongs to.
     *
     * @return the nation this army type belongs to.
     */
    public Nation getNation() {
        return nation;
    }

    /**
     * Set the nation this army type belongs to.
     *
     * @param param The nation this army type belongs to.
     */
    public void setNation(final Nation param) {
        this.nation = param;
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
        this.dead = value;
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
        this.sick = value;
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
     * Get the pool state of the commander.
     *
     * @return true if the commander is in pool
     */
    public boolean getPool() {
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

    /**
     * Get the unit that is transferring the commander.
     *
     * @return the unit that is transferring the commander.
     */
    public CarrierInfo getCarrierInfo() {
        return carrierInfo;
    }

    /**
     * Set the unit that is transferring the commander.
     *
     * @param value the unit that is transferring the commander.
     */
    public void setCarrierInfo(final CarrierInfo value) {
        this.carrierInfo = value;
    }

    /**
     * Get the indicator of whether this is a cavalry leader.
     *
     * @return the indicator of whether this is a cavalry leader
     */
    public boolean getCavalryLeader() {
        return cavalryLeader;
    }

    /**
     * Set the indicator of whether this is a cavalry leader.
     *
     * @param cavalryLeader, the indicator of whether this is a cavalry leader
     */
    public void setCavalryLeader(final boolean cavalryLeader) {
        this.cavalryLeader = cavalryLeader;
    }

    /**
     * Get the indicator of whether this is an artillery leader.
     *
     * @return the indicator of whether this is an artillery leader
     */
    public boolean getArtilleryLeader() {
        return artilleryLeader;
    }

    /**
     * Set the indicator of whether this is an artillery leader.
     *
     * @param artilleryLeader, the indicator of whether this is an artillery leader
     */
    public void setArtilleryLeader(final boolean artilleryLeader) {
        this.artilleryLeader = artilleryLeader;
    }

    /**
     * Get the indicator of whether this is a stout defender.
     *
     * @return the indicator of whether this is a stout defender
     */
    public boolean getStoutDefender() {
        return stoutDefender;
    }

    /**
     * Set the indicator of whether this is a stout defender.
     *
     * @param stoutDefender, the indicator of whether this is a stout defender
     */
    public void setStoutDefender(final boolean stoutDefender) {
        this.stoutDefender = stoutDefender;
    }

    /**
     * Get the indicator of whether this is a fearless attacker.
     *
     * @return the indicator of whether this is a fearless attacker
     */
    public boolean getFearlessAttacker() {
        return fearlessAttacker;
    }

    /**
     * Set the indicator of whether this is a fearless attacker.
     *
     * @param fearlessAttacker, the indicator of whether this is a stout defender
     */
    public void setFearlessAttacker(final boolean fearlessAttacker) {
        this.fearlessAttacker = fearlessAttacker;
    }

    /**
     * Get the indicator of whether this is a legendary commander.
     *
     * @return the indicator of whether this is a legendary commander
     */
    public boolean getLegendaryCommander() {
        return legendaryCommander;
    }

    /**
     * Set the indicator of whether this is a legendary commander.
     *
     * @param legendaryCommander, the indicator of whether this is a legendary commander
     */
    public void setLegendaryCommander(final boolean legendaryCommander) {
        this.legendaryCommander = legendaryCommander;
    }

    /**
     * Get the nation that has captured this commander.
     *
     * @return the nation that has captured this commander.
     */
    public Nation getCaptured() {
        return captured;
    }

    /**
     * Set the nation that has captured this commander.
     *
     * @param value the nation that has captured this commander.
     */
    public void setCaptured(final Nation value) {
        this.captured = value;
    }
}
