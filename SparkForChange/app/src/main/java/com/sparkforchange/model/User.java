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
    private List<Block> transactions;
    private Set<Group> groups;

    User(String email, String password, String name) {
        super(email, password, name);
        sparkBalance = 0;
        transactions = new LinkedList<>();
        groups = new HashSet<>();
    }

    public void addGroup(Group group) {
        groups.add(group);
    }

    public void removeGroup(Group group) {
        groups.remove(group);
    }

    public int getSparkBalance() {
        return sparkBalance;
    }

    public void setSparkBalance(int sparkBalance) {
        this.sparkBalance = sparkBalance;
    }

    public List<Block> getTransactions() {
        return transactions;
    }

    public void addTransaction(Block b) {
        this.transactions.add(b);
    }

}
