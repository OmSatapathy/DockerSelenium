package TestOrangeHRM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BasePageOranageHRM.BaseTest;
import BasePageOranageHRM.Drivermaager;
import orangeHRmPageObject.HomePage;

public class HomepageTest extends BaseTest {

	@Test
	public void verifyLogin() {
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php");
		HomePage hm = new HomePage(driver);
		hm.doLogin("Admin", "admin123");

		driver.getCurrentUrl();
		System.out.println(driver.getCurrentUrl());
	}

}
