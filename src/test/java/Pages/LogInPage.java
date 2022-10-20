package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPage {
    WebDriver webDriver;

    public LogInPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public WebElement getUsername(){
        return webDriver.findElement(By.id("user-name"));
    }

    public WebElement getPassword(){
        return webDriver.findElement(By.id("password"));
    }

    public WebElement getLogInButton(){
        return webDriver.findElement(By.id("login-button"));
    }

    public WebElement getErrorMessage(){
        return webDriver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"));
    }

    public void insertUsername(String username){
        getUsername().clear();
        getUsername().sendKeys(username);
    }

    public void insertPassword(String password){
        getPassword().clear();
        getPassword().sendKeys(password);
    }

    public void clickOnLogInButton(){
        getLogInButton().click();
    }

    public String errorMessage(){
        return getErrorMessage().getText();
    }
}
