package company;

import company.details.Engine;
import company.professions.Driver;
import company.vehicles.Car;
import company.vehicles.Lorry;
import company.vehicles.SportCar;

public class Main {
    public static void main(String[] args) {


        SportCar ferrari = new SportCar("Ferrari", "812 GTS", 1600, 6.5, 92, 13,1.3, 340);
        Lorry scania = new Lorry("Scania", "G-460", 150000, 140000);
        Driver ferrariDriver = new Driver("Дальнобойнов Александр Батькович", 54, 23);
        Driver scaniaDriver = new Driver("Быстров Петр Валерьевич", 33, 9);
        Engine scaniaEngine = new Engine(460, "Scania");
        Engine ferrariEngine = new Engine(800, "Ferrari");


        ferrari.doRandomMoves(40);


    }
}
