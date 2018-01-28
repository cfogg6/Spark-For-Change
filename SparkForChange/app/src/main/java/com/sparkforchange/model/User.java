package com.sparkforchange.model;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by Nancy on 01/27/2018.
 */

public class User extends Loginable {
    private int sparkBalance;
    private int sparkLifetimeTotal;
    private List<SparkDonation> sparkTransactions;
    private List<VolunteerHourBlock> hourHistory;
    private List<UserDonationBlock> donationHistory;
    private Set<Group> groups;

    // payment info
    private String paymentName;
    private String address;
    private String creditCard;
    private String cvv;
    private String expDate;

    User(String email, String password, String name) {
        super(email, password, name);
        sparkBalance = 0;
        sparkLifetimeTotal = 0;
        sparkTransactions = new LinkedList<>();
        hourHistory = new LinkedList<>();
        donationHistory = new LinkedList<>();
        groups = new HashSet<>();
    }

    public void addGroup(Group group) {
        groups.add(group);
    }

    public void removeGroup(Group group) {
        groups.remove(group);
    }

    public List<SparkDonation> getSparkTransactions() {
        return sparkTransactions;
    }

    public void addSparkTransaction(SparkDonation transaction) {
        sparkTransactions.add(transaction);
        sparkBalance -= transaction.getSparkNum();
    }

    public List<VolunteerHourBlock> getHourHistory() {
        return hourHistory;
    }

    public List<UserDonationBlock> getDonationHistory() {
        return donationHistory;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public int getSparkBalance() {
        return sparkBalance;
    }

    public int getSparkLifetimeTotal() {
        return sparkLifetimeTotal;
    }

    public void addSparks(int newSparks) {
        sparkBalance += newSparks;
        if (newSparks > 0) {
            sparkLifetimeTotal += newSparks;
        }
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getPaymentName() {
        return paymentName;
    }

    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }
}
