package testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pageObjects.*;

import java.time.Duration;

public class BaseClass {
    public static WebDriver driver;
    public static HomePage homePage;
    public static LoginPage loginPage;
    public static SignupPage signupPage;
    public static AccountCreatedPage accountCreatedPage;
    public static DeleteAccountPage deleteAccountPage;
    @BeforeClass
    public void setup(){
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        signupPage = new SignupPage(driver);
        accountCreatedPage = new AccountCreatedPage(driver);
        deleteAccountPage = new DeleteAccountPage(driver);
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://automationexercise.com/");
        driver.manage().window().maximize();
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
