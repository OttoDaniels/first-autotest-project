import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Locators {

    //Booking

    private final By HEADER_LOGO = By.xpath(".//a[@data-testid='header-booking-logo']");
    private final By CURRENCY_BTN = By.xpath(".//button[@data-testid='header-currency-picker-trigger']");
    private final By NOTIFICATIONS_ICON = By.xpath("//div[./a[@data-testid='header-custom-action-button']]/span[4]");
    private final By USER_LEVEL = By.xpath("//span[contains(text(), 'Genius Level')]");
    private final By AIRPORT_TAXIS_BTN = By.id("airport_taxis");
    private final By WHERE_TO_BANNER = By.xpath(".//span[@data-testid='herobanner-title1']");
    private final By IN_OUT_DATE_SEARCH = By.xpath(".//span[@data-testid='searchbox-dates-container']");
    private final By SEARCH_BUTTON = By.xpath("//button[.//span[text()='Search']]");
    private final By COVID_ALERT = By.xpath("//span[@data-testid='web-shell-global-alert']");
    private final By RECENT_SEARCHES_LABEL = By.xpath("//span[@text(), 'Your recent searches']");


    //Google

    private final By SEARCH_CONTAINER = By.xpath("//span[@jsname(), 'RNNXgb']");
    private final By SETTINGS_BTN = By.id("_q_BhZP6qN4PRqwHBvYz4Bw_3");
    private final By ACCOUNT_BTN = By.xpath("[@class = 'gb_e gb_7a gb_7f gb_v']");
    private final By MORE_BTN = By.xpath("(//div[@id='hdtb-msb']//div[@role='button'])[1]");
    private final By TOOLS_BTN = By.id("hdtb-tls");
    private final By SEARCH_RESULTS = By.id("result-stats");
    private final By ABOUT_SEARCH_RESULTS_BTN = By.xpath("//div[@role='button']//span[@jsname='czHhOd'][1]");
    private final By SEARCH_INFO_BANNER = By.id("rhs");


    //Amazon

    private final By LOGO = By.id("nav-logo");
    private final By SEARCH_INPUT = By.id("nav-search-bar-form");
    private final By ACCOUNT_ICON = By.id("nav-link-accountList");
    private final By SHOPPING_BASKET_ICON = By.id("nav-cart");
    private final By BURGER_MENU_BTN = By.id("nav-hamburger-menu");
    private final By TOP_DEALS_BANNER = By.id("CardInstanceaFySO7NQyiNulB71ZvasJA");


    //1a

    private final By FOR_BUSINESS_BTN = By.xpath("//li[@class='site-top__menu-left-item'][7]");
    private final By RECEIVE_GOODS_PLACES_BTN = By.xpath("//a[@class='site-top__menu-right-link'][1]");
    private final By LANGUAGE_SWITCHER_LV = By.xpath("//li[@class='site-top__menu-right-item language-switcher'][1]");
    private final By LANGUAGE_SWITCHER_RU = By.xpath("//li[@class='site-top__menu-right-item language-switcher'][2]");
    private final By MAIN_LOGO = By.xpath("//a[@class='main-logo']");
    private final By SEARCH_BTN = By.xpath("//i[@class='main-search-submit__icon icon-svg']");
    private final By GOODS_BASKET_BTN = By.xpath("//div[@class='cart-block']");
    private final By SMART_NET_LOGO = By.xpath("//div[@class='smart-net-banner__logo']");
    private final By PRESENT_ICON = By.xpath("//img[@class='smart-net-banner__image'][2]");
    private final By BURGER_MENU_ICON = By.xpath("//i[@class='main-menu__handle-icon icon-svg']");
}
