package web;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertWindowhandle {
	static WebDriver driver;

	@BeforeMethod
	public void setup() { // Runs before each test method
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.automationtesting.in/Register.html");
	}

	@Test
	public void alert() {
		WebElement target = driver.findElement(By.xpath("//a[starts-with(text(),'SwitchTo')]"));
		Actions act = new Actions(driver);
		act.moveToElement(target).build().perform();
		driver.findElement(By.xpath("//a[starts-with(text(),'Alerts')]")).click();

		driver.findElement(By.xpath("//a[starts-with(text(),'Alert with Textbox ')]")).click();

		driver.findElement(By.xpath("//*[starts-with(text(),'click the button to demonstrate the prompt box ')]"))
				.click();

		Alert alt = driver.switchTo().alert();
		alt.sendKeys("Kiran");
		alt.accept();

	}

	@Test
	public void windowHandle() {
		WebElement target = driver.findElement(By.xpath("//a[starts-with(text(),'SwitchTo')]"));
		Actions act = new Actions(driver);
		act.moveToElement(target).build().perform();
		driver.findElement(By.xpath("//a[starts-with(text(),'Windows')]")).click();

		driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
		String parentWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();

		Iterator<String> itr = windows.iterator();
		while (itr.hasNext()) {
			String ChildWindow = itr.next();
			if (!parentWindow.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow);
				System.out.println(driver.getTitle());
				driver.close();
			}
		}
	}

	@Test
	public void multipleWindow() {
		WebElement target = driver.findElement(By.xpath("//a[starts-with(text(),'SwitchTo')]"));
		Actions act = new Actions(driver);
		act.moveToElement(target).build().perform();
		driver.findElement(By.xpath("//a[starts-with(text(),'Windows')]")).click();
		
		driver.findElement(By.xpath("//a[@href='#Multiple']")).click();
		
		WebElement ele=	driver.findElement(By.xpath("//button[@class='btn btn-info']"));
		
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", ele);
		


		String parent = driver.getWindowHandle();
		Set<String> childWinows = driver.getWindowHandles();

		Iterator<String> itr = childWinows.iterator();
		while (itr.hasNext()) {
			String childwin = itr.next();
			if (!parent.equalsIgnoreCase(childwin)) {
				driver.switchTo().window(childwin);
				System.out.println(driver.getCurrentUrl());
			}
		}
	}

	@AfterMethod
	public void tearDown() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.alertIsPresent());
		
		driver.quit();
	}
}
