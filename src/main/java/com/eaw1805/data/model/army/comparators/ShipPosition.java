package com.eaw1805.data.model.army.comparators;

import com.eaw1805.data.model.Game;
import com.eaw1805.data.model.fleet.Ship;
import com.eaw1805.data.model.map.comparators.PositionComparator;

import java.util.Comparator;
import java.util.Random;

/**
 * Used to sort ships based on their distance from the nearest trade city if in Europe, otherwise randomly if in the
 * colonies.
 */
public class ShipPosition
        extends PositionComparator
        implements Comparator<Ship> {

    /**
     * Default Constructor.
     *
     * @param thisGame  the game to sort.
     * @param generator the random number generator.
     */
    public ShipPosition(final Game thisGame, final Random generator) {
        super(thisGame, generator);
    }

    /**
     * Compares its two arguments for order.  Returns a negative integer,
     * zero, or a positive integer as the first argument is less than, equal
     * to, or greater than the second.<p>
     * <p/>
     * In the foregoing description, the notation
     * <tt>sgn(</tt><i>expression</i><tt>)</tt> designates the mathematical
     * <i>signum</i> function, which is defined to return one of <tt>-1</tt>,
     * <tt>0</tt>, or <tt>1</tt> according to whether the value of
     * <i>expression</i> is negative, zero or positive.<p>
     * <p/>
     * The implementor must ensure that <tt>sgn(compare(x, y)) ==
     * -sgn(compare(y, x))</tt> for all <tt>x</tt> and <tt>y</tt>.  (This
     * implies that <tt>compare(x, y)</tt> must throw an exception if and only
     * if <tt>compare(y, x)</tt> throws an exception.)<p>
     * <p/>
     * The implementor must also ensure that the relation is transitive:
     * <tt>((compare(x, y)&gt;0) &amp;&amp; (compare(y, z)&gt;0))</tt> implies
     * <tt>compare(x, z)&gt;0</tt>.<p>
     * <p/>
     * Finally, the implementor must ensure that <tt>compare(x, y)==0</tt>
     * implies that <tt>sgn(compare(x, z))==sgn(compare(y, z))</tt> for all
     * <tt>z</tt>.<p>
     * <p/>
     * It is generally the case, but <i>not</i> strictly required that
     * <tt>(compare(x, y)==0) == (x.equals(y))</tt>.  Generally speaking,
     * any comparator that violates this condition should clearly indicate
     * this fact.  The recommended language is "Note: this comparator
     * imposes orderings that are inconsistent with equals."
     *
     * @param brig1 the first object to be compared.
     * @param brig2 the second object to be compared.
     * @return a negative integer, zero, or a positive integer as the
     *         first argument is less than, equal to, or greater than the
     *         second.
     * @throws ClassCastException if the arguments' types prevent them from
     *                            being compared by this comparator.
     */
    @Override
    public int compare(final Ship brig1, final Ship brig2) {
        return comparePositions(brig1.getPosition(), brig2.getPosition(), brig1.getNation(), brig2.getNation());
    }

}