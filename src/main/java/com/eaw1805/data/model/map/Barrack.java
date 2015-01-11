package com.eaw1805.data.model.map;

import com.eaw1805.data.model.Nation;

import java.io.Serializable;

/**
 * Represents a Barrack or a Shipyard.
 */
public class Barrack implements Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD

    /**
     * Barrack's identification number.
     */
    private int id; // NOPMD

    /**
     * The nation that this barrack belongs to.
     */
    private Nation nation;

    /**
     * Barrack's relative coordinates.
     */
    private Position position;

    /**
     * Signals that the barrack is not supplied.
     */
    private boolean notSupplied;

    /**
     * The name of the barrack.
     */
    private String name;

    /**
     * Default constructor.
     */
    public Barrack() {
        // Empty constructor
    }

    /**
     * Get the Identification number of the barrack.
     *
     * @return the identification number of the barrack.
     */
    public int getId() {
        return id;
    }

    /**
     * Set the Identification number of the barrack.
     *
     * @param identity the identification number of the barrack.
     */
    public void setId(final int identity) {
        this.id = identity;
    }

    /**
     * Get the nation this barrack belongs to.
     *
     * @return the nation this barrack belongs to.
     */
    public Nation getNation() {
        return nation;
    }

    /**
     * Set the nation this barrack belongs to.
     *
     * @param param The nation this barrack belongs to.
     */
    public void setNation(final Nation param) {
        this.nation = param;
    }

    /**
     * Get the relative position of the barrack.
     *
     * @return the relative position of the barrack.
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Set the relative position of the barrack.
     *
     * @param param the relative position of the barrack.
     */
    public void setPosition(final Position param) {
        this.position = param;
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
     * Get the name of the barrack.
     *
     * @return The name of the barrack.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the barrack.
     *
     * @param name The name to set.
     */
    public void setName(final String name) {
        this.name = name;
    }
}
