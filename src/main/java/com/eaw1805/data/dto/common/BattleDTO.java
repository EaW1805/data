package com.eaw1805.data.dto.common;

/**
 * Stores information for Battles.
 */
public class BattleDTO extends PositionDTO {

    private int battleId;

    private int battleType;

    private int side;

    private int winner;

    private boolean show;


    public int getBattleId() {
        return battleId;
    }

    public void setBattleId(final int value) {
        this.battleId = value;
    }

    public int getSide() {
        return side;
    }

    public void setSide(final int value) {
        this.side = value;
    }

    public int getWinner() {
        return winner;
    }

    public void setWinner(final int value) {
        this.winner = value;
    }

    public int getBattleType() {
        return battleType;
    }

    public void setBattleType(final int value) {
        this.battleType = value;
    }

    public boolean isShow() {
        return show;
    }

    public void setShow(final boolean value) {
        this.show = value;
    }
}
