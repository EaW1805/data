package com.eaw1805.data.model.economy;

import java.io.Serializable;

/**
 * Represents a quantity of goods stored.
 */
public class StoredGood implements Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD

    /**
     * The good type.
     */
    private Good goodType;

    /**
     * The good quantity.
     */
    private int qte;

    /**
     * Get the good type.
     *
     * @return the good type.
     */
    public Good getGoodType() {
        return goodType;
    }

    /**
     * Set the good type.
     *
     * @param value the good type.
     */
    public void setGoodType(final Good value) {
        this.goodType = value;
    }

    /**
     * Get the quantity.
     *
     * @return the quantity.
     */
    public int getQte() {
        return qte;
    }

    /**
     * Set the quantity.
     *
     * @param value the quantity.
     */
    public void setQte(final int value) {
        this.qte = qte;
    }
}
