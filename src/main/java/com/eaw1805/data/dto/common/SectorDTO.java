package com.eaw1805.data.dto.common;

import com.eaw1805.data.constants.ProductionSiteConstants;
import com.eaw1805.data.constants.TerrainConstants;

import java.io.Serializable;

/**
 * Data-transfer object for the information for the Sector types.
 */
public class SectorDTO
        extends PositionDTO
        implements com.google.gwt.user.client.rpc.IsSerializable, Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 31L; //NOPMD

    /**
     * Population size for each level.
     */
    private static final int[] POP_LEVELS = {1000, 4000, 10000, 20000, 40000, 60000, 90000, 120000, 160000, 200000};

    private static final int NORTH = 0;

    private static final int EAST = 1;

    private static final int SOUTH = 2;

    private static final int WEST = 3;

    /**
     * Sector's identification number.
     */
    private int id; // NOPMD

    /**
     * Sector's population.
     */
    private int population;

    /**
     * Sector's terrain.
     */
    private TerrainDTO terrain;

    /**
     * Sector's terrain id.
     */
    private int terrainId;

    /**
     * Sector's natural resource.
     */
    private NaturalResourceDTO natResDTO;

    /**
     * Sector's natural resource id.
     */
    private int natResId;

    /**
     * The Sector's production site.
     */
    private ProductionSiteDTO productionSiteDTO;

    /**
     * The Sector's production site.
     */
    private int productionSiteId;

    /**
     * The nation that this sector belongs to.
     */
    private NationDTO nationDTO;

    /**
     * The nation that this sector belongs to.
     */
    private int nationId;

    /**
     * The Sector's political sphere.
     */
    private String politicalSphere;

    /**
     * Indicates if this is a economy city.
     */
    private boolean tradeCity;

    /**
     * Indicates if this sector was struck by an epidemic during the previous turn.
     */
    private boolean epidemic;

    /**
     * Indicates if this sector has rebelled during the previous turn.
     */
    private boolean rebelled;

    /**
     * If the sector is a sea-shore.
     */
    private boolean isByTheSea;

    /**
     * If the sector was properly maintained during last turn.
     */
    private boolean payed;

    /**
     * The name of the sector.
     */
    private String name;

    /**
     * The image that represents the state of the sector.
     */
    private String image;

    /**
     * The image that represents the geographic info of the sector (no winter).
     */
    private String imageGeo;

    /**
     * Indication for storm affecting the sector or is centered on this sector.
     */
    private int storm;

    /**
     * Indication if the sector needs to be conquered.
     */
    private boolean needsConquer;

    /**
     * Indication if the sector is visible under fog-of-war rules.
     */
    private boolean visible;

    /**
     * If the sector is affected by winter.
     */
    private boolean winter;

    /**
     * Counter for turns until fully assimilated after a conquer.
     */
    private int conqueredCounter;

    /**
     * Indication the progress of building a complex production site.
     */
    private int buildProgress;

    /**
     * Signals if the sector was conquered this turn.
     */
    private boolean conquered;

    /**
     * Indicator if there is river in the north side of the sector.
     */
    private boolean riverNorth;

    /**
     * Indicator if there is river in the east side of the sector.
     */
    private boolean riverEast;

    /**
     * Indicator if there is river in the south side of the sector.
     */
    private boolean riverSouth;

    /**
     * Indicator if there is river in the west side of the sector.
     */
    private boolean riverWest;

    /**
     * The type of the climatic zone.
     */
    private char climaticZone;

    /**
     * Default SectorDTO's constructor.
     */
    public SectorDTO() {
        // Empty constructor
        isByTheSea = false;
    }

    /**
     * Get the Identification number of the sector.
     *
     * @return the identification number of the sector.
     */
    public int getId() {
        return id;
    }

    /**
     * Set the Identification number of the sector.
     *
     * @param identity the identification number of the sector.
     */
    public void setId(final int identity) {
        this.id = identity;
    }

    /**
     * Get the population of the sector.
     *
     * @return the population of the sector.
     */
    public Integer getPopulation() {
        return population;
    }

    /**
     * Set the population of the sector.
     *
     * @param pop the population of the sector.
     */
    public void setPopulation(final int pop) {
        this.population = pop;
    }

    /**
     * Get the terrain of the sector.
     *
     * @return the terrain of the sector.
     */
    public TerrainDTO getTerrain() {
        return terrain;
    }

    /**
     * Set the terrain of the sector.
     *
     * @param value the terrain of the sector.
     */
    public void setTerrain(final TerrainDTO value) {
        this.terrain = value;
    }

    /**
     * Get the terrain of the sector.
     *
     * @return the terrain of the sector.
     */
    public int getTerrainId() {
        return terrainId;
    }

    /**
     * Set the terrain of the sector.
     *
     * @param value the terrain of the sector.
     */
    public void setTerrainId(final int value) {
        this.terrainId = value;
    }

    /**
     * Get the natural resource number of the sector.
     *
     * @return the natural resource number of the sector.
     */
    public NaturalResourceDTO getNatResDTO() {
        return natResDTO;
    }

    /**
     * Set the natural resource of the sector.
     *
     * @param value the natural resource of the sector.
     */
    public void setNatResDTO(final NaturalResourceDTO value) {
        this.natResDTO = value;
    }

    /**
     * Get the natural resource number of the sector.
     *
     * @return the natural resource number of the sector.
     */
    public int getNatResId() {
        return natResId;
    }

    /**
     * Set the natural resource of the sector.
     *
     * @param value the natural resource of the sector.
     */
    public void setNatResId(final int value) {
        this.natResId = value;
    }

    /**
     * Get the production site of the sector.
     *
     * @return the production site of the sector.
     */
    public ProductionSiteDTO getProductionSiteDTO() {
        return productionSiteDTO;
    }

    /**
     * Set the natural resource of the sector.
     *
     * @param value the production site of the sector.
     */
    public void setProductionSiteDTO(final ProductionSiteDTO value) {
        this.productionSiteDTO = value;
    }

    /**
     * Get the production site of the sector.
     *
     * @return the production site of the sector.
     */
    public int getProductionSiteId() {
        return productionSiteId;
    }

    /**
     * Set the natural resource of the sector.
     *
     * @param value the production site of the sector.
     */
    public void setProductionSiteId(final int value) {
        this.productionSiteId = value;
    }

    /**
     * Get the nation this sector belongs to.
     *
     * @return the nation this sector belongs to.
     */
    public NationDTO getNationDTO() {
        return nationDTO;
    }

    /**
     * Set the nation this sector belongs to.
     *
     * @param value The nation this sector belongs to.
     */
    public void setNationDTO(final NationDTO value) {
        this.nationDTO = value;
    }

    /**
     * Get the nation this sector belongs to.
     *
     * @return the nation this sector belongs to.
     */
    public int getNationId() {
        return nationId;
    }

    /**
     * Set the nation this sector belongs to.
     *
     * @param value The nation this sector belongs to.
     */
    public void setNationId(final int value) {
        this.nationId = value;
    }

    /**
     * Get the political sphere of influence.
     *
     * @return the political sphere of influence.
     */
    public char getPoliticalSphere() {
        return politicalSphere.charAt(0);
    }

    /**
     * Set the political sphere of influence.
     *
     * @param thisPSphere the political sphere of influence.
     */
    public void setPoliticalSphere(final char thisPSphere) {
        this.politicalSphere = String.valueOf(thisPSphere);
    }

    /**
     * Get the indicator if this sector is a the economy city.
     *
     * @return true if this sector is a the economy city.
     */
    public boolean getTradeCity() {
        return tradeCity;
    }

    /**
     * Set the indicator if this sector is a the economy city.
     *
     * @param value true if this sector is a the economy city.
     */
    public void setTradeCity(final boolean value) {
        this.tradeCity = value;
    }

    /**
     * Get the indicator if this sector was struck by an epidemic.
     *
     * @return the indicator if this sector was struck by an epidemic.
     */
    public boolean getEpidemic() {
        return epidemic;
    }

    /**
     * Set the indicator if this sector was struck by an epidemic.
     *
     * @param value the indicator if this sector was struck by an epidemic.
     */
    public void setEpidemic(final boolean value) {
        this.epidemic = value;
    }

    /**
     * Get the indicator if this sector has rebelled.
     *
     * @return the indicator if this sector has rebelled.
     */
    public boolean getRebelled() {
        return rebelled;
    }

    /**
     * Set the indicator if this sector has rebelled.
     *
     * @param value the indicator if this sector has rebelled.
     */
    public void setRebelled(final boolean value) {
        this.rebelled = value;
    }

    /**
     * Set if the sector is a sea-shore sector.
     *
     * @param value true if it is a sea-shore sector.
     */
    public void setByTheSea(final boolean value) {
        this.isByTheSea = value;
    }

    /**
     * Check if the sector is a sea-shore sector.
     *
     * @return true if the sector isd a sea-shore sector.
     */
    public boolean isByTheSea() {
        return isByTheSea;
    }

    /**
     * Get the indicator if this sector was properly maintained or not.
     *
     * @return true if this sector was properly maintained.
     */
    public boolean getPayed() {
        return payed;
    }

    /**
     * Set the indicator if this sector was properly maintained or not.
     *
     * @param value true if this sector was properly maintained or not.
     */
    public void setPayed(final boolean value) {
        this.payed = value;
    }

    /**
     * Check if the sector has a shipyard or a barrack.
     *
     * @return true if the sector has a shipyard or a barrack.
     */
    public boolean hasShipyardOrBarracks() {
        return (getProductionSiteId() == ProductionSiteConstants.PS_BARRACKS)
                || (getProductionSiteId() == ProductionSiteConstants.PS_BARRACKS_FS)
                || (getProductionSiteId() == ProductionSiteConstants.PS_BARRACKS_FM)
                || (getProductionSiteId() == ProductionSiteConstants.PS_BARRACKS_FL)
                || (getProductionSiteId() == ProductionSiteConstants.PS_BARRACKS_FH);
    }

    /**
     * Determine the level of the sector based on the population size.
     *
     * @return the corresponding level.
     */
    public final int populationCount() {
        int popCount = POP_LEVELS[getPopulation()];

        // Deserts have max 500 for level 0
        if (getTerrain().getId() == TerrainConstants.TERRAIN_D) {
            popCount = 500;
        }

        return popCount;
    }

    /**
     * Get the name of the sector.
     *
     * @return the name of the sector.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the sector.
     *
     * @param value the name of the sector.
     */
    public void setName(final String value) {
        this.name = value;
    }

    /**
     * Get the image that represents the state of the sector.
     *
     * @return the image that represents the state of the sector.
     */
    public String getImage() {
        return image;
    }

    /**
     * Set the image that represents the state of the sector.
     *
     * @param value the image that represents the state of the sector.
     */
    public void setImage(final String value) {
        this.image = value;
    }

    /**
     * Get the image that represents the geographic state of the sector.
     *
     * @return the image that represents the state of the sector.
     */
    public String getImageGeo() {
        return imageGeo;
    }

    /**
     * Set the image that represents the geographic state of the sector.
     *
     * @param value the image that represents the state of the sector.
     */
    public void setImageGeo(final String value) {
        imageGeo = value;
    }

    /**
     * Get the indication for storm affecting the sector or is centered on this sector.
     *
     * @return the indication for storm affecting the sector or is centered on this sector.
     */
    public int getStorm() {
        return storm;
    }

    /**
     * Set the indication for storm affecting the sector or is centered on this sector.
     *
     * @param value the indication for storm affecting the sector or is centered on this sector.
     */
    public void setStorm(final int value) {
        this.storm = value;
    }

    /**
     * Get the Indication if the sector needs to be conquered.
     *
     * @return the Indication if the sector needs to be conquered.
     */
    public boolean getNeedsConquer() {
        return needsConquer;
    }

    /**
     * Set the Indication if the sector needs to be conquered.
     *
     * @param value the Indication if the sector needs to be conquered.
     */
    public void setNeedsConquer(final boolean value) {
        this.needsConquer = value;
    }

    /**
     * Get the Indication if the sector is visible under fog-of-war rules.
     *
     * @return the Indication if the sector is visible under fog-of-war rules.
     */
    public boolean getVisible() {
        return visible;
    }

    /**
     * Set the Indication if the sector is visible under fog-of-war rules.
     *
     * @param value the Indication if the sector is visible under fog-of-war rules.
     */
    public void setVisible(final boolean value) {
        this.visible = value;
    }

    /**
     * Get if the sector is affected by winter.
     *
     * @return if the sector is affected by winter.
     */
    public boolean getWinter() {
        return winter;
    }

    /**
     * Set if the sector is affected by winter.
     *
     * @param value if the sector is affected by winter.
     */
    public void setWinter(final boolean value) {
        this.winter = value;
    }

    /**
     * Get the counter for turns until fully assimilated after a conquer.
     *
     * @return the counter for turns until fully assimilated after a conquer.
     */
    public int getConqueredCounter() {
        return conqueredCounter;
    }

    /**
     * Set the counter for turns until fully assimilated after a conquer.
     *
     * @param counter the counter for turns until fully assimilated after a conquer.
     */
    public void setConqueredCounter(final int counter) {
        conqueredCounter = counter;
    }


    /**
     * Get indicator on the progress of building a complex production site.
     *
     * @return indicator on the progress of building a complex production site.
     */
    public int getBuildProgress() {
        return buildProgress;
    }

    /**
     * Set the indicator on the progress of building a complex production site.
     *
     * @param value indicator on the progress of building a complex production site.
     */
    public void setBuildProgress(final int value) {
        this.buildProgress = value;
    }

    /**
     * Get if the sector was conquered this turn.
     * @return if the sector was conquered this turn.
     */
    public boolean getConquered() {
        return conquered;
    }

    /**
     * Set if the sector was conquered this turn.
     * @param value if the sector was conquered this turn.
     */
    public void setConquered(final boolean value) {
        this.conquered = value;
    }


    /**
     * Get if there is river in the north side of the sector.
     *
     * @return True if sector has river in the north side.
     */
    public boolean isRiverNorth() {
        return riverNorth;
    }

    /**
     * Set if there is river in the north side of this sector.
     *
     * @param value The value to set.
     */
    public void setRiverNorth(boolean value) {
        this.riverNorth = value;
    }

    /**
     * Get if there is river in the east side of the sector.
     *
     * @return True if sector has river in the east side.
     */
    public boolean isRiverEast() {
        return riverEast;
    }

    /**
     * Set if there is river in the east side of this sector.
     *
     * @param value The value to set.
     */
    public void setRiverEast(boolean value) {
        this.riverEast = value;
    }

    /**
     * Get if there is river in the south side of the sector.
     *
     * @return True if sector has river in the south side.
     */
    public boolean isRiverSouth() {
        return riverSouth;
    }

    /**
     * Set if there is river in the south side of this sector.
     *
     * @param value The value to set.
     */
    public void setRiverSouth(boolean value) {
        this.riverSouth = value;
    }

    /**
     * Get if there is river in the west side of the sector.
     *
     * @return True if sector has river in the west side.
     */
    public boolean isRiverWest() {
        return riverWest;
    }

    /**
     * Set if there is river in the west side of this sector.
     *
     * @param value The value to set.
     */
    public void setRiverWest(boolean value) {
        this.riverWest = value;
    }

    /**
     * Get the climatic zone for this sector.
     *
     * @return The climatic zone indicator.
     */
    public char getClimaticZone() {
        return climaticZone;
    }

    /**
     * Set the climatic zone.
     *
     * @param climaticZone The value to set.
     */
    public void setClimaticZone(char climaticZone) {
        this.climaticZone = climaticZone;
    }

}
