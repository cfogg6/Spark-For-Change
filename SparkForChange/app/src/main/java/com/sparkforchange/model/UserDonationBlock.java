package com.sparkforchange.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Nancy on 01/27/2018.
 */

public class UserDonationBlock {
    private double donationAmount;
    private int sparkNum;
    private String date;
    private Charity charity;
    private User user;

    public UserDonationBlock(double donationAmount, Charity charity, User user) {
        this.donationAmount = donationAmount;
        this.sparkNum = Facade.getInstance().dollarsToSparks(donationAmount);
        this.charity = charity;
        this.user = user;

        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        this.date = df.format(c.getTime());
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

    public String getDate() {
        return date;
    }
}
