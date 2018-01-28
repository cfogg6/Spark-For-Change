package com.sparkforchange.model;

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
    public static final double SPARK_TO_DOLLAR = .10;
    public static final double HOUR_TO_SPARK = 1;
    public static final double DOLLAR_TO_SPARK = 1 / SPARK_TO_DOLLAR;

    public static Facade getInstance() {
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
        this.companies.put("UPS", new Company("ups@gmail.com", "password", "UPS", "https://sustainability.ups.com/the-ups-foundation/"));
        this.companies.put("Union Pacific", new Company("unionpacific@gmail.com", "password", "Union Pacific", "https://www.up.com/aboutup/community/foundation/"));
        this.companies.put("Sandia", new Company("sandia@gmail.com", "password", "Sandia", "http://www.sandia.gov/about/community/contribution_programs.html"));
        this.companies.put("Capital One", new Company("capitalone@gmail.com", "password", "Capital One", "https://www.capitalone.com/about/corporate-citizenship/partnerships/"));
        this.companies.put("Bloomberg", new Company("bloomberg@gmail.com", "password", "Bloomberg", "https://www.bloomberg.org/"));
        this.companies.put("Shofur", new Company("shofur@gmail.com", "password", "Shofur", "https://shofur.com/blog/"));
        this.companies.put("Google", new Company("google@gmail.com", "password", "Google", "https://www.google.org/"));
        this.companies.put("GTRI", new Company("gtri@gmail.com", "password", "GTRI", "https://gtri.gatech.edu/"));
        this.companies.put("Verizon", new Company("verizon@gmail.com", "password", "Verizon", "http://www.verizon.com/about/responsibility/giving-and-grants"));
        this.charities.put("Child's Play", new Charity("child@gmail.com", "password", "Child's Play"));
        this.charities.put("Malaria", new Charity("malaria@gmail.com", "password", "Against Malaria"));
        this.charities.put("Breast Cancer", new Charity("breastcancer@gmail.com", "password", "Breast Cancer Research Foundation"));
        this.groups.put("Alpha Sigma Phi", new Group("Alpha Sigma Phi", users.get("cfogg6@gatech.edu")));
        this.users.put("nancy@gmail.com", new User("nancy@gmail.com", "password", "Nancy Tao"));
        this.users.put("cole@gmail.com", new User("cole@gmail.com", "password", "Cole Bowers"));
        this.groups.get("Alpha Sigma Phi").addUser(users.get("amgiddings@gmail.com"));
        this.groups.get("Alpha Sigma Phi").addUser(users.get("cole@gmail.com"));


        this.addPartnership(this.getCompanies().get(0),this.getCharities().get(0));

        // set current user since we are not implementing login
        this.currentUser = users.get("cole@gmail.com");
        this.currentUser.addSparks(288);
        makeSparkDonation(this.currentUser, companies.get("Bloomberg"), charities.get("Child's Play"), 50);
        makeSparkDonation(this.currentUser, companies.get("UPS"), charities.get("Malaria"), 100);
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

    public User getUserByEmail(String email) {
        return users.get(email);
    }

    public Charity getCharityByName(String name) {
        return charities.get(name);
    }

    public Group getGroupByName(String name) { return groups.get(name); }

    public List<Charity> getCharities() {
        ArrayList<Charity> charityList = new ArrayList<Charity>(this.charities.values());
        Collections.sort(charityList, new Comparator<Charity>() {
            @Override
            public int compare(Charity t, Charity t1) {
                return t.getName().compareTo(t1.getName());
            }
        });
        return charityList;
    }

    public List<Company> getCompanies() {
        return new ArrayList<>(this.companies.values());
    }

    public List<User> getUsers() {
        return new ArrayList<>(this.users.values());
    }

    public List<Group> getGroups() {
        return new ArrayList<>(this.groups.values());
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
}

