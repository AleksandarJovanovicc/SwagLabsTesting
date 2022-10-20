package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutStepTwoPage {
    WebDriver webDriver;

    public CheckOutStepTwoPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public void clickFinish(){
        webDriver.findElement(By.xpath("//*[@id=\"finish\"]")).click();
    }

    public void clickCancel(){
        webDriver.findElement(By.xpath("//*[@id=\"cancel\"]")).click();
    }
}
