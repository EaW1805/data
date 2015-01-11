package com.eaw1805.data.dto.converters;

import com.eaw1805.data.dto.web.army.BarrackDTO;
import com.eaw1805.data.model.map.Barrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Convert Barrack DB objects into BarrackDTOs.
 */
public final class BarrackConverter {

    /**
     * Cannot instantiate this class.
     */
    private BarrackConverter() {
        // empty constructor
    }

    /**
     * Convert the DB object into a DTO.
     *
     * @param value the DB object.
     * @return the DTO object.
     */
    public static BarrackDTO convert(final Barrack value) {
        final BarrackDTO newDTO = new BarrackDTO();
        newDTO.setId(value.getId());
        newDTO.setNationId(value.getNation().getId());
        newDTO.setRegionId(value.getPosition().getRegion().getId());
        newDTO.setX(value.getPosition().getX());
        newDTO.setY(value.getPosition().getY());
        newDTO.setXStart(value.getPosition().getX());
        newDTO.setYStart(value.getPosition().getY());
        newDTO.setNotSupplied(value.getNotSupplied());
        newDTO.setName(value.getName());
        newDTO.setOriginalName(value.getName());
        return newDTO;
    }

    /**
     * Convert the list of DB object into a list of DTO.
     *
     * @param list the list of DB object.
     * @return the list of DTO object.
     */
    public static List<BarrackDTO> convert(final List<Barrack> list) {
        final List<BarrackDTO> listDTOs = new ArrayList<BarrackDTO>();
        for (final Barrack value : list) {
            listDTOs.add(convert(value));
        }
        return listDTOs;
    }

}
