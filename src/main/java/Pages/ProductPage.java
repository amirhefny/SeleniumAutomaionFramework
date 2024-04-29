package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage extends MethodsHandle {
    private WebDriver driver;

    public ProductPage(WebDriver driver){
        this.driver = driver;
    }

    private final By selectProcessor = By.xpath("//select[@id='product_attribute_1']");
    private final By selectRAM = By.xpath("//select[@id='product_attribute_2']");
    private final By selectHDD = By.id("product_attribute_3_7");
    private final By selectOS = By.id("product_attribute_4_9");
    private final By selectSoftware = By.xpath("//input[@value='12']");
    private final By addToWishListButton = By.xpath("//button[@id='add-to-wishlist-button-1']");
    private final By addToCartButton = By.xpath("//button[@id='add-to-cart-button-1']");
    private final By successMessage = By.xpath("//p[@class='content']");
    private final By wishListPageButton = By.xpath("//span[@class='wishlist-label']");
    private final By wishItemsQuantity = By.xpath("//span[@class='wishlist-qty']");
    private final By cartItemsQuantity = By.xpath("//span[@class='cart-qty']");
    private final By cartPageButton = By.xpath("//span[@class='cart-label']");




    public void buildYourOwnComputer() {
        select(driver, selectProcessor, "index", "1");
        select(driver,selectRAM, "VisibleText","4GB [+$20.00]");
        click(driver, selectHDD);
        click(driver, selectOS);
        click(driver, selectSoftware);
    }

    public void clickAddToWishButton(){
        click(driver, addToWishListButton);
    }

    public void clickAddToCartButton(){
        click(driver, addToCartButton);
    }

    public String successMessageText(){
        return Element(successMessage).getText();
    }

    public String wishItemsQuantity(){
        return Element(wishItemsQuantity).getText();
    }

    public String cartItemsQuantity(){
        return Element(cartItemsQuantity).getText();
    }

    public WishListPage clickWishListPageButton(){
        click(driver, wishListPageButton);
        return new WishListPage(driver);
    }

    public ShoppingCartPage clickCartPageButton(){
        click(driver, cartPageButton);
        return new ShoppingCartPage(driver);
    }

    public WebElement Element(By by){
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
}