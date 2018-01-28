package com.sparkforchange.model;

/**
 * Created by Nancy on 01/27/2018.
 */

public class UserDonationBlock {
    private double donationAmount;
    private int sparkNum;
    private Charity charity;
    private User user;

    public UserDonationBlock(double donationAmount, int sparkNum, Charity charity, User user) {
        this.donationAmount = donationAmount;
        this.sparkNum = Facade.getInstance().dollarsToSparks(donationAmount);
        this.charity = charity;
        this.user = user;
    }

    public double getDonationAmount() {
        return donationAmount;
    }

    public int getSparkNum() {
        return sparkNum;
    }

    public Charity getCharity() {
        return charity;
    }

    public User getUser() {
        return user;
    }
}
