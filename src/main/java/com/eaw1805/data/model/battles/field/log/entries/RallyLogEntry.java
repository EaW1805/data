package com.eaw1805.data.model.battles.field.log.entries;

import com.eaw1805.data.model.battles.field.enumerations.MoraleStatusEnum;

/**
 * Log entry that represents a rally attempt.
 * @author fragkakis
 *
 */
public class RallyLogEntry extends HalfRoundLogEntry {

	private final int brigadeId;
	private final int x;
	private final int y;
	private final MoraleStatusEnum moraleStatusOutcome;
	private static final long serialVersionUID = -5689036632871840316L;
	
	public RallyLogEntry(int brigadeId, int x, int y, MoraleStatusEnum moraleStatusOutcome) {
		this.brigadeId = brigadeId;
		this.x = x;
		this.y = y;
		this.moraleStatusOutcome = moraleStatusOutcome;
	}

	public int getBrigadeId() {
		return brigadeId;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public MoraleStatusEnum getMoraleStatusOutcome() {
		return moraleStatusOutcome;
	}
	
}
