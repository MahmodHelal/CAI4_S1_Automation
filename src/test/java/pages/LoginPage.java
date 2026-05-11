package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;

    String expectedTitle = "Login Page";
    By actualTitleBy = By.tagName("h2");
    String expectedErrorForInvalidPassword = "Your password is invalid!";
    String expectedErrorForInvalidUsername = "Your username is invalid!";
    By actualErrorBy = By.id("flash");
    By usernameTextboxBy = By.id("username");
    By passwordTextboxBy = By.id("password");
    By loginButtonBy = By.xpath("//i[@class='fa fa-2x fa-sign-in']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getExpectedTitle(){
        return expectedTitle;
    }

    public String getActualTitle(){
        return driver.findElement(actualTitleBy).getText();
    }

    public String getExpectedErrorForInvalidPassword(){
        return expectedErrorForInvalidPassword;
    }

    public String getExpectedErrorForInvalidUsername(){
        return expectedErrorForInvalidUsername;
    }

    public String getActualError(){
        return driver.findElement(actualErrorBy).getText();
    }

    public SecureAreaPage loginBy(String name, String password){
        driver.findElement(usernameTextboxBy).sendKeys(name);
        driver.findElement(passwordTextboxBy).sendKeys(password);
        driver.findElement(loginButtonBy).click();
        return new SecureAreaPage(driver);
    }



}
