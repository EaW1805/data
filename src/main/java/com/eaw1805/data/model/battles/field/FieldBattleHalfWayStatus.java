package com.eaw1805.data.model.battles.field;


import java.io.Serializable;

public class FieldBattleHalfWayStatus implements Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD
	
	private int id;
	private int battleId;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBattleId() {
		return battleId;
	}
	public void setBattleId(int battleId) {
		this.battleId = battleId;
	}

}
