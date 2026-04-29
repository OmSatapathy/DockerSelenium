package web;

import java.time.Duration;

import org.mozilla.javascript.JavaScriptException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestComplete {

	WebDriver driver;
	
	@Test
	public void setUp() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notification");
		driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		
		driver.get("https://www.naukri.com/");
		WebElement ele =driver.findElement(By.id("login_Layer"));
	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		
		JavascriptExecutor js  = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", ele);
		
		Thread.sleep(5000);
	}
}
