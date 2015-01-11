package com.eaw1805.data.model.map;


import java.io.Serializable;

public class JumpOff implements Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD

    private int jumpOffId;

    private Position departure;

    private Position destination;

    public int getJumpOffId() {
        return jumpOffId;
    }

    public void setJumpOffId(int jumpOffId) {
        this.jumpOffId = jumpOffId;
    }

    public Position getDeparture() {
        return departure;
    }

    public void setDeparture(Position departure) {
        this.departure = departure;
    }

    public Position getDestination() {
        return destination;
    }

    public void setDestination(Position destination) {
        this.destination = destination;
    }
}
