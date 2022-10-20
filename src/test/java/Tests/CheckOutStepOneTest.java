package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Helpers.Strings.validPassword;
import static Helpers.Strings.validUsername;
import static Helpers.URLs.*;

public class CheckOutStepOneTest extends BaseTest {

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
    public void checkOutStepOneContinue(){
        inventoryPage.scrollToProduct();
        inventoryPage.addToCartProduct();
        cartPage.goToCart();
        cartPage.clickCheckOutButton();
        checkOutStepOnePage.inputName();
        checkOutStepOnePage.inputLastName();
        checkOutStepOnePage.inputZipCode();
        checkOutStepOnePage.clickContinue();

        Assert.assertEquals(webDriver.getCurrentUrl(), CHECKOUT_STEP_TWO_PAGE, "Should be redirected to " + CHECKOUT_STEP_TWO_PAGE);
    }

    @Test
    public void checkOutStepOneCancel(){
        cartPage.goToCart();
        cartPage.clickCheckOutButton();
        checkOutStepOnePage.inputName();
        checkOutStepOnePage.inputLastName();
        checkOutStepOnePage.inputZipCode();
        checkOutStepOnePage.clickCancel();

        Assert.assertEquals(webDriver.getCurrentUrl(), CARTPAGE, "Should be redirected to " + CARTPAGE);
    }

}
