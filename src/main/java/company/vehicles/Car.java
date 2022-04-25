package company.vehicles;

import company.details.Engine;
import company.professions.Driver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class Car {

    private String brand;
    private String model;
    private int weight;
    private double engineVolume;
    private Driver driver;
    private Engine engine;
    protected double fuelVolume; //объем бака
    protected double fuelLevel; //уровень топлива
    protected double fuelConsumptionRate; //расход топлива  зависимости от типа машины


    public Car(String brand, String model, int weight) {
        this.brand = brand;
        this.model = model;
        this.weight = weight;
    }

    public Car(String brand, String model, int weight, double engineVolume) {
        this.brand = brand;
        this.model = model;
        this.weight = weight;
        this.engineVolume = engineVolume;
    }

    public Car(String brand, String model, int weight, double engineVolume, double fuelVolume, double fuelLevel, double fuelConsumptionRate) {
        this.brand = brand;
        this.model = model;
        this.weight = weight;
        this.engineVolume = engineVolume;
        this.fuelVolume = fuelVolume;
        this.fuelLevel = fuelLevel;
        this.fuelConsumptionRate = fuelConsumptionRate;
    }

    public void start() {
        double fuelConsumption = 15 * fuelConsumptionRate;
        if (fuelLevel > fuelConsumption) {
            this.fuelLevel -= fuelConsumption;
            System.out.println("Начали движение");
            System.out.println("Всего сейчас в баке " + fuelLevel + " литров");
        } else {
            System.out.println("Не хватает топлива для выполнения маневра");
        }
    }

    public void fillFuel(double volumeOfFuel) {
        if (volumeOfFuel > 0 & fuelLevel + volumeOfFuel <= fuelVolume) {
            this.fuelLevel += volumeOfFuel;
            System.out.println("Бак успешно заполнен на " + volumeOfFuel + " литров");
            System.out.println("Всего сейчас в баке " + fuelLevel + " литров");

        } else if (fuelLevel + volumeOfFuel > fuelVolume) {
            this.fuelLevel = fuelVolume;
            System.out.println("Бак успешно полностью заполнен. Не влезло в бак " + (fuelLevel + volumeOfFuel - fuelVolume) + " литров");
        } else {
            System.out.println("Введено некорректное значение для заправки");
        }
    }

    public void driveFast() {
        double fuelConsumption = 15 * fuelConsumptionRate;
        if (fuelLevel > fuelConsumption) {
            this.fuelLevel -= fuelConsumption;
            System.out.println("Машина поехала быстрее");
        } else {
            System.out.println("Не хватает топлива для выполнения маневра");
        }
        System.out.println("Всего сейчас в баке " + fuelLevel + " литров");
    }

    public void stop() {
        System.out.println("Остановиться");
        System.out.println("Всего сейчас в баке " + fuelLevel + " литров");
    }

    public void turnRight() {
        double fuelConsumption = 10 * fuelConsumptionRate;
        if (fuelLevel > fuelConsumption) {
            this.fuelLevel -= fuelConsumption;
            System.out.println("Повернули направо");
        } else {
            System.out.println("Не хватает топлива для выполнения маневра");
        }
        System.out.println("Всего сейчас в баке " + fuelLevel + " литров");
    }

    public void turnLeft() {
        double fuelConsumption = 10 * fuelConsumptionRate;
        if (fuelLevel > fuelConsumption) {
            this.fuelLevel -= fuelConsumption;
            System.out.println("Повернули налево");
        } else {
            System.out.println("Не хватает топлива для выполнения маневра");
        }
        System.out.println("Всего сейчас в баке " + fuelLevel + " литров");
    }

    @Override
    public String toString() {
        return "Марка машины: " + brand + "\nМодель машины: " + model + "\nВес машины: " + weight +
                "\nВодитель машины: " + driver + "\nДвигатель: " + engine;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(int engineVolume) {
        this.engineVolume = engineVolume;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public double getFuelVolume() {
        return fuelVolume;
    }

    public void setFuelVolume(int fuelVolume) {
        if (fuelVolume > 0) {
            this.fuelVolume = fuelVolume;
        } else {
            throw new RuntimeException("Объем бака не может быть отрицательным и равным нулю!");
        }
    }

    public double getFuelLevel() {
        return fuelLevel;
    }

    public void setFuelLevel(int fuelLevel) {
        if (fuelLevel >= 0 & fuelLevel <= fuelVolume) {
            this.fuelLevel = fuelLevel;
        } else {
            throw new RuntimeException("Уровень бака не может быть меньше нуля");
        }
    }

    public double getFuelConsumptionRate() {
        return fuelConsumptionRate;
    }

    public void setFuelConsumptionRate(int fuelConsumptionRate) {
        this.fuelConsumptionRate = fuelConsumptionRate;
    }


    public void doRandomMoves(int countMoves) {
        List<Integer> list = new ArrayList<>();
        start();
        for (int i = 0; i < countMoves; i++) {
            int numberOfMove = (int) (Math.random() * 6);
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
            }
        }
    }


}
