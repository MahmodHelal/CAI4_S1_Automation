package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    WebDriver driver;
    String expectedTitle = "Welcome to the-internet";

    By actualTitleBy = By.className("heading");
    By formAuthLinkBy = By.linkText("Form Authentication");
    By checkboxBy = By.linkText("Checkboxes");
    By dropdownBy = By.linkText("Dropdown");
    By dynamicLoadingBy = By.linkText("Dynamic Loading");
    By javaScriptAlertsBy = By.linkText("JavaScript Alerts");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    public String getExpectedTitle(){
        return expectedTitle;
    }
    public String getActualTitle(){
        return driver.findElement(actualTitleBy).getText();
    }



    public LoginPage clickFormAuthLink(){
        driver.findElement(formAuthLinkBy).click();
        return  new LoginPage(driver);
    }



    public CheckboxPage clickCheckboxLink(){
        driver.findElement(checkboxBy).click();
        return new CheckboxPage(driver);
    }


    public DropdownPage clickDropdownLink(){
        driver.findElement(dropdownBy).click();
        return new DropdownPage(driver);
    }


    public DynamicLoadingPage clickDynamicLoadingLink(){
        driver.findElement(dynamicLoadingBy).click();
        return new DynamicLoadingPage(driver);
    }


    public JavaScriptAlertsPage clickJavaScriptAlertsLink(){
        driver.findElement(javaScriptAlertsBy).click();
        return new JavaScriptAlertsPage(driver);
    }

}
