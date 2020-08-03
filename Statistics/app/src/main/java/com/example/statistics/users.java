package com.example.statistics;

public class users {
    private String state;
    private int active,recovered,deceased;

    public users(String state, int active, int recovered, int deceased) {
        this.state = state;
        this.active = active;
        this.recovered = recovered;
        this.deceased = deceased;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getRecovered() {
        return recovered;
    }

    public void setRecovered(int recovered) {
        this.recovered = recovered;
    }

    public int getDeceased() {
        return deceased;
    }

    public void setDeceased(int deceased) {
        this.deceased = deceased;
    }
}
