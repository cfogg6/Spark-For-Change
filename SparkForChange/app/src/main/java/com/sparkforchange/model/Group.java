package com.sparkforchange.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.Calendar;

/**
 * Created by Nancy on 01/27/2018.
 */

public class Group {
    private String name;
    private User admin;
    private Set<User> members;
    private String date;

    public Group(String name, User admin) {
        this.name = name;
        this.admin = admin;
        members = new HashSet<>();
        this.date = Calendar.getInstance().getTime().toString();
    }

    public void addUser(User u) {
        members.add(u);
    }

    public boolean removeUser(User u) {
        if (admin.equals(u)) {
            return false;
        } else {
            members.remove(u);
            return true;
        }
    }

    public int getGroupsSparks() {
        return members.stream().mapToInt(user -> user.getSparkBalance()).sum();
    }

    public Set<User> getMembers() {
        return members;
    }

    public String getName() {
        return name;
    }

    public String getDate() { return date; }

    public void setName(String name) {
        this.name = name;
    }

    public User getAdmin() {
        return admin;
    }

    public void setAdmin(User admin) {
        this.admin = admin;
    }
}
