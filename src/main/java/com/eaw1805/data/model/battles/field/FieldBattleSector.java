package com.eaw1805.data.model.battles.field;

import com.eaw1805.data.model.Nation;

import java.io.Serializable;

/**
 * This class represents a sector of a field battle terrain.
 *
 * @author fragkakis
 */
public class FieldBattleSector implements Serializable {

    private static final long serialVersionUID = -1463194004819434853L;

    private int id;

    /**
     * The sector's x position.
     */
    private int x;

    /**
     * The sector's y position.
     */
    private int y;

    /**
     * If greater than 0, this sector has a chateau.
     */
    private int chateau;

    /**
     * If greater than 0, this sector has a village.
     */
    private int village;

    /**
     * True if the field has a minor river.
     */
    private boolean minorRiver;

    /**
     * True if the field has a minor river.
     */
    private boolean majorRiver;

    /**
     * If greater than 0, this sector has a bridge.
     */
    private int bridge;

    /**
     * True if the field has a road.
     */
    private boolean road;

    /**
     * If greater than 0, this sector has a town.
     */
    private int town;

    /**
     * True if the field has a lake.
     */
    private boolean lake;

    /**
     * True if the field has a forest.
     */
    private boolean forest;

    /**
     * True if the field has bush.
     */
    private boolean bush;

    /**
     * True if the field is a fortification interior sector.
     */
    private boolean fortificationInterior;

    /**
     * If greater than 0, the field has a wall.
     */
    private int wall;

    /**
     * If greater than 0, the field has an entrenchment.
     */
    private int entrenchment;

    /**
     * The Map this sector belongs to.
     */
    private transient FieldBattleMap map;

    /**
     * The Nation of which the setup area contains the sector. May be null,
     * if it does not belong to the setup area of a nation.
     */
    private transient Nation nation;

    /**
     * The altitude of the sector. May be from 1 to 4.
     */
    private int altitude = 0;

    /**
     * True if the field battle sector is a strategic point.
     */
    private boolean strategicPoint;

    /**
     * The nation by which this strategic point is held. It is null for non-strategic point sectors.
     */
    private transient Nation currentHolder;

    /**
     * Checks if the sector is empty.
     *
     * @return true or false
     */
    public boolean isEmpty() {
        return !(hasSectorChateau() || hasSectorVillage() || minorRiver || majorRiver || hasSectorBridge() || road || hasSectorTown() || lake || forest || bush || fortificationInterior || hasSectorWall());
    }

    /**
     * Checks if the sector is empty.
     *
     * @return true or false
     */
    public boolean isBuildable() {
        return !(hasSectorChateau() || hasSectorVillage() || minorRiver || majorRiver || road || hasSectorTown() || lake || forest || hasSectorWall());
    }

    public boolean hasSectorWall() {
        return wall > 0;
    }

    public boolean hasSectorVillage() {
        return village > 0;
    }

    public boolean hasSectorChateau() {
        return chateau > 0;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isMinorRiver() {
        return minorRiver;
    }

    public void setMinorRiver(boolean minorRiver) {
        this.minorRiver = minorRiver;
    }

    public FieldBattleMap getMap() {
        return map;
    }

    public void setMap(FieldBattleMap map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    public boolean isRoad() {
        return road;
    }

    public void setRoad(boolean hasRoad) {
        this.road = hasRoad;
    }

    public boolean hasSectorBridge() {
        return bridge > 0;
    }

    public boolean hasSectorTown() {
        return town > 0;
    }


    public boolean isLake() {
        return lake;
    }

    public void setLake(boolean hasLake) {
        this.lake = hasLake;
    }

    public boolean isForest() {
        return forest;
    }

    public void setForest(boolean hasForest) {
        this.forest = hasForest;
    }

    public boolean isFortificationInterior() {
        return fortificationInterior;
    }

    public void setFortificationInterior(boolean fortificationInterior) {
        this.fortificationInterior = fortificationInterior;
    }

    public int getAltitude() {
        return altitude;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    public boolean isBush() {
        return bush;
    }

    public void setBush(boolean hasBush) {
        this.bush = hasBush;
    }

    public boolean isMajorRiver() {
        return majorRiver;
    }

    public void setMajorRiver(boolean majorRiver) {
        this.majorRiver = majorRiver;
    }

    public boolean hasSectorEntrenchment() {
        return entrenchment > 0;
    }

    public boolean isStrategicPoint() {
        return strategicPoint;
    }

    public void setStrategicPoint(boolean strategicPoint) {
        this.strategicPoint = strategicPoint;
    }

    public Nation getNation() {
        return nation;
    }

    public void setNation(Nation nation) {
        this.nation = nation;
    }

    public Nation getCurrentHolder() {
        return currentHolder;
    }

    public void setCurrentHolder(Nation currentHolder) {
        this.currentHolder = currentHolder;
    }

    public int getChateau() {
        return chateau;
    }

    public void setChateau(int chateau) {
        this.chateau = chateau;
    }

    public int getVillage() {
        return village;
    }

    public void setVillage(int village) {
        this.village = village;
    }

    public int getBridge() {
        return bridge;
    }

    public void setBridge(int bridge) {
        this.bridge = bridge;
    }

    public int getTown() {
        return town;
    }

    public void setTown(int town) {
        this.town = town;
    }

    public int getWall() {
        return wall;
    }

    public void setWall(int wall) {
        this.wall = wall;
    }

    public int getEntrenchment() {
        return entrenchment;
    }

    public void setEntrenchment(int entrenchment) {
        this.entrenchment = entrenchment;
    }

    public boolean hasStructure() {
        return hasSectorBridge()
                || hasSectorChateau()
                || hasSectorEntrenchment()
                || hasSectorTown()
                || hasSectorVillage()
                || hasSectorWall();
    }

    public String getStructureType() {
        return hasSectorBridge() ? "bridge" :
                hasSectorChateau() ? "chateau" :
                        hasSectorEntrenchment() ? "entrenchment" :
                                hasSectorTown() ? "town" :
                                        hasSectorVillage() ? "village" :
                                                hasSectorWall() ? "wall" : "none";
    }

    public int getStructureHitPoints() {
        return hasSectorBridge() ? getBridge() :
                hasSectorChateau() ? getChateau() :
                        hasSectorEntrenchment() ? getEntrenchment() :
                                hasSectorTown() ? getTown() :
                                        hasSectorVillage() ? getVillage() :
                                                hasSectorWall() ? getWall() : 0;
    }

}
