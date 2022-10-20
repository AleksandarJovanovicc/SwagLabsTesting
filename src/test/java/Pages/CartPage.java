package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CartPage {
    WebDriver webDriver;

    public CartPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public void goToCart(){
        webDriver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
    }

    public void clickRemoveButton(){
        webDriver.findElement(By.xpath("//*[@id=\"remove-test.allthethings()-t-shirt-(red)\"]")).click();
    }

    public void clickContinueShoppingButton(){
        webDriver.findElement(By.xpath("//*[@id=\"continue-shopping\"]")).click();
    }

    public void clickCheckOutButton(){
        webDriver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();
    }
}
