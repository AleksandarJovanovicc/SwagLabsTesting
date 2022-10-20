package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutCompletePage {
    WebDriver webDriver;

    public CheckOutCompletePage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public void clickBackHome(){
        webDriver.findElement(By.xpath("//*[@id=\"back-to-products\"]")).click();
    }
}
