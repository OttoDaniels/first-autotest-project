package pages;

import model.ReservationInfo;
import org.openqa.selenium.By;

public class FlightRegistrationPage {
    private final By NAME_INPUT = By.id("name");
    private final By SURNAME_INPUT = By.id("surname");
    private final By DISCOUNT_CODE = By.id("discount");
    private final By PASSENGER_COUNT = By.id("adults");
    private final By CHILDREN_COUNT = By.id("children");
    private final By LUGGAGE_COUNT = By.id("bugs");
    private final By NEXT_FLIGHT_DATE = By.id("flight");
    private final By BOOK_BTN = By.id("book2");
    private final By GET_PRICE_BTN = By.xpath(".//span[@onclick='setLang();']");

    private BaseFunctions baseFunc;

    public FlightRegistrationPage(BaseFunctions baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void enterPassengerInfo(ReservationInfo reservationInfo) {
        baseFunc.type(NAME_INPUT, reservationInfo.getFirstName());
        baseFunc.type(SURNAME_INPUT, reservationInfo.getLastName());
        baseFunc.type(DISCOUNT_CODE, reservationInfo.getDiscount());
        baseFunc.type(PASSENGER_COUNT, reservationInfo.getBagsCount());
        baseFunc.type(CHILDREN_COUNT, reservationInfo.getChildCount());
        baseFunc.type(LUGGAGE_COUNT, reservationInfo.getBagsCount());
        baseFunc.selectByText(NEXT_FLIGHT_DATE, reservationInfo.getFlightDate());

    }
    public void clickGetPriceBtn() {
        baseFunc.click(GET_PRICE_BTN);
    }
    public void clickBookBtn() {
        baseFunc.click(BOOK_BTN);
    }
    public String getDepartureAirport(){
        String airport = "RIX"; //Finding element(s) by locator. Getting text
        return airport;
    }
}
