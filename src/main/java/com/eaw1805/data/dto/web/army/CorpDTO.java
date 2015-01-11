package com.eaw1805.data.dto.web.army;

import com.eaw1805.data.dto.common.PositionDTO;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Represent Army Corps.
 */
public class CorpDTO
        extends PositionDTO
        implements com.google.gwt.user.client.rpc.IsSerializable, Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 34L; //NOPMD

    /**
     * The identity of the entity.
     */
    private int corpId;

    /**
     * The identity of the army.
     */
    private int armyId;

    /**
     * The army id in which the brigade started this turn
     */
    private int startArmy = 0;

    /**
     * The nation that this corp belongs to.
     */
    private int nationId;

    /**
     * The name of the corp.
     */
    private String name;

    /**
     * The original name of the corps as is stored in the db.
     */
    private String originalName;

    /**
     * The commander of the corp.
     */
    private CommanderDTO commander;

    /**
     * The brigades of the corp.
     */
    private Map<Integer, BrigadeDTO> brigades = new HashMap<Integer, BrigadeDTO>();

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
     * Get the identity of the entity.
     *
     * @return the identity of the entity.
     */
    public int getCorpId() {
        return corpId;
    }

    /**
     * Set the identity of the entity.
     *
     * @param value the identity of the entity.
     */
    public void setCorpId(final int value) {
        this.corpId = value;
    }

    /**
     * Get the identity of the army.
     *
     * @return the identity of the army.
     */
    public int getArmyId() {
        return armyId;
    }

    /**
     * Set the identity of the army.
     *
     * @param value the identity of the army.
     */
    public void setArmyId(final int value) {
        this.armyId = value;
    }

    /**
     * Get the nation this corp type belongs to.
     *
     * @return the nation this corp type belongs to.
     */
    public int getNationId() {
        return nationId;
    }

    /**
     * Set the nation this corp type belongs to.
     *
     * @param param The nation this corp type belongs to.
     */
    public void setNationId(final int param) {
        this.nationId = param;
    }

    /**
     * The name of the corp.
     *
     * @return The name of the corp.
     */
    public String getName() {
        return name;
    }

    /**
     * Set The name of the corp.
     *
     * @param value The name of the corp.
     */
    public void setName(final String value) {
        this.name = value;
    }

    /**
     * Get the commander of the corp.
     *
     * @return the commander of the corp.
     */
    public CommanderDTO getCommander() {
        return commander;
    }

    /**
     * Set the commander of the corp.
     *
     * @param value the commander of the corp.
     */
    public void setCommander(final CommanderDTO value) {
        this.commander = value;
    }

    /**
     * Get The brigades of the corp.
     *
     * @return The brigades of the corp.
     */
    public Map<Integer, BrigadeDTO> getBrigades() {
        return brigades;
    }

    /**
     * Set The brigades of the corp.
     *
     * @param value The brigades of the corp.
     */
    public void setBrigades(final Map<Integer, BrigadeDTO> value) {
        this.brigades = value;
    }

    /**
     * Get the army in which the corp started.
     *
     * @return the armyId in which the corp started
     */
    public int getStartArmy() {
        return startArmy;
    }

    /**
     * Set the army in which the corp started.
     *
     * @param startArmy the corpId in which the corp started
     */
    public void setStartArmy(final int startArmy) {
        this.startArmy = startArmy;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(final String originalName) {
        this.originalName = originalName;
    }

    public boolean isUpgraded() {
        return isUpgraded;
    }

    public void setUpgraded(final boolean upgraded) {
        isUpgraded = upgraded;
    }

    public boolean isUpgradedToElite() {
        return isUpgradedToElite;
    }

    public void setUpgradedToElite(final boolean upgradedToElite) {
        isUpgradedToElite = upgradedToElite;
    }

    public boolean isUpHeadcount() {
        return isUpHeadcount;
    }

    public void setUpHeadcount(final boolean upHeadcount) {
        isUpHeadcount = upHeadcount;
    }
}
