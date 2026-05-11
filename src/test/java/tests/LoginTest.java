package tests;

import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void validLogin(){
        Assert.assertEquals(homePage.getActualTitle(),homePage.getExpectedTitle());
       loginPage = homePage.clickFormAuthLink(); // = new LoginPage(driver);
        Assert.assertEquals(loginPage.getActualTitle(),loginPage.getExpectedTitle());
        secureAreaPage =  loginPage.loginBy("tomsmith","SuperSecretPassword!");
        Assert.assertTrue(secureAreaPage.getActualTitle().contains(secureAreaPage.getActualTitle()));
        Assert.assertTrue(secureAreaPage.getActualMessage().contains(secureAreaPage.getExpectedSuccessMsg()));
    }


    @Test
    public void invalidUsernameLogin(){
        Assert.assertEquals(homePage.getActualTitle(),homePage.getExpectedTitle());
        loginPage = homePage.clickFormAuthLink(); // = new LoginPage(driver);
        Assert.assertEquals(loginPage.getActualTitle(),loginPage.getExpectedTitle());
        loginPage.loginBy("WrongUsername","SuperSecretPassword!");
        Assert.assertTrue(loginPage.getActualError().contains(loginPage.getExpectedErrorForInvalidUsername()));
    }


}
