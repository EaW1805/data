package com.eaw1805.data.model;

import java.io.Serializable;

/**
 * Represents a player profile entry.
 */
public class Profile implements Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD

    /**
     * player profile entry's identification number.
     */
    private int id; // NOPMD

    /**
     * The user of the player profile entry.
     */
    private com.eaw1805.data.model.User user;

    /**
     * player profile entry key.
     */
    private String key;

    /**
     * player profile entry value.
     */
    private int value;

    /**
     * Get the Identification number of the player profile entry.
     *
     * @return the identification number of the player profile entry.
     */
    public int getId() {
        return id;
    }

    /**
     * Set the identification number of the player profile entry.
     *
     * @param identity the identification number of player profile entry.
     */
    public void setId(final int identity) {
        this.id = identity;
    }

    /**
     * Get the user related of the player profile entry.
     *
     * @return the user of the player profile entry.
     */
    public com.eaw1805.data.model.User getUser() {
        return user;
    }

    /**
     * Set the user of the player profile entry.
     *
     * @param value the user of the player profile entry.
     */
    public void setUser(final com.eaw1805.data.model.User value) {
        user = value;
    }

    /**
     * Get the key of the player profile entry.
     *
     * @return the key of the player profile entry.
     */
    public String getKey() {
        return key;
    }

    /**
     * Set the key of the player profile entry.
     *
     * @param thisKey the key of the player profile entry.
     */
    public void setKey(final String thisKey) {
        this.key = thisKey;
    }

    /**
     * Get the value of the player profile entry.
     *
     * @return the value of the player profile entry.
     */
    public int getValue() {
        return value;
    }

    /**
     * Set the value of the player profile entry.
     *
     * @param thisValue the value of the player profile entry.
     */
    public void setValue(final int thisValue) {
        value = thisValue;
    }


}
