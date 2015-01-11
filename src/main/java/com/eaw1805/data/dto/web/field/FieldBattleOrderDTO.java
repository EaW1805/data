package com.eaw1805.data.dto.web.field;


import java.io.Serializable;
import java.util.Set;

public class FieldBattleOrderDTO implements com.google.gwt.user.client.rpc.IsSerializable, Serializable {
	
	private static final long serialVersionUID = 8293892800871207711L;
	
	private int id;
    //the check points
    private String orderType;
    private FieldBattlePositionDTO checkPoint1;
    private FieldBattlePositionDTO checkPoint2;
    private FieldBattlePositionDTO checkPoint3;

    private boolean reachedCheckpoint1;
    private boolean reachedCheckpoint2;
    private boolean reachedCheckpoint3;
    private String formation;


    // order-specific
    private Integer maintainDistance;
    private FieldBattlePositionDTO strategicPoint1;
    private FieldBattlePositionDTO strategicPoint2;
    private FieldBattlePositionDTO strategicPoint3;
    private Integer constructionCounter;

    // target filters
    private Set<Integer> targetNations;
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
    private FieldBattlePositionDTO customStrategicPoint1;
    private FieldBattlePositionDTO customStrategicPoint2;
    private FieldBattlePositionDTO customStrategicPoint3;
    private FieldBattleOrderDTO originalOrder;
    private boolean changedAtMiddleRound;
    private String detachmentPosition;

    //for follow detachment order
    private int leaderId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public FieldBattlePositionDTO getCheckPoint1() {
        return checkPoint1;
    }

    public void setCheckPoint1(FieldBattlePositionDTO checkPoint1) {
        this.checkPoint1 = checkPoint1;
    }

    public FieldBattlePositionDTO getCheckPoint2() {
        return checkPoint2;
    }

    public void setCheckPoint2(FieldBattlePositionDTO checkPoint2) {
        this.checkPoint2 = checkPoint2;
    }

    public FieldBattlePositionDTO getCheckPoint3() {
        return checkPoint3;
    }

    public void setCheckPoint3(FieldBattlePositionDTO checkPoint3) {
        this.checkPoint3 = checkPoint3;
    }

    public boolean hasCheckPoint1() {
        return checkPoint1.getX() >= 0 && checkPoint1.getY() >= 0;
    }

    public boolean hasCheckPoint2() {
        return checkPoint2.getX() >= 0 && checkPoint2.getY() >= 0;
    }

    public boolean hasCheckPoint3() {
        return checkPoint3.getX() >= 0 && checkPoint3.getY() >= 0;
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

    public String getFormation() {
        return formation;
    }

    public void setFormation(String formation) {
        this.formation = formation;
    }

    public Integer getMaintainDistance() {
        return maintainDistance;
    }

    public void setMaintainDistance(Integer maintainDistance) {
        this.maintainDistance = maintainDistance;
    }

    public FieldBattlePositionDTO getStrategicPoint1() {
        return strategicPoint1;
    }

    public void setStrategicPoint1(FieldBattlePositionDTO strategicPoint1) {
        this.strategicPoint1 = strategicPoint1;
    }

    public FieldBattlePositionDTO getStrategicPoint2() {
        return strategicPoint2;
    }

    public void setStrategicPoint2(FieldBattlePositionDTO strategicPoint2) {
        this.strategicPoint2 = strategicPoint2;
    }

    public FieldBattlePositionDTO getStrategicPoint3() {
        return strategicPoint3;
    }

    public void setStrategicPoint3(FieldBattlePositionDTO strategicPoint3) {
        this.strategicPoint3 = strategicPoint3;
    }

    public boolean hasStrategicPoint1() {
        return strategicPoint1.getX() >= 0 && strategicPoint1.getY() >= 0;
    }

    public boolean hasStrategicPoint2() {
        return strategicPoint2.getX() >= 0 && strategicPoint2.getY() >= 0;
    }

    public boolean hasStrategicPoint3() {
        return strategicPoint3.getX() >= 0 && strategicPoint3.getY() >= 0;
    }

    public Integer getConstructionCounter() {
        return constructionCounter;
    }

    public void setConstructionCounter(Integer constructionCounter) {
        this.constructionCounter = constructionCounter;
    }

    public Set<Integer> getTargetNations() {
        return targetNations;
    }

    public void setTargetNations(Set<Integer> targetNations) {
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

    public int getActivationRound() {
        return activationRound;
    }

    public void setActivationRound(int activationRound) {
        this.activationRound = activationRound;
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

    public boolean isOwnSideCapturedEnemyStrategicPoint() {
        return ownSideCapturedEnemyStrategicPoint;
    }

    public void setOwnSideCapturedEnemyStrategicPoint(boolean ownSideCapturedEnemyStrategicPoint) {
        this.ownSideCapturedEnemyStrategicPoint = ownSideCapturedEnemyStrategicPoint;
    }

    public boolean isEnemySideCapturedOwnStrategicPoint() {
        return enemySideCapturedOwnStrategicPoint;
    }

    public void setEnemySideCapturedOwnStrategicPoint(boolean enemySideCapturedOwnStrategicPoint) {
        this.enemySideCapturedOwnStrategicPoint = enemySideCapturedOwnStrategicPoint;
    }

    public FieldBattlePositionDTO getCustomStrategicPoint1() {
        return customStrategicPoint1;
    }

    public void setCustomStrategicPoint1(FieldBattlePositionDTO customStrategicPoint1) {
        this.customStrategicPoint1 = customStrategicPoint1;
    }

    public FieldBattlePositionDTO getCustomStrategicPoint2() {
        return customStrategicPoint2;
    }

    public void setCustomStrategicPoint2(FieldBattlePositionDTO customStrategicPoint2) {
        this.customStrategicPoint2 = customStrategicPoint2;
    }

    public FieldBattlePositionDTO getCustomStrategicPoint3() {
        return customStrategicPoint3;
    }

    public void setCustomStrategicPoint3(FieldBattlePositionDTO customStrategicPoint3) {
        this.customStrategicPoint3 = customStrategicPoint3;
    }

    public boolean hasCustomStrategicPoint1() {
        return customStrategicPoint1.getX() >= 0 && customStrategicPoint1.getY() >= 0;
    }

    public boolean hasCustomStrategicPoint2() {
        return customStrategicPoint2.getX() >= 0 && customStrategicPoint2.getY() >= 0;
    }

    public boolean hasCustomStrategicPoint3() {
        return customStrategicPoint3.getX() >= 0 && customStrategicPoint3.getY() >= 0;
    }

    public FieldBattleOrderDTO getOriginalOrder() {
        return originalOrder;
    }

    public void setOriginalOrder(FieldBattleOrderDTO originalOrder) {
        this.originalOrder = originalOrder;
    }

    public int getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(int leaderId) {
        this.leaderId = leaderId;
    }

    public String getDetachmentPosition() {
        return detachmentPosition;
    }

    public void setDetachmentPosition(String detachmentPosition) {
        this.detachmentPosition = detachmentPosition;
    }

}
