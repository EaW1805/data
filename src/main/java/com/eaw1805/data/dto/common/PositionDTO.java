package com.eaw1805.data.dto.common;

import com.eaw1805.data.constants.RegionConstants;

import java.io.Serializable;

/**
 * Represents the position of an entity on the map
 */
public class PositionDTO
        implements com.google.gwt.user.client.rpc.IsSerializable, Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 20L; //NOPMD

    /**
     * The x coordinate.
     */
    private int x; // NOPMD

    /**
     * The y coordinate.
     */
    private int y;  // NOPMD

    /**
     * The x starting coordinate.
     */
    private int xStart; // NOPMD

    /**
     * The y starting coordinate.
     */
    private int yStart;  // NOPMD

    /**
     * The region id.
     */
    private int regionId;

    /**
     * Get the x coordinate.
     *
     * @return the x coordinate.
     */
    public int getX() {
        return x;
    }

    /**
     * Get the x start coordinate.
     *
     * @return the xStart coordinate.
     */
    public int getXStart() {
        return xStart;
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
     * Set the x start coordinate.
     *
     * @param xCoord the x Start coordinate.
     */
    public void setXStart(final int xCoord) {
        this.xStart = xCoord;
    }

    /**
     * Set the y start coordinate.
     *
     * @param yCoord the y Start coordinate.
     */
    public void setYStart(final int yCoord) {
        this.yStart = yCoord;
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
     * Get the y start coordinate.
     *
     * @return the YStart coordinate.
     */
    public int getYStart() {
        return yStart;
    }

    /**
     * Get the region id.
     *
     * @return the region id.
     */
    public int getRegionId() {
        return regionId;
    }

    /**
     * Set the region id.
     *
     * @param value the region id.
     */
    public void setRegionId(final int value) {
        this.regionId = value;
    }


    /**
     * Encode the position of the entity in String format.
     *
     * @return the position in the format "Rxx/yy".
     */
    public String positionToString() {
        final StringBuilder sbld = new StringBuilder();
        switch (regionId) {
            case RegionConstants.EUROPE:
                sbld.append("E");
                break;

            case RegionConstants.CARIBBEAN:
                sbld.append("C");
                break;

            case RegionConstants.INDIES:
                sbld.append("I");
                break;

            case RegionConstants.AFRICA:
                sbld.append("A");
                break;

            default:
                break;

        }

        sbld.append(x + 1);
        sbld.append("/");
        sbld.append(y + 1);
        return sbld.toString();
    }

    public String startPositionToString() {
        final StringBuilder sbld = new StringBuilder();
        switch (regionId) {
            case RegionConstants.EUROPE:
                sbld.append("E");
                break;

            case RegionConstants.CARIBBEAN:
                sbld.append("C");
                break;

            case RegionConstants.INDIES:
                sbld.append("I");
                break;

            case RegionConstants.AFRICA:
                sbld.append("A");
                break;

            default:
                break;

        }

        sbld.append(xStart + 1);
        sbld.append("/");
        sbld.append(yStart + 1);
        return sbld.toString();
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

        if (!(obj instanceof PositionDTO)) {
            return false;
        }

        final PositionDTO position = (PositionDTO) obj;

        if (x != position.x) {
            return false;
        }

        if (y != position.y) {
            return false;
        }

        if (regionId != position.regionId) {
            return false;
        }

        return true;
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
    public boolean equalsStart(final Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof PositionDTO)) {
            return false;
        }

        final PositionDTO position = (PositionDTO) obj;

        if (xStart != position.xStart) {
            return false;
        }

        if (yStart != position.yStart) {
            return false;
        }

        if (regionId != position.regionId) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 310 * result + y;
        result = 310 * result + xStart;
        result = 310 * result + yStart;
        result = 310 * result + regionId;
        return result;
    }
}

