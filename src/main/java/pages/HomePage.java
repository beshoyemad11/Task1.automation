package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {
    WebDriver driver;

    // --- Constructor ---
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // --- Locators ---
    private By registerLink = By.className("ico-register");
    private By loginLink = By.className("ico-login");
    private By wishlistTab = By.className("wishlist-label");
    private By currencyDropdown = By.id("customerCurrency");
    private By searchBox = By.id("small-searchterms");
    private By searchButton = By.cssSelector("button.button-1.search-box-button");

    private By productPrices = By.cssSelector(".prices");
    private By searchResults = By.cssSelector(".product-item");

    private By firstSlider = By.cssSelector("a.nivo-imageLink:nth-of-type(1)");
    private By secondSlider = By.cssSelector("a.nivo-imageLink:nth-of-type(2)");

    private By facebookIcon = By.cssSelector("li.facebook a");
    private By twitterIcon = By.cssSelector("li.twitter a");
    private By rssIcon = By.cssSelector("li.rss a");
    private By youtubeIcon = By.cssSelector("li.youtube a");

    private By wishlistButtonHTC = By.xpath("//a[@href='/htc-one-m8-android-l-50-lollipop']//following::button[contains(@class,'add-to-wishlist-button')]");
    private By successMsg = By.cssSelector("div.bar-notification.success");


    // --- Actions ---

    public void clickRegister() {
        driver.findElement(registerLink).click();
    }

    public void clickLogin() {
        driver.findElement(loginLink).click();
    }

    public void clickWishlistTab() {
        driver.findElement(wishlistTab).click();
    }

    public void selectCurrency(String visibleText) {
        driver.findElement(currencyDropdown).click();
        driver.findElement(By.xpath("//option[text()='" + visibleText + "']")).click();
    }

    public List<WebElement> getProductPrices() {
        return driver.findElements(productPrices);
    }

    public void searchFor(String query) {
        driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(query);
        driver.findElement(searchButton).click();
    }

    public List<WebElement> getSearchResults() {
        return driver.findElements(searchResults);
    }

    public void clickFirstSlider() {
        driver.findElement(firstSlider).click();
    }

    public void clickSecondSlider() {
        driver.findElement(secondSlider).click();
    }

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

    public void addHTCProductToWishlist() {
        driver.findElement(wishlistButtonHTC).click();
    }

    public WebElement getSuccessMsg() {
        return driver.findElement(successMsg);}
        public void clickSearchButton() {
            driver.findElement(By.cssSelector("button[class='button-1 search-box-button']")).click();}

    }

