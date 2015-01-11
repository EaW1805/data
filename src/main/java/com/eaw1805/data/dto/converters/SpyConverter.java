package com.eaw1805.data.dto.converters;

import com.eaw1805.data.dto.web.army.SpyDTO;
import com.eaw1805.data.model.army.Spy;

import java.util.ArrayList;
import java.util.List;


/**
 * Convert Spy DB objects into SpyDTOs.
 */
public final class SpyConverter {

    /**
     * Cannot instantiate this class.
     */
    private SpyConverter() {
        // empty constructor
    }

    /**
     * Convert the DB object into a DTO.
     *
     * @param value the DB object.
     * @return the DTO object.
     */
    public static SpyDTO convert(final Spy value) {
        final SpyDTO dto = new SpyDTO();
        dto.setSpyId(value.getSpyId());
        dto.setName(value.getName());
        dto.setNationId(value.getNation().getId());
        dto.setRegionId(value.getPosition().getRegion().getId());
        dto.setX(value.getPosition().getX());
        dto.setY(value.getPosition().getY());
        dto.setXStart(value.getPosition().getX());
        dto.setYStart(value.getPosition().getY());
        dto.setColonial(value.getColonial());
        dto.setStationary(value.getStationary());
        dto.setReportBattalions(value.getReportBattalions());
        dto.setReportBrigades(value.getReportBrigades());
        dto.setReportShips(value.getReportShips());
        dto.setReportNearbyShips(value.getReportNearbyShips());
        dto.setReportTrade(value.getReportTrade());
        dto.setReportRelations(value.getReportRelations());
        dto.setOriginalName(value.getName());

        // Detect if unit is loaded
        if (value.getCarrierInfo().getCarrierType() != 0) {
            dto.setLoaded(true);
            dto.setStartLoaded(true);
        }

        return dto;
    }

    /**
     * Convert the list of DB object into a list of DTO.
     *
     * @param list the list of DB object.
     * @return the list of DTO object.
     */
    public static List<SpyDTO> convert(final List<Spy> list) {
        final List<SpyDTO> listDTOs = new ArrayList<SpyDTO>();
        for (final Spy value : list) {
            listDTOs.add(convert(value));
        }
        return listDTOs;
    }

}

