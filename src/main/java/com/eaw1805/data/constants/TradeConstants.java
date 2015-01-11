package com.eaw1805.data.constants;

/**
 * Constants related to Trade.
 */
public interface TradeConstants {

    /**
     * Extra High Demand.
     */
    int TRADE_EHD = 6;

    /**
     * High Demand.
     */
    int TRADE_HD = 5;

    /**
     * Demand.
     */
    int TRADE_D = 4;

    /**
     * Average.
     */
    int TRADE_A = 3;

    /**
     * Surplus.
     */
    int TRADE_S = 2;

    /**
     * Excessive Surplus.
     */
    int TRADE_ES = 1;

    /**
     * Extra Excessive Surplus.
     */
    double TRADE_EES = 0.5d;

    /**
     * Trade Action: No Trade.
     */
    int TRADE_NO = 0;

    /**
     * Trade Action: Buy.
     */
    int TRADE_BUY = 1;

    /**
     * Trade Action: Sell.
     */
    int TRADE_SELL = 2;

    /**
     * Good Rating Action: No Change.
     */
    int TRADE_RATE_NO = 0;

    /**
     * Good Rating Action: Increase.
     */
    int TRADE_RATE_INC = 1;

    /**
     * Good Rating Action: Decrease.
     */
    int TRADE_RATE_DEC = 2;

}
