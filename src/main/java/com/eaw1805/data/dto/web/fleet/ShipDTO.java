package com.eaw1805.data.dto.web.fleet;

import com.eaw1805.data.constants.ArmyConstants;
import com.eaw1805.data.dto.web.TransportUnitDTO;

import java.io.Serializable;

/**
 * Models a ship.
 */
public class ShipDTO
        extends TransportUnitDTO
        implements com.google.gwt.user.client.rpc.IsSerializable, Serializable, ArmyConstants {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 19L; //NOPMD

    /**
     * the type of the ship.
     */
    private int typeId;

    /**
     * the type of the ship.
     */
    private ShipTypeDTO type = new ShipTypeDTO();

    /**
     * The fleet of the ship.
     */
    private int fleet;

    /**
     * The fleet id in which the ship started this turn
     */
    private int startFleet = 0;

    /**
     * Warships have marines on board.
     */
    private int marines;

    /**
     * The original number of marines for this ship as stored in database.
     */
    private int originalMarines;

    /**
     * The experience of the marines.
     */
    private int exp;

    /**
     * The id of the nation that has captured this ship.
     */
    private int capturedByNation;

    /**
     * A boolean indicating load/unload troops phase
     */
    private boolean phaseOne = true;

    /**
     * The id of the nation to which you will hand over the ship
     * 0 value means that the ship remains yours
     */
    private int hOverNationId = 0;

    /**
     * used to determine if a ship has moved during the turn.
     */
    private boolean hasMoved;

    /**
     * True if ship has been scuttled.
     */
    private boolean scuttle;

    /**
     * True if for this ship the order to be constructed has been given in the current round.
     */
    private boolean justUnderConstruction;

    public ShipDTO() {
        setUnitType(SHIP);
    }

    /**
     * Get the type of the ship.
     *
     * @return the type of the ship.
     */
    public int getTypeId() {
        return typeId;
    }

    /**
     * Set the type of the ship.
     *
     * @param thisType the type of the ship.
     */
    public void setTypeId(final int thisType) {
        typeId = thisType;
    }

    /**
     * Get the fleet of the ship.
     *
     * @return the fleet of the ship.
     */
    public int getFleet() {
        return fleet;
    }

    /**
     * Set the fleet of the ship.
     *
     * @param thisFed the fleet of the ship.
     */
    public void setFleet(final int thisFed) {
        this.fleet = thisFed;
    }

    /**
     * Get the marines on board the warship.
     *
     * @return the marines on board the warship.
     */
    public int getMarines() {
        return marines;
    }

    /**
     * Set the marines on board the warship.
     *
     * @param thisMarines the marines on board the warship.
     */
    public void setMarines(final int thisMarines) {
        this.marines = thisMarines;
    }

    /**
     * Get the original number of marines as stored in database.
     *
     * @return The original number of marines.
     */
    public int getOriginalMarines() {
        return originalMarines;
    }

    /**
     * Set the original number of marines.
     *
     * @param value The value to set.
     */
    public void setOriginalMarines(final int value) {
        this.originalMarines = value;
    }

    /**
     * Get the experience of the marines.
     *
     * @return the experience of the marines.
     */
    public int getExp() {
        return exp;
    }

    /**
     * Set the experience of the marines.
     *
     * @param value the experience of the marines.
     */
    public void setExp(final int value) {
        this.exp = value;
    }

    /**
     * Get the type of the ship.
     *
     * @return the type of the ship.
     */
    public ShipTypeDTO getType() {
        return type;
    }

    /**
     * Set the type of the ship.
     *
     * @param thisType the type of the ship.
     */
    public void setType(final ShipTypeDTO thisType) {
        this.type = thisType;
    }

    /**
     * @return the hOverNationId
     */
    public int gethOverNationId() {
        return hOverNationId;
    }

    /**
     * @param hOverNationId the hOverNationId to set
     */
    public void sethOverNationId(final int hOverNationId) {
        this.hOverNationId = hOverNationId;
    }

    /**
     * Gets the loading troops phase
     *
     * @return true if the phase is one
     */
    public boolean isPhaseOne() {
        return this.phaseOne;
    }

    /**
     * Sets the loading troops phase
     *
     * @param value set true if one or false if two
     */
    public void setPhaseOne(final boolean value) {
        this.phaseOne = value;
    }


    /**
     * Get the fleet in which the ship started.
     *
     * @return the fleetId in which the ship started
     */
    public int getStartFleet() {
        return startFleet;
    }

    /**
     * Set the fleet in which the ship started.
     *
     * @param value the shipId in which the ship started
     */
    public void setStartFleet(final int value) {
        this.startFleet = value;
    }

    /**
     * Get the id of the nation that has captured this ship (if any).
     *
     * @return the id of the nation that has captured the ship.
     */
    public int getCapturedByNation() {
        return capturedByNation;
    }

    /**
     * Set the id of the nation that has captured this ship (if any).
     *
     * @param value the id of the nation that has captured the ship.
     */
    public void setCapturedByNation(final int value) {
        this.capturedByNation = value;
    }

    /**
     * Get if the battalion has moved during the turn.
     *
     * @return true, if the battalion has moved during the turn.
     */
    public boolean getHasMoved() {
        return hasMoved;
    }

    /**
     * Set if the battalion has moved during the turn.
     *
     * @param value true, if the battalion has moved during the turn.
     */
    public void setHasMoved(final boolean value) {
        this.hasMoved = value;
    }

    /**
     * Calculate the tonnage of the ship.
     *
     * @return the tonnage of the ship.
     */
    public int calcTonnage() {
        double tonnage = getCondition() * getType().getWood() * Math.sqrt(getType().getShipClass()) / 100d;
        if (getType().getShipClass() == 0) {
            tonnage = getCondition() * getType().getWood() / 100d;
        }
        return (int) tonnage;
    }

    /**
     * Get if ship is scuttled.
     *
     * @return True if scuttle ship.
     */
    public boolean isScuttle() {
        return scuttle;
    }

    /**
     * Set scuttle ship.
     *
     * @param scuttle The value to set.
     */
    public void setScuttle(final boolean scuttle) {
        this.scuttle = scuttle;
    }

    /**
     * Get if ship is under construction and the order has been given in the current round.
     *
     * @return True if the order to be constructed is in the current round.
     */
    public boolean isJustUnderConstruction() {
        return justUnderConstruction;
    }

    /**
     * Set if the ship is under construction and the order has been given in the current round.
     * @param justUnderConstruction
     */
    public void setJustUnderConstruction(boolean justUnderConstruction) {
        this.justUnderConstruction = justUnderConstruction;
    }
}
