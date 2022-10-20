package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPage {
    WebDriver webDriver;

    public InventoryPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public void scrollToProduct() {
        WebElement ADD_TO_CART_BUTTON = webDriver.findElement(By.xpath("//*[@id=\"add-to-cart-test.allthethings()-t-shirt-(red)\"]"));
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", ADD_TO_CART_BUTTON);
    }

    public void addToCartProduct (){
        WebElement ADD_TO_CART_BUTTON = webDriver.findElement(By.xpath("//*[@id=\"add-to-cart-test.allthethings()-t-shirt-(red)\"]"));
        ADD_TO_CART_BUTTON.click();
    }

    public WebElement checkForRemoveButton(){
       return webDriver.findElement(By.xpath("//*[@id=\"remove-test.allthethings()-t-shirt-(red)\"]"));
    }

    public void scrollToTwitterLink() {
        WebElement twitterLink = webDriver.findElement(By.xpath("//*[@id=\"page_wrapper\"]/footer/ul/li[1]/a"));
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", twitterLink);
    }

    public String getTwitterLink(){
        WebElement twitterLink = webDriver.findElement(By.xpath("//*[@id=\"page_wrapper\"]/footer/ul/li[1]/a"));
        return twitterLink.getAttribute("href");
    }

    public String getLinkedInLink(){
        WebElement linkedInLink = webDriver.findElement(By.xpath("//*[@id=\"page_wrapper\"]/footer/ul/li[3]/a"));
        return linkedInLink.getAttribute("href");
    }

    public void scrollToLinkedInLink() {
        WebElement linkedInLink = webDriver.findElement(By.xpath("//*[@id=\"page_wrapper\"]/footer/ul/li[3]/a"));
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", linkedInLink);
    }

    public String getFacebookLink(){
        WebElement facebookLink = webDriver.findElement(By.xpath("//*[@id=\"page_wrapper\"]/footer/ul/li[2]/a"));
        return facebookLink.getAttribute("href");
    }

    public void scrollToFacebookLink() {
        WebElement facebookLink = webDriver.findElement(By.xpath("//*[@id=\"page_wrapper\"]/footer/ul/li[2]/a"));
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", facebookLink);
    }
}
