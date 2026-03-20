package flipkart;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LetCodeDemo {

	WebDriver driver;

	@Test
	public void productFinder() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://letcode.in/home");

		List<WebElement> allprod = driver
				.findElements(By.xpath("//button[@class='card-footer-item button is-link is-fullwidth']"));
		double maxprice = 0.0;
		double minPrice = Double.MAX_VALUE;
		WebElement highestPricedElement = null;
		WebElement lowestPricedElement = null;

		for (int i = 0; i < allprod.size(); i++) {
			String value = allprod.get(i).getText().replaceAll("₹", "").trim();
			double price = Double.parseDouble(value);

			if (price > maxprice) {
				maxprice = price;
				highestPricedElement = allprod.get(i);
			} else if (price < minPrice) {
				minPrice = price;
				lowestPricedElement = allprod.get(i);
			}
		}

		System.out.println(maxprice + ":" + minPrice);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1250)");
		js.executeScript("window.scrollBy(0,550)");
		
		// Click on the highest-priced product
		if (highestPricedElement != null) {
			highestPricedElement.click();
		} else {
			System.out.println("No product found to click.");
		}

		//driver.quit();
	}

}
