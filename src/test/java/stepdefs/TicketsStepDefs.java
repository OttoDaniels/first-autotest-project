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
import pages.*;
import requesters.TicketsRequester;

import java.util.List;
import java.util.Map;

public class TicketsStepDefs {
    private final String URL = "http://www.qaguru.lv:8089/tickets/";
    private Passenger passenger = new Passenger();
    private Flight flight = new Flight();
    private BaseFunctions baseFunctions = new BaseFunctions();
    private HomePage homePage;
    private PassengerInfoPage infopage;
    private SeatSelectionPage seatSelectionPage;
    private SuccessfullRegistrationPage successfullRegistrationPage;
    private List<Reservation> reservations;
    private Reservation reservationFromApi;

    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    @Given("airports:")
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
        flight.setPassengerCount(Integer.parseInt(params.get("passenger_count")));
        flight.setChildCount(Integer.parseInt(params.get("child_count")));
        flight.setLuggageCount(Integer.parseInt(params.get("luggage_count")));
        flight.setFlightDate(params.get("flight_date"));
        flight.setSeatNumber(Integer.parseInt(params.get("seat_number")));

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
        Assertions.assertEquals(flight.getDeparture(), infopage.getDepartureAirport(2), "Wrong departure airport!");
        Assertions.assertEquals(flight.getArrival(), infopage.getArrivalAirport(2), "Wrong arrival airport!");
    }

    @When("we are filling in passenger info")
    public void fill_in_flight_info() {
        infopage.fillInPassengerInfo(flight, passenger);
    }

    @When("requesting price")
    public void get_price() {
        infopage.clickGetPriceBtn();
    }

    @Then("airports and price appears in flight details")
    public void check_reservation_info() {
        Assertions.assertEquals(passenger.getFirstName(), infopage.getFirstName(), "Wrong first name!");
        Assertions.assertEquals("!", infopage.getFirstNameValueLastChar(), "Wrong first name!");

    }
    @When("we are confirming reservation")
    public void confirm_reservation(){
        infopage.clickBookBtn();
    }
    @When("we are confirming reservation after seat selection")
    public void confirm_reservation_after_selection(){
        seatSelectionPage.clickBookBtn();
    }
    @When("selecting seat number")
    public void select_seat_number(){
        seatSelectionPage = new SeatSelectionPage(baseFunctions);
        seatSelectionPage.selectSeat(flight.getSeatNumber());
    }
    @Then("selected seat number appears")
    public void compareSeatNumbers(){
        Assertions.assertEquals(flight.getSeatNumber(), seatSelectionPage.getSelectedSeat(), "Wrong seat");
    }
    @Then ("successfull registration message appears")
    public void get_success_message(){
        successfullRegistrationPage = new SuccessfullRegistrationPage(baseFunctions);
        Assertions.assertEquals(successfullRegistrationPage.getSuccessMsg(), successfullRegistrationPage.getFinalText(), "Wrong success message");
    }
    //Continue
    @When("we are requesting all reservations via API")
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
    public void check_reservation_data() {
        Assertions.assertEquals(passenger.getLastName(), reservationFromApi.getSurname(), "Wrong last name!");
        Assertions.assertEquals(flight.getSeatNumber(), reservationFromApi.getSeat(), "Wrong seat number");
        /// another assertions
    }
}
