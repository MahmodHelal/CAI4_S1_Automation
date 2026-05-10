package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = new EdgeDriver();
        Thread.sleep(2000);

        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");


        WebElement usernameTextbox =driver.findElement(By.id("user-name"));
        usernameTextbox.sendKeys("standard_user");


        WebElement passwordTextbox = driver.findElement(By.id("password"));
        passwordTextbox.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.className("submit-button"));
        Thread.sleep(2000);
        loginButton.click();

        Thread.sleep(2000);

        driver.navigate().back();
        Thread.sleep(2000);

        driver.navigate().refresh();
        Thread.sleep(2000);

        driver.navigate().forward();
        Thread.sleep(2000);


        driver.quit();
    }
}