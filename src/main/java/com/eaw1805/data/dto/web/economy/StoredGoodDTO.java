package com.eaw1805.data.dto.web.economy;

import java.io.Serializable;

/**
 * Represents a quantity of goods stored.
 */
public class StoredGoodDTO
        implements com.google.gwt.user.client.rpc.IsSerializable, Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 29L; //NOPMD

    /**
     * Warehouse's identification number.
     */
    private int warehouseId;

    /**
     * The good type.
     */
    private int tpe;

    /**
     * The good quantity.
     */
    private int qte;

    /**
     * The Good type.
     */
    private GoodDTO goodDTO = new GoodDTO();

    /**
     * Get the warehouse identification number.
     *
     * @return the warehouse identification number.
     */
    public int getWarehouseId() {
        return warehouseId;
    }

    /**
     * Set the warehouse identification number.
     *
     * @param identity the warehouse identification number.
     */
    public void setWarehouseId(final int identity) {
        warehouseId = identity;
    }

    /**
     * Get the good type.
     *
     * @return the good type.
     */
    public int getTpe() {
        return tpe;
    }

    /**
     * Set the good type.
     *
     * @param value the good type.
     */
    public void setTpe(final int value) {
        this.tpe = value;
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
     * Set  the quantity.
     *
     * @param value the quantity.
     */
    public void setQte(final int value) {
        this.qte = value;
    }

    /**
     * Get the Good type.
     *
     * @return the Good type.
     */
    public GoodDTO getGoodDTO() {
        return goodDTO;
    }

    /**
     * Set  the Good type.
     *
     * @param value the Good type.
     */
    public void setGoodDTO(final GoodDTO value) {
        this.goodDTO = value;
    }

}
