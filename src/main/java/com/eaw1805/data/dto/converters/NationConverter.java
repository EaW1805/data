package com.eaw1805.data.dto.converters;

import com.eaw1805.data.dto.common.NationDTO;
import com.eaw1805.data.model.Nation;

import java.util.ArrayList;
import java.util.List;

/**
 * Convert Nation DB objects into NationDTOs.
 */
public final class NationConverter {

    /**
     * Cannot instantiate this class.
     */
    private NationConverter() {
        // empty constructor
    }

    /**
     * Convert the DB object into a DTO.
     *
     * @param value the DB object.
     * @return the DTO object.
     */
    public static NationDTO convert(final Nation value) {
        final NationDTO empireNationDTO = new NationDTO();
        empireNationDTO.setNationId(value.getId());
        empireNationDTO.setCode(value.getCode());
        empireNationDTO.setTaxRate(value.getTaxRate());
        empireNationDTO.setSphereOfInfluence(value.getSphereOfInfluence());
        empireNationDTO.setName(value.getName());
        empireNationDTO.setColor(value.getColor());

        return empireNationDTO;
    }

    /**
     * Convert the list of DB object into a list of DTO.
     *
     * @param list the list of DB object.
     * @return the list of DTO object.
     */
    public static List<NationDTO> convert(final List<Nation> list) {
        final List<NationDTO> listDTOs = new ArrayList<NationDTO>();
        for (final Nation value : list) {
            listDTOs.add(convert(value));
        }
        return listDTOs;
    }

}
