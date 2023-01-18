package com.qa;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import FE.utils.GlobalVariables;

public class SeleniumDriver {
    private ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();     //private ChromeDriver webDriver;
    public Properties properties = new Properties();
    private static SeleniumDriver instance = null;

    private SeleniumDriver(){}

    public static SeleniumDriver getInstance(){
        if(instance == null){
            instance = new SeleniumDriver();
        }
        return instance;
    }

    public final void setDriver(String browser, String environment) throws Exception{
        properties.load(new FileInputStream(GlobalVariables.AP_Properties));
        DesiredCapabilities capabilities = null;

        switch(browser){
            case "chrome":
                capabilities = new DesiredCapabilities();
                ChromeOptions chromeoptions = new ChromeOptions();
                Map<String, Object> chromePrefs = new HashMap<String, Object>();

                chromePrefs.put("credentials_enable_service",false);

                chromeoptions.setExperimentalOption("prefs", chromePrefs);
                chromeoptions.addArguments("--disable-plugins","--disable-extensions","--disable-popup-blocking");

                capabilities.setCapability(ChromeOptions.CAPABILITY, chromeoptions);
                capabilities.setCapability("applicationCacheEnabled", false);

                chromeoptions.merge(capabilities);

                if (environment.equalsIgnoreCase("local")) {
                    System.setProperty("webdriver.chrome.driver", properties.getProperty("chrome.driver.windows.path"));
                    webDriver.set(new ChromeDriver(chromeoptions.merge(capabilities))); //webDriver = new ChromeDriver(chromeoptions);
                }
                break;
                }
            getDriver().manage().window().maximize();
            getDriver().manage().timeouts().implicitlyWait(GlobalVariables.pageloadwait);

    }

    public WebDriver getDriver(){
    return webDriver.get();
    }

    public void closeDriver(){
    try{
        getDriver().quit();
    }
    catch (Exception e){
        System.out.println("cannot close the driver");
    }
    }
}
