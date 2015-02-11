package com.eaw1805.data.model.map;

import com.eaw1805.data.model.Game;

import java.io.Serializable;

/**
 * Models the position on a game's regional map.
 */
public class Position
        implements Cloneable, Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD

    /**
     * The x coordinate.
     */
    private int x; // NOPMD

    /**
     * The y coordinate.
     */
    private int y;  // NOPMD

    /**
     * The region of the coordinate.
     */
    private Region region;

    /**
     * The game of the map.
     */
    private Game game;

    /**
     * Keep track of a random number for ordering purposes. Does not persist to the db.
     */
    private int randomOrder;

    /**
     * Default constructor.
     */
    public Position() {
        // Empty constructor
    }

    /**
     * Get the x coordinate.
     *
     * @return the x coordinate.
     */
    public int getX() {
        return x;
    }

    /**
     * Set the x coordinate.
     *
     * @param xCoord the x coordinate.
     */
    public void setX(final int xCoord) {
        this.x = xCoord;
    }

    /**
     * Set the y coordinate.
     *
     * @param yCoord the y coordinate.
     */
    public void setY(final int yCoord) {
        this.y = yCoord;
    }

    /**
     * Get the y coordinate.
     *
     * @return the y coordinate.
     */
    public int getY() {
        return y;
    }

    /**
     * Get the region of the position.
     *
     * @return the region of the position.
     */
    public Region getRegion() {
        return region;
    }

    /**
     * Set the region of the position.
     *
     * @param thisRegion the region of the position.
     */
    public void setRegion(final Region thisRegion) {
        this.region = thisRegion;
    }

    /**
     * Get the game of the position.
     *
     * @return the game of the position.
     */
    public Game getGame() {
        return game;
    }

    /**
     * Set the game of the position.
     *
     * @param thisGame the game of the position.
     */
    public void setGame(final Game thisGame) {
        this.game = thisGame;
    }

    /**
     * Get the random number for ordering purposes. Does not persist to the db.
     *
     * @return the random number for ordering purposes. Does not persist to the db.
     */
    public int getRandomOrder() {
        return randomOrder;
    }

    /**
     * Set the random number for ordering purposes. Does not persist to the db.
     *
     * @param value the random number for ordering purposes. Does not persist to the db.
     */
    public void setRandomOrder(final int value) {
        this.randomOrder = value;
    }

    /**
     * Calculate the euclidean distance from another position.
     *
     * @param thatPos the position to calculate the distance from.
     * @return the euclidean distance.
     */
    public double distance(final Position thatPos) {
        return Math.sqrt((getX() - thatPos.getX()) * (getX() - thatPos.getX()) + (getY() - thatPos.getY()) * (getY() - thatPos.getY()));
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     * The <code>equals</code> method implements an equivalence relation
     * on non-null object references:
     * <ul>
     * <li>It is <i>reflexive</i>: for any non-null reference value
     * <code>x</code>, <code>x.equals(x)</code> should return
     * <code>true</code>.
     * <li>It is <i>symmetric</i>: for any non-null reference values
     * <code>x</code> and <code>y</code>, <code>x.equals(y)</code>
     * should return <code>true</code> if and only if
     * <code>y.equals(x)</code> returns <code>true</code>.
     * <li>It is <i>transitive</i>: for any non-null reference values
     * <code>x</code>, <code>y</code>, and <code>z</code>, if
     * <code>x.equals(y)</code> returns <code>true</code> and
     * <code>y.equals(z)</code> returns <code>true</code>, then
     * <code>x.equals(z)</code> should return <code>true</code>.
     * <li>It is <i>consistent</i>: for any non-null reference values
     * <code>x</code> and <code>y</code>, multiple invocations of
     * <tt>x.equals(y)</tt> consistently return <code>true</code>
     * or consistently return <code>false</code>, provided no
     * information used in <code>equals</code> comparisons on the
     * objects is modified.
     * <li>For any non-null reference value <code>x</code>,
     * <code>x.equals(null)</code> should return <code>false</code>.
     * </ul>
     * The <tt>equals</tt> method for class <code>Object</code> implements
     * the most discriminating possible equivalence relation on objects;
     * that is, for any non-null reference values <code>x</code> and
     * <code>y</code>, this method returns <code>true</code> if and only
     * if <code>x</code> and <code>y</code> refer to the same object
     * (<code>x == y</code> has the value <code>true</code>).
     * Note that it is generally necessary to override the <tt>hashCode</tt>
     * method whenever this method is overridden, so as to maintain the
     * general contract for the <tt>hashCode</tt> method, which states
     * that equal objects must have equal hash codes.
     *
     * @param obj the reference object with which to compare.
     * @return <code>true</code> if this object is the same as the obj
     *         argument; <code>false</code> otherwise.
     * @see #hashCode()
     * @see java.util.Hashtable
     */
    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Position)) {
            return false;
        }

        final Position position = (Position) obj;

        if (!game.equals(position.game)) {
            return false;
        }

        if (!region.equals(position.region)) {
            return false;
        }

        if (x != position.x) {
            return false;
        }
        if (y != position.y) {
            return false;
        }

        return true;
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
        int result = x;
        result = 310 * result + y;
        result = 310 * result + (region != null ? region.hashCode() : 0);
        result = 310 * result + (game != null ? game.hashCode() : 0);
        return result;
    }

    /**
     * Creates and returns a copy of this object.  The precise meaning
     * of "copy" may depend on the class of the object. The general
     * intent is that, for any object <tt>x</tt>, the expression:
     * <blockquote>
     * <pre>
     * x.clone() != x</pre></blockquote>
     * will be true, and that the expression:
     * <blockquote>
     * <pre>
     * x.clone().getClass() == x.getClass()</pre></blockquote>
     * will be <tt>true</tt>, but these are not absolute requirements.
     * While it is typically the case that:
     * <blockquote>
     * <pre>
     * x.clone().equals(x)</pre></blockquote>
     * will be <tt>true</tt>, this is not an absolute requirement.
     *
     * By convention, the returned object should be obtained by calling
     * <tt>super.clone</tt>.  If a class and all of its superclasses (except
     * <tt>Object</tt>) obey this convention, it will be the case that
     * <tt>x.clone().getClass() == x.getClass()</tt>.
     *
     * By convention, the object returned by this method should be independent
     * of this object (which is being cloned).  To achieve this independence,
     * it may be necessary to modify one or more fields of the object returned
     * by <tt>super.clone</tt> before returning it.  Typically, this means
     * copying any mutable objects that comprise the internal "deep structure"
     * of the object being cloned and replacing the references to these
     * objects with references to the copies.  If a class contains only
     * primitive fields or references to immutable objects, then it is usually
     * the case that no fields in the object returned by <tt>super.clone</tt>
     * need to be modified.
     *
     * The method <tt>clone</tt> for class <tt>Object</tt> performs a
     * specific cloning operation. First, if the class of this object does
     * not implement the interface <tt>Cloneable</tt>, then a
     * <tt>CloneNotSupportedException</tt> is thrown. Note that all arrays
     * are considered to implement the interface <tt>Cloneable</tt>.
     * Otherwise, this method creates a new instance of the class of this
     * object and initializes all its fields with exactly the contents of
     * the corresponding fields of this object, as if by assignment; the
     * contents of the fields are not themselves cloned. Thus, this method
     * performs a "shallow copy" of this object, not a "deep copy" operation.
     *
     * The class <tt>Object</tt> does not itself implement the interface
     * <tt>Cloneable</tt>, so calling the <tt>clone</tt> method on an object
     * whose class is <tt>Object</tt> will result in throwing an
     * exception at run time.
     *
     * @return a clone of this instance.
     * @see java.lang.Cloneable
     */
    @Override
    public Object clone() { //NOPMD
        final Position newObj = new Position();
        newObj.setRegion(getRegion());
        newObj.setGame(getGame());
        newObj.setX(getX());
        newObj.setY(getY());
        return newObj;
    }

    @Override
    public String toString() {
        final StringBuilder sbld = new StringBuilder();
        sbld.append(region.toString());
        sbld.append(x + 1);
        sbld.append("/");
        sbld.append(y + 1);
        return sbld.toString();
    }
}
