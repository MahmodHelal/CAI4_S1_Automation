package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingPage {
    WebDriver driver;
    By titleOfPage = By.tagName("h3");
    String expectedTitle = "Dynamically Loaded Page Elements";

    By ex1By = By.partialLinkText("Example 1:");
    By ex2By = By.partialLinkText("Example 2:");

    public DynamicLoadingPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getActualTitle(){
        return driver.findElement(titleOfPage).getText();
    }
    public String getExpectedTitle(){
        return expectedTitle;
    }


    public ExampleOnePage clickExampleOne(){
        driver.findElement(ex1By).click();
        return new ExampleOnePage(driver);
    }
    public ExampleTwoPage clickExampleTwo(){
        driver.findElement(ex2By).click();
        return new ExampleTwoPage(driver);
    }



}
