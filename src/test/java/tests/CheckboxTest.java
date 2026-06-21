package tests;

import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CheckboxTest extends BaseTest {
    SoftAssert softAssert = new SoftAssert();
    @Test
    public void validateDefaultCheckboxState(){
        checkboxPage=homePage.clickCheckboxLink();
        System.out.println(checkboxPage.getCheckboxText());

        Assert.assertEquals(checkboxPage.getCountOfChecks(), 2);
        softAssert.assertTrue(checkboxPage.checkBoxNumber(0).isSelected(),"First checkbox is not selected");
        System.out.println("Hello All");
        Assert.assertTrue(checkboxPage.checkBoxNumber(1).isSelected());
        softAssert.assertAll();
    }
}
