package ru.netology;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {
    Seller seller = new Seller(this);
    List<Car> cars = new ArrayList<>();

    public Car sellCar() {
        return seller.sellCar();
    }

    public void produceCar() {
        Car newCar = new Car();
        seller.receiveCar(newCar);
    }

    List<Car> getCars() {
        return cars;
    }
}
