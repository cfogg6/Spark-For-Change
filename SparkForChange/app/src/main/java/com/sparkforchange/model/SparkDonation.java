package com.sparkforchange.model;

/**
 * Created by Nancy on 01/27/2018.
 */

public class SparkDonation {
    private int sparkNum;
    private Charity charity;
    private Company company;
    private User user;

    public SparkDonation(int sparkNum, Charity charity, Company company, User user) {
        this.sparkNum = sparkNum;
        this.charity = charity;
        this.company = company;
        this.user = user;
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
}
