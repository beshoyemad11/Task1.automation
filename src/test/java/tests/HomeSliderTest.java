package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeSliderTest extends BaseTest {
    HomePage home;

    @BeforeMethod
    public void prepare() {
        home = new HomePage(driver); // This uses the initialized driver from BaseTest
    }
//    public void setUp() {
//        home = new HomePage(driver);
//    }

    @Test
    public void validateNokiaLumiaSlider() {
        driver.get("https://demo.nopcommerce.com/");
        home.clickFirstSlider();

        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.urlContains("nokia"));

        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, "https://demo.nopcommerce.com/nokia-lumia-1020");
    }

    @Test
    public void validateIphoneSlider() {
        driver.get("https://demo.nopcommerce.com/");
        home.clickSecondSlider();

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlContains("iphone"));

        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, "https://demo.nopcommerce.com/iphone-6");
    }
}
