package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class LogOutPage {
    WebDriver webDriver;

    public LogOutPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public void clickMenuButton(){
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0]. click();", webDriver.findElement(By.xpath("//*[@id=\"react-burger-menu-btn\"]")));
    }

    public void clickLogOutButton(){
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0]. click();", webDriver.findElement(By.xpath("//*[@id=\"logout_sidebar_link\"]")));
    }

    public void clickAbout(){
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0]. click();", webDriver.findElement(By.xpath("//*[@id=\"about_sidebar_link\"]")));
    }
}
