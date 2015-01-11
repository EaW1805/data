package com.eaw1805.data.dto.converters;

import com.eaw1805.data.dto.common.NaturalResourceDTO;
import com.eaw1805.data.model.map.NaturalResource;

import java.util.ArrayList;
import java.util.List;

/**
 * Convert NaturalResource DB objects into NaturalResourceDTOs.
 */
public final class NaturalResourceConverter {

    /**
     * Cannot instantiate this class.
     */
    private NaturalResourceConverter() {
        // empty constructor
    }

    /**
     * Convert the DB object into a DTO.
     *
     * @param value the DB object.
     * @return the DTO object.
     */
    public static NaturalResourceDTO convert(final NaturalResource value) {
        final NaturalResourceDTO empireNaturalResourceDTO = new NaturalResourceDTO();
        empireNaturalResourceDTO.setId(value.getId());
        empireNaturalResourceDTO.setCode(value.getCode());
        empireNaturalResourceDTO.setName(value.getName());

        return empireNaturalResourceDTO;
    }

    /**
     * Convert the list of DB object into a list of DTO.
     *
     * @param list the list of DB object.
     * @return the list of DTO object.
     */
    public static List<NaturalResourceDTO> convert(final List<NaturalResource> list) {
        final List<NaturalResourceDTO> listDTOs = new ArrayList<NaturalResourceDTO>();
        for (final NaturalResource value : list) {
            listDTOs.add(convert(value));
        }
        return listDTOs;
    }

}
