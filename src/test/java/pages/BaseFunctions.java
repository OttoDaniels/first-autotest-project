package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;
import java.util.List;

public class BaseFunctions {
    private WebDriver browser;
    private WebDriverWait wait;
    private Select select;
    private final Logger LOGGER = LogManager.getLogger(this.getClass());


    public BaseFunctions() {
        LOGGER.info("Open Browser info");
        browser = new ChromeDriver();
        LOGGER.info("Expanding browser window");
        browser.manage().window().maximize();

        wait = new WebDriverWait(browser, Duration.ofSeconds(5));

    }

    public void openURL(String url) {
        LOGGER.info("Open web page:" + url);
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "http://" + url;
        }

//        if (url.startsWith("http://") || url.startsWith("https://")) {

//        } else {
//            url = "http://" + url;
//        }

        browser.get(url);
    }

    public WebElement findElement(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        //return browser.findElement(locator);
    }

    public List<WebElement> findElements(By locator) {
        return browser.findElements(locator);
    }


    public void selectByValue(By locator, String value) {
        Select select = new Select(findElement(locator));
        select.selectByValue(value);

    }

    public void selectByText(By locator, String text) {
        Select select = new Select(findElement(locator));
        select.selectByVisibleText(text);

    }

    public void click(By locator) {

        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void type(By locator, String text) {
        WebElement inputField = findElement(locator);
        inputField.clear();
        inputField.sendKeys(text);
    }

    public void type(By locator, int text) {
        type(locator, String.valueOf(text));

    }

    public void waitForElementsCountToBeAtList(By locator, int minCount) {
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, minCount - 1));
    }

    public List<WebElement> waitForNumberOfElementsToBe(By locator, int count) {
        return wait.until(ExpectedConditions.numberOfElementsToBe(locator, count));
    }


}
