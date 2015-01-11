package com.eaw1805.data.dto.converters;

import com.eaw1805.data.dto.web.economy.StoredGoodDTO;
import com.eaw1805.data.dto.web.economy.TradeCityDTO;
import com.eaw1805.data.model.economy.TradeCity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Convert TradeCity DB objects into TradeCityDTOs.
 */
public final class TradeCityConverter {

    /**
     * Cannot instantiate this class.
     */
    private TradeCityConverter() {
        // empty constructor
    }

    /**
     * Convert the DB object into a DTO.
     *
     * @param tradeCityDb the DB object.
     * @return the DTO object.
     */
    public static TradeCityDTO convert(final TradeCity tradeCityDb) {
        final TradeCityDTO tCityDTO = new TradeCityDTO();
        tCityDTO.setId(tradeCityDb.getCityId());
        tCityDTO.setRegionId(tradeCityDb.getPosition().getRegion().getId());
        tCityDTO.setXStart(tradeCityDb.getPosition().getX());
        tCityDTO.setYStart(tradeCityDb.getPosition().getY());
        tCityDTO.setX(tradeCityDb.getPosition().getX());
        tCityDTO.setY(tradeCityDb.getPosition().getY());
        tCityDTO.setName(tradeCityDb.getName());
        tCityDTO.setOriginalName(tradeCityDb.getName());
        
        final Map<Integer, Integer> tradeLvl = new HashMap<Integer, Integer>();
        final Map<Integer, StoredGoodDTO> cityGoods = new HashMap<Integer, StoredGoodDTO>();
        for (Integer key : tradeCityDb.getGoodsTradeLvl().keySet()) {
            final StoredGoodDTO stGood = new StoredGoodDTO();
            stGood.getGoodDTO().setGoodId(key);
            stGood.setQte(tradeCityDb.getGoodsTradeLvl().get(key));
            cityGoods.put(key, stGood);
            tradeLvl.put(key, tradeCityDb.getGoodsTradeLvl().get(key));
        }

        tCityDTO.setGoodsTradeLvl(tradeLvl);
        tCityDTO.setGoodsDTO(cityGoods);
        return tCityDTO;
    }

    /**
     * Convert the list of DB object into a list of DTO.
     *
     * @param list the list of DB object.
     * @return the list of DTO object.
     */
    public static List<TradeCityDTO> convert(final List<TradeCity> list) {
        final List<TradeCityDTO> listDTOs = new ArrayList<TradeCityDTO>();
        for (final TradeCity value : list) {
            listDTOs.add(convert(value));
        }
        return listDTOs;
    }
}
