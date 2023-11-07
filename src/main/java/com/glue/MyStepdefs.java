package com.glue;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyStepdefs {
    WebDriver driver;
    @Given("User is on Home Page")
    public void userIsOnHomePage() {
        System.setProperty("webdriver.gecko.driver","/Users/Automation/drivers/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://google.com");
    }

    @When("User Navigate to LogIn Page")
    public void userNavigateToLogInPage() {
        
    }

    @And("User enters UserName and Password")
    public void userEntersUserNameAndPassword() {
    }
}
