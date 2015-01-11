package com.eaw1805.data.dto.web.field;

import java.io.Serializable;

public class RallyLogEntryDTO implements com.google.gwt.user.client.rpc.IsSerializable, Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD

    private int brigadeId;
    private int x;
    private int y;
    private String moralStatusOutCome;

    public int getBrigadeId() {
        return brigadeId;
    }

    public void setBrigadeId(int brigadeId) {
        this.brigadeId = brigadeId;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getMoralStatusOutCome() {
        return moralStatusOutCome;
    }

    public void setMoralStatusOutCome(String moralStatusOutCome) {
        this.moralStatusOutCome = moralStatusOutCome;
    }
}
