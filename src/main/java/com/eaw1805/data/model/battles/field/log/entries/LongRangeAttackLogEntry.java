package com.eaw1805.data.model.battles.field.log.entries;

/**
 * Log entry that represents a long range attack.
 * @author fragkakis
 *
 */
public class LongRangeAttackLogEntry extends HalfRoundLogEntry {

	private final int attackerBrigadeId;
	private final int targetBrigadeId;
	private final int casualties;
	private final boolean ricochetAttack;
	private static final long serialVersionUID = -5689036632871840316L;

	
	public LongRangeAttackLogEntry(int attackerBrigadeId, int targetBrigadeId, boolean ricochetAttack, int casualties) {
		this.attackerBrigadeId = attackerBrigadeId;
		this.targetBrigadeId = targetBrigadeId;
		this.casualties = casualties;
		this.ricochetAttack = ricochetAttack;
	}
	
	public int getAttackerBrigadeId() {
		return attackerBrigadeId;
	}
	
	public int getTargetBrigadeId() {
		return targetBrigadeId;
	}
	
	public int getCasualties() {
		return casualties;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public boolean isRicochetAttack() {
		return ricochetAttack;
	}
		
}
