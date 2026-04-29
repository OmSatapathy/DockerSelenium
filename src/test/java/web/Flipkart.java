package web;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Flipkart {

	WebDriver driver;

	@Test
	public void setUp() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(
				"https://www.flipkart.com/search?q=samsung+mobile&as=on&as-show=on&otracker=AS_Query_HistoryAutoSuggest_1_2_na_na_na&otracker1=AS_Query_HistoryAutoSuggest_1_2_na_na_na&as-pos=1&as-type=HISTORY&suggestionId=samsung+mobile&requestId=1651f11f-059a-45a2-ac4e-8da19bddd0a1&as-searchtext=sa");

		List<WebElement> allprice = driver.findElements(By.xpath("//div[@class='hZ3P6w DeU9vF']"));

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (WebElement ele : allprice) {
			String priceText = ele.getText().replaceAll("[^0-9]", "");
			
			if(!priceText.isEmpty()) {
				int price = Integer.parseInt(priceText);
				
				if(price>max) {
					max = price;
				}
				if(price<min) {
					min= price;
				}
			}

		}

		
		System.out.println(max);
		System.out.println(min);
	}
}
