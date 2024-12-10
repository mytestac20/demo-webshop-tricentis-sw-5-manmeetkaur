package com.tricentis.demowedbshop.testbase;

import com.tricentis.demowedbshop.propertyreader.PropertyReader;
import com.tricentis.demowedbshop.utility.Utility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase extends Utility {


    String browser = PropertyReader.getInstance().getProperty("browser");

    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        selectBrowser(browser);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        closeBrowser();
    }
}
