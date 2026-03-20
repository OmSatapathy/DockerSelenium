package web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Letcode {

	WebDriver driver;

	@Test
	public void addtoCart() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://letcode.in/home");

		List<WebElement> allIteam = driver
				.findElements(By.xpath("//button[@class='card-footer-item button is-link is-fullwidth']"));

		int maxValue = Integer.MIN_VALUE;
		WebElement maxElement = null;

		for (WebElement item : allIteam) {
			String text = item.getText().replaceAll("[^0-9]", ""); // Extract numbers
			if (!text.isEmpty()) {
				int value = Integer.parseInt(text);
				if (value > maxValue) {
					maxValue = value;
					maxElement = item; // Store the highest value element
				}
			}
		}

		// Click on the button with the highest value
		if (maxElement != null) {
			// Switch to the iframe first
			driver.switchTo().frame("aswift_1"); // Use correct iframe ID or index

			// Now find and click the button
			maxElement.click();

			// Switch back to the main content
			driver.switchTo().defaultContent();

			System.out.println("Clicking on element with highest value: " + maxValue);

		} else {
			System.out.println("No valid numerical values found in buttons.");
		}

	}
}
