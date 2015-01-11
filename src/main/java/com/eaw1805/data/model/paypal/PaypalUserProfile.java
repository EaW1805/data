package com.eaw1805.data.model.paypal;

import com.eaw1805.data.model.User;

import java.io.Serializable;

/**
 * Implements the Paypal User Profile.
 */
public class PaypalUserProfile implements Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD

    /**
     * The Paypal User Profile unique ID.
     */
    private int id;

    /**
     * The user.
     */
    private User user;

    /**
     * Paypal User ID.
     */
    private String payerID;

    /**
     * Paypal User.
     */
    private String payer;

    /**
     * User Status.
     */
    private String payerStatus;

    /**
     * Salutation.
     */
    private String salutation;

    /**
     * First Name.
     */
    private String firstName;

    /**
     * Middle Name.
     */
    private String middleName;

    /**
     * Last Name.
     */
    private String lastName;

    /**
     * Suffix.
     */
    private String suffix;

    /**
     * Country Code Type.
     */
    private String countryCodeType ;

    /**
     * Address Name.
     */
    private String name;

    /**
     * Street 1.
     */
    private String street1;

    /**
     * Street 2.
     */
    private String street2;

    /**
     * Cityname.
     */
    private String cityName;

    /**
     * State or Province
     */
    private String stateOrProvince;

    /**
     * Country Name.
     */
    private String countryName;

    /**
     * Phone.
     */
    private String phone;

    /**
     * Postal code.
     */
    private String postalCode;

    /**
     * Address Status.
     */
    private String addressStatus;

    public User getUser() {
        return user;
    }

    public void setUser(final User value) {
        this.user = value;
    }

    public String getPayerID() {
        return payerID;
    }

    public void setPayerID(final String value) {
        this.payerID = value;
    }

    public String getPayer() {
        return payer;
    }

    public void setPayer(final String value) {
        this.payer = value;
    }

    public String getPayerStatus() {
        return payerStatus;
    }

    public void setPayerStatus(final String value) {
        this.payerStatus = value;
    }

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(final String value) {
        this.salutation = value;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String value) {
        this.firstName = value;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(final String value) {
        this.middleName = value;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String value) {
        this.lastName = value;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(final String value) {
        this.suffix = value;
    }

    public String getCountryCodeType() {
        return countryCodeType;
    }

    public void setCountryCodeType(final String value) {
        this.countryCodeType = value;
    }

    public String getName() {
        return name;
    }

    public void setName(final String value) {
        this.name = value;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(final String value) {
        this.street1 = value;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(final String value) {
        this.street2 = value;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(final String value) {
        this.cityName = value;
    }

    public String getStateOrProvince() {
        return stateOrProvince;
    }

    public void setStateOrProvince(final String value) {
        this.stateOrProvince = value;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(final String value) {
        this.countryName = value;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(final String value) {
        this.phone = value;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(final String value) {
        this.postalCode = value;
    }

    public String getAddressStatus() {
        return addressStatus;
    }

    public void setAddressStatus(final String value) {
        this.addressStatus = value;
    }

    public int getId() {
        return id;
    }

    public void setId(final int value) {
        this.id = value;
    }
}
