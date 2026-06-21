package tests;

import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ExampleTwoPage;

public class ExampleTwoTest extends BaseTest {

    ExampleTwoPage exampleTwoPage;

    @Test
    public void validateExampleTwo(){
        dynamicLoadingPage = homePage.clickDynamicLoadingLink();
        Assert.assertEquals(dynamicLoadingPage.getActualTitle() , dynamicLoadingPage.getExpectedTitle());

        exampleTwoPage = dynamicLoadingPage.clickExampleTwo();

        Assert.assertEquals(exampleTwoPage.getActualTitle() , exampleTwoPage.getExpectedTitle());

        exampleTwoPage.clickStartButton();

        Assert.assertEquals(exampleTwoPage.getActualText() , exampleTwoPage.getExpectedText());
    }
    
}
