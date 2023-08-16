package model;

public class Sofa {
    private int width;
    private int depth;
    private String color;
    private boolean leather;
    private boolean armRests;
    private int seats;
    private boolean cornerSofa;
    private boolean movesApart;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isLeather() {
        return leather;
    }

    public void setLeather(boolean leather) {
        this.leather = leather;
    }

    public boolean isArmRests() {
        return armRests;
    }

    public void setArmRests(boolean armRests) {
        this.armRests = armRests;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public boolean isCornerSofa() {
        return cornerSofa;
    }

    public void setCornerSofa(boolean cornerSofa) {
        this.cornerSofa = cornerSofa;
    }

    public boolean isMovesApart() {
        return movesApart;
    }

    public void setMovesApart(boolean movesApart) {
        this.movesApart = movesApart;
    }
}
