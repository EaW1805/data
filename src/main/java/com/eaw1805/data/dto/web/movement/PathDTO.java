package com.eaw1805.data.dto.web.movement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a movement Path.
 */
public class PathDTO
        implements com.google.gwt.user.client.rpc.IsSerializable, Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 321L; //NOPMD

    /**
     * The region of the movement.
     */
    private int regionId;

    /**
     * The length of the path.
     */
    private int totLength;

    /**
     * The total cost of the movement path in MPs.
     */
    private int totalCost;

    /**
     * The total number of neutral sectors that will be conquered.
     */
    private int totalConquerNeutral;

    /**
     * The total number of sectors that will be conquered.
     */
    private int totalConquer;

    /**
     * The sectors visited by the movement path.
     */
    private List<PathSectorDTO> pathSectors;

    /**
     * Path contains non allied and thus cannot force march over it.
     */
    private boolean canForceMarch;

    /**
     * Default constructor.
     */
    public PathDTO() {
        super();
        pathSectors = new ArrayList<PathSectorDTO>();
        totalCost = 0;
    }

    /**
     * Get the sectors visited by the movement path.
     *
     * @return the sectors visited by the movement path.
     */
    public List<PathSectorDTO> getPathSectors() {
        return pathSectors;
    }

    /**
     * Set the sectors visited by the movement path.
     *
     * @param value the sectors visited by the movement path.
     */
    public void setPathSectors(final List<PathSectorDTO> value) {
        pathSectors = value;
    }

    /**
     * Get the total cost of the movement path.
     *
     * @return the total cost of the movement path.
     */
    public int getTotalCost() {
        return totalCost;
    }

    /**
     * Set the total cost of the movement path.
     *
     * @param value the total cost of the movement path.
     */
    public void setTotalCost(final int value) {
        this.totalCost = value;
    }

    /**
     * Get the total path length.
     *
     * @return the total path length.
     */
    public int getTotLength() {
        return totLength;
    }

    /**
     * Set the total path length.
     *
     * @param value the total path length.
     */
    public void setTotLength(final int value) {
        totLength = value;
    }

    /**
     * The region where the movement takes place.
     *
     * @return the region where the movement takes place.
     */
    public int getRegionId() {
        return regionId;
    }

    /**
     * Set the region where the movement takes place.
     *
     * @param value the region where the movement takes place.
     */
    public void setRegionId(final int value) {
        regionId = value;
    }

    /**
     * Get the total number of neutral sectors that will be conquered.
     *
     * @return the total number of neutral sectors that will be conquered.
     */
    public int getTotalConquerNeutral() {
        return totalConquerNeutral;
    }

    /**
     * Set the total number of neutral sectors that will be conquered.
     *
     * @param value the total number of neutral sectors that will be conquered.
     */
    public void setTotalConquerNeutral(final int value) {
        this.totalConquerNeutral = value;
    }

    /**
     * Get the total number of sectors that will be conquered.
     *
     * @return the total number of sectors that will be conquered.
     */
    public int getTotalConquer() {
        return totalConquer;
    }

    /**
     * Set the total number of sectors that will be conquered.
     *
     * @param value the total number of sectors that will be conquered.
     */
    public void setTotalConquer(final int value) {
        this.totalConquer = value;
    }

    /**
     * Get if tile is non allied and thus cannot force march over it.
     *
     * @return if tile is non allied and thus cannot force march over it.
     */
    public boolean getCanForceMarch() {
        return canForceMarch;
    }

    /**
     * Get if unit can force march over this path by checking the sectors.
     *
     * @return True if path can be force marched.
     */
    public boolean getCanForceMarchBySectors() {
        boolean canForce = true;
        for (PathSectorDTO sector : getPathSectors()) {
            canForce &= sector.getCanForceMarch();
        }
        return canForce;
    }

    /**
     * Set if tile is non allied and thus cannot force march over it.
     *
     * @param value \if tile is non allied and thus cannot force march over it.
     */
    public void setCanForceMarch(final boolean value) {
        canForceMarch = value;
    }

}
