import org.apache.logging.log4j.core.appender.SocketAppender;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TicketsTests {
    private final By FROM = By.id("afrom");
    private final By TO = By.id("bfrom");
    private final By GO_BTN = By.xpath(".//span[@class = 'gogogo']");


    //private final By SELECTED_AIRPORT = By.xpath(".//span[@class = 'bTxt']");

    //select airports
    private final String URL = "http://www.qaguru.lv:8089/tickets/";
    private final String DEPARTURE_AIRPORT = "RIX";
    private final String ARRIVAL_AIRPORT = "MEL";

    private final By NAME_INPUT = By.id("name");
    private final By SURNAME_INPUT = By.id("surname");
    private final By DISCOUNT_CODE = By.id("discount");
    private final By PASSENGER_COUNT = By.id("adults");
    private final By CHILDREN_COUNT = By.id("children");
    private final By LUGGAGE_COUNT = By.id("bugs");
    private final By NEXT_FLIGHT_DATE = By.id("flight");
    private final By GET_PRICE_BTN = By.xpath(".//span[@onclick='setLang();']");
    private final By FLIGHT_INFO = By.xpath(".//span[@class='bTxt']");
    private final By BOOK_BTN = By.id("book2");
    private final By SEAT_NUMBER = By.xpath(".//div[@onclick='seat(15)']");
    private final By BOOK_BUTTON_AFTER_SEAT = By.id("book3");
    private final By FINAL_TEXT = By.xpath(".//div[@class='finalTxt']");

    //personal info
    private final String NAME = "Daniels";
    private final String SURNAME = "Otto";
    private final String DISCOUNT = "abc123";
    private final int PASSENGERS = 4;
    private final int CHILDREN = 2;
    private final int LUGGAGE = 2;
    private final String DATE_OF_FLIGHT = "13";
    private final String SUCCESS_MSG = "Thank You for flying with us!";


    @Test
    public void successTicketsBookCheck() {
        //Open browser
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();

        //Open url
        browser.get(URL);


        //Select departure airport
        WebElement fromDropdown = browser.findElement(FROM); //Open dropdown
        Select fromSelect = new Select(fromDropdown);  //set variable for dropdown for working with it
        fromSelect.selectByValue(DEPARTURE_AIRPORT); //select a value from set locator

        //--------Select arrival airport
        WebElement toDropdown = browser.findElement((TO));
        Select toSelect = new Select(toDropdown);
        toSelect.selectByValue(ARRIVAL_AIRPORT);

        //Click GoGoGo btn
        browser.findElement(GO_BTN).click();

        //Check if selected airport appears
        //List<WebElement> selectedAirports = browser.findElements(SELECTED_AIRPORT);
        //System.out.println("First airport " + selectedAirports.get(0).getText());
        //System.out.println("Second airport " + selectedAirports.get(1).getText());


        //Enter person's info
        WebElement nameInputField = browser.findElement(NAME_INPUT);
        nameInputField.clear(); //clear input field
        nameInputField.sendKeys(NAME);

        WebElement surnameInputField = browser.findElement(SURNAME_INPUT);
        surnameInputField.clear();
        surnameInputField.sendKeys(SURNAME);

        WebElement discountCodeInput = browser.findElement(DISCOUNT_CODE);
        discountCodeInput.clear();
        discountCodeInput.sendKeys(DISCOUNT);

        WebElement passengerCountInput = browser.findElement(PASSENGER_COUNT);
        passengerCountInput.clear();
        passengerCountInput.sendKeys(Integer.toString(PASSENGERS));

        WebElement childrenCountInput = browser.findElement(CHILDREN_COUNT);
        childrenCountInput.clear();
        childrenCountInput.sendKeys(Integer.toString(CHILDREN));

        WebElement luggageCountInput = browser.findElement(LUGGAGE_COUNT);
        luggageCountInput.clear();
        luggageCountInput.sendKeys(Integer.toString(LUGGAGE));

        WebElement flightDateDropdown = browser.findElement((NEXT_FLIGHT_DATE));
        Select flightDate = new Select(flightDateDropdown);
        flightDate.selectByValue(DATE_OF_FLIGHT);
        System.out.println("Departure date " + flightDate.getFirstSelectedOption().getText());


        //Click on Get Price link
        browser.findElement(GET_PRICE_BTN).click();

        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.numberOfElementsToBe(FLIGHT_INFO, 5));

        List<WebElement> flightInfo = browser.findElements(FLIGHT_INFO);
        Assertions.assertEquals(DEPARTURE_AIRPORT, flightInfo.get(0).getText(), "Wrong departure airport!");
        Assertions.assertEquals(ARRIVAL_AIRPORT, flightInfo.get(1).getText(), "Wrong arrival airport");

        String name = flightInfo.get(2).getText();
        Assertions.assertEquals(NAME, name.substring(0, name.length() - 1), "Wrong name!");

        Assertions.assertEquals(DEPARTURE_AIRPORT, flightInfo.get(3).getText(), "Wrong departure airport!");
        Assertions.assertEquals(ARRIVAL_AIRPORT, flightInfo.get(4).getText(), "Wrong arrival airport");

        //Click on Book btn
        browser.findElement(BOOK_BTN).click();

        //Select seat number
        browser.findElement(SEAT_NUMBER).click();
        // Click Book btn
        browser.findElement(BOOK_BUTTON_AFTER_SEAT).click();
        //Check if successfull msg appears
        System.out.println(SUCCESS_MSG);
    }
}
