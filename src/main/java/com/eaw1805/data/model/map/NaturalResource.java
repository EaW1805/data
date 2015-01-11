package com.eaw1805.data.model.map;

import java.io.Serializable;

/**
 * Class that contains all the information about a natural resource.
 */
public class NaturalResource implements Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD

    /**
     * NaturalResource's ID.
     */
    private int id; // NOPMD

    /**
     * NaturalResource's code.
     */
    private char code;

    /**
     * NaturalResource's name.
     */
    private String name;

    /**
     * Improve production's factor(percentage).
     */
    private int factor;

    /**
     * Default constructor.
     */
    public NaturalResource() {
        // Empty constructor
    }

    /**
     * Constructor that sets the NaturalResource's identity.
     *
     * @param identity the identification number of the NaturalResource.
     */
    public NaturalResource(final int identity) {
        this.id = identity;
    }

    /**
     * Get the Identification number of the NaturalResource.
     *
     * @return the identification number of the natural resource.
     */
    public int getId() {
        return id;
    }

    /**
     * Set the identification number of the natural resource.
     *
     * @param identity the identification number of the natural resource.
     */
    public void setId(final int identity) {
        this.id = identity;
    }

    /**
     * Get the Single-char code of the natural resource.
     *
     * @return the Single-char code of the natural resource.
     */
    public char getCode() {
        return code;
    }

    /**
     * Set the single-char code of the natural resource.
     *
     * @param param the single-char code of the natural resource.
     */
    public void setCode(final char param) {
        this.code = param;
    }

    /**
     * Get the name of the natural resource.
     *
     * @return the name of the natural resource.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the natural resource.
     *
     * @param param the name of the natural resource.
     */
    public void setName(final String param) {
        this.name = param;
    }

    /**
     * Get the imrove production factor.
     *
     * @return the improve production factor as a percentage.
     */
    public int getFactor() {
        return factor;
    }

    /**
     * Set the imrove production factor.
     *
     * @param param the improve production factor as a percentage.
     */
    public void setFactor(final int param) {
        this.factor = param;
    }

}
