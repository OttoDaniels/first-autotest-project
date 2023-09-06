package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import model.tickets.Flight;
import model.tickets.Passenger;
import pages.BaseFunctions;
import pages.FlightRegistrationPage;
import pages.HomePage;

import java.util.Map;

public class TicketsStepDefs {
    private Passenger passenger = new Passenger();
    private Flight flight = new Flight();
    private BaseFunctions baseFunctions= new BaseFunctions();
    private HomePage homePage;
    private FlightRegistrationPage infopage;

    @Given("airports")
    public void set_airports(Map<String, String> params) {
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
        infopage = new FlightRegistrationPage(baseFunctions);
    }

}