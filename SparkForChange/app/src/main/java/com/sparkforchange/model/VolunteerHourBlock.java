package com.sparkforchange.model;

/**
 * Created by Nancy on 01/27/2018.
 */

public class VolunteerHourBlock {
    private int sparkNum;
    private double hours;
    private Charity charity;
    private User user;

    public VolunteerHourBlock(double hours, Charity charity, User user) {
        this.sparkNum = Facade.getInstance().hoursToSparks(hours);
        this.hours = hours;
        this.charity = charity;
        this.user = user;
    }

    public int getSparkNum() {
        return sparkNum;
    }

    public double getHours() {
        return hours;
    }

    public Charity getCharity() {
        return charity;
    }

    public User getUser() {
        return user;
    }
}
