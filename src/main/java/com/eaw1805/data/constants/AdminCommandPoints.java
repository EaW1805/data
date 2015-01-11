package com.eaw1805.data.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * Used to hold static tables with command and admin points for all orders.
 */
public final class AdminCommandPoints
        implements OrderConstants {

    /**
     * Administrative Points.
     */
    public static final Map<Integer, Integer> P_ADM = new HashMap<Integer, Integer>();

    /**
     * Command Points.
     */
    public static final Map<Integer, Integer> P_COM = new HashMap<Integer, Integer>();

    static {
        P_ADM.put(ORDER_B_BATT, 1);
        P_COM.put(ORDER_B_BATT, 1);

        P_ADM.put(ORDER_B_BATT_COL, 3);
        P_COM.put(ORDER_B_BATT_COL, 3);

        P_ADM.put(ORDER_B_ARMY, 1);
        P_COM.put(ORDER_B_ARMY, 1);

        P_ADM.put(ORDER_B_CORP, 1);
        P_COM.put(ORDER_B_CORP, 1);

        P_ADM.put(ORDER_ADDTO_ARMY, 0);
        P_COM.put(ORDER_ADDTO_ARMY, 0);

        P_ADM.put(ORDER_ADDTO_CORP, 0);
        P_COM.put(ORDER_ADDTO_CORP, 0);

        P_ADM.put(ORDER_ADDTO_BRIGADE, 0);
        P_COM.put(ORDER_ADDTO_BRIGADE, 0);

        P_ADM.put(ORDER_INC_HEADCNT, 1);
        P_COM.put(ORDER_INC_HEADCNT, 0);

        P_ADM.put(ORDER_INC_HEADCNT_ARMY, 2);
        P_COM.put(ORDER_INC_HEADCNT_ARMY, 0);

        P_ADM.put(ORDER_INC_EXP, 0);
        P_COM.put(ORDER_INC_EXP, 0);

        P_ADM.put(ORDER_MRG_BATT, 0);
        P_COM.put(ORDER_MRG_BATT, 0);

        P_ADM.put(ORDER_D_BATT, 0);
        P_COM.put(ORDER_D_BATT, 0);

        P_ADM.put(ORDER_D_BRIG, 0);
        P_COM.put(ORDER_D_BRIG, 0);

        P_ADM.put(ORDER_D_CORP, 0);
        P_COM.put(ORDER_D_CORP, 0);

        P_ADM.put(ORDER_HIRE_COM, 1);
        P_COM.put(ORDER_HIRE_COM, 0);

        P_ADM.put(ORDER_HIRE_COM_COL, 4);
        P_COM.put(ORDER_HIRE_COM_COL, 0);

        P_ADM.put(ORDER_CORP_COM, 0);
        P_COM.put(ORDER_CORP_COM, 0);

        P_ADM.put(ORDER_ARMY_COM, 0);
        P_COM.put(ORDER_ARMY_COM, 0);

        P_ADM.put(ORDER_LEAVE_COM, 0);
        P_COM.put(ORDER_LEAVE_COM, 1);

        P_ADM.put(ORDER_DISS_COM, 1);
        P_COM.put(ORDER_DISS_COM, 1);

        P_ADM.put(ORDER_D_ARMY, 0);
        P_COM.put(ORDER_D_ARMY, 0);

        P_ADM.put(ORDER_B_SHIP, 1);
        P_COM.put(ORDER_B_SHIP, 1);

        P_ADM.put(ORDER_R_SHP, 0);
        P_COM.put(ORDER_R_SHP, 0);

        P_ADM.put(ORDER_R_FLT, 0);
        P_COM.put(ORDER_R_FLT, 0);

        P_ADM.put(ORDER_B_FLT, 1);
        P_COM.put(ORDER_B_FLT, 1);

        P_ADM.put(ORDER_ADDTO_FLT, 0);
        P_COM.put(ORDER_ADDTO_FLT, 0);

        P_ADM.put(ORDER_D_FLT, 0);
        P_COM.put(ORDER_D_FLT, 0);

        P_ADM.put(ORDER_B_PRODS, 1);
        P_COM.put(ORDER_B_PRODS, 0);

        P_ADM.put(ORDER_D_PRODS, 2);
        P_COM.put(ORDER_D_PRODS, 0);

        P_ADM.put(ORDER_INC_POP, 1); // minimum
        P_COM.put(ORDER_INC_POP, 0);

        P_ADM.put(ORDER_DEC_POP, 1); // minimum
        P_COM.put(ORDER_DEC_POP, 0);

        P_ADM.put(ORDER_LOAD_TROOPSF, 0);
        P_COM.put(ORDER_LOAD_TROOPSF, 0);

        P_ADM.put(ORDER_UNLOAD_TROOPSF, 0);
        P_COM.put(ORDER_UNLOAD_TROOPSF, 0);

        P_ADM.put(ORDER_M_ARMY, 0);
        P_COM.put(ORDER_M_ARMY, 3);

        P_ADM.put(ORDER_FM_ARMY, 0);
        P_COM.put(ORDER_FM_ARMY, 3);

        P_ADM.put(ORDER_M_BRIG, 0);
        P_COM.put(ORDER_M_BRIG, 1);

        P_ADM.put(ORDER_FM_BRIG, 0);
        P_COM.put(ORDER_FM_BRIG, 1);

        P_ADM.put(ORDER_M_CORP, 0);
        P_COM.put(ORDER_M_CORP, 2);

        P_ADM.put(ORDER_FM_CORP, 0);
        P_COM.put(ORDER_FM_CORP, 2);

        P_ADM.put(ORDER_FM_ARMY, 0);
        P_COM.put(ORDER_FM_ARMY, 3);

        P_ADM.put(ORDER_M_COMM, 0);
        P_COM.put(ORDER_M_COMM, 0);

        P_ADM.put(ORDER_M_SPY, 0);
        P_COM.put(ORDER_M_SPY, 1);

        P_ADM.put(ORDER_M_BTRAIN, 0);
        P_COM.put(ORDER_M_BTRAIN, 1);

        P_ADM.put(ORDER_M_MSHIP, 0);
        P_COM.put(ORDER_M_MSHIP, 1);

        P_ADM.put(ORDER_M_SHIP, 0);
        P_COM.put(ORDER_M_SHIP, 1);

        P_ADM.put(ORDER_M_FLEET, 0);
        P_COM.put(ORDER_M_FLEET, 3);

        P_ADM.put(ORDER_P_SHIP, 0);
        P_COM.put(ORDER_P_SHIP, 1);

        P_ADM.put(ORDER_P_FLEET, 0);
        P_COM.put(ORDER_P_FLEET, 3);

        P_ADM.put(ORDER_LOAD_TROOPSS, 0);
        P_COM.put(ORDER_LOAD_TROOPSS, 0);

        P_ADM.put(ORDER_UNLOAD_TROOPSS, 0);
        P_COM.put(ORDER_UNLOAD_TROOPSS, 0);

        P_ADM.put(ORDER_HOVER_SEC, 1); // minimum 1
        P_COM.put(ORDER_HOVER_SEC, 0);

        P_ADM.put(ORDER_HOVER_SHIP, 1);
        P_COM.put(ORDER_HOVER_SHIP, 1);

        P_ADM.put(ORDER_TAXATION, 0);
        P_COM.put(ORDER_TAXATION, 0);

        P_ADM.put(TAX_HARSH, 0);
        P_COM.put(TAX_HARSH, 0);

        P_ADM.put(TAX_LOW, 0);
        P_COM.put(TAX_LOW, 0);

        P_ADM.put(ORDER_POLITICS, 0);
        P_COM.put(ORDER_POLITICS, 0);

        P_ADM.put(ORDER_B_BTRAIN, 1);
        P_COM.put(ORDER_B_BTRAIN, 0);

        P_ADM.put(ORDER_R_BTRAIN, 0);
        P_COM.put(ORDER_R_BTRAIN, 0);

        P_ADM.put(ORDER_SCUTTLE_BTRAIN, 0);
        P_COM.put(ORDER_SCUTTLE_BTRAIN, 0);

        P_ADM.put(ORDER_SCUTTLE_SHIP, 0);
        P_COM.put(ORDER_SCUTTLE_SHIP, 0);

        P_ADM.put(ORDER_REN_BRIG, 0);
        P_COM.put(ORDER_REN_BRIG, 0);

        P_ADM.put(ORDER_REN_COMM, 0);
        P_COM.put(ORDER_REN_COMM, 0);

        P_ADM.put(ORDER_REN_SHIP, 0);
        P_COM.put(ORDER_REN_SHIP, 0);

        P_ADM.put(ORDER_REN_ARMY, 0);
        P_COM.put(ORDER_REN_ARMY, 0);

        P_ADM.put(ORDER_REN_CORP, 0);
        P_COM.put(ORDER_REN_CORP, 0);

        P_ADM.put(ORDER_REN_FLT, 0);
        P_COM.put(ORDER_REN_FLT, 0);

        P_ADM.put(ORDER_REN_SPY, 0);
        P_COM.put(ORDER_REN_SPY, 0);

        P_ADM.put(ORDER_REN_BARRACK, 0);
        P_COM.put(ORDER_REN_BARRACK, 0);

        P_ADM.put(ORDER_REN_BTRAIN, 0);
        P_COM.put(ORDER_REN_BTRAIN, 0);

        P_ADM.put(ORDER_EXCHF, 1);
        P_COM.put(ORDER_EXCHF, 0);

        P_ADM.put(ORDER_EXCHS, 1);
        P_COM.put(ORDER_EXCHS, 0);
    }

}
