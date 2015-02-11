package com.eaw1805.data.dto.web.army;

import com.eaw1805.data.dto.web.CargoUnitDTO;

import java.io.Serializable;

/**
 * Models a Spy.
 */
public class SpyDTO
        extends CargoUnitDTO
        implements com.google.gwt.user.client.rpc.IsSerializable, Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 38L; //NOPMD

    /**
     * The unique identifier of the spy.
     */
    private int spyId;

    /**
     * The name of the spy.
     */
    private String name;

    /**
     * The original name of the spy as  is stored in the db.
     */
    private String originalName;

    /**
     * The nationId that this spy belongs to.
     */
    private int nationId;

    /**
     * The number of turns the spy has remained stationary.
     */
    private int stationary;

    /**
     * If a colonial spy attempts to travel to another map, he/she will be eliminated and a new spy
     * will appear at a controlled barrack/shipyard of the colonial map.
     */
    private boolean colonial;

    /**
     * The number of battalions on the current position and their owner
     */
    private String reportBattalions;

    /**
     * The number of brigades on the 8 neighboring co-ordinates.
     */
    private String reportBrigades;

    /**
     * The number of warships and merchant ships on the current position and their owner.
     */
    private String reportShips;

    /**
     * The number of ships on the 8 neighboring co-ordinates.
     */
    private String reportNearbyShips;

    /**
     * The amount of trading that took place last month (no trading, little trading,
     * substantial trading or heavy trading).
     */
    private String reportTrade;

    /**
     * The nationId's relations to report.
     */
    private int reportRelations;

    /**
     * The spy's movement points.
     */
    private int spyMP = 80;

    /**
     * Get the unique identifier of the spy.
     *
     * @return the unique identifier of the spy.
     */
    public int getSpyId() {
        return spyId;
    }

    /**
     * Set the unique identifier of the spy.
     *
     * @param identity the unique identifier of the spy.
     */
    public void setSpyId(final int identity) {
        this.spyId = identity;
    }

    /**
     * Get the name of the spy.
     *
     * @return the name of the spy.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the thisName of the spy.
     *
     * @param thisName the name of the spy.
     */
    public void setName(final String thisName) {
        this.name = thisName;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    /**
     * Get the nationId this spy belongs to.
     *
     * @return the nationId this spy belongs to.
     */
    public int getNationId() {
        return nationId;
    }

    /**
     * Set the nationId this spy belongs to.
     *
     * @param param The nationId this spy belongs to.
     */
    public void setNationId(final int param) {
        this.nationId = param;
    }

    /**
     * Get the number of turns this spy remained stationary.
     *
     * @return the number of turns this spy remained stationary.
     */
    public int getStationary() {
        return stationary;
    }

    /**
     * Set the number of turns this spy remained stationary.
     *
     * @param value the number of turns this spy remained stationary.
     */
    public void setStationary(final int value) {
        this.stationary = value;
    }

    /**
     * Get if this is a colonial spy.
     *
     * @return true if this is a colonial spy.
     */
    public boolean getColonial() {
        return colonial;
    }

    /**
     * Set if this is a colonial spy.
     *
     * @param value true if this is a colonial spy.
     */
    public void setColonial(final boolean value) {
        this.colonial = value;
    }

    /**
     * Get the battalions report.
     *
     * @return the battalions report.
     */
    public String getReportBattalions() {
        return reportBattalions;
    }

    /**
     * Set the battalions report.
     *
     * @param value the battalions report.
     */
    public void setReportBattalions(final String value) {
        this.reportBattalions = value;
    }

    /**
     * Get the brigades report.
     *
     * @return the brigades report.
     */
    public String getReportBrigades() {
        return reportBrigades;
    }

    /**
     * Set the brigades report.
     *
     * @param value the brigades report.
     */
    public void setReportBrigades(final String value) {
        this.reportBrigades = value;
    }

    /**
     * Get the ships report.
     *
     * @return the ships report.
     */
    public String getReportShips() {
        return reportShips;
    }

    /**
     * Set the ships report.
     *
     * @param value the ships report.
     */
    public void setReportShips(final String value) {
        this.reportShips = value;
    }

    /**
     * Get the number of ships on the 8 neighboring co-ordinates.
     *
     * @return the number of ships on the 8 neighboring co-ordinates.
     */
    public String getReportNearbyShips() {
        return reportNearbyShips;
    }

    /**
     * Set the number of ships on the 8 neighboring co-ordinates.
     *
     * @param value the number of ships on the 8 neighboring co-ordinates.
     */
    public void setReportNearbyShips(final String value) {
        this.reportNearbyShips = value;
    }

    /**
     * Get the trading report.
     *
     * @return the trading report.
     */
    public String getReportTrade() {
        return reportTrade;
    }

    /**
     * Set the trading report.
     *
     * @param value the trading report.
     */
    public void setReportTrade(final String value) {
        this.reportTrade = value;
    }

    /**
     * Get the nationId's relations to report.
     *
     * @return the nationId's relations to report.
     */
    public int getReportRelations() {
        return reportRelations;
    }

    /**
     * Set the nationId's relations to report.
     *
     * @param value the nationId's relations to report.
     */
    public void setReportRelations(final int value) {
        this.reportRelations = value;
    }

    /**
     * Get the spy's movement points.
     *
     * @return the spy's movement points.
     */
    public int getSpyMP() {
        return this.spyMP;
    }

    /**
     * Set the spy's movement points.
     *
     * @param spyMP the spy's movement points.
     */
    public void setSpyMP(final int spyMP) {
        this.spyMP = spyMP;
    }


}
