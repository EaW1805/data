package com.eaw1805.data.dto.web.field;

import java.io.Serializable;
import java.util.Set;

public class FieldBattleMapDTO implements com.google.gwt.user.client.rpc.IsSerializable, Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD

    private int id;
    private int battleId;
    private int sizeX;
    private int sizeY;
    private FieldBattleSectorDTO[][] sectors;
    private Set<FieldBattleSectorDTO> sectorsSet;


    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public FieldBattleSectorDTO getFieldBattleSector(int sectorX, int sectorY) {
        return sectors[sectorX][sectorY];
    }

    public FieldBattleSectorDTO[][] getSectors() {
        if(sectors == null) {
            sectors = new FieldBattleSectorDTO[sizeX][sizeY];
            for(FieldBattleSectorDTO sector : sectorsSet) {
                sectors[sector.getX()][sector.getY()] = sector;
            }
        }
        return sectors;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }

    public Set<FieldBattleSectorDTO> getSectorsSet() {
        return sectorsSet;
    }

    public void setSectorsSet(Set<FieldBattleSectorDTO> sectorsSet) {
        this.sectorsSet = sectorsSet;
    }

    public int getBattleId() {
        return battleId;
    }

    public void setBattleId(int battleId) {
        this.battleId = battleId;
    }

    public void setSectors(FieldBattleSectorDTO[][] sectors) {
        this.sectors = sectors;
    }
}
