package com.eaw1805.data.model.economy;

import com.eaw1805.data.model.MapElement;
import com.eaw1805.data.model.Nation;
import com.eaw1805.data.model.map.Carrier;
import com.eaw1805.data.model.map.Position;

import java.io.Serializable;

/**
 * Represents a Baggage Train entity.
 */
public class BaggageTrain
        extends Carrier
        implements Serializable, MapElement {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD

    /**
     * The unique identifier of the baggage train.
     */
    private int baggageTrainId;

    /**
     * baggage train's relative coordinates.
     */
    private Position position;

    /**
     * The name of the baggage train.
     */
    private String name;

    /**
     * The nation that this baggage train belongs to.
     */
    private Nation nation;

    /**
     * The condition of the baggage train.
     */
    private int condition;

    /**
     * Get the unique identifier of the baggage train.
     *
     * @return the unique identifier of the baggage train.
     */
    public int getBaggageTrainId() {
        return baggageTrainId;
    }

    /**
     * Set the unique identifier of the baggage train.
     *
     * @param identity the unique identifier of the baggage train.
     */
    public void setBaggageTrainId(final int identity) {
        baggageTrainId = identity;
    }

    /**
     * Get the relative position of the baggage train.
     *
     * @return the relative position of the baggage train.
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Set the relative thisPosition of the baggage train.
     *
     * @param thisPosition the relative thisPosition of the baggage train.
     */
    public void setPosition(final Position thisPosition) {
        this.position = thisPosition;
    }

    /**
     * Get the name of the baggage train.
     *
     * @return the name of the baggage train.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the thisName of the baggage train.
     *
     * @param thisName the name of the baggage train.
     */
    public void setName(final String thisName) {
        this.name = thisName;
    }

    /**
     * Get the nation this baggage train belongs to.
     *
     * @return the nation this baggage train belongs to.
     */
    public Nation getNation() {
        return nation;
    }

    /**
     * Set the nation this baggage train belongs to.
     *
     * @param param The nation this baggage train belongs to.
     */
    public void setNation(final Nation param) {
        this.nation = param;
    }

    /**
     * Get the condition of the ship.
     *
     * @return the condition of the ship.
     */
    public int getCondition() {
        return condition;
    }

    /**
     * Set the condition of the ship.
     *
     * @param thisCond the condition of the ship.
     */
    public void setCondition(final int thisCond) {
        this.condition = thisCond;
    }

}
