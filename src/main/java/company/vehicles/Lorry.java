package company.vehicles;

public class Lorry extends Car {

    private int carrying;

    public Lorry(String brand, String model, int weight, int carrying) {
        super(brand, model, weight);
        this.carrying = carrying;
    }

    public int getCarrying() {
        return carrying;
    }

    public void setCarrying(int carrying) {
        this.carrying = carrying;
    }

    @Override
    public String toString() {
        return "Марка машины: " + getBrand() + "\nМодель машины: " + getModel() +
                "\nВес машины: " + getWeight() + "\nГрузоподъемность: " + getCarrying();
    }
}
