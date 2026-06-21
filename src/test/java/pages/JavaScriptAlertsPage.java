package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JavaScriptAlertsPage {
    WebDriver driver;
    By titleOfPage = By.tagName("h3");
    String expectedTitle = "JavaScript Alerts";

    By jsAlertBy = By.xpath("//button[@onclick='jsAlert()']");
    By jsConfirmBy = By.cssSelector("button[onclick=\"jsConfirm()\"]");
    By jsPromptBy = By.xpath("//button[text()=\"Click for JS Prompt\"]");

    By resultBy = By.cssSelector("#result");


    String expectedTextForAlert = "You successfully clicked an alert";

    WebDriverWait wait;

    public JavaScriptAlertsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver , Duration.ofSeconds(10));
    }


    public void acceptAlert(){
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    public void cancelAlert(){
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().dismiss();
    }

    public void sendPrompt(String prompt){
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().sendKeys(prompt);
        acceptAlert();
    }


    public void clickJsAlert(){
        wait.until(ExpectedConditions.elementToBeClickable(jsAlertBy)).click();
//        driver.findElement(jsAlertBy).click();
    }

    public void clickJsConfirm(){
        wait.until(ExpectedConditions.elementToBeClickable(jsConfirmBy)).click();
    }

    public void clickJsPrompt(){
        wait.until(ExpectedConditions.elementToBeClickable(jsPromptBy)).click();
    }


    public String getExpectedTextForAlert() {
        return expectedTextForAlert;
    }

    public String getExpectedTitle() {
        return expectedTitle;
    }

    public String getActualTitle(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(titleOfPage)).getText();
    }

    public String getActualText(){
/*        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(resultBy));
        String text= result.getText();
        return text;*/

         return  wait.until(ExpectedConditions.visibilityOfElementLocated(resultBy)).getText();
    }
}
