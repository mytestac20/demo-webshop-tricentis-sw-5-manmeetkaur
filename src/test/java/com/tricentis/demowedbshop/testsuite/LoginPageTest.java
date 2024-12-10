package com.tricentis.demowedbshop.testsuite;

import com.tricentis.demowedbshop.pages.HomePage;
import com.tricentis.demowedbshop.pages.LoginPage;
import com.tricentis.demowedbshop.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {


    HomePage homePage;
    LoginPage loginPage;


    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        loginPage = new LoginPage();

    }




    @Test(groups = {"sanity", "smoke", "regression"})
    public void userShouldNavigateToLoginPageSuccessFully() throws InterruptedException {

        Thread.sleep(3000);


        //Click on the login link
        homePage.clickOnLogin();



        //verify that the "Welcome, Please Sign In!" message display
        Assert.assertEquals(loginPage.getWelcomeText(), "Welcome, Please Sign In!");

    }

    @Test(groups = {"sanity", "smoke", "regression"})
    public void verifyTheErrorMessageWithInValidCredentials() throws InterruptedException {

        Thread.sleep(3000);

        //Click on the login link
        homePage.clickOnLogin();


        //Enter EmailId
        loginPage.enterEmailId("parekhrudratsaxca@gmailesdf.com");


        //Enter Password
        loginPage.enterPassword("Ludhianaasd@123");


        //Click on the Login Button
        loginPage.clickOnLoginButton();


        //Verify that the Error message
        String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.\n"
                + "No customer account found";
        String actualErrorMessage = loginPage.getErrorMessage();
        Assert.assertEquals( expectedErrorMessage, actualErrorMessage,"Error message not displayed");

    }
    @Test(groups = {"smoke", "regression"})
    public void verifyThatUserShouldLogInSuccessFullyWithValidCredentials() throws InterruptedException {

        Thread.sleep(3000);

        //Click on the login link
        homePage.clickOnLogin();


        //Enter EmailId
        loginPage.enterEmailId("parekhrudraa@gmail.com");


        //Enter Password
        loginPage.enterPassword("Ludhiana@123");


        //Click on the Login Button
        loginPage.clickOnLoginButton();


        //Verify that the LogOut link is displayed
        Assert.assertEquals(loginPage.getLogoutText(), "Log out");

    }

    @Test(groups = "regression")
    public void VerifyThatUserShouldLogOutSuccessFully() throws InterruptedException {

        Thread.sleep(3000);

        //Click on the login link
        homePage.clickOnLogin();


        //Enter EmailId
        loginPage.enterEmailId("parekhrudraa@gmail.com");


        //Enter Password
        loginPage.enterPassword("Ludhiana@123");


        //Click on the Login Button
        loginPage.clickOnLoginButton();


        //Verify that the LogOut link is displayed
        Assert.assertEquals(loginPage.getLogoutText(), "Log out");

        //Verify that the LogIn Link Display
        Assert.assertEquals(homePage.getLoginText(), "Log in");


    }
}

