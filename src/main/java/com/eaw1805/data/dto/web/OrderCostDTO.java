package com.eaw1805.data.dto.web;


import com.eaw1805.data.constants.GoodConstants;

import java.io.Serializable;

/**
 * Class that contains information about the cost of an order.
 */
public class OrderCostDTO implements
        com.google.gwt.user.client.rpc.IsSerializable, GoodConstants, Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD

    /**
     * An array that contains the costs in goods of
     * a given command
     */
    private int[] costs = new int[GOOD_LAST + 1];

    /**
     * Empty constructor that initializes all costs to zero
     */
    public OrderCostDTO() {
        super();
        for (int i = GOOD_FIRST; i < GOOD_LAST; i++) {
            costs[i] = 0;
        }
    }

    /**
     * Method that gets cost of the good
     *
     * @param good is any value in GoodConstants
     * @return the cost of the good
     */
    public int getNumericCost(final int good) {
        if (good >= GOOD_FIRST && good <= GOOD_LAST) {
            return costs[good];
        } else {
            return -1;
        }
    }

    /**
     * Method that sets cost of the good
     *
     * @param good     is any value in GoodConstants
     * @param quantity is the quantity of the good
     */
    public void setNumericCost(final int good, final int quantity) {
        if (good >= GOOD_FIRST && good <= GOOD_LAST) {
            costs[good] = quantity;
        }
    }

    public String convertToString() {
        StringBuilder out = new StringBuilder();
        for (int i = GOOD_FIRST; i < GOOD_LAST; i++) {
            out.append("!").append(i).append(":").append(costs[i]);
        }
        return out.toString().substring(1);
    }

}