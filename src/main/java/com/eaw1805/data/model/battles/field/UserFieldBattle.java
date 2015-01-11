package com.eaw1805.data.model.battles.field;

import java.io.Serializable;

public class UserFieldBattle implements Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD

    private int userFieldBattleId;

    private int battleId;

    private int userId;

    private int nationId;

    private boolean ready;

    private String facebookId;

    public int getBattleId() {
        return battleId;
    }

    public void setBattleId(int battleId) {
        this.battleId = battleId;
    }

    public int getUserFieldBattleId() {
        return userFieldBattleId;
    }

    public void setUserFieldBattleId(int userFieldBattleId) {
        this.userFieldBattleId = userFieldBattleId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getNationId() {
        return nationId;
    }

    public void setNationId(int nationId) {
        this.nationId = nationId;
    }

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public String getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }
}
