package com.eaw1805.data.dto.collections;

import com.eaw1805.data.dto.common.NationDTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FieldData implements com.google.gwt.user.client.rpc.IsSerializable, Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD

    private List<NationDTO> allNations = new ArrayList<NationDTO>();
    private List<NationDTO> alliedNations = new ArrayList<NationDTO>();
    private List<NationDTO> enemyNations = new ArrayList<NationDTO>();


    public FieldData() {
        super();
    }

    public void setAllNations(List<NationDTO> nations) {
        allNations.addAll(nations);
    }
    public void setAlliedNations(List<NationDTO> nations) {
        alliedNations.addAll(nations);
    }

    public void setEnemyNations(List<NationDTO> nations) {
        enemyNations.addAll(nations);
    }

    public List<NationDTO> getAllNations() {
        return allNations;
    }

    public List<NationDTO> getAlliedNations() {
        return alliedNations;
    }

    public List<NationDTO> getEnemyNations() {
        return enemyNations;
    }
}
