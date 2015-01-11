package com.eaw1805.data.dto.converters;

import com.eaw1805.data.dto.common.ProductionSiteDTO;
import com.eaw1805.data.model.map.ProductionSite;

import java.util.ArrayList;
import java.util.List;

/**
 * Convert ProductionSite DB objects into ProductionSiteDTOs.
 */
public final class ProductionSiteConverter {

    /**
     * Cannot instantiate this class.
     */
    private ProductionSiteConverter() {
        // empty constructor
    }

    /**
     * Convert the DB object into a DTO.
     *
     * @param value the DB object.
     * @return the DTO object.
     */
    public static ProductionSiteDTO convert(final ProductionSite value) {
        final ProductionSiteDTO empireProductionSiteDTO = new com.eaw1805.data.dto.common.ProductionSiteDTO();
        empireProductionSiteDTO.setId(value.getId());
        empireProductionSiteDTO.setCode(value.getCode());
        empireProductionSiteDTO.setCost(value.getCost());
        empireProductionSiteDTO.setName(value.getName());
        empireProductionSiteDTO.setTerrainsSuitable(value.getTerrainsSuitable());
        empireProductionSiteDTO.setAttritionMax(value.getAttritionMax());
        empireProductionSiteDTO.setAttritionMin(value.getAttritionMin());
        empireProductionSiteDTO.setMaintenanceCost(value.getMaintenanceCost());
        empireProductionSiteDTO.setMaxPopDensity(value.getMaxPopDensity());
        empireProductionSiteDTO.setMinPopDensity(value.getMinPopDensity());
        empireProductionSiteDTO.setDescription(value.getDescription());
        return empireProductionSiteDTO;
    }

    /**
     * Convert the list of DB object into a list of DTO.
     *
     * @param list the list of DB object.
     * @return the list of DTO object.
     */
    public static List<ProductionSiteDTO> convert(final List<ProductionSite> list) {
        final List<com.eaw1805.data.dto.common.ProductionSiteDTO> listDTOs = new ArrayList<ProductionSiteDTO>();
        for (final ProductionSite value : list) {
            listDTOs.add(convert(value));
        }
        return listDTOs;
    }

}
