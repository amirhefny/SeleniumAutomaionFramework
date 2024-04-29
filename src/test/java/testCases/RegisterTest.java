package testCases;

import Pages.RegisterConfirmPage;
import Pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTests {
    @Test
    public void name() throws InterruptedException {

        RegisterPage RegisterPage =homePage.clickOnRegister();
        RegisterPage.fillRegisterInfoMale("Amir", "Ahmed", "5", "January", "2000", "vois","amdiddrf@gmail.com","ajaja5555", "ajaja5555");
        RegisterConfirmPage RegisterConfirmPage=RegisterPage.clickConfRegister();
        String Message = RegisterConfirmPage.getResultMsg();
        String resultMsgText = "Your registration completed";
        Assert.assertEquals(Message,resultMsgText,"Result Message incorrect");

    }

}