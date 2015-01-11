package com.eaw1805.data.dto.web.economy;

import java.io.Serializable;

/**
 * Class that contains read-only information about the goods.
 */
public class GoodDTO
        implements com.google.gwt.user.client.rpc.IsSerializable, Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 28L; //NOPMD

    /**
     * The identification number of the good.
     */
    private int goodId;

    /**
     * The good's name.
     */
    private String name;

    /**
     * The good's GF (good factor).
     */
    private int goodFactor;

    /**
     * The good's weight, units per tone.
     */
    private int weightOfGood;


    /**
     * Get the Identification number of the good.
     *
     * @return the identification number of the good.
     */
    public int getGoodId() {
        return goodId;
    }

    /**
     * Set the identification number of the good.
     *
     * @param identity the identification number of the good.
     */
    public void setGoodId(final int identity) {
        this.goodId = identity;
    }

    /**
     * Get the name of the good.
     *
     * @return the name of the good.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the thisName of the good.
     *
     * @param thisName the name of the good.
     */
    public void setName(final String thisName) {
        this.name = thisName;
    }

    /**
     * Get the Good's Factor.
     *
     * @return the Good's Factor.
     */
    public int getGoodFactor() {
        return goodFactor;
    }

    /**
     * Set the Good's Factor.
     *
     * @param thisGoodFactor the good's Factor.
     */
    public void setGoodFactor(final int thisGoodFactor) {
        this.goodFactor = thisGoodFactor;
    }

    /**
     * Get the Good's weight in units per tone.
     *
     * @return the Good's weight in units per tone.
     */
    public int getWeightOfGood() {
        return weightOfGood;
    }

    /**
     * Set the Good's weight in units per tone.
     *
     * @param thisWeightOfGood the good's Factor in units per tone.
     */
    public void setWeightOfGood(final int thisWeightOfGood) {
        this.weightOfGood = thisWeightOfGood;
    }

}
