package com.eaw1805.data.model.battles;

import com.eaw1805.data.model.Nation;
import com.eaw1805.data.model.army.Commander;
import com.eaw1805.data.model.map.Position;

import java.io.Serializable;
import java.util.Set;

/**
 * Stores information about a tactical battle.
 */
public class TacticalBattleReport implements Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD

    /**
     * The identity of the battle.
     */
    private int battleId;

    /**
     * Battle's relative coordinates.
     */
    private Position position;

    /**
     * The turn of the battle.
     */
    private int turn;

    /**
     * The nations of the 1st side.
     */
    private Set<Nation> side1;

    /**
     * The nations of the 2nd side.
     */
    private Set<Nation> side2;

    /**
     * The commander of the 1st side.
     */
    private Commander comm1;

    /**
     * The commander of the 2nd side.
     */
    private Commander comm2;

    /**
     * The winner of the battle (0: none, 1: side 1, 2: side 2).
     */
    private int winner;

    /**
     * The level of fortification of the sector.
     */
    private String fort;

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
     * Get the commander of the 1st side.
     *
     * @return the commander of the 1st side.
     */
    public Commander getComm1() {
        return comm1;
    }

    /**
     * Set the commander of the 1st side.
     *
     * @param value the commander of the 1st side.
     */
    public void setComm1(final Commander value) {
        this.comm1 = value;
    }

    /**
     * Get the commander of the 2nd side.
     *
     * @return the commander of the 2nd side.
     */
    public Commander getComm2() {
        return comm2;
    }

    /**
     * Set the commander of the 2nd side.
     *
     * @param value the commander of the 2nd side.
     */
    public void setComm2(final Commander value) {
        this.comm2 = value;
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
     * Get the level of fortification of the sector.
     *
     * @return the level of fortification of the sector.
     */
    public String getFort() {
        return fort;
    }

    /**
     * Set the level of fortification of the sector.
     *
     * @param value the level of fortification of the sector.
     */
    public void setFort(final String value) {
        this.fort = value;
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

    @Override
    public boolean equals(final Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        TacticalBattleReport that = (TacticalBattleReport) object;
        if (battleId != 0 || that.battleId != 0) {
            return battleId == that.battleId;
        } else {
            return super.equals(object);
        }
    }

    @Override
    public int hashCode() {
        return battleId;
    }
}
