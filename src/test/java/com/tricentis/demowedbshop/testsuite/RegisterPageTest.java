package com.tricentis.demowedbshop.testsuite;

import com.tricentis.demowedbshop.pages.HomePage;
import com.tricentis.demowedbshop.pages.RegisterPage;
import com.tricentis.demowedbshop.pages.RegisterResultPage;
import com.tricentis.demowedbshop.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterPageTest extends TestBase {


    HomePage homePage;
    RegisterPage registerPage;
    RegisterResultPage registerResultPage;


    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        registerPage = new RegisterPage();
        registerResultPage = new RegisterResultPage();
    }


    @Test(groups = {"sanity", "smoke", "regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully(){


        //Click on the Register Link
        homePage.clickOnRegister();


        //Verify "Register" text
        Assert.assertEquals(registerPage.getRegisterText(), "Register");
    }


    @Test(groups = {"smoke", "regression"})
    public void verifyThatFirstNameLastNameEmailPasswordAndConfirmPasswordFieldsAreMandatory(){


        //Click on the Register Link
        homePage.clickOnRegister();


        //Click on the "Register" button
        registerPage.clickOnRegisterButton();


        //Verify the error message "First name is required."
        Assert.assertEquals(registerPage.getFirstNameRequired(), "First name is required.");


        //Verify the error message "Last name is required."
        Assert.assertEquals(registerPage.getLastNameRequired(), "Last name is required.");


        //Verify the error message "Email is required."
        Assert.assertEquals(registerPage.getEmailRequired(), "Email is required.");


        //Verify the error message "Password is required."
        Assert.assertEquals(registerPage.getPasswordRequires(), "Password is required.");


        //Verify the error message "Password is required."
        Assert.assertEquals(registerPage.getPasswordRequires2(), "Password is required.");
    }

    @Test(groups = "regression")
    public void verifyThatUserShouldCreateAccountSuccessfully(){


        //Click on the Register Link
        homePage.clickOnRegister();


        //Select gender "Female"
        registerPage.clickOnGender();

        //Enter the first name
        registerPage.enterFirstNameField("rudraa");

        //Enter the last name
        registerPage.enterLastNameField("parekh");

        //Enter email
        registerPage.enterEmailField("parekhrudraa@gamil.com");

        //Enter password
        registerPage.enterPasswordField("Ludhiana@123");

        //Enter Confirm Password
        registerPage.enterConfirmPasswordField("Ludhiana@123");


        //Click on the "Register" button
        registerPage.clickOnRegisterButton();

        //Verify the message "Your registration completed"
        Assert.assertEquals(registerResultPage.getRegisterMessageRequired(), "Your registration completed");







    }
}
