package com.eaw1805.data.model.forum;

import com.eaw1805.data.model.User;

import java.io.Serializable;

/**
 * Handles user's permission on forum.
 */
public class UserPermissions implements Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD

    /**
     * User Permissions id.
     */
    private int id;

    /**
     * The user.
     */
    private User user;

    /**
     * The forum for this game.
     */
    private int forumId;

    /**
     * User's permission role
     */
    private int authRoleId;

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

    /**
     * Get the forum for this game.
     *
     * @return the forum for this game.
     */
    public int getForumId() {
        return forumId;
    }

    /**
     * Set the forum for this game.
     *
     * @param value the forum for this game.
     */
    public void setForumId(final int value) {
        this.forumId = value;
    }

    /**
     * Get the user's permissions role.
     *
     * @return the user's permissions role.
     */
    public int getAuthRoleId() {
        return authRoleId;
    }

    /**
     * Set the permissions role for this user.
     *
     * @param value the role id.
     */
    public void setAuthRoleId(final int value) {
        this.authRoleId = value;
    }


}
