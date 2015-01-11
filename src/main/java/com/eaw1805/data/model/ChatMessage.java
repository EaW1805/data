package com.eaw1805.data.model;

import java.io.Serializable;
import java.util.Date;

/**
 * A chat entry.
 */
public class ChatMessage implements Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD

    /**
     * Id used by hibernate.
     */
    private int chatMessageId;

    /**
     * The protocol to be used for the communication.
     */
    private String protocol;

    /**
     * The actual message.
     */
    private String message;

    /**
     * The date it sent.
     */
    private Date sentDate;

    private int sender;

    private int receiver;

    private int game;
    
    private User user;

    /**
     * Get the message id.
     *
     * @return The id.
     */
    public int getChatMessageId() {
        return chatMessageId;
    }

    /**
     * Set the message id.
     *
     * @param value The id to set.
     */
    public void setChatMessageId(final int value) {
        this.chatMessageId = value;
    }

    /**
     * Get the protocol used for this message.
     *
     * @return The protocol.
     */
    public String getProtocol() {
        return protocol;
    }

    /**
     * Set the protocol for this message.
     *
     * @param value The protocol to send.
     */
    public void setProtocol(final String value) {
        this.protocol = value;
    }

    /**
     * Get the actual string message.
     *
     * @return The message.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Set the message.
     *
     * @param value The message to set.
     */
    public void setMessage(final String value) {
        this.message = value;
    }

    /**
     * Get the date this message was sent.
     *
     * @return The date.
     */
    public Date getSentDate() {
        return sentDate;
    }

    /**
     * Set the date for this message.
     *
     * @param value The date to set.
     */
    public void setSentDate(final Date value) {
        this.sentDate = value;
    }


    public int getSender() {
        return sender;
    }

    public void setSender(final int sender) {
        this.sender = sender;
    }

    public int getReceiver() {
        return receiver;
    }

    public void setReceiver(final int receiver) {
        this.receiver = receiver;
    }

    public int getGame() {
        return game;
    }

    public void setGame(final int game) {
        this.game = game;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
