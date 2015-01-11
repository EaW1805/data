package com.eaw1805.data.dto.web;

import com.eaw1805.data.model.User;

import java.io.Serializable;

/**
 * Information related to a player profile.
 */
public class HofDTO implements Serializable {

    private static final long serialVersionUID = -3757271241442308962L;

    private final int undefined = Integer.MAX_VALUE;
    
    /**
     * The User.
     */
    private final User user;

    /**
     * The Username of the current User. Used for sorting.
     */
    private final String username;

    /**
     * User's VPs.
     */
    private int vps = undefined;

    /**
     * User's VPs world position.
     */
    private int vpsPosition = undefined;

    /**
     * User's achievements.
     */
    private int achievements = undefined;

    /**
     * User's achievements world position.
     */
    private int achievementsPosition = undefined;

    /**
     * Number of battles tactical user won.
     */
    private int battlesTacticalWon = undefined;

    /**
     * Battles tactical user won world position.
     */
    private int battlesTacticalWonPosition = undefined;

    /**
     * Number of battles naval user won.
     */
    private int battlesNavalWon = undefined;

    /**
     * Battles naval user won world position.
     */
    private int battlesNavalWonPosition = undefined;

    /**
     * Number of battles fields user won.
     */
    private int battlesFieldWon = undefined;

    /**
     * Battles fields user won world position.
     */
    private int battlesFieldWonPosition = undefined;

    /**
     * Number of enemies killed.
     */
    private int enemyKilled = undefined;

    /**
     * Enemies killed world position.
     */
    private int enemyKilledPosition = undefined;

    /**
     * Number of games played.
     */
    private int playedGames;

    /**
     * Default constructor.
     *
     * @param value the User.
     */
    public HofDTO(final User value) {
        this.user = value;
        username = value.getUsername();
    }

    /**
     * Returns the current User.
     *
     * @return the User.
     */
    public User getUser() {
        return user;
    }

    /**
     * Return the VPs.
     *
     * @return an int with the VPs
     */
    public int getVps() {
        return vps;
    }

    /**
     * Set the VPs.
     *
     * @param value an int with the VPs
     */
    public void setVps(final int value) {
        this.vps = value;
    }

    /**
     * Returns the achievements.
     *
     * @return an int with the Achievements.
     */
    public int getAchievements() {
        return achievements;
    }

    /**
     * Set the achievements.
     *
     * @param value an int with achievements
     */
    public void setAchievements(final int value) {
        this.achievements = value;
    }

    /**
     * Returns the number of tactical battles won.
     *
     * @return an int with number of tactical battles won.
     */
    public int getBattlesTacticalWon() {
        return battlesTacticalWon;
    }

    /**
     * Set the number of tactical battles won.
     *
     * @param value an int with number of tactical battles won.
     */
    public void setBattlesTacticalWon(final int value) {
        this.battlesTacticalWon = value;
    }

    /**
     * Returns the number of naval battles won.
     *
     * @return an int with number of naval battles won.
     */
    public int getBattlesNavalWon() {
        return battlesNavalWon;
    }

    /**
     * Set the number of naval battles won.
     *
     * @param value an int with number of naval battles won.
     */
    public void setBattlesNavalWon(final int value) {
        this.battlesNavalWon = value;
    }

    /**
     * Returns the number of field battles won.
     *
     * @return an int with number of field battles won.
     */
    public int getBattlesFieldWon() {
        return battlesFieldWon;
    }

    /**
     * Set the number of field battles won.
     *
     * @param value an int with number of field battles won.
     */
    public void setBattlesFieldWon(final int value) {
        this.battlesFieldWon = value;
    }

    /**
     * Returns the number of killed enemies.
     *
     * @return a int with the number of killed enemies.
     */
    public int getEnemyKilled() {
        return enemyKilled;
    }

    /**
     * Set the number of killed enemies.
     *
     * @param value an int with the number of killed enemies.
     */
    public void setEnemyKilled(final int value) {
        this.enemyKilled = value;
    }

    //
    //
    //Setters / Getters for world position.
    //
    //
    public int getVpsPosition() {
        return vpsPosition;
    }

    public void setVpsPosition(final int value) {
        this.vpsPosition = value;
    }

    public int getAchievementsPosition() {
        return achievementsPosition;
    }

    public void setAchievementsPosition(final int value) {
        this.achievementsPosition = value;
    }

    public int getBattlesTacticalWonPosition() {
        return battlesTacticalWonPosition;
    }

    public void setBattlesTacticalWonPosition(final int value) {
        this.battlesTacticalWonPosition = value;
    }

    public int getBattlesNavalWonPosition() {
        return battlesNavalWonPosition;
    }

    public void setBattlesNavalWonPosition(final int value) {
        this.battlesNavalWonPosition = value;
    }

    public int getBattlesFieldWonPosition() {
        return battlesFieldWonPosition;
    }

    public void setBattlesFieldWonPosition(final int value) {
        this.battlesFieldWonPosition = value;
    }

    public int getEnemyKilledPosition() {
        return enemyKilledPosition;
    }

    public void setEnemyKilledPosition(final int value) {
        this.enemyKilledPosition = value;
    }

    public int getPlayedGames() {
        return playedGames;
    }

    public void setPlayedGames(int playedGames) {
        this.playedGames = playedGames;
    }

    public int getUndefined() {
        return undefined;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HofDTO hofDTO = (HofDTO) o;

        if (user != null ? !user.equals(hofDTO.user) : hofDTO.user != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return user != null ? user.hashCode() : 0;
    }
}
