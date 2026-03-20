package flipkart;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchMobile {

	WebDriver driver;

	@Test
	public void samsungMobile() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Handle login pop-up if it appears
		try {
			WebElement closeButton = driver.findElement(By.xpath("//span[@role='button']"));
			if (closeButton.isDisplayed()) {
				closeButton.click();
			}
		} catch (Exception e) {
			System.out.println("No login popup found.");
		}

		driver.findElement(By.xpath("//input[@name='q']")).click();
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("samsung 5g mobile", Keys.ENTER);

		// Get all prices and corresponding product elements
		List<WebElement> priceElements = driver.findElements(By.xpath("//div[@class='Nx9bqj _4b5DiR']"));
		List<WebElement> productElements = driver.findElements(By.xpath("//div[@class='Nx9bqj _4b5DiR']/../../.."));

		int maxValue = 0;
		WebElement highestPricedElement = null;
		
		for (int i = 0; i < priceElements.size(); i++) {
			String num = priceElements.get(i).getText().replaceAll("₹", "").replaceAll(",", "");
			int price = Integer.parseInt(num);

			if (price > maxValue) {
				maxValue = price;
				highestPricedElement = productElements.get(i); // Directly use 'i' instead of indexOf()
			}
		}
		System.out.println("Highest Price: ₹" + maxValue);

		// Click on the highest-priced product
		if (highestPricedElement != null) {
			highestPricedElement.click();
		} else {
			System.out.println("No product found to click.");
		}
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.numberOfWindowsToBe(4));
	}
	
	
	

}
