package com.eaw1805.data.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Stores information related to a processing of a game turn.
 */
public class EngineProcess implements Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD

    /**
     * Processing id.
     */
    private int procId;

    /**
     * Game's ID.
     */
    private int gameId;

    /**
     * Scenario ID.
     */
    private int scenarioId;

    /**
     * The current turn of the game.
     */
    private int turn;

    /**
     * The date the processing started.
     */
    private Date dateStart;

    /**
     * The duration of the processing in seconds.
     */
    private int duration;

    /**
     * The name of the process in the linux system.
     */
    private String processName;

    /**
     * The build number.
     */
    private int buildNumber;

    /**
     * Set the Processing id.
     *
     * @return the Processing id.
     */
    public int getProcId() {
        return procId;
    }

    /**
     * Set the Processing id.
     *
     * @param value the Processing id.
     */
    public void setProcId(final int value) {
        this.procId = value;
    }

    /**
     * Get the Identification number of the game.
     *
     * @return the identification number of the game.
     */
    public int getGameId() {
        return gameId;
    }

    /**
     * Set the identification number of the game.
     *
     * @param value the identification number of the game.
     */
    public void setGameId(final int value) {
        this.gameId = value;
    }

    /**
     * Get the Scenario ID.
     *
     * @return the Scenario ID.
     */
    public int getScenarioId() {
        return scenarioId;
    }

    /**
     * Set the Scenario ID.
     *
     * @param value the Scenario ID.
     */
    public void setScenarioId(final int value) {
        this.scenarioId = value;
    }

    /**
     * The current turn number.
     *
     * @return the turn number of the game.
     */
    public int getTurn() {
        return turn;
    }

    /**
     * Set the turn number of the game.
     *
     * @param value the number of the turn.
     */
    public void setTurn(final int value) {
        this.turn = value;
    }

    /**
     * Get the date the processing started.
     *
     * @return the date the processing started.
     */
    public Date getDateStart() {
        return dateStart;
    }

    /**
     * Set the date the processing started.
     *
     * @param value the date the processing started.
     */
    public void setDateStart(final Date value) {
        this.dateStart = value;
    }

    /**
     * Set the duration of the processing.
     *
     * @return the duration of the processing.
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Set the duration of the processing.
     *
     * @param value the duration of the processing.
     */
    public void setDuration(final int value) {
        this.duration = value;
    }

    /**
     * Get the name of the process in the linux system.
     *
     * @return the name of the process in the linux system.
     */
    public String getProcessName() {
        return processName;
    }

    /**
     * Set the name of the process in the linux system.
     *
     * @param value the name of the process in the linux system.
     */
    public void setProcessName(final String value) {
        this.processName = value;
    }

    /**
     * Get the build number.
     *
     * @return the build number.
     */
    public int getBuildNumber() {
        return buildNumber;
    }

    /**
     * Set the build number.
     *
     * @param value the build number.
     */
    public void setBuildNumber(final int value) {
        this.buildNumber = value;
    }
}
