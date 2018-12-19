package by.bsu.onetravel.index;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OneTravelTest {
    private WebDriver driver;

    @Test
    public void ableToHideReturnDateChoiceAfterOneWayChoice() {
        driver.get("https://www.onetravel.com/");
        driver.findElement(By.xpath("//label[@id='owFlight']")).click();
        Assert.assertFalse(driver.findElement(By.xpath("//input[@id='arrivalCalendar_0']")).isDisplayed());
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