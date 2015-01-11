package com.eaw1805.data.dto.common;

import java.io.Serializable;

/**
 * Data-Transfer Object for the information of the production site.
 */
public class ProductionSiteDTO
        implements com.google.gwt.user.client.rpc.IsSerializable, Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD

    /**
     * ProductionSite's identification number.
     */
    private int id; // NOPMD

    /**
     * ProductionSite's code.
     */
    private char code;

    /**
     * ProductionSite's name.
     */
    private String name;

    /**
     * Suitable terrains to build this site, comma separated.
     */
    private String terrainsSuitable;

    /**
     * ProductionSite's maintenanceCosts.
     */
    private int cost;

    /**
     * ProductionSite's maintenanceCosts.
     */
    private int maintenanceCost;

    /**
     * ProductionSite's minimum population density requirement.
     */
    private int minPopDensity;

    /**
     * ProductionSite's maximum population density requirement.
     */
    private int maxPopDensity;

    /**
     * Attrition Min range (%).
     */
    private int attritionMin;

    /**
     * Attrition Max range (%).
     */
    private int attritionMax;

    /**
     * Description to be set as title of the production site.
     */
    private String description;

    /**
     * Get the Identification number of the ProductionSite.
     *
     * @return the identification number of the ProductionSite.
     */
    public int getId() {
        return id;
    }

    /**
     * Set the identification number of the ProductionSite.
     *
     * @param identity the identification number of the ProductionSite.
     */
    public void setId(final int identity) {
        this.id = identity;
    }

    /**
     * ProductionSiteDTO's default constructor.
     */
    public ProductionSiteDTO() {
        // Empty constructor
    }

    /**
     * ProductionSiteDTO's constructor that sets the identification number.
     *
     * @param identity The ProductionSiteDTO's identification number.
     */
    public ProductionSiteDTO(final int identity) {
        this.id = identity;
    }

    /**
     * The ProductionSiteDTO's constructor that sets all ProductionSiteDTO
     * fields.
     *
     * @param identity      The ProductionSite's identification number.
     * @param thisCode      The ProductionSite's code.
     * @param thisName      The ProductionSite's name.
     * @param thisTSuitable The terrains suitable for this production site.
     */
    public ProductionSiteDTO(final int identity,
                             final char thisCode,
                             final String thisName,
                             final String thisTSuitable) {
        this.id = identity;
        this.code = thisCode;
        this.name = thisName;
        this.terrainsSuitable = thisTSuitable;
    }

    /**
     * Get the single-char code of the ProductionSite.
     *
     * @return the single-char code of the ProductionSite.
     */
    public char getCode() {
        return code;
    }

    /**
     * Set the single-char code of the ProductionSite.
     *
     * @param thisCode the single-char code of the ProductionSite.
     */
    public void setCode(final char thisCode) {
        this.code = thisCode;
    }

    /**
     * Get the name of the ProductionSite.
     *
     * @return the name of the ProductionSite.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the ProductionSite.
     *
     * @param thisName the name of the ProductionSite.
     */
    public void setName(final String thisName) {
        this.name = thisName;
    }

    /**
     * Get the suitable terrains to build this site, comma separated.
     *
     * @return the suitable terrains to build this site, comma separated.
     */
    public String getTerrainsSuitable() {
        return terrainsSuitable;
    }

    /**
     * Set the suitable terrains to build this site, comma separated.
     *
     * @param terrReq the suitable terrains to build this site, comma separated.
     */
    public void setTerrainsSuitable(final String terrReq) {
        this.terrainsSuitable = terrReq;
    }

    /**
     * Get the cost of the ProductionSite.
     *
     * @return the cost of the ProductionSite.
     */
    public int getCost() {
        return cost;
    }

    /**
     * Set the cost of the ProductionSite.
     *
     * @param thisCost the cost of the ProductionSite.
     */
    public void setCost(final int thisCost) {
        this.cost = thisCost;
    }

    /**
     * Get the maintenance cost of the ProductionSite.
     *
     * @return the maintenance cost of the ProductionSite.
     */
    public int getMaintenanceCost() {
        return maintenanceCost;
    }

    /**
     * Set the maintenanceCost of the ProductionSite.
     *
     * @param maint the maintenance cost of the ProductionSite.
     */
    public void setMaintenanceCost(final int maint) {
        this.maintenanceCost = maint;
    }

    /**
     * Get the minimum population density requirement of the ProductionSite.
     *
     * @return the minimum population density requirement of the ProductionSite.
     */
    public int getMinPopDensity() {
        return minPopDensity;
    }

    /**
     * Set the minimum population density requirement of the ProductionSite.
     *
     * @param minPop the minimum population density requirement of
     *               the ProductionSite.
     */
    public void setMinPopDensity(final int minPop) {
        this.minPopDensity = minPop;
    }

    /**
     * Get the maximum population density requirement of the ProductionSite.
     *
     * @return the maximum population density requirement of the ProductionSite.
     */
    public int getMaxPopDensity() {
        return maxPopDensity;
    }

    /**
     * Set the maximum population density requirement of the ProductionSite.
     *
     * @param maxPop the maximum population density requirement of
     *               the ProductionSite.
     */
    public void setMaxPopDensity(final int maxPop) {
        this.maxPopDensity = maxPop;
    }

    /**
     * Get the maximum rate of attrition for the ProductionSite.
     *
     * @return the maximum rate of attrition for the ProductionSite.
     */
    public int getAttritionMin() {
        return attritionMin;
    }

    /**
     * Set the maximum rate of attrition for the ProductionSite.
     *
     * @param attrition the maximum rate of attrition for the ProductionSite.
     */
    public void setAttritionMin(final int attrition) {
        this.attritionMin = attrition;
    }

    /**
     * Get the minimum rate of attritionMax for the ProductionSite.
     *
     * @return the minimum rate of attritionMax for the ProductionSite.
     */
    public int getAttritionMax() {
        return attritionMax;
    }

    /**
     * Set the minimum rate of attritionMax for the ProductionSite.
     *
     * @param attrition the minimum rate of attritionMax for the ProductionSite.
     */
    public void setAttritionMax(final int attrition) {
        this.attritionMax = attrition;
    }

    /**
     * Get the description for this production site.
     *
     * @return The description as it will be visible in browser.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the description for this production site.
     *
     * @param description The description to set.
     */
    public void setDescription(final String description) {
        this.description = description;
    }
}
