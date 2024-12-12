package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    //Calling constructor
    public LoginPage(WebDriver driver){
        super(driver);
    }

    //Locators
    @FindBy(xpath = "//h2[normalize-space()='New User Signup!']")
    WebElement newUserSignupText;
    @FindBy(xpath = "//input[contains(@data-qa,'signup-name')]")
    WebElement signupName;
    @FindBy(xpath = "//input[contains(@data-qa,'signup-email')]")
    WebElement signupEmail;
    @FindBy(xpath = "//button[contains(@data-qa,'signup-button')]")
    WebElement signupButton;


    //Action Methods
    public boolean isNewUserSignupTextDisplayed(){
        return newUserSignupText.isDisplayed();
    }
    public void setSignupName(String signupName){
        this.signupName.sendKeys(signupName);
    }
    public void setSignupEmail(String signupEmail){
        this.signupEmail.sendKeys(signupEmail);
    }
    public void clickSignupButton(){
        signupButton.click();
    }
}
