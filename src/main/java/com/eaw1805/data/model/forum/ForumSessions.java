package com.eaw1805.data.model.forum;

import com.eaw1805.data.model.User;

import java.io.Serializable;

/**
 * Handles the phpbb sessions.
 */
public class ForumSessions implements Serializable {
    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD


    /**
     * Session id.
     */
    private String sessionId;

    /**
     * The user.
     */
    private User user;

    /**
     * The forum id..
     */
    private int forumId;

    /**
     * User last visit.
     */
    private long lastVisit;

    /**
     * Session start time.
     */
    private long sessionStart;

    /**
     * Current Session time.
     */
    private long sessionTime;

    /**
     * Client IP.
     */
    private String sessionIp;

    /**
     * Client Browser.
     */
    private String sessionBrowser;

    /**
     * Current Session Page.
     */
    private String sessionPage;

    /**
     * True if user will be visible online.
     */
    private boolean viewOnline;

    /**
     * True for auto login.
     */
    private boolean autoLogin;

    /**
     * True for admin.
     */
    private boolean admin;

    /**
     * Returns the Session ID.
     *
     * @return a String with the Session id,
     */
    public String getSessionId() {
        return sessionId;
    }

    /**
     * Set the Session ID.
     *
     * @param value the String with the Session id.
     */
    public void setSessionId(final String value) {
        this.sessionId = value;
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
     * Returns the Forum id.
     *
     * @return an int with the Forum id.
     */
    public int getForumId() {
        return forumId;
    }

    /**
     * Current viewing forum id.
     *
     * @param value an int with the forum id,
     */
    public void setForumId(final int value) {
        this.forumId = value;
    }

    /**
     * Returns user's last visit.
     *
     * @return a long with the timestamp.
     */
    public long getLastVisit() {
        return lastVisit;
    }

    /**
     * Set users last visit.
     *
     * @param value a long with the timestamp.
     */
    public void setLastVisit(final long value) {
        this.lastVisit = value;
    }

    /**
     * Session Start timestamp.
     *
     * @return a long with the timestamp.
     */
    public long getSessionStart() {
        return sessionStart;
    }

    /**
     * Set the session start timestamp.
     *
     * @param value a long with the timestamp.
     */
    public void setSessionStart(final long value) {
        this.sessionStart = value;
    }

    /**
     * Return open session time.
     *
     * @return a long with the timestamp.
     */
    public long getSessionTime() {
        return sessionTime;
    }

    /**
     * Set the session time.
     *
     * @param value a long with the timestamp.
     */
    public void setSessionTime(final long value) {
        this.sessionTime = value;
    }

    /**
     * Set Session IP.
     *
     * @return a String with the IP.
     */
    public String getSessionIp() {
        return sessionIp;
    }

    /**
     * Set Clients ip.
     *
     * @param value a String with the IP.
     */
    public void setSessionIp(final String value) {
        this.sessionIp = value;
    }

    /**
     * Returns the Client's Browser.
     *
     * @return a String with the Browser type.
     */
    public String getSessionBrowser() {
        return sessionBrowser;
    }

    /**
     * Set Browser type.
     *
     * @param value a String with the Browser type.
     */
    public void setSessionBrowser(final String value) {
        this.sessionBrowser = value;
    }

    /**
     * Return current session page.
     *
     * @return a String with the Page.
     */
    public String getSessionPage() {
        return sessionPage;
    }

    /**
     * Set Current viewing page.
     *
     * @param value a String with the page.
     */
    public void setSessionPage(final String value) {
        this.sessionPage = value;
    }

    /**
     * Return true if the user will be visible online.
     *
     * @return a boolean with the value.
     */
    public boolean isViewOnline() {
        return viewOnline;
    }

    /**
     * Set's if user will be visible online.
     *
     * @param value a boolean value.
     */
    public void setViewOnline(final boolean value) {
        this.viewOnline = value;
    }

    /**
     * Return true for autologin enabled.
     *
     * @return a boolean with the autologin value.
     */
    public boolean isAutoLogin() {
        return autoLogin;
    }

    /**
     * Set true for autologin.
     *
     * @param value a boolean value.
     */
    public void setAutoLogin(final boolean value) {
        this.autoLogin = value;
    }

    /**
     * Return true if the user is admin.
     *
     * @return true if user is admin.
     */
    public boolean isAdmin() {
        return admin;
    }

    /**
     * Define if the current user is an administrator.
     *
     * @param value a boolean value.
     */
    public void setAdmin(final boolean value) {
        this.admin = value;
    }

    @Override
    public String toString() {
        return "ForumSessions{" +
                "sessionId='" + sessionId + '\'' +
                ", user=" + user.getUserId() +
                ", forumId=" + forumId +
                ", lastVisit=" + lastVisit +
                ", sessionStart=" + sessionStart +
                ", sessionTime=" + sessionTime +
                ", sessionIp='" + sessionIp + '\'' +
                ", sessionBrowser='" + sessionBrowser + '\'' +
                ", sessionPage='" + sessionPage + '\'' +
                ", viewOnline=" + viewOnline +
                ", autoLogin=" + autoLogin +
                ", admin=" + admin +
                '}';
    }
}
