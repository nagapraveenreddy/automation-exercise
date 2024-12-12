package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountCreatedPage extends BasePage{
    //Calling Constructor
    public AccountCreatedPage(WebDriver driver){
        super(driver);
    }

    //Locators
    @FindBy(xpath = "//b[normalize-space()='Account Created!']")
    WebElement accountCreatedText;
    @FindBy(xpath = "//a[@class='btn btn-primary']")
    WebElement continueButton;

    //Action Methods
    public boolean isAccountCreatedTextDisplayed(){
        return accountCreatedText.isDisplayed();
    }
    public void clickContinueButton(){
        continueButton.click();
    }
}
