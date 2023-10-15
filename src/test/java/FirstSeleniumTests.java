import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstSeleniumTests {
//    find element on web page starts with private final By

    private final By REGISTRATION_FORM = By.id("registration-form");
    private final By FIRST_NAME_INPUT_FIELD = By.id("first-name");
    private final By SMART_NET_JOIN_BUTTON = By.xpath(".//span[@class = 'smart-net-banner__info-button-text']");
    private final By LOGO = By.tagName("img");
    private final By SEARCH_INPUT_FIELD = By.id("q");


    @Test
    public void firstSeleniumTry() {
        WebDriver browser = new ChromeDriver(); // open Chrome browser. Can be FirefoxDriver, Edge and others
        browser.get("http://1a.lv"); // open entered url

        browser.findElement(SEARCH_INPUT_FIELD).sendKeys("ledusskapis");

//        WebElement registrationForm = browser.findElement(LOGO); //search inside full page
//        registrationForm.findElement(LOGO); //search inside one element

    }
}
