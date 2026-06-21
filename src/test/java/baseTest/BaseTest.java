package baseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import pages.*;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected SecureAreaPage secureAreaPage;
    protected CheckboxPage checkboxPage;
    protected DropdownPage dropdownPage;
    protected DynamicLoadingPage dynamicLoadingPage;
    protected JavaScriptAlertsPage javaScriptAlertsPage;
    @BeforeSuite
    public void setUpSuite(){
        System.out.println("DB Connection");
    }


    @BeforeTest
    public void setUpTest(){
        System.out.println("Test Started");
    }







    @BeforeClass(groups = "smoke")
    public  void setUp(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        homePage = new HomePage(driver);
    }
    @BeforeMethod(groups = "smoke")
    public void goToHomaPage(){
        driver.get("https://the-internet.herokuapp.com/");
    }

    @AfterClass(groups = "smoke")
    public void tearDown(){
        driver.quit();
    }

    @AfterTest
    public void tearDownTest(){
        System.out.println("Test Finished");
    }
    @AfterSuite
    public void tearDownSuite(){
        System.out.println("DB Disconnection");
    }


}
