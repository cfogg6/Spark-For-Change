package com.sparkforchange.model;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Nancy on 01/27/2018.
 */

public class Facade {
    private static final Facade ourInstance = new Facade();
    private boolean fakeDataAdded = false;
    public static final double SPARK_TO_DOLLAR = .10;
    public static final double HOUR_TO_SPARK = 1;
    public static final double DOLLAR_TO_SPARK = 1 / SPARK_TO_DOLLAR;

    public static Facade getInstance() {
        System.out.println(ourInstance);
        return ourInstance;
    }
    private HashMap<String, User> users;
    private HashMap<String, Company> companies;
    private HashMap<String, Charity> charities;
    private HashMap<String, Group> groups;
    private User currentUser;

    private Facade() {
        this.users = new HashMap<>();
        this.companies = new HashMap<>();
        this.charities = new HashMap<>();
        this.groups = new HashMap<>();

        // fake data
        this.users.put("amgiddings@gmail.com", new User("amgiddings@gmail.com", "password", "Allie Giddings"));
        this.users.put("cfogg6@gatech.edu", new User("cfogg6@gatech.edu", "password", "Corey Fogg"));
        this.companies.put("UPS", new Company("ups@gmail.com", "password", "UPS", "https://sustainability.ups.com/the-ups-foundation/", "UPS is great"));
        this.companies.put("Union Pacific", new Company("unionpacific@gmail.com", "password", "Union Pacific", "https://www.up.com/aboutup/community/foundation/", "Union Pacific is great"));
        this.companies.put("Sandia", new Company("sandia@gmail.com", "password", "Sandia", "http://www.sandia.gov/about/community/contribution_programs.html", "Has offices in New Mexico"));
        this.companies.put("Capital One", new Company("capitalone@gmail.com", "password", "Capital One", "https://www.capitalone.com/about/corporate-citizenship/partnerships/", "What's in your wallet?"));
        this.companies.put("Bloomberg", new Company("bloomberg@gmail.com", "password", "Bloomberg", "https://www.bloomberg.org/", "Bloomberg"));
        this.companies.put("Shofur", new Company("shofur@gmail.com", "password", "Shofur", "https://shofur.com/blog/", "Shofur"));
        this.companies.put("Google", new Company("google@gmail.com", "password", "Google", "https://www.google.org/", "Google drive, android studio, etc."));
        this.companies.put("GTRI", new Company("gtri@gmail.com", "password", "GTRI", "https://gtri.gatech.edu/", "Georgia tech research institute"));
        this.companies.put("Verizon", new Company("verizon@gmail.com", "password", "Verizon", "http://www.verizon.com/about/responsibility/giving-and-grants", "verizon"));
        this.charities.put("Child's Play", new Charity("child@gmail.com", "password", "Child's Play", "http://childsplaycharity.org/"));
        this.charities.put("Against Malaria", new Charity("malaria@gmail.com", "password", "Against Malaria", "https://www.againstmalaria.com/"));
        this.charities.put("Susan G. Komen", new Charity("breastcancer@gmail.com", "password", "Susan G. Komen", "https://ww5.komen.org/"));
        this.groups.put("Alpha Sigma Phi", new Group("Alpha Sigma Phi", users.get("cfogg6@gatech.edu")));
        this.users.put("nancy@gmail.com", new User("nancy@gmail.com", "password", "Nancy Tao"));
        this.users.put("cole@gmail.com", new User("cole@gmail.com", "password", "Cole Bowers"));
        this.addUserToGroup(this.groups.get("Alpha Sigma Phi"), "amgiddings@gmail.com");
        this.addUserToGroup(this.groups.get("Alpha Sigma Phi"), "cole@gmail.com");

        this.addPartnership(this.getCompanies().get(0),this.getCharities().get(0));
        this.addPartnership(this.getCompanies().get(0),this.getCharities().get(1));
        this.addPartnership(this.getCompanies().get(1),this.getCharities().get(1));
        this.addPartnership(this.getCompanies().get(2),this.getCharities().get(0));
        this.addPartnership(this.getCompanies().get(2),this.getCharities().get(1));
        this.addPartnership(this.getCompanies().get(2),this.getCharities().get(2));
        this.addPartnership(this.getCompanies().get(3),this.getCharities().get(0));
        this.addPartnership(this.getCompanies().get(4),this.getCharities().get(1));
        this.addPartnership(this.getCompanies().get(5),this.getCharities().get(2));
        this.addPartnership(this.getCompanies().get(6),this.getCharities().get(0));
        this.addPartnership(this.getCompanies().get(6),this.getCharities().get(1));
        this.addPartnership(this.getCompanies().get(6),this.getCharities().get(2));
        this.addPartnership(this.getCompanies().get(7),this.getCharities().get(0));
        this.addPartnership(this.getCompanies().get(7),this.getCharities().get(1));
        this.addPartnership(this.getCompanies().get(8),this.getCharities().get(1));
        this.addPartnership(this.getCompanies().get(8),this.getCharities().get(2));

        // set current user since we are not implementing login
        this.currentUser = users.get("cole@gmail.com");
        this.currentUser.addSparks(288);
        makeSparkDonation(this.currentUser, companies.get("Bloomberg"), charities.get("Child's Play"), 50);
        makeSparkDonation(this.currentUser, companies.get("UPS"), charities.get("Against Malaria"), 100);
    }

    public void addFakeVolunteerData() {
        if (!fakeDataAdded) {
            this.currentUser.addHours(charities.get("Child's Play"), 4);
            this.currentUser.addHours(charities.get("Susan G. Komen"), 3.5);
            this.currentUser.addHours(getCharityByName("Child's Play"), 4);
            this.currentUser.addHours(getCharityByName("Against Malaria"), 4);
            this.currentUser.addDonation(getCharityByName("Against Malaria"), 100);
            this.currentUser.addDonation(getCharityByName("Susan G. Komen"), 10);
        }
        fakeDataAdded = true;
    }

    public int hoursToSparks(double hours) {
        return (int)(hours * HOUR_TO_SPARK);
    }

    public double sparksToDollars(int sparks) {
        return sparks * SPARK_TO_DOLLAR;
    }

    public int dollarsToSparks(double dollars) {
        return (int)(dollars * DOLLAR_TO_SPARK);
    }

    public void makeSparkDonation(User user, Company company, Charity charity, int sparkNum) {
        SparkDonation donation = new SparkDonation(sparkNum, charity, company, user);
        user.addSparkTransaction(donation);
        company.addDonation(donation);
        charity.addDonation(donation);
    }

    public void addPartnership(Company company, Charity charity) {
        company.addCharity(charity);
        charity.addCompany(company);
    }

    public void createGroup(String name) {
        Group newGroup = new Group(name, currentUser);
        groups.put(name, newGroup);
        currentUser.addGroup(newGroup);
    }

    public boolean addUserToGroup(Group group, String usersEmail) {
        if (users.get(usersEmail) != null) {
            User user = users.get(usersEmail);
            group.addUser(users.get(usersEmail));
            user.addGroup(group);
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

    public User getUserByEmail(String email) {
        return users.get(email);
    }

    public Charity getCharityByName(String name) {
        return charities.get(name);
    }

    public Group getGroupByName(String name) { return groups.get(name); }

    public List<Charity> getCharities() {
        ArrayList<Charity> charityList = new ArrayList<Charity>(this.charities.values());
        Collections.sort(charityList);
        return charityList;
    }

    public List<Company> getCompanies() {
        return new ArrayList<>(this.companies.values());
    }

    public List<Loginable> getLoginables() {
        ArrayList<Loginable> loginablesArrayList = new ArrayList<>();
        loginablesArrayList.addAll(companies.values());
        loginablesArrayList.addAll(charities.values());
        Collections.sort(loginablesArrayList);
        return loginablesArrayList;
    }

    public List<User> getUsers() {
        return new ArrayList<>(this.users.values());
    }

    public List<Group> getGroups() {
        return new ArrayList<>(this.groups.values());
    }

    public HashMap<String, Group> getGroupsAsMap() {return this.groups;}

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public Company getCompanyByEmail(String email) {
        return companies.get(email);
    }

    public Charity getCharityByEmail(String email) {
        return charities.get(email);
    }
}

