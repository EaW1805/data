package com.eaw1805.data.dto.converters;

import com.eaw1805.data.dto.web.OrderDTO;
import com.eaw1805.data.model.Game;
import com.eaw1805.data.model.Nation;
import com.eaw1805.data.model.PlayerOrder;

import java.util.ArrayList;
import java.util.List;

/**
 * Convert Order DB objects into OrderDTOs.
 */
public final class OrderConverter {

    /**
     * Cannot instantiate this class.
     */
    private OrderConverter() {
        // empty constructor
    }

    /**
     * Convert the DB object into a DTO.
     *
     * @param value the DB object.
     * @return the DTO object.
     */
    public static OrderDTO convert(final PlayerOrder value) {
        final OrderDTO empireOrderDTO = new OrderDTO();
        empireOrderDTO.setOrderId(value.getOrderId());
        empireOrderDTO.setGameId(value.getGame().getGameId());
        empireOrderDTO.setNationId(value.getNation().getId());
        empireOrderDTO.setTurn(value.getTurn());
        empireOrderDTO.setType(value.getType());
        empireOrderDTO.setPosition(value.getPosition());
        empireOrderDTO.setResult(value.getResult());
        empireOrderDTO.setParameter1(value.getParameter1());
        empireOrderDTO.setParameter2(value.getParameter2());
        empireOrderDTO.setParameter3(value.getParameter3());
        empireOrderDTO.setParameter4(value.getParameter4());
        empireOrderDTO.setParameter5(value.getParameter5());
        empireOrderDTO.setParameter6(value.getParameter6());
        empireOrderDTO.setParameter7(value.getParameter7());
        empireOrderDTO.setParameter8(value.getParameter8());
        empireOrderDTO.setParameter9(value.getParameter9());
        empireOrderDTO.setTemp1(value.getTemp1());
        empireOrderDTO.setTemp2(value.getTemp2());
        empireOrderDTO.setTemp3(value.getTemp3());
        empireOrderDTO.setTemp4(value.getTemp4());
        empireOrderDTO.setTemp5(value.getTemp5());
        empireOrderDTO.setTemp6(value.getTemp6());
        empireOrderDTO.setTemp7(value.getTemp7());
        empireOrderDTO.setTemp8(value.getTemp8());
        empireOrderDTO.setTemp9(value.getTemp9());
        return empireOrderDTO;
    }

    /**
     * Convert the DTO object into a DB.
     *
     * @param value      the DTO object.
     * @param thisGame   the DB object corresponding to the Game ID found in the DTO object.
     * @param thisNation the DB object corresponding to the Nation ID found in the DTO object.
     * @return the DB object.
     */
    public static PlayerOrder convert(final OrderDTO value, final Game thisGame, final Nation thisNation) {
        final PlayerOrder empireOrder = new PlayerOrder();
        empireOrder.setOrderId(value.getOrderId());
        empireOrder.setGame(thisGame);
        empireOrder.setTurn(value.getTurn());
        empireOrder.setNation(thisNation);
        empireOrder.setType(value.getType());
        empireOrder.setPosition(value.getPosition());
        empireOrder.setParameter1(value.getParameter1());
        empireOrder.setParameter2(value.getParameter2());
        empireOrder.setParameter3(value.getParameter3());
        empireOrder.setParameter4(value.getParameter4());
        empireOrder.setParameter5(value.getParameter5());
        empireOrder.setParameter6(value.getParameter6());
        empireOrder.setParameter7(value.getParameter7());
        empireOrder.setParameter8(value.getParameter8());
        empireOrder.setParameter9(value.getParameter9());
        empireOrder.setTemp1(value.getTemp1());
        empireOrder.setTemp2(value.getTemp2());
        empireOrder.setTemp3(value.getTemp3());
        empireOrder.setTemp4(value.getTemp4());
        empireOrder.setTemp5(value.getTemp5());
        empireOrder.setTemp6(value.getTemp6());
        empireOrder.setTemp7(value.getTemp7());
        empireOrder.setTemp8(value.getTemp8());
        empireOrder.setTemp9(value.getTemp9());
        empireOrder.setResult(value.getResult());
        empireOrder.setProcOrder(0);

        return empireOrder;
    }

    /**
     * Convert the list of DB object into a list of DTO.
     *
     * @param list the list of DB object.
     * @return the list of DTO object.
     */
    public static List<OrderDTO> convert(final List<PlayerOrder> list) {
        final List<OrderDTO> listDTOs = new ArrayList<OrderDTO>();
        for (final PlayerOrder value : list) {
            listDTOs.add(convert(value));
        }
        return listDTOs;
    }

    /**
     * Convert the list of DB object into a list of DTO.
     *
     * @param list       the list of DB object.
     * @param thisGame   the DB object corresponding to the Game ID found in the DTO object.
     * @param thisNation the DB object corresponding to the Nation ID found in the DTO object.
     * @return the list of DTO object.
     */
    public static List<PlayerOrder> convert(final List<OrderDTO> list, final Game thisGame, final Nation thisNation) {
        final List<PlayerOrder> listDTOs = new ArrayList<PlayerOrder>();
        for (final OrderDTO value : list) {
            listDTOs.add(convert(value, thisGame, thisNation));
        }
        return listDTOs;
    }

}
