package com.eaw1805.data.dto.web;

import java.io.Serializable;

/**
 * Game object holds all meta-data for the game itself.
 */
public class GameDTO
        implements com.google.gwt.user.client.rpc.IsSerializable, Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD

    /**
     * Game's ID.
     */
    private int id;

    /**
     * The current turn of the game.
     */
    private int turn;

    /**
     * Get the Identification number of the game.
     *
     * @return the identification number of the game.
     */
    public int getGameId() {
        return id;
    }

    /**
     * Set the identification number of the game.
     *
     * @param identity the identification number of the game.
     */
    public void setGameId(final int identity) {
        this.id = identity;
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
     * @param thisTurn the number of the turn.
     */
    public void setTurn(final int thisTurn) {
        this.turn = thisTurn;
    }

}
