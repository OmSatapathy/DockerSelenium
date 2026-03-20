package BasePageOranageHRM;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Drivermaager {

	public WebDriver setUp(String browser) {

		WebDriver driver = null;

		switch (browser.toLowerCase()) {

		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		case "remote":
			try {
				driver = new RemoteWebDriver(new URL("http://localhost:4444/"), new DesiredCapabilities());
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			break;

		default:
			throw new RuntimeException("Invalid browser: " + browser);
		}

		return driver;
	}
}