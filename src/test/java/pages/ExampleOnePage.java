package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExampleOnePage {
    WebDriver driver;

    By titleOfPage =  By.cssSelector(".example > h4");
    By startButtonBy = By.xpath("//div/button[text()=\"Start\"]");
    By resultBy = By.xpath("//div[@id=\"finish\"]/h4");
    String expectedTitle = "Example 1: Element on page that is hidden";
    String expectedText = "Hello World!";
    WebDriverWait wait;


    public ExampleOnePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver ,  Duration.ofSeconds(10));
    }

    public String getActualTitle(){
        return driver.findElement(titleOfPage).getText();
    }

    public String getExpectedText() {
        return expectedText;
    }

    public String getActualText(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(resultBy));
        return driver.findElement(resultBy).getText();
    }

    public String getExpectedTitle() {
        return expectedTitle;
    }

    public void clickStartButton(){
        driver.findElement(startButtonBy).click();
    }
}
