package model;

public class Phone {
    private String brand;
    private int rearCameraMP;
    private int frontCameraMP;
    private String screenHeight;
    private String screenWidth;
    private boolean physicalButtons;
    private boolean wirelessCharge;
    private int ram;
    private int memory;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getRearCameraMP() {
        return rearCameraMP;
    }

    public void setRearCameraMP(int rearCameraMP) {
        this.rearCameraMP = rearCameraMP;
    }

    public int getFrontCameraMP() {
        return frontCameraMP;
    }

    public void setFrontCameraMP(int frontCameraMP) {
        this.frontCameraMP = frontCameraMP;
    }

    public String getScreenHeight() {
        return screenHeight;
    }

    public void setScreenHeight(String screenHeight) {
        this.screenHeight = screenHeight;
    }

    public String getScreenWidth() {
        return screenWidth;
    }

    public void setScreenWidth(String screenWidth) {
        this.screenWidth = screenWidth;
    }

    public boolean isPhysicalButtons() {
        return physicalButtons;
    }

    public void setPhysicalButtons(boolean physicalButtons) {
        this.physicalButtons = physicalButtons;
    }

    public boolean isWirelessCharge() {
        return wirelessCharge;
    }

    public void setWirelessCharge(boolean wirelessCharge) {
        this.wirelessCharge = wirelessCharge;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }
}
