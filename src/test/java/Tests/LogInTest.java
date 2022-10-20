package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Helpers.Strings.*;
import static Helpers.URLs.*;

public class LogInTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp(){
        webDriver.manage().window().maximize();
        webDriver.navigate().to(LOGINPAGE);
    }

    @AfterMethod
    public void pageCleanUp(){
        webDriver.manage().deleteAllCookies();
    }

    @Test
    public void successfulLogIn(){
        logInPage.insertUsername(validUsername);
        logInPage.insertPassword(validPassword);
        logInPage.clickOnLogInButton();

        Assert.assertEquals(webDriver.getCurrentUrl(), INVENTORYPAGE, "Should be redirected to " + INVENTORYPAGE);
    }

    @Test
    public void unsuccessfulLogInInvalidPassword(){
        logInPage.insertUsername(validUsername);
        logInPage.insertPassword(invalidPassword);
        logInPage.clickOnLogInButton();

        Assert.assertEquals(webDriver.getCurrentUrl(), LOGINPAGE, "Should be redirected to " + LOGINPAGE);
        Assert.assertEquals(logInPage.errorMessage(), errorMessageInvalidCredentials);
    }

    @Test
    public void unsuccessfulLogInUsernameMissing(){
        logInPage.insertUsername(usernameMissing);
        logInPage.insertPassword(validPassword);
        logInPage.clickOnLogInButton();

        Assert.assertEquals(webDriver.getCurrentUrl(), LOGINPAGE, "Should be redirected to " + LOGINPAGE);
        Assert.assertEquals(logInPage.errorMessage(), errorMessageUsernameMissing);
    }

    @Test
    public void unsuccessfulLogInInvalidUsername(){
        logInPage.insertUsername(invalidUsername);
        logInPage.insertPassword(validPassword);
        logInPage.clickOnLogInButton();

        Assert.assertEquals(webDriver.getCurrentUrl(), LOGINPAGE, "Should be redirected to " + LOGINPAGE);
        Assert.assertEquals(logInPage.errorMessage(), errorMessageInvalidCredentials);
    }

    @Test
    public void unsuccessfulLogInLockedUser(){
        logInPage.insertUsername(lockedUserUsername);
        logInPage.insertPassword(validPassword);
        logInPage.clickOnLogInButton();

        Assert.assertEquals(webDriver.getCurrentUrl(), LOGINPAGE, "Should be redirected " + LOGINPAGE);
        Assert.assertEquals(logInPage.errorMessage(), errorMessageLockedUser);
    }

    @Test
    public void unsuccessfulLogInPasswordMissing(){
        logInPage.insertUsername(validUsername);
        logInPage.insertPassword(passwordMissing);
        logInPage.clickOnLogInButton();

        Assert.assertEquals(webDriver.getCurrentUrl(), LOGINPAGE, "Should be redirected to " + LOGINPAGE);
        Assert.assertEquals(logInPage.errorMessage(), errorMessagePasswordMissing);
    }
}
