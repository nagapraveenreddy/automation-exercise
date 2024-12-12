package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.BaseClass;

public class TC001_RegisterUser extends BaseClass {

    @Test
    public void Test_RegisterUser(){
        try{
            String activePage = homePage.getActivePage();
            Assert.assertEquals(activePage,"Home");
            homePage.clickSignupOrLoginLink();
            boolean signupOrLoginPageStatus = loginPage.isNewUserSignupTextDisplayed();
            Assert.assertTrue(signupOrLoginPageStatus);
            loginPage.setSignupName("test");
            loginPage.setSignupEmail("admin@praveen.com");
            loginPage.clickSignupButton();
            boolean signupPageStatus = signupPage.isEnterAccountInformationTextDisplayed();
            Assert.assertTrue(signupPageStatus);

            signupPage.clickTitle_mr_radio();
            if(signupPage.isNameEmpty()){
                signupPage.setName("test");
            }
            if(signupPage.isEmailEmpty() && signupPage.isEmailEnabled()){
                signupPage.setEmail("admin@praveen.com");
            }

            signupPage.setPassword("admin");
            signupPage.setDay("24");
            signupPage.setMonth("November");
            signupPage.setYear("1999");
            signupPage.selectNewsletter();
            signupPage.selectSpecialOffers();
            signupPage.setFirstName("test");
            signupPage.setLastName("test");
            signupPage.setCompany("test");
            signupPage.setAddress1("main road");
            signupPage.setAddress2("Vishnupur");
            signupPage.setCountry("India");
            signupPage.setState("Andhra Pradesh");
            signupPage.setCity("Bhimavaram");
            signupPage.setZipcode("534124");
            signupPage.setMobileNumber("9999999999");
            signupPage.clickCreateAccount();

            boolean accountCreatedStatus = accountCreatedPage.isAccountCreatedTextDisplayed();
            Assert.assertTrue(accountCreatedStatus);
            accountCreatedPage.clickContinueButton();

            boolean loginStatus = homePage.isLoggedInAsDisplayed();
            Assert.assertTrue(loginStatus);

            homePage.clickDeleteAccount();

            boolean deleteStatus = deleteAccountPage.isAccountDeletedTextDisplayed();
            Assert.assertTrue(deleteStatus);
            deleteAccountPage.clickContinueButton();
        }
        catch (Exception e) {
            Assert.fail();
        }

    }
}
