package com.eaw1805.data.model;

import java.io.Serializable;

/**
 * Represent a User-Game assignment.
 */
public class UserGame implements Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD

    /**
     * Id used by hibernate.
     */
    private int id;

    /**
     * The user who plays.
     */
    private int userId;

    /**
     * The game the user plays in.
     */
    private Game game;

    /**
     * The nation the user chosen for this game.
     */
    private Nation nation;

    /**
     * The turn of the game the user start playing.
     */
    private int turnPickUp;

    /**
     * The turn of the game the user dropped the game.
     */
    private int turnDrop;

    /**
     * If user is alive.
     */
    private boolean alive;

    /**
     * If user is active player.
     */
    private boolean active;

    /**
     * If user won the game.
     */
    private boolean hasWon;

    /**
     * The cost for playing in this game with this nation.
     */
    private int cost;

    /**
     * If user loads the client for first time in this turn.
     */
    private boolean turnFirstLoad;

    /**
     * If this is the current user game.
     */
    private boolean current;

    /**
     * If this position has a special offer.
     */
    private int offer;

    /**
     * Indicator if the user has accepted this position.
     */
    private boolean accepted;

    /**
     * Indicator if the result of the game has been viewed by the player.
     */
    private boolean resultViewed;

    /**
     * Get the object id.
     *
     * @return The object id.
     */
    public int getId() {
        return id;
    }

    /**
     * Set the object id.
     *
     * @param id The id to set.
     */
    public void setId(final int id) {
        this.id = id;
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
     * @param game The value to set.
     */
    public void setGame(final Game game) {
        this.game = game;
    }

    /**
     * Get the nation.
     *
     * @return The nation.
     */
    public Nation getNation() {
        return nation;
    }

    /**
     * Set the nation.
     *
     * @param nation The nation to set.
     */
    public void setNation(final Nation nation) {
        this.nation = nation;
    }

    /**
     * Get the user.
     *
     * @return the user.
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Set the user.
     *
     * @param value The user to set.
     */
    public void setUserId(final int value) {
        this.userId = value;
    }

    /**
     * Get the turn the user start playing.
     *
     * @return The turn the user start playing.
     */
    public int getTurnPickUp() {
        return turnPickUp;
    }

    /**
     * Set the turn the user start playing.
     *
     * @param turnPickUp The value to set.
     */
    public void setTurnPickUp(final int turnPickUp) {
        this.turnPickUp = turnPickUp;
    }

    /**
     * Get the turn the user drop the game.
     *
     * @return The turn the user drop the game.
     */
    public int getTurnDrop() {
        return turnDrop;
    }

    /**
     * Set the turn the user drop tha game.
     *
     * @param turnDrop The value to set.
     */
    public void setTurnDrop(final int turnDrop) {
        this.turnDrop = turnDrop;
    }

    /**
     * Get if player is still alive in this game.
     *
     * @return True if empire is alive.
     */
    public boolean isAlive() {
        return alive;
    }

    /**
     * Set if player is still alive in this game.
     *
     * @param alive The value to set.
     */
    public void setAlive(final boolean alive) {
        this.alive = alive;
    }

    /**
     * Get if user is active player.
     *
     * @return True if user is active.
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Set if user is active player.
     *
     * @param active The value to set.
     */
    public void setActive(final boolean active) {
        this.active = active;
    }

    /**
     * Get if user won the game.
     *
     * @return True if user won the game.
     */
    public boolean isHasWon() {
        return hasWon;
    }

    /**
     * Set if user won the game.
     *
     * @param hasWon The value to set.
     */
    public void setHasWon(final boolean hasWon) {
        this.hasWon = hasWon;
    }

    /**
     * Get the cost for this game and nation.
     *
     * @return The cost.
     */
    public int getCost() {
        return cost;
    }

    /**
     * Set the cost of this game and nation.
     *
     * @param cost The value to set.
     */
    public void setCost(final int cost) {
        this.cost = cost;
    }

    /**
     * Get if user loads the client for first time in the current turn.
     *
     * @return True if user loads the client for first time in the current turn.
     */
    public boolean isTurnFirstLoad() {
        return turnFirstLoad;
    }

    /**
     * Set if user loads the client for first time in the current turn.
     *
     * @param turnFirstLoad The value to set.
     */
    public void setTurnFirstLoad(final boolean turnFirstLoad) {
        this.turnFirstLoad = turnFirstLoad;
    }


    /**
     * Get if this is the current user game.
     *
     * @return True if user loads the client for first time in the current turn.
     */
    public boolean isCurrent() {
        return current;
    }

    /**
     * Set if this game is the current user game.
     *
     * @param value The value to set.
     */
    public void setCurrent(final boolean value) {
        this.current = value;
    }

    /**
     * Get If this position has a special offer.
     *
     * @return the special offer identifier.
     */
    public int getOffer() {
        return offer;
    }

    /**
     * Set If this position has a special offer.
     *
     * @param value the identifier of the special offer.
     */
    public void setOffer(final int value) {
        offer = value;
    }

    /**
     * Get if user has accepted this position.
     *
     * @return True if accepted.
     */
    public boolean isAccepted() {
        return accepted;
    }

    /**
     * Set if user has accepted this position.
     *
     * @param value The value to set.
     */
    public void setAccepted(final boolean value) {
        this.accepted = value;
    }

    /**
     * Get if the result has been viewed.
     *
     * @return True if the result has been viewed.
     */
    public boolean isResultViewed() {
        return resultViewed;
    }

    /**
     * Set if the result has been viewed.
     *
     * @param value The value to set
     */
    public void setResultViewed(final boolean value) {
        this.resultViewed = value;
    }
}
