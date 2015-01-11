package com.eaw1805.data.model.battles.field;

import com.eaw1805.data.model.battles.field.enumerations.FormationEnum;
import com.eaw1805.data.model.battles.field.enumerations.DetachmentPosition;
import com.eaw1805.data.model.battles.field.enumerations.OrdersEnum;
import com.eaw1805.data.model.Nation;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Order implements Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD

    private int id;

    // basic properties
    private String orderType;
    private FieldBattlePosition checkpoint1;
    private FieldBattlePosition checkpoint2;
    private FieldBattlePosition checkpoint3;
    private boolean reachedCheckpoint1;
    private boolean reachedCheckpoint2;
    private boolean reachedCheckpoint3;
    private String formation;

    // order-specific
    private Integer maintainDistance;
    private FieldBattlePosition strategicPoint1;
    private FieldBattlePosition strategicPoint2;
    private FieldBattlePosition strategicPoint3;
    private Integer constructionCounter;
    private FieldBattlePosition defendPositionArtilleryTarget;
    private int detachmentLeaderId;
    private String detachmentPosition;

    // target filters
    private Set<Nation> targetNations = new HashSet<Nation>();
    private String targetArm;
    private String targetFormation;
    private boolean targetHighestHeadcount;
    private boolean targetClosestInRange;

    // alternative order triggers
    private int activationRound;
    private int headCountThreshold;
    private boolean lastDestinationReached;
    private boolean ownSideCapturedEnemyStrategicPoint;
    private boolean enemySideCapturedOwnStrategicPoint;
    private FieldBattlePosition customStrategicPoint1;
    private FieldBattlePosition customStrategicPoint2;
    private FieldBattlePosition customStrategicPoint3;
    private Order backup;

    public int getActivationRound() {
        return activationRound;
    }

    public void setActivationRound(int activationRound) {
        this.activationRound = activationRound;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public void setOrderTypeEnum(OrdersEnum orderType) {
        this.orderType = orderType.toString();
    }

    public OrdersEnum getOrderTypeEnum() {
        return OrdersEnum.valueOf(this.orderType);
    }

    public int getHeadCountThreshold() {
        return headCountThreshold;
    }

    public void setHeadCountThreshold(int headCountThreshold) {
        this.headCountThreshold = headCountThreshold;
    }

    public boolean isLastDestinationReached() {
        return lastDestinationReached;
    }

    public void setLastDestinationReached(boolean lastDestinationReached) {
        this.lastDestinationReached = lastDestinationReached;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FieldBattlePosition getCheckpoint1() {
        return checkpoint1;
    }

    public void setCheckpoint1(FieldBattlePosition checkpoint1) {
        this.checkpoint1 = checkpoint1;
    }

    public FieldBattlePosition getCheckpoint2() {
        return checkpoint2;
    }

    public void setCheckpoint2(FieldBattlePosition checkpoint2) {
        this.checkpoint2 = checkpoint2;
    }

    public FieldBattlePosition getCheckpoint3() {
        return checkpoint3;
    }

    public void setCheckpoint3(FieldBattlePosition checkpoint3) {
        this.checkpoint3 = checkpoint3;
    }

    public boolean isReachedCheckpoint1() {
        return reachedCheckpoint1;
    }

    public void setReachedCheckpoint1(boolean reachedCheckpoint1) {
        this.reachedCheckpoint1 = reachedCheckpoint1;
    }

    public boolean isReachedCheckpoint2() {
        return reachedCheckpoint2;
    }

    public void setReachedCheckpoint2(boolean reachedCheckpoint2) {
        this.reachedCheckpoint2 = reachedCheckpoint2;
    }

    public boolean isReachedCheckpoint3() {
        return reachedCheckpoint3;
    }

    public void setReachedCheckpoint3(boolean reachedCheckpoint3) {
        this.reachedCheckpoint3 = reachedCheckpoint3;
    }

    public Integer getMaintainDistance() {
        return maintainDistance;
    }

    public void setMaintainDistance(Integer maintainDistance) {
        this.maintainDistance = maintainDistance;
    }

    @Override
    public String toString() {
        return orderType;
    }

    public FieldBattlePosition getStrategicPoint1() {
        return strategicPoint1;
    }

    public void setStrategicPoint1(FieldBattlePosition strategicPoint1) {
        this.strategicPoint1 = strategicPoint1;
    }

    public FieldBattlePosition getStrategicPoint2() {
        return strategicPoint2;
    }

    public void setStrategicPoint2(FieldBattlePosition strategicPoint2) {
        this.strategicPoint2 = strategicPoint2;
    }

    public FieldBattlePosition getStrategicPoint3() {
        return strategicPoint3;
    }

    public void setStrategicPoint3(FieldBattlePosition strategicPoint3) {
        this.strategicPoint3 = strategicPoint3;
    }

    public Set<Nation> getTargetNations() {
        return targetNations;
    }

    public void setTargetNations(Set<Nation> targetNations) {
        this.targetNations = targetNations;
    }

    public String getTargetArm() {
        return targetArm;
    }

    public void setTargetArm(String targetArm) {
        this.targetArm = targetArm;
    }

    public String getTargetFormation() {
        return targetFormation;
    }

    public void setTargetFormation(String targetFormation) {
        this.targetFormation = targetFormation;
    }

    public boolean isTargetHighestHeadcount() {
        return targetHighestHeadcount;
    }

    public void setTargetHighestHeadcount(boolean targetHighestHeadcount) {
        this.targetHighestHeadcount = targetHighestHeadcount;
    }

    public boolean isTargetClosestInRange() {
        return targetClosestInRange;
    }

    public void setTargetClosestInRange(boolean targetClosestInRange) {
        this.targetClosestInRange = targetClosestInRange;
    }

    public Integer getConstructionCounter() {
        return constructionCounter;
    }

    public void setConstructionCounter(Integer constructionCounter) {
        this.constructionCounter = constructionCounter;
    }

    public String getFormation() {
        return formation;
    }

    public void setFormation(String formation) {
        this.formation = formation;
    }

    public FormationEnum getFormationEnum() {
        return FormationEnum.valueOf(formation);
    }

    public void setFormationEnum(FormationEnum formationEnum) {
        this.formation = formationEnum.toString();
    }

    public boolean isOwnSideCapturedEnemyStrategicPoint() {
        return ownSideCapturedEnemyStrategicPoint;
    }

    public void setOwnSideCapturedEnemyStrategicPoint(
            boolean ownSideCapturedEnemyStrategicPoint) {
        this.ownSideCapturedEnemyStrategicPoint = ownSideCapturedEnemyStrategicPoint;
    }

    public boolean isEnemySideCapturedOwnStrategicPoint() {
        return enemySideCapturedOwnStrategicPoint;
    }

    public void setEnemySideCapturedOwnStrategicPoint(
            boolean enemySideCapturedOwnStrategicPoint) {
        this.enemySideCapturedOwnStrategicPoint = enemySideCapturedOwnStrategicPoint;
    }

    public FieldBattlePosition getCustomStrategicPoint1() {
        return customStrategicPoint1;
    }

    public void setCustomStrategicPoint1(FieldBattlePosition customStrategicPoint1) {
        this.customStrategicPoint1 = customStrategicPoint1;
    }

    public FieldBattlePosition getCustomStrategicPoint2() {
        return customStrategicPoint2;
    }

    public void setCustomStrategicPoint2(FieldBattlePosition customStrategicPoint2) {
        this.customStrategicPoint2 = customStrategicPoint2;
    }

    public FieldBattlePosition getCustomStrategicPoint3() {
        return customStrategicPoint3;
    }

    public void setCustomStrategicPoint3(FieldBattlePosition customStrategicPoint3) {
        this.customStrategicPoint3 = customStrategicPoint3;
    }

    public Order getBackup() {
        return backup;
    }

    public void setBackup(Order backup) {
        this.backup = backup;
    }


    public int getDetachmentLeaderId() {
        return detachmentLeaderId;
    }

    public void setDetachmentLeaderId(int detachmentLeaderId) {
        this.detachmentLeaderId = detachmentLeaderId;
    }

    public String getDetachmentPosition() {
        return detachmentPosition;
    }

    public void setDetachmentPosition(String detachmentPosition) {
        this.detachmentPosition = detachmentPosition;
    }

    public DetachmentPosition getDetachmentPositionEnum() {
        return DetachmentPosition.valueOf(detachmentPosition);
    }

    public void setDetachmentPosition(DetachmentPosition detachmentPosition) {
        this.detachmentPosition = detachmentPosition.toString();
    }

    public FieldBattlePosition getDefendPositionArtilleryTarget() {
        return defendPositionArtilleryTarget;
    }

    public void setDefendPositionArtilleryTarget(
            FieldBattlePosition defendPositionArtilleryTarget) {
        this.defendPositionArtilleryTarget = defendPositionArtilleryTarget;
    }
}
