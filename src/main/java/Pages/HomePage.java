package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HomePage  extends MethodsHandle {


    WebDriver driver;

    //create Constractor

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private final By rgisterClick = By.linkText("Register");
    private final By loginButton = By.className("ico-login");
    private final By welcomeMessage = By.xpath("//div[@class=\"topic-block-title\"]//h2");
    private final By searchBar = By.id("small-searchterms");
    private final By searchButton = By.xpath("//button[@type='submit']");
    private final By selectProduct = By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[4]/div[2]/div[1]/div/div[2]/h2/a");
    private final By addToWishListButton = By.xpath("//div[@data-productid='4']//button[@title='Add to wishlist']");
    private final By addToCartButton = By.xpath("//div[@data-productid='18']//button[contains(@class,'add-to-cart')]");
    private final By faceBookButton = By.xpath("//li[@class='facebook']//a[@target='_blank']");
    private final By twitterButton = By.xpath("//li[@class='twitter']//a[@target='_blank']");
    private final By youTubeButton = By.xpath("//li[@class='youtube']//a[@target='_blank']");

    public RegisterPage clickOnRegister() {
        Element(rgisterClick).click();
        return new RegisterPage(driver);
    }
    public ProductPage chooseProduct() {
        click(driver, selectProduct);
        return new ProductPage(driver);
    }

    public String getWelcomeMsg() {
        return Element(welcomeMessage).getText();
    }

    public LoginPage clickLoginButton() {
        Element(loginButton).click();
        return new LoginPage(driver);
    }

    public void searchInput(String input) {
        fill(driver, searchBar, input);
    }

    public SearchPage clickSearchButton() {
        Element(searchButton).click();
        return new SearchPage(driver);
    }

    public ProductPage AddProductToWishList() {
        Element(addToWishListButton).click();
        return new ProductPage(driver);
    }

    public ProductPage AddProductToCart() {
        click(driver, addToCartButton);
        return new ProductPage(driver);
    }

    public FollowUsPage clickFaceBookButton(){
        click(driver, faceBookButton);
        return new FollowUsPage(driver);
    }
    public FollowUsPage clickTwitterButton(){
        click(driver, twitterButton);
        return new FollowUsPage(driver);
    }
    public FollowUsPage clickYouTubeButton(){
        click(driver, youTubeButton);
        return new FollowUsPage(driver);
    }

    public WebElement Element(By by) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static class FollowUsPage {
        private WebDriver driver;

        public FollowUsPage(WebDriver driver){
            this.driver = driver;
        }
        public List<String > getWindowsTitles(){
            List<String> pagesTitles = new ArrayList<>();
            var mainWindow = driver.getWindowHandle();
            var newWindows = driver.getWindowHandles();
            Iterator<String> iterator = newWindows.iterator();
            for (int i = 0; i < newWindows.size(); i++){
                String newWindow = iterator.next();
                if(!mainWindow.equals(newWindow)){

                    String pageTitle = driver.switchTo().window(newWindow).getCurrentUrl();
                    pagesTitles.add(pageTitle);
                }
            }
            return pagesTitles;
        }
    }
}