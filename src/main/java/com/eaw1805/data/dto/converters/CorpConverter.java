package com.eaw1805.data.dto.converters;

import com.eaw1805.data.dto.web.army.BrigadeDTO;
import com.eaw1805.data.dto.web.army.CorpDTO;
import com.eaw1805.data.model.army.Brigade;
import com.eaw1805.data.model.army.Corp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Convert Corp DB objects into CorpDTOs.
 */
public final class CorpConverter {

    /**
     * Cannot instantiate this class.
     */
    private CorpConverter() {
        // empty constructor
    }

    /**
     * Convert the DB object into a DTO.
     *
     * @param value the DB object.
     * @return the DTO object.
     */
    public static CorpDTO convert(final Corp value) {
        final CorpDTO corpDTO = new CorpDTO();
        corpDTO.setCorpId(value.getCorpId());

        if (value.getArmy() == null) {
            corpDTO.setArmyId(0);
            corpDTO.setStartArmy(0);

        } else {
            corpDTO.setArmyId(value.getArmy());
            corpDTO.setStartArmy(value.getArmy());
        }

        corpDTO.setName(value.getName());
        corpDTO.setOriginalName(value.getName());
        corpDTO.setNationId(value.getNation().getId());
        if (value.getCorpId() != 0) {
            corpDTO.setRegionId(value.getPosition().getRegion().getId());
            corpDTO.setX(value.getPosition().getX());
            corpDTO.setY(value.getPosition().getY());
            corpDTO.setXStart(value.getPosition().getX());
            corpDTO.setYStart(value.getPosition().getY());
        }

        if (value.getCommander() != null) {
            corpDTO.setCommander(CommanderConverter.convert(value.getCommander()));
        }

        final Map<Integer, BrigadeDTO> brigadeDTOList = new HashMap<Integer, BrigadeDTO>();

        // Include Brigades of this Corp
        for (final Brigade brigade : value.getBrigades()) {
            final BrigadeDTO brigadeDTO = BrigadeConverter.convert(brigade);
            brigadeDTOList.put(brigadeDTO.getBrigadeId(), brigadeDTO);
        }

        corpDTO.setBrigades(brigadeDTOList);

        return corpDTO;
    }

    /**
     * Convert the list of DB object into a list of DTO.
     *
     * @param list the list of DB object.
     * @return the list of DTO object.
     */
    public static List<CorpDTO> convert(final List<Corp> list) {
        final List<CorpDTO> listDTOs = new ArrayList<CorpDTO>();
        for (final Corp value : list) {
            listDTOs.add(convert(value));
        }
        return listDTOs;
    }

}
