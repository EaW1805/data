package com.eaw1805.data.model.forum;

import com.eaw1805.data.model.User;

import java.io.Serializable;

/**
 * Handles user's posts on forum.
 */
public class ForumPost implements Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD


    /**
     * Post id.
     */
    private int id;

    /**
     * The user.
     */
    private User user;

    /**
     * Returns the id.
     *
     * @return an int with the id.
     */
    public int getId() {
        return id;
    }

    /**
     * Set the entity id,
     *
     * @param value an int with id.
     */
    public void setId(final int value) {
        this.id = value;
    }

    /**
     * Get the user.
     *
     * @return The user.
     */
    public User getUser() {
        return user;
    }

    /**
     * Set the user.
     *
     * @param user The user to set.
     */
    public void setUser(final User user) {
        this.user = user;
    }
}

