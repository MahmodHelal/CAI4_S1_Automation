package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class DunnyHero {
    WebDriver driver;
    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }
    @BeforeMethod
    public void goToLoginPage(){
        driver.get("https://the-internet.herokuapp.com/");

        WebElement formLink = driver.findElement(By.linkText("Form Authentication"));
        formLink.click();
        String currentUrl = driver.getCurrentUrl();
/*        if (currentUrl.contains("login")) {
            System.out.println("Form Authentication page opened successfully.");
        } else {
            System.out.println("Form Authentication page did not open.");
        }*/

        Assert.assertEquals(currentUrl, "https://the-internet.herokuapp.com/login", "Form Authentication page did not open.");

        String pageTitle = driver.findElement(By.tagName("h2")).getText();

/*        if (pageTitle.equals("Login Page")) {
            System.out.println("Form Authentication page opened successfully.");
        } else {
            System.out.println("Form Authentication page did not open.");
        }*/

        Assert.assertEquals(pageTitle, "Login Page", "Form Authentication page did not open.");



    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }



    @Test(priority = 1)
    public void validLogin() {

/*        WebElement usernameTextbox = driver.findElement(By.id("username"));
        usernameTextbox.sendKeys("tomsmith");*/

        driver.findElement(By.id("username")).sendKeys("tomsmith");

        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();// use xpath //tagName[@attributeName='attributevalu']

        String expectedSuccessMessage = "You logged into a secure area!";
        String actualMessage = driver.findElement(By.id("flash")).getText();




        System.out.println("Before Assert");


        Assert.assertTrue(actualMessage.contains(expectedSuccessMessage), "Login failed.");

        System.out.println("After Assert");

    }

    @Test(priority = 2)
    public void invalidLoginByUsername() {

        driver.findElement(By.id("username")).sendKeys("Wrong username");

        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();// use xpath //tagName[@attributeName='attributevalu']

        String expectedErrorMessage = "Your username is invalid!";
        String actualMessage = driver.findElement(By.id("flash")).getText();


        if (actualMessage.contains(expectedErrorMessage)){
            System.out.println("Login Failed.");
        } else {
            System.out.println("Expected message: " + expectedErrorMessage);
            System.out.println("Actual message: " + actualMessage);
            System.out.println("Login failed.");
        }



    }

    @Test(priority = 3)
    public void invalidLoginByPassword() {

        driver.findElement(By.id("username")).sendKeys("tomsmith");

        driver.findElement(By.id("password")).sendKeys("wrongpassword!");

        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();// use xpath //tagName[@attributeName='attributevalu']

        String expectedErrorMessage = "Your password is invalid!";
        String actualMessage = driver.findElement(By.id("flash")).getText();


        if (actualMessage.contains(expectedErrorMessage)){
            System.out.println("Login Failed.");
        } else {
            System.out.println("Expected message: " + expectedErrorMessage);
            System.out.println("Actual message: " + actualMessage);
            System.out.println("Login Successful.");
        }




    }
}
