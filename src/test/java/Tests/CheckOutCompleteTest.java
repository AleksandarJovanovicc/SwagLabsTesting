package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Helpers.Strings.validPassword;
import static Helpers.Strings.validUsername;
import static Helpers.URLs.*;

public class CheckOutCompleteTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp(){
        webDriver.manage().window().maximize();
        webDriver.navigate().to(LOGINPAGE);
        logInPage.insertUsername(validUsername);
        logInPage.insertPassword(validPassword);
        logInPage.clickOnLogInButton();
        inventoryPage.scrollToProduct();
        inventoryPage.addToCartProduct();
        cartPage.goToCart();
        cartPage.clickCheckOutButton();
        checkOutStepOnePage.inputName();
        checkOutStepOnePage.inputLastName();
        checkOutStepOnePage.inputZipCode();
        checkOutStepOnePage.clickContinue();
        checkOutStepTwoPage.clickFinish();
    }

    @AfterMethod
    public void pageCleanUp(){
        webDriver.manage().deleteAllCookies();
    }

    @Test
    public void backHome(){
        checkOutCompletePage.clickBackHome();

        Assert.assertEquals(webDriver.getCurrentUrl(), INVENTORYPAGE, "Should be redirected to " + INVENTORYPAGE);
    }
}
