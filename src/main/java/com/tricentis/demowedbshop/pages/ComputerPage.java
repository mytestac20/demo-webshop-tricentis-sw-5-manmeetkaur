package com.tricentis.demowedbshop.pages;

import com.aventstack.extentreports.Status;
import com.tricentis.demowedbshop.customelisteners.CustomListeners;
import com.tricentis.demowedbshop.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class ComputerPage extends Utility {



    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Computers']")
    WebElement computerText;


    @CacheLookup
    @FindBy(xpath = "//img[@title='Show products in category Desktops']")
    WebElement desktopTab;








    public String getComputerMessageRequired() {
        Reporter.log("get " + computerText.toString());
        CustomListeners.test.log(Status.PASS, "get " + computerText.toString());
        return getTextFromElement(computerText);
    }


    public void clickOnDesktop(){
        clickOnElement(desktopTab);
        Reporter.log("Get " + desktopTab.toString());
        CustomListeners.test.log(Status.PASS, "Get " + desktopTab);
    }





}
