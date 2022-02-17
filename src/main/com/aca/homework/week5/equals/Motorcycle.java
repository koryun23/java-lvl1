package com.aca.homework.week5.equals;

public class Motorcycle {
    private Owner owner;
    private MotorcycleType brand;

    public Motorcycle(Owner owner, MotorcycleType brand) {
        this.owner = owner;
        this.brand = brand;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Motorcycle) {
            Motorcycle moto = (Motorcycle) obj;
            return moto.owner.equals(this.owner) && moto.brand == this.brand;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s: %s\n%s", "brand", this.brand, this.owner);
    }
}
