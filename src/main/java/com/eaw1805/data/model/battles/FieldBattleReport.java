package com.eaw1805.data.model.battles;

import com.eaw1805.data.model.Nation;
import com.eaw1805.data.model.army.Commander;
import com.eaw1805.data.model.map.Position;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Stores information about a field battle.
 */
public class FieldBattleReport implements Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD

    public static enum Stage {
        NOT_INITIALIZED, INITIALIZED, HALF_ROUNDS, ALL_ROUNDS;
    }

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
     * The winner of the battle (-1: none, 0: side 1, 1: side 2).
     */
    private int winner;

    /**
     * The detailed statistics of the battle.
     */
    private byte[] stats;

    /**
     * The stage of the field battle. Is one of {@link Stage}.
     */
    private String stage;

    /**
     * The round of the battle. On initialization it is -1.
     */
    private int round;

    /**
     * Indicator if this battle is a scenario battle.
     *
     * That means is not a processable battle,
     * but the template for creating copy battles.
     */
    private boolean scenarioBattle;

    /**
     * Comma-separated ids of the brigades that moved in the previous halfround.
     */
    private String brigadesThatMovedInPreviousHalfround;

    /**
     * The initial morale contributions of each brigade. It is initially
     * calculated at first set of half rounds, and is reused on second set of
     * half rounds.
     */
    private byte[] initialMoraleContributions;

    private String status;

    /**
     *
     */
    private Date nextProcessDate;

    /**
     * The user id of the creator of the fieldbattle.
     */
    private int ownerId;

    /**
     * A name for the fieldbattle.
     */
    private String name;

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
     * Get the stage of the field battle. Is one of {@link Stage}.
     *
     * @return the stage
     */
    public String getStage() {
        return stage;
    }

    /**
     * Set the stage of the field battle. Is one of {@link Stage}.
     *
     * @param stage the stage
     */
    public void setStage(String stage) {
        this.stage = stage;
    }

    /**
     * Get the stage of the field battle as {@link Stage}. This is a convenience getter.
     *
     * @return the stage
     */
    public Stage getStageEnum() {
        return Stage.valueOf(stage);
    }

    /**
     * Set the stage of the field battle. Is one of {@link Stage}.
     *
     * @param stage the stage to set
     */
    public void setStageEnum(Stage stage) {
        this.stage = stage.toString();
    }

    /**
     * The field battle round.
     *
     * @return the round
     */
    public int getRound() {
        return round;
    }

    /**
     * Set the field battle round.
     *
     * @param round the round
     */
    public void setRound(int round) {
        this.round = round;
    }

    /**
     * Get the comma-separated ids of the brigades that moved in the previous halfround.
     *
     * @return the brigade ids
     */
    public String getBrigadesThatMovedInPreviousHalfround() {
        return brigadesThatMovedInPreviousHalfround;
    }

    /**
     * Set the comma-separated ids of the brigades that moved in the previous halfround.
     *
     * @param brigadesThatMovedInPreviousHalfround
     *         the comma-separated ids
     */
    public void setBrigadesThatMovedInPreviousHalfround(
            String brigadesThatMovedInPreviousHalfround) {
        this.brigadesThatMovedInPreviousHalfround = brigadesThatMovedInPreviousHalfround;
    }

    /**
     * Returns the initial morale contributions of each brigade. It is initially
     * calculated at first set of half rounds, and is reused on second set of
     * half rounds.
     */
    public byte[] getInitialMoraleContributions() {
        return initialMoraleContributions;
    }

    /**
     * Sets the initial morale contributions of each brigade. It is initially
     * calculated at first set of half rounds, and is reused on second set of
     * half rounds.
     */
    public void setInitialMoraleContributions(byte[] initialMoraleContributions) {
        this.initialMoraleContributions = initialMoraleContributions;
    }

    public boolean isRunning() {

        return status != null && "running".equals(status);

    }

    public boolean isGameEnded() {
        return getWinner() != -1 || getRound() >= 23;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Get the  creators id.
     *
     * @return The creators id.
     */
    public int getOwnerId() {
        return ownerId;
    }

    /**
     * Set the creators id.
     *
     * @param value The creators id.
     */
    public void setOwnerId(final int value) {
        this.ownerId = value;
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        FieldBattleReport that = (FieldBattleReport) object;
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

    /**
     * Get the next processing date.
     *
     * @return The next processing date.
     */
    public Date getNextProcessDate() {
        return nextProcessDate;
    }

    /**
     * Set the next processing date.
     *
     * @param value The value to set.
     */
    public void setNextProcessDate(final Date value) {
        this.nextProcessDate = value;
    }

    /**
     * Get if this battle is a scenario battle.
     *
     * @return True if it is a scenario battle.
     */
    public boolean isScenarioBattle() {
        return scenarioBattle;
    }

    /**
     * Set if this battle is a scenario battle.
     *
     * @param value The value to set.
     */
    public void setScenarioBattle(final boolean value) {
        this.scenarioBattle = value;
    }

    /**
     * Get the name of the fieldbattle.
     *
     * @return The name of the fieldbattle.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the fieldbattle.
     *
     * @param value The value to set.
     */
    public void setName(final String value) {
        this.name = value;
    }
}
