package com.eaw1805.data.dto.web;

import com.eaw1805.data.constants.OrderConstants;

import java.io.Serializable;

/**
 * Class that contains information about the cost of an order.
 */
public class ClientOrderDTO
        implements OrderConstants, Comparable<ClientOrderDTO>, com.google.gwt.user.client.rpc.IsSerializable, Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD

    /**
     * Integer indicating the order type as
     * defined in OrderConstants
     */
    private int orderTypeId;

    /**
     * Integer the target object identifier
     */
    private int[] identifiers = new int[9];

    /**
     * Integer that defines priority of the
     * order
     */
    private int priority;

    /**
     * Integer describing the region where the order was placed
     */
    private int regionId = 1;

    /**
     * DTO that consists of data for all goods
     * and their corresponding quantities
     */
    private OrderCostDTO costs = new OrderCostDTO();

    /**
     * String describing the order
     */
    private String name;

    /**
     * comment to provide more information when needed...
     */
    private String comment;

    /**
     * Basic empty constructor
     */
    public ClientOrderDTO() {
        super();
        name = "";
        for (int i = 0; i < 9; i++) {
            identifiers[0] = 0;
        }
    }

    /**
     * @return the costs of the order
     */
    public OrderCostDTO getCosts() {
        return costs;
    }

    /**
     * @param costs the costs to set
     */
    public void setCosts(final OrderCostDTO costs) {
        this.costs = costs;
    }

    /**
     * @return the orderTypeId as defined in OrderConstants
     */
    public int getOrderTypeId() {
        return orderTypeId;
    }

    /**
     * @param orderTypeId the orderTypeId to set
     */
    public void setOrderTypeId(final int orderTypeId) {
        this.orderTypeId = orderTypeId;
    }

    /**
     * @return the priority
     */
    public int getPriority() {
        return priority;
    }

    /**
     * @param priority the priority to set
     */
    public void setPriority(final int priority) {
        this.priority = priority;
    }

    /**
     * @param name the name to set
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }


    /**
     * @param regionId the regionId to set
     */
    public void setRegionId(final int regionId) {
        this.regionId = regionId;
    }

    /**
     * @return the regionId
     */
    public int getRegionId() {
        return regionId;
    }

    /**
     * @param ident the identifier to set.
     * @param value the value to set.
     */
    public void setIdentifier(final int ident, final int value) {
        if (ident >= 0 && ident < 9) {
            this.identifiers[ident] = value;
        }
    }

    /**
     * @param ident the index.
     * @return the identifier
     */
    public int getIdentifier(final int ident) {
        return identifiers[ident];
    }

    public int compareTo(final ClientOrderDTO other) {
        return ((Integer) priority).compareTo(other.getPriority());
    }

    public String getComment() {
        return comment;
    }

    public void setComment(final String comment) {
        this.comment = comment;
    }
}
