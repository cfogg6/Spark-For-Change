package com.sparkforchange.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    private Set<Group> groups;
    private User currentUser;

    private Facade() {
        this.users = new HashMap<>();
        this.companies = new HashMap<>();
        this.charities = new HashMap<>();
        this.groups = new HashSet<>();

        // fake data
        this.users.put("amgiddings@gmail.com", new User("amgiddings@gmail.com", "password", "Allie Giddings"));
        this.users.put("cfogg6@gatech.edu", new User("cfogg6@gatech.edu", "password", "Corey Fogg"));
        this.companies.put("ups@gmail.com", new Company("ups@gmail.com", "password", "UPS", "https://sustainability.ups.com/the-ups-foundation/"));
        this.companies.put("unionpacific@gmail.com", new Company("unionpacific@gmail.com", "password", "Union Pacific", "https://www.up.com/aboutup/community/foundation/"));
        this.companies.put("sandia@gmail.com", new Company("sandia@gmail.com", "password", "Sandia", "http://www.sandia.gov/about/community/contribution_programs.html"));
        this.companies.put("capitalone@gmail.com", new Company("capitalone@gmail.com", "password", "Capital One", "https://www.capitalone.com/about/corporate-citizenship/partnerships/"));
        this.companies.put("bloomberg@gmail.com", new Company("bloomberg@gmail.com", "password", "Bloomberg", "https://www.bloomberg.org/"));
        this.companies.put("shofur@gmail.com", new Company("shofur@gmail.com", "password", "Shofur", "https://shofur.com/blog/"));
        this.companies.put("google@gmail.com", new Company("google@gmail.com", "password", "Google", "https://www.google.org/"));
        this.companies.put("gtri@gmail.com", new Company("gtri@gmail.com", "password", "GTRI", "https://gtri.gatech.edu/"));
        this.companies.put("verizon@gmail.com", new Company("verizon@gmail.com", "password", "Verizon", "http://www.verizon.com/about/responsibility/giving-and-grants"));
        this.charities.put("child@gmail.com", new Charity("child@gmail.com", "password", "Child's Play"));
        this.charities.put("malaria@gmail.com", new Charity("malaria@gmail.com", "password", "Against Malaria Foundation"));
        this.charities.put("breastcancer@gmail.com", new Charity("breastcancer@gmail.com", "password", "Breast Cancer Research Foundation"));

        // set current user since we are not implementing login
        this.currentUser = users.get("amgiddings@gmail.com");
    }

    public int hoursToSparks(double hours) {
        return (int)(hours * HOUR_TO_SPARK);
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

    public void createGroup(String name) {
        Group newGroup = new Group(name, currentUser);
        groups.add(newGroup);
        currentUser.addGroup(newGroup);
    }

    public boolean addUser(Group group, String usersEmail) {
        if (users.get(usersEmail) != null) {
            group.addUser(users.get(usersEmail));
            return true;
        }
        return false;
    }

    public void deleteGroup(Group g) {
        for (User u : g.getMembers()) {
            u.removeGroup(g);
        }
        groups.remove(g);
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

    public List<Group> getGroups() {
        return new ArrayList<>(this.groups);
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
}

