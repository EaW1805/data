package com.eaw1805.data.constants;

/**
 * Contains all the calculations for the trade.
 */
public class TradeCalculations
        implements GoodConstants, TradeConstants, RegionConstants {

    /**
     * Method that returns monetary cost of a good bought in a trade city.
     *
     * @param goodFactor    the factor of the good.
     * @param goodRate      the rating of the good.
     * @param quantity      the quantity to buy.
     * @param isMerchantile true for merchantile nations.
     * @param isDeficit     true if deficit random event is in effect.
     * @param isSurplus     true if surplus random event is in effect.
     * @return monetary cost.
     */
    public static int getBuyGoodCost(final int goodFactor,
                                     final double goodRate,
                                     final int quantity,
                                     final boolean isMerchantile,
                                     final boolean isDeficit,
                                     final boolean isSurplus) {
        // old bug -- avoid negative good rates
        double thisRate = goodRate;
        if (thisRate < TRADE_EES) {
            thisRate = TRADE_EES;
        }

        double money = (goodFactor + ((thisRate - 3d) / 8d) ) * thisRate * (quantity + Math.sqrt(quantity) / 2d) * 53d;

        // Merchantile Trait
        if (isMerchantile) {
            money *= 0.95d;
        }

        // Selling in that trade city, increases profits by 20%. Buying from that trade city, costs 20% more.
        if (isDeficit) {
            money *= 1.2d;
        }

        // Selling in that trade city, reduces profits by 20%. Buying from that trade city, costs 20% less.
        if (isSurplus) {
            money *= 0.8d;
        }

        return (int) money;
    }

    /**
     * Method that returns monetary cost of a good sold in a trade city.
     *
     * @param goodFactor    the factor of the good.
     * @param goodRate      the rating of the good.
     * @param quantity      the quantity to sell.
     * @param isMerchantile true for merchantile nations
     * @param isDeficit     true if deficit random event is in effect.
     * @param isSurplus     true if surplus random event is in effect.
     * @return monetary cost.
     */
    public static int getSellGoodCost(final int goodFactor,
                                      final double goodRate,
                                      final int quantity,
                                      final boolean isMerchantile,
                                      final boolean isDeficit,
                                      final boolean isSurplus) {
        // old bug -- avoid negative good rates
        double thisRate = goodRate;
        if (thisRate < TRADE_EES) {
            thisRate = TRADE_EES;
        }

        double money = (goodFactor + ((thisRate - 3d) / 8d) ) * thisRate * (quantity + Math.sqrt(quantity) / 5d) * 15d;

        // Merchantile Trait
        if (isMerchantile) {
            money *= 1.05d;
        }

        // Selling in that trade city, increases profits by 20%. Buying from that trade city, costs 20% more.
        if (isDeficit) {
            money *= 1.2d;
        }

        // Selling in that trade city, reduces profits by 20%. Buying from that trade city, costs 20% less.
        if (isSurplus) {
            money *= 0.8d;
        }

        return (int) money;
    }

    /**
     * Method that returns monetary cost of a good sold in a trade city.
     *
     * @param goodFactor    the factor of the good.
     * @param goodRate      the rating of the good.
     * @param wealth        the available money.
     * @param isMerchantile true for merchantile nations
     * @param isDeficit     true if deficit random event is in effect.
     * @param isSurplus     true if surplus random event is in effect.
     * @param isFirst       true if this is the first player to trade with this city.
     * @return monetary cost.
     */
    public static int getMaxSellQTE(final int goodFactor,
                                    final double goodRate,
                                    final double wealth,
                                    final boolean isMerchantile,
                                    final boolean isDeficit,
                                    final boolean isSurplus,
                                    final boolean isFirst) {

        // old bug -- avoid negative good rates
        double thisRate = goodRate;
        if (thisRate < TRADE_EES) {
            thisRate = TRADE_EES;
        }

        // Determine maximum city wealth
        double actualWealth;
        if (isFirst) {
            // The 1st player to trade, can sell up to 100% of city wealth
            actualWealth = wealth;

        } else {
            // All other trades after the 1st transaction can sell up to 50% of the city wealth.
            actualWealth = wealth * 0.5d;
        }

        // Merchantile Trait
        if (isMerchantile) {
            actualWealth *= 1.05d;
        }

        // Selling in that trade city, increases profits by 20%. Buying from that trade city, costs 20% more.
        if (isDeficit) {
            actualWealth *= 1.2d;
        }

        // Selling in that trade city, reduces profits by 20%. Buying from that trade city, costs 20% less.
        if (isSurplus) {
            actualWealth *= 0.8d;
        }

        // Determine maximum quantity
        actualWealth /= goodFactor;
        actualWealth /= thisRate;
        actualWealth /= 15d;

        final double beta = -(2d * actualWealth + 1d / 25d);
        final double gamma = actualWealth * actualWealth;

        final double x1 = (-beta + Math.sqrt(beta * beta - 4d * gamma)) / 2d;
        final double x2 = (-beta - Math.sqrt(beta * beta - 4d * gamma)) / 2d;

        if (x1 < 0) {
            return (int) x2;

        } else if (x2 < 0) {
            return (int) x1;

        } else {
            return (int) Math.min(Math.floor(x1), Math.floor(x2));
        }
    }

    /**
     * Method that returns monetary cost of a good bought in a trade city.
     *
     * @param goodID        the good type.
     * @param goodFactor    the factor of the good.
     * @param goodRate      the rating of the good.
     * @param wealth        the money available.
     * @param isMerchantile true for merchantile nations
     * @param isDeficit     true if deficit random event is in effect.
     * @param isSurplus     true if surplus random event is in effect.
     * @param isFirst       true if this is the first player to trade with this city.
     * @return monetary cost.
     */
    public static int getMaxBuyQTE(final int goodID,
                                   final int goodFactor,
                                   final double goodRate,
                                   final double wealth,
                                   final boolean isMerchantile,
                                   final boolean isDeficit,
                                   final boolean isSurplus,
                                   final boolean isFirst) {

        // old bug -- avoid negative good rates
        double thisRate = goodRate;
        if (thisRate < TRADE_EES) {
            thisRate = TRADE_EES;
        }

        // Determine maximum city wealth
        double actualWealth;
        switch (goodID) {
            // Common Goods
            case GOOD_INPT:
            case GOOD_FOOD:
            case GOOD_STONE:
            case GOOD_WOOD:
            case GOOD_HORSE:
            case GOOD_WOOL:
                if (isFirst) {
                    // The 1st player to trade, can buy up to 50% of city wealth
                    actualWealth = wealth * 0.5d;

                } else {
                    // All the remaining players after the first can buy up to 20% of city wealth
                    actualWealth = wealth * 0.2d;
                }
                break;

            case GOOD_FABRIC:
            case GOOD_WINE:
            case GOOD_COLONIAL:
            case GOOD_ORE:
            case GOOD_GEMS:
            case GOOD_PRECIOUS:
                if (isFirst) {
                    // The 1st player to trade, can buy up to 25% of city wealth
                    actualWealth = wealth * 0.25d;

                } else {
                    // All the remaining players after the first, can buy up to 10% of city wealth
                    actualWealth = wealth * 0.2d;
                }
                break;

            default:
                // This is when we want to find max QTE for a give value
                actualWealth = wealth;
        }

        // Merchantile Trait
        if (isMerchantile) {
            actualWealth *= 1.05d;
        }

        // Selling in that trade city, increases profits by 20%. Buying from that trade city, costs 20% more.
        if (isDeficit) {
            actualWealth *= 1.2d;
        }

        // Selling in that trade city, reduces profits by 20%. Buying from that trade city, costs 20% less.
        if (isSurplus) {
            actualWealth *= 0.8d;
        }

        // Determine maximum quantity
        actualWealth /= goodFactor;
        actualWealth /= thisRate;
        actualWealth /= 54d;

        final double beta = -(2d * actualWealth + 0.25d);
        final double gamma = actualWealth * actualWealth;

        final double x1 = (-beta + Math.sqrt(beta * beta - 4d * gamma)) / 2d;
        final double x2 = (-beta - Math.sqrt(beta * beta - 4d * gamma)) / 2d;

        //double money = goodFactor * thisRate * (quantity + Math.sqrt(quantity) / 2) * 70d;
        if (x1 < 0) {
            return (int) x2;

        } else if (x2 < 0) {
            return (int) x1;

        } else {
            return (int) Math.min(Math.floor(x1), Math.floor(x2));
        }
    }

    /**
     * Determine if there is a change to the trading rate of the particular good when trading in this city.
     *
     * @param cityName  the city name.
     * @param goodId    the good type.
     * @param tradeRate the trading rate of the particular good.
     * @return the modified trade rate.
     */
    public static double determineBuyTradeRate(final String cityName, final int goodId, final double tradeRate) {
        double goodRate = tradeRate;

        // Special Trade Cities Traits
        if (("London".equals(cityName) && goodId == GOOD_FABRIC)
                || ("Munich".equals(cityName) && goodId == GOOD_HORSE)
                || ("Petersburg".equals(cityName) && goodId == GOOD_WOOD)
                || ("Madrid".equals(cityName) && goodId == GOOD_WINE)
                || ("Lisbon".equals(cityName) && goodId == GOOD_WINE)
                || ("Rome".equals(cityName) && goodId == GOOD_WINE)) {
            goodRate--;
        }

        // Minimums and maximums of 1 and 5 are never exceeded.
        if (goodRate < TRADE_ES) {
            goodRate = TRADE_ES;

        } else if (goodRate > TRADE_EHD) {
            goodRate = TRADE_EHD;
        }

        return goodRate;
    }

    /**
     * Determine if there is a change to the trading rate of the particular good when trading in this city.
     *
     * @param regionId  the region of the city.
     * @param cityName  the city name.
     * @param goodId    the good type.
     * @param tradeRate the trading rate of the particular good.
     * @return the modified trade rate.
     */
    public static double determineSellTradeRate(final int regionId, final String cityName, final int goodId, final double tradeRate) {
        double goodRate = tradeRate;

        // Special Trade Cities Traits
        if (regionId != EUROPE && goodId == GOOD_COLONIAL) {
            goodRate--;
        }

        // Special Trade Cities Traits
        if (regionId == EUROPE && goodId == GOOD_COLONIAL) {
            goodRate++;
        }

        // Special Trade Cities Traits (continued)
        if ((regionId != EUROPE && goodId == GOOD_INPT)
                || ("Copenhagen".equals(cityName) && goodId == GOOD_FOOD)
                || ("Stockholm".equals(cityName) && goodId == GOOD_FOOD)
                || ("Constantinople".equals(cityName) && goodId == GOOD_WOOL)
                || ("Rabat".equals(cityName) && goodId == GOOD_WOOL)
                || ("Vienna".equals(cityName) && goodId == GOOD_PRECIOUS)
                || ("Amsterdam".equals(cityName) && goodId == GOOD_GEMS)
                || ("Moscow".equals(cityName) && goodId == GOOD_STONE)) {
            goodRate++;
        }

        // Minimums and maximums of 1 and 5 are never exceeded.
        if (goodRate < TRADE_EES) {
            goodRate = TRADE_EES;

        } else if (goodRate > TRADE_EHD) {
            goodRate = TRADE_EHD;
        }

        return goodRate;
    }

}
