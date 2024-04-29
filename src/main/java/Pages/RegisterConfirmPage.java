package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterConfirmPage {
    WebDriver driver;
    public RegisterConfirmPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By registerMessage = By.className("result");

    public String getResultMsg(){
        String ResultMessage=   driver.findElement(registerMessage).getText();
        return ResultMessage ;
    }
}