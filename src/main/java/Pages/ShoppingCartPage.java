package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends MethodsHandle {
    private WebDriver driver;

    public ShoppingCartPage(WebDriver driver){
        this.driver = driver;
    }
    private final By productName = By.xpath("//td//a[@class='product-name']");
    private final By productSpecifications = By.xpath("//td//div[@class='attributes']");
    private final By quantityNumber = By.xpath("//td//input[@class='qty-input']");
    private final By itemPrice = By.xpath("//td//span[@class='product-unit-price']");
    private final By totalPrice =By.xpath("//td//span[@class='product-subtotal']");
    private final By updateCart = By.id("updatecart");

    public String productName(){
        return getText(driver, productName);
    }

    public String productSpecifications(){
        return getText(driver, productSpecifications);
    }

    public String quantityNumber(){
        fill(driver, quantityNumber, "3");
        return getAttribute(driver, quantityNumber,"value");

    }

    public String itemPrice(){
        return getText(driver, itemPrice);
    }

    public void updateCartPage() {
        click(driver, updateCart); //to update the Cart and calculate the total price
    }
    public String totalPrice(){
        return getText(driver, totalPrice);
    }




}
