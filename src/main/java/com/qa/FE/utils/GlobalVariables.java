package com.qa.FE.utils;

import java.io.File;
import java.time.Duration;

public class GlobalVariables {
    //browser defaults
    public static final String BROWSER = "chrome";
    public static final String PLATFORM = "Windows 10";
    public static final String ENVIRONMENT = "local";

    //Waits
    public static final Duration defaultwait = Duration.ofSeconds(15);
    public static final Duration pageloadwait = Duration.ofSeconds(30);

    //Default URL
    public static final String LOGIN_URL = "";

    //Titles
    public  static final String TARGET_URL_title= "";
    public  static final String ACCOUNT_URL_title= "";


    //Paths
    public static final String TARGET_URL = "";
    public static String propertiesFile = "src/main/java/com.qa.com.qa.BE.FE.utils/selenium.properties";
    public static final String AP_Properties = new File(propertiesFile).getAbsolutePath();
}