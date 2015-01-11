package com.eaw1805.data.dto.web;

import java.io.Serializable;

public class RegionDTO
        implements com.google.gwt.user.client.rpc.IsSerializable, Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD

    /**
     * Region's identification number.
     */
    private int regionId; // NOPMD

    /**
     * Region's code.
     */
    private String code;

    /**
     * The name of the region.
     */
    private String name;

    /**
     * Default constructor.
     */
    public RegionDTO() {
        // Empty constructor
    }

    /**
     * Get the Identification number of the region.
     *
     * @return the identification number of the region.
     */
    public int getRegionId() {
        return regionId;
    }

    /**
     * Set the Identification number of the region.
     *
     * @param identity the identification number of the region.
     */
    public void setRegionId(final int identity) {
        this.regionId = identity;
    }

    /**
     * Get the name of the region.
     *
     * @return the name of the region.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the thisName of the region.
     *
     * @param thisName the name of the region.
     */
    public void setName(final String thisName) {
        this.name = thisName;
    }

    /**
     * Get the Single-char code of the region.
     *
     * @return the Single-char code of the region.
     */
    public String getCode() {
        return code;
    }

    /**
     * Set the single-char code of the region.
     *
     * @param thisCode the single-char code of the region.
     */
    public void setCode(final char thisCode) {
        this.code = String.valueOf(thisCode);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegionDTO regionDTO = (RegionDTO) o;

        if (regionId != regionDTO.regionId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return regionId;
    }
}
