package web;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.apache.http.HttpConnection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {
	WebDriver driver;
	String urls;

	@Test
	public void verifyLinks() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		List<WebElement> lst = driver.findElements(By.tagName("a"));

		for (int i = 0; i < lst.size(); i++) {

			urls = lst.get(i).getAttribute("href");
			//System.out.println(urls);
			try {

				URL url = new URL(urls);
				HttpURLConnection con = (HttpURLConnection) url.openConnection();
				con.connect();

				int resCode = con.getResponseCode();

				if (resCode >= 400) {
					System.out.println(url + " is a broken link (Status Code: " + resCode + ")");
				}

			} catch (Exception e) {
				System.out.println(urls + " encountered an exception: " + e.getMessage());
			}
		}

	}

}
