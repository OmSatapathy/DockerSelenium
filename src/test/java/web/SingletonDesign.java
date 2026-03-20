package web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SingletonDesign {

	private static WebDriver driver;

	private SingletonDesign() {

	}

	public WebDriver getInstance(WebDriver driver) {
		if (driver == null) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		}
		return driver;
	}

	public void runner() {
		driver.get("https://www.facebook.com/omprakash.satapathy.1");
		System.out.println(driver.getTitle());
	}
}
