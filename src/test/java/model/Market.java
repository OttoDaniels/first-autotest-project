package model;

public class Market {
    private String marketLabel;
    private int doors;
    private boolean toilet;
    private int cashDesk;
    private int area;
    private int products;
    private int employees;
    private boolean discount;

    public String getMarketLabel() {
        return marketLabel;
    }

    public void setMarketLabel(String marketLabel) {
        this.marketLabel = marketLabel;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public boolean isToilet() {
        return toilet;
    }

    public void setToilet(boolean toilet) {
        this.toilet = toilet;
    }

    public int getCashDesk() {
        return cashDesk;
    }

    public void setCashDesk(int cashDesk) {
        this.cashDesk = cashDesk;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getProducts() {
        return products;
    }

    public void setProducts(int products) {
        this.products = products;
    }

    public int getEmployees() {
        return employees;
    }

    public void setEmployees(int employees) {
        this.employees = employees;
    }

    public boolean isDiscount() {
        return discount;
    }

    public void setDiscount(boolean discount) {
        this.discount = discount;
    }

    public void showShopOverview() {
        System.out.println(getMarketLabel() + " has " + getEmployees() + " employees and " + getCashDesk() + " Cash desks.");
    }
}