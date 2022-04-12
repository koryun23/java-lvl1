package com.aca.homework.week5.abstractphone;

public class Phone {
    private final String imei;
    private final Model model;

    public Phone(String imei, Model model) {
        this.imei = imei;
        this.model = model;
    }

    public String getImei() {
        return imei;
    }

    public Model getModel() {
        return model;
    }

    @Override
    public String toString() {
        return String.format("%s: %s\n%s: %s",
                "IMEI", imei, "Model", model);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Phone) {
            Phone phone = (Phone) obj;
            return phone.imei.equals(this.imei) && phone.model == this.model;
        }
        return false;
    }
}
