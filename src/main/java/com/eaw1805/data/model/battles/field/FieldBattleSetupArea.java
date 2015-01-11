package com.eaw1805.data.model.battles.field;

import com.eaw1805.data.model.Nation;

import java.io.Serializable;

/**
 * This class described a setup area for a specific nation in a field battle.
 * @author deadlock
 *
 */
public class FieldBattleSetupArea implements Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD

	private final FieldBattleMap fbt;
	private final Nation nation;
	private final int startX;
	private final int endX;
	private final int startY;
	private final int endY;
	private int startWallX = -1;
	private int endWallX = -1;
	private int wallY = -1;

	/**
	 * Public constructor.
	 * @param fbt the field battle terrain where this setup area belongs
	 * @param nation the nation the setup area corresponds to
	 * @param startX the start X coordinate
	 * @param endX the end X coordinate
	 * @param startY the start Y coordinate
	 * @param endY the end Y coordinate
	 */
	public FieldBattleSetupArea(FieldBattleMap fbt, Nation nation,
			int startX, int endX, int startY, int endY) {
		this.fbt = fbt;
		this.nation = nation;
		this.startX = startX;
		this.endX = endX;
		this.startY = startY;
		this.endY = endY;
	}
	
	/**
	 * Checks if a sector is contained within the setup area.
	 * @param fbSector the field battle sector
	 * @return true or false
	 */
	public boolean containsSector(FieldBattleSector fbSector) {
		return startX <= fbSector.getX() && fbSector.getX() <= endX
				&& startY <= fbSector.getY() && fbSector.getY() <= endY;
	}

	public FieldBattleMap getFbt() {
		return fbt;
	}

	public Nation getNation() {
		return nation;
	}

	public int getStartX() {
		return startX;
	}

	public int getEndX() {
		return endX;
	}

	public int getStartY() {
		return startY;
	}

	public int getEndY() {
		return endY;
	}
	
	public boolean isTop() {
		return startY == 0;
	}

	public int getStartWallX() {
		return startWallX;
	}

	public void setStartWallX(int startWallX) {
		this.startWallX = startWallX;
	}

	public int getEndWallX() {
		return endWallX;
	}

	public void setEndWallX(int endWallX) {
		this.endWallX = endWallX;
	}

	public void setWallY(int wallY) {
		this.wallY = wallY;
	}

	public int getWallY() {
		return wallY;
	}
	
}
