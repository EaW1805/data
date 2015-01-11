package com.eaw1805.data.model.battles.field.log.entries;

/**
 * Log entry that represents a melee attack.
 * @author fragkakis
 *
 */
public class MeleeAttackLogEntry extends HalfRoundLogEntry {

	private final int attackerBrigadeId;
	private final int targetBrigadeId;
	private final int casualties;
	private static final long serialVersionUID = -5689036632871840316L;

	
	public MeleeAttackLogEntry(int attackerBrigadeId, int targetBrigadeId, int casualties) {
		this.attackerBrigadeId = attackerBrigadeId;
		this.targetBrigadeId = targetBrigadeId;
		this.casualties = casualties;
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

}
