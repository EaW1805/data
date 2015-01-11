package com.eaw1805.data.dto.web;

import com.eaw1805.data.constants.ArmyConstants;
import com.eaw1805.data.constants.RegionConstants;
import com.eaw1805.data.dto.common.PositionDTO;
import com.eaw1805.data.dto.web.economy.StoredGoodDTO;

import java.io.Serializable;
import java.util.Map;

public class TradeUnitAbstractDTO
        extends PositionDTO
        implements com.google.gwt.user.client.rpc.IsSerializable, Serializable, ArmyConstants, RegionConstants {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 39L; //NOPMD

    /**
     * The unique identifier of the trade unit.
     */
    private int id;

    /**
     * The name of the trade unit.
     */
    private String name;

    /**
     * The original name of this unit as is stored in the db
     */
    private String originalName;

    /**
     * The nationId that this trade unit belongs to.
     */
    private int nationId;

    /**
     * The condition of the trade unit.
     */
    private int condition;

    private int originalCondition;

    /**
     * The type of the unit
     */
    private int unitType;

    /**
     * The contents of the trade unit.
     */
    private Map<Integer, StoredGoodDTO> goodsDTO;

    /**
     * The contents of the trade unit as stored in the db.
     */
    private Map<Integer, StoredGoodDTO> originalGoodsDTO;


    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the unit type
     */
    public int getUnitType() {
        return this.unitType;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the nationId
     */
    public int getNationId() {
        return nationId;
    }

    /**
     * @return the condition
     */
    public int getCondition() {
        return condition;
    }

    /**
     * @return the goodsDTO
     */
    public Map<Integer, StoredGoodDTO> getGoodsDTO() {
        return goodsDTO;
    }

    /**
     * @param value the id to set
     */
    public void setId(final int value) {
        this.id = value;
    }

    /**
     * @param value the name to set
     */
    public void setName(final String value) {
        this.name = value;
    }

    /**
     * @param value the unit type id to set
     */
    public void setUnitType(final int value) {
        this.unitType = value;
    }

    /**
     * @param value the nationId to set
     */
    public void setNationId(final int value) {
        this.nationId = value;
    }

    /**
     * @param value the condition to set
     */
    public void setCondition(final int value) {
        this.condition = value;
    }

    /**
     * @param value the goodsDTO to set
     */
    public void setGoodsDTO(final Map<Integer, StoredGoodDTO> value) {
        goodsDTO = value;
    }

    /**
     * Get the original condition of the unit, the condition before repair order if one exist.
     *
     * @return The original condition of the unit.
     */
    public int getOriginalCondition() {
        return originalCondition;
    }

    /**
     * Set the original condition of the unit.
     *
     * @param value The original condition.
     */
    public void setOriginalCondition(final int value) {
        this.originalCondition = value;
    }

    /**
     * The original name of the fleet.
     *
     * @return the original name of the fleet.
     */
    public String getOriginalName() {
        return originalName;
    }

    /**
     * Set the original name of the fleet.
     *
     * @param value the original name of the fleet.
     */
    public void setOriginalName(final String value) {
        originalName = value;
    }

    /**
     * Get the original goods stored in the unit before any transaction.
     *
     * @return A map with the goods.
     */
    public Map<Integer, StoredGoodDTO> getOriginalGoodsDTO() {
        return originalGoodsDTO;
    }

    /**
     * Set the original goods as stored in the db.
     *
     * @param value The value to set.
     */
    public void setOriginalGoodsDTO(final Map<Integer, StoredGoodDTO> value) {
        this.originalGoodsDTO = value;
    }
}
