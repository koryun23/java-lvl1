package com.aca.homework.week5.abstractphone;

public abstract class AbstractPhoneService {
    public abstract Phone create(String imei, Model model);

    public abstract Phone getByImei(String imei);
}
