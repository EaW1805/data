package com.eaw1805.data.dto.web.field;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: karavias
 * Date: 7/10/13
 * Time: 12:54 AM
 * To change this template use File | Settings | File Templates.
 */
public class StructureAffectedLogEntryDTO implements com.google.gwt.user.client.rpc.IsSerializable, Serializable {
    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD

    private int brigadeId;
    private int oldHitPoints;
    private int hitPointDiff;

    public int getBrigadeId() {
        return brigadeId;
    }

    public void setBrigadeId(int brigadeId) {
        this.brigadeId = brigadeId;
    }

    public int getOldHitPoints() {
        return oldHitPoints;
    }

    public void setOldHitPoints(int oldHitPoints) {
        this.oldHitPoints = oldHitPoints;
    }

    public int getHitPointDiff() {
        return hitPointDiff;
    }

    public void setHitPointDiff(int hitPointDiff) {
        this.hitPointDiff = hitPointDiff;
    }
}
