package com.eaw1805.data.dto.converters;

import com.eaw1805.data.dto.web.army.ArmyDTO;
import com.eaw1805.data.dto.web.army.CorpDTO;
import com.eaw1805.data.model.army.Army;
import com.eaw1805.data.model.army.Corp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Convert Army DB objects into ArmyDTOs.
 */
public final class ArmyConverter {

    /**
     * Cannot instantiate this class.
     */
    private ArmyConverter() {
        // empty constructor
    }

    /**
     * Convert the DB object into a DTO.
     *
     * @param value the DB object.
     * @return the DTO object.
     */
    public static ArmyDTO convert(final Army value) {
        final ArmyDTO thisDTO = new ArmyDTO();
        thisDTO.setArmyId(value.getArmyId());
        thisDTO.setName(value.getName());
        thisDTO.setOriginalName(value.getName());
        thisDTO.setRegionId(value.getPosition().getRegion().getId());
        thisDTO.setX(value.getPosition().getX());
        thisDTO.setY(value.getPosition().getY());
        thisDTO.setXStart(value.getPosition().getX());
        thisDTO.setYStart(value.getPosition().getY());
        thisDTO.setNationId(value.getNation().getId());

        if (value.getCommander() != null) {
            thisDTO.setCommander(CommanderConverter.convert(value.getCommander()));
        }

        final HashMap<Integer, CorpDTO> corpDTOList = new HashMap<Integer, CorpDTO>();

        // Include Corps of this Army
        for (final Corp corp : value.getCorps()) {
            corpDTOList.put(corp.getCorpId(), CorpConverter.convert(corp));
        }

        // Set Corp list
        thisDTO.setCorps(corpDTOList);

        return thisDTO;
    }

    /**
     * Convert the list of DB object into a list of DTO.
     *
     * @param list the list of DB object.
     * @return the list of DTO object.
     */
    public static List<ArmyDTO> convert(final List<Army> list) {
        final List<ArmyDTO> listDTOs = new ArrayList<ArmyDTO>();
        for (final Army value : list) {
            listDTOs.add(convert(value));
        }
        return listDTOs;
    }

}
