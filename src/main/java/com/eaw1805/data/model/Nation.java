package com.eaw1805.data.model;

import java.io.Serializable;

/**
 * Read-only information for the nations of each game.
 */
public class Nation implements Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD

    /**
     * Nation's ID.
     */
    private int id; // NOPMD

    /**
     * Nation's code.
     */
    private char code;

    /**
     * Nation's name.
     */
    private String name;

    /**
     * Nation's taxation rate.
     */
    private int taxRate;

    /**
     * The political spheres of influence.
     */
    private String sphereOfInfluence;

    /**
     * The default color.
     */
    private String color;

    /**
     * Morale of Nation's marines.
     */
    private int morale;

    /**
     * The starting VPs.
     */
    private int vpInit;

    /**
     * The VPs required to win the game.
     */
    private int vpWin;

    /**
     * Default cost per round for this nation.
     */
    private int cost;

    /**
     * Weight of nation - used during game processing.
     * Does not persist to db.
     */
    private int weight;

    /**
     * Temp value used to sort nations.
     */
    private int sort;

    /**
     * Default constructor.
     */
    public Nation() {
        // Empty constructor
    }

    /**
     * Get the Identification number of the nation.
     *
     * @return the identification number of the nation.
     */
    public int getId() {
        return id;
    }

    /**
     * Set the identification number of the nation.
     *
     * @param identity the identification number of the nation.
     */
    public void setId(final int identity) {
        this.id = identity;
    }

    /**
     * Get the Single-char code of the nation.
     *
     * @return the Single-char code of the nation.
     */
    public char getCode() {
        return code;
    }

    /**
     * Set the single-char code of the nation.
     *
     * @param thisCode the single-char code of the nation.
     */
    public void setCode(final char thisCode) {
        this.code = thisCode;
    }

    /**
     * Get the name of the nation.
     *
     * @return the name of the nation.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the nation.
     *
     * @param thisName the name of the nation.
     */
    public void setName(final String thisName) {
        this.name = thisName;
    }

    /**
     * Get the taxation rate of the nation.
     *
     * @return set the taxation rate of the nation.
     */
    public int getTaxRate() {
        return taxRate;
    }

    /**
     * Set the taxation rate of the nation.
     *
     * @param rate the taxation rate of the nation.
     */
    public void setTaxRate(final int rate) {
        this.taxRate = rate;
    }

    /**
     * Get the political sphere of influence.
     *
     * @return the political sphere of influence.
     */
    public String getSphereOfInfluence() {
        return sphereOfInfluence;
    }

    /**
     * Set the political sphere of influence.
     *
     * @param thisPSphere the political sphere of influence.
     */
    public void setSphereOfInfluence(final String thisPSphere) {
        this.sphereOfInfluence = thisPSphere;
    }

    /**
     * Get the color representing the Nation in maps.
     *
     * @return the color of the nation.
     */
    public String getColor() {
        return color;
    }

    /**
     * Set the color of the nation.
     *
     * @param value the color of the nation.
     */
    public void setColor(final String value) {
        this.color = value;
    }

    /**
     * Get the morale of the nation's marines.
     *
     * @return the morale of the marines.
     */
    public int getMorale() {
        return morale;
    }

    /**
     * Set the morale of the nation's marines.
     *
     * @param value the morale of the marines.
     */
    public void setMorale(final int value) {
        this.morale = value;
    }

    /**
     * Get the starting VPs.
     *
     * @return the starting VPs.
     */
    public int getVpInit() {
        return vpInit;
    }

    /**
     * Set the starting VPs.
     *
     * @param value the starting VPs.
     */
    public void setVpInit(final int value) {
        this.vpInit = value;
    }

    /**
     * Get the VPs required to win the game.
     *
     * @return the VPs required to win the game.
     */
    public int getVpWin() {
        return vpWin;
    }

    /**
     * Set the VPs required to win the game.
     *
     * @param value the VPs required to win the game.
     */
    public void setVpWin(final int value) {
        this.vpWin = value;
    }

    /**
     * Get the default cost per round for this nation.
     *
     * @return the default cost per round for this nation.
     */
    public int getCost() {
        return cost;
    }

    /**
     * Set the default cost per round for this nation.
     *
     * @param value the default cost per round for this nation.
     */
    public void setCost(final int value) {
        this.cost = value;
    }

    /**
     * Get the weight of the nation.
     *
     * @return the weight of the nation.
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Set the weight of the nation.
     *
     * @param value the weight of the nation.
     */
    public void setWeight(final int value) {
        this.weight = value;
    }

    /**
     * Get the Temp value used to sort nations.
     *
     * @return Temp value used to sort nations.
     */
    public int getSort() {
        return sort;
    }

    /**
     * Set Temp value used to sort nations.
     *
     * @param value Temp value used to sort nations.
     */
    public void setSort(final int value) {
        this.sort = value;
    }

    @Override
    public boolean equals(final Object other) {
        if (other == null || getClass() != other.getClass()) {
            return false;
        }

        final Nation nation = (Nation) other;

        if (id != nation.id) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }
    
    @Override
    public String toString() {
    	return String.valueOf(id);
    }

}
