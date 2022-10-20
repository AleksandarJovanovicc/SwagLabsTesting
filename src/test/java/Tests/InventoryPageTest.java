package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Helpers.Strings.validPassword;
import static Helpers.Strings.validUsername;
import static Helpers.URLs.*;

public class InventoryPageTest extends BaseTest {

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
    public void addToCartProduct(){
        inventoryPage.scrollToProduct();
        inventoryPage.addToCartProduct();

        Assert.assertEquals(inventoryPage.checkForRemoveButton().getText(), "REMOVE", "Remove button should be displayed");
    }

    @Test
    public void twitterLink(){
        inventoryPage.scrollToTwitterLink();

        Assert.assertEquals(inventoryPage.getTwitterLink(), TWITTER_PAGE, "Should be redirected to " + TWITTER_PAGE);
    }

    @Test
    public void linkedInLink(){
        inventoryPage.scrollToLinkedInLink();

        Assert.assertEquals(inventoryPage.getLinkedInLink(), LINKEDIN_PAGE, "Should be redirected to " + LINKEDIN_PAGE);
    }

    @Test
    public void facebookLink(){
        inventoryPage.scrollToFacebookLink();

        Assert.assertEquals(inventoryPage.getFacebookLink(), FACEBOOK_PAGE, "Should be redirected to " + FACEBOOK_PAGE);
    }
}
