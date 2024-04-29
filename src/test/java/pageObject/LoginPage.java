package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    public void setUsername(String username) {
        WebElement usernameField = driver.findElement(By.name("uid"));

		usernameField.clear();
        usernameField.sendKeys(username);
    }
    public void setpassword(String password) {
        WebElement passwordField = driver.findElement(By.name("password"));

        passwordField.clear();
        passwordField.sendKeys(password);
    }
    public void clickLogin() {
        WebElement loginBtn = driver.findElement(By.name("btnLogin"));

        loginBtn.click();
    }
}
