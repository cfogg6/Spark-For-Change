package com.sparkforchange.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nancy on 01/27/2018.
 */

public class Charity extends Loginable {
    private String description;
    private List<SparkDonation> donationHistory;
    private List<Company> companiesSponsoring;
    private String website;

    Charity(String email, String password, String name, String website) {
        super(email, password, name);
        donationHistory = new ArrayList<>();
        companiesSponsoring = new ArrayList<>();
        this.website = website;
    }

    public List<SparkDonation> getDonationHistory() {
        return donationHistory;
    }

    public int getRaisedSparks() {
        int raised = 0;
        for (SparkDonation donation : donationHistory) {
            raised += donation.getSparkNum();
        }
        return raised;
    }

    public List<Company> getCompaniesSponsoring() {
        return companiesSponsoring;
    }

    public String getDescription() {
        return description;
    }

    public String getWebsite() { return website; }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addDonation(SparkDonation donation) {
        donationHistory.add(donation);
    }

    public void addCompany(Company c) {
        companiesSponsoring.add(c);
    }
}
