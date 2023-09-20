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
    public String getDepartureAirport(){
        return baseFunc.waitForNumberOfElementsToBe(FLIGHT_INFO, 5).get(0).getText();
        //String airport = "RIX"; //Finding element(s) by locator. Getting text
        //return airport;
    }
}
