package com.eaw1805.data.dto.converters;

import com.eaw1805.data.dto.common.JumpOffDTO;
import com.eaw1805.data.model.map.JumpOff;

import java.util.ArrayList;
import java.util.List;


public class JumpOffConverter {

    /**
     * Cannot instantiate this class.
     */
    private JumpOffConverter() {
        // empty constructor
    }

    /**
     * Convert the DB object into a DTO.
     *
     * @param value the DB object.
     * @return the DTO object.
     */
    public static JumpOffDTO convert(final JumpOff value) {
        final JumpOffDTO out = new JumpOffDTO();
        out.setJumpOffId(value.getJumpOffId());
        out.setGameId(value.getDeparture().getGame().getGameId());
        out.setDepartureRegion(value.getDeparture().getRegion().getId());
        out.setDepartureX(value.getDeparture().getX());
        out.setDepartureY(value.getDeparture().getY());
        out.setDestinationRegion(value.getDestination().getRegion().getId());
        out.setDestinationX(value.getDestination().getX());
        out.setDestinationY(value.getDestination().getY());
        return out;
    }

    /**
     * Convert the list of DB object into a list of DTO.
     *
     * @param list the list of DB object.
     * @return the list of DTO object.
     */
    public static List<JumpOffDTO> convert(final List<JumpOff> list) {
        final List<JumpOffDTO> listDTOs = new ArrayList<JumpOffDTO>();
        for (final JumpOff value : list) {
            listDTOs.add(convert(value));
        }
        return listDTOs;
    }
}
