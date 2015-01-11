package com.eaw1805.data.dto.converters;


import com.eaw1805.data.dto.web.field.FieldBattleSectorDTO;
import com.eaw1805.data.model.battles.field.FieldBattleSector;

public class FieldBattleSectorConverter {

    /**
     * Cannot instantiate this class.
     */
    private FieldBattleSectorConverter() {
        // empty constructor
    }

    /**
     * Convert the DB object into a DTO.
     *
     * @param value the DB object.
     * @return the DTO object.
     */
    public static FieldBattleSectorDTO convert(final FieldBattleSector value) {
        final FieldBattleSectorDTO sector = new FieldBattleSectorDTO();
        sector.setId(value.getId());
        sector.setAltitude(value.getAltitude());
        sector.setBridge(value.getBridge());
        sector.setBush(value.isBush());
        sector.setChateau(value.getChateau());
        if (value.getCurrentHolder() != null) {
            sector.setCurrentHolder(value.getCurrentHolder().getId());
        } else {
            sector.setCurrentHolder(0);
        }
        if (value.getNation() != null) {
            sector.setNationSetup(value.getNation().getId());
        } else {
            sector.setNationSetup(0);
        }
        sector.setEntrenchment(value.getEntrenchment());
        sector.setForest(value.isForest());
        sector.setFortificationInterior(value.isFortificationInterior());
        sector.setLake(value.isLake());
        sector.setMajorRiver(value.isMajorRiver());
        sector.setX(value.getX());
        sector.setY(value.getY());
        sector.setMinorRiver(value.isMinorRiver());
        sector.setRoad(value.isRoad());
        sector.setStrategicPoint(value.isStrategicPoint());
        sector.setTown(value.getTown());
        sector.setVillage(value.getVillage());
        sector.setWall(value.getWall());




        return sector;
    }

    public static FieldBattleSectorDTO[][] convert(final FieldBattleSector[][] value) {
        final FieldBattleSectorDTO[][] sectors = new FieldBattleSectorDTO[value.length][value[0].length];
        int x=0,y;
        for (FieldBattleSector[] row : value) {
            y = 0;
            for (FieldBattleSector sector : row) {
                sectors[x][y] = convert(sector);
                y++;
            }
            x++;
        }
        return sectors;
    }
}
