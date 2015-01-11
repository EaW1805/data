package com.eaw1805.data.model.battles;

import com.eaw1805.data.model.Nation;
import com.eaw1805.data.model.map.Position;

import java.io.Serializable;
import java.util.Set;

/**
 * Stores information about a naval battle.
 */
public class NavalBattleReport implements Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD

    /**
     * The identity of the battle.
     */
    private int battleId;

    /**
     * Brigade's relative coordinates.
     */
    private Position position;

    /**
     * The turn of the battle.
     */
    private int turn;

    /**
     * The weather of the battle.
     */
    private int weather;

    /**
     * The nations of the 1st side.
     */
    private Set<Nation> side1;

    /**
     * The nations of the 2nd side.
     */
    private Set<Nation> side2;

    /**
     * The winner of the battle (0: none, 1: side 1, 2: side 2).
     */
    private int winner;

    /**
     * The attacking side B are pirates.
     */
    private boolean piracy;

    /**
     * The attacking side B are patrollers.
     */
    private boolean patrol;

    /**
     * The detailed statistics of the battle.
     */
    private byte[] stats;

    /**
     * Get the identity of the battle.
     *
     * @return the identity of the battle.
     */
    public int getBattleId() {
        return battleId;
    }

    /**
     * Set the identity of the battle.
     *
     * @param value the identity of the battle.
     */
    public void setBattleId(final int value) {
        this.battleId = value;
    }

    /**
     * Get the position of the battle.
     *
     * @return the position of the battle.
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Set the position of the battle.
     *
     * @param value the position of the battle.
     */
    public void setPosition(final Position value) {
        this.position = value;
    }

    /**
     * Get the turn of the battle.
     *
     * @return the turn of the battle.
     */
    public int getTurn() {
        return turn;
    }

    /**
     * Set the turn of the battle.
     *
     * @param value the turn of the battle.
     */
    public void setTurn(final int value) {
        this.turn = value;
    }

    /**
     * Get the weather of the battle.
     *
     * @return the weather of the battle.
     */
    public int getWeather() {
        return weather;
    }

    /**
     * Set the weather of the battle.
     *
     * @param value the weather of the battle.
     */
    public void setWeather(final int value) {
        this.weather = value;
    }

    /**
     * Get the nations of the 1st side.
     *
     * @return the nations of the 1st side.
     */
    public Set<Nation> getSide1() {
        return side1;
    }

    /**
     * Set the nations of the 1st side.
     *
     * @param value the nations of the 1st side.
     */
    public void setSide1(final Set<Nation> value) {
        this.side1 = value;
    }

    /**
     * Get the nations of the 2nd side.
     *
     * @return the nations of the 2nd side.
     */
    public Set<Nation> getSide2() {
        return side2;
    }

    /**
     * Set the nations of the 2nd side.
     *
     * @param value the nations of the 2nd side.
     */
    public void setSide2(final Set<Nation> value) {
        this.side2 = value;
    }

    /**
     * Get the winner of the battle.
     *
     * @return the winner of the battle.
     */
    public int getWinner() {
        return winner;
    }

    /**
     * Set the winner of the battle.
     *
     * @param value the winner of the battle.
     */
    public void setWinner(final int value) {
        this.winner = value;
    }

    /**
     * Get the statistics of the battle.
     *
     * @return the statistics of the battle.
     */
    public byte[] getStats() {
        return stats;
    }

    /**
     * Set the statistics of the battle.
     *
     * @param value the statistics of the battle.
     */
    public void setStats(final byte[] value) {
        this.stats = value;
    }

    /**
     * Get if the attacking side B are pirates.
     *
     * @return true if the attacking side B are pirates.
     */
    public boolean getPiracy() {
        return piracy;
    }

    /**
     * Set if the attacking side B are pirates.
     *
     * @param value if the attacking side B are pirates.
     */
    public void setPiracy(final boolean value) {
        this.piracy = value;
    }

    /**
     * Get if the battle is a result of a patrol.
     *
     * @return if the battle is a result of a patrol.
     */
    public boolean getPatrol() {
        return patrol;
    }

    /**
     * Set if the battle is a result of a patrol.
     *
     * @param value if the battle is a result of a patrol.
     */
    public void setPatrol(final boolean value) {
        this.patrol = value;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NavalBattleReport that = (NavalBattleReport) o;
        //if at least one of them is saved into the database...
        if (battleId != 0 ||  that.battleId !=0) {
            return battleId == that.battleId;
        } else {
            //else just do the defaults...
            return super.equals(o);
        }
    }

    @Override
    public int hashCode() {
        return battleId;
    }
}
