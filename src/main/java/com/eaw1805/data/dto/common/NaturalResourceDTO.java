package com.eaw1805.data.dto.common;

import java.io.Serializable;

/**
 * Data-Transfer Object for the Natural Resource information.
 */
public class NaturalResourceDTO
        implements com.google.gwt.user.client.rpc.IsSerializable, Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD

    /**
     * Natural Resource's identification number.
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
     * NaturalResourceDTO's default constructor.
     */
    public NaturalResourceDTO() {
        // Empty constructor
    }

    /**
     * The NaturalResourceDTO's constructor that sets all EmpireMapDTO fields.
     *
     * @param identity The NaturalResourceDTO's identification number.
     * @param thiscode The NaturalResourceDTO's code.
     * @param thisname The NaturalResourceDTO's name.
     */
    public NaturalResourceDTO(final int identity,
                              final char thiscode,
                              final String thisname) {
        this.id = identity;
        this.code = thiscode;
        this.name = thisname;
    }

    /**
     * Get the Identification number of the natural resource.
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
     * @param thisCode the single-char code of the natural resource.
     */
    public void setCode(final char thisCode) {
        this.code = thisCode;
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
     * @param thisName the name of the natural resource.
     */
    public void setName(final String thisName) {
        this.name = thisName;
    }

}
