package com.eaw1805.data.model;

import java.io.Serializable;
import java.util.Date;

/**
 * A private message.
 */
public class Message implements Serializable {

    /**
     * Required by Serializable interface.
     */
    private static final long serialVersionUID = 6190445529301382846L;

    /**
     * The unique id of the message.
     */
    private int messageId;

    /**
     * The sender of the message.
     */
    private User sender;

    /**
     * The receiver of the message.
     */
    private User receiver;

    /**
     * The body of the message.
     */
    private String bodyMessage;

    /**
     * The subject of the message.
     */
    private String subject;

    /**
     * The timestamp when the message was sent.
     */
    private Date date;

    /**
     * The thread ID.
     */
    private int rootId;

    /**
     * If the message is read.
     */
    private boolean opened;

    /**
     * If the message is deleted by the Sender.
     */
    private boolean deletedSender;

    /**
     * If the message is deleted by the Receiver.
     */
    private boolean deletedReceiver;

    /**
     * Get the unique id of the message.
     *
     * @return the unique id of the message.
     */
    public int getMessageId() {
        return messageId;
    }

    /**
     * Set the unique id of the message.
     *
     * @param value the unique id of the message.
     */
    public void setMessageId(final int value) {
        this.messageId = value;
    }

    /**
     * Get the sender of the message.
     *
     * @return the sender of the message.
     */
    public User getSender() {
        return sender;
    }

    /**
     * Set the sender of the message.
     *
     * @param value the sender of the message.
     */
    public void setSender(final User value) {
        this.sender = value;
    }

    /**
     * Get the receiver of the message.
     *
     * @return the receiver of the message.
     */
    public User getReceiver() {
        return receiver;
    }

    /**
     * Set the receiver of the message.
     *
     * @param value the receiver of the message.
     */
    public void setReceiver(final User value) {
        this.receiver = value;
    }

    /**
     * Get the body of the message.
     *
     * @return the body of the message.
     */
    public String getBodyMessage() {
        return bodyMessage;
    }

    /**
     * Set the body of the message.
     *
     * @param value the body of the message.
     */
    public void setBodyMessage(final String value) {
        this.bodyMessage = value;
    }

    /**
     * Get the subject of the message.
     *
     * @return the subject of the message.
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Set the subject of the message.
     *
     * @param value the subject of the message.
     */
    public void setSubject(final String value) {
        this.subject = value;
    }

    /**
     * Get the date of the message.
     *
     * @return the date of the message.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Set the date of the message.
     *
     * @param value the date of the message.
     */
    public void setDate(final Date value) {
        this.date = value;
    }

    /**
     * Get the thread ID of the message.
     *
     * @return the thread ID of the message.
     */
    public int getRootId() {
        return rootId;
    }

    /**
     * Set the thread ID of the message.
     *
     * @param value the thread ID of the message.
     */
    public void setRootId(final int value) {
        this.rootId = value;
    }

    /**
     * Check if the message is read.
     *
     * @return true, if the message is read.
     */
    public boolean getOpened() {
        return opened;
    }

    /**
     * Set if the message is read.
     *
     * @param value true, if the message is read.
     */
    public void setOpened(final boolean value) {
        this.opened = value;
    }

    /**
     * Check if the message is deleted by the Receiver.
     *
     * @return true, if the message is deleted.
     */
    public boolean getDeletedReceiver() {
        return deletedReceiver;
    }

    /**
     * Set if the message is deleted by the Receiver..
     *
     * @param value true, if the message is deleted.
     */
    public void setDeletedReceiver(final boolean value) {
        deletedReceiver = value;
    }

    /**
     * Check if the message is deleted by the Sender.
     *
     * @return true, if the message is deleted.
     */
    public Object getDeletedSender() {
        return deletedSender;
    }

    /**
     * Set if the message is deleted by the Sender..
     *
     * @param value true, if the message is deleted.
     */
    public void setDeletedSender(final boolean value) {
        deletedSender = value;
    }

    @Override
    public String toString() {
        return "Message{" +
                "rootId=" + rootId +
                ", date=" + date +
                ", subject='" + subject + '\'' +
                ", messageId=" + messageId +
                '}';
    }
}
