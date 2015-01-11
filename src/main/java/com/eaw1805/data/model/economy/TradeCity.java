package com.eaw1805.data.model.economy;

import com.eaw1805.data.managers.map.SectorManager;
import com.eaw1805.data.model.MapElement;
import com.eaw1805.data.model.Nation;
import com.eaw1805.data.model.map.Position;

import java.io.Serializable;
import java.util.Map;

/**
 * Class for holding all the information about the trade cities.
 */
public class TradeCity
        implements Serializable, MapElement {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD

    /**
     * The unique identifier of the trade city.
     */
    private int cityId;

    /**
     * trade city's relative coordinates.
     */
    private Position position;

    /**
     * The name of the trade city.
     */
    private String name;

    /**
     * Trade City's trade goods levels.
     */
    private Map<Integer, Integer> goodsTradeLvl;

    /**
     * Get the unique identifier of the trade city.
     *
     * @return the unique identifier of the trade city.
     */
    public int getCityId() {
        return cityId;
    }

    /**
     * Set the unique identifier of the trade city.
     *
     * @param value the unique identifier of the trade city.
     */
    public void setCityId(final int value) {
        this.cityId = value;
    }

    /**
     * Get the position of the trade city.
     *
     * @return the position of the trade city.
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Set the position of the trade city.
     *
     * @param value the position of the trade city.
     */
    public void setPosition(final Position value) {
        this.position = value;
    }

    /**
     * Get the name of the trade city.
     *
     * @return the name of the trade city.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the trade city.
     *
     * @param value the name of the trade city.
     */
    public void setName(final String value) {
        this.name = value;
    }

    /**
     * Get the Trade City's trade goods levels.
     *
     * @return the Trade City's trade goods levels.
     */
    public Map<Integer, Integer> getGoodsTradeLvl() {
        return goodsTradeLvl;
    }

    /**
     * Set the Trade City's trade goods levels.
     *
     * @param value the Trade City's trade goods levels.
     */
    public void setGoodsTradeLvl(final Map<Integer, Integer> value) {
        this.goodsTradeLvl = value;
    }

    /**
     * Get the nation this mobile unit belongs to.
     *
     * @return the nation this mobile unit belongs to.
     */
    public Nation getNation() {
        return SectorManager.getInstance().getByPosition(getPosition()).getNation();
    }

    /**
     * Set the nation this mobile unit belongs to.
     *
     * @param param The nation this mobile unit belongs to.
     */
    public void setNation(final Nation param) {
        // Not implemented
    }
}
