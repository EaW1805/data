package com.eaw1805.data.model.map;

import com.eaw1805.data.constants.ProductionSiteConstants;
import com.eaw1805.data.constants.TerrainConstants;
import com.eaw1805.data.model.Nation;

import java.io.Serializable;

/**
 * Sector object to hold information for a map sector.
 */
public class Sector implements Serializable { // NOPMD

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD

    /**
     * Population size for each level.
     */
    public static final int[] POP_LEVELS = {1000, 4000, 10000, 20000, 40000, 60000, 90000, 120000, 160000, 200000};

    /**
     * Required citizens to raise the population density.
     */
    public static final int[] REQ_CITIZENS = {4000, 6000, 10000, 20000, 20000, 30000, 30000, 40000, 40000, 40000};

    /**
     * Required wood to raise the population density.
     */
    public static final int[] REQ_STONE = {320, 480, 800, 1600, 1600, 2400, 2400, 3200, 3200, 3200};

    /**
     * Sector's identification number.
     */
    private int id; // NOPMD

    /**
     * Sector's relative coordinates.
     */
    private Position position;

    /**
     * Sector's population.
     */
    private int population;

    /**
     * Sector's terrain.
     */
    private Terrain terrain;

    /**
     * Sector's natural resource.
     */
    private NaturalResource naturalResource;

    /**
     * Sector's production site.
     */
    private ProductionSite productionSite;

    /**
     * Indication the progress of building a complex production site.
     */
    private int buildProgress;

    /**
     * The nation that this sector belongs to.
     */
    private Nation nation;

    /**
     * The political sphere of influence.
     */
    private char politicalSphere;

    /**
     * Counter for turns until fully assimilated after a conquer.
     */
    private int conqueredCounter;

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
     * Temporary nation in case the sector was conquered.
     */
    private Nation tempNation;

    /**
     * Indication for storm affecting the sector or is centered on this sector.
     */
    private int storm;

    /**
     * Signals if the production site was maintained properly during last turn.
     */
    private boolean payed;

    /**
     * Signals if the sector was conquered this turn.
     */
    private boolean conquered;

    /**
     * Fog of War. Lists all the nation ids that are allowed to view the details of this sector in a *-delimited format.
     */
    private String fow;

    /**
     * Boolean if the sector has river at the north side.
     */
    private boolean riverNorth;

    /**
     * Boolean if the sector has river at the east side.
     */
    private boolean riverEast;

    /**
     * Boolean if the sector has river at the south side.
     */
    private boolean riverSouth;

    /**
     * Boolean if the sector has river at the west side.
     */
    private boolean riverWest;

    /**
     * The type of the climatic zone.
     */
    private char climaticZone;

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
        id = identity;
    }

    /**
     * Get the nation this sector belongs to.
     *
     * @return the nation this sector belongs to.
     */
    public Nation getNation() {
        return nation;
    }

    /**
     * Set the nation this sector belongs to.
     *
     * @param param The nation this sector belongs to.
     */
    public void setNation(final Nation param) {
        nation = param;
    }

    /**
     * Get the relative position of the sector.
     *
     * @return the relative position of the sector.
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Set the relative position of the sector.
     *
     * @param param the relative position of the sector.
     */
    public void setPosition(final Position param) {
        position = param;
    }

    /**
     * Get the population of the sector.
     *
     * @return the population of the sector.
     */
    public int getPopulation() {
        return population;
    }

    /**
     * Set the population of the sector.
     *
     * @param param the population of the sector.
     */
    public void setPopulation(final int param) {
        population = param;
    }

    /**
     * Get the terrain of the sector.
     *
     * @return the terrain of the sector.
     */
    public Terrain getTerrain() {
        return terrain;
    }

    /**
     * Set the terrain of the sector.
     *
     * @param param the terrain of the sector.
     */
    public void setTerrain(final Terrain param) {
        terrain = param;
    }

    /**
     * Get the natural resource number of the sector.
     *
     * @return the natural resource number of the sector.
     */
    public NaturalResource getNaturalResource() {
        return naturalResource;
    }

    /**
     * Set the natural resource of the sector.
     *
     * @param param the natural resource of the sector.
     */
    public void setNaturalResource(final NaturalResource param) {
        naturalResource = param;
    }

    /**
     * Get the production site of the sector.
     *
     * @return the production site of the sector.
     */
    public ProductionSite getProductionSite() {
        return productionSite;
    }

    /**
     * Set the natural resource of the sector.
     *
     * @param param the production site of the sector.
     */
    public void setProductionSite(final ProductionSite param) {
        productionSite = param;
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
     * Get the political sphere of influence.
     *
     * @return the political sphere of influence.
     */
    public char getPoliticalSphere() {
        return politicalSphere;
    }

    /**
     * Set the political sphere of influence.
     *
     * @param thisPSphere the political sphere of influence.
     */
    public void setPoliticalSphere(final char thisPSphere) {
        politicalSphere = thisPSphere;
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
        tradeCity = value;
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
        epidemic = value;
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
        rebelled = value;
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
     * Set the image that represents the state of the sector.
     *
     * @param value the image that represents the state of the sector.
     */
    public void setImage(final String value) {
        image = value;
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
        storm = value;
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
        payed = value;
    }

    /**
     * Get if the sector was conquered this turn.
     *
     * @return if the sector was conquered this turn.
     */
    public boolean getConquered() {
        return conquered;
    }

    /**
     * Set if the sector was conquered this turn.
     *
     * @param value if the sector was conquered this turn.
     */
    public void setConquered(final boolean value) {
        this.conquered = value;
    }

    /**
     * Get the Temporary nation in case the sector was conquered.
     *
     * @return the Temporary nation in case the sector was conquered.
     */
    public Nation getTempNation() {
        return tempNation;
    }

    /**
     * Set the Temporary nation in case the sector was conquered.
     *
     * @param value the Temporary nation in case the sector was conquered.
     */
    public void setTempNation(final Nation value) {
        tempNation = value;
    }

    /**
     * Get the Fog of War. Lists all the nation ids that are allowed to view the details of this sector in a *-delimited format.
     *
     * @return the Fog of War. Lists all the nation ids that are allowed to view the details of this sector in a *-delimited format.
     */
    public String getFow() {
        return fow;
    }

    /**
     * Set the Fog of War. Lists all the nation ids that are allowed to view the details of this sector in a *-delimited format.
     *
     * @param value the Fog of War. Lists all the nation ids that are allowed to view the details of this sector in a *-delimited format.
     */
    public void setFow(final String value) {
        fow = value;
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
     * Population of Conquered Areas.
     *
     * @return the rate of decrease of the taxation.
     */
    public final int taxDecrease() {
        int decrease;
        switch (getConqueredCounter()) {
            case 0:
                decrease = 0;
                break;

            case 1:
                decrease = 80;
                break;

            case 2:
                decrease = 70;
                break;

            case 3:
                decrease = 60;
                break;

            case 4:
                decrease = 50;
                break;

            case 5:
            default:
                decrease = 100;
                break;
        }

        return decrease;
    }

    /**
     * Check if the sector has the capability to train troops.
     *
     * @return true if a barrack is available at this sector.
     */
    public final boolean hasBarrack() {
        return (getProductionSite() != null)
                && ((getProductionSite().getId() == ProductionSiteConstants.PS_BARRACKS)
                || (getProductionSite().getId() == ProductionSiteConstants.PS_BARRACKS_FS)
                || (getProductionSite().getId() == ProductionSiteConstants.PS_BARRACKS_FM)
                || (getProductionSite().getId() == ProductionSiteConstants.PS_BARRACKS_FL)
                || (getProductionSite().getId() == ProductionSiteConstants.PS_BARRACKS_FH));
    }

    /**
     * Check if the sector has a fort.
     *
     * @return true if a fort is available at this sector.
     */
    public final boolean hasFort() {
        return (getProductionSite() != null)
                && ((getProductionSite().getId() == ProductionSiteConstants.PS_BARRACKS_FS)
                || (getProductionSite().getId() == ProductionSiteConstants.PS_BARRACKS_FM)
                || (getProductionSite().getId() == ProductionSiteConstants.PS_BARRACKS_FL)
                || (getProductionSite().getId() == ProductionSiteConstants.PS_BARRACKS_FH));
    }

    /**
     * Check if the sector has the capability to build ships.
     *
     * @return true if a shipyard is available at this sector.
     */
    public final boolean hasShipyard() {
        return hasBarrack();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }

        final Sector sector = (Sector) other;

        if (id != sector.id) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
