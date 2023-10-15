package model;


public class Country {


    private String name;
    private int area;
    private String flagColor;
    private int population;
    private String countryCode;
    private boolean seaBorder;
    private int countryBorderLength;


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

    public String getFlagColor() {
        return flagColor;
    }

    public void setFlagColor(String flagColor) {
        this.flagColor = flagColor;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public boolean isSeaBorder() {
        return seaBorder;
    }

    public void setSeaBorder(boolean seaBorder) {
        this.seaBorder = seaBorder;
    }

    public int getCountryBorderLength() {
        return countryBorderLength;
    }

    public void setCountryBorderLength(int countryBorderLength) {
        this.countryBorderLength = countryBorderLength;
    }

    public void countryProperties() {
        System.out.println("Country " + getName() + " has " + flagColor + " flag and area is " + getArea());

        System.out.println("Population of " + getName() + " is " + getPopulation() + " and country code starts with " + getCountryCode() + ".");
        String hasBorder = "hasn't sea border";
        if (isSeaBorder()) {
            hasBorder = "has sea border";
        } else {
            hasBorder = "hasn't sea border";
        }
        System.out.println("County " + hasBorder);


        //        String message = "Country %s has %s flag and area is %s";
//        System.out.println(String.format(message, getName(), getFlagColor(), getArea()));
//        String hasBorder = isSeaBorder() ? "has" : "hasn't";
//        String hasBorder = "";


    }

}
