package com.eaw1805.data.dto.converters;

import com.eaw1805.data.dto.common.SectorDTO;
import com.eaw1805.data.dto.web.RegionDTO;
import com.eaw1805.data.model.map.Region;

import java.util.ArrayList;
import java.util.List;

/**
 * Convert Region DB objects into RegionDTOs.
 */
public final class RegionConverter {

    /**
     * Cannot instantiate this class.
     */
    private RegionConverter() {
        // empty constructor
    }

    /**
     * Convert the DB object into a DTO.
     *
     * @param value the DB object.
     * @return the DTO object.
     */
    public static RegionDTO convert(final Region value) {
        final RegionDTO regDto = new RegionDTO();
        regDto.setRegionId(value.getId());
        regDto.setCode(value.getCode());
        regDto.setName(value.getName());

        return regDto;
    }

    /**
     * Convert the DB object into a DTO.
     *
     * @param value the DB object.
     * @param list  the list of SectorDTOs.
     * @return the DTO object.
     */
    public static RegionDTO convert(final Region value, final List<SectorDTO> list) {
        final RegionDTO regDto = new RegionDTO();
        regDto.setRegionId(value.getId());
        regDto.setCode(value.getCode());
        regDto.setName(value.getName());

        return regDto;
    }

    /**
     * Convert the list of DB object into a list of DTO.
     *
     * @param list the list of DB object.
     * @return the list of DTO object.
     */
    public static List<RegionDTO> convert(final List<Region> list) {
        final List<RegionDTO> listDTOs = new ArrayList<RegionDTO>();
        for (final Region value : list) {
            listDTOs.add(convert(value));
        }
        return listDTOs;
    }

}
