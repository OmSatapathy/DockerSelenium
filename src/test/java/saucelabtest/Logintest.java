package saucelabtest;

import java.io.IOException;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjectSaucelab.Loginpage;
import utilities.TakescreenShot;

public class Logintest {

	WebDriver driver;

	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/v1/");
	}

	@Test(retryAnalyzer = utilities.Retrying.class)
	public void loginTest() throws IOException {
	    // Ensure driver is initialized
	    if (driver == null) {
	        throw new IllegalStateException("WebDriver is not initialized");
	    }

	    Loginpage loginPage = new Loginpage(driver);
	    loginPage.login("standard_user", "secret_sauce11"); // Passing valid credentials

	    TakescreenShot sc = new TakescreenShot();

	    try {
	        String currentUrl = driver.getCurrentUrl();
	        Assert.assertEquals(currentUrl, "https://www.saucedemo.com/inventory.html"); // Fixed URL
	        sc.takeScreenshot(driver); // Pass driver to screenshot method
	    } catch (Exception e) {
	        sc.takeScreenshot(driver); // Pass driver to screenshot method
	    }
	}


	@AfterTest
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
