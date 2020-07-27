package com.example.covid19;

public class users {
    private String date,death,active,recovered;

    public users(String date, String active, String recovered, String death) {
        this.date = date;
        this.death = death;
        this.active = active;
        this.recovered = recovered;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDeath() {
        return death;
    }

    public void setDeath(String death) {
        this.death = death;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }
}
