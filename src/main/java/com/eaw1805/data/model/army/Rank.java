package com.eaw1805.data.model.army;

import java.io.Serializable;

/**
 * Models commanders' ranks.
 */
public class Rank implements Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD

    /**
     * The unique identifier of the rank.
     */
    private int rankId;

    /**
     * The name of the commander.
     */
    private String name;

    /**
     * Minimum Command Capability.
     */
    private int minComC;

    /**
     * Maximum Command Capability.
     */
    private int maxComC;

    /**
     * Strategic Capability.
     */
    private int strC;

    /**
     * Monthly salary.
     */
    private int salary;

    /**
     * Get the unique identifier of the commander.
     *
     * @return the unique identifier of the commander.
     */
    public int getRankId() {
        return rankId;
    }

    /**
     * Set the unique identifier of the commander.
     *
     * @param identity the unique identifier of the commander.
     */
    public void setRankId(final int identity) {
        this.rankId = identity;
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
     * @param value the name of the commander.
     */
    public void setName(final String value) {
        this.name = value;
    }

    /**
     * Get the minimum command capability.
     *
     * @return the minimum command capability.
     */
    public int getMinComC() {
        return minComC;
    }

    /**
     * Set the minimum command capability.
     *
     * @param value the minimum command capability.
     */
    public void setMinComC(final int value) {
        this.minComC = value;
    }

    /**
     * Get the minimum command capability.
     *
     * @return the minimum command capability.
     */
    public int getMaxComC() {
        return maxComC;
    }

    /**
     * Set the minimum command capability.
     *
     * @param value the minimum command capability.
     */
    public void setMaxComC(final int value) {
        this.maxComC = value;
    }

    /**
     * Get the strategic capability of the commander.
     *
     * @return the strategic capability of the commander.
     */
    public int getStrC() {
        return strC;
    }

    /**
     * Set the strategic capability of the commander.
     *
     * @param value the strategic capability of the commander.
     */
    public void setStrC(final int value) {
        this.strC = value;
    }

    /**
     * Get the salary.
     *
     * @return the salary.
     */
    public int getSalary() {
        return salary;
    }

    /**
     * Set the salary.
     *
     * @param value the salary.
     */
    public void setSalary(final int value) {
        this.salary = value;
    }

}
