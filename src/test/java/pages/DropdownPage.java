package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage {
    WebDriver driver;
    By dropdownBy = By.cssSelector("#dropdown");
    Select select ;


    public DropdownPage(WebDriver driver) {
        this.driver = driver;
        select = new Select(driver.findElement(dropdownBy));
    }


    public void selectOptionByVisibleText(String option) {
        select.selectByVisibleText(option);
    }

    public void selectOptionByValue(String option) {
        select.selectByValue(option);
    }
}
