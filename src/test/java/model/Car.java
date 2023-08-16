package model;

public class Car {
    private String brand;
    private int age;
    private String color;
    private int wheels;
    private int weight;
    private int windows;
    private boolean towBar;
    private boolean gasTankHatch;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWindows() {
        return windows;
    }

    public void setWindows(int windows) {
        this.windows = windows;
    }

    public boolean isTowBar() {
        return towBar;
    }

    public void setTowBar(boolean towBar) {
        this.towBar = towBar;
    }

    public boolean isGasTankHatch() {
        return gasTankHatch;
    }

    public void setGasTankHatch(boolean gasTankHatch) {
        this.gasTankHatch = gasTankHatch;
    }
}
