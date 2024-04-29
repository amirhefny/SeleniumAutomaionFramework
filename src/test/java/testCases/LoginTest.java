package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.LoginPage;

public class LoginTest extends BaseTests {

    @Test
    public  void name() {
        LoginPage LoginPage = homePage.clickLoginButton();

        String resultTitle = LoginPage.BeforeLogin();
        String pageTitle = "Welcome, Please Sign In!";
        Assert.assertEquals(resultTitle,pageTitle,"PageTitle is incorrect");

        LoginPage.fillUsernameAndPass("aae@gmail.com", "123456789");
        LoginPage.ClickLogin();
        // Assert welcomeMessage

    }
}
