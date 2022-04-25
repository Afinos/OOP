package company.vehicles;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс описывает спортивный автомобиль
 */
public class SportCar extends Car {

    private double maxSpeed;

    public SportCar(String brand, String model, int weight, double engineVolume, double maxSpeed) {
        super(brand, model, weight, engineVolume);
        this.maxSpeed = maxSpeed;
    }

    public SportCar(String brand, String model, int weight, double engineVolume, double fuelVolume, double fuelLevel, double fuelRate, double maxSpeed) {
        super(brand, model, weight, engineVolume, fuelVolume, fuelLevel, fuelRate);
        this.maxSpeed = maxSpeed;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Марка машины: " + getBrand() + "\nМодель машины: " + getModel() +
                "\nВес машины: " + getWeight() + "\nОбъем двигателя: " + getEngineVolume() +
                "\nМаксимальная скорость: " + getMaxSpeed();
    }

    public void driveExtraFast() {
        double fuelConsumption = 22 * fuelConsumptionRate;
        if (fuelLevel > fuelConsumption) {
            this.fuelLevel -= fuelConsumption;
            System.out.println("Машина поехала очень быстро");
        } else {
            System.out.println("Не хватает топлива для выполнения маневра");
        }
        System.out.println("Всего сейчас в баке " + fuelLevel + " литров");
    }

    /**
     * Метод выполняет такую то логику
     *
     * @param countMoves - количество заданных действий для маневра автомобиля
     */
    @Override
    public void doRandomMoves(int countMoves) {

            if (countMoves <= 0 || countMoves > 1000) {
                throw new IllegalArgumentException("Введено неверное количество движений");
            }


        List<Integer> list = new ArrayList<>();
        list.add(0, 0);
        start();
        for (int i = 1; i <= countMoves; i++) {
            int numberOfMove = (int) (Math.random() * 7);
            switch (numberOfMove) {
                case 0:
                    list.add(i, numberOfMove);
                    if (list.get(i - 1) == 2) {
                        start();
                    } else {
                        System.out.println("Машина не может тронуться, машина уже в пути");
                    }
                    break;
                case 1:
                    list.add(i, numberOfMove);
                    fillFuel(Math.random() * fuelVolume);
                    break;
                case 2:
                    list.add(i, numberOfMove);
                    if (list.get(i - 1) == 2) {
                        System.out.println("Машина уже остановлена");
                    } else {
                        stop();
                    }
                    break;
                case 3:
                    list.add(i, numberOfMove);
                    if (list.get(i - 1) == 2) {
                        System.out.println("Невозможно совершить маневр, для начала нужно тронуться");
                    } else {
                        turnLeft();
                    }
                    break;
                case 4:
                    list.add(i, numberOfMove);
                    if (list.get(i - 1) == 2) {
                        System.out.println("Невозможно совершить маневр, для начала нужно тронуться");
                    } else {
                        turnRight();
                    }
                    break;
                case 5:
                    list.add(i, numberOfMove);
                    if (list.get(i - 1) == 2) {
                        System.out.println("Невозможно совершить маневр, для начала нужно тронуться");
                    } else {
                        driveFast();
                    }
                    break;
                case 6:
                    list.add(i, numberOfMove);
                    if (list.get(i - 1) == 2) {
                        System.out.println("Невозможно совершить маневр, для начала нужно тронуться");
                    } else {
                        driveExtraFast();
                    }
                    break;
            }
        }
    }
}
