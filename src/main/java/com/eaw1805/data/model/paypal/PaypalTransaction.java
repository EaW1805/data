package com.eaw1805.data.model.paypal;

import com.eaw1805.data.model.PaymentHistory;

import java.io.Serializable;

/**
 * Implements the Paypal Transaction.
 */
public class PaypalTransaction implements Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD

    /**
     * Unique ID.
     */
    private int id;

    /**
     * The payer.
     */
    private PaypalUserProfile payer;

    /**
     * The associated payment history object..
     */
    private PaymentHistory pmHistory;

    /**
     * The corellation ID.
     */
    private String corellationId;

    /**
     * Paypal Unique Transaction ID.
     */
    private String transactionId;

    /**
     * Transaction TimeStamp.
     */
    private String timestamp;

    /**
     * Transaction Type.
     */
    private String transactionType;

    /**
     * Payment Type.
     */
    private String paymentType;

    /**
     * Gross Amount.
     */
    private double grossAmount;

    /**
     * Item Description.
     */
    private String item;

    /**
     * Payment Status Code.
     */
    private String paymentStatusCode;

    /**
     * Pending status Code.
     */
    private String pendingStatusCode;

    /**
     * Payer Note.
     */
    private String payerNote;

    /**
     * Payer name.
     */
    private String payerName;

    /**
     * Payer address.
     */
    private String payerAddress;

    /**
     * Payer postal city.
     */
    private String payerCity;

    /**
     * Payer postal code.
     */
    private String payerPOCode;

    /**
     * Payer postal country.
     */
    private String payerCountry;

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public PaypalUserProfile getPayer() {
        return payer;
    }

    public void setPayer(final PaypalUserProfile payer) {
        this.payer = payer;
    }

    public String getCorellationId() {
        return corellationId;
    }

    public void setCorellationId(final String corellationId) {
        this.corellationId = corellationId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(final String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(final String timestamp) {
        this.timestamp = timestamp;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(final String transactionType) {
        this.transactionType = transactionType;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(final String paymentType) {
        this.paymentType = paymentType;
    }

    public double getGrossAmount() {
        return grossAmount;
    }

    public void setGrossAmount(final double grossAmount) {
        this.grossAmount = grossAmount;
    }

    public String getItem() {
        return item;
    }

    public void setItem(final String item) {
        this.item = item;
    }

    public String getPaymentStatusCode() {
        return paymentStatusCode;
    }

    public void setPaymentStatusCode(final String paymentStatusCode) {
        this.paymentStatusCode = paymentStatusCode;
    }

    public String getPendingStatusCode() {
        return pendingStatusCode;
    }

    public void setPendingStatusCode(final String pendingStatusCode) {
        this.pendingStatusCode = pendingStatusCode;
    }

    public String getPayerNote() {
        return payerNote;
    }

    public void setPayerNote(final String value) {
        this.payerNote = value;
    }

    public PaymentHistory getPmHistory() {
        return pmHistory;
    }

    public void setPmHistory(final PaymentHistory value) {
        this.pmHistory = value;
    }

    /**
     * Get the Payer's name.
     * @return the Payer's name.
     */
    public String getPayerName() {
        return payerName;
    }

    /**
     * Set the Payer's name.
     * @param value the Payer's name.
     */
    public void setPayerName(final String value) {
        this.payerName = value;
    }

    /**
     * Get the Payer's address.
     * @return the Payer's address.
     */
    public String getPayerAddress() {
        return payerAddress;
    }

    /**
     * Set the Payer's address.
     * @param value the Payer's address.
     */
    public void setPayerAddress(final String value) {
        this.payerAddress = value;
    }

    /**
     * Get the payer's city.
     * @return the payer's city.
     */
    public String getPayerCity() {
        return payerCity;
    }

    /**
     * Set the payer's city.
     * @param value the payer's city.
     */
    public void setPayerCity(final String value) {
        this.payerCity = value;
    }

    /**
     * Get the Payer's postal office code.
     * @return the Payer's postal office code.
     */
    public String getPayerPOCode() {
        return payerPOCode;
    }

    /**
     * Set the Payer's postal office code.
     * @param value the Payer's postal office code.
     */
    public void setPayerPOCode(final String value) {
        this.payerPOCode = value;
    }

    /**
     * Get the Payer's country.
     * @return the Payer's country.
     */
    public String getPayerCountry() {
        return payerCountry;
    }

    /**
     * Set the Payer's country.
     * @param value the Payer's country.
     */
    public void setPayerCountry(final String value) {
        this.payerCountry = value;
    }
}
