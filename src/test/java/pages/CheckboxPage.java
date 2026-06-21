package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckboxPage {
    WebDriver driver;
    By allChecks = By.xpath("//input[@type='checkbox']");
    By firstCheck = By.xpath("//input[@type='checkbox'][1]");
    By secondCheck = By.cssSelector("input[type='checkbox']:nth-of-type(2)");

    By checkboxBy = By.id("checkboxes");

    public CheckboxPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getCheckboxText(){
        return driver.findElement(checkboxBy).getText();
    }

    public int getCountOfChecks(){
  /*      int count = 0;
         List<WebElement> allElemnts =driver.findElements(allChecks);
         count = allElemnts.size();

        return count;*/

        return driver.findElements(allChecks).size();
    }

    public void clickFirstCheck(){
        driver.findElement(firstCheck).click();
    }

    public void clickSecondCheck(){
        driver.findElement(secondCheck).click();
    }
    public WebElement checkBoxNumber(int number){
        List<WebElement> allElements = driver.findElements(allChecks);
        return allElements.get(number);

    }
}
