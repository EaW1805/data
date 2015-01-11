package com.eaw1805.data.dto.web.field;


import java.io.Serializable;

public class FieldBattleSectorDTO implements com.google.gwt.user.client.rpc.IsSerializable, Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD

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
     * The Nation of which the setup area contains the sector. May be null,
     * if it does not belong to the setup area of a nation.
     */
    private int nationSetup;

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
    private int currentHolder;


    /**
     * Checks if the sector is empty.
     *
     * @return true or false
     */
    public boolean isEmpty() {
        return !(hasChateau() || hasVillage() || minorRiver || majorRiver || hasBridge() || road || hasTown() || lake || forest || bush || fortificationInterior || hasWall());
    }

    /**
     * Checks if the sector is empty.
     *
     * @return true or false
     */
    public boolean isBuildable() {
        return !(hasChateau() || hasVillage() || minorRiver || majorRiver || road || hasTown() || lake || forest || hasWall());
    }

    public boolean hasWall() {
        return wall > 0;
    }

    public boolean hasVillage() {
        return village > 0;
    }

    public boolean hasChateau() {
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

    public boolean hasBridge() {
        return bridge > 0;
    }

    public boolean hasTown() {
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

    public boolean hasEntrenchment() {
        return entrenchment > 0;
    }

    public boolean isStrategicPoint() {
        return strategicPoint;
    }

    public void setStrategicPoint(boolean strategicPoint) {
        this.strategicPoint = strategicPoint;
    }

    public int getNationSetup() {
        return nationSetup;
    }

    public void setNationSetup(int nationSetup) {
        this.nationSetup = nationSetup;
    }

    public int getCurrentHolder() {
        return currentHolder;
    }

    public void setCurrentHolder(final int currentHolder) {
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

    public boolean[][] getRoadDirections(final FieldBattleSectorDTO[][] sectors) {
        int posX = getX();
        int posY = getY();
        int sizeX = sectors.length;
        int sizeY = sectors[0].length;
        boolean[][] roadSides = new boolean[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                roadSides[i][j] = false;
            }
        }
        if (posX > 0) {
            roadSides[0][1] = sectors[posX - 1][posY].isRoad() || sectors[posX - 1][posY].hasBridge();
        }
        if (posY > 0) {
            roadSides[1][0] = sectors[posX][posY - 1].isRoad() || sectors[posX][posY - 1].hasBridge();
        }
        if (posX + 1 != sizeX) {
            roadSides[2][1] = sectors[posX + 1][posY].isRoad() || sectors[posX + 1][posY].hasBridge();
        }
        if (posY + 1 != sizeY) {
            roadSides[1][2] = sectors[posX][posY + 1].isRoad() || sectors[posX][posY + 1].hasBridge();
        }

        if (posX > 0 && posY > 0 && !roadSides[0][1] && !roadSides[1][0]) {
            roadSides[0][0] = sectors[posX - 1][posY - 1].isRoad() || sectors[posX - 1][posY - 1].hasBridge();
        }
        if (posX + 1 != sizeX && posY + 1 != sizeY && !roadSides[1][2] && !roadSides[2][1]) {
            roadSides[2][2] = sectors[posX + 1][posY + 1].isRoad() || sectors[posX + 1][posY + 1].hasBridge();
        }
        if (posX > 0 && posY + 1 != sizeY && !roadSides[0][1] && !roadSides[1][2]) {
            roadSides[0][2] = sectors[posX - 1][posY + 1].isRoad() || hasBridge();
        }
        if (posY > 0 && posX + 1 != sizeX && !roadSides[1][0] && !roadSides[2][1]) {
            roadSides[2][0] = sectors[posX + 1][posY - 1].isRoad() || sectors[posX + 1][posY - 1].hasBridge();
        }
        int countConnections = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (roadSides[i][j]) {
                    countConnections++;
                }
            }
        }
        //fix connections for end of map sectors
        if (posX == 0) {
            if (countConnections < 2) {
                roadSides[0][1] = true;
            }
        } else if (posY == 0) {
            if (countConnections < 2) {
                roadSides[1][0] = true;
            }
        } else if (posX + 1 == sizeX) {
            if (countConnections < 2) {
                roadSides[2][1] = true;
            }
        } else if (posY + 1 == sizeY) {
            if (countConnections < 2) {
                roadSides[1][2] = true;
            }
        }
        return roadSides;
    }

    public boolean[][] getWallDirections(final FieldBattleSectorDTO[][] sectors) {
        int posX = getX();
        int posY = getY();
        int sizeX = sectors.length;
        int sizeY = sectors[0].length;
        boolean[][] wallSides = new boolean[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                wallSides[i][j] = false;
            }
        }
        int countConnections = 0;
        if (posX > 0) {
            wallSides[0][1] = sectors[posX - 1][posY].hasWall();
        }
        if (posY > 0) {
            wallSides[1][0] = sectors[posX][posY - 1].hasWall();
        }
        if (posX + 1 != sizeX) {
            wallSides[2][1] = sectors[posX + 1][posY].hasWall();
        }
        if (posY + 1 != sizeY) {
            wallSides[1][2] = sectors[posX][posY + 1].hasWall();
        }
        //fix edge of map connections
        if (wallSides[1][0] && !wallSides[0][1] && !wallSides[1][2] && !wallSides[2][1]) {
            wallSides[1][2] = true;
        }
        if (wallSides[1][2] && !wallSides[0][1] && !wallSides[1][0] && !wallSides[2][1]) {
            wallSides[1][0] = true;
        }
        if (wallSides[0][1] && wallSides[2][1]) {
            if (getY() > sizeY / 2) {
                wallSides[1][0] = true;
            } else {
                wallSides[1][2] = true;
            }
        }
        if (wallSides[1][0] && wallSides[1][2]) {
            if (getX() > sizeX / 2) {
                wallSides[2][1] = true;
            } else {
                wallSides[0][1] = true;
            }
        }
        return wallSides;
    }

    public boolean getBridgeDirection(final FieldBattleSectorDTO[][] sectors) {
        boolean bridgeUD;
        boolean[][] riverDirection = getRiverDirections(sectors);
        if ((riverDirection[0][0] || riverDirection[0][1] || riverDirection[0][2])
                && (riverDirection[2][0] || riverDirection[2][1] || riverDirection[2][2])) {
            bridgeUD = false;
        } else {
            bridgeUD = true;
        }
        return bridgeUD;
    }

    public boolean[][] getRiverDirections(final FieldBattleSectorDTO[][] sectors) {
        int posX = getX();
        int posY = getY();
        int sizeX = sectors.length;
        int sizeY = sectors[0].length;
        boolean[][] riverSides = new boolean[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                riverSides[i][j] = false;
            }
        }
        if (posX > 0) {
            riverSides[0][1] = sectors[posX - 1][posY].isMinorRiver();
        }
        if (posY > 0) {
            riverSides[1][0] = sectors[posX][posY - 1].isMinorRiver();
        }
        if (posX + 1 != sizeX) {
            riverSides[2][1] = sectors[posX + 1][posY].isMinorRiver();
        }
        if (posY + 1 != sizeY) {
            riverSides[1][2] = sectors[posX][posY + 1].isMinorRiver();
        }

        if (posX > 0 && posY > 0 && !riverSides[0][1] && !riverSides[1][0]) {
            riverSides[0][0] = sectors[posX - 1][posY - 1].isMinorRiver();
        }
        if (posX + 1 != sizeX && posY + 1 != sizeY && !riverSides[1][2] && !riverSides[2][1]) {
            riverSides[2][2] = sectors[posX + 1][posY + 1].isMinorRiver();
        }
        if (posX > 0 && posY + 1 != sizeY && !riverSides[0][1] && !riverSides[1][2]) {
            riverSides[0][2] = sectors[posX - 1][posY + 1].isMinorRiver();
        }
        if (posY > 0 && posX + 1 != sizeX && !riverSides[1][0] && !riverSides[2][1]) {
            riverSides[2][0] = sectors[posX + 1][posY - 1].isMinorRiver();
        }
        int countConnections = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (riverSides[i][j]) {
                    countConnections++;
                }
            }
        }
        //fix connections for end of map sectors
        if (posX == 0) {
            if (countConnections < 2) {
                riverSides[0][1] = true;
            }
        } else if (posY == 0) {
            if (countConnections < 2) {
                riverSides[1][0] = true;
            }
        } else if (posX + 1 == sizeX) {
            if (countConnections < 2) {
                riverSides[2][1] = true;
            }
        } else if (posY + 1 == sizeY) {
            if (countConnections < 2) {
                riverSides[1][2] = true;
            }
        }
        return riverSides;
    }

    public String getStructure() {
        if (hasVillage()) {
            return "Village " + village;
        } else if (hasTown()) {
            return "Town " + town;
        } else if (hasWall()) {
            return "Wall " + wall;
        } else if (hasBridge()) {
            return "Bridge " + bridge;
        } else if (hasChateau()) {
            return "Chateau " + chateau;
        }
        return "";
    }

    public String getGroundType() {
        if (isForest()) {
            return "Forest";
        } else if (isMinorRiver()) {
            return "Minor river";
        } else if (isMajorRiver()) {
            return "Major river";
        } else if (isBush()) {
            return "Bush";
        } else if (isRoad()) {
            return "Road";
        } else if (isLake()) {
            return "Lake";
        } else {
            return "";
        }

    }
}
