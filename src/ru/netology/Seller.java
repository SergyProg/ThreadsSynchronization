package ru.netology;

public class Seller {
    static final int TIME_OF_RECEIPT = 200;
    static final int TIME_OF_CAR_PURCHASE = 100;

    private CarFactory carFactoryShop;

    public Seller(CarFactory carFactoryShop) {
        this.carFactoryShop = carFactoryShop;
    }

    public synchronized void receiveCar(Car newCar) {
        try {
            Thread.sleep(TIME_OF_RECEIPT);
            System.out.println("Автомагазин завода получил машину");
            carFactoryShop.cars.add(newCar);
            notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized Car sellCar() {
        try {
            System.out.println(Thread.currentThread().getName() + " зашел в автомагазин завода и оформил заказ");
            boolean flagFirstMessage = true;
            while (carFactoryShop.getCars().size() == 0) {
                if(flagFirstMessage) System.out.println("Машин нет");
                wait();
                flagFirstMessage = false;
            }
            Thread.sleep(TIME_OF_CAR_PURCHASE);
            System.out.println(Thread.currentThread().getName() + " уехал на новеньком авто");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return carFactoryShop.getCars().remove(0);
    }
}
