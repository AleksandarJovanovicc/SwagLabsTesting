package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static Helpers.Strings.*;
import static Helpers.URLs.*;

public class LogOutTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp(){
        webDriver.manage().window().maximize();
        webDriver.navigate().to(LOGINPAGE);
        logInPage.insertUsername(validUsername);
        logInPage.insertPassword(validPassword);
        logInPage.clickOnLogInButton();
    }

    @AfterMethod
    public void pageCleanUp(){
        webDriver.manage().deleteAllCookies();
    }

    @Test
    public void successfulLogOut(){
        logOutPage.clickMenuButton();
        logOutPage.clickLogOutButton();

        Assert.assertEquals(webDriver.getCurrentUrl(), LOGINPAGE, "Should be redirected to " + LOGINPAGE);
    }

    @Test
    public void about(){
        logOutPage.clickMenuButton();
        logOutPage.clickAbout();

        Assert.assertEquals(webDriver.getCurrentUrl(), ABOUTPAGE, "Should be redirected to " + ABOUTPAGE);
    }
}
