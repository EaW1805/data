package com.eaw1805.data.model;

import java.io.Serializable;

/**
 * Used to capture the interest of users in following a game.
 */
public class WatchGame implements Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD

    /**
     * The unique id.
     */
    private int watchGameId;

    /**
     * The game the user plays in.
     */
    private Game game;

    /**
     * The user who plays.
     */
    private int userId;

    public int getWatchGameId() {
        return watchGameId;
    }

    public void setWatchGameId(int watchGameId) {
        this.watchGameId = watchGameId;
    }

    /**
     * Get the game.
     *
     * @return The game.
     */
    public Game getGame() {
        return game;
    }

    /**
     * Set the game.
     *
     * @param game The value to set.
     */
    public void setGame(final Game game) {
        this.game = game;
    }

    /**
     * Get the user.
     *
     * @return The user.
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Set the user.
     *
     * @param value The user to set.
     */
    public void setUserId(final int value) {
        this.userId = value;
    }

    /**
     * Returns a hash code value for the object. This method is
     * supported for the benefit of hashtables such as those provided by
     * <code>java.util.Hashtable</code>.
     * The general contract of <code>hashCode</code> is:
     * <ul>
     * <li>Whenever it is invoked on the same object more than once during
     * an execution of a Java application, the <tt>hashCode</tt> method
     * must consistently return the same integer, provided no information
     * used in <tt>equals</tt> comparisons on the object is modified.
     * This integer need not remain consistent from one execution of an
     * application to another execution of the same application.
     * <li>If two objects are equal according to the <tt>equals(Object)</tt>
     * method, then calling the <code>hashCode</code> method on each of
     * the two objects must produce the same integer result.
     * <li>It is <em>not</em> required that if two objects are unequal
     * according to the {@link java.lang.Object#equals(java.lang.Object)}
     * method, then calling the <tt>hashCode</tt> method on each of the
     * two objects must produce distinct integer results.  However, the
     * programmer should be aware that producing distinct integer results
     * for unequal objects may improve the performance of hashtables.
     * </ul>
     * As much as is reasonably practical, the hashCode method defined by
     * class <tt>Object</tt> does return distinct integers for distinct
     * objects. (This is typically implemented by converting the internal
     * address of the object into an integer, but this implementation
     * technique is not required by the
     * Java<font size="-2"><sup>TM</sup></font> programming language.)
     *
     * @return a hash code value for this object.
     * @see java.lang.Object#equals(java.lang.Object)
     * @see java.util.Hashtable
     */
    @Override
    public int hashCode() {
        return getGame().hashCode();
    }

}
