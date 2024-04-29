package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WishListPage extends MethodsHandle{
    private WebDriver driver;
    private final By productName = By.xpath("//td//a[@class='product-name']");
    private final By productSpecifications = By.xpath("//td//div[@class='attributes']");
    private final By quantityNumber = By.xpath("//td//input[@class='qty-input']");
    private final By itemPrice = By.xpath("//td//span[@class='product-unit-price']");
    private final By totalPrice =By.xpath("//td//span[@class='product-subtotal']");
    private final By updateWishList =By.xpath("//button[@id ='updatecart']");

	public WishListPage(WebDriver driver){
        this.driver = driver;
    }

    public String productName(){
        return getText(driver, productName);
    }

    public String productSpecifications(){
        return getText(driver, productSpecifications);
    }

    public String quantityNumber(){
        click(driver, quantityNumber);
        fill(driver, quantityNumber, "3");
        return getAttribute(driver, quantityNumber,"value");
    }

    public String itemPrice(){
        return getText(driver, itemPrice);
    }

    public void updateWishList() {
        click(driver, updateWishList); //to update the wish list and calculate the total price
    }

    public String totalPrice(){
        return getText(driver, totalPrice);
    }
    public WebElement findElement(By by){
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

}
