package BasePageOranageHRM;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {
	protected WebDriver driver;

	@Parameters("browser")
	@BeforeMethod
	public void setUp(String browser) {
		Drivermaager dm = new Drivermaager();
		driver = dm.setUp(browser);
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
