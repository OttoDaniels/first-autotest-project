package model.tickets;

public class Flight {
    private String departure;
    private String arrival;
    private String discount;
    private int passengerCount;
    private int childCount;
    private int luggageCount;
    private String flightDate;
    private int seatNumber;

    public Flight(String departure, String arrival, String discount, int passengerCount, int childCount, int luggageCount, String flightDate, int seatNumber) {
        this.departure = departure;
        this.arrival = arrival;
        this.discount = discount;
        this.passengerCount = passengerCount;
        this.childCount = childCount;
        this.luggageCount = luggageCount;
        this.flightDate = flightDate;
        this.seatNumber = seatNumber;
    }

    public Flight() {
    } //can be empty to enter info in a test

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public void setPassengerCount(int passengerCount) {
        this.passengerCount = passengerCount;
    }

    public int getChildCount() {
        return childCount;
    }

    public void setChildCount(int childCount) {
        this.childCount = childCount;
    }

    public int getLuggageCount() {
        return luggageCount;
    }

    public void setLuggageCount(int luggageCount) {
        this.luggageCount = luggageCount;
    }

    public String getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(String flightDate) {
        this.flightDate = flightDate;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }
}
