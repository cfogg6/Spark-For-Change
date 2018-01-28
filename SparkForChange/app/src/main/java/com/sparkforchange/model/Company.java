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

    Company(String email, String password, String name, String link) {
        super(email, password, name);
        this.link = link;
        this.sparkBalance = 0;
        charityList = new ArrayList<>();
        donationsList = new ArrayList<>();
    }

    public void addDonation(SparkDonation donation) {
        donationsList.add(donation);
        sparkBalance += donation.getSparkNum();
    }

    public void addCharity(Charity charity) {
        charityList.add(charity);
    }

    public List<Charity> getCharityList() {
        return charityList;
    }

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
