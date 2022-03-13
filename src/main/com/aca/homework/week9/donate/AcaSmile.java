package com.aca.homework.week9.donate;

import java.util.ArrayList;
import java.util.List;

public class AcaSmile<T extends Donatable> {
    private double totalDonationAmount;
    private final List<String> listOfPurchasedGoods = new ArrayList<>();

    public void buyWithDonation(T donatableGood) {
        System.out.println(donatableGood.toString() + " is bought.");
        double donationAmount = donatableGood.donationAmount();
        System.out.println("donated $" + donationAmount);
        totalDonationAmount += donationAmount;
        listOfPurchasedGoods.add(donatableGood.toString());
    }

    public double getTotalDonationAmount() {
        return totalDonationAmount;
    }

    public List<String> getListOfPurchasedGoods() {
        return listOfPurchasedGoods;
    }
}
