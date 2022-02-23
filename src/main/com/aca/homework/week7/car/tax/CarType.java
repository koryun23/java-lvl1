package com.aca.homework.week7.car.tax;

public enum CarType {
    ELECTRIC() {
        @Override
        public double annualTax(int carAge) {
            return 5;
        }
    },
    HYBRID {
        @Override
        public double annualTax(int carAge) {
            return 5 * carAge;
        }
    };

    public abstract double annualTax(int carAge);
}
