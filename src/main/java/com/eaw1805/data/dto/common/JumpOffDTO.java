package com.eaw1805.data.dto.common;


import java.io.Serializable;

public class JumpOffDTO
        implements com.google.gwt.user.client.rpc.IsSerializable, Serializable {
    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD

    private int jumpOffId;
    private int gameId;
    private int departureRegion;
    private int departureX;
    private int departureY;
    private int destinationRegion;
    private int destinationX;
    private int destinationY;

    public int getJumpOffId() {
        return jumpOffId;
    }

    public void setJumpOffId(int jumpOffId) {
        this.jumpOffId = jumpOffId;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getDepartureRegion() {
        return departureRegion;
    }

    public void setDepartureRegion(int departureRegion) {
        this.departureRegion = departureRegion;
    }

    public int getDepartureX() {
        return departureX;
    }

    public void setDepartureX(int departureX) {
        this.departureX = departureX;
    }

    public int getDepartureY() {
        return departureY;
    }

    public void setDepartureY(int departureY) {
        this.departureY = departureY;
    }

    public int getDestinationRegion() {
        return destinationRegion;
    }

    public void setDestinationRegion(int destinationRegion) {
        this.destinationRegion = destinationRegion;
    }

    public int getDestinationX() {
        return destinationX;
    }

    public void setDestinationX(int destinationX) {
        this.destinationX = destinationX;
    }

    public int getDestinationY() {
        return destinationY;
    }

    public void setDestinationY(int destinationY) {
        this.destinationY = destinationY;
    }
}
