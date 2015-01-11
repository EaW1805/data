package com.eaw1805.data.model.fleet;

import com.eaw1805.data.model.MapElement;
import com.eaw1805.data.model.Nation;
import com.eaw1805.data.model.army.Commander;
import com.eaw1805.data.model.map.Position;

import java.io.Serializable;

/**
 * Represents fleet entities.
 */
public class Fleet
        implements Serializable, MapElement {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD

    /**
     * The identity of the fleet.
     */
    private int fleetId;

    /**
     * Brigade's relative coordinates.
     */
    private Position position;

    /**
     * The nation that this brigade belongs to.
     */
    private Nation nation;

    /**
     * The name of the fleet.
     */
    private String name;

    /**
     * the available movement points.
     */
    private int mps;

    /**
     * The commander of the fleet.
     */
    private Commander commander;

    /**
     * Get the identity of the fleet.
     *
     * @return the identity of the fleet.
     */
    public int getFleetId() {
        return fleetId;
    }

    /**
     * Set the identity of the fleet.
     *
     * @param value the identity of the fleet.
     */
    public void setFleetId(final int value) {
        this.fleetId = value;
    }

    /**
     * Get the relative position of the fleet.
     *
     * @return the relative position of the fleet.
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Set the relative position of the fleet.
     *
     * @param thisPosition the relative position of the fleet.
     */
    public void setPosition(final Position thisPosition) {
        this.position = thisPosition;
    }

    /**
     * Get the nation this fleet type belongs to.
     *
     * @return the nation this fleet type belongs to.
     */
    public Nation getNation() {
        return nation;
    }

    /**
     * Set the nation this fleet belongs to.
     *
     * @param param The nation this fleet belongs to.
     */
    public void setNation(final Nation param) {
        this.nation = param;
    }

    /**
     * The name of the fleet.
     *
     * @return The name of the fleet.
     */
    public String getName() {
        return name;
    }

    /**
     * Set The name of the fleet.
     *
     * @param value The name of the fleet.
     */
    public void setName(final String value) {
        this.name = value;
    }

    /**
     * Get the available movement points.
     *
     * @return the available movement points.
     */
    public int getMps() {
        return mps;
    }

    /**
     * Set the available movement points.
     *
     * @param thisMps the available movement points.
     */
    public void setMps(final int thisMps) {
        this.mps = thisMps;
    }

    /**
     * Get the commander of the fleet.
     *
     * @return the commander of the fleet.
     */
    public Commander getCommander() {
        return commander;
    }

    /**
     * Set the commander of the fleet.
     *
     * @param value the commander of the fleet.
     */
    public void setCommander(final Commander value) {
        this.commander = value;
    }

}
