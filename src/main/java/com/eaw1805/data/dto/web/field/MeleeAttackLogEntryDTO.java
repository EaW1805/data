package com.eaw1805.data.dto.web.field;


import java.io.Serializable;

public class MeleeAttackLogEntryDTO implements com.google.gwt.user.client.rpc.IsSerializable, Serializable {
    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD

    private int attackerBrigadeId;
    private int targetBrigadeId;
    private int casualties;

    public int getAttackerBrigadeId() {
        return attackerBrigadeId;
    }

    public void setAttackerBrigadeId(int attackerBrigadeId) {
        this.attackerBrigadeId = attackerBrigadeId;
    }

    public int getTargetBrigadeId() {
        return targetBrigadeId;
    }

    public void setTargetBrigadeId(int targetBrigadeId) {
        this.targetBrigadeId = targetBrigadeId;
    }

    public int getCasualties() {
        return casualties;
    }

    public void setCasualties(int casualties) {
        this.casualties = casualties;
    }
}
