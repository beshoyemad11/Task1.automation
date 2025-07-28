package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
    private By emailField = By.id("Email");
    private By passwordField = By.id("Password");
    private By loginButton = By.cssSelector("button.login-button");
    private By errorMessage = By.cssSelector("div.message-error");
    private By myAccountTab = By.className("ico-account");

    // Actions
    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public String getErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).getText();
    }

    public String getErrorColorHex() {
        String rgba = driver.findElement(errorMessage).getCssValue("color");
        return org.openqa.selenium.support.Color.fromString(rgba).asHex();
    }

    public boolean isMyAccountTabDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(myAccountTab)).isDisplayed();
    }
}
