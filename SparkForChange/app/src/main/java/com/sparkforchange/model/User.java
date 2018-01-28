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
}
