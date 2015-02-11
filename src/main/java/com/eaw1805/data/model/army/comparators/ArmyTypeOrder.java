package com.eaw1805.data.model.army.comparators;

import com.eaw1805.data.model.army.ArmyType;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Used to sort army types based on type (In,Ca,Ar,CC,...) and ID.
 */
public class ArmyTypeOrder
        implements Comparator<ArmyType>, Serializable {

    /**
     * For serialization purposes.
     */
    static final long serialVersionUID = -338756993124229948L;

    /**
     * Compares its two arguments for order.  Returns a negative integer,
     * zero, or a positive integer as the first argument is less than, equal
     * to, or greater than the second.<p>
     * In the foregoing description, the notation
     * <tt>sgn(</tt><i>expression</i><tt>)</tt> designates the mathematical
     * <i>signum</i> function, which is defined to return one of <tt>-1</tt>,
     * <tt>0</tt>, or <tt>1</tt> according to whether the value of
     * <i>expression</i> is negative, zero or positive.<p>
     * The implementor must ensure that <tt>sgn(compare(x, y)) ==
     * -sgn(compare(y, x))</tt> for all <tt>x</tt> and <tt>y</tt>.  (This
     * implies that <tt>compare(x, y)</tt> must throw an exception if and only
     * if <tt>compare(y, x)</tt> throws an exception.)<p>
     * The implementor must also ensure that the relation is transitive:
     * <tt>((compare(x, y)&gt;0) &amp;&amp; (compare(y, z)&gt;0))</tt> implies
     * <tt>compare(x, z)&gt;0</tt>.<p>
     * Finally, the implementor must ensure that <tt>compare(x, y)==0</tt>
     * implies that <tt>sgn(compare(x, z))==sgn(compare(y, z))</tt> for all
     * <tt>z</tt>.<p>
     * It is generally the case, but <i>not</i> strictly required that
     * <tt>(compare(x, y)==0) == (x.equals(y))</tt>.  Generally speaking,
     * any comparator that violates this condition should clearly indicate
     * this fact.  The recommended language is "Note: this comparator
     * imposes orderings that are inconsistent with equals."
     *
     * @param armyType1 the first object to be compared.
     * @param armyType2 the second object to be compared.
     * @return a negative integer, zero, or a positive integer as the
     *         first argument is less than, equal to, or greater than the
     *         second.
     * @throws ClassCastException if the arguments' types prevent them from
     *                            being compared by this comparator.
     */
    @Override
    public int compare(final ArmyType armyType1, final ArmyType armyType2) {
        int comparison = 0;
        // First check type.
        final int aTypeId1 = getTypeOrder(armyType1.getType());
        final int aTypeId2 = getTypeOrder(armyType2.getType());

        if (aTypeId1 < aTypeId2) {
            comparison = -1;

        } else if (aTypeId1 > aTypeId2) {
            comparison = 1;

        } else {
            // Then check id.
            if (armyType1.getIntId() < armyType2.getIntId()) {
                comparison = -1;

            } else if (armyType1.getIntId() > armyType2.getIntId()) {
                comparison = 1;
            }
        }

        return comparison;
    }

    public int getTypeOrder(final String type) {
        if (type.equals("In")) {
            return 1;

        } else if (type.equals("Ca")) {
            return 2;

        } else if (type.equals("Ar")) {
            return 3;

        } else if (type.equals("Kt")) {
            return 4;

        }
        return 5;
    }
}
