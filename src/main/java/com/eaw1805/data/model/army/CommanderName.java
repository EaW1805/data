package com.eaw1805.data.model.army;

import com.eaw1805.data.model.Game;
import com.eaw1805.data.model.Nation;

import java.io.Serializable;

/**
 * Used to store names for commanders.
 */
public class CommanderName implements Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD

    /**
     * The unique identifier of the commander.
     */
    private int nameId; // NOPMD

    /**
     * The nation that this commander belongs to.
     */
    private Nation nation;

    /**
     * The position of the commander.
     */
    private int position;

    /**
     * The name of the commander.
     */
    private String name;

    /**
     * The game that the name belongs to.
     * We need this only for the Scenario Client.
     */
    private Game game;

    /**
     * Empty constructor.
     */
    public CommanderName() {
        // Empty constructor
    }

    /**
     * Get the id of the commander name,
     *
     * @return the identity.
     */
    public int getNameId() {
        return nameId;
    }

    /**
     * Set the id of the commander name.
     *
     * @param value the id of the commander name.
     */
    public void setNameId(final int value) {
        this.nameId = value;
    }

    /**
     * Get the nation of the name.
     *
     * @return the nation of the name.
     */
    public Nation getNation() {
        return nation;
    }

    /**
     * Set the nation of the name.
     *
     * @param value the nation of the name.
     */
    public void setNation(final Nation value) {
        this.nation = value;
    }

    /**
     * Get the order of the name.
     *
     * @return the order of the name.
     */
    public int getPosition() {
        return position;
    }

    /**
     * Set the order of the name.
     *
     * @param value the order of the name.
     */
    public void setPosition(final int value) {
        this.position = value;
    }

    /**
     * Get the name.
     *
     * @return the name.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name.
     *
     * @param value the name.
     */
    public void setName(final String value) {
        this.name = value;
    }

    /**
     * Get the game.
     *
     * @return The game.
     */
    public Game getGame() {
        return game;
    }

    /**
     * Set the game.
     *
     * @param value The value to set.
     */
    public void setGame(final Game value) {
        this.game = value;
    }
}
