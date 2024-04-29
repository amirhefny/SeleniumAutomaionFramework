package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Locale;

public class SearchPage  {
    private WebDriver driver;

    public SearchPage(WebDriver driver){
        this.driver = driver;
    }

    private final By searchBar = By.xpath("//input[@name='q']");
    private final By productsTitle = By.xpath("//h2[@class='product-title']");

    public boolean searchResultsContainWord(){
        boolean visible = true;
        String searched = findElement(searchBar).getAttribute("value");
        List<WebElement> searchResults = findElements(productsTitle);
        for(int i = 0; i < searchResults.size(); i++){
            if(!searchResults.get(i).getText().toLowerCase(Locale.ROOT).contains(searched.toLowerCase())){
                visible = false;
                break;
            }
        }
        return visible;
    }

    public WebElement findElement(By by){
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public List<WebElement> findElements(By by){
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }
}