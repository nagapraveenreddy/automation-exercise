package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    // Calling constructor
    public HomePage(WebDriver driver){
        super(driver);
    }

    //Locators
    @FindBy(xpath = "//a[contains(@style,'color: orange')]")
    WebElement activePage;
    @FindBy(xpath = "//a[contains(@href,'login')]")
    WebElement signupOrLoginLink;
    @FindBy(xpath = "//a[text()=' Logged in as ']")
    WebElement loggedInAs;
    @FindBy(xpath = "//a[normalize-space()='Delete Account']")
    WebElement deleteAccount;

    //Action methods
    public String getActivePage(){
        return activePage.getText();
    }
    public String getPageTitle(){
        return driver.getTitle();
    }
    public void clickSignupOrLoginLink(){
        signupOrLoginLink.click();
    }
    public boolean isLoggedInAsDisplayed(){
        return loggedInAs.isDisplayed();
    }
    public void clickDeleteAccount(){
        deleteAccount.click();
    }
}
