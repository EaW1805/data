package com.eaw1805.data.dto.web;

import com.eaw1805.data.dto.common.PositionDTO;

import java.io.Serializable;

/**
 * A class that contains the necessary items for a
 * unit that can be the cargo of other units
 */
public class CargoUnitDTO
        extends PositionDTO
        implements com.google.gwt.user.client.rpc.IsSerializable, Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 40L; //NOPMD

    /**
     * A boolean that indicates if the unit is loaded on a transport unit
     */
    private boolean loaded = false;

    /**
     * A boolean that indicates if the unit is loaded to a transport unit at the beginning of the round
     */
    private boolean startLoaded = false;

    /**
     * Get info if the unit is loaded.
     *
     * @return true if the unit is loaded.
     */
    public boolean getLoaded() {
        return loaded;
    }

    /**
     * Set the loaded info.
     *
     * @param value the variable that indicates loaded status.
     */
    public void setLoaded(final boolean value) {
        this.loaded = value;
    }


    /**
     * Get info if the unit is loaded at the beginning of the round.
     *
     * @return true if the unit is loaded at the beginning of the round.
     */
    public boolean getStartLoaded() {
        return startLoaded;
    }

    /**
     * Set the loaded info.
     *
     * @param value the variable that indicates loaded status.
     */
    public void setStartLoaded(final boolean value) {
        this.startLoaded = value;
    }
}