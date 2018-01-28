package com.sparkforchange.model;

/**
 * Created by Nancy on 01/27/2018.
 */

public abstract class Loginable implements Comparable<Loginable> {
    private String email;
    private String password;
    private String name;

    public Loginable(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Loginable l) {
        return name.compareTo(l.getName());
    }
}
