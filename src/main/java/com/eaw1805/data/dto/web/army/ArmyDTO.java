package com.eaw1805.data.dto.web.army;

import com.eaw1805.data.dto.common.PositionDTO;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Represents a particular army.
 */
public class ArmyDTO
        extends PositionDTO
        implements com.google.gwt.user.client.rpc.IsSerializable, Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD

    /**
     * The identity of the army.
     */
    private int armyId;

    /**
     * The name of the army.
     */
    private String name;

    /**
     * The original name of this army as is stored in the db
     */
    private String originalName;

    /**
     * The commander of the army.
     */
    private CommanderDTO commander;

    /**
     * The corps that constitute the army.
     */
    private Map<Integer, CorpDTO> corps;

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

    private int nationId;


    /**
     * Default constructor.
     */
    public ArmyDTO() {
        super();
        commander = new CommanderDTO();
        corps = new HashMap<Integer, CorpDTO>();
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
     * The name of the army.
     *
     * @return The name of the army.
     */
    public String getName() {
        return name;
    }

    /**
     * Set The name of the army.
     *
     * @param value The name of the army.
     */
    public void setName(final String value) {
        this.name = value;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(final String originalName) {
        this.originalName = originalName;
    }

    /**
     * Get the commander of the army.
     *
     * @return the commander of the army.
     */
    public CommanderDTO getCommander() {
        return commander;
    }

    /**
     * Set the commander of the army.
     *
     * @param value the commander of the army.
     */
    public void setCommander(final CommanderDTO value) {
        this.commander = value;
    }

    /**
     * The corps that constitute the army.
     *
     * @return the corps that constitute the army.
     */
    public Map<Integer, CorpDTO> getCorps() {
        return corps;
    }

    /**
     * Set the corps that constitute the army.
     *
     * @param value the corps that constitute the army.
     */
    public void setCorps(final Map<Integer, CorpDTO> value) {
        this.corps = value;
    }

    public int getNationId() {
        return nationId;
    }

    public void setNationId(final int nationId) {
        this.nationId = nationId;
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
