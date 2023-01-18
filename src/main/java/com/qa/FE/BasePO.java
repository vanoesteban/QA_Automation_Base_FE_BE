package com.qa.FE;
import com.qa.FE.utils.GlobalVariables;
import com.qa.SeleniumDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePO <L extends WebElement> {

    public BasePO() throws Exception {
        PageFactory.initElements(SeleniumDriver.getInstance().getDriver(), this);
    }

    /* ******************* ELEMENTS ******************* */

    //
    @FindBy(id = "")
    protected L locator1;
    @FindBy(xpath = "")
    protected L locator2;

    /* ******************* METHODS ******************* */
    WebDriver driver = SeleniumDriver.getInstance().getDriver();
    WebDriverWait wait = new WebDriverWait(driver, GlobalVariables.defaultwait);

    public void loadPage(String url, String title) throws Exception {
        System.out.println("[INIT] loading Page");
        driver.navigate().to(url);
        verifyTitle(title);
        System.out.println("[END] loading Page");
    }

    public void verifyTitle(String title) throws AssertionError {
        System.out.println("[INIT] verify Title");
        Assert.assertEquals(driver.getTitle(), title, "verify page title");
        System.out.println("[END] verify Title");
    }

    public void visibilityofElement(L element, String description) {
        System.out.println("[INIT] visibility of "+ description);
        wait.until(ExpectedConditions.visibilityOf(element));
        System.out.println("[END] visibility of " + description);
    }

    public void invisibilityofElement(L element, String description) {
        System.out.println("[INIT] invisibility of "+ description);
        wait.until(ExpectedConditions.visibilityOf(element));
        System.out.println("[END] invisibility of " + description);    }

    public void clickElement(L element, String description) {
        System.out.println("[INIT] click " + description);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        System.out.println("[END] click "+ description);
    }

    public void inputString(L element, String data, String description){
        System.out.println("[INIT] input String into " + description);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(data);
        System.out.println("[INIT] input String into " + description);
    }

    public String getTextElement(L element, String description) {
        System.out.println("[INIT] get Text from " + description);
        String text = element.getText();
        System.out.println("[END] get Text from " + description);
        return text;
    }

    public String[][] getInfoFromTable(L element, int rows, int columns, String description){
        System.out.println("[INIT] get Text from " + description);
        String[][] tableinfo = new String[rows][columns];
        for (int i=0; i <= columns; i++){
            for (int j=0; j <= rows; j++) {
                tableinfo[i][j] = element.getText();
            }
        }
        System.out.println("[INIT] get Text from " + description);
        return tableinfo;
    }

}
