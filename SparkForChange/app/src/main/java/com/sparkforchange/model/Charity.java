package com.sparkforchange.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nancy on 01/27/2018.
 */

public class Charity extends Loginable {
    private String description;
    private List<Block> donationHistory;
    private List<Company> companiesSponsoring;

    Charity(String email, String password, String name) {
        super(email, password, name);
        donationHistory = new ArrayList<>();
        companiesSponsoring = new ArrayList<>();
    }

    public List<Block> getDonationHistory() {
        return donationHistory;
    }

    public List<Company> getCompaniesSponsoring() {
        return companiesSponsoring;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addDonation(Block donation) {
        donationHistory.add(donation);
    }

    public void addCompany(Company c) {
        companiesSponsoring.add(c);
    }
}
