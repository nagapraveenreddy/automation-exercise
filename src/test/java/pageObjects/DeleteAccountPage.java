package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteAccountPage extends BasePage{
    //Calling constructor
    public DeleteAccountPage(WebDriver driver){
        super(driver);
    }

    //Locators
    @FindBy(xpath = "//b[normalize-space()='Account Deleted!']")
    WebElement accountDeletedText;
    @FindBy(xpath = "//a[@class='btn btn-primary']")
    WebElement continueButton;

    //Action Methods
    public boolean isAccountDeletedTextDisplayed(){
        return accountDeletedText.isDisplayed();
    }
    public void clickContinueButton(){
        continueButton.click();
    }

}
