package com.sparkforchange.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nancy on 01/27/2018.
 */

public class Company extends Loginable {
    private String link;
    private List<Charity> charityList;
    private List<Block> donationsList;

    Company(String email, String password, String name, String link) {
        super(email, password, name);
        this.link = link;
        charityList = new ArrayList<>();
        donationsList = new ArrayList<>();
    }

    public void addDonation(Block donation) {
        donationsList.add(donation);
    }

    public void addCharity(Charity charity) {
        charityList.add(charity);
    }

    public List<Charity> getCharityList() {
        return charityList;
    }

    public List<Block> getDonationsList() {
        return donationsList;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
