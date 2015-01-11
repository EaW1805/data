package com.eaw1805.data.dto.converters;


import com.eaw1805.data.dto.web.field.FieldBattleMapDTO;
import com.eaw1805.data.model.battles.field.FieldBattleMap;

public class FieldBattleMapConverter {

    /**
     * Cannot instantiate this class.
     */
    private FieldBattleMapConverter() {
        // empty constructor
    }

    /**
     * Convert the DB object into a DTO.
     *
     * @param value the DB object.
     * @return the DTO object.
     */
    public static FieldBattleMapDTO convert(final FieldBattleMap value) {
        FieldBattleMapDTO map = new FieldBattleMapDTO();
        map.setBattleId(value.getBattleId());
        map.setSectors(FieldBattleSectorConverter.convert(value.getSectors()));
        map.setSizeX(value.getSizeX());
        map.setSizeY(value.getSizeY());
        return map;
    }


}
