package com.eaw1805.data.dto.common;

import java.io.Serializable;

/**
 * Data-transfer object for the information for the Terrain types.
 */
public class TerrainDTO
        implements com.google.gwt.user.client.rpc.IsSerializable, Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD

    /**
     * terrain's identification number.
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
     * terrain's movement points for the particular game, region and turn.
     */
    private int actualMPs;

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
     * Set the single-char code of the terrain.
     *
     * @param thisCode the single-char code of the terrain.
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
     * Set the name of the terrain.
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
     * Get the terrain's movement points for the particular game, region and turn.
     *
     * @return the terrain's movement points for the particular game, region and turn.
     */
    public int getActualMPs() {
        return actualMPs;
    }

    /**
     * Set the terrain's movement points for the particular game, region and turn.
     *
     * @param value the terrain's movement points for the particular game, region and turn.
     */
    public void setActualMPs(final int value) {
        this.actualMPs = value;
    }
}
