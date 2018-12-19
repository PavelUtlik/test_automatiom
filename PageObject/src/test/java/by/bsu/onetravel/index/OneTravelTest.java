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
        Assert.assertTrue(indexPage.isInfantWithoutAdultWarningVisible());
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