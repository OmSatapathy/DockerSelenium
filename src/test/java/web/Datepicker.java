package web;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Datepicker {

	WebDriver driver;

	@Test
	public void verifyDatepicker() {
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disabale-notification");
		opt.setAcceptInsecureCerts(true);

		driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.get("https://mui.com/x/react-date-pickers/date-picker/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.id("datetimepicker1")).click();

		String targetMonth = "December";
		String targetYear = "2028";
		String targetDay = "25";
		
		while(true) {
			
		}

	}
}
