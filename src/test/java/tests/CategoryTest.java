package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CategoryPage;

public class CategoryTest extends BaseTest {

    @Test
    public void testHoverAndClickNotebooks() {
        driver.get("https://demo.nopcommerce.com/");
        CategoryPage categoryPage = new CategoryPage(driver);

        categoryPage.hoverAndClickNotebooks();

        String actualTitle = categoryPage.getPageTitle();
        Assert.assertEquals(actualTitle, "Notebooks", "The page title should be 'Notebooks'");
    }
}
