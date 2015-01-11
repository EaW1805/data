package com.eaw1805.data.dto.web.army;

import com.eaw1805.data.dto.web.CargoUnitDTO;
import com.eaw1805.data.dto.web.field.FieldBattleOrderDTO;
import com.eaw1805.data.dto.web.field.FieldBattlePositionDTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Brigade.
 */
public class BrigadeDTO
        extends CargoUnitDTO
        implements com.google.gwt.user.client.rpc.IsSerializable, Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 34L; //NOPMD

    /**
     * The unique identifier of the brigade.
     */
    private int brigadeId;

    /**
     * The nation that this brigade belongs to.
     */
    private int nationId;

    /**
     * The name of the brigade.
     */
    private String name;

    /**
     * The original name of the brigade as is stored in the db.
     */
    private String originalName;

    /**
     * the available movement points.
     */
    private int mps;

    /**
     * The corp of the brigade.
     */
    private int corp;

    /**
     * The corp id in which the brigade started this turn
     */
    private int startCorp = 0;

    /**
     * The upgrade flag of the brigade.
     */
    private boolean isUpgraded = false;

    /**
     * The upgrade to crack elite flag of the brigade.
     */
    private boolean isUpgradedToElite = false;

    /**
     * The up headcount flag of the brigade.
     */

    private boolean isUpHeadcount = false;

    /**
     * The up headcount number to upgrade.
     */
    private int upHeadcount;

    /**
     * Indicates if the brigade was constructed at the initialization of the game and not by the user.
     */
    private boolean fromInit;

    private List<BattalionDTO> battalions = new ArrayList<BattalionDTO>();

    private int fieldBattleX;
    private int fieldBattleY;
    private boolean placedOnFieldMap;
    private FieldBattleOrderDTO basicOrder;

    private FieldBattleOrderDTO additionalOrder;

    private CommanderDTO fieldBattleCommander;
    private int fieldBattleCommanderId;
    private int fieldBattleOverallCommanderId;
    private boolean fieldBattleUpdateMiddleRound;


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
     * Get the nation this army type belongs to.
     *
     * @return the nation this army type belongs to.
     */
    public int getNationId() {
        return nationId;
    }

    /**
     * Set the nation this army type belongs to.
     *
     * @param param The nation this army type belongs to.
     */
    public void setNationId(final int param) {
        this.nationId = param;
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

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(final String originalName) {
        this.originalName = originalName;
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
    public int getCorpId() {
        return corp;
    }

    /**
     * Set the corp of the brigade.
     *
     * @param thisFed the corp of the brigade.
     */
    public void setCorpId(final int thisFed) {
        this.corp = thisFed;
    }

    /**
     * Get the list of battalions.
     *
     * @return the list of battalions.
     */
    public List<BattalionDTO> getBattalions() {
        return battalions;
    }

    /**
     * Set the list of battalions.
     *
     * @param value the list of battalions.
     */
    public void setBattalions(final List<BattalionDTO> value) {
        this.battalions = value;
    }

    /**
     * Get the upgrade flag of the brigade.
     *
     * @return the true or flase.
     */
    public boolean isUpgraded() {
        return isUpgraded;
    }

    /**
     * Set the upgrade to crack elite flag of the brigade.
     *
     * @param isUpgradedToElite of the brigade.
     */
    public void setIsUpgradedToElite(final boolean isUpgradedToElite) {
        this.isUpgradedToElite = isUpgradedToElite;
    }

    /**
     * Get the upgrade flag of the brigade.
     *
     * @return the true or flase.
     */
    public boolean isUpgradedToElite() {
        return isUpgradedToElite;
    }

    /**
     * Set the upgrade flag of the brigade.
     *
     * @param isUpgraded of the brigade.
     */
    public void setIsUpgraded(final boolean isUpgraded) {
        this.isUpgraded = isUpgraded;
    }

    /**
     * Get the up headcount flag of the brigade.
     *
     * @return the up headcount trur or false of the brigade.
     */
    public boolean IsUpHeadcount() {
        return isUpHeadcount;
    }

    /**
     * Set the is Up Headcount flag of the brigade.
     *
     * @param isUpHeadcount Headcount flag true or false of the brigade.
     */
    public void setIsUpHeadcount(final boolean isUpHeadcount) {
        this.isUpHeadcount = isUpHeadcount;
    }

    /**
     * Get the headcount number of the brigade we want to upgrade.
     *
     * @return the headcount number of the brigade we want to upgrade.
     */
    public int getUpHeadcount() {
        return upHeadcount;
    }

    /**
     * Set the headcount number of the brigade we want to upgrade.
     *
     * @param upHeadcount number of the brigade we want to upgrade.
     */
    public void setUpHeadcount(final int upHeadcount) {
        this.upHeadcount = upHeadcount;
    }

    /**
     * Get the corp in which the brigade started.
     *
     * @return the corpId in which the brigade started
     */
    public int getStartCorp() {
        return startCorp;
    }

    /**
     * Set the corp in which the brigade started.
     *
     * @param startCorp the corpId in which the brigade started
     */
    public void setStartCorp(final int startCorp) {
        this.startCorp = startCorp;
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

    public int getFieldBattleX() {
        return fieldBattleX;
    }

    public void setFieldBattleX(int fieldBattleX) {
        this.fieldBattleX = fieldBattleX;
    }

    public int getFieldBattleY() {
        return fieldBattleY;
    }

    public void setFieldBattleY(int fieldBattleY) {
        this.fieldBattleY = fieldBattleY;
    }

    public boolean isPlacedOnFieldMap() {
        return placedOnFieldMap;
    }

    public void setPlacedOnFieldMap(boolean placedOnFieldMap) {
        this.placedOnFieldMap = placedOnFieldMap;
    }

    public FieldBattleOrderDTO getBasicOrder() {
        return basicOrder;
    }

    public void setBasicOrder(FieldBattleOrderDTO basicOrder) {
        this.basicOrder = basicOrder;
    }

    public FieldBattleOrderDTO getAdditionalOrder() {
        return additionalOrder;
    }

    public void setAdditionalOrder(FieldBattleOrderDTO additionalOrder) {
        this.additionalOrder = additionalOrder;
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

    public boolean isFieldBattleUpdateMiddleRound() {
        return fieldBattleUpdateMiddleRound;
    }

    public void setFieldBattleUpdateMiddleRound(boolean fieldBattleUpdateMiddleRound) {
        this.fieldBattleUpdateMiddleRound = fieldBattleUpdateMiddleRound;
    }

    public boolean hasBasicOrder() {
        return basicOrder != null && !"SELECT_AN_ORDER".equalsIgnoreCase(basicOrder.getOrderType());
    }

    public boolean hasAdditionalOrder() {
        return additionalOrder != null && !"SELECT_AN_ORDER".equalsIgnoreCase(additionalOrder.getOrderType());
    }

    public boolean hasEngineers() {
        boolean out = false;
        for (BattalionDTO battalion : battalions) {
            if (battalion.getEmpireArmyType().isEngineer()) {
                out = true;
                break;
            }
        }
        return out;
    }

    public int calculateTotalHeadCount() {
        int out = 0;
        for (BattalionDTO batt : getBattalions()) {
            out += batt.getHeadcount();
        }
        return out;
    }

    public int calculateTotalPower() {
        int out = 0;
        for (BattalionDTO batt : getBattalions()) {
            out += batt.getHeadcount() * batt.getExperience();
        }
        return out;
    }

    public int calculateTotalEfficiency() {
        int out = 0;
        for (BattalionDTO batt : getBattalions()) {
            out += batt.getExperience();
        }
        return out;
    }

    public String positionFieldBattleToString() {
        return (fieldBattleX + 1) + "/" + (fieldBattleY + 1);
    }

    public FieldBattlePositionDTO getLastCheckPoint(final boolean basic) {
        if (basic) {
            if (basicOrder.hasCheckPoint3()) {
                return basicOrder.getCheckPoint3();
            }
            if (basicOrder.hasCheckPoint2()) {
                return basicOrder.getCheckPoint2();
            }
            if (basicOrder.hasCheckPoint1()) {
                return basicOrder.getCheckPoint1();
            }


        } else {
            if (additionalOrder.hasCheckPoint3()) {
                return additionalOrder.getCheckPoint3();
            }
            if (additionalOrder.hasCheckPoint2()) {
                return additionalOrder.getCheckPoint2();
            }
            if (additionalOrder.hasCheckPoint1()) {
                return additionalOrder.getCheckPoint1();
            }
            if (basicOrder.hasCheckPoint3()) {
                return basicOrder.getCheckPoint3();
            }
            if (basicOrder.hasCheckPoint2()) {
                return basicOrder.getCheckPoint2();
            }
            if (basicOrder.hasCheckPoint1()) {
                return basicOrder.getCheckPoint1();
            }

        }


        FieldBattlePositionDTO pos = new FieldBattlePositionDTO();
        pos.setX(fieldBattleX);
        pos.setY(fieldBattleY);
        return pos;
    }

    public boolean hasArtillery() {
        for (BattalionDTO battalion : battalions) {
            if (battalion.getEmpireArmyType().isArtillery()) {
                return true;
            }
        }
        return false;
    }

    public int getTotalHeadCount() {
        int out = 0;
        for (BattalionDTO batt : battalions) {
            out += batt.getHeadcount();
        }
        return out;
    }

    public boolean isRouted() {
        return fieldBattleX == -1 && fieldBattleY == -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        BrigadeDTO that = (BrigadeDTO) o;

        if (brigadeId != that.brigadeId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + brigadeId;
        return result;
    }
}
