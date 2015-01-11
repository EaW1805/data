package com.eaw1805.data.model.map;

import java.io.Serializable;

/**
 * Holds information regarding the unit (Ship, Fleet, Baggage Train) that is transferring units (Spy, Commander, Brigade).
 */
public class CarrierInfo implements Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD

    /**
     * the type of the cargo unit.
     */
    private int carrierType;

    /**
     * the identity of the cargo unit.
     */
    private int carrierId;

    /**
     * Get the type of the cargo unit.
     *
     * @return the type of the cargo unit.
     */
    public int getCarrierType() {
        return carrierType;
    }

    /**
     * Set the type of the cargo unit.
     *
     * @param value the type of the cargo unit.
     */
    public void setCarrierType(final int value) {
        this.carrierType = value;
    }

    /**
     * Get the identity of the cargo unit.
     *
     * @return the identity of the cargo unit.
     */
    public int getCarrierId() {
        return carrierId;
    }

    /**
     * Set the identity of the cargo unit.
     *
     * @param value the identity of the cargo unit.
     */
    public void setCarrierId(final int value) {
        this.carrierId = value;
    }
}
