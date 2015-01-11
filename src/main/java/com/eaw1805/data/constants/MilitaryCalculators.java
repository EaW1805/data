package com.eaw1805.data.constants;

import com.eaw1805.data.model.map.Region;

/**
 * Contains all the calculations for the military units.
 */
public class MilitaryCalculators
        implements RegionConstants {

    public static int getTransitDistance(final int comRegionId, final int unitRegionId) {
        int distance = 1;
        switch (comRegionId) {
            case EUROPE:

                switch (unitRegionId) {
                    case EUROPE:
                        distance = 0;
                        break;

                    case AFRICA:
                        distance = 1;
                        break;

                    case INDIES:
                        distance = 2;
                        break;

                    case CARIBBEAN:
                    default:
                        distance = 2;
                        break;
                }

                break;

            case AFRICA:
                switch (unitRegionId) {
                    case EUROPE:
                        distance = 1;
                        break;

                    case AFRICA:
                        distance = 0;
                        break;

                    case INDIES:
                        distance = 1;
                        break;

                    case CARIBBEAN:
                    default:
                        distance = 1;
                        break;
                }
                break;

            case INDIES:
                switch (unitRegionId) {
                    case EUROPE:
                        distance = 2;
                        break;

                    case AFRICA:
                        distance = 1;
                        break;

                    case INDIES:
                        distance = 0;
                        break;

                    case CARIBBEAN:
                    default:
                        distance = 1;
                        break;
                }
                break;

            case CARIBBEAN:
            default:
                switch (unitRegionId) {
                    case EUROPE:
                        distance = 2;
                        break;

                    case AFRICA:
                        distance = 1;
                        break;

                    case INDIES:
                        distance = 1;
                        break;

                    case CARIBBEAN:
                    default:
                        distance = 0;
                        break;
                }
                break;
        }

        return distance + 1;
    }

}
