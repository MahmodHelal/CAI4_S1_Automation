package tests;

import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaScriptAlertsTest extends BaseTest {
    @Test
    public void validateJavaScriptAlerts(){
        javaScriptAlertsPage = homePage.clickJavaScriptAlertsLink();

        Assert.assertEquals(javaScriptAlertsPage.getActualTitle() , javaScriptAlertsPage.getExpectedTitle());


        javaScriptAlertsPage.clickJsAlert();
        javaScriptAlertsPage.acceptAlert();
        Assert.assertEquals(javaScriptAlertsPage.getActualText() , javaScriptAlertsPage.getExpectedTextForAlert());



        javaScriptAlertsPage.clickJsConfirm();
        javaScriptAlertsPage.cancelAlert();
        Assert.assertTrue(javaScriptAlertsPage.getActualText().contains("Cancel"));



        javaScriptAlertsPage.clickJsPrompt();
        javaScriptAlertsPage.sendPrompt("Helal");
        Assert.assertTrue(javaScriptAlertsPage.getActualText().contains("Helal"));







    }


}
