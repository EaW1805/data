package com.eaw1805.data.dto.web.fleet;

import com.eaw1805.data.constants.ArmyConstants;
import com.eaw1805.data.dto.web.TransportUnitDTO;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Represents fleet entities.
 */
public class FleetDTO
        extends TransportUnitDTO
        implements com.google.gwt.user.client.rpc.IsSerializable, Serializable, ArmyConstants {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 37L; //NOPMD

    /**
     * The identity of the fleet.
     */
    private int fleetId;

    /**
     * The nation that this corp belongs to.
     */
    private int nationId;

    /**
     * The name of the fleet.
     */
    private String name;

    /**
     * The original name of the fleet as is stored in the db.
     */
    private String originalName;
    /**
     * The ships of the fleet.
     */
    private Map<Integer, ShipDTO> ships = new HashMap<Integer, ShipDTO>();

    /**
     * Empty constructor
     */

    public FleetDTO() {
        setUnitType(FLEET);
    }

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
        this.setId(value);
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

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(final String originalName) {
        this.originalName = originalName;
    }

    /**
     * Get the ships of the fleet.
     *
     * @return the ships of the fleet.
     */
    public Map<Integer, ShipDTO> getShips() {
        return ships;
    }

    /**
     * Set the ships of the fleet.
     *
     * @param ships the ships of the fleet.
     */
    public void setShips(final Map<Integer, ShipDTO> ships) {
        this.ships = ships;
    }

}
