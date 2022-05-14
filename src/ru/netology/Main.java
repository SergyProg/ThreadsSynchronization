package ru.netology;

public class Main {
    static private final int NUMBER_OF_CARS_PRODUCED = 9;
    static private final int NUMBER_OF_BUYERS = 9;
    static private final int MAX_SALE_COUNT = 10;

    public static void main(String[] args) {
        final CarFactory carFactoryShop = new CarFactory();

        int maxIteration = NUMBER_OF_CARS_PRODUCED > NUMBER_OF_BUYERS ? NUMBER_OF_CARS_PRODUCED : NUMBER_OF_BUYERS;
        for (int i = 1; i <= maxIteration; i++) {
            if (i <= NUMBER_OF_BUYERS) {
                if (i > MAX_SALE_COUNT) {
                    break;
                }
                new Thread(null, carFactoryShop::sellCar, "Покупатель" + i).start();
            }
            if (i <= NUMBER_OF_CARS_PRODUCED)
                new Thread(null, carFactoryShop::produceCar, "Автомобильный завод").start();
        }
    }
}
