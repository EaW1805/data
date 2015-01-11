package com.eaw1805.data.model.battles.field.log.entries;

/**
 * Log entry that represents a structure-related event.
 * @author fragkakis
 *
 */
public class StructureAffectedLogEntry extends HalfRoundLogEntry {

	private final int brigadeId;
	private final int oldHitPoints;
	private final int hitPointDiff;
	private static final long serialVersionUID = -5689036632871840316L;
	
	public StructureAffectedLogEntry(int brigadeId, int oldHitPoints, int hitPointDiff) {
		this.brigadeId = brigadeId;
		this.oldHitPoints = oldHitPoints;
		this.hitPointDiff = hitPointDiff;
	}

	public int getAttackerBrigadeId() {
		return brigadeId;
	}
	
	public int getOldHitPoints() {
		return oldHitPoints;
	}
	
	public int getDamage() {
		return hitPointDiff;
	}

}
