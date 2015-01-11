package com.eaw1805.data.dto.converters;

import com.eaw1805.data.dto.web.army.BattalionDTO;
import com.eaw1805.data.model.army.Battalion;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Convert Battalion DB objects into BattalionDTOs.
 */
public final class BattalionConverter {

    /**
     * Cannot instantiate this class.
     */
    private BattalionConverter() {
        // empty constructor
    }

    /**
     * Convert the DB object into a DTO.
     *
     * @param value the DB object.
     * @return the DTO object.
     */
    public static BattalionDTO convert(final Battalion value) {
        final BattalionDTO empBat = new BattalionDTO();
        empBat.setId(value.getId());
        empBat.setBrigadeId(value.getBrigade().getBrigadeId());
        empBat.setExperience(value.getExperience());
        empBat.setOriginalExperience(value.getExperience());
        empBat.setHeadcount(value.getHeadcount());
        empBat.setOriginalHeadcount(value.getHeadcount());
        empBat.setOrder(value.getOrder());

        // non persisting fields
        empBat.setAttackedByCav(value.isAttackedByCav());
        empBat.setExpIncByComm(value.getExpIncByComm());
        empBat.setFleeing(value.isFleeing());
        empBat.setParticipated(value.isParticipated());

        // Convert army type
        empBat.setTypeId(value.getType().getId());
        empBat.setEmpireArmyType(ArmyTypeConverter.convert(value.getType()));
        empBat.setOriginalArmyType(ArmyTypeConverter.convert(value.getType()));

        empBat.setNotSupplied(value.getNotSupplied());
        empBat.setHasLost(value.getHasLost());

        empBat.setStartBrigadeId(value.getBrigade().getBrigadeId());
        empBat.setStartOrder(value.getOrder());
        return empBat;
    }

    /**
     * Convert the list of DB object into a list of DTO.
     *
     * @param list the list of DB object.
     * @return the list of DTO object.
     */
    public static List<BattalionDTO> convert(final Set<Battalion> list) {
        final List<BattalionDTO> listDTOs = new ArrayList<BattalionDTO>();
        for (final Battalion value : list) {
            listDTOs.add(convert(value));
        }
        return listDTOs;
    }

    /**
     * Convert the list of DB object into a list of DTO.
     *
     * @param list the list of DB object.
     * @return the list of DTO object.
     */
    public static List<BattalionDTO> convert(final List<Battalion> list) {
        final List<BattalionDTO> listDTOs = new ArrayList<BattalionDTO>();
        for (final Battalion value : list) {
            listDTOs.add(convert(value));
        }
        return listDTOs;
    }

}
