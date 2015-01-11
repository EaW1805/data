package com.eaw1805.data.model.orders;

import com.eaw1805.data.model.Nation;
import com.eaw1805.data.model.fleet.Ship;
import com.eaw1805.data.model.map.Position;
import com.eaw1805.data.model.map.Sector;

import java.util.List;
import java.util.Set;

/**
 * Captures all the details related to a patrol order.
 */
public class PatrolOrderDetails {

    /**
     * The id of the player order.
     */
    private int orderId;

    /**
     * Nation owner.
     */
    private Nation nation;

    /**
     * The ships participating in the patrol order.
     */
    private List<Ship> ships;

    /**
     * The movement path of the patrol order.
     */
    private Set<Sector> path;

    /**
     * The tonnage of the patrolling fleet/ship.
     */
    private int tonnage;

    /**
     * The patrolling fleet/ship's speed (i.e. maximum movement potential).
     */
    private int maxMP;

    /**
     * Unspent movement point of the patrolling fleet.
     */
    private int unspentMP;

    /**
     * Indicates if the patrol has already intercept an army.
     */
    private boolean intercept;

    /**
     * Indicates if the patrol is triggered to intercept. This is a flag for a 2-phase commit procedure.
     */
    private boolean triggered;

    /**
     * The position of the intercept.
     */
    private Position position;

    /**
     * Get the id of the player order.
     *
     * @return the id of the player order.
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * Set the id of the player order.
     *
     * @param value the id of the player order.
     */
    public void setOrderId(final int value) {
        this.orderId = value;
    }

    /**
     * Get the Nation issuing the order.
     *
     * @return the Nation issuing the order.
     */
    public Nation getNation() {
        return nation;
    }

    /**
     * Set the Nation issuing the order.
     *
     * @param empireID the Nation issuing the order.
     */
    public void setNation(final Nation empireID) {
        this.nation = empireID;
    }

    /**
     * Get the ships participating in the patrol order.
     *
     * @return the ships participating in the patrol order.
     */
    public List<Ship> getShips() {
        return ships;
    }

    /**
     * Set the ships participating in the patrol order.
     *
     * @param value the ships participating in the patrol order.
     */
    public void setShips(final List<Ship> value) {
        this.ships = value;
    }

    /**
     * Get the movement path of the patrol order.
     *
     * @return the movement path of the patrol order.
     */
    public Set<Sector> getPath() {
        return path;
    }

    /**
     * Set the movement path of the patrol order.
     *
     * @param value the movement path of the patrol order.
     */
    public void setPath(final Set<Sector> value) {
        this.path = value;
    }

    /**
     * Get the tonnage of the patrolling fleet/ship.
     *
     * @return the tonnage of the patrolling fleet/ship.
     */
    public int getTonnage() {
        return tonnage;
    }

    /**
     * Set the tonnage of the patrolling fleet/ship.
     *
     * @param value the tonnage of the patrolling fleet/ship.
     */
    public void setTonnage(final int value) {
        this.tonnage = value;
    }

    /**
     * Get the patrolling fleet/ship's speed (i.e. maximum movement potential).
     *
     * @return the patrolling fleet/ship's speed (i.e. maximum movement potential).
     */
    public int getMaxMP() {
        return maxMP;
    }

    /**
     * Set the patrolling fleet/ship's speed (i.e. maximum movement potential).
     *
     * @param value the patrolling fleet/ship's speed (i.e. maximum movement potential).
     */
    public void setMaxMP(final int value) {
        this.maxMP = value;
    }

    /**
     * Get the unspent movement point of the patrolling fleet.
     *
     * @return the unspent movement point of the patrolling fleet.
     */
    public int getUnspentMP() {
        return unspentMP;
    }

    /**
     * Set the unspent movement point of the patrolling fleet.
     *
     * @param value the unspent movement point of the patrolling fleet.
     */
    public void setUnspentMP(final int value) {
        this.unspentMP = value;
    }

    /**
     * Get the indicator if the patrol has already intercept an army.
     *
     * @return the indicator if the patrol has already intercept an army.
     */
    public boolean getIntercept() {
        return intercept;
    }

    /**
     * Set the indicator if the patrol has already intercept an army.
     *
     * @param value the indicator if the patrol has already intercept an army.
     */
    public void setIntercept(final boolean value) {
        this.intercept = value;
    }

    /**
     * Get if the patrol is triggered to intercept. This is a flag for a 2-phase commit procedure.
     *
     * @return if the patrol is triggered to intercept. This is a flag for a 2-phase commit procedure.
     */
    public boolean getTriggered() {
        return triggered;
    }

    /**
     * Set if the patrol is triggered to intercept. This is a flag for a 2-phase commit procedure.
     *
     * @param value if the patrol is triggered to intercept. This is a flag for a 2-phase commit procedure.
     */
    public void setTriggered(final boolean value) {
        this.triggered = value;
    }

    /**
     * Get the position of the intercept.
     *
     * @return the position of the intercept.
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Set the position of the intercept.
     *
     * @param thisPosition the position of the intercept.
     */
    public void setPosition(final Position thisPosition) {
        this.position = thisPosition;
    }

}
