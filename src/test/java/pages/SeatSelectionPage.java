package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SeatSelectionPage {
    private BaseFunctions baseFunctions;
    private final By SEAT = By.xpath(".//div[contains(@onclick, 'seat')]");
    private final By BOOK_BUTTON_AFTER_SEAT = By.id("book3");

    public SeatSelectionPage(BaseFunctions baseFunctions) {
        this.baseFunctions = baseFunctions;
    }

    public void selectSeat(int seatNumber) {
        //wait for seats to appear
        baseFunctions.waitForElementsCountToBeAtList(SEAT, 32);
        //get all seats
        List<WebElement> availableSeats = baseFunctions.findElements(SEAT);
        System.out.println("Size: " + availableSeats.size());
        Assertions.assertFalse(availableSeats.isEmpty(), "There is no seats at all");

        //find necessary seat and select it

        boolean isSeatFound = false;  //if seat is not found in the list
        for (WebElement seat : availableSeats) {
            if (Integer.parseInt(seat.getText()) == seatNumber) {     // == - compare true/false
                seat.click();
                isSeatFound = true;
                break;
            }
        }
        Assertions.assertTrue(isSeatFound, "Seat Nr. " + seatNumber + " is not found!");


        //--------------------FOR--------------
        //for (int i = 0; i < seats.size(); i++) {    //i = i + 1 => i++
        //    System.out.println(seats.get(i).getText());
        //do something
        //}
        // ------------------FOR EACH------------
        //for (WebElement we : seats){
        //    System.out.println(we.getText());
        //do something
        //}
    }
    public void clickBookBtn() {
        baseFunctions.click(BOOK_BUTTON_AFTER_SEAT);
    }
}
