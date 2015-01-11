package com.eaw1805.data.dto.web.movement;

import com.eaw1805.data.dto.common.PositionDTO;

import java.io.Serializable;

/**
 * Stores information required for defining a movement path.
 */
public class PathSectorDTO
        extends PositionDTO
        implements com.google.gwt.user.client.rpc.IsSerializable, Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 31L; //NOPMD

    /**
     * terrain's movement points for the particular game, region and turn.
     */
    private int actualMPs;

    /**
     * Indication if the sector needs to be conquered.
     */
    private boolean needsConquer;

    /**
     * The image to use if this sector is part of a movement path.
     */
    private String path;

    /**
     * Tile is non allied and thus cannot force march over it.
     */
    private boolean canForceMarch;

    /**
     * Get the terrain's movement points for the particular game, region and turn.
     *
     * @return the terrain's movement points for the particular game, region and turn.
     */
    public int getActualMPs() {
        return actualMPs;
    }

    /**
     * Set the terrain's movement points for the particular game, region and turn.
     *
     * @param value the terrain's movement points for the particular game, region and turn.
     */
    public void setActualMPs(final int value) {
        this.actualMPs = value;
    }

    /**
     * Get the Indication if the sector needs to be conquered.
     *
     * @return the Indication if the sector needs to be conquered.
     */
    public boolean getNeedsConquer() {
        return needsConquer;
    }

    /**
     * Set the Indication if the sector needs to be conquered.
     *
     * @param value the Indication if the sector needs to be conquered.
     */
    public void setNeedsConquer(final boolean value) {
        this.needsConquer = value;
    }

    /**
     * Get the image to use if this sector is part of a movement path.
     *
     * @return the image to use if this sector is part of a movement path.
     */
    public String getPath() {
        return path;
    }

    /**
     * Set the image to use if this sector is part of a movement path.
     *
     * @param value the image to use if this sector is part of a movement path.
     */
    public void setPath(final String value) {
        this.path = value;
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
     * Set if tile is non allied and thus cannot force march over it.
     *
     * @param value \if tile is non allied and thus cannot force march over it.
     */
    public void setCanForceMarch(final boolean value) {
        canForceMarch = value;
    }
}
