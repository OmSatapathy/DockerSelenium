package saucelabtest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Basetest {

	WebDriver driver;

	public WebDriver setUp(String bowser) throws MalformedURLException {

		DesiredCapabilities dc = new DesiredCapabilities();
		if (bowser.equalsIgnoreCase("chrome")) {

			dc.setBrowserName("chrome");
		} else if (bowser.equalsIgnoreCase("firefox")) {

			dc.setBrowserName("firefox");
		}

		driver = new RemoteWebDriver(new URL("http://localhost:4444/"), dc);
		return driver;

	}
}
