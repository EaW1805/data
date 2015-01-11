package com.eaw1805.data.dto.web.field;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class StructureStatusDTO implements com.google.gwt.user.client.rpc.IsSerializable, Serializable {
    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD

    private int x;
    private int y;
    private String type;
    private int hitPoints;
    private List<StructureAffectedLogEntryDTO> structureAffected = new ArrayList<StructureAffectedLogEntryDTO>();

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public List<StructureAffectedLogEntryDTO> getStructureAffected() {
        return structureAffected;
    }

    public void setStructureAffected(List<StructureAffectedLogEntryDTO> structureAffected) {
        this.structureAffected = structureAffected;
    }

    public boolean isBridge() {
        return "bridge".equals(type);
    }

    public boolean isChateau() {
        return "chateau".equals(type);
    }

    public boolean isEntrenchment() {
        return "entrenchment".equals(type);
    }

    public boolean isTown() {
        return "town".equals(type);
    }

    public boolean isVillage() {
        return "village".equals(type);
    }

    public boolean isWall() {
        return "wall".equals(type);
    }
}
