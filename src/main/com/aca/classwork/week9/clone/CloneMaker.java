package com.aca.classwork.week9.clone;

class CloneMaker<T extends ConstructorCloneable<T>>{
    public T printCloneAndPrint(T input){
        System.out.println(input);
        T clone = input.doClone();
        System.out.println();
        return clone;
    }

    public static void main(String[] args) {
        CloneMaker<Car> carCloneMaker = new CloneMaker<>();
        carCloneMaker.printCloneAndPrint(new Car(54));

        CloneMaker<Computer> computerCloneMaker = new CloneMaker<>();
        computerCloneMaker.printCloneAndPrint(new Computer("Dell"));
    }
}