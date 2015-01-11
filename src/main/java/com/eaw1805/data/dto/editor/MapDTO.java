package com.eaw1805.data.dto.editor;

import java.io.Serializable;
import java.util.Set;

/**
 * Data-Transfer Object for the Map information.
 */
public class MapDTO
        implements com.google.gwt.user.client.rpc.IsSerializable, Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD

    /**
     * The EmpireMapDTO's identification number.
     */
    private int id; // NOPMD

    /**
     * The EmpireMapDTO's description.
     */
    private String description;

    /**
     * The EmpireMapDTO's description.
     */
    private long version;

    /**
     * The EmpireMapDTO's sectors.
     */
    private Set<com.eaw1805.data.dto.common.SectorDTO> sectors;

    /**
     * Minimum and maximum X and Y coordinates.
     */
    private int minX, maxX, minY, maxY;

    /**
     * The EmpireMapDTO default constructor.
     */
    public MapDTO() {
        // Empty constructor
    }

    /**
     * The EmpireMapDTO constructor that sets all EmpireMapDTO fields.
     *
     * @param identity        The EmpireMapDTO's identification number
     * @param thisversion     The EmpireMapDTO's version number
     * @param thisdescription The EmpireMapDTO's description
     * @param sectorsDTO      The EmpireMapDTO's sectorsDTO
     */
    public MapDTO(final int identity,
                  final Long thisversion,
                  final String thisdescription,
                  final Set<com.eaw1805.data.dto.common.SectorDTO> sectorsDTO) {
        this.id = identity;
        this.version = thisversion;
        this.description = thisdescription;
        this.sectors = sectorsDTO;
    }

    /**
     * Get the identification number of the EmpireMapDTO.
     *
     * @return The identification number of the EmpireMapDTO
     */
    public int getId() {
        return id;
    }

    /**
     * Set the EmpireMapDTO identification number.
     *
     * @param identity The EmpireMapDTO's identification number
     */
    public void setId(final int identity) {
        this.id = identity;
    }

    /**
     * Get the description of the EmpireMapDTO.
     *
     * @return The description of the EmpireMapDTO
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the description of the EmpireMapDTO.
     *
     * @param descr The EmpireMapDTO's description.
     */
    public void setDescription(final String descr) {
        this.description = descr;
    }

    /**
     * Get the version of the EmpireMapDTO.
     *
     * @return The version of the EmpireMapDTO
     */
    public long getVersion() {
        return version;
    }

    /**
     * Set the version number of the EmpireMapDTO.
     *
     * @param ver The EmpireMapDTO's version number
     */
    public void setVersion(final long ver) {
        this.version = ver;
    }

    /**
     * Get the sectors of the EmpireMapDTO.
     *
     * @return The sectors of the EmpireMapDTO
     */
    public Set<com.eaw1805.data.dto.common.SectorDTO> getSectors() {
        return sectors;
    }

    /**
     * Set the sectors of the EmpireMapDTO.
     *
     * @param sec The EmpireMapDTO's sectors
     */
    public void setSectors(final Set<com.eaw1805.data.dto.common.SectorDTO> sec) {
        this.sectors = sec;
    }

    /**
     * Get the maximum X coordinate.
     *
     * @return the maximum X coordinate.
     */
    public int getMaxX() {
        return maxX;
    }

    /**
     * Set the maximum X coordinate.
     *
     * @param value the maximum X coordinate.
     */
    public void setMaxX(final int value) {
        this.maxX = value;
    }

    /**
     * Get the maximum Y coordinate.
     *
     * @return the maximum Y coordinate.
     */
    public int getMaxY() {
        return maxY;
    }

    /**
     * Set the maximum Y coordinate.
     *
     * @param value the maximum Y coordinate.
     */
    public void setMaxY(final int value) {
        this.maxY = value;
    }

    /**
     * Get the minimum X coordinate.
     *
     * @return the minimum X coordinate.
     */
    public int getMinX() {
        return minX;
    }

    /**
     * Set the minimum X coordinate.
     *
     * @param value the minimum X coordinate.
     */
    public void setMinX(final int value) {
        this.minX = value;
    }

    /**
     * Get the minimum Y coordinate.
     *
     * @return the minimum Y coordinate.
     */
    public int getMinY() {
        return minY;
    }

    /**
     * Set the minimum Y coordinate.
     *
     * @param value the minimum Y coordinate.
     */
    public void setMinY(final int value) {
        this.minY = value;
    }
}
