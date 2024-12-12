package testBase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import pageObjects.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {
    public static WebDriver driver;
    public static HomePage homePage;
    public static LoginPage loginPage;
    public static SignupPage signupPage;
    public static AccountCreatedPage accountCreatedPage;
    public static DeleteAccountPage deleteAccountPage;
    public static Logger logger;
    public static Properties properties;

    @Parameters({"os","browser"})
    @BeforeClass
    public void setup(String os, String browser) throws IOException {

        switch (browser.toLowerCase()){
            case "chrome": driver = new ChromeDriver(); break;
            case "edge" : driver = new EdgeDriver(); break;
            case "firefox" : driver = new FirefoxDriver(); break;
            default: System.out.println("No matching browser"); return;
        }
        logger = LogManager.getLogger(this.getClass());
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        signupPage = new SignupPage(driver);
        accountCreatedPage = new AccountCreatedPage(driver);
        deleteAccountPage = new DeleteAccountPage(driver);

        //Loading config.properties file
        FileReader file = new FileReader("./src//test//resources//config.properties");
        properties = new Properties();
        properties.load(file);

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(properties.getProperty("appURL"));
        driver.manage().window().maximize();
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
