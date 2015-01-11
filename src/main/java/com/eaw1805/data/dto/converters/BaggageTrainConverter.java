package com.eaw1805.data.dto.converters;

import com.eaw1805.data.constants.ArmyConstants;
import com.eaw1805.data.constants.GoodConstants;
import com.eaw1805.data.dto.web.economy.BaggageTrainDTO;
import com.eaw1805.data.dto.web.economy.GoodDTO;
import com.eaw1805.data.dto.web.economy.StoredGoodDTO;
import com.eaw1805.data.managers.beans.GoodManagerBean;
import com.eaw1805.data.model.economy.BaggageTrain;
import com.eaw1805.data.model.economy.Good;
import com.eaw1805.data.model.economy.StoredGood;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Convert BaggageTrain DB objects into BaggageTrainDTOs.
 */
public final class BaggageTrainConverter {

    /**
     * Cannot instantiate this class.
     */
    private BaggageTrainConverter() {
        // empty constructor
    }

    /**
     * Convert the DB object into a DTO.
     *
     * @param value       the DB object.
     * @param goodManager a bean for accessing DB entities of type Good.
     * @return the DTO object.
     */
    public static BaggageTrainDTO convert(final BaggageTrain value, final GoodManagerBean goodManager) {
        final BaggageTrainDTO newDTO = new BaggageTrainDTO();
        newDTO.setId(value.getBaggageTrainId());
        newDTO.setNationId(value.getNation().getId());
        newDTO.setCondition(value.getCondition());
        newDTO.setOriginalCondition(value.getCondition());
        newDTO.setRegionId(value.getPosition().getRegion().getId());
        newDTO.setX(value.getPosition().getX());
        newDTO.setY(value.getPosition().getY());
        newDTO.setXStart(value.getPosition().getX());
        newDTO.setYStart(value.getPosition().getY());
        newDTO.setName(value.getName());
        newDTO.setScuttle(false);
        newDTO.setOriginalName(value.getName());
        for (int key : value.getStoredGoods().keySet()) {
            if (key > GoodConstants.GOOD_LAST) {
                // this is a unit loaded on the vessel
                final int cargoType;
                if (key >= ArmyConstants.SPY * 1000) {
                    cargoType = ArmyConstants.SPY;

                } else if (key >= ArmyConstants.COMMANDER * 1000) {
                    cargoType = ArmyConstants.COMMANDER;

                } else if (key >= ArmyConstants.BRIGADE * 1000) {
                    cargoType = ArmyConstants.BRIGADE;

                } else {
                    cargoType = -1;
                }

                if (!newDTO.getLoadedUnitsMap().containsKey(cargoType)) {
                    newDTO.getLoadedUnitsMap().put(cargoType, new ArrayList<Integer>());
                }
                newDTO.getLoadedUnitsMap().get(cargoType).add(value.getStoredGoods().get(key));
            }
        }

        newDTO.setGoodsDTO(generateGoodsMap(value, goodManager));
        newDTO.setOriginalGoodsDTO(generateGoodsMap(value, goodManager));
        return newDTO;
    }

    public static Map<Integer, StoredGoodDTO> generateGoodsMap(final BaggageTrain value, final GoodManagerBean goodManager) {
        final HashMap<Integer, StoredGoodDTO> goodsMap = new HashMap<Integer, StoredGoodDTO>();
        for (int key : value.getStoredGoods().keySet()) {
            if (key <= GoodConstants.GOOD_LAST) {
                final StoredGoodDTO goodsDTOmap = new StoredGoodDTO();
                goodsDTOmap.setTpe(key);
                goodsDTOmap.setQte(value.getStoredGoods().get(key));
                goodsDTOmap.setWarehouseId(value.getBaggageTrainId());

                final Good good = goodManager.getByID(key);
                final GoodDTO thisDTO = new GoodDTO();
                thisDTO.setGoodId(key);
                thisDTO.setGoodFactor(good.getGoodFactor());
                thisDTO.setName(good.getName());
                thisDTO.setWeightOfGood(good.getWeightOfGood());
                goodsDTOmap.setGoodDTO(thisDTO);

                goodsMap.put(goodsDTOmap.getTpe(), goodsDTOmap);

            }
        }
        return goodsMap;
    }

    public static GoodDTO convertGood(final Good value) {
        final GoodDTO thisDTO = new GoodDTO();
        thisDTO.setGoodId(value.getGoodId());
        thisDTO.setGoodFactor(value.getGoodFactor());
        thisDTO.setName(value.getName());
        thisDTO.setWeightOfGood(value.getWeightOfGood());

        return thisDTO;
    }

    public static StoredGoodDTO convertStoredGoodDTO(final StoredGood storedGood) {
        final StoredGoodDTO goodsDTOMap = new StoredGoodDTO();
        goodsDTOMap.setGoodDTO(convertGood(storedGood.getGoodType()));
        goodsDTOMap.setTpe(storedGood.getGoodType().getGoodId());
        goodsDTOMap.setQte(storedGood.getQte());
        return goodsDTOMap;
    }

    /**
     * Convert the list of DB object into a list of DTO.
     *
     * @param list        the list of DB object.
     * @param goodManager a bean for accessing DB entities of type Good.
     * @return the list of DTO object.
     */
    public static List<BaggageTrainDTO> convert(final List<BaggageTrain> list, final GoodManagerBean goodManager) {
        final List<BaggageTrainDTO> listDTOs = new ArrayList<BaggageTrainDTO>();
        for (final BaggageTrain value : list) {
            listDTOs.add(convert(value, goodManager));
        }
        return listDTOs;
    }

}
