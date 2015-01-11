package com.eaw1805.data.model;

import java.io.Serializable;

/**
 * Used to hold game/turn historic information for future reporting.
 */
public class Report implements Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD    

    /**
     * Report's identification number.
     */
    private int id; // NOPMD

    /**
     * The game of the report.
     */
    private com.eaw1805.data.model.Game game;

    /**
     * The turn of the report.
     */
    private int turn;

    /**
     * Nation owner.
     */
    private com.eaw1805.data.model.Nation nation;

    /**
     * Report key.
     */
    private String key;

    /**
     * Report value.
     */
    private String value;

    /**
     * Get the Identification number of the report.
     *
     * @return the identification number of the report.
     */
    public int getId() {
        return id;
    }

    /**
     * Set the identification number of the report.
     *
     * @param identity the identification number of report.
     */
    public void setId(final int identity) {
        this.id = identity;
    }

    /**
     * Get the game related to the report.
     *
     * @return the game related to the report.
     */
    public com.eaw1805.data.model.Game getGame() {
        return game;
    }

    /**
     * Set the game related to the report.
     *
     * @param thisGame the game related to the report.
     */
    public void setGame(final com.eaw1805.data.model.Game thisGame) {
        this.game = thisGame;
    }

    /**
     * The turn number related to the report.
     *
     * @return the turn number related to the report.
     */
    public int getTurn() {
        return turn;
    }

    /**
     * Set the turn number related to the report.
     *
     * @param thisTurn the number of the turn related to the report.
     */
    public void setTurn(final int thisTurn) {
        this.turn = thisTurn;
    }

    /**
     * Get the Nation related to the report.
     *
     * @return the Nation related to the report.
     */
    public com.eaw1805.data.model.Nation getNation() {
        return nation;
    }

    /**
     * Set the Nation related to the report.
     *
     * @param empireID the Nation related to the report.
     */
    public void setNation(final com.eaw1805.data.model.Nation empireID) {
        this.nation = empireID;
    }

    /**
     * Get the key of the report entry.
     *
     * @return the key of the report entry.
     */
    public String getKey() {
        return key;
    }

    /**
     * Set the key of the report entry.
     *
     * @param thisKey the key of the report entry.
     */
    public void setKey(final String thisKey) {
        this.key = thisKey;
    }

    /**
     * Get the value of the report entry.
     *
     * @return the value of the report entry.
     */
    public String getValue() {
        return value;
    }

    /**
     * Set the value of the report entry.
     *
     * @param thisValue the value of the report entry.
     */
    public void setValue(final String thisValue) {
        this.value = thisValue;
    }
}
