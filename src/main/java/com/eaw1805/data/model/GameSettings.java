package com.eaw1805.data.model;

import java.io.Serializable;

public class GameSettings implements Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD

    /**
     * The object id used by hibernate.
     */
    private int gameSettingsId;

    /**
     * The game the settings are for.
     */
    private Game game;

    /**
     * The nation the settings are for.
     */
    private Nation nation;

    /**
     * display land forces.
     */
    private boolean landForces;

    /**
     * display movements.
     */
    private boolean movements;

    /**
     * display population density.
     */
    private boolean populationDensity;

    /**
     * display sphere of influence.
     */
    private boolean sphereOfInfluence;

    /**
     * display political borders.
     */
    private boolean politicalBorders;

    /**
     * display naval forces.
     */
    private boolean navalForces;

    /**
     * display grid.
     */
    private boolean grid;

    /**
     * display reported units.
     */
    private boolean reportedUnits;

    /**
     * Play music intro.
     */
    private boolean playMusic;

    /**
     * Play sound effects.
     */
    private boolean playSoundEffects;

    /**
     * If low resolution images will be used.
     */
    private boolean lowResolution;

    /**
     * Zoom level (or -1 for default).
     */
    private double zoom;

    /**
     * Show trade cities goods on map.
     */
    private boolean tradeCities;

    /**
     * Show client in full screen mode.
     */
    private boolean fullScreen;

    /**
     * Get the gameSettings id as it has been saved in the db.
     *
     * @return The objects id.
     */
    public int getGameSettingsId() {
        return gameSettingsId;
    }

    /**
     * Used by hibernate to set the gameSettings id as it has been saved in the db.
     *
     * @param gameSettingsId The game settings id.
     */
    public void setGameSettingsId(final int gameSettingsId) {
        this.gameSettingsId = gameSettingsId;
    }

    /**
     * Get the game the settings are for.
     *
     * @return The game.
     */
    public Game getGame() {
        return game;
    }

    /**
     * Set the game the settings are for.
     *
     * @param game The game to set.
     */
    public void setGame(Game game) {
        this.game = game;
    }

    /**
     * Get the nation the settings are for.
     *
     * @return The nation.
     */
    public Nation getNation() {
        return nation;
    }

    /**
     * Set the nation the settings are for.
     *
     * @param nation The nation to set.
     */
    public void setNation(Nation nation) {
        this.nation = nation;
    }

    /**
     * Get if display land forces.
     *
     * @return True if displaying land forces.
     */
    public boolean isLandForces() {
        return landForces;
    }

    /**
     * Set if should display land forces.
     *
     * @param landForces The value to set.
     */
    public void setLandForces(final boolean landForces) {
        this.landForces = landForces;
    }

    /**
     * Get if display movement.
     *
     * @return True if displaying movements.
     */
    public boolean isMovements() {
        return movements;
    }

    /**
     * Set if should display movement.
     *
     * @param movements The value to set.
     */
    public void setMovements(final boolean movements) {
        this.movements = movements;
    }

    /**
     * Get if display population density.
     *
     * @return True if displaying population density.
     */
    public boolean isPopulationDensity() {
        return populationDensity;
    }

    /**
     * Set if should display population density.
     *
     * @param populationDensity The value to set.
     */
    public void setPopulationDensity(final boolean populationDensity) {
        this.populationDensity = populationDensity;
    }

    /**
     * Get if display sphere of influence.
     *
     * @return True if displaying sphere of influence.
     */
    public boolean isSphereOfInfluence() {
        return sphereOfInfluence;
    }

    /**
     * Set if should display sphere of influence.
     *
     * @param sphereOfInfluence The value to set.
     */
    public void setSphereOfInfluence(final boolean sphereOfInfluence) {
        this.sphereOfInfluence = sphereOfInfluence;
    }

    /**
     * Get if display political borders.
     *
     * @return True if displaying political borders.
     */
    public boolean isPoliticalBorders() {
        return politicalBorders;
    }

    /**
     * Set if should display political borders.
     *
     * @param politicalBorders The value to set.
     */
    public void setPoliticalBorders(final boolean politicalBorders) {
        this.politicalBorders = politicalBorders;
    }

    /**
     * Get if display naval forces.
     *
     * @return True if displaying naval forces.
     */
    public boolean isNavalForces() {
        return navalForces;
    }

    /**
     * Set if should display naval forces.
     *
     * @param navalForces The value to set.
     */
    public void setNavalForces(final boolean navalForces) {
        this.navalForces = navalForces;
    }

    /**
     * Get if display grid.
     *
     * @return True if displaying grid.
     */
    public boolean isGrid() {
        return grid;
    }

    /**
     * Set if should display grid.
     *
     * @param grid The value to set.
     */
    public void setGrid(final boolean grid) {
        this.grid = grid;
    }

    /**
     * Get if display reported units.
     *
     * @return True if displaying reported units.
     */
    public boolean isReportedUnits() {
        return reportedUnits;
    }

    /**
     * Set if  should display reported units.
     *
     * @param reportedUnits True if displaying reported units.
     */
    public void setReportedUnits(final boolean reportedUnits) {
        this.reportedUnits = reportedUnits;
    }

    /**
     * Get if play music.
     *
     * @return True if playing music.
     */
    public boolean isPlayMusic() {
        return playMusic;
    }

    /**
     * Set if should play music.
     *
     * @param playMusic The value to set.
     */
    public void setPlayMusic(boolean playMusic) {
        this.playMusic = playMusic;
    }

    /**
     * Get if play sound effects.
     *
     * @return True if playing sound effects.
     */
    public boolean isPlaySoundEffects() {
        return playSoundEffects;
    }

    /**
     * Set if should play sound effects.
     *
     * @param playSoundEffects The value to set.
     */
    public void setPlaySoundEffects(boolean playSoundEffects) {
        this.playSoundEffects = playSoundEffects;
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
    public void setLowResolution(boolean value) {
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
    public boolean isFullScreen() {
        return fullScreen;
    }

    /**
     * Set if client is in full screen mode.
     *
     * @param value The value to set.
     */
    public void setFullScreen(final boolean value) {
        this.fullScreen = value;
    }
}
