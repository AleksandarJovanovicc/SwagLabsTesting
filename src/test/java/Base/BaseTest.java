package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.time.Duration;

public class BaseTest {
    public WebDriver webDriver;
    public WebDriverWait webDriverWait;
    public LogInPage logInPage;
    public LogOutPage logOutPage;
    public InventoryPage inventoryPage;
    public CartPage cartPage;
    public CheckOutStepOnePage checkOutStepOnePage;
    public CheckOutStepTwoPage checkOutStepTwoPage;
    public CheckOutCompletePage checkOutCompletePage;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        logInPage = new LogInPage(webDriver);
        logOutPage = new LogOutPage(webDriver);
        inventoryPage = new InventoryPage(webDriver);
        cartPage = new CartPage(webDriver);
        checkOutStepOnePage = new CheckOutStepOnePage(webDriver);
        checkOutStepTwoPage = new CheckOutStepTwoPage(webDriver);
        checkOutCompletePage = new CheckOutCompletePage(webDriver);

    }

    @AfterClass
    public void tearDown(){
        webDriver.close();
        webDriver.quit();
    }
}
