package tests;

import baseTest.BaseTest;
import org.testng.annotations.Test;

public class DropdownTest extends BaseTest {
    @Test
    public void validateSelectByText(){
        dropdownPage = homePage.clickDropdownLink();

        dropdownPage.selectOptionByVisibleText("Option 1");
    }
}
