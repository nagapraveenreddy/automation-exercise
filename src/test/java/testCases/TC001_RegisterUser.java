package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.BaseClass;

public class TC001_RegisterUser extends BaseClass {

    @Test
    public void Test_RegisterUser(){
        logger.info("*** Started TC001_RegisterUser ***");
        try{
            String activePage = homePage.getActivePage();
            logger.info("Navigated to homepage and maximized browser");

            Assert.assertEquals(activePage,"Home");
            logger.info("Homepage validation success");

            homePage.clickSignupOrLoginLink();
            logger.info("Clicked on Signup/Login link");
            Thread.sleep(3000);

            boolean signupOrLoginPageStatus = loginPage.isNewUserSignupTextDisplayed();
            Assert.assertTrue(signupOrLoginPageStatus);
            logger.info("Signup/Login page Validation success");

            loginPage.setSignupName(properties.getProperty("name"));
            loginPage.setSignupEmail(properties.getProperty("email"));
            loginPage.clickSignupButton();
            logger.info("Provided Name & Email and clicked on Submit button");

            boolean signupPageStatus = signupPage.isEnterAccountInformationTextDisplayed();
            Assert.assertTrue(signupPageStatus);
            logger.info("Signup page Validation success");

            logger.info("Entering signup details.......");
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
            logger.info("Signup details entered successfully and clicked on create account button");

            boolean accountCreatedStatus = accountCreatedPage.isAccountCreatedTextDisplayed();
            Assert.assertTrue(accountCreatedStatus);
            accountCreatedPage.clickContinueButton();
            logger.info("Account created page Validation success and clicked on continue button");

            boolean loginStatus = homePage.isLoggedInAsDisplayed();
            Assert.assertTrue(loginStatus);
            logger.info("Validated User is login status");

            homePage.clickDeleteAccount();
            logger.info("Deleted account");

            boolean deleteStatus = deleteAccountPage.isAccountDeletedTextDisplayed();
            Assert.assertTrue(deleteStatus);
            deleteAccountPage.clickContinueButton();
            logger.info("Account deleted page Validated and clicked on continue button");
        }
        catch (Exception e) {
            Assert.fail();
        }
        finally {
            logger.info("*** Completed TC001_RegisterUser ***");
        }

    }
}
