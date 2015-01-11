package com.eaw1805.data.dto.web;

import java.io.Serializable;

public class OrderPositionDTO
        implements com.google.gwt.user.client.rpc.IsSerializable, Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD

    private int orderType, position;
    private String parameter1, parameter2, parameter3, parameter4;

    public OrderPositionDTO() {
        super();
    }

    /**
     * @return the orderId
     */
    public int getOrderType() {
        return orderType;
    }

    /**
     * @return the position
     */
    public int getPosition() {
        return position;
    }

    /**
     * @param orderType the orderId to set
     */
    public void setOrderType(final int orderType) {
        this.orderType = orderType;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(final int position) {
        this.position = position;
    }

    /**
     * @return the parameter1
     */
    public String getParameter1() {
        return parameter1;
    }

    /**
     * @return the parameter2
     */
    public String getParameter2() {
        return parameter2;
    }

    /**
     * @return the parameter3
     */
    public String getParameter3() {
        return parameter3;
    }

    /**
     * @param parameter1 the parameter1 to set
     */
    public void setParameter1(final String parameter1) {
        this.parameter1 = parameter1;
    }

    /**
     * @param parameter2 the parameter2 to set
     */
    public void setParameter2(final String parameter2) {
        this.parameter2 = parameter2;
    }

    /**
     * @param parameter3 the parameter3 to set
     */
    public void setParameter3(final String parameter3) {
        this.parameter3 = parameter3;
    }

    /**
     * @return The parameter4
     */
    public String getParameter4() {
        return parameter4;
    }

    /**
     * @param parameter4 The parameter4 to set.
     */
    public void setParameter4(String parameter4) {
        this.parameter4 = parameter4;
    }
}
