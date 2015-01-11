package com.eaw1805.data.dto.converters;

import com.eaw1805.data.constants.ArmyConstants;
import com.eaw1805.data.constants.GoodConstants;
import com.eaw1805.data.dto.web.economy.GoodDTO;
import com.eaw1805.data.dto.web.economy.StoredGoodDTO;
import com.eaw1805.data.dto.web.fleet.ShipDTO;
import com.eaw1805.data.managers.beans.GoodManagerBean;
import com.eaw1805.data.model.economy.Good;
import com.eaw1805.data.model.fleet.Ship;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Convert Ship DB objects into ShipDTOs.
 */
public final class ShipConverter {

    /**
     * Cannot instantiate this class.
     */
    private ShipConverter() {
        // empty constructor
    }

    /**
     * Convert the DB object into a DTO.
     *
     * @param value       the DB object.
     * @param goodManager a bean for accessing DB entities of type Good.
     * @return the DTO object.
     */
    public static ShipDTO convert(final Ship value, final GoodManagerBean goodManager) {
        final ShipDTO empShip = new ShipDTO();
        empShip.setId(value.getShipId());
        empShip.setRegionId(value.getPosition().getRegion().getId());
        empShip.setNationId(value.getNation().getId());
        empShip.setTypeId(value.getType().getTypeId());
        empShip.setCondition(value.getCondition());
        empShip.setFleet(value.getFleet());
        empShip.setStartFleet(value.getFleet());
        empShip.setMarines(value.getMarines());
        empShip.setOriginalMarines(value.getMarines());
        empShip.setExp(value.getExp());
        empShip.setHasMoved(value.getHasMoved());
        empShip.setCapturedByNation(value.getCapturedByNation());

        empShip.setX(value.getPosition().getX());
        empShip.setY(value.getPosition().getY());
        empShip.setXStart(value.getPosition().getX());
        empShip.setYStart(value.getPosition().getY());
        empShip.setName(value.getName());
        empShip.setType(ShipTypeConverter.convert(value.getType()));
        empShip.setScuttle(false);

        // the original condition of the ship.
        empShip.setOriginalCondition(value.getCondition());

        // the original name of the ship
        empShip.setOriginalName(value.getName());

        empShip.setGoodsDTO(generateGoodsMap(value, goodManager));
        empShip.setOriginalGoodsDTO(generateGoodsMap(value, goodManager));

        if (goodManager != null && value.getStoredGoods() != null) {

            for (Integer key : value.getStoredGoods().keySet()) {
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

                    // make sure the list is initialized for the particular region
                    if (!empShip.getLoadedUnitsMap().containsKey(cargoType)) {
                        empShip.getLoadedUnitsMap().put(cargoType, new ArrayList<Integer>());
                    }

                    empShip.getLoadedUnitsMap().get(cargoType).add(value.getStoredGoods().get(key));
                }
            }
        }


        return empShip;
    }

    public static Map<Integer, StoredGoodDTO> generateGoodsMap(final Ship value, final GoodManagerBean goodManager) {
        final HashMap<Integer, StoredGoodDTO> goodsMap = new HashMap<Integer, StoredGoodDTO>();
        if (goodManager != null && value.getStoredGoods() != null) {

            for (Integer key : value.getStoredGoods().keySet()) {
                if (key <= GoodConstants.GOOD_LAST) {
                    final StoredGoodDTO goodsDTOmap = new StoredGoodDTO();
                    goodsDTOmap.setTpe(key);
                    goodsDTOmap.setQte(value.getStoredGoods().get(key));
                    goodsDTOmap.setWarehouseId(value.getShipId());

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
        }

        return goodsMap;

    }

    /**
     * Convert the list of DB object into a list of DTO.
     *
     * @param list        the list of DB object.
     * @param goodManager a bean for accessing DB entities of type Good.
     * @return the list of DTO object.
     */
    public static List<ShipDTO> convert(final List<Ship> list, final GoodManagerBean goodManager) {
        final List<ShipDTO> listDTOs = new ArrayList<ShipDTO>();
        for (final Ship value : list) {
            listDTOs.add(convert(value, goodManager));
        }
        return listDTOs;
    }

    /**
     * Convert the list of DB object into a list of DTO.
     *
     * @param list        the list of DB object.
     * @param goodManager a bean for accessing DB entities of type Good.
     * @return the list of DTO object.
     */
    public static Map<Integer, ShipDTO> convertToMap(final List<Ship> list, final GoodManagerBean goodManager) {
        final Map<Integer, ShipDTO> mapDTOs = new HashMap<Integer, ShipDTO>();
        for (final Ship value : list) {
            mapDTOs.put(value.getShipId(), convert(value, goodManager));
        }
        return mapDTOs;
    }

}

