package com.eaw1805.data.dto.common;

import java.io.Serializable;

public class NationDTO
        implements com.google.gwt.user.client.rpc.IsSerializable, Serializable {
    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD

    /**
     * Nation's ID.
     */
    private int nationId;

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
     * Get the Identification number of the nation.
     *
     * @return the identification number of the nation.
     */
    public int getNationId() {
        return nationId;
    }

    /**
     * Set the identification number of the nation.
     *
     * @param identity the identification number of the nation.
     */
    public void setNationId(final int identity) {
        this.nationId = identity;
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

}
