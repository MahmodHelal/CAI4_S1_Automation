package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage {
    WebDriver driver;
    String expectedSuccessMsg = "You logged into a secure area!";
    By actualmsgBy = By.id("flash");
    String expectedTitle = "Secure Area";
    By actualTitleBy = By.tagName("h2");




    public SecureAreaPage(WebDriver driver){
        this.driver = driver;
    }


    public String getExpectedSuccessMsg() {
        return expectedSuccessMsg;
    }

    public String getExpectedTitle() {
        return expectedTitle;
    }



    public String getActualTitle(){
        return driver.findElement(actualTitleBy).getText();
    }

    public String getActualMessage(){
        return driver.findElement(actualmsgBy).getText();
    }
}
