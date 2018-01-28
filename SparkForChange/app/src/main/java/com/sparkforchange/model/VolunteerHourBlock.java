package com.sparkforchange.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Nancy on 01/27/2018.
 */

public class VolunteerHourBlock {
    private int sparkNum;
    private double hours;
    private String date;
    private Charity charity;
    private User user;

    public VolunteerHourBlock(double hours, Charity charity, User user) {
        this.sparkNum = Facade.getInstance().hoursToSparks(hours);
        this.hours = hours;
        this.charity = charity;
        this.user = user;

        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        this.date = df.format(c.getTime());
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

    public String getDate() {
        return date;
    }
}
