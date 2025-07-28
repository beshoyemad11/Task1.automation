package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CategoryPage {
    WebDriver driver;

    public CategoryPage(WebDriver driver) {
        this.driver = driver;
    }

    private By computersMenu = By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']");
    private By notebooksSubMenu = By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Notebooks']");
    private By pageTitle = By.cssSelector("div.page-title h1");

    public void hoverAndClickNotebooks() {
        Actions actions = new Actions(driver);
        WebElement computers = driver.findElement(computersMenu);
        actions.moveToElement(computers).perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement notebooks = wait.until(ExpectedConditions
                .visibilityOfElementLocated(notebooksSubMenu));
        notebooks.click();
    }

    public String getPageTitle() {
        return driver.findElement(pageTitle).getText();
    }
}
