package com.aca.homework.week9.donate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class AcaSmileTest {
    private AcaSmile<Donatable> acaSmile;

    @BeforeEach
    public void setUp() {
        acaSmile = new AcaSmile<>();
    }

    @Test
    public void testWhenNothingIsBought() {
        Assertions.assertEquals(0, acaSmile.getTotalDonationAmount());
    }

    @Test
    public void testWhenOneSmartphoneIsBought() {
        acaSmile.buyWithDonation(new Smartphone(100));
        Assertions.assertEquals(5, acaSmile.getTotalDonationAmount());
    }

    @Test
    public void testWhenOneSmartphoneAndOneSmartWatchAreBought() {
        acaSmile.buyWithDonation(new Smartphone(100));
        acaSmile.buyWithDonation(new SmartWatch(200));
        Assertions.assertEquals(15, acaSmile.getTotalDonationAmount());
    }

    @Test
    public void testWhenOneSmartphoneOneWatchAndOneSmartWatchAreBought() {
        acaSmile.buyWithDonation(new Smartphone(100));
        acaSmile.buyWithDonation(new Watch(200));
        acaSmile.buyWithDonation(new SmartWatch(1000));
        Assertions.assertEquals(65, acaSmile.getTotalDonationAmount());
    }

    @Test
    public void testListOfStringRepresentationsOfPurchasedGoods() {
        acaSmile.buyWithDonation(new Smartphone(100));
        acaSmile.buyWithDonation(new Watch(150));
        acaSmile.buyWithDonation(new SmartWatch(200));
        List<String> listOfPurchasedGoods = acaSmile.getListOfPurchasedGoods();
        Assertions.assertEquals(3, listOfPurchasedGoods.size());
        Assertions.assertEquals("Smartphone with price $100.0", listOfPurchasedGoods.get(0));
        Assertions.assertEquals("Watch with price $150.0", listOfPurchasedGoods.get(1));
        Assertions.assertEquals("Smart watch with price $200.0", listOfPurchasedGoods.get(2));
    }
}