package com.glue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelTest {

    public static void main(String[] args){
        System.setProperty("webdriver.gecko.driver","/Users/Automation/drivers/geckodriver");
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        System.setProperty("webdriver.gecko.silentOutput", "true");

        WebDriver driver = new FirefoxDriver();
        driver.get("https://google.com");
        driver.manage().window().maximize();

    }
}
