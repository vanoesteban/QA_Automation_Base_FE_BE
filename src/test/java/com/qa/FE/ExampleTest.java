package com.qa.FE;
import com.qa.FE.utils.GlobalVariables;
import com.qa.SeleniumDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExampleTest extends ExamplePO {
    ExamplePO accountObjects = null;

    public ExampleTest() throws Exception {
    }


    @BeforeMethod(alwaysRun = true, enabled = true)
    protected void testSetup() throws Exception {
        System.out.println("\u001B[34m" + "" + "\u001B[0m");
        accountObjects = new ExamplePO();
        accountObjects.loadPage(GlobalVariables.LOGIN_URL, GlobalVariables.ACCOUNT_URL_title);
    }

    @AfterMethod(alwaysRun = true, enabled = true)
    protected void testTeardown() throws Exception {
        SeleniumDriver.getInstance().closeDriver();
    }

    @Test(alwaysRun = true, enabled = true)
    public void test_case_name() {
        System.out.println("[INIT] test_case_name");

        System.out.println("[END] test_case_name");
    }

}

