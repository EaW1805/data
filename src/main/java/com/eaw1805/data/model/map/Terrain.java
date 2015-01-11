package com.eaw1805.data.model.map;

import java.io.Serializable;

/**
 * Read-only information for the Terrain types.
 */
public class Terrain implements Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD

    /**
     * terrain's ID.
     */
    private int id; // NOPMD

    /**
     * terrain's code.
     */
    private char code;

    /**
     * terrain's name.
     */
    private String name;

    /**
     * terrain's maximum density.
     */
    private int maxDensity;

    /**
     * terrain's movement points required to cross.
     */
    private int mps;

    /**
     * terrain's movement points required to cross during winter.
     */
    private int mpsWinter;

    /**
     * Attrition on land for owned territories.
     */
    private double attritionOwn;

    /**
     * Attrition on land for foreign territories.
     */
    private double attritionForeign;

    /**
     * The effectiveness of troops as influenced by different terrains.
     */
    private int terrainFactor;

    /**
     * Terrain's default constructor.
     */
    public Terrain() {
        // Empty constructor
    }

    /**
     * Get the Identification number of the terrain.
     *
     * @return the identification number of the terrain.
     */
    public int getId() {
        return id;
    }

    /**
     * Set the identification number of the terrain.
     *
     * @param identity the identification number of the terrain.
     */
    public void setId(final int identity) {
        this.id = identity;
    }

    /**
     * Get the Single-char code of the terrain.
     *
     * @return the Single-char code of the terrain.
     */
    public char getCode() {
        return code;
    }

    /**
     * Set the single-char thisCode of the terrain.
     *
     * @param thisCode the single-char thisCode of the terrain.
     */
    public void setCode(final char thisCode) {
        this.code = thisCode;
    }

    /**
     * Get the name of the terrain.
     *
     * @return the name of the terrain.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the thisName of the terrain.
     *
     * @param thisName the name of the terrain.
     */
    public void setName(final String thisName) {
        this.name = thisName;
    }

    /**
     * Get the maximum density of the terrain.
     *
     * @return the maximum density of the terrain.
     */
    public int getMaxDensity() {
        return maxDensity;
    }

    /**
     * Set the maximum density of the terrain.
     *
     * @param thisMaxDensity the maximum density of the terrain.
     */
    public void setMaxDensity(final int thisMaxDensity) {
        this.maxDensity = thisMaxDensity;
    }

    /**
     * Get the movement points required to cross the terrain.
     *
     * @return the movement points required to cross the terrain.
     */
    public int getMps() {
        return mps;
    }

    /**
     * Set the movement points required to cross the terrain.
     *
     * @param thisMps the movement points required to cross the terrain.
     */
    public void setMps(final int thisMps) {
        this.mps = thisMps;
    }

    /**
     * Get the movement points required to cross the terrain during Winter.
     *
     * @return the movement points required to cross the terrain during Winter.
     */
    public int getMpsWinter() {
        return mpsWinter;
    }

    /**
     * Set the movement points required to cross the terrain during Winter.
     *
     * @param thisMpsWinter the movement points required to cross the terrain during Winter.
     */
    public void setMpsWinter(final int thisMpsWinter) {
        this.mpsWinter = thisMpsWinter;
    }

    /**
     * Get the attrition on land for owned territories.
     *
     * @return the attrition on land for owned territories.
     */
    public double getAttritionOwn() {
        return attritionOwn;
    }

    /**
     * Set the attrition on land for owned territories.
     *
     * @param thisAttrOwn the attrition on land for owned territories.
     */
    public void setAttritionOwn(final double thisAttrOwn) {
        this.attritionOwn = thisAttrOwn;
    }

    /**
     * Get the attrition on land for foreign territories.
     *
     * @return the attrition on land for foreign territories.
     */
    public double getAttritionForeign() {
        return attritionForeign;
    }

    /**
     * set the attrition on land for foreign territories.
     *
     * @param thisAttrForeign the attrition on land for foreign territories.
     */
    public void setAttritionForeign(final double thisAttrForeign) {
        this.attritionForeign = thisAttrForeign;
    }

    /**
     * Get the terrain factor for the terrain.
     *
     * @return the terrain factor.
     */
    public int getTerrainFactor() {
        return terrainFactor;
    }

    /**
     * Set the terrain factor for this terrain
     *
     * @param value The terrain factor.
     */
    public void setTerrainFactor(final int value) {
        this.terrainFactor = value;
    }

}
