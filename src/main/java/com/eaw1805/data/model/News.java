package com.eaw1805.data.model;

import java.io.Serializable;

/**
 * Represents news related to the game processing.
 */
public class News implements Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD

    /**
     * The identification number of the news entry.
     */
    private int newsId;

    /**
     * The game.
     */
    private com.eaw1805.data.model.Game game;

    /**
     * Nation owner.
     */
    private com.eaw1805.data.model.Nation nation;

    /**
     * Nation subject.
     */
    private com.eaw1805.data.model.Nation subject;

    /**
     * The turn the news appeared.
     */
    private int turn;

    /**
     * The type of the news entry.
     */
    private int type;

    /**
     * If this is a news reported to other nations too, the base newsId.
     */
    private int baseNewsId;

    /**
     * If the owner of the entry decided to announce it to the whole world.
     */
    private boolean announcement;

    /**
     * If the entry appears on the front page (of the user).
     */
    private boolean front;

    /**
     * If the entry appears on the public page (all user).
     */
    private boolean global;

    /**
     * The text of the announcement.
     */
    private String text;

    /**
     * Get the identification number of the news entry.
     *
     * @return the identification number of the news entry.
     */
    public int getNewsId() {
        return newsId;
    }

    /**
     * Set the identification number of the news entry.
     *
     * @param value the identification number of the news entry.
     */
    public void setNewsId(final int value) {
        this.newsId = value;
    }

    /**
     * Set the game related to this news entry.
     *
     * @return the game related to this news entry.
     */
    public Game getGame() {
        return game;
    }

    /**
     * Set the game related to this news entry.
     *
     * @param value the game related to this news entry.
     */
    public void setGame(final Game value) {
        this.game = value;
    }

    /**
     * Get the owner of the news entry.
     *
     * @return the owner of the news entry.
     */
    public Nation getNation() {
        return nation;
    }

    /**
     * Set the owner of the news entry.
     *
     * @param value the owner of the news entry.
     */
    public void setNation(final Nation value) {
        this.nation = value;
    }

    /**
     * Get the subject of the news entry.
     *
     * @return the subject of the news entry.
     */
    public Nation getSubject() {
        return subject;
    }

    /**
     * Set the subject of the news entry.
     *
     * @param value the subject of the news entry.
     */
    public void setSubject(final Nation value) {
        this.subject = value;
    }

    /**
     * Get the turn that this news entry appeared.
     *
     * @return the turn that this news entry appeared.
     */
    public int getTurn() {
        return turn;
    }

    /**
     * Set the turn that this news entry appeared.
     *
     * @param value the turn that this news entry appeared.
     */
    public void setTurn(final int value) {
        this.turn = value;
    }

    /**
     * Get the type of the news entry.
     *
     * @return the type of the news entry.
     */
    public int getType() {
        return type;
    }

    /**
     * Set the type of the news entry.
     *
     * @param value the type of the news entry.
     */
    public void setType(final int value) {
        this.type = value;
    }

    /**
     * If this is a news reported to other nations too,
     * Get the base newsId.
     *
     * @return the base newsId.
     */
    public int getBaseNewsId() {
        return baseNewsId;
    }

    /**
     * If this is a news reported to other nations too,
     * Set the base newsId.
     *
     * @param value the base newsId.
     */
    public void setBaseNewsId(final int value) {
        this.baseNewsId = value;
    }

    /**
     * Get true if this news entry is public to all the world.
     *
     * @return true if this news entry is public to all the world.
     */
    public boolean getAnnouncement() {
        return announcement;
    }

    /**
     * Set true if this news entry is public to all the world.
     *
     * @param value true if this news entry is public to all the world.
     */
    public void setAnnouncement(final boolean value) {
        this.announcement = value;
    }

    /**
     * Get the entry appears on the front page (of the user).
     *
     * @return the entry appears on the front page (of the user).
     */
    public boolean getFront() {
        return front;
    }

    /**
     * Set the entry appears on the front page (of the user).
     *
     * @param value the entry appears on the front page (of the user).
     */
    public void setFront(final boolean value) {
        this.front = value;
    }

    /**
     * Get the actual text of the news.
     *
     * @return the actual text of the news.
     */
    public String getText() {
        return text;
    }

    /**
     * Set the actual text of the news.
     *
     * @param value the actual text of the news.
     */
    public void setText(final String value) {
        this.text = value;
    }

    /**
     * Get if the entry appears on the public page (all user).
     *
     * @return if the entry appears on the public page (all user).
     */
    public boolean getGlobal() {
        return global;
    }

    /**
     * Set if the entry appears on the public page (all user).
     *
     * @param value if the entry appears on the public page (all user).
     */
    public void setGlobal(final boolean value) {
        this.global = value;
    }

    @Override
    public boolean equals(Object entry) {
        if (this == entry) {
            return true;
        }
        if (entry == null || getClass() != entry.getClass()) {
            return false;
        }

        final News news = (News) entry;

        if (newsId != news.newsId) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return newsId;
    }
}
