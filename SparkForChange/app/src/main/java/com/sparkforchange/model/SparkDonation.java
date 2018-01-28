package com.sparkforchange.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Nancy on 01/27/2018.
 */

public class SparkDonation {
    private int sparkNum;
    private String date;
    private Charity charity;
    private Company company;
    private User user;

    public SparkDonation(int sparkNum, Charity charity, Company company, User user) {
        this.sparkNum = sparkNum;
        this.charity = charity;
        this.company = company;
        this.user = user;

        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        this.date = df.format(c.getTime());
    }

    public int getSparkNum() {
        return sparkNum;
    }

    public Charity getCharity() {
        return charity;
    }

    public Company getCompany() {
        return company;
    }

    public User getUser() {
        return user;
    }

    public String getDate() {
        return date;
    }
}
