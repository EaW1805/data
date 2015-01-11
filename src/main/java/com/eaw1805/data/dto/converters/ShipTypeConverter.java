package com.eaw1805.data.dto.converters;

import com.eaw1805.data.dto.web.fleet.ShipTypeDTO;
import com.eaw1805.data.model.fleet.ShipType;

import java.util.ArrayList;
import java.util.List;

/**
 * Convert ShipType DB objects into ShipTypeDTOs.
 */
public final class ShipTypeConverter {

    /**
     * Cannot instantiate this class.
     */
    private ShipTypeConverter() {
        // empty constructor
    }

    /**
     * Convert the DB object into a DTO.
     *
     * @param value the DB object.
     * @return the DTO object.
     */
    public static ShipTypeDTO convert(final ShipType value) {
        final ShipTypeDTO empireShipTypeDTO = new ShipTypeDTO();
        empireShipTypeDTO.setTypeId(value.getTypeId());
        empireShipTypeDTO.setName(value.getName());
        empireShipTypeDTO.setIntId(value.getIntId());
        empireShipTypeDTO.setCanColonies(value.getCanColonies());
        empireShipTypeDTO.setCitizens(value.getCitizens());
        empireShipTypeDTO.setCost(value.getCost());
        empireShipTypeDTO.setLoadCapacity(value.getLoadCapacity());
        empireShipTypeDTO.setMaintenance(value.getMaintenance());
        empireShipTypeDTO.setMovementFactor(value.getMovementFactor());
        empireShipTypeDTO.setShipClass(value.getShipClass());
        empireShipTypeDTO.setFabrics(value.getFabrics());
        empireShipTypeDTO.setWood(value.getWood());
        empireShipTypeDTO.setIndPt(value.getIndPt());

        return empireShipTypeDTO;
    }

    /**
     * Convert the list of DB object into a list of DTO.
     *
     * @param list the list of DB object.
     * @return the list of DTO object.
     */
    public static List<ShipTypeDTO> convert(final List<ShipType> list) {
        final List<ShipTypeDTO> listDTOs = new ArrayList<ShipTypeDTO>();
        for (final ShipType value : list) {
            listDTOs.add(convert(value));
        }
        return listDTOs;
    }

}

