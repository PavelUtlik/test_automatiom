package by.bsu.onetravel.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {
    private WebDriver driver;

    @FindBy(xpath = "//label[@id='owFlight']")
    private WebElement oneWayRadio;

    @FindBy(xpath = "//input[@id='arrivalCalendar_0']")
    private WebElement returnDateCalendarButton;

    @FindBy(xpath = "//label[@for='totalTraveler']")
    private WebElement bookingFormButton;

    @FindBy(xpath = "//input[@value='Search Now']")
    private WebElement searchButton;

    @FindBy(xpath = "//button[@data-ember-action='729']")
    WebElement removeAdultButton;

    @FindBy(xpath = "//button[@data-ember-action='742']")
    WebElement addLapInfantButton;

    @FindBy(xpath = "//li[contains(text(),'Each child under 2 (lap) should have at least one Adult or Senior traveling with them.')]")
    WebElement infantWithoutAdultWarning;

    public IndexPage(WebDriver driver) {
        this.driver = driver;
        driver.get("https://www.onetravel.com/");
        PageFactory.initElements(driver, this);
    }

    public void pickOneWayTicketOption() {
        oneWayRadio.click();
    }

    public boolean isReturnCalendarButtonVisible() {
        return returnDateCalendarButton.isDisplayed();
    }

    public void openBookingForm() {
        bookingFormButton.click();
    }

    public void addLapInfant() {
        addLapInfantButton.click();
    }

    public void removeAdult() {
        removeAdultButton.click();
    }

    public void selectRequest() {
        searchButton.click();
    }

    public boolean isInfantWithoutAdultWarningVisible() {
        return infantWithoutAdultWarning.isDisplayed();
    }
}
