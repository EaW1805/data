package com.eaw1805.data.dto.web;

import org.apache.commons.lang3.StringEscapeUtils;

import java.io.Serializable;

/**
 * Chat Message DTO.
 */
public class ChatMessageDTO implements Serializable {

    private static final long serialVersionUID = -3757271242482308962L;

    /**
     * User id.
     */
    private int userId = -1;

    /**
     * Game id.
     */
    private int gameId = -1;

    /**
     * Nation Id.
     */
    private int nationId = -1;

    /**
     * The message content.
     */
    private String message = "";

    /**
     * Author.
     */
    private String author = "";

    /**
     * User's encoded email.
     */
    private String encodedEmail = "";

    /**
     * Username.
     */
    private String username = "";

    /**
     * Message timestamp.
     */
    private long time = 0;

    /**
     * Returns the users encoded email address.
     *
     * @return the encoded email address.
     */
    public String getEncodedEmail() {
        return encodedEmail;
    }

    /**
     * Set user's encoded email address.
     *
     * @param value a String with the encoded email.
     */
    public void setEncodedEmail(final String value) {
        this.encodedEmail = value;
    }

    /**
     * Returns message timestamp.
     *
     * @return the timestamp.
     */
    public long getTime() {
        return time;
    }

    /**
     * Set message timestamp.
     *
     * @param value the timestamp.
     */
    public void setTime(final long value) {
        this.time = value;
    }

    /**
     * Returns the content of the message.
     *
     * @return A String with the message.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Set the content of the message.
     *
     * @param value the content message.
     */
    public void setMessage(final String value) {
        this.message = value;
    }

    /**
     * Returns Game id.
     *
     * @return the game id.,
     */
    public int getGameId() {
        return gameId;
    }

    /**
     * Set game id.
     *
     * @param value an int with game id,
     */
    public void setGameId(final int value) {
        this.gameId = value;
    }

    /**
     * Returns nation id.
     *
     * @return an int with nation id.
     */
    public int getNationId() {
        return nationId;
    }

    /**
     * Set nation id.
     *
     * @param value an int with the nation id.
     */
    public void setNationId(final int value) {
        this.nationId = value;
    }

    /**
     * Returns the author username.
     *
     * @return a string with the username.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Set author's name.
     *
     * @param value a String with the Authors username.
     */
    public void setAuthor(final String value) {
        this.author = value;
    }

    /**
     * Return a String with the username.
     *
     * @return a String with the username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set Username.
     *
     * @param value a String with the username
     */
    public void setUsername(final String value) {
        this.username = value;
    }

    /**
     * Return user id.
     *
     * @return an int with user id.
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Set user id.
     *
     * @param value an int with user id.
     */
    public void setUserId(final int value) {
        this.userId = value;
    }

    public void escapeMessage() {
        message = StringEscapeUtils.escapeHtml4(message);
    }

    @Override
    public String toString() {
        return "Data{" +
                "userId=" + userId +
                ", gameId=" + gameId +
                ", nationId=" + nationId +
                ", message='" + message + '\'' +
                ", author='" + author + '\'' +
                ", encodedEmail='" + encodedEmail + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
