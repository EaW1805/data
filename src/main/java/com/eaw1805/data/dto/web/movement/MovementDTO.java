package com.eaw1805.data.dto.web.movement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MovementDTO
        implements com.google.gwt.user.client.rpc.IsSerializable, Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD


    /**
     * The region of the movement.
     */
    private int regionId;

    private int armyType, id;

    private boolean forcedMarch = false;

    private boolean patrol = false;

    /**
     * The total cost of the movement path in MPs.
     */
    private int totalCost;

    /**
     * The sectors visited by the movement path.
     */
    private List<PathDTO> paths;

    /**
     * Default constructor.
     */
    public MovementDTO() {
        super();
        paths = new ArrayList<PathDTO>();
        totalCost = 0;
    }

    public int getArmyType() {
        return armyType;
    }

    public int getId() {
        return id;
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

    public void setArmyType(final int armyType) {
        this.armyType = armyType;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getForcedMarch() {
        return forcedMarch;
    }

    public void setForcedMarch(final boolean forcedMarch) {
        this.forcedMarch = forcedMarch;
    }

    public boolean getPatrol() {
        return patrol;
    }

    public void setPatrol(final boolean patrol) {
        this.patrol = patrol;
    }

    /**
     * Get the sectors visited by the movement path.
     *
     * @return the sectors visited by the movement path.
     */
    public List<PathDTO> getPaths() {
        return paths;
    }

    /**
     * Add a sector path contained in the movement path.
     *
     * @param value a sector path contained in the movement path.
     */
    public void addPaths(final PathDTO value) {
        paths.add(value);
    }

    /**
     * Set the sectors visited by the movement path.
     *
     * @param value the sectors visited by the movement path.
     */
    public void setPaths(final List<PathDTO> value) {
        paths = value;
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

}
