package webutilites;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class calender {
	
	WebDriver driver;
	
	@Test
	public void pickCalenderdate() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
	//	driver.get("https://letcode.in/calendar");
		driver.get("https://demo.automationtesting.in/Datepicker.html");
		
		driver.findElement(By.xpath("//input[@id='datepicker1']")).click();
		
		String currentM = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
		String currentY = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
		
		
		System.out.println(currentM );
		System.out.println(currentY );
		
		while(!(currentM.equalsIgnoreCase("July") && currentY.equalsIgnoreCase("2023"))) {
			
			driver.findElement(By.xpath("//*[@class='ui-datepicker-prev ui-corner-all']"));
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		//  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@class='ui-datepicker-prev ui-corner-all']"));
			driver.findElement(By.xpath("//*[@class='ui-datepicker-prev ui-corner-all']")).click();
			
			 currentM = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			 currentY = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			
		
		}
		driver.findElement(By.xpath("(//td[@data-handler='selectDay'])[12]")).click();
	}

}
