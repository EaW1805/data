package com.eaw1805.data.dto.converters;

import com.eaw1805.data.dto.web.army.CommanderDTO;
import com.eaw1805.data.model.army.Commander;

import java.util.ArrayList;
import java.util.List;

/**
 * Convert Commander DB objects into CommanderDTOs.
 */
public final class CommanderConverter {

    /**
     * Cannot instantiate this class.
     */
    private CommanderConverter() {
        // empty constructor
    }

    /**
     * Convert the DB object into a DTO.
     *
     * @param value the DB object.
     * @return the DTO object.
     */
    public static CommanderDTO convert(final Commander value) {
        final CommanderDTO commanderDTO = new CommanderDTO();
        commanderDTO.setId(value.getId());
        commanderDTO.setComc(value.getComc());
        commanderDTO.setStrc(value.getStrc());
        commanderDTO.setArmy(value.getArmy());
        commanderDTO.setStartArmy(value.getArmy());
        commanderDTO.setCorp(value.getCorp());
        commanderDTO.setStartCorp(value.getCorp());
        commanderDTO.setMps(value.getMps());
        commanderDTO.setName(value.getName());
        commanderDTO.setNationId(value.getNation().getId());
        commanderDTO.setRankId(value.getRank().getRankId());
        commanderDTO.setRegionId(value.getPosition().getRegion().getId());
        commanderDTO.setX(value.getPosition().getX());
        commanderDTO.setY(value.getPosition().getY());
        commanderDTO.setXStart(value.getPosition().getX());
        commanderDTO.setYStart(value.getPosition().getY());
        commanderDTO.setRank(RankConverter.convert(value.getRank()));
        commanderDTO.setIntId(value.getIntId());
        commanderDTO.setDead(value.getDead());
        commanderDTO.setStartInPool(value.getPool());
        commanderDTO.setPool(value.getPool());
        commanderDTO.setInTransit(value.getInTransit());
        commanderDTO.setTransit(value.getTransit());
        commanderDTO.setSupreme(value.getSupreme());
        commanderDTO.setSick(value.getSick());
        commanderDTO.setOriginalName(value.getName());
        commanderDTO.setCaptured(value.getCaptured().getId());

        // Detect if unit is loaded
        if (value.getCarrierInfo().getCarrierType() != 0) {
            commanderDTO.setLoaded(true);
            commanderDTO.setStartLoaded(true);
        }

        return commanderDTO;
    }

    /**
     * Convert the list of DB object into a list of DTO.
     *
     * @param list the list of DB object.
     * @return the list of DTO object.
     */
    public static List<CommanderDTO> convert(final List<Commander> list) {
        final List<CommanderDTO> listDTOs = new ArrayList<CommanderDTO>();
        for (final Commander value : list) {
            listDTOs.add(convert(value));
        }
        return listDTOs;
    }

}
