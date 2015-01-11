package com.eaw1805.data.model.army;

import com.eaw1805.data.model.MapElement;
import com.eaw1805.data.model.Nation;
import com.eaw1805.data.model.map.Position;

import java.io.Serializable;
import java.util.Set;

/**
 * Represents army entities.
 */
public class Army
        implements Serializable, MapElement {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD

    /**
     * The identity of the army.
     */
    private int armyId;

    /**
     * Brigade's relative coordinates.
     */
    private Position position;

    /**
     * The nation that this brigade belongs to.
     */
    private Nation nation;

    /**
     * The name of the army.
     */
    private String name;

    /**
     * the available movement points.
     */
    private int mps;

    /**
     * The commander of the army.
     */
    private Commander commander;

    /**
     * The corps that constitute the army.
     */
    private Set<Corp> corps;

    /**
     * Get the identity of the army.
     *
     * @return the identity of the army.
     */
    public int getArmyId() {
        return armyId;
    }

    /**
     * Set the identity of the army.
     *
     * @param value the identity of the army.
     */
    public void setArmyId(final int value) {
        this.armyId = value;
    }

    /**
     * Get the relative position of the army.
     *
     * @return the relative position of the army.
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Set the relative position of the army.
     *
     * @param thisPosition the relative position of the army.
     */
    public void setPosition(final Position thisPosition) {
        this.position = thisPosition;
    }

    /**
     * Get the nation this army type belongs to.
     *
     * @return the nation this army type belongs to.
     */
    public Nation getNation() {
        return nation;
    }

    /**
     * Set the nation this army belongs to.
     *
     * @param param The nation this army belongs to.
     */
    public void setNation(final Nation param) {
        this.nation = param;
    }

    /**
     * The name of the army.
     *
     * @return The name of the army.
     */
    public String getName() {
        return name;
    }

    /**
     * Set The name of the army.
     *
     * @param value The name of the army.
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
     * Get the commander of the army.
     *
     * @return the commander of the army.
     */
    public Commander getCommander() {
        return commander;
    }

    /**
     * Set the commander of the army.
     *
     * @param value the commander of the army.
     */
    public void setCommander(final Commander value) {
        this.commander = value;
    }

    /**
     * The corps that constitute the army.
     *
     * @return the corps that constitute the army.
     */
    public Set<Corp> getCorps() {
        return corps;
    }

    /**
     * Set the corps that constitute the army.
     *
     * @param value the corps that constitute the army.
     */
    public void setCorps(final Set<Corp> value) {
        this.corps = value;
    }
}
