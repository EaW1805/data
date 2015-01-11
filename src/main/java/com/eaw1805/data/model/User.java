package com.eaw1805.data.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Locale;

/**
 * Implements a serializable user.
 */
public class User implements Serializable {

    /**
     * Required by Serializable interface.
     */
    private static final long serialVersionUID = 4123178053064040031L;

    /**
     * the identity of the account.
     */
    private int userId;

    /**
     * The identity of the account, if it is a facebook account.
     */
    private String facebookId;

    /**
     * The current access token for facebook.
     */
    private String facebookAccessToken;

    /**
     * The user type.
     * 0: Regular.
     * 1: Inactive.
     * 2: Ignore.
     * 3: Founder.
     */
    private int userType;

    /**
     * A hash with the user permissions.
     */
    private String userPermissions;

    /**
     * The username of the account.
     */
    private String username;

    /**
     * The password of the account.
     */
    private String password;

    /**
     * The full name of the user.
     */
    private String fullname;

    /**
     * The email of the user.
     */
    private String email;

    /**
     * The email of the user encoded (MD5).
     */
    private String emailEncoded;

    /**
     * The location of the user.
     */
    private String location;

    /**
     * The timezone of the user.
     */
    private double timezone;

    /**
     * The date the user joined.
     */
    private long dateJoin;

    /**
     * The remote address/IP of the user.
     */
    private String remoteAddress;

    /**
     * Users access token for twitter.
     */
    private String twitterAccessToken;

    /**
     * Users secret for twitter.
     */
    private String twitterSecret;

    private int creditFree;

    private int creditTransferred;

    private int creditBought;

    /**
     * The Facebook status.
     * 0: No Connection.
     * 1: Connected.
     * 2: Liked.
     * 3: Shared / Complete.
     */
    private int facebookStatus;

    /**
     * The Twitter status.
     * 0: No Connection.
     * 1: Connected.
     * 2: Followed.
     * 3: Shared / Complete.
     */
    private int twitterStatus;

    /**
     * Defines if the user will receive Newsletter or Notifications.
     */
    private Boolean enableNotifications;

    /**
     * Defines if users mail is public.
     */
    private Boolean publicMail;

    /**
     * Defines the users inbox thread size.
     */
    private Integer inboxThreadSize;

    /**
     * Defines the users last visit.
     */
    private long userLastVisit;

    /**
     * Defines the users last IP used.
     */
    private String userLastIP;

    /**
     * The html the user added to his profile.
     */
    private String profileHtml;

    /**
     * A unique id to give access to the questionnaire page.
     */
    private String questionnaireUUID;

    /**
     * Last date a game got processed for this user.
     */
    private Date lastProcDate;

    /**
     * The language the user uses for the website and emails.
     */
    private String language;

    /**
     * The date indicates the time the user got deleted.
     *
     * If null it means the user is not deleted.
     */
    private Date deletionDate;

    /**
     * An indicator if a help email has already been sent to this user.
     */
    private boolean helpSent;

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
     * Get the user type.
     *
     * @return the user type.
     */
    public int getUserType() {
        return userType;
    }

    /**
     * Set the user type.
     *
     * @param value the user type.
     */
    public void setUserType(final int value) {
        this.userType = value;
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

    /**
     * Get the email of the user.
     *
     * @return the email of the user.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the email of the user.
     *
     * @param value the email of the user.
     */
    public void setEmail(final String value) {
        this.email = value;
    }

    /**
     * Get the email of the user encoded (MD5).
     *
     * @return the email of the user encoded (MD5).
     */
    public String getEmailEncoded() {
        return emailEncoded;
    }

    /**
     * Set the email of the user encoded (MD5).
     *
     * @param value the email of the user encoded (MD5).
     */
    public void setEmailEncoded(final String value) {
        this.emailEncoded = value;
    }

    /**
     * Get the full name of the user.
     *
     * @return the full name of the user.
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * Set the full name of the user.
     *
     * @param value the full name of the user.
     */
    public void setFullname(final String value) {
        this.fullname = value;
    }

    /**
     * Get the location of the user.
     *
     * @return the location of the user.
     */
    public String getLocation() {
        return location;
    }

    /**
     * Set the location of the user.
     *
     * @param value the location of the user.
     */
    public void setLocation(final String value) {
        this.location = value;
    }

    /**
     * Get the date the user joined.
     *
     * @return the date the user joined.
     */
    public long getDateJoin() {
        return dateJoin;
    }

    /**
     * Set the date the user joined.
     *
     * @param value the date the user joined.
     */
    public void setDateJoin(final long value) {
        dateJoin = value;
    }

    /**
     * Get the remote address/IP of the user.
     *
     * @return the remote address/IP of the user.
     */
    public String getRemoteAddress() {
        return remoteAddress;
    }

    /**
     * Set the remote address/IP of the user.
     *
     * @param value the remote address/IP of the user.
     */
    public void setRemoteAddress(final String value) {
        this.remoteAddress = value;
    }

    public String getTwitterAccessToken() {
        return twitterAccessToken;
    }

    public void setTwitterAccessToken(final String twitterAccessToken) {
        this.twitterAccessToken = twitterAccessToken;
    }

    public String getTwitterSecret() {
        return twitterSecret;
    }

    public void setTwitterSecret(final String twitterSecret) {
        this.twitterSecret = twitterSecret;
    }

    public int getCreditFree() {
        return creditFree;
    }

    public void setCreditFree(final int creditFree) {
        this.creditFree = creditFree;
    }

    public int getCreditTransferred() {
        return creditTransferred;
    }

    public void setCreditTransferred(final int creditTransferred) {
        this.creditTransferred = creditTransferred;
    }

    public int getCreditBought() {
        return creditBought;
    }

    public void setCreditBought(final int creditBought) {
        this.creditBought = creditBought;
    }

    /**
     * Return true if notifications are enabled.
     *
     * @return a boolean
     */
    public Boolean getEnableNotifications() {
        return enableNotifications;
    }

    /**
     * Set true if the user will receive notifications.
     *
     * @param enableNotifications the boolean
     */
    public void setEnableNotifications(final Boolean enableNotifications) {
        this.enableNotifications = enableNotifications;
    }

    /**
     * Returns true if user mail is public.
     *
     * @return a boolean
     */
    public Boolean getPublicMail() {
        return publicMail;
    }

    /**
     * Set true if the mail is public.
     *
     * @param publicMail a boolean, true if mail is public.
     */
    public void setPublicMail(final Boolean publicMail) {
        this.publicMail = publicMail;
    }

    /**
     * Returns the users inbox thread size.
     *
     * @return an int with the size.
     */
    public Integer getInboxThreadSize() {
        return inboxThreadSize;
    }

    /**
     * Return the String with the user permissions.
     *
     * @return a String containing the hash value.
     */
    public String getUserPermissions() {
        return userPermissions;
    }

    /**
     * Set the hash value with the user's permissions.
     *
     * @param value a String cotaining the hash
     */
    public void setUserPermissions(final String value) {
        this.userPermissions = value;
    }

    public int getFacebookStatus() {
        return facebookStatus;
    }

    public void setFacebookStatus(final int value) {
        this.facebookStatus = value;
    }

    public int getTwitterStatus() {
        return twitterStatus;
    }

    public void setTwitterStatus(final int value) {
        this.twitterStatus = value;
    }

    /**
     * Sets the inbox thread size.
     *
     * @param inboxThreadSize an int with the size.
     */
    public void setInboxThreadSize(final Integer inboxThreadSize) {
        this.inboxThreadSize = inboxThreadSize;
    }

    /**
     * Get the timezone of the user.
     *
     * @return the timezone of the user.
     */
    public double getTimezone() {
        return timezone;
    }

    /**
     * Set the timezone of the user.
     *
     * @param value the timezone of the user.
     */
    public void setTimezone(final double value) {
        timezone = value;
    }

    /**
     * Return a long with the timestamp of the user's last visit.
     *
     * @return a long with the timestamp.
     */
    public long getUserLastVisit() {
        return userLastVisit;
    }

    /**
     * Get the users last IP used.
     *
     * @return the users last IP used.
     */
    public String getUserLastIP() {
        return userLastIP;
    }

    /**
     * Set the users last IP used.
     *
     * @param value the users last IP used.
     */
    public void setUserLastIP(final String value) {
        this.userLastIP = value;
    }

    /**
     * Get the html code the user wrote for his profile.
     *
     * @return The profile html code.
     */
    public String getProfileHtml() {
        return profileHtml;
    }

    /**
     * Set the profile html code the user wrote for his profile.
     *
     * @param value The value to set.
     */
    public void setProfileHtml(final String value) {
        this.profileHtml = value;
    }


    public String getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }

    public String getFacebookAccessToken() {
        return facebookAccessToken;
    }

    public void setFacebookAccessToken(String facebookAccessToken) {
        this.facebookAccessToken = facebookAccessToken;
    }

    public String getQuestionnaireUUID() {
        return questionnaireUUID;
    }

    public void setQuestionnaireUUID(String questionnaireUUID) {
        this.questionnaireUUID = questionnaireUUID;
    }

    /**
     * Get last processing date.
     *
     * @return The last processing date.
     */
    public Date getLastProcDate() {
        return lastProcDate;
    }

    /**
     * Set last processing date.
     *
     * @param value The value to set.
     */
    public void setLastProcDate(final Date value) {
        this.lastProcDate = value;
    }

    /**
     * Get the language the user uses.
     *
     * @return The language the user wants to use.
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Set the language the user wants to use.
     *
     * @param value The value to set.
     */
    public void setLanguage(final String value) {
        this.language = value;
    }

    /**
     * Get users locale.
     *
     * @return The locale for this user.
     */
    public Locale getLocale() {
        if (language == null) {
            //if no language is specified, use default.
            return Locale.US;
        } else if (language.equals("English")) {
            //if english is specified use english.
            return Locale.US;
        } else if (language.equals("Ελληνικά")) {
            //if greek is specified, use greek.
            return new Locale("el", "GR");
        }
        //if nothing understandable is specified, use default.
        return Locale.US;
    }

    /**
     * Get the date the user got deleted.
     *
     * @return The date the user got deleted.
     */
    public Date getDeletionDate() {
        return deletionDate;
    }

    /**
     * Set the date the user got deleted.
     *
     * @param value The date the user got deleted.
     */
    public void setDeletionDate(final Date value) {
        this.deletionDate = value;
    }

    /**
     * Set the timestamp of the user's last visit.
     *
     * @param value a long with the timestamp.
     */
    public void setUserLastVisit(final long value) {
        this.userLastVisit = value;
    }

    /**
     * Get if help email has been sent to this user.
     *
     * @return True if help email has been sent to this user.
     */
    public boolean isHelpSent() {
        return helpSent;
    }

    /**
     * Set if help email has been sent to this user.
     *
     * @param value The value to set.
     */
    public void setHelpSent(final boolean value) {
        this.helpSent = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userId != user.userId) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        return result;
    }
}

