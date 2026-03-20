package web;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragDrop {


	 static	WebDriver driver;
	 
	
	 @BeforeMethod
	 public void setup() { // Runs before each test method
	     WebDriverManager.chromedriver().setup();
	     driver = new ChromeDriver();
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	     driver.get("https://demoqa.com/droppable/");
	 }

	@Test
	public void drag_drop() {
	WebElement source= 	driver.findElement(By.xpath("//div[@id='draggable']"));
	WebElement target = driver.findElement(By.xpath("//div[@id='droppable']"));
	
	Actions act = new Actions(driver);
	act.dragAndDrop(source, target).build().perform();
	
	String message= target.getText();
	Assert.assertEquals(message, "Dropped!");
	
	}
	
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
