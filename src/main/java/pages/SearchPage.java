package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage {
    WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchFor(String keyword) {
        WebElement input = driver.findElement(By.id("small-searchterms"));
        input.clear();
        input.sendKeys(keyword);
    }

    public List<WebElement> getSearchResults() {
        return driver.findElements(By.cssSelector(".product-item"));
    }

    public void clickFirstProductFromResults() {
        driver.findElement(By.cssSelector(".product-item .product-title a")).click();
    }

    public String getProductSKU() {
        return driver.findElement(By.cssSelector(".sku span.value"))
                .getText().trim();
    }
}