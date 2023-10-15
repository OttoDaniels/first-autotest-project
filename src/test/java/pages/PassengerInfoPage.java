package pages;


import model.tickets.Flight;
import model.tickets.Passenger;
import org.openqa.selenium.By;

public class PassengerInfoPage {
    private final By NAME_INPUT = By.id("name");
    private final By SURNAME_INPUT = By.id("surname");
    private final By DISCOUNT_CODE = By.id("discount");
    private final By PASSENGER_COUNT = By.id("adults");
    private final By CHILDREN_COUNT = By.id("children");
    private final By LUGGAGE_COUNT = By.id("bugs");
    private final By NEXT_FLIGHT_DATE = By.id("flight");
    private final By BOOK_BTN = By.id("book2");
    private final By GET_PRICE_BTN = By.xpath(".//span[@onclick='setLang();']");
    private final String DEPARTURE_AIRPORT = "RIX";
    private final String ARRIVAL_AIRPORT = "MEL";
    private final By FLIGHT_INFO = By.xpath(".//span[@class='bTxt']");

    private BaseFunctions baseFunc;

    public PassengerInfoPage(BaseFunctions baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void fillInPassengerInfo(Flight flight, Passenger passenger) {
        baseFunc.type(NAME_INPUT, passenger.getFirstName());
        baseFunc.type(SURNAME_INPUT, passenger.getLastName());
        baseFunc.type(DISCOUNT_CODE, flight.getDiscount());
        baseFunc.type(PASSENGER_COUNT, flight.getPassengerCount());
        baseFunc.type(CHILDREN_COUNT, flight.getChildCount());
        baseFunc.type(LUGGAGE_COUNT, flight.getLuggageCount());
        baseFunc.selectByText(NEXT_FLIGHT_DATE, flight.getFlightDate());
    }

    public void clickGetPriceBtn() {
        baseFunc.click(GET_PRICE_BTN);
    }

    public void clickBookBtn() {
        baseFunc.click(BOOK_BTN);
    }

    private String getFlightInfoTextByIndex(int index) {
        return getFlightInfoTextByIndex(index, 5);
    }

    private String getFlightInfoTextByIndex(int index, int count) {
        return baseFunc.waitForNumberOfElementsToBe(FLIGHT_INFO, count).get(index).getText();
    }

    public String getDepartureAirport() {
        return getFlightInfoTextByIndex(0);
    }

    public String getDepartureAirport(int count) {
        return getFlightInfoTextByIndex(0, count);
    }

    public String getArrivalAirport() {
        return getFlightInfoTextByIndex(1);
    }
    public String getArrivalAirport(int count) {
        return getFlightInfoTextByIndex(1, count);
    }

    public String getFirstName() {
        String firstName = getFlightInfoTextByIndex(2);
        return firstName.substring(0, firstName.length() - 1);
    }

    public String getFirstNameValueLastChar() {
        String firstNameValue = getFlightInfoTextByIndex(2);
        return firstNameValue.substring(firstNameValue.length() - 1);
    }
    public void clickGetPrice(){
        baseFunc.click(GET_PRICE_BTN);
    }
}
