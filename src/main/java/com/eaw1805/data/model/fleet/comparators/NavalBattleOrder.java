package com.eaw1805.data.model.fleet.comparators;

import com.eaw1805.data.model.battles.NavalBattleReport;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Used to sort battle reports.
 */
public class NavalBattleOrder
        implements Comparator<NavalBattleReport>, Serializable {

    /**
     * For serialization purposes.
     */
    static final long serialVersionUID = -33875699324229948L;

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
     * @param report1 the first object to be compared.
     * @param report2 the second object to be compared.
     * @return a negative integer, zero, or a positive integer as the
     *         first argument is less than, equal to, or greater than the
     *         second.
     * @throws ClassCastException if the arguments' types prevent them from
     *                            being compared by this comparator.
     */
    @Override
    public int compare(final NavalBattleReport report1, final NavalBattleReport report2) {
        int comparison = 0;
        if (report1.getTurn() < report2.getTurn()) {
            comparison = 1;

        } else if (report1.getTurn() > report2.getTurn()) {
            comparison = -1;

        } else {
            // Then check id.
            if (report1.getBattleId() < report2.getBattleId()) {
                comparison = 1;

            } else if (report1.getBattleId() > report2.getBattleId()) {
                comparison = -1;
            }
        }

        return comparison;
    }

}

