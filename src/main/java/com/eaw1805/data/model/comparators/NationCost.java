package com.eaw1805.data.model.comparators;

import com.eaw1805.data.model.Nation;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Used to sort nations based on their cost in descending order (i.e., highest cost goes first).
 */
public class NationCost
        implements Comparator<Nation>, Serializable {

    /**
     * For serialization purposes.
     */
    static final long serialVersionUID = -37516993124229948L;

    /**
     * Compares its two arguments for order.  Returns a negative integer,
     * zero, or a positive integer as the first argument is less than, equal
     * to, or greater than the second.
     * In the foregoing description, the notation
     * <tt>sgn(</tt><i>expression</i><tt>)</tt> designates the mathematical
     * <i>signum</i> function, which is defined to return one of <tt>-1</tt>,
     * <tt>0</tt>, or <tt>1</tt> according to whether the value of
     * <i>expression</i> is negative, zero or positive.
     * The implementor must ensure that <tt>sgn(compare(x, y)) ==
     * -sgn(compare(y, x))</tt> for all <tt>x</tt> and <tt>y</tt>.  (This
     * implies that <tt>compare(x, y)</tt> must throw an exception if and only
     * if <tt>compare(y, x)</tt> throws an exception.)
     * The implementor must also ensure that the relation is transitive:
     * <tt>((compare(x, y)&gt;0) &amp;&amp; (compare(y, z)&gt;0))</tt> implies
     * <tt>compare(x, z)&gt;0</tt>.
     * Finally, the implementor must ensure that <tt>compare(x, y)==0</tt>
     * implies that <tt>sgn(compare(x, z))==sgn(compare(y, z))</tt> for all
     * <tt>z</tt>.
     * It is generally the case, but <i>not</i> strictly required that
     * <tt>(compare(x, y)==0) == (x.equals(y))</tt>.  Generally speaking,
     * any comparator that violates this condition should clearly indicate
     * this fact.  The recommended language is "Note: this comparator
     * imposes orderings that are inconsistent with equals."
     *
     * @param nat1 the first object to be compared.
     * @param nat2 the second object to be compared.
     * @return a negative integer, zero, or a positive integer as the
     *         first argument is less than, equal to, or greater than the
     *         second.
     * @throws ClassCastException if the arguments' types prevent them from
     *                            being compared by this comparator.
     */
    public int compare(final Nation nat1, final Nation nat2) {
        int comparison = 0;
        // Check cost
        if (nat1.getCost() < nat2.getCost()) {
            comparison = 1;

        } else if (nat1.getCost() > nat2.getCost()) {
            comparison = -1;

        } else {
            // Finally check id.
            if (nat1.getId() < nat2.getId()) {
                comparison = -1;
            } else {
                comparison = 1;
            }
        }
        return comparison;
    }
}
