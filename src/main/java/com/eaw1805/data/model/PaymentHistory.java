package com.eaw1805.data.model;

import java.io.Serializable;
import java.util.Date;


public class PaymentHistory implements Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD

    public static final String TYPE_SETUP = "setup";

    public static final String TYPE_SETUP_REFUND = "setupRefund";

    public static final String TYPE_TRANSFER = "transfer";

    public static final String TYPE_PROCESSING = "game";

    public static final String METHOD_PAYPAL = "paypal";

    public static final String TYPE_OFFER = "offer";

    public static final String METHOD_BANK = "bank";

    public static final String METHOD_OTHER = "other";

    private int paymentHistoryId;
    private User user;
    private Date date;
    private String method;
    private String comment;
    private String type;
    private User agent;
    private int creditBought;
    private int creditFree;
    private int creditTransferred;
    private int discount;
    private int chargeBought;
    private int chargeFree;
    private int chargeTransferred;

    public int getPaymentHistoryId() {
        return paymentHistoryId;
    }

    public void setPaymentHistoryId(final int value) {
        this.paymentHistoryId = value;
    }

    public User getUser() {
        return user;
    }

    public void setUser(final User value) {
        this.user = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(final Date value) {
        this.date = value;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(final String value) {
        this.method = value;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(final String value) {
        this.comment = value;
    }

    public String getType() {
        return type;
    }

    public void setType(final String value) {
        this.type = value;
    }

    public User getAgent() {
        return agent;
    }

    public void setAgent(final User value) {
        this.agent = value;
    }

    public int getCreditBought() {
        return creditBought;
    }

    public void setCreditBought(final int value) {
        this.creditBought = value;
    }

    public int getCreditFree() {
        return creditFree;
    }

    public void setCreditFree(final int value) {
        this.creditFree = value;
    }

    public int getCreditTransferred() {
        return creditTransferred;
    }

    public void setCreditTransferred(final int value) {
        this.creditTransferred = value;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(final int value) {
        this.discount = value;
    }

    public int getChargeBought() {
        return chargeBought;
    }

    public void setChargeBought(final int value) {
        this.chargeBought = value;
    }

    public int getChargeFree() {
        return chargeFree;
    }

    public void setChargeFree(final int value) {
        this.chargeFree = value;
    }

    public int getChargeTransferred() {
        return chargeTransferred;
    }

    public void setChargeTransferred(final int value) {
        this.chargeTransferred = value;
    }
}
