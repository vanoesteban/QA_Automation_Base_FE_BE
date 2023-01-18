package com.qa.FE;

import com.qa.FE.utils.GlobalVariables;
import com.qa.SeleniumDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest{

    public BaseTest() throws Exception {
    }

    @BeforeClass
    protected void classSetup() {
        try {
            SeleniumDriver.getInstance()
                          .setDriver(GlobalVariables.BROWSER, GlobalVariables.ENVIRONMENT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass(alwaysRun = true)
    protected void classTearDown() {

    }

}