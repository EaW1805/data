package com.eaw1805.data.dto.web;


import java.io.Serializable;

public class GameSettingsDTO
        implements com.google.gwt.user.client.rpc.IsSerializable, Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD

    /**
     * The id of the game settings object.
     */
    private int id;

    /**
     * If land forces are visible.
     */
    private boolean landForces;

    /**
     * If movements are visible.
     */
    private boolean movements;

    /**
     * If population density is visible.
     */
    private boolean populationDensity;

    /**
     * If sphere of influence is visible.
     */
    private boolean sphereOfInfluence;

    /**
     * If political borders are visible.
     */
    private boolean politicalBorders;

    /**
     * If naval forces are visible.
     */
    private boolean navalForces;

    /**
     * If grid is visible.
     */
    private boolean grid;

    /**
     * If virtual reported units are visible.
     */
    private boolean virtualReportedUnits;

    /**
     * If nation is dead.
     */
    private boolean deadNation;

    /**
     * If music is on.
     */
    private boolean music;

    /**
     * If sound effects is on.
     */
    private boolean soundEffects;

    /**
     * If low resolution images will be used.
     */
    private boolean lowResolution;

    /**
     * Zoom level (or -1 for default).
     */
    private double zoom;

    /**
     * Indicates if a user can use harsh taxation in this round.
     */
    private boolean allowHarshTax;

    /**
     * If game has ended.
     */
    private boolean gameEnded;

    /**
     * If trade cities goods are on map.
     */
    private boolean tradeCities;

    /**
     * If client is in fullscreen mode.
     */
    private boolean fullscreen;

    /**
     * Get the id.
     *
     * @return The id to get.
     */
    public int getId() {
        return id;
    }

    /**
     * Set the id.
     *
     * @param id The id to set.
     */
    public void setId(final int id) {
        this.id = id;
    }

    /**
     * Get if land forces are visible.
     *
     * @return True if land forces are visible.
     */
    public boolean isLandForces() {
        return landForces;
    }

    /**
     * Set if land forces are visible.
     *
     * @param landForces The value to set.
     */
    public void setLandForces(final boolean landForces) {
        this.landForces = landForces;
    }

    /**
     * Get if movements are visible.
     *
     * @return True if movements are visible.
     */
    public boolean isMovements() {
        return movements;
    }

    /**
     * Set if movements are visible.
     *
     * @param movements The value to set.
     */
    public void setMovements(final boolean movements) {
        this.movements = movements;
    }

    /**
     * Get if population density are visible.
     *
     * @return True if population density are visible.
     */
    public boolean isPopulationDensity() {
        return populationDensity;
    }

    /**
     * Set if population density is visible.
     *
     * @param populationDensity The value to set.
     */
    public void setPopulationDensity(final boolean populationDensity) {
        this.populationDensity = populationDensity;
    }

    /**
     * Get if sphere of influence are visible.
     *
     * @return True if sphere of influence are visible.
     */
    public boolean isSphereOfInfluence() {
        return sphereOfInfluence;
    }

    /**
     * Set if sphere of influence are visible.
     *
     * @param sphereOfInfluence The value to set.
     */
    public void setSphereOfInfluence(final boolean sphereOfInfluence) {
        this.sphereOfInfluence = sphereOfInfluence;
    }

    /**
     * Get if political borders are visible.
     *
     * @return True if political borders are visible.
     */
    public boolean isPoliticalBorders() {
        return politicalBorders;
    }

    /**
     * Set if political borders are visible.
     *
     * @param politicalBorders The value to set.
     */
    public void setPoliticalBorders(final boolean politicalBorders) {
        this.politicalBorders = politicalBorders;
    }

    /**
     * Get if naval forces are visible.
     *
     * @return True if naval forces are visible.
     */
    public boolean isNavalForces() {
        return navalForces;
    }

    /**
     * Set if naval forces are visible.
     *
     * @param navalForces The value to set.
     */
    public void setNavalForces(final boolean navalForces) {
        this.navalForces = navalForces;
    }

    /**
     * Get if grid are visible.
     *
     * @return True if grid  are visible.
     */
    public boolean isGrid() {
        return grid;
    }

    /**
     * Set if grid units are visible.
     *
     * @param grid The value to set.
     */
    public void setGrid(final boolean grid) {
        this.grid = grid;
    }

    /**
     * Get if virtual reported units are visible.
     *
     * @return True if virtual reported units are visible.
     */
    public boolean isVirtualReportedUnits() {
        return virtualReportedUnits;
    }

    /**
     * Set if virtual reported units are visible.
     *
     * @param virtualReportedUnits The value to set.
     */
    public void setVirtualReportedUnits(final boolean virtualReportedUnits) {
        this.virtualReportedUnits = virtualReportedUnits;
    }

    /**
     * Get if nation is dead.
     *
     * @return If nation is dead.
     */
    public boolean isDeadNation() {
        return deadNation;
    }

    /**
     * Set if nation is dead.
     *
     * @param deadNation The value to set.
     */
    public void setDeadNation(final boolean deadNation) {
        this.deadNation = deadNation;
    }

    /**
     * Get if music is on.
     *
     * @return True if music is on.
     */
    public boolean isMusic() {
        return music;
    }

    /**
     * Set if music is on.
     *
     * @param music The value to set.
     */
    public void setMusic(boolean music) {
        this.music = music;
    }

    /**
     * Get if sound effects are on.
     *
     * @return True if sound effects are on.
     */
    public boolean isSoundEffects() {
        return soundEffects;
    }

    /**
     * Set if sound effects are on.
     *
     * @param soundEffects True if sound effects are on.
     */
    public void setSoundEffects(boolean soundEffects) {
        this.soundEffects = soundEffects;
    }

    /**
     * Get If low resolution images will be used.
     *
     * @return If low resolution images will be used.
     */
    public boolean isLowResolution() {
        return lowResolution;
    }

    /**
     * Set If low resolution images will be used.
     *
     * @param value, If low resolution images will be used.
     */
    public void setLowResolution(final boolean value) {
        this.lowResolution = value;
    }

    /**
     * Get the Zoom level (or -1 for default).
     *
     * @return the Zoom level (or -1 for default).
     */
    public double getZoom() {
        return zoom;
    }

    /**
     * Set the Zoom level (or -1 for default).
     *
     * @param value the Zoom level (or -1 for default).
     */
    public void setZoom(final double value) {
        this.zoom = value;
    }

    /**
     * Get if user can use harsh taxation.
     *
     * @return
     */
    public boolean isAllowHarshTax() {
        return allowHarshTax;
    }

    /**
     * Set if user can use harsh taxation.
     *
     * @param value The value to set.
     */
    public void setAllowHarshTax(boolean value) {
        this.allowHarshTax = value;
    }

    /**
     * Get if the game has ended.
     *
     * @return true, if the game has ended.
     */
    public boolean isGameEnded() {
        return gameEnded;
    }

    /**
     * Set if the game has ended.
     *
     * @param value the game has ended.
     */
    public void setGameEnded(final boolean value) {
        this.gameEnded = value;
    }

    /**
     * Get if showing trade city goods on map.
     *
     * @return A boolean value.
     */
    public boolean isTradeCities() {
        return tradeCities;
    }

    /**
     * Set if showing trade cities goods on map.
     *
     * @param value The value to set.
     */
    public void setTradeCities(boolean value) {
        this.tradeCities = value;
    }

    /**
     * Get if client is in fullscreen mode.
     *
     * @return A boolean value.
     */
    public boolean isFullscreen() {
        return fullscreen;
    }

    /**
     * Set if client is in fullscreen mode.
     *
     * @param value The value to  set.
     */
    public void setFullscreen(final boolean value) {
        this.fullscreen = value;
    }
}
