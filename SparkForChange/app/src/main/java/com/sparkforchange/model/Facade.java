package com.sparkforchange.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Nancy on 01/27/2018.
 */

public class Facade {
    private static final Facade ourInstance = new Facade();
    public static final double SPARK_TO_DOLLAR = .10;
    public static final double HOUR_TO_SPARK = 1;

    public static Facade getInstance() {
        return ourInstance;
    }
    private HashMap<String, User> users;
    private HashMap<String, Company> companies;
    private HashMap<String, Charity> charities;

    private Facade() {
        this.users = new HashMap<>();
        this.companies = new HashMap<>();
        this.charities = new HashMap<>();
    }

    public int hoursToSparks(double hours) {
        return (int)(hours*HOUR_TO_SPARK);
    }

    public double sparksToDollars(int sparks) {
        return sparks * SPARK_TO_DOLLAR;
    }

    public void addPartnership(Company company, Charity charity) {
        company.addCharity(charity);
        charity.addCompany(company);
    }

    public void companyToCharity(Company company, Charity charity, int sparkNum) {
        Block transaction = new Block(sparkNum, BlockType.COMPANY_TO_CHARITY, company, charity);
        company.addDonation(transaction);
        charity.addDonation(transaction);
    }

    public void charityToUser(Charity charity, User user, int sparkNum){
        Block transaction = new Block(sparkNum, BlockType.CHARITY_TO_USER, charity, user);
        user.addTransaction(transaction);
        charity.addDonation(transaction);
    }

    public void userToCompany(User user, Company company, int sparkNum){
        Block transaction = new Block(sparkNum, BlockType.USER_TO_COMPANY, user, company);
        company.addDonation(transaction);
        user.addTransaction(transaction);
    }

    public void addCompany(String name, Company company) {
        companies.put(name, company);
    }

    public void addUser(String name, User user) {
        users.put(name, user);
    }

    public void addCharity(String name, Charity charity) {
        charities.put(name, charity);
    }

    public Company getCompanyByName(String name) {
        return companies.get(name);
    }

    public User getUserByName(String name) {
        return users.get(name);
    }

    public Charity getCharityByName(String name) {
        return charities.get(name);
    }

    public List<Charity> getCharities() {
        return new ArrayList<>(this.charities.values());
    }

    public List<Company> getCompanies() {
        return new ArrayList<>(this.companies.values());
    }

    public List<User> getUsers() {
        return new ArrayList<>(this.users.values());
    }
}
