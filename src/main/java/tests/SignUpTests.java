package tests;

import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTests extends BaseTest{

    @Test(priority = 1)
    public void visitsTheSignupPage(){

        navPage.getSignUpLink().click();
        Assert.assertEquals(driver.getCurrentUrl(),baseURL + "/signup","Not on signup page.");

    }

    @Test(priority = 2)
    public void checkInputTypes(){

        navPage.getSignUpLink().click();
        Assert.assertEquals(signupPage.getInputForEmail().getAttribute("type"),"email","Incorrect attribute type for email.");
        Assert.assertEquals(signupPage.getInputForPassword().getAttribute("type"),"password","Incorrect attribute type for password.");
        Assert.assertEquals(signupPage.getInputForConfirmPassword().getAttribute("type"),"password","Incorrect attribute type for password.");

    }

    @Test(priority = 3)
    public void displaysErrorsWhenUserAlreadyExists(){

        navPage.getSignUpLink().click();
        Assert.assertEquals(driver.getCurrentUrl(),baseURL + "/signup","Not on signup page.");

        signupPage.getInputForName().sendKeys("Another User");
        signupPage.getInputForEmail().sendKeys("admin@admin.com");
        signupPage.getInputForPassword().sendKeys("12345");
        signupPage.getInputForConfirmPassword().sendKeys("12345");
        signupPage.getButtonSignMeUp().click();

        messagePopUpPAge.waitForPopUpToBeVisible();
        Assert.assertTrue(messagePopUpPAge.getElementsWithTextOfMessage().getText().contains("E-mail already exists"),"Error is not displayed when credentials are invalid");
        Assert.assertEquals(driver.getCurrentUrl(),baseURL + "/signup","Not on signup page.");

    }

    @Test(priority = 4)
    public void signUp() throws InterruptedException {

        navPage.getSignUpLink().click();
        signupPage.getInputForName().sendKeys("Aleksandar Jevtic");
        signupPage.getInputForEmail().sendKeys("aleksandar.jevtic@itbootcamp.rs");
        signupPage.getInputForPassword().sendKeys("12345");
        signupPage.getInputForConfirmPassword().sendKeys("12345");
        signupPage.getButtonSignMeUp().click();

        driver.get(baseURL+"/home");
        messagePopUpPAge.waitForVerifyBoxToBeVisible();

        Assert.assertTrue(messagePopUpPAge.getElementWithTextFromVerifyBox().getText().contains("IMPORTANT: Verify your account"),"Incorrect message for verification");
        messagePopUpPAge.getCloseButtonFromVerifyBox().click();
        navPage.getLogoutButton();

    }
}
