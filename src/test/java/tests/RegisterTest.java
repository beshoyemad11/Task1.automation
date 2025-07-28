package tests;

import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegisterPage;

public class RegisterTest extends BaseTest {

    @Test
    public void validRegister() {
        driver.get("https://demo.nopcommerce.com/register");

        RegisterPage registerPage = new RegisterPage(driver);

        registerPage.selectGender();
        registerPage.enterFirstName("automation");
        registerPage.enterLastName("tester");
//        registerPage.selectDateOfBirth("10", "May", "1990");
        registerPage.enterEmail("test@example.com");
        registerPage.enterPassword("P@ssw0rd");
        registerPage.clickRegister();

        String message = registerPage.getSuccessMessage().getText();
        String color = registerPage.getSuccessMessage().getCssValue("color");
        String colorHex = Color.fromString(color).asHex();

        Assert.assertEquals(message, "Your registration completed");
        Assert.assertEquals(colorHex, "#4cb17c"); // rgba(76, 177, 124, 1)
    }
}
