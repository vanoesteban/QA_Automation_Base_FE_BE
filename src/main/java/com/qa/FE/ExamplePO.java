package com.qa.FE;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ExamplePO<L extends WebElement> extends BasePO {

    public ExamplePO() throws Exception {
        super();
    }

    /* ******************* ELEMENTS ******************* */

    //
    @FindBy(id = "")
    protected L locator1;
    @FindBy(xpath = "")
    protected L locator2;
    /* ******************* TEST CASES ******************* */

    public void specific_actions() {

    }

}
