package com.eaw1805.data.dto.web.economy;

import com.eaw1805.data.constants.ArmyConstants;
import com.eaw1805.data.dto.web.TradeUnitAbstractDTO;

import java.io.Serializable;

/**
 * Class for holding all the information about the warehouse.
 */
public class WarehouseDTO extends TradeUnitAbstractDTO
        implements com.google.gwt.user.client.rpc.IsSerializable, Serializable, ArmyConstants {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 40L; //NOPMD

    /**
     * Default constructor.
     */
    public WarehouseDTO() {
        setUnitType(WAREHOUSE);
    }

    public String getName() {
        switch (getRegionId()) {
            case EUROPE:
                return "European Warehouse";
            case CARIBBEAN:
                return "Caribbean Warehouse";
            case INDIES:
                return "Indies Warehouse";
            case AFRICA:
                return "African Warehouse";
            default:
                return "";
        }
    }


}
