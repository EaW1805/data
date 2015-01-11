package com.eaw1805.data.dto.web;

import java.io.Serializable;

public class UserDTO
        implements com.google.gwt.user.client.rpc.IsSerializable, Serializable {


    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD

    /**
     * the identity of the account.
     */
    private int userId;

    /**
     * The username of the account.
     */
    private String username;

    /**
     * The password of the account.
     */
    private String password;

    public UserDTO() {
        super();
    }

    public UserDTO(final int id, final String username, final String password) {
        super();
        this.userId = id;
        this.username = username;
        this.password = password;
    }

    /**
     * Get  the identity.
     *
     * @return the identity.
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Set the identity.
     *
     * @param value the identity.
     */
    public void setUserId(final int value) {
        userId = value;
    }

    /**
     * Get  the username.
     *
     * @return the username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set the username.
     *
     * @param value the username.
     */
    public void setUsername(final String value) {
        this.username = value;
    }

    /**
     * Get the password.
     *
     * @return the password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the password.
     *
     * @param value the password.
     */
    public void setPassword(final String value) {
        this.password = value;
    }


}
