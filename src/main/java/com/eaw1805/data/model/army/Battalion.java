package com.eaw1805.data.model.army;

import com.eaw1805.data.model.map.CarrierInfo;

import java.io.Serializable;

/**
 * Represents a battalion.
 */
public class Battalion implements Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD

    /**
     * The unique identifier of the battalion.
     */
    private int id; // NOPMD

    /**
     * The order of the battalion in the brigade.
     */
    private int order;

    /**
     * The type of the troops.
     */
    private com.eaw1805.data.model.army.ArmyType type;

    /**
     * The experience level of the battalion.
     */
    private int experience;

    /**
     * The headcount of the battalion.
     */
    private int headcount;

    /**
     * The brigade that this battalion belongs to.
     */
    private Brigade brigade;

    /**
     * used temporarily during battles. this field does not persist.
     * Used in the battle to check if the battalion has passed the morale check.
     */
    private boolean fleeing;

    /**
     * used temporarily during battles. this field does not persist.
     */
    private boolean attackedByCav;

    /**
     * used temporarily during battles. this field does not persist.
     * Used in the battle to check if the experience of this unit
     * is increased by the commander's skill.
     */
    private boolean expIncByComm;

    /**
     * used temporarily during battles. this field does not persist.
     * Used in the battle to check if the particular unit has participated
     * in a round of the battle.
     */
    private boolean participated;

    /**
     * used temporarily during battles. this field does not persist.
     * Used in the battle to check if the battalion was unloaded for the battle.
     */
    private boolean unloaded;

    /**
     * used to determine if a battalion has moved during the turn.
     */
    private boolean hasMoved;

    /**
     * used to determine if a battalion will engage to battle due to its movement.
     */
    private boolean hasEngagedBattle;

    /**
     * used to determine if a battalion has lost a battle during the turn.
     */
    private boolean hasLost;

    /**
     * used to determine if a battalion is not properly supplied.
     */
    private boolean notSupplied;

    /**
     * The unit that is transferring the battalion.
     */
    private CarrierInfo carrierInfo;

    /**
     * Get the unique identifier of the battalion.
     *
     * @return the unique identifier of the battalion.
     */
    public int getId() {
        return id;
    }

    /**
     * Set the unique identifier of the battalion.
     *
     * @param identity the unique identifier of the battalion.
     */
    public void setId(final int identity) {
        this.id = identity;
    }

    /**
     * The order of the battalion in the brigade.
     *
     * @return the order of the battalion in the brigade.
     */
    public int getOrder() {
        return order;
    }

    /**
     * Set the order of the battalion in the brigade.
     *
     * @param value The order of the battalion in the brigade.
     */
    public void setOrder(final int value) {
        this.order = value;
    }

    /**
     * Get the type of the troops.
     *
     * @return the type of the troops.
     */
    public com.eaw1805.data.model.army.ArmyType getType() {
        return type;
    }

    /**
     * Set the thisType of the troops.
     *
     * @param thisType the thisType of the troops.
     */
    public void setType(final com.eaw1805.data.model.army.ArmyType thisType) {
        this.type = thisType;
    }

    /**
     * Get experience level of the battalion.
     *
     * @return the experience level of the battalion.
     */
    public int getExperience() {
        return experience;
    }

    /**
     * Set the thisExperience level of the battalion.
     *
     * @param thisExperience the thisExperience level of the battalion.
     */
    public void setExperience(final int thisExperience) {
        this.experience = thisExperience;
    }

    /**
     * Get the headcount of the battalion.
     *
     * @return the headcount of the battalion.
     */
    public int getHeadcount() {
        return headcount;
    }

    /**
     * Set the thisHeadcount of the battalion.
     *
     * @param thisHeadcount the thisHeadcount of the battalion.
     */
    public void setHeadcount(final int thisHeadcount) {
        this.headcount = thisHeadcount;
    }

    /**
     * Get the brigade this battalion belongs to.
     *
     * @return the brigade this battalion belongs to.
     */
    public Brigade getBrigade() {
        return brigade;
    }

    /**
     * Set the brigade this battalion belongs to.
     *
     * @param value the brigade this battalion belongs to.
     */
    public void setBrigade(final Brigade value) {
        this.brigade = value;
    }

    /**
     * Check if the unit is fleeing.
     *
     * @return true if the unit is fleeing.
     */
    public boolean isFleeing() {
        return fleeing;
    }

    /**
     * Set if the unit is fleeing.
     *
     * @param value true if the unit is fleeing.
     */
    public void setFleeing(final boolean value) {
        fleeing = value;
    }

    /**
     * Check if the unit is being attacked by cavalry.
     *
     * @return true if the unit is being attacked by cavalry.
     */
    public boolean isAttackedByCav() {
        return attackedByCav;
    }

    /**
     * Set if the unit is being attacked by cavalry.
     *
     * @param value true if the unit is being attacked by cavalry.
     */
    public void setAttackedByCav(final boolean value) {
        this.attackedByCav = value;
    }

    /**
     * Check if the unit's experience is increased by the commander.
     *
     * @return true if the unit's experience is increased by the commander.
     */
    public boolean getExpIncByComm() {
        return expIncByComm;
    }

    /**
     * Set if the unit's experience is increased by the commander.
     *
     * @param value true if the unit's experience is increased by the commander.
     */
    public void setExpIncByComm(final boolean value) {
        this.expIncByComm = value;
    }

    /**
     * Get if the particular unit has participated in a round of the battle.
     *
     * @return true, if the particular unit has participated in a round of the battle.
     */
    public boolean isParticipated() {
        return participated;
    }

    /**
     * Set if the particular unit has participated in a round of the battle.
     *
     * @param value true, if the particular unit has participated in a round of the battle.
     */
    public void setParticipated(final boolean value) {
        participated = value;
    }

    /**
     * Used in the battle to check if the battalion was unloaded for the battle.
     * @return true if the battalion was unloaded for the battle.
     */
    public boolean getUnloaded() {
        return unloaded;
    }

    /**
     Used in the battle to check if the battalion was unloaded for the battle.
     * @param value true if the battalion was unloaded for the battle.
     */
    public void setUnloaded(final boolean value) {
        this.unloaded = value;
    }

    /**
     * Get if the battalion has moved during the turn.
     *
     * @return true, if the battalion has moved during the turn.
     */
    public boolean getHasMoved() {
        return hasMoved;
    }

    /**
     * Set if the battalion has moved during the turn.
     *
     * @param value true, if the battalion has moved during the turn.
     */
    public void setHasMoved(final boolean value) {
        this.hasMoved = value;
    }

    /**
     * Get if a battalion engaged to battle due to its movement.
     *
     * @return true, if a battalion engaged to battle due to its movement.
     */
    public boolean getHasEngagedBattle() {
        return hasEngagedBattle;
    }

    /**
     * Set if a battalion engaged to battle due to its movement.
     *
     * @param value true, if a battalion engaged to battle due to its movement.
     */
    public void setHasEngagedBattle(final boolean value) {
        this.hasEngagedBattle = value;
    }

    /**
     * Get if the battalion is not properly supplied.
     *
     * @return true, if the battalion is not properly supplied.
     */
    public boolean getNotSupplied() {
        return notSupplied;
    }

    /**
     * Get if the battalion has lost a battle during the turn.
     *
     * @return if the battalion has lost a battle during the turn.
     */
    public boolean getHasLost() {
        return hasLost;
    }

    /**
     * Set if the battalion has lost a battle during the turn.
     *
     * @param value if the battalion has lost a battle during the turn.
     */
    public void setHasLost(final boolean value) {
        this.hasLost = value;
    }

    /**
     * Set if the battalion is not properly supplied.
     *
     * @param value true, if the battalion is not properly supplied.
     */
    public void setNotSupplied(final boolean value) {
        this.notSupplied = value;
    }

    /**
     * Get the unit that is transferring the spy.
     *
     * @return the unit that is transferring the spy.
     */
    public CarrierInfo getCarrierInfo() {
        return carrierInfo;
    }

    /**
     * Set the unit that is transferring the spy.
     *
     * @param value the unit that is transferring the spy.
     */
    public void setCarrierInfo(final CarrierInfo value) {
        this.carrierInfo = value;
    }

    @Override
    public Object clone() {
        final Battalion bat = new Battalion();
        bat.setId(getId());
        bat.setOrder(getOrder());
        bat.setType(getType());
        bat.setExperience(getExperience());
        bat.setHeadcount(getHeadcount());
        bat.setBrigade(getBrigade());
        bat.setFleeing(isFleeing());
        bat.setAttackedByCav(isAttackedByCav());
        bat.setExpIncByComm(getExpIncByComm());
        bat.setParticipated(isParticipated());
        bat.setHasMoved(getHasMoved());
        bat.setHasLost(getHasLost());
        bat.setNotSupplied(getNotSupplied());
        bat.setHasEngagedBattle(getHasEngagedBattle());

        final CarrierInfo thisCarrierInfo = new CarrierInfo();
        thisCarrierInfo.setCarrierType(getCarrierInfo().getCarrierType());
        thisCarrierInfo.setCarrierId(getCarrierInfo().getCarrierId());
        bat.setCarrierInfo(thisCarrierInfo);

        return bat;
    }
}
