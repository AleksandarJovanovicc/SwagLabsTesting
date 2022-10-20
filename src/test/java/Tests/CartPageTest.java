package Tests;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static Helpers.Strings.validPassword;
import static Helpers.Strings.validUsername;
import static Helpers.URLs.*;

public class CartPageTest extends BaseTest {

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

    @Test(priority = 10)
    public void goToCart(){
        cartPage.goToCart();

        Assert.assertEquals(webDriver.getCurrentUrl(), CARTPAGE, "Should be redirected to " + CARTPAGE);
    }

    @Test (priority = 30)
    public void removeFromCart(){
        cartPage.goToCart();
        cartPage.clickRemoveButton();

        ArrayList<WebElement> cartItems = (ArrayList<WebElement>) webDriver.findElements(By.className("cart_item"));
        Assert.assertEquals(cartItems.size(), 0, "Cart item should be removed");
    }

    @Test(priority = 20)
    public void continueShopping(){
        cartPage.goToCart();
        cartPage.clickContinueShoppingButton();

        Assert.assertEquals(webDriver.getCurrentUrl(), INVENTORYPAGE, "Should be redirected to " + INVENTORYPAGE);
    }

    @Test
    public void checkOutRedirection(){
        inventoryPage.scrollToProduct();
        inventoryPage.addToCartProduct();
        cartPage.goToCart();
        cartPage.clickCheckOutButton();

        Assert.assertEquals(webDriver.getCurrentUrl(), CHECKOUT_STEP_ONE_PAGE, "Should be redirected to " + CHECKOUT_STEP_ONE_PAGE);
    }
}
