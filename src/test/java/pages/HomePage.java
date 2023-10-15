package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
    private final By DEPARTURE_SELECT = By.id("afrom");
    private final By ARRIVAL_SELECT = By.id("bfrom");
    private final By GO_BTN = By.xpath(".//span[@class = 'gogogo']");


    private BaseFunctions baseFunctions;

    public HomePage(BaseFunctions baseFunctions) {
        this.baseFunctions = baseFunctions;
    }

    public void selectDepartureAirport(String airport) {
        baseFunctions.selectByValue(DEPARTURE_SELECT, airport);
    }

    public void selectArrivalAirport(String airport) {
        baseFunctions.selectByValue(ARRIVAL_SELECT, airport);
    }

    public void clickGoBtn() {
        baseFunctions.click(GO_BTN);
    }
}
