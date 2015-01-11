package com.eaw1805.data.model.battles.field.log.entries;

/**
 * Log entry that represents a brigade movement.
 * @author fragkakis
 *
 */
public class BrigadeMovementLogEntry extends HalfRoundLogEntry {

	private final int brigadeId;
	private final int startX;
	private final int startY;
	private final int endX;
	private final int endY;
	private static final long serialVersionUID = -5689036632871840316L;
	
	public BrigadeMovementLogEntry(int brigadeId, int startX, int startY, int endX, int endY) {
		this.brigadeId = brigadeId;
		this.startX = startX;
		this.startY = startY;
		this.endX = endX;
		this.endY = endY;
	}

	public int getBrigadeId() {
		return brigadeId;
	}

	public int getStartX() {
		return startX;
	}

	public int getStartY() {
		return startY;
	}

	public int getEndX() {
		return endX;
	}

	public int getEndY() {
		return endY;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
