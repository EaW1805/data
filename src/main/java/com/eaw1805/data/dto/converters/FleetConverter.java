package com.eaw1805.data.dto.converters;

import com.eaw1805.data.dto.web.economy.StoredGoodDTO;
import com.eaw1805.data.dto.web.fleet.FleetDTO;
import com.eaw1805.data.dto.web.fleet.ShipDTO;
import com.eaw1805.data.managers.beans.GoodManagerBean;
import com.eaw1805.data.managers.beans.ShipManagerBean;
import com.eaw1805.data.model.fleet.Fleet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Convert Fleet DB objects into FleetDTOs.
 */
public final class FleetConverter {

    /**
     * Cannot instantiate this class.
     */
    private FleetConverter() {
        // empty constructor
    }

    /**
     * Convert the DB object into a DTO.
     *
     * @param value the DB object.
     * @return the DTO object.
     */
    public static FleetDTO convert(final Fleet value) {
        final FleetDTO empireFleetDTO = new FleetDTO();
        empireFleetDTO.setFleetId(value.getFleetId());
        empireFleetDTO.setName(value.getName());
        empireFleetDTO.setRegionId(value.getPosition().getRegion().getId());
        empireFleetDTO.setX(value.getPosition().getX());
        empireFleetDTO.setY(value.getPosition().getY());
        empireFleetDTO.setXStart(value.getPosition().getX());
        //calculate condition
        empireFleetDTO.setYStart(value.getPosition().getY());
        empireFleetDTO.setNationId(value.getNation().getId());
        empireFleetDTO.setOriginalName(value.getName());

        final HashMap<Integer, StoredGoodDTO> goodsMap = new HashMap<Integer, StoredGoodDTO>();
        empireFleetDTO.setGoodsDTO(goodsMap);
        empireFleetDTO.setOriginalGoodsDTO(new HashMap<Integer, StoredGoodDTO>());

        return empireFleetDTO;
    }

    /**
     * Register all units loaded in the ships of the fleet to the top-level fleet object.
     *
     * @param thisFleet the fleet object.
     */
    protected static void registerLoadedUnits(final FleetDTO thisFleet) {
        for (final ShipDTO ship : thisFleet.getShips().values()) {
            if (ship.getLoadedUnitsMap() != null) {
                for (Map.Entry<Integer, List<Integer>> entry : ship.getLoadedUnitsMap().entrySet()) {
                    // Make sure that a list exists for the specific cargo type
                    if (!thisFleet.getLoadedUnitsMap().containsKey(entry.getKey())) {
                        thisFleet.getLoadedUnitsMap().put(entry.getKey(), new ArrayList<Integer>());
                    }

                    // add all loaded units one by one
                    for (Integer shipId : entry.getValue()) {
                        thisFleet.getLoadedUnitsMap().get(entry.getKey()).add(shipId);
                    }
                }

                // Remove all units from the ship
                ship.getLoadedUnitsMap().clear();
            }
        }
    }

    /**
     * Convert the list of DB object into a list of DTO.
     *
     * @param list        the list of DB object.
     * @param shipManager a bean for accessing the Ship entities.
     * @param goodManager a bean for accessing DB entities of type Good.
     * @return the list of DTO object.
     */
    public static List<FleetDTO> convert(final List<Fleet> list, final ShipManagerBean shipManager, final GoodManagerBean goodManager) {
        final List<FleetDTO> listDTOs = new ArrayList<FleetDTO>();
        for (final Fleet value : list) {
            final FleetDTO thisFleet = convert(value);
            thisFleet.setShips(ShipConverter.convertToMap(shipManager.listByFleet(value.getPosition().getGame(), value.getFleetId()), goodManager));
            registerLoadedUnits(thisFleet);
            //calculate the average condition for this fleet.
            int sumCondition = 0;
            for (ShipDTO ship : thisFleet.getShips().values()) {
                sumCondition += ship.getCondition();
            }
            if (thisFleet.getShips().values().size() > 0) {
                thisFleet.setCondition(sumCondition/thisFleet.getShips().values().size());
            } else {
                thisFleet.setCondition(100);
            }
            listDTOs.add(thisFleet);
        }
        return listDTOs;
    }

}

