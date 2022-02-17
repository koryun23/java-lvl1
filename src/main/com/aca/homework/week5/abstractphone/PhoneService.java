package com.aca.homework.week5.abstractphone;

public class PhoneService extends AbstractPhoneService {
    private final Phone[] phones = new Phone[5];
    private int phoneCount = 0;

    @Override
    public Phone create(String imei, Model model) {
        Phone phone = new Phone(imei, model);
        phones[phoneCount++] = phone;
        return phone;
    }

    @Override
    public Phone getByImei(String imei) {
        for (Phone phone : phones) {
            if (phone == null) break;
            if (phone.getImei().equals(imei)) {
                return phone;
            }
        }
        return null;
    }
}
