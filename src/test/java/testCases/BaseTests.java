package testCases;
import com.google.common.io.Files;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import Pages.HomePage;


import java.io.File;
import java.io.IOException;


public class BaseTests {
private WebDriver driver;
protected HomePage homePage;

@BeforeClass
public void setUp() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();

     homePage = new HomePage(driver);


}

@BeforeMethod
public void goHome() {
    driver.get("https://demo.nopcommerce.com/");

}
@AfterMethod
public void recordFailure(ITestResult result){

    if(ITestResult.FAILURE == result.getStatus()){
        var camera = (TakesScreenshot)driver;
        File screenshot = camera.getScreenshotAs(OutputType.FILE);
        try {
            Files.move(screenshot,new File("reports/screenshots" + result.getName() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

@AfterClass
public void tearDown() {
    //driver.quit();
}
}
