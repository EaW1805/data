package com.eaw1805.data.model.army;

import com.eaw1805.data.model.MapElement;
import com.eaw1805.data.model.Nation;
import com.eaw1805.data.model.map.Position;

import java.io.Serializable;
import java.util.Set;

/**
 * Represent Army Corps.
 */
public class Corp
        implements Serializable, MapElement {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD

    /**
     * The identity of the entity.
     */
    private int corpId;

    /**
     * Brigade's relative coordinates.
     */
    private Position position;

    /**
     * The nation that this brigade belongs to.
     */
    private Nation nation;

    /**
     * The name of the entity.
     */
    private String name;

    /**
     * the available movement points.
     */
    private int mps;

    /**
     * The army of the corp.
     */
    private Integer army;

    /**
     * The commander of the corp.
     */
    private Commander commander;

    /**
     * The brigades of the corp.
     */
    private Set<Brigade> brigades;

    /**
     * Get the identity of the entity.
     *
     * @return the identity of the entity.
     */
    public int getCorpId() {
        return corpId;
    }

    /**
     * Set the identity of the entity.
     *
     * @param value the identity of the entity.
     */
    public void setCorpId(final int value) {
        this.corpId = value;
    }

    /**
     * Get the relative position of the corp.
     *
     * @return the relative position of the corp.
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Set the relative position of the corp.
     *
     * @param thisPosition the relative position of the corp.
     */
    public void setPosition(final Position thisPosition) {
        this.position = thisPosition;
    }

    /**
     * Get the nation this corp type belongs to.
     *
     * @return the nation this corp type belongs to.
     */
    public Nation getNation() {
        return nation;
    }

    /**
     * Set the nation this corp belongs to.
     *
     * @param param The nation this corp belongs to.
     */
    public void setNation(final Nation param) {
        this.nation = param;
    }

    /**
     * The name of the Corp.
     *
     * @return The name of the Corp.
     */
    public String getName() {
        return name;
    }

    /**
     * Set The name of the Corp.
     *
     * @param value The name of the Corp.
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
     * Get the army of the corp.
     *
     * @return the army of the corp.
     */
    public Integer getArmy() {
        return army;
    }

    /**
     * Set the army of the corp.
     *
     * @param value the army of the corp.
     */
    public void setArmy(final Integer value) {
        this.army = value;
    }

    /**
     * Get the commander of the corp.
     *
     * @return the commander of the corp.
     */
    public Commander getCommander() {
        return commander;
    }

    /**
     * Set the commander of the corp.
     *
     * @param value the commander of the corp.
     */
    public void setCommander(final Commander value) {
        this.commander = value;
    }

    /**
     * The brigades of the corp.
     *
     * @return the brigades of the corp.
     */
    public Set<Brigade> getBrigades() {
        return brigades;
    }

    /**
     * Set the brigades of the corp.
     *
     * @param value the brigades of the corp.
     */
    public void setBrigades(final Set<Brigade> value) {
        this.brigades = value;
    }

}
