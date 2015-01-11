package com.eaw1805.data.dto.converters;

import com.eaw1805.data.dto.common.TerrainDTO;
import com.eaw1805.data.model.map.Terrain;

import java.util.ArrayList;
import java.util.List;

/**
 * Convert Terrain DB objects into TerrainDTOs.
 */
public final class TerrainConverter {

    /**
     * Cannot instantiate this class.
     */
    private TerrainConverter() {
        // empty constructor
    }

    /**
     * Convert the DB object into a DTO.
     *
     * @param value the DB object.
     * @return the DTO object.
     */
    public static com.eaw1805.data.dto.common.TerrainDTO convert(final Terrain value) {
        final TerrainDTO terrainDTO = new com.eaw1805.data.dto.common.TerrainDTO();
        terrainDTO.setId(value.getId());
        terrainDTO.setActualMPs(value.getMps());
        terrainDTO.setMaxDensity(value.getMaxDensity());
        terrainDTO.setCode(value.getCode());
        terrainDTO.setName(value.getName());

        return terrainDTO;
    }

    /**
     * Convert the list of DB object into a list of DTO.
     *
     * @param list the list of DB object.
     * @return the list of DTO object.
     */
    public static List<com.eaw1805.data.dto.common.TerrainDTO> convert(final List<Terrain> list) {
        final List<com.eaw1805.data.dto.common.TerrainDTO> listDTOs = new ArrayList<TerrainDTO>();
        for (final Terrain value : list) {
            listDTOs.add(convert(value));
        }
        return listDTOs;
    }

}
