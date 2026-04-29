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

public class DropdownHandle {

	WebDriver driver;

	@Test
	public void verifyDropdown() {

		driver = new ChromeDriver();
		driver.get("https://getbootstrap.com/docs/5.0/components/dropdowns/");
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.findElement(By.id("bd-versions")).click();

		List<WebElement> allList = wait.until(
		        ExpectedConditions.visibilityOfAllElementsLocatedBy(
		            By.xpath("//ul[contains(@class,'show')]//li")
		        )
		    );

		for (int i = 0; i < allList.size(); i++) {

	        // 🔥 re-fetch element every time (important)
	        WebElement ele = driver.findElements(
	            By.xpath("//ul[contains(@class,'show')]//li")
	        ).get(i);

	        String text = ele.getText();
	        System.out.println(text);

	        if (text.contains("v5.0.2")) {
	            ele.click();
	            break;
	        }
		}
	}
}
