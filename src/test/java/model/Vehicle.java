package model;


public class Vehicle {

    private double fuelConsumptionPer100KM;
    private String type;


    public double getFuelConsumptionPer100KM() {
        return fuelConsumptionPer100KM;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setFuelConsumptionPer100KM(double fuelConsumption) {
        this.fuelConsumptionPer100KM = fuelConsumption;
    }

    public void calcFuelConsumption(double routeRange) {
        double result = getFuelConsumptionPer100KM() * (routeRange / 100);
        System.out.println(getType() + " fuel consumption " + getFuelConsumptionPer100KM() + "*" + routeRange / 100 + "=" + result + "L");
    }
}
