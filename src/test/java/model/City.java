package model;

public class City {
    private String name;
    private int area;
    private int regions;
    private int population;
    private boolean metro;
    private Integer bridges;
    private Integer rivers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getRegions() {
        return regions;
    }

    public void setRegions(int regions) {
        this.regions = regions;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public boolean isMetro() {
        return metro;
    }

    public void setMetro(boolean metro) {
        this.metro = metro;
    }

    public Integer getBridges() {
        return bridges;
    }

    public void setBridges(Integer bridges) {
        this.bridges = bridges;
    }

    public Integer getRivers() {
        return rivers;
    }

    public void setRivers(Integer rivers) {
        this.rivers = rivers;
    }
}
