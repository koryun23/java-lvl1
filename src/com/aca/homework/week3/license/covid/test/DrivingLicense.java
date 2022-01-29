package com.aca.homework.week3.license.covid.test;

public class DrivingLicense {
    private User user;
    private String[] availableLicenses = {"AD", "BD", "CD", "BC", "AC"};
    public DrivingLicense(User user){
        this.user = user;
    }

    public String[] getAvailableLicenses(){
        return this.availableLicenses;
    }
}
