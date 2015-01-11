package com.eaw1805.data.dto.web.army;

import com.eaw1805.data.dto.common.PositionDTO;

import java.io.Serializable;

/**
 * Holds information related to foreign armies.
 */
public class ForeignArmyDTO
        extends PositionDTO
        implements com.google.gwt.user.client.rpc.IsSerializable, Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 12L; //NOPMD

    /**
     * The nation that this army belongs to.
     */
    private int nationId;

    /**
     * The total number of brigades.
     */
    private int totBrigades;

    /**
     * The total number of battalions.
     */
    private int totBattalions;

    /**
     * Get the nation this army belongs to.
     *
     * @return the nation this army belongs to.
     */
    public int getNationId() {
        return nationId;
    }

    /**
     * Set the nation this army belongs to.
     *
     * @param param The nation this army belongs to.
     */
    public void setNationId(final int param) {
        nationId = param;
    }

    /**
     * Get the total number of battalions.
     *
     * @return the total number of battalions.
     */
    public int getTotBattalions() {
        return totBattalions;
    }

    /**
     * Set the total number of battalions.
     *
     * @param value the total number of battalions.
     */
    public void setTotBattalions(final int value) {
        this.totBattalions = value;
    }

    /**
     * Get the total number of brigades.
     *
     * @return the total number of brigades.
     */
    public int getTotBrigades() {
        return totBrigades;
    }

    /**
     * Set the total number of brigades.
     *
     * @param value the total number of brigades.
     */
    public void setTotBrigades(final int value) {
        this.totBrigades = value;
    }
}
