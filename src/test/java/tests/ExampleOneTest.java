package tests;

import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ExampleOnePage;

public class ExampleOneTest extends BaseTest {
    ExampleOnePage exampleOnePage;

    @Test
    public void validateExampleOne(){
        dynamicLoadingPage = homePage.clickDynamicLoadingLink();
        Assert.assertEquals(dynamicLoadingPage.getActualTitle() , dynamicLoadingPage.getExpectedTitle());

        exampleOnePage = dynamicLoadingPage.clickExampleOne();

        Assert.assertEquals(exampleOnePage.getActualTitle() , exampleOnePage.getExpectedTitle());

        exampleOnePage.clickStartButton();


        Assert.assertEquals(exampleOnePage.getActualText() , exampleOnePage.getExpectedText());
    }
}
