package com.eaw1805.data.dto.converters;

import com.eaw1805.data.dto.web.economy.GoodDTO;
import com.eaw1805.data.dto.web.economy.StoredGoodDTO;
import com.eaw1805.data.dto.web.economy.WarehouseDTO;
import com.eaw1805.data.managers.beans.GoodManagerBean;
import com.eaw1805.data.model.economy.Good;
import com.eaw1805.data.model.economy.Warehouse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Convert Warehouse DB objects into WarehouseDTOs.
 */
public final class WarehouseConverter {

    /**
     * Cannot instantiate this class.
     */
    private WarehouseConverter() {
        // empty constructor
    }

    /**
     * Convert the DB object into a DTO.
     *
     * @param value       the DB object.
     * @param goodManager a bean for accessing DB entities of type Good.
     * @return the DTO object.
     */
    public static WarehouseDTO convert(final Warehouse value, final GoodManagerBean goodManager) {
        final WarehouseDTO empireWarehouseDTO = new WarehouseDTO();
        empireWarehouseDTO.setId(value.getId());
        empireWarehouseDTO.setNationId(value.getNation().getId());
        empireWarehouseDTO.setRegionId(value.getRegion().getId());
        empireWarehouseDTO.setGoodsDTO(generateGoodsMap(value, goodManager));
        empireWarehouseDTO.setOriginalGoodsDTO(generateGoodsMap(value, goodManager));
        return empireWarehouseDTO;
    }

    public static HashMap<Integer, StoredGoodDTO> generateGoodsMap(final Warehouse value, final GoodManagerBean goodManager) {
        final HashMap<Integer, StoredGoodDTO> goodsMap = new HashMap<Integer, StoredGoodDTO>();
        for (Integer key : value.getStoredGoodsQnt().keySet()) {
            final StoredGoodDTO goodsDTOmap = new StoredGoodDTO();
            goodsDTOmap.setTpe(key);
            goodsDTOmap.setQte(value.getStoredGoodsQnt().get(key));
            goodsDTOmap.setWarehouseId(value.getId());

            final Good good = goodManager.getByID(key);
            final GoodDTO thisDTO = new GoodDTO();
            thisDTO.setGoodId(key);
            thisDTO.setGoodFactor(good.getGoodFactor());
            thisDTO.setName(good.getName());
            thisDTO.setWeightOfGood(good.getWeightOfGood());
            goodsDTOmap.setGoodDTO(thisDTO);

            goodsMap.put(goodsDTOmap.getTpe(), goodsDTOmap);
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
    public static List<WarehouseDTO> convert(final List<Warehouse> list, final GoodManagerBean goodManager) {
        final List<WarehouseDTO> listDTOs = new ArrayList<WarehouseDTO>();
        for (final Warehouse value : list) {
            listDTOs.add(convert(value, goodManager));
        }
        return listDTOs;
    }

}
