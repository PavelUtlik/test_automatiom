package by.bsu.onetravel.index;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import by.bsu.onetravel.page.IndexPage;

public class OneTravelTest {
    private WebDriver driver;

    @Test
    public void ableToHideReturnDateCalendarAfterOneWayChoice() {
        IndexPage indexPage = new IndexPage(driver);
        indexPage.pickOneWayTicketOption();
        Assert.assertFalse(indexPage.isReturnCalendarButtonVisible());
    }

    @Test
    public void preventsInfantsWithoutSeniors() {
        IndexPage indexPage = new IndexPage(driver);
        indexPage.openBookingForm();
        indexPage.addLapInfant();
        indexPage.removeAdult();
        indexPage.selectRequest();
        Assert.assertTrue(indexPage.isWarningVisible());
    }

    @Test
    public void isAbleToPreventsMoreInfantsThanAdults() {
        IndexPage indexPage = new IndexPage(driver);
        indexPage.openBookingForm();
        indexPage.addLapInfant();
        indexPage.addLapInfant();
        indexPage.selectRequest();
        Assert.assertTrue(indexPage.isWarningVisible());
    }

    @Test
    public void allowsReturnPlaneFromAnotherPlace() {
        IndexPage indexPage = new IndexPage(driver);
        indexPage.openAdvencedOptionsForm();
        indexPage.pickToReturnFromAnotherAirport();
        Assert.assertTrue(indexPage.isReturnAirportInputVisible());
    }

    @Test
    public void preventsSameFromAndToPlace() {
        IndexPage indexPage = new IndexPage(driver);
        indexPage.setDestinationAirport("VTB - Vitebsk, Belarus");
        indexPage.selectRequest();
        Assert.assertTrue(indexPage.isWarningVisible());
    }

    @Test
    public void limitMaxAllowedBookingQuantity() {
        IndexPage indexPage = new IndexPage(driver);
        indexPage.openBookingForm();
        for (int i = 0; i < 8; i++) {
            indexPage.addAdult();
        }
        indexPage.addLapInfant();
        indexPage.selectRequest();
        indexPage.isWarningVisible();
    }

    @Test
    public void allowsChoiceFromMultipleDestinations() {
        IndexPage indexPage = new IndexPage(driver);
        indexPage.chooseMultipleDestinationFlights();
        Assert.assertTrue(indexPage.isSecondFromInputVisible());
    }

    @Test
    public void allowsDifferentCarDropOffPlace() {
        IndexPage indexPage = new IndexPage(driver);
        indexPage.openCarsTab();
        indexPage.pickDropOffInAnotherPlaceOption();
        Assert.assertTrue(indexPage.isDropOffLocationCanBeSet());
    }

    @Test
    public void isAbleToBookFlightAndHotelForVacation() {
        IndexPage indexPage = new IndexPage(driver);
        indexPage.openVacationsTab();
        indexPage.openVacationsAdvencedOptions();
        Assert.assertTrue(indexPage.isHotelNameInputVisible());
    }

    @Test
    public void isAbleToBookHotelAndCarVacation() {
        IndexPage indexPage = new IndexPage(driver);
        indexPage.openVacationsTab();
        indexPage.pickHotelAndCarVacation();
        indexPage.openVacationsAdvencedOptions();
        Assert.assertTrue(indexPage.isCarInputVisible());
    }

    @BeforeClass
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments(
                "--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.77 Safari/537.36");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}