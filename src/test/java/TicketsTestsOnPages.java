import model.ReservationInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.BaseFunctions;
import pages.FlightRegistrationPage;
import pages.HomePage;
import pages.SeatSelectionPage;

public class TicketsTestsOnPages {
    private final String URL = "qaguru.lv:8089/tickets/";
    private final String DEPARTURE_AIRPORT = "RIX";
    private final String ARRIVAL_AIRPORT = "MEL";
    private int seatNr = 5;
    private ReservationInfo info = new ReservationInfo("Dmitry","Tester","111222",4,1,2,"11-05-2018");


    @Test
    public void successTicketsBookCheck() {
        BaseFunctions baseFunc = new BaseFunctions();
        baseFunc.openURL(URL);

        HomePage homePage = new HomePage(baseFunc);
        homePage.selectDepartureAirport(DEPARTURE_AIRPORT);
        homePage.selectArrivalAirport(ARRIVAL_AIRPORT);
        homePage.clickGoBtn();

        FlightRegistrationPage infoPage = new FlightRegistrationPage(baseFunc);
        infoPage.enterPassengerInfo(info);
        infoPage.clickBookBtn();

        //Continue code

        Assertions.assertEquals(DEPARTURE_AIRPORT, infoPage.getDepartureAirport(), "incorrect airport");

        //Continue code
        SeatSelectionPage seatSelectionPage = new SeatSelectionPage(baseFunc);
        seatSelectionPage.selectSeat(seatNr);


    }
}
