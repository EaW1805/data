package com.eaw1805.data.dto.web.army;

import com.eaw1805.data.dto.common.PositionDTO;

import java.io.Serializable;

/**
 * Represents a Barrack or a Shipyard.
 */
public class BarrackDTO
        extends PositionDTO
        implements com.google.gwt.user.client.rpc.IsSerializable, Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 36L; //NOPMD

    /**
     * Barrack's identification number.
     */
    private int id; // NOPMD

    /**
     * The nation that this entity belongs to.
     */
    private int nationId;

    /**
     * Signals that the barrack is not supplied.
     */
    private boolean notSupplied;

    /**
     * The name of the barrack.
     */
    private String name;

    private String originalName;



    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the nationId
     */
    public int getNationId() {
        return nationId;
    }

    /**
     * @param value the nationId to set
     */
    public void setNationId(final int value) {
        this.nationId = value;
    }

    /**
     * @param value the id to set
     */
    public void setId(final int value) {
        this.id = value;
    }

    /**
     * Get the indicator if the barrack is not supplied.
     *
     * @return the indicator if the barrack is not supplied.
     */
    public boolean getNotSupplied() {
        return notSupplied;
    }

    /**
     * Set the indicator if the barrack is not supplied.
     *
     * @param value the indicator if the barrack is not supplied.
     */
    public void setNotSupplied(final boolean value) {
        this.notSupplied = value;
    }

    /**
     * Get the barracks name.
     *
     * @return The barracks name.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the barracks name.
     *
     * @param name The name to set.
     */
    public void setName(final String name) {
        this.name = name;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(final String originalName) {
        this.originalName = originalName;
    }
}
