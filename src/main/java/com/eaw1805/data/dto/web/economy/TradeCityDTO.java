package com.eaw1805.data.dto.web.economy;

import com.eaw1805.data.constants.ArmyConstants;
import com.eaw1805.data.constants.GoodConstants;
import com.eaw1805.data.dto.web.TradeUnitAbstractDTO;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class TradeCityDTO
        extends TradeUnitAbstractDTO
        implements com.google.gwt.user.client.rpc.IsSerializable, Serializable, ArmyConstants, GoodConstants {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 41L; //NOPMD

    /**
     * The basec constructor
     */

    public TradeCityDTO() {
        setUnitType(TRADECITY);
        soldGoods = new HashMap<Integer, Integer>();
        boughtGoods = new HashMap<Integer, Integer>();
        for (int i = GOOD_FIRST; i <= GOOD_LAST; i++) {
            soldGoods.put(i, 0);
            boughtGoods.put(i, 0);
        }
    }

    /**
     * Trade City's trade goods levels.
     */
    private Map<Integer, Integer> goodsTradeLvl;

    /**
     * Trade City's sold goods this turn.
     */
    private Map<Integer, Integer> soldGoods;

    /**
     * Trade City's bought goods this turn.
     */
    private Map<Integer, Integer> boughtGoods;

    /**
     * Get the Trade City's trade goods levels.
     *
     * @return the Trade City's trade goods levels.
     */
    public Map<Integer, Integer> getGoodsTradeLvl() {
        return goodsTradeLvl;
    }

    /**
     * Get the Trade City's sold goods.
     *
     * @return the Trade City's sold goods.
     */
    public Map<Integer, Integer> getSoldGoods() {
        return soldGoods;
    }

    /**
     * Get the Trade City's bought goods.
     *
     * @return the Trade City's bought goods.
     */
    public Map<Integer, Integer> getBoughtGoods() {
        return boughtGoods;
    }


    /**
     * Set the Trade City's trade goods levels.
     *
     * @param value the Trade City's trade goods levels.
     */
    public void setGoodsTradeLvl(final Map<Integer, Integer> value) {
        this.goodsTradeLvl = value;
    }

}
