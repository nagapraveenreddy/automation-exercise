package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SignupPage extends BasePage{
    //Calling constructor
    public SignupPage(WebDriver driver){
        super(driver);
    }

    //Locators
    @FindBy(xpath = "//b[normalize-space()='Enter Account Information']")
    WebElement enterAccountInformationText;

    @FindBy(xpath = "//input[@id='id_gender1']")
    WebElement title_mr_radio;
    @FindBy(xpath = "//input[@id='id_gender2']")
    WebElement title_mrs_radio;
    @FindBy(xpath = "//input[@id='name']")
    WebElement name;
    @FindBy(xpath = "//input[@id='email']")
    WebElement email;
    @FindBy(xpath = "//input[@id='password']")
    WebElement password;

    @FindBy(xpath = "//select[@id='days']")
    WebElement daysDropdown;
    @FindBy(xpath = "//select[@id='months']")
    WebElement monthsDropdown;
    @FindBy(xpath = "//select[@id='years']")
    WebElement yearsDropdown;

    @FindBy(xpath = "//input[@id='newsletter']")
    WebElement newsletterCheckbox;
    @FindBy(xpath = "//input[@id='optin']")
    WebElement specialOffersCheckbox;
    @FindBy(xpath = "//input[@id='first_name']")
    WebElement firstName;
    @FindBy(xpath = "//input[@id='last_name']")
    WebElement lastName;
    @FindBy(xpath = "//input[@id='company']")
    WebElement company;
    @FindBy(xpath = "//input[@id='address1']")
    WebElement address1;
    @FindBy(xpath = "//input[@id='address2']")
    WebElement address2;
    @FindBy(xpath = "//select[@id='country']")
    WebElement countryDropdown;
    @FindBy(xpath = "//input[@id='state']")
    WebElement state;
    @FindBy(xpath = "//input[@id='city']")
    WebElement city;
    @FindBy(xpath = "//input[@id='zipcode']")
    WebElement zipcode;
    @FindBy(xpath = "//input[@id='mobile_number']")
    WebElement mobileNumber;
    @FindBy(xpath = "//button[normalize-space()='Create Account']")
    WebElement createAccountButton;

    //Action Methods
    public boolean isEnterAccountInformationTextDisplayed(){
        return enterAccountInformationText.isDisplayed();
    }

    public void clickTitle_mr_radio(){
        title_mr_radio.click();
    }
    public void clickTitle_mrs_radio(){
        title_mrs_radio.click();
    }
    public void setName(String name){
        this.name.sendKeys(name);
    }
    public boolean isNameEmpty(){
        String text = name.getDomProperty("value");
        return text==null || text.trim().isEmpty();

    }
    public void setEmail(String email){
        this.email.sendKeys(email);
    }
    public boolean isEmailEmpty(){
        String text = email.getDomProperty("value");
        return text==null || text.trim().isEmpty();

    }
    public boolean isEmailEnabled(){
        return email.isEnabled();

    }
    public void setPassword(String password){
        this.password.sendKeys(password);
    }
    public void setDay(String option){
        Select day = new Select(daysDropdown);
        day.selectByVisibleText(option);
    }
    public void setMonth(String option){
        Select month = new Select(monthsDropdown);
        month.selectByVisibleText(option);
    }
    public void setYear(String option){
        Select year = new Select(yearsDropdown);
        year.selectByVisibleText(option);
    }

    public void selectNewsletter(){
        newsletterCheckbox.click();
    }
    public void selectSpecialOffers(){
        specialOffersCheckbox.click();
    }
    public void setFirstName(String firstName){
        this.firstName.sendKeys(firstName);
    }
    public void setLastName(String lastName){
        this.lastName.sendKeys(lastName);
    }
    public void setCompany(String company){
        this.company.sendKeys(company);
    }
    public void setAddress1(String address1){
        this.address1.sendKeys(address1);
    }
    public void setAddress2(String address2){
        this.address2.sendKeys(address2);
    }

    public void setCountry(String option){
        Select country = new Select(countryDropdown);
        country.selectByVisibleText(option);
    }

    public void setState(String state){
        this.state.sendKeys(state);
    }
    public void setCity(String city){
        this.city.sendKeys(city);
    }
    public void setZipcode(String zipcode){
        this.zipcode.sendKeys(zipcode);
    }
    public void setMobileNumber(String mobileNumber){
        this.mobileNumber.sendKeys(mobileNumber);
    }
    public void clickCreateAccount(){
        createAccountButton.click();
    }

}
