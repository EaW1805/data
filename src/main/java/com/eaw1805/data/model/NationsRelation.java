package com.eaw1805.data.model;

import java.io.Serializable;

/**
 * Models political relation between nations.
 */
public class NationsRelation implements Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD

    /**
     * The identification number of the relation.
     */
    private int id; // NOPMD

    /**
     * The game.
     */
    private com.eaw1805.data.model.Game game;

    /**
     * Nation owner.
     */
    private com.eaw1805.data.model.Nation nation;

    /**
     * Nation target.
     */
    private com.eaw1805.data.model.Nation target;

    /**
     * relation to other nations.
     */
    private int relation;

    /**
     * The prisoners of war.
     */
    private int prisoners;

    /**
     * Turn count since the previous change.
     */
    private int turnCount;

    /**
     * Turn count since the peace.
     */
    private int peaceCount;

    /**
     * Turn count since the surrender.
     */
    private int surrenderCount;

    /**
     * Turn movements visible to the ally.
     */
    private boolean visible;

    /**
     * Get the relation identification number.
     *
     * @return the relation identification number.
     */
    public int getId() {
        return id;
    }

    /**
     * Set the relation identification number.
     *
     * @param identification the relation identification number.
     */
    public void setId(final int identification) {
        this.id = identification;
    }

    /**
     * Get the game.
     *
     * @return the game.
     */
    public com.eaw1805.data.model.Game getGame() {
        return game;
    }

    /**
     * Set the game.
     *
     * @param thisGame the game.
     */
    public void setGame(final com.eaw1805.data.model.Game thisGame) {
        this.game = thisGame;
    }

    /**
     * Get the nation that this relation belongs to.
     *
     * @return the nation owner.
     */
    public com.eaw1805.data.model.Nation getNation() {
        return nation;
    }

    /**
     * Set the nation that this relation belongs to.
     *
     * @param thisNation the nation onwer.
     */
    public void setNation(final com.eaw1805.data.model.Nation thisNation) {
        this.nation = thisNation;
    }

    /**
     * Get the target nation of this relation.
     *
     * @return the target nation of this relation.
     */
    public com.eaw1805.data.model.Nation getTarget() {
        return target;
    }

    /**
     * Set the target nation of this relation.
     *
     * @param thisNation the target nation of this relation.
     */
    public void setTarget(final com.eaw1805.data.model.Nation thisNation) {
        this.target = thisNation;
    }

    /**
     * Get the relation to the other nation.
     *
     * @return the relation to the other nation.
     */
    public int getRelation() {
        return relation;
    }

    /**
     * Set the relation to the other nation.
     *
     * @param rel the relation to the other nation.
     */
    public void setRelation(final int rel) {
        this.relation = rel;
    }

    /**
     * Get the prisoners of war.
     *
     * @return the prisoners of war.
     */
    public int getPrisoners() {
        return prisoners;
    }

    /**
     * Set the prisoners of war.
     *
     * @param value the prisoners of war.
     */
    public void setPrisoners(final int value) {
        this.prisoners = value;
    }

    /**
     * Get the turn count since the previous change.
     *
     * @return the turn count since the previous change.
     */
    public int getTurnCount() {
        return turnCount;
    }

    /**
     * Set the turn count since the previous change.
     *
     * @param value the turn count since the previous change.
     */
    public void setTurnCount(final int value) {
        this.turnCount = value;
    }

    /**
     * Get the turn count since the peace.
     *
     * @return the turn count since the peace.
     */
    public int getPeaceCount() {
        return peaceCount;
    }

    /**
     * Set the turn count since the peace.
     *
     * @param value the turn count since the peace.
     */
    public void setPeaceCount(final int value) {
        this.peaceCount = value;
    }

    /**
     * Get the turn count since the surrender.
     *
     * @return the turn count since the surrender.
     */
    public int getSurrenderCount() {
        return surrenderCount;
    }

    /**
     * Set the turn count since the surrender.
     *
     * @param value the turn count since the surrender.
     */
    public void setSurrenderCount(final int value) {
        this.surrenderCount = value;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
