package datadriven;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Oleatest {

	WebDriver driver;

	@Test
    public void verifyOlea() {
		
		FirefoxOptions options = new FirefoxOptions();
		FirefoxProfile profile = new FirefoxProfile();

		// Set a normal user-agent string (example: Chrome on Windows)
		options.addPreference("general.useragent.override", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");
		   WebDriverManager.firefoxdriver().setup();
		 driver = new FirefoxDriver(options);
     
  
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        try {
            driver.get("https://www.google.com/");
            driver.manage().window().maximize();

            // Locate search bar and enter query
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys("olea global");

            // Wait for suggestions
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@role='listbox']//li")));

            // Retrieve and click correct suggestion
            List<WebElement> suggestions = driver.findElements(By.xpath("//ul[@role='listbox']//li"));
            boolean suggestionClicked = false;

            for (WebElement suggestion : suggestions) {
                System.out.println(suggestion.getText());
                if (suggestion.getText().toLowerCase().contains("olea global")) {
                    suggestion.click();
                    suggestionClicked = true;
                    break;
                }
            }

         //   assertTrue("Matching suggestion not found!", suggestionClicked);

            // Wait for search results
            wait.until(ExpectedConditions.titleContains("Olea Global"));

        } catch (NoSuchElementException e) {
            System.out.println("Element not found: " + e.getMessage());
            fail("Test failed due to missing element.");
        } finally {
            driver.quit();
        }
    }
}
