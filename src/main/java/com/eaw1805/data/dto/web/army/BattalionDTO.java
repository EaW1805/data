package com.eaw1805.data.dto.web.army;

import java.io.Serializable;

/**
 * Represents a battalion.
 */
public class BattalionDTO
        implements com.google.gwt.user.client.rpc.IsSerializable, Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD

    /**
     * The unique identifier of the battalion.
     */
    private int id; // NOPMD

    /**
     * The unique identifier of the brigade in whic it belongs.
     */
    private int brigadeId;

    /**
     * The order of the battalion in the brigade.
     */
    private int order;

    /**
     * The type of the troops.
     */
    private int typeId;

    /**
     * The type of the troops.
     */
    private ArmyTypeDTO empireArmyType;

    /**
     * The original army type this battalion is.
     */
    private ArmyTypeDTO originalArmyType;

    /**
     * The experience level of the battalion.
     */
    private int experience;

    /**
     * The original experience of this battalion as stored in the db.
     */
    private int originalExperience;

    /**
     * The headcount of the battalion.
     */
    private int headcount;

    /**
     * The original headcount of the battalion.
     */
    private int originalHeadcount;

    /**
     * Indicates if it has been merged and with which
     * battalion if it is different than 0.
     */
    private int mergedWith = 0;

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
     * indicates if the battalion is not properly supplied.
     */
    private boolean notSupplied;

    /**
     * The starting brigade id.
     */
    private int startBrigadeId;

    /**
     * The starting slot.
     */
    private int startOrder;

    /**
     * used to determine if a battalion has lost a battle during the turn.
     */
    private boolean hasLost;

    /**
     * Default constructor.
     */
    public BattalionDTO() {
        // empty constructor
    }

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
     * Get the unique identifier of the battalion's brigade.
     *
     * @return the unique identifier of the battalion's brigade.
     */
    public int getBrigadeId() {
        return brigadeId;
    }

    /**
     * Set the unique identifier of the battalion's brigade.
     *
     * @param brigadeId the unique identifier of the battalion's brigade.
     */
    public void setBrigadeId(final int brigadeId) {
        this.brigadeId = brigadeId;
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
    public int getTypeId() {
        return typeId;
    }

    /**
     * Set the thisType of the troops.
     *
     * @param thisType the thisType of the troops.
     */
    public void setTypeId(final int thisType) {
        this.typeId = thisType;
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
     * Get the original headcount of the battalion.
     *
     * @return The original headcount as it is saved in the database.
     */
    public int getOriginalHeadcount() {
        return originalHeadcount;
    }

    /**
     * Set the original headcount of the battalion.
     *
     * @param originalHeadcount The value ot set.
     */
    public void setOriginalHeadcount(final int originalHeadcount) {
        this.originalHeadcount = originalHeadcount;
    }

    /**
     * Get the type of the troops.
     *
     * @return the type of the troops.
     */
    public ArmyTypeDTO getEmpireArmyType() {
        return empireArmyType;
    }

    /**
     * Set the thisType of the troops.
     *
     * @param thisType the thisType of the troops.
     */
    public void setEmpireArmyType(final ArmyTypeDTO thisType) {
        this.empireArmyType = thisType;
    }

    /**
     * Get the original type of the troops.
     *
     * @return the type of the troops.
     */
    public ArmyTypeDTO getOriginalArmyType() {
        return originalArmyType;
    }

    /**
     * Set the army type of the troops.
     *
     * @param value The value to set.
     */
    public void setOriginalArmyType(final ArmyTypeDTO value) {
        this.originalArmyType = value;
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
    public boolean isExpIncByComm() {
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
     * @param mergedWith the mergedWith to set
     */
    public void setMergedWith(final int mergedWith) {
        this.mergedWith = mergedWith;
    }

    /**
     * @return the mergedWith int that if it is different
     *         than zero indicates the battalion id with which it is merged
     */
    public int getMergedWith() {
        return mergedWith;
    }

    public boolean getNotSupplied() {
        return notSupplied;
    }

    public void setNotSupplied(final boolean notSupplied) {
        this.notSupplied = notSupplied;
    }

    public int getStartBrigadeId() {
        return startBrigadeId;
    }

    public void setStartBrigadeId(final int getStartBrigadeId) {
        this.startBrigadeId = getStartBrigadeId;
    }

    public int getStartOrder() {
        return startOrder;
    }

    public void setStartOrder(final int startOrder) {
        this.startOrder = startOrder;
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
     * Get the original experience of this battalion.
     *
     * @return The original experience.
     */
    public int getOriginalExperience() {
        return originalExperience;
    }

    /**
     * Set the original experience of this battalion.
     *
     * @param value the value to set.
     */
    public void setOriginalExperience(final int value) {
        this.originalExperience = value;
    }
}
