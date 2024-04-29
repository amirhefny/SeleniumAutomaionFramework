package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends MethodsHandle {

    WebDriver driver;
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }



    private final By selectGender = By.id("gender-male");
    private final  By firstNameField = By.id("FirstName");
    private final  By lastNameField = By.id("LastName");
    private final  By birthDayField = By.name("DateOfBirthDay");
    private final  By birthMonthField = By.name("DateOfBirthMonth");
    private final  By birthYearField = By.name("DateOfBirthYear");
    private final  By emailField = By.id("Email");
    private final  By companyNameField = By.id("Company");
    private final  By passwordField = By.xpath("//*[@id=\"Password\"]");
    private final  By confirmPasswordField = By.id("ConfirmPassword");
    private final  By confirmRegisterButton = By.id("register-button");
    private final By GetValidationMessage = By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]");


    public void fillRegisterInfoMale(String firstName, String lastName,String day, String month, String year, String companyName,
                                     String email,String password, String confirmPassword) throws InterruptedException{

        click(driver,selectGender);
        fill(driver,firstNameField,firstName);
        fill(driver,lastNameField,lastName);
        Thread.sleep(200);
        select(driver,birthDayField,"index",day);
        select(driver,birthMonthField,"VisibleText",month);
        select(driver,birthYearField,"VisibleText",year);
        Thread.sleep(200);
        fill(driver,emailField,email);
        fill(driver,companyNameField,companyName);
        fill(driver,passwordField,password);
        Thread.sleep(200);
        fill(driver,confirmPasswordField,confirmPassword);
    }
    public RegisterConfirmPage clickConfRegister(){
        click(driver,confirmRegisterButton);
        return new RegisterConfirmPage(driver);
    }
