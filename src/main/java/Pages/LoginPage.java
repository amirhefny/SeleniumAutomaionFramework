package Pages;

import Pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage  extends MethodsHandle {

    private WebDriver driver;

    private final By beforeLogin = By.xpath("//div[@class=\"page-title\"]//h1");
    private final By emailField = By.id("Email");
    private final By passwordField =By.id("Password");
    private final By loginButton = By.xpath("//button[@class=\"button-1 login-button\"]");


    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public String BeforeLogin(){
        return Element(beforeLogin).getText();
    }

    public void fillUsernameAndPass(String UserName,String Pass) {
        fill(driver, emailField, UserName);
        fill(driver, passwordField, Pass);
    }

    public HomePage ClickLogin() {
        click(driver, loginButton);
        return new HomePage(driver);
    }

    public WebElement Element(By by){
        var webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
