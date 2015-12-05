package com.eaw1805.data.dto.web;

import java.io.Serializable;

/**
 * Models political relation between nations.
 */
public class RelationDTO
        implements com.google.gwt.user.client.rpc.IsSerializable, Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD

    /**
     * The nation owner.
     */
    private int nationId;

    /**
     * Nation target.
     */
    private int targetNationId;

    /**
     * relation to other nations.
     */
    private int relation;

    /**
     * action done when at war with the nation
     */
    private int warAction = 0;

    private int nextRoundRelation, theirRelation;

    /**
     * Turn count since the peace.
     */
    private int peaceCount;

    /**
     * Turn count since the surrender.
     */
    private int surrenderCount;

    /**
     * If we are called to support an allie against this nation.
     */
    private boolean calledToAllies;

    /**
     * Turn movements visible to the ally.
     */
    private boolean visible;

    /**
     * Alliance status is fixed throughout the game.
     */
    private boolean fixed;

    /**
     * Get the nation this relation refers to.
     *
     * @return the nation this relation refers to.
     */
    public int getNationId() {
        return nationId;
    }

    /**
     * Set the nation this relation refers to.
     *
     * @param param the nation this relation refers to.
     */
    public void setNationId(final int param) {
        this.nationId = param;
    }

    /**
     * Get the war action identification number.
     *
     * @return the war action identification number.
     */
    public int getWarAction() {
        return warAction;
    }

    /**
     * Set the war action identification number.
     *
     * @param warAction the war action.
     */
    public void setWarAction(final int warAction) {
        this.warAction = warAction;
    }

    /**
     * Get the target nation of this relation.
     *
     * @return the target nation of this relation.
     */
    public int getTargetNationId() {
        return targetNationId;
    }

    /**
     * Set the target nation of this relation.
     *
     * @param thisNation the target nation of this relation.
     */
    public void setTargetNationId(final int thisNation) {
        targetNationId = thisNation;
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
        this.nextRoundRelation = rel;
    }

    public int getNextRoundRelation() {
        return nextRoundRelation;
    }

    public void setNextRoundRelation(final int nextRoundRelation) {
        this.nextRoundRelation = nextRoundRelation;
    }

    /**
     * @return the theirRelation
     */
    public int getTheirRelation() {
        return theirRelation;
    }

    /**
     * @param theirRelation the theirRelation to set
     */
    public void setTheirRelation(final int theirRelation) {
        this.theirRelation = theirRelation;
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

    /**
     * Get if we are called to support an allie against this nation.
     *
     * @return true, if we are called to support an allie against this nation.
     */
    public boolean getCalledToAllies() {
        return calledToAllies;
    }

    /**
     * Set if we are called to support an allie against this nation.
     *
     * @param value true if we are called to support an allie against this nation.
     */
    public void setCalledToAllies(final boolean value) {
        this.calledToAllies = value;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    /**
     * Get if Alliance status is fixed throughout the game.
     *
     * @return true, if Alliance status is fixed throughout the game.
     */
    public boolean getFixed() {
        return fixed;
    }

    /**
     * Set if the Alliance status is fixed throughout the game.
     *
     * @param value - true, if the Alliance status is fixed throughout the game.
     */
    public void setFixed(final boolean value) {
        this.fixed = value;
    }

}
