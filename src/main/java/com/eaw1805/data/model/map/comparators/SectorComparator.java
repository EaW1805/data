package com.eaw1805.data.model.map.comparators;

import com.eaw1805.data.model.Game;
import com.eaw1805.data.model.map.Sector;

import java.util.Comparator;
import java.util.Random;

/**
 * Used to sort sectors in 3 phases (Home, Sphere, Outside) then sorted by distance from nearest TRADE CITY.
 */
public class SectorComparator
        extends PositionComparator
        implements Comparator<Sector> {

    /**
     * Default Constructor.
     *
     * @param thisGame  the game to sort.
     * @param generator the random number generator.
     */
    public SectorComparator(final Game thisGame, final Random generator) {
        super(thisGame, generator);
    }

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
     * @param sector1 the first object to be compared.
     * @param sector2 the second object to be compared.
     * @return a negative integer, zero, or a positive integer as the
     *         first argument is less than, equal to, or greater than the
     *         second.
     * @throws ClassCastException if the arguments' types prevent them from
     *                            being compared by this comparator.
     */
    public int compare(final Sector sector1, final Sector sector2) {
        int comparison;
        final int sphere1 = getSphere(sector1);
        final int sphere2 = getSphere(sector2);

        if (sphere1 != sphere2) {
            comparison = Integer.valueOf(sphere1).compareTo(Integer.valueOf(sphere2));

        } else {
            comparison = comparePositions(sector1.getPosition(), sector2.getPosition(), sector1.getNation(), sector2.getNation());
        }

        return comparison;
    }

    /**
     * Identify if sector is a home region, inside sphere of influence, or outside.
     *
     * @param sector the sector to examine.
     * @return 1 if home region, 2 if in sphere of influence, 3 if outside.
     */
    private int getSphere(final Sector sector) {
        if (sector == null || String.valueOf(sector.getPoliticalSphere()).length() == 0) {
            return 3;
        }

        final char thisNationCodeLower = String.valueOf(sector.getNation().getCode()).toLowerCase().charAt(0);
        final char thisSectorCodeLower = String.valueOf(sector.getPoliticalSphere()).toLowerCase().charAt(0);
        int sphere = 1;

        // Check if this is not home region
        if (thisNationCodeLower != thisSectorCodeLower) {
            sphere = 2;

            final char thisNationCode = String.valueOf(sector.getNation().getCode()).toLowerCase().charAt(0);

            // Check if this is outside sphere of influence
            if (sector.getNation().getSphereOfInfluence().toLowerCase().indexOf(thisNationCode) < 0) {
                sphere = 3;
            }
        }

        return sphere;
    }

}
