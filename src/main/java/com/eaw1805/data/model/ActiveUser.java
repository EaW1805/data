package com.eaw1805.data.model;


import java.io.Serializable;
import java.util.Date;

/**
 * Handles an Active User Object.
 */
public class ActiveUser implements Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD

    /**
     * Id used by hibernate.
     */
    private int activeUserId;

    /**
     * The user id.
     */
    private int userId;

    /**
     * The username.
     */
    private String username;

    /**
     * The user email.
     */
    private String emailEncoded;

    /**
     * The login time.
     */
    private Date loginTime;

    /**
     * Remote Ip address.
     */
    private String remoteIpAddress;

    /**
     * The Session Id..
     */
    private String sessionId;

    /**
     * Returns the active user id.
     *
     * @return an int with the id.
     */
    public int getActiveUserId() {
        return activeUserId;
    }

    /**
     * Set the active user id.
     *
     * @param value an int with id
     */
    public void setActiveUserId(final int value) {
        this.activeUserId = value;
    }

    /**
     * Returns the user id.
     *
     * @return an int with the id.
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Set the user id.
     *
     * @param value the user id.
     */
    public void setUserId(final int value) {
        this.userId = value;
    }

    /**
     * Returns the username.
     *
     * @return a String with the username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set the Username.
     *
     * @param value a String with the username.
     */
    public void setUsername(final String value) {
        this.username = value;
    }

    /**
     * Returns the encoded email address.
     *
     * @return a String with the email.
     */
    public String getEmailEncoded() {
        return emailEncoded;
    }

    /**
     * Set the encoded email address.
     *
     * @param value A string with the address.
     */
    public void setEmailEncoded(final String value) {
        this.emailEncoded = value;
    }

    /**
     * Returns the login time.
     *
     * @return A date.
     */
    public Date getLoginTime() {
        return loginTime;
    }

    /**
     * Set the login time.
     *
     * @param value a Date with the login time.
     */
    public void setLoginTime(final Date value) {
        this.loginTime = value;
    }

    /**
     * Returns the remote ip address.
     *
     * @return a String with the remote ip address.
     */
    public String getRemoteIpAddress() {
        return remoteIpAddress;
    }

    /**
     * Set the remote ip address.
     *
     * @param value a String with the remote ip address.
     */
    public void setRemoteIpAddress(final String value) {
        this.remoteIpAddress = value;
    }

    /**
     * Return the session id.
     *
     * @return a String with the session id.
     */
    public String getSessionId() {
        return sessionId;
    }

    /**
     * Set the session id.
     *
     * @param value a String with the session id.
     */
    public void setSessionId(final String value) {
        this.sessionId = value;
    }
}
