package com.sd.org.model;

/**
 * Created by Achal on 4/4/17.
 */
public class User {

    private int userId;
    private String fName;
    private String lName;
    private String phoneNumber;
    private String email;
    private Address shippingAddress;
    private PaymentInformation paymentInformation;


    public User() {
    }

    public User(int userId, String fName, String lName, String phoneNumber, String email, Address shippingAddress, PaymentInformation paymentInformation) {

        this.userId = userId;
        this.fName = fName;
        this.lName = lName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.shippingAddress = shippingAddress;
        this.paymentInformation = paymentInformation;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public PaymentInformation getUserCreditCard() {
        return paymentInformation;
    }

    public void setUserCreditCard(PaymentInformation paymentInformation) {
        this.paymentInformation = paymentInformation;
    }
}
