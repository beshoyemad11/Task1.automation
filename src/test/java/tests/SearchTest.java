package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.SearchPage;

import java.time.Duration;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class SearchTest {
    WebDriver driver;
    HomePage home;
    SearchPage search;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
        home = new HomePage(driver);
        search = new SearchPage(driver);
    }

    @Test(priority = 1)
    public void searchByProductName() {
        String[] productNames = {"book", "laptop", "nike"};

        for (String name : productNames) {
            search.searchFor(name);
            home.clickSearchButton();

            SoftAssert soft = new SoftAssert();

            String currentURL = driver.getCurrentUrl();
            soft.assertTrue(currentURL.contains("https://demo.nopcommerce.com/search?q="), "URL doesn't contain search query");

            List results = search.getSearchResults();
            soft.assertTrue(results.size() > 0, "No results for: " + name);

            for (Object result : results) {
                String text = ((org.openqa.selenium.WebElement) result).getText().toLowerCase();
                soft.assertTrue(text.contains(name.toLowerCase()), "Result doesn't contain keyword: " + name);
            }

            soft.assertAll();
            driver.navigate().to("https://demo.nopcommerce.com/");
        }
    }

    @Test(priority = 2)
    public void searchBySKU() {
        String[] skus = {"SCI_FAITH", "APPLE_CAM", "SF_PRO_11"};

        for (String sku : skus) {
            search.searchFor(sku);
            home.clickSearchButton();
            search.clickFirstProductFromResults();

            String productSKU = search.getProductSKU();
            assertTrue(productSKU.contains(sku), "Product page SKU does not contain searched SKU: " + sku);

            driver.navigate().to("https://demo.nopcommerce.com/");
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}