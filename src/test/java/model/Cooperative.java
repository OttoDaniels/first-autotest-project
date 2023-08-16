package model;

public class Cooperative {
    private boolean barrier;
    private boolean security;
    private boolean openAir;
    private int members;
    private int area;
    private int line;
    private Integer cameras;

    public boolean isBarrier() {
        return barrier;
    }

    public void setBarrier(boolean barrier) {
        this.barrier = barrier;
    }

    public boolean isSecurity() {
        return security;
    }

    public void setSecurity(boolean security) {
        this.security = security;
    }

    public boolean isOpenAir() {
        return openAir;
    }

    public void setOpenAir(boolean openAir) {
        this.openAir = openAir;
    }

    public int getMembers() {
        return members;
    }

    public void setMembers(int members) {
        this.members = members;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public Integer getCameras() {
        return cameras;
    }

    public void setCameras(Integer cameras) {
        this.cameras = cameras;
    }
}
