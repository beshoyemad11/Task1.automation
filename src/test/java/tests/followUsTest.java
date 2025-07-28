package tests;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.FollowUsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class followUsTest extends BaseTest {
    WebDriver driver;
    FollowUsPage followUsPage;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
        followUsPage = new FollowUsPage(driver);
    }

    @Test
    public void verifyFacebookLink() {
        followUsPage.clickFacebook();
        String url = followUsPage.switchToNewTabAndGetUrl();
        Assert.assertEquals(url, "https://www.facebook.com/nopCommerce");
    }

    @Test
    public void verifyTwitterLink() {
        followUsPage.clickTwitter();
        String url = followUsPage.switchToNewTabAndGetUrl();
        Assert.assertEquals(url, "https://x.com/nopCommerce");
    }

    @Test
    public void verifyRSSLink() {
        followUsPage.clickRSS();
        String url = followUsPage.switchToNewTabAndGetUrl();
        Assert.assertEquals(url, "https://demo.nopcommerce.com/news/rss/1");
    }

    @Test
    public void verifyYouTubeLink() {
        followUsPage.clickYouTube();
        String url = followUsPage.switchToNewTabAndGetUrl();
        Assert.assertEquals(url, "https://www.youtube.com/user/nopCommerce");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}