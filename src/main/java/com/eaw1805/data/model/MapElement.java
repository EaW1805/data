package com.eaw1805.data.model;

import com.eaw1805.data.model.map.Position;

/**
 * Interface implemented by all units that are positioned on a map.
 */
public interface MapElement {

    /**
     * Get the relative position of the mobile unit.
     *
     * @return the relative position of the mobile unit.
     */
    Position getPosition();

    /**
     * Set the relative position of the mobile unit.
     *
     * @param thisPosition the relative position of the mobile unit.
     */
    void setPosition(final Position thisPosition);

    /**
     * Get the nation this mobile unit belongs to.
     *
     * @return the nation this mobile unit belongs to.
     */
    Nation getNation();

    /**
     * Set the nation this mobile unit belongs to.
     *
     * @param param The nation this mobile unit belongs to.
     */
    void setNation(final Nation param);

}
