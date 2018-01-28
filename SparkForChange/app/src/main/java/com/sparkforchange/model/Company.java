package com.sparkforchange.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nancy on 01/27/2018.
 */

public class Company extends Loginable {
    private String link;
    private int sparkBalance;
    private List<Charity> charityList;
    private List<SparkDonation> donationsList;
    private String description;
    private List<User> employees;

    Company(String email, String password, String name, String link, String description) {
        super(email, password, name);
        this.link = link;
        this.sparkBalance = 0;
        charityList = new ArrayList<>();
        donationsList = new ArrayList<>();
        this.description = description;
    }

    public void addDonation(SparkDonation donation) {
        donationsList.add(donation);
        sparkBalance += donation.getSparkNum();
    }

    public void addCharity(Charity charity) {
        charityList.add(charity);
    }

    public void addEmployee(User user) { employees.add(user);}

    public void removeEmployee(User user) { employees.remove(user);}

    public int getEmployeeSparks() {
        int sparks = 0;
        for (User emp : employees) {
            sparks += emp.getSparkBalance();
        }
        return sparks;
    }

    public String getDescription() { return description; }

    public List<Charity> getCharityList() {
        return charityList;
    }

    public int getSparkBalance() { return sparkBalance; }

    public List<SparkDonation> getDonationsList() {
        return donationsList;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
