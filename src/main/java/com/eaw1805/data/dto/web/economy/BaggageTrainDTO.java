package com.eaw1805.data.dto.web.economy;


import com.eaw1805.data.constants.ArmyConstants;
import com.eaw1805.data.dto.web.TransportUnitDTO;

import java.io.Serializable;

/**
 * Represents a Baggage Train entity.
 */
public class BaggageTrainDTO
        extends TransportUnitDTO
        implements com.google.gwt.user.client.rpc.IsSerializable, Serializable, ArmyConstants {

    /**
     * True if user scuttles baggage train.
     */
    private boolean scuttle;

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 35L; //NOPMD

    public BaggageTrainDTO() {
        setUnitType(BAGGAGETRAIN);
    }

    /**
     * Get the movement points of this baggage train.
     *
     * @return The mp's.
     */
    public int getMps() {
        return (int) (80d * this.getCondition() / 100d);
    }

    /**
     * Get if baggage train is scuttled.
     *
     * @return True if scuttle.
     */
    public boolean isScuttle() {
        return scuttle;
    }

    /**
     * Set if baggage train is scuttled.
     *
     * @param scuttle The value to set.
     */
    public void setScuttle(final boolean scuttle) {
        this.scuttle = scuttle;
    }

}
