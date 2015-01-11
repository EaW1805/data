package com.eaw1805.data.dto.web;

import com.eaw1805.data.constants.ArmyConstants;
import com.eaw1805.data.dto.web.economy.StoredGoodDTO;
import com.eaw1805.data.dto.web.fleet.FleetDTO;
import com.eaw1805.data.dto.web.fleet.ShipDTO;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A class that contains the neccessary items for a
 * unit that can transport other units
 */
public class TransportUnitDTO
        extends TradeUnitAbstractDTO
        implements com.google.gwt.user.client.rpc.IsSerializable, Serializable, ArmyConstants {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 39L; //NOPMD

    /**
     * A map that contains all loaded units in the form <UnitType,List of Ids of the type>.
     */
    private Map<Integer, List<Integer>> loadedUnitsMap = new HashMap<Integer, List<Integer>>();

    /**
     * Get the map that contains all the loaded units
     *
     * @return a map with the IDs of the units loaded per unit category.
     */
    public Map<Integer, List<Integer>> getLoadedUnitsMap() {
        return loadedUnitsMap;
    }

    /**
     * Return true if the unit has loaded items.
     *
     * @return true if it is has even a single item loaded.
     */
    public boolean hasLoadedItemsOrUnits() {
        int itemCount = 0;
        if (loadedUnitsMap != null && loadedUnitsMap.values().size() > 0) {
            for (List<Integer> units : loadedUnitsMap.values()) {
                itemCount += units.size();
            }
        }

        if (getUnitType() != FLEET) {
            if (getGoodsDTO() != null && getGoodsDTO().values().size() > 0) {
                for (StoredGoodDTO good : getGoodsDTO().values()) {
                    if (good.getQte() > 0) {
                        itemCount++;
                    }
                }
            }

        } else {
            for (ShipDTO ship : ((FleetDTO) this).getShips().values()) {
                if (ship.hasLoadedItemsOrUnits()) {
                    itemCount++;
                }
            }
        }
        return (itemCount != 0);
    }


    public boolean hasLoadedUnits() {
        int itemCount = 0;
        if (loadedUnitsMap != null && loadedUnitsMap.values().size() > 0) {
            for (List<Integer> units : loadedUnitsMap.values()) {
                itemCount += units.size();
            }
        }
        return (itemCount != 0);
    }
}