package com.eaw1805.data.constants;

import com.eaw1805.data.dto.web.army.BattalionDTO;
import com.eaw1805.data.dto.web.army.BrigadeDTO;
import com.eaw1805.data.model.army.Battalion;
import com.eaw1805.data.model.army.Brigade;

public final class WeightCalculators
        implements ArmyConstants {

    /**
     * Method that returns the weight of a battalion
     *
     * @param battalion the battalion whose weight we want
     * @return the weight in tons of the battalion
     */
    public static int getBattalionWeight(final Battalion battalion) {
        double unitWeight;
        if (battalion.getType().isInfantry() || battalion.getType().isEngineer()) {
            unitWeight = 200d;

        } else if (battalion.getType().isCavalry()) {
            unitWeight = 400d;

        } else {
            unitWeight = 600d;
        }

        return (int) ((battalion.getHeadcount() * unitWeight) / 1000d);
    }

    /**
     * Method that returns the weight of a battalion
     *
     * @param battalion the battalion whose weight we want
     * @return the weight in tons of the battalion
     */
    public static int getBattalionWeight(final BattalionDTO battalion) {
        double unitWeight;
        if (battalion.getEmpireArmyType().isInfantry() || battalion.getEmpireArmyType().isEngineer()) {
            unitWeight = 200d;

        } else if (battalion.getEmpireArmyType().isCavalry()) {
            unitWeight = 400d;

        } else {
            unitWeight = 600d;
        }

        return (int) ((battalion.getHeadcount() * unitWeight) / 1000d);
    }

    /**
     * Method that returns the weight of a brigade
     *
     * @param brigade the brigade whose weight we want
     * @return the weight in tons of the brigade
     */
    public static int getBrigadeWeight(final BrigadeDTO brigade) {
        if (brigade == null) {
            return 0;
        }
        int weight = 0;
        for (final BattalionDTO battalion : brigade.getBattalions()) {
            weight += getBattalionWeight(battalion);
        }
        return weight;
    }

    /**
     * Method that returns the weight of a brigade
     *
     * @param brigade the brigade whose weight we want
     * @return the weight in tons of the brigade
     */
    public static int getBrigadeWeight(final Brigade brigade) {
        if (brigade == null) {
            return 0;
        }

        int weight = 0;
        for (final Battalion battalion : brigade.getBattalions()) {
            weight += getBattalionWeight(battalion);
        }
        return weight;
    }

    /**
     * Method that returns the weight of a brigade
     *
     * @param brigade the brigade whose weight we want
     * @return the weight in tons of the brigade
     */
    public static int getLightestBattalion(final Brigade brigade) {
        if (brigade == null) {
            return 0;
        }

        int weight = Integer.MAX_VALUE;
        for (final Battalion battalion : brigade.getBattalions()) {
            weight = java.lang.Math.min(weight, getBattalionWeight(battalion));
        }

        return weight;
    }

}
