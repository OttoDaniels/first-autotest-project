import model.tickets.Flight;
import model.tickets.Passenger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.BaseFunctions;
import pages.PassengerInfoPage;
import pages.HomePage;
import pages.SeatSelectionPage;

public class TicketsTestsOnPages {
    private final String URL = "qaguru.lv:8089/tickets/";
    private Passenger passenger = new Passenger("Dmitry", "Tester");
    private Flight flight = new Flight("RIX", "MEL", "CCC", 4,4,
            2, "11-05-2018", 18);


    @Test
    public void successTicketsBookCheck() {
        BaseFunctions baseFunc = new BaseFunctions();
        baseFunc.openURL(URL);

        HomePage homePage = new HomePage(baseFunc);
        homePage.selectDepartureAirport(flight.getDeparture());
        homePage.selectArrivalAirport(flight.getArrival());
        homePage.clickGoBtn();

        PassengerInfoPage infoPage = new PassengerInfoPage(baseFunc);
        infoPage.fillInPassengerInfo(flight, passenger);
        infoPage.clickBookBtn();

        //Continue code

        Assertions.assertEquals(flight.getDeparture(), infoPage.getDepartureAirport(), "incorrect departure airport");
        Assertions.assertEquals(flight.getArrival(), infoPage.getDepartureAirport(), "incorrect arrival airport");

        //Continue code
        SeatSelectionPage seatSelectionPage = new SeatSelectionPage(baseFunc);
        seatSelectionPage.selectSeat(flight.getSeatNumber());


    }
}
