package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOutStepOnePage {
    WebDriver webDriver;

    public CheckOutStepOnePage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public void inputName(){
        WebElement firstNameBox = webDriver.findElement(By.xpath("//*[@id=\"first-name\"]"));
        firstNameBox.clear();
        firstNameBox.sendKeys("Aleksandar");
    }

    public void inputLastName(){
        WebElement lastNameBox = webDriver.findElement(By.xpath("//*[@id=\"last-name\"]"));
        lastNameBox.clear();
        lastNameBox.sendKeys("Jovanovic");
    }

    public void inputZipCode(){
        WebElement zipCodeBox = webDriver.findElement(By.xpath("//*[@id=\"postal-code\"]"));
        zipCodeBox.sendKeys("11000");
    }

    public void clickContinue(){
        WebElement continueButton = webDriver.findElement(By.xpath("//*[@id=\"continue\"]"));
        continueButton.click();
    }

    public void clickCancel(){
        WebElement cancelButton = webDriver.findElement(By.xpath("//*[@id=\"cancel\"]"));
        cancelButton.click();
    }
}
