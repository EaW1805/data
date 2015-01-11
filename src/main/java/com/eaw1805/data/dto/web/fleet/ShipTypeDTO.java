package com.eaw1805.data.dto.web.fleet;

import java.io.Serializable;

/**
 * Represents a particular ship type.
 */
public class ShipTypeDTO
        implements com.google.gwt.user.client.rpc.IsSerializable, Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 30L; //NOPMD

    /**
     * The unique identifier of the ship.
     */
    private int typeId;

    /**
     * The internal identifier of the ship.
     */
    private int intId;

    /**
     * The name of the ship.
     */
    private String name;

    /**
     * If the ship can be built on the colonies.
     */
    private boolean canColonies;

    /**
     * Wood required.
     */
    private int wood;

    /**
     * Industrial points required.
     */
    private int indPt;

    /**
     * Fabrics required.
     */
    private int fabrics;

    /**
     * Citizens required.
     */
    private int citizens;

    /**
     * Cost of each new ship.
     */
    private int cost;

    /**
     * Maintenance costs of the ship.
     */
    private int maintenance;

    /**
     * Loading capacity.
     */
    private int loadCapacity;

    /**
     * Movement factor.
     */
    private int movementFactor;

    /**
     * Ship class.
     */
    private int shipClass;

    /**
     * Get the unique identifier of the ship.
     *
     * @return the unique identifier of the ship.
     */
    public int getTypeId() {
        return typeId;
    }

    /**
     * Set the unique identifier of the ship.
     *
     * @param identity the unique identifier of the ship.
     */
    public void setTypeId(final int identity) {
        this.typeId = identity;
    }

    /**
     * Get the internal identifier of the ship.
     *
     * @return the internal identifier of the ship.
     */
    public int getIntId() {
        return intId;
    }

    /**
     * Set the internal identifier of the ship.
     *
     * @param thisIdentity the internal identifier of the ship.
     */
    public void setIntId(final int thisIdentity) {
        this.intId = thisIdentity;
    }

    /**
     * Get the name of the ship.
     *
     * @return the name of the ship.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the ship.
     *
     * @param thisName the name of the ship.
     */
    public void setName(final String thisName) {
        this.name = thisName;
    }

    /**
     * Get if the ship can be built on the colonies.
     *
     * @return if the ship can be built on the colonies.
     */
    public boolean getCanColonies() {  // NOPMD
        return canColonies;
    }

    /**
     * Set if the ship can be built on the colonies.
     *
     * @param isCol if the ship can be built on the colonies.
     */
    public void setCanColonies(final boolean isCol) {
        this.canColonies = isCol;
    }

    /**
     * Get the Wood required.
     *
     * @return the Wood required.
     */
    public int getWood() {
        return wood;
    }

    /**
     * Set the Wood required.
     *
     * @param thisWood the Wood required.
     */
    public void setWood(final int thisWood) {
        this.wood = thisWood;
    }

    /**
     * Get the Industrial points required.
     *
     * @return the Industrial points required.
     */
    public int getIndPt() {
        return indPt;
    }

    /**
     * Set the Industrial points required.
     *
     * @param thisEcPt the Industrial points required.
     */
    public void setIndPt(final int thisEcPt) {
        this.indPt = thisEcPt;
    }

    /**
     * Get the Fabrics required.
     *
     * @return the Fabrics required.
     */
    public int getFabrics() {
        return fabrics;
    }

    /**
     * Set the Fabrics required.
     *
     * @param thisText the Fabrics required.
     */
    public void setFabrics(final int thisText) {
        this.fabrics = thisText;
    }

    /**
     * Get the Citizens required.
     *
     * @return the Citizens required.
     */
    public int getCitizens() {
        return citizens;
    }

    /**
     * Set the Citizens required.
     *
     * @param thisCit the Citizens required.
     */
    public void setCitizens(final int thisCit) {
        this.citizens = thisCit;
    }

    /**
     * Get the Cost of each new ship.
     *
     * @return the Cost of each new ship.
     */
    public int getCost() {
        return cost;
    }

    /**
     * Set the Cost of each new ship.
     *
     * @param thisCost the Cost of each new ship.
     */
    public void setCost(final int thisCost) {
        this.cost = thisCost;
    }

    /**
     * Get the maintenance costs.
     *
     * @return the maintenance costs.
     */
    public int getMaintenance() {
        return maintenance;
    }

    /**
     * Set the maintenance costs.
     *
     * @param thisMain the maintenance costs.
     */
    public void setMaintenance(final int thisMain) {
        this.maintenance = thisMain;
    }

    /**
     * Get the Loading capacity.
     *
     * @return the Loading capacity.
     */
    public int getLoadCapacity() {
        return loadCapacity;
    }

    /**
     * Set the Loading capacity.
     *
     * @param thisLC the Loading capacity.
     */
    public void setLoadCapacity(final int thisLC) {
        this.loadCapacity = thisLC;
    }

    /**
     * Get the Movement factor.
     *
     * @return the Movement factor.
     */
    public int getMovementFactor() {
        return movementFactor;
    }

    /**
     * Set the Movement factor.
     *
     * @param thisMF the Movement factor.
     */
    public void setMovementFactor(final int thisMF) {
        this.movementFactor = thisMF;
    }

    /**
     * Get the Ship.
     *
     * @return the Ship.
     */
    public int getShipClass() {
        return shipClass;
    }

    /**
     * Set  the Ship.
     *
     * @param thisShipClass the Ship.
     */
    public void setShipClass(final int thisShipClass) {
        this.shipClass = thisShipClass;
    }

    /**
     * The number of cannons of the ship.
     *
     * @return number of cannons.
     */
    public int getCannons() {
        int totCannons = 0;
        if (shipClass > 0) {
            try {
                // try to extract cannons from name of ship class.
                totCannons = Integer.parseInt(getName().substring(0, getName().indexOf("Cannon") - 1));
            } catch (Exception ex) {
                // cannot parse name
                totCannons = 0;
            }
        }

        return totCannons;
    }
}
