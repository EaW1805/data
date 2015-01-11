package com.eaw1805.data.dto.converters;

import com.eaw1805.data.constants.TerrainConstants;
import com.eaw1805.data.dto.common.SectorDTO;
import com.eaw1805.data.model.Game;
import com.eaw1805.data.model.map.Sector;
import com.eaw1805.data.model.map.Terrain;

import java.util.ArrayList;
import java.util.List;

/**
 * Convert Sector DB objects into SectorDTOs.
 */
public final class SectorConverter {

    /**
     * Cannot instantiate this class.
     */
    private SectorConverter() {
        // empty constructor
    }

    /**
     * Convert the DB object into a DTO.
     *
     * @param value the DB object to convert.
     * @return the DTO object.
     */
    public static SectorDTO convert(final Sector value) {
        final String winter = "Winter";
        final Terrain terrain = value.getTerrain();

        final com.eaw1805.data.dto.common.SectorDTO empSec = new SectorDTO();
        empSec.setId(value.getId());
        empSec.setRegionId(value.getPosition().getRegion().getId());

        empSec.setTerrainId(terrain.getId());
        empSec.setTerrain(TerrainConverter.convert(terrain));

        empSec.setNationId(value.getNation().getId());
        empSec.setNationDTO(NationConverter.convert(value.getNation()));

        empSec.setX(value.getPosition().getX());
        empSec.setY(value.getPosition().getY());
        empSec.setXStart(value.getPosition().getX());
        empSec.setYStart(value.getPosition().getY());
        empSec.setPopulation(value.getPopulation());
        empSec.setPoliticalSphere(value.getPoliticalSphere());
        empSec.setName(value.getName());
        empSec.setImage(value.getImage());
        empSec.setImageGeo(value.getImageGeo());
        empSec.setTradeCity(value.getTradeCity());
        empSec.setEpidemic(value.getEpidemic());
        empSec.setRebelled(value.getRebelled());
        empSec.setPayed(value.getPayed());
        empSec.setConquered(value.getConquered());
        empSec.setStorm(value.getStorm());
        empSec.setVisible(true);
        if (value.getImage() != null) {
            empSec.setWinter(value.getImage().contains(winter));
        }
        empSec.setConqueredCounter(value.getConqueredCounter());
        empSec.setBuildProgress(value.getBuildProgress());
        empSec.setRiverNorth(value.isRiverNorth());
        empSec.setRiverEast(value.isRiverEast());
        empSec.setRiverSouth(value.isRiverSouth());
        empSec.setRiverWest(value.isRiverWest());
        empSec.setClimaticZone(value.getClimaticZone());
        if (value.getNaturalResource() == null) {
            empSec.setNatResId(-1);

        } else {
            empSec.setNatResId(value.getNaturalResource().getId());
            empSec.setNatResDTO(NaturalResourceConverter.convert(value.getNaturalResource()));
        }

        if (value.getProductionSite() == null) {
            empSec.setProductionSiteId(-1);

        } else {
            empSec.setProductionSiteId(value.getProductionSite().getId());
            empSec.setProductionSiteDTO(ProductionSiteConverter.convert(value.getProductionSite()));
        }

        return empSec;
    }

    /**
     * Convert the DB object into a DTO based on the permissions of the particular nation.
     *
     * @param value    the DB object.
     * @param nationId the nation that is browsing the map.
     * @return the DTO object.
     */
    public static SectorDTO convert(final Sector value, final int nationId, final Game game) {
        final String token = "*" + nationId + "*";
        final String winter = "Winter";

        final Terrain terrain = value.getTerrain();

        final com.eaw1805.data.dto.common.SectorDTO empSec = new SectorDTO();
        empSec.setId(value.getId());
        empSec.setRegionId(value.getPosition().getRegion().getId());

        empSec.setTerrainId(terrain.getId());
        empSec.setTerrain(TerrainConverter.convert(terrain));

        empSec.setNationId(value.getNation().getId());
        empSec.setNationDTO(NationConverter.convert(value.getNation()));

        empSec.setX(value.getPosition().getX());
        empSec.setY(value.getPosition().getY());
        empSec.setXStart(value.getPosition().getX());
        empSec.setYStart(value.getPosition().getY());
        empSec.setPopulation(value.getPopulation());
        empSec.setPoliticalSphere(value.getPoliticalSphere());
        empSec.setImage(value.getImage());
        empSec.setTradeCity(value.getTradeCity());
        empSec.setEpidemic(value.getEpidemic());
        empSec.setRebelled(value.getRebelled());
        empSec.setPayed(value.getPayed());
        empSec.setConquered(value.getConquered());
        empSec.setStorm(value.getStorm());
        empSec.setVisible(terrain.getId() == TerrainConstants.TERRAIN_O
                || value.getTradeCity()
                || value.getNation().getId() == nationId
                || value.getFow().contains(token)
                || !game.isFogOfWar());
        empSec.setWinter(value.getImage().contains(winter));
        empSec.setConqueredCounter(value.getConqueredCounter());
        empSec.setBuildProgress(value.getBuildProgress());

        empSec.setNatResId(-1);
        empSec.setProductionSiteId(-1);
        empSec.setImageGeo(value.getImageGeo());

        empSec.setName(value.getName());

        if (empSec.getVisible()) {
            if (value.getNaturalResource() != null) {
                empSec.setNatResId(value.getNaturalResource().getId());
                empSec.setNatResDTO(NaturalResourceConverter.convert(value.getNaturalResource()));
            }

            if (value.getProductionSite() != null) {
                empSec.setProductionSiteId(value.getProductionSite().getId());
                empSec.setProductionSiteDTO(ProductionSiteConverter.convert(value.getProductionSite()));
            }

        } else {
            empSec.setImage("fow-" + empSec.getImage());
        }

        return empSec;
    }

    /**
     * Convert the list of DB object into a list of DTO.
     *
     * @param list the list of DB object.
     * @return the list of DTO object.
     */
    public static List<com.eaw1805.data.dto.common.SectorDTO> convert(final List<Sector> list) {
        final List<com.eaw1805.data.dto.common.SectorDTO> listDTOs = new ArrayList<com.eaw1805.data.dto.common.SectorDTO>();
        for (final Sector value : list) {
            listDTOs.add(convert(value));
        }
        return listDTOs;
    }

    /**
     * Convert the list of DB object into a list of DTO.
     *
     * @param list     the list of DB object.
     * @param nationId the ID of the nation requesting the conversion (to apply for of war rules).
     * @param useFOW   to investigate if fog-of-war rules are applied.
     * @return the list of DTO object.
     */
    public static List<com.eaw1805.data.dto.common.SectorDTO> convert(final List<Sector> list, final int nationId, final boolean useFOW, final Game game) {
        final List<com.eaw1805.data.dto.common.SectorDTO> listDTOs = new ArrayList<com.eaw1805.data.dto.common.SectorDTO>();
        for (final Sector value : list) {
            final SectorDTO thisSector = convert(value, nationId, game);
            if (!useFOW) {
                thisSector.setVisible(true);
            }
            listDTOs.add(thisSector);
        }
        return listDTOs;
    }

}
