package com.eaw1805.data.model.battles.field.log;

import com.eaw1805.data.model.battles.field.log.entries.StructureAffectedLogEntry;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class StructureStatus implements Serializable {

    private static final long serialVersionUID = 1L;

    public StructureStatus(int x, int y, String type, int hitPoints) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.hitPoints = hitPoints;
    }

    private final int x;
    private final int y;
    private final String type;
    private final int hitPoints;
    private List<StructureAffectedLogEntry> structureAffectedLogEntries = new ArrayList<StructureAffectedLogEntry>();

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getType() {
        return type;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public List<StructureAffectedLogEntry> getStructureAffectedLogEntries() {
        return structureAffectedLogEntries;
    }
}
