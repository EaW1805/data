package com.eaw1805.data.model.fleet;

import com.eaw1805.data.model.MapElement;
import com.eaw1805.data.model.Nation;
import com.eaw1805.data.model.map.Carrier;
import com.eaw1805.data.model.map.Position;

import java.io.Serializable;

/**
 * Models a ship.
 */
public class Ship
        extends Carrier
        implements Serializable, MapElement, Cloneable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD

    /**
     * The identity of the record.
     */
    private int shipId;

    /**
     * ship's relative coordinates.
     */
    private Position position;

    /**
     * The nation that this ship belongs to.
     */
    private Nation nation;

    /**
     * The name of the ship.
     */
    private String name;

    /**
     * the type of the ship.
     */
    private ShipType type;

    /**
     * The fleet of the ship.
     */
    private int fleet;

    /**
     * The condition of the ship.
     */
    private int condition;

    /**
     * Warships have marines on board.
     */
    private int marines;

    /**
     * The experience of the marines.
     */
    private int exp;

    /**
     * The id of the nation that has captured this ship.
     */
    private int capturedByNation;

    /**
     * If the ship has participated in a naval battle this turn.
     */
    private boolean navalBattle;

    /**
     * used to determine if the marines have received their monthly portion of wine or not.
     */
    private boolean noWine;

    /**
     * used to determine if a ship has moved during the turn.
     */
    private boolean hasMoved;

    /**
     * used to determine if a ship is constructed during this turn.
     */
    private boolean justConstructed;

    /**
     * Get the unique identifier of the ship.
     *
     * @return the unique identifier of the ship.
     */
    public int getShipId() {
        return shipId;
    }

    /**
     * Set the unique identifier of the ship.
     *
     * @param identity the unique identifier of the ship.
     */
    public void setShipId(final int identity) {
        this.shipId = identity;
    }

    /**
     * Get the relative position of the ship.
     *
     * @return the relative position of the ship.
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Set the relative position of the ship.
     *
     * @param thisPosition the relative position of the ship.
     */
    public void setPosition(final Position thisPosition) {
        this.position = thisPosition;
    }

    /**
     * Get the nation this ship belongs to.
     *
     * @return the nation this ship belongs to.
     */
    public Nation getNation() {
        return nation;
    }

    /**
     * Set the nation this ship belongs to.
     *
     * @param param The nation this ship belongs to.
     */
    public void setNation(final Nation param) {
        this.nation = param;
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
     * Set the thisName of the ship.
     *
     * @param thisName the name of the ship.
     */
    public void setName(final String thisName) {
        this.name = thisName;
    }

    /**
     * Get the type of the ship.
     *
     * @return the type of the ship.
     */
    public ShipType getType() {
        return type;
    }

    /**
     * Set the type of the ship.
     *
     * @param thisType the type of the ship.
     */
    public void setType(final ShipType thisType) {
        this.type = thisType;
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
     * Get if the ship has participated in a naval battle this turn.
     *
     * @return true, if the ship has participated in a naval battle this turn.
     */
    public boolean getNavalBattle() {
        return navalBattle;
    }

    /**
     * Set if the ship has participated in a naval battle this turn.
     *
     * @param value true if the ship has participated in a naval battle this turn.
     */
    public void setNavalBattle(final boolean value) {
        this.navalBattle = value;
    }

    /**
     * Get if the marines have received their monthly portion of wine or not.
     *
     * @return false, if the marines have received their monthly portion of wine.
     */
    public boolean getNoWine() {
        return noWine;
    }

    /**
     * Set if the marines have received their monthly portion of wine or not.
     *
     * @param value true, if the marines have NOT received their monthly portion of wine, otherwise false.
     */
    public void setNoWine(final boolean value) {
        this.noWine = value;
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
     * Set if the ship is constructed during this turn.
     *
     * @return true, if the ship is constructed during this turn.
     */
    public boolean getJustConstructed() {
        return justConstructed;
    }

    /**
     * Set if the ship is constructed during this turn.
     *
     * @param value true, if the ship is constructed during this turn.
     */
    public void setJustConstructed(final boolean value) {
        justConstructed = value;
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
     * Calculate the condition of the ship based on the tonnage lost.
     *
     * @param tonnageLost the tonnage lost.
     */
    public void calcCondition(final int tonnageLost) {
        double maxTonnage = getType().getWood() * Math.sqrt(getType().getShipClass());
        if (getType().getShipClass() == 0) {
            maxTonnage = getType().getWood();
        }
        final double currentTonnage = maxTonnage * getCondition() / 100d;
        final double newCondition = (currentTonnage - tonnageLost) / maxTonnage;
        setCondition((int) (newCondition * 100d));

        // Make sure we do not end up with negative condition or more than 100 condition
        if (getCondition() < 0) {
            setCondition(0);

        } else if (getCondition() > 100) {
            setCondition(100);
        }
    }

    public Ship clone() {
        final Ship newShip = new Ship();
        newShip.setShipId(getShipId());
        newShip.setType(getType());
        newShip.setPosition(getPosition());
        newShip.setNation(getNation());
        newShip.setName(getName());
        newShip.setCondition(getCondition());
        newShip.setMarines(getMarines());
        newShip.setExp(getExp());
        newShip.setFleet(getFleet());
        newShip.setCapturedByNation(getCapturedByNation());
        newShip.setStoredGoods(getStoredGoods());
        newShip.setNavalBattle(getNavalBattle());
        newShip.setNoWine(getNoWine());
        return newShip;
    }

}
