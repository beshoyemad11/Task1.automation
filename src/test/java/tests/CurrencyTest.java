package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class CurrencyTest extends BaseTest {

    @Test
    public void verifyEuroSymbolAppearsForAllProducts() {
        driver.get("https://demo.nopcommerce.com/");

        WebElement currencyDropdown = driver.findElement(By.id("customerCurrency"));
        currencyDropdown.click();
        currencyDropdown.findElement(By.xpath("//option[text()='Euro']")).click();

        List<WebElement> priceElements = driver.findElements(By.cssSelector(".product-item .prices"));


        for (int i = 0; i < priceElements.size(); i++) {
            String priceText = priceElements.get(i).getText(); // Get price as string
            System.out.println("Price " + (i + 1) + ": " + priceText); // Optional: log output
            Assert.assertTrue(priceText.contains("€"), "Price " + (i + 1) + " does not contain € symbol");
        }
    }
}
