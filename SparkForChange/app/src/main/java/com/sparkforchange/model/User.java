package com.sparkforchange.model;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Nancy on 01/27/2018.
 */

public class User extends Loginable {
    private int sparkBalance;
    private List<Block> transactions;

    User(String email, String password, String name) {
        super(email, password, name);
        sparkBalance = 0;
        transactions = new LinkedList<>();
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
