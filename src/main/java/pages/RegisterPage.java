package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class RegisterPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    // Locators
    private By genderMale = By.id("gender-male");
    private By firstName = By.id("FirstName");
    private By lastName = By.id("LastName");
    private By day = By.name("DateOfBirthDay");
    private By month = By.name("DateOfBirthMonth");
    private By year = By.name("DateOfBirthYear");
    private By email = By.id("Email");
    private By password = By.id("Password");
    private By confirmPassword = By.id("ConfirmPassword");
    private By registerButton = By.id("register-button");
    private By successMessage = By.className("result");

    // Actions with waits

    private By emailError = By.cssSelector(".message-error.validation-summary-errors");

    public WebElement getEmailErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(emailError));
    }

    public void selectGender() {
        wait.until(ExpectedConditions.elementToBeClickable(genderMale)).click();
    }

    public void enterFirstName(String fname) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName)).sendKeys(fname);
    }

    public void enterLastName(String lname) {
        driver.findElement(lastName).sendKeys(lname);
    }

    public void selectDateOfBirth(String d, String m, String y) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(day)).sendKeys(d);
        driver.findElement(month).sendKeys(m);
        driver.findElement(year).sendKeys(y);
    }

    public void enterEmail(String mail) {
        driver.findElement(email).sendKeys(mail);
    }

    public void enterPassword(String pass) {
        driver.findElement(password).sendKeys(pass);
        driver.findElement(confirmPassword).sendKeys(pass);
    }

    public void clickRegister() {
        driver.findElement(registerButton).click();
    }

    public WebElement getSuccessMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
    }
}
