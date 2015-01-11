package com.eaw1805.data.model.economy;

import com.eaw1805.data.model.Game;
import com.eaw1805.data.model.Nation;
import com.eaw1805.data.model.map.Region;

import java.io.Serializable;
import java.util.Map;

/**
 * Class for holding all the information about the warehouse.
 */
public class Warehouse implements Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD

    /**
     * Warehouse's identification number.
     */
    private int id; // NOPMD

    /**
     * Warehouse's game id.
     */
    private Game game;

    /**
     * Warehouse's nation owner.
     */
    private Nation nation;

    /**
     * Warehouse's region location.
     */
    private Region region;

    /**
     * Warehouse's stored goods quantity.
     */
    private Map<Integer, Integer> storedGoodsQnt;

    /**
     * Get the warehouse identification number.
     *
     * @return the warehouse identification number.
     */
    public int getId() {
        return id;
    }

    /**
     * Set the warehouse identification number.
     *
     * @param identity the warehouse identification number.
     */
    public void setId(final int identity) {
        this.id = identity;
    }

    /**
     * Get the nation that this warehouse belongs to.
     *
     * @return the nation owner.
     */
    public com.eaw1805.data.model.Nation getNation() {
        return nation;
    }

    /**
     * Set the nation that this warehouse belongs to.
     *
     * @param thisNation the Nation onwer.
     */
    public void setNation(final com.eaw1805.data.model.Nation thisNation) {
        this.nation = thisNation;
    }

    /**
     * Get the region that the warehouse is located.
     *
     * @return the region of the warehouse.
     */
    public com.eaw1805.data.model.map.Region getRegion() {
        return region;
    }

    /**
     * Set the region that the warehouse is located.
     *
     * @param thisRegion the region of the warehouse.
     */
    public void setRegion(final com.eaw1805.data.model.map.Region thisRegion) {
        this.region = thisRegion;
    }

    /**
     * Set the game of the warehouse.
     *
     * @return the game of the warehouse.
     */
    public com.eaw1805.data.model.Game getGame() {
        return game;
    }

    /**
     * Set the game of the warehouse.
     *
     * @param thisGame the game of the warehouse.
     */
    public void setGame(final com.eaw1805.data.model.Game thisGame) {
        this.game = thisGame;
    }

    /**
     * Get the stored goods in the warehouse.
     *
     * @return a list with the stored goods Quantity.
     */
    public java.util.Map<Integer, Integer> getStoredGoodsQnt() {
        return storedGoodsQnt;
    }

    /**
     * Get the stored goods in the warehouse.
     *
     * @param lstGoodsQnt a list with the stored goods Quantity.
     */
    public void setStoredGoodsQnt(final java.util.Map<Integer, Integer> lstGoodsQnt) {
        this.storedGoodsQnt = lstGoodsQnt;
    }

}
