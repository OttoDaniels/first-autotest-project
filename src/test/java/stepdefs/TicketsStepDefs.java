package stepdefs;

import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.tickets.Flight;
import model.tickets.Passenger;
import model.tickets.Reservation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import pages.BaseFunctions;
import pages.PassengerInfoPage;
import pages.HomePage;
import requesters.TicketsRequester;

import java.util.List;
import java.util.Map;

public class TicketsStepDefs {
    private Passenger passenger = new Passenger();
    private Flight flight = new Flight();
    private BaseFunctions baseFunctions= new BaseFunctions();
    private HomePage homePage;
    private PassengerInfoPage infopage;
    private List<Reservation> reservations;
    private Reservation reservationFromApi;

    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    @Given("airports")
    public void set_airports(Map<String, String> params) {
        LOGGER.info("Setting airports");
        flight.setDeparture(params.get("from"));
        flight.setArrival(params.get("to"));
    }
    @Given("passenger info is:")
    public void set_passenger_info(Map<String, String> params) {
        passenger.setFirstName(params.get("first_name"));
        passenger.setLastName(params.get("last_name"));
    }
    @Given("flight info is:")
    public void set_flight_info(Map<String, String> params) {
        flight.setDiscount(params.get("discount"));
        flight.setPassengerCount(Integer.parseInt(params.get("discount")));
        flight.setChildCount(Integer.parseInt(params.get("child_count")));
        flight.setLuggageCount(Integer.parseInt(params.get("lugagge_count")));
        flight.setFlightDate(params.get("flight_date"));
        flight.setSeatNumber(Integer.parseInt(params.get("seat_nr")));

    }
    @Given("home page is opened")
    public void open_home_page() {
        baseFunctions.openURL("qaguru.lv:8089/tickets/");
        homePage = new HomePage(baseFunctions);
    }
    @When("we are selecting airport")
    public void select_airports() {
        homePage.selectDepartureAirport(flight.getDeparture());
        homePage.selectArrivalAirport(flight.getArrival());
        homePage.clickGoBtn();
        infopage = new PassengerInfoPage(baseFunctions);
    }
    @Then("selected airports appears on the passenger info page")
    public void check_selected_airports() {
        Assertions.assertEquals(flight.getDeparture(), infopage.getDepartureAirport(), "Wrong departure airport!");
        //check arrival airport
    }
    @When("we are filling in passenger info")
    public void fill_in_flight_info() {
        infopage.fillInPassengerInfo(flight, passenger);
    }
//Continue
    @When("we are reuesting all reservations via API")
    public void request_all_reservations() throws JsonProcessingException {
        TicketsRequester requester = new TicketsRequester();
        reservations = requester.getReservations();
    }
    @Then("current reservation exists in the list")
    public void find_reservation() {
        for (Reservation reservation : reservations) {
            if (reservation.getName().equals(passenger.getFirstName())) {
                reservationFromApi = reservation;
                break;
            }
        }
        Assertions.assertNotNull(reservationFromApi, "Can't find reservation!");
    }
    @Then("all data are stored correctly")
    public void check_reservation_data(){
        Assertions.assertEquals(passenger.getLastName(), reservationFromApi.getSurname(), "Wrong last name!");
        Assertions.assertEquals(flight.getSeatNumber(), reservationFromApi.getSeat(), "Wrong seat number");
        /// another assertions
    }
}
