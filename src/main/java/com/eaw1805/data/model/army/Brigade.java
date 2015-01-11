package com.eaw1805.data.model.army;

import com.eaw1805.data.model.battles.field.enumerations.ArmEnum;
import com.eaw1805.data.model.battles.field.enumerations.FormationEnum;
import com.eaw1805.data.model.battles.field.enumerations.MoraleStatusEnum;
import com.eaw1805.data.model.MapElement;
import com.eaw1805.data.model.Nation;
import com.eaw1805.data.model.battles.field.FieldBattlePosition;
import com.eaw1805.data.model.battles.field.Order;
import com.eaw1805.data.model.map.Position;

import java.io.Serializable;
import java.util.Set;

/**
 * Represents a Brigade.
 */
public class Brigade implements Serializable, MapElement {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD

    /**
     * The unique identifier of the brigade.
     */
    private int brigadeId;

    /**
     * Brigade's relative coordinates.
     */
    private Position position;

    /**
     * Brigade's coordinates in the field battle map.
     */
    private FieldBattlePosition fieldBattlePosition;

    /**
     * The name of the brigade.
     */
    private String name;

    /**
     * the available movement points.
     */
    private int mps;

    /**
     * The corp of the brigade.
     */
    private Integer corp;

    /**
     * The nation that this brigade belongs to.
     */
    private Nation nation;

    /**
     * The battalions that constitute the brigade.
     */
    private Set<Battalion> battalions;

    /**
     * The arm type of the battalion.
     */
    private String armType;

    /**
     * The formation of the brigade.
     */
    private String formation;

    /**
     * The morale status of the brigade throughout a field battle. Can be one of
     * "Routing", "Disorder", "Normal".
     */
    private String moraleStatus;

    /**
     * The basic order this brigade was given for the field battle.
     */
    private Order basicOrder;

    /**
     * The additional order this brigade was given for the field battle.
     */
    private Order additionalOrder;

    /**
     * Indicates if the brigade was constructed at the initialization of the
     * game and not by the user.
     */
    private boolean fromInit;

    /**
     * The id of the commander that is attached to this brigade. 0 if no commander is
     * attached in the brigade.
     */
    private int fieldBattleCommanderId;

    /**
     * The id of the overall commander that is attached to this brigade. 0 if no commander is
     * attached in the brigade.
     */
    private int fieldBattleOverallCommanderId;

    /**
     * Get the unique identifier of the brigade.
     *
     * @return the unique identifier of the brigade.
     */
    public int getBrigadeId() {
        return brigadeId;
    }

    /**
     * Set the unique identifier of the brigade.
     *
     * @param identity the unique identifier of the brigade.
     */
    public void setBrigadeId(final int identity) {
        this.brigadeId = identity;
    }

    /**
     * Get the relative position of the brigade.
     *
     * @return the relative position of the brigade.
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Set the relative position of the brigade.
     *
     * @param thisPosition the relative position of the brigade.
     */
    public void setPosition(final Position thisPosition) {
        this.position = thisPosition;
    }

    /**
     * Get the name of the brigade.
     *
     * @return the name of the brigade.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the thisName of the brigade.
     *
     * @param thisName the name of the brigade.
     */
    public void setName(final String thisName) {
        this.name = thisName;
    }

    /**
     * Get the available movement points.
     *
     * @return the available movement points.
     */
    public int getMps() {
        return mps;
    }

    /**
     * Set the available movement points.
     *
     * @param thisMps the available movement points.
     */
    public void setMps(final int thisMps) {
        this.mps = thisMps;
    }

    /**
     * Get the corp of the brigade.
     *
     * @return the corp of the brigade.
     */
    public Integer getCorp() {
        return corp;
    }

    /**
     * Set the corp of the brigade.
     *
     * @param thisFed the corp of the brigade.
     */
    public void setCorp(final Integer thisFed) {
        this.corp = thisFed;
    }

    /**
     * Get the nation this brigade belongs to.
     *
     * @return the nation this brigade belongs to.
     */
    public Nation getNation() {
        return nation;
    }

    /**
     * Set the nation this brigade belongs to.
     *
     * @param param The nation this brigade belongs to.
     */
    public void setNation(final Nation param) {
        this.nation = param;
    }

    /**
     * Get the list of battalions.
     *
     * @return the list of battalions.
     */
    public Set<Battalion> getBattalions() {
        return battalions;
    }

    /**
     * Set the list of battalions.
     *
     * @param thisBatt the list of battalions.
     */
    public void setBattalions(final Set<Battalion> thisBatt) {
        this.battalions = thisBatt;
    }

    /**
     * Updates the MP field of the brigade by identifying the slowest battalion.
     */
    public void updateMP() {
        int minMP = Integer.MAX_VALUE;
        for (final Battalion batt : battalions) {
            minMP = Math.min(batt.getType().getMps(), minMP);
        }
        setMps(minMP);
    }

    public String getArmType() {
        return armType;
    }

    public void setArmType(String armType) {
        this.armType = armType;
    }

    public String getFormation() {
        return formation;
    }

    public void setFormation(String formation) {
        this.formation = formation;
    }

    public FieldBattlePosition getFieldBattlePosition() {
        return fieldBattlePosition;
    }

    public void setFieldBattlePosition(FieldBattlePosition fieldBattlePosition) {
        this.fieldBattlePosition = fieldBattlePosition;
    }

    /**
     * Checks whether the brigade is routing in a field battle.
     *
     * @return true if the brigade is routing, false otherwise
     */
    public boolean isRouting() {
        return MoraleStatusEnum.ROUTING == MoraleStatusEnum
                .fromName(moraleStatus);
    }

    /**
     * Checks whether the brigade is in disorder during a field battle.
     *
     * @return true if the brigade is routing, false otherwise
     */
    public boolean isInDisorder() {
        return MoraleStatusEnum.DISORDER == MoraleStatusEnum
                .fromName(moraleStatus);
    }

    public void setMoraleStatusEnum(MoraleStatusEnum moraleStatusEnum) {
        this.moraleStatus = moraleStatusEnum.getName();
    }

    public MoraleStatusEnum getMoraleStatusEnum() {
        return MoraleStatusEnum.fromName(moraleStatus);
    }

    public ArmEnum getArmTypeEnum() {
        return ArmEnum.valueOf(armType);
    }

    public void setArmTypeEnum(ArmEnum armTypeEnum) {
        this.armType = armTypeEnum.toString();
    }

    public FormationEnum getFormationEnum() {
        try {
            return FormationEnum.valueOf(formation);
        } catch (Exception e) {
            formation = "COLUMN";
            return FormationEnum.valueOf(formation);
        }
    }

    public void setFormationEnum(FormationEnum formationEnum) {
        this.formation = formationEnum.toString();
    }

    public Order getBasicOrder() {
        return basicOrder;
    }

    public void setBasicOrder(Order basicOrder) {
        this.basicOrder = basicOrder;
    }

    public Order getAdditionalOrder() {
        return additionalOrder;
    }

    public void setAdditionalOrder(Order additionalOrder) {
        this.additionalOrder = additionalOrder;
    }

    /**
     * Get if the brigade was constructed at the initialization of the game.
     *
     * @return True if brigade was constructed by engine at turn 0.
     */
    public boolean getFromInit() {
        return fromInit;
    }

    /**
     * Set if brigade was constructed at the initialization of the game.
     *
     * @param value The value to set.
     */
    public void setFromInit(final boolean value) {
        this.fromInit = value;
    }

    public String getMoraleStatus() {
        return moraleStatus;
    }

    public void setMoraleStatus(String moraleStatus) {
        this.moraleStatus = moraleStatus;
    }

    public int getFieldBattleCommanderId() {
        return fieldBattleCommanderId;
    }

    public void setFieldBattleCommanderId(int fieldBattleCommanderId) {
        this.fieldBattleCommanderId = fieldBattleCommanderId;
    }

    public int getFieldBattleOverallCommanderId() {
        return fieldBattleOverallCommanderId;
    }

    public void setFieldBattleOverallCommanderId(int fieldBattleOverallCommanderId) {
        this.fieldBattleOverallCommanderId = fieldBattleOverallCommanderId;
    }

    @Override
    public String toString() {
        return "Brigade " + getBrigadeId() + "/N" + nation;
    }
}
