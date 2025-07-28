package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.Set;

public class FollowUsPage {
    WebDriver driver;

    public FollowUsPage(WebDriver driver) {
        this.driver = driver;
    }

    By facebookIcon = By.linkText("Facebook");
    By twitterIcon = By.linkText("Twitter");
    By rssIcon = By.linkText("RSS");
    By youtubeIcon = By.linkText("YouTube");

    public void clickFacebook() {
        driver.findElement(facebookIcon).click();
    }

    public void clickTwitter() {
        driver.findElement(twitterIcon).click();
    }

    public void clickRSS() {
        driver.findElement(rssIcon).click();
    }

    public void clickYouTube() {
        driver.findElement(youtubeIcon).click();
    }

    public String switchToNewTabAndGetUrl() {
        String originalWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(originalWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }
        return driver.getCurrentUrl();
    }
}