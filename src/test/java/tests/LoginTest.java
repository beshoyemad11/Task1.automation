package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {
        driver.get("https://demo.nopcommerce.com/login");

        LoginPage loginPage = new LoginPage(driver);
        SoftAssert softAssert = new SoftAssert();

        loginPage.enterEmail("test@example.com");
        loginPage.enterPassword("P@ssw0rd");
        loginPage.clickLogin();

        // Soft assertions
        softAssert.assertEquals(driver.getCurrentUrl(), "https://demo.nopcommerce.com/", "URL mismatch after login");
        softAssert.assertTrue(loginPage.isMyAccountTabDisplayed(), "'My account' tab not displayed");

        softAssert.assertAll();
    }

    @Test
    public void invalidLoginTest() {
        driver.get("https://demo.nopcommerce.com/login");

        LoginPage loginPage = new LoginPage(driver);
        SoftAssert softAssert = new SoftAssert();

        loginPage.enterEmail("wrong@example.com");
        loginPage.enterPassword("P@ssw0rd");
        loginPage.clickLogin();

        String errorMessage = loginPage.getErrorMessage();
        String errorColor = loginPage.getErrorColorHex();

        softAssert.assertTrue(errorMessage.contains("Login was unsuccessful."), "Error message text incorrect");
        softAssert.assertEquals(errorColor, "#e4434b", "Error message color mismatch");

        softAssert.assertAll();
    }
}
