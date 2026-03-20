package web;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandlers {

 static	WebDriver driver;
 
 
 @BeforeMethod
 public void setup() { // Runs before each test method
     WebDriverManager.chromedriver().setup();
     driver = new ChromeDriver();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     driver.get("https://demo.automationtesting.in/Register.html");
 }


	@Test(groups = {"smoke"})
	public void windowHandle() {

		WebElement allCounty = driver.findElement(By.xpath("//select[@type='text' and @id='Skills']"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Select sel = new Select(allCounty);
		sel.selectByVisibleText("Configuration");
		sel.selectByValue("CSS");

		List<WebElement> all = sel.getOptions();

		for (int i = 0; i < all.size(); i++) {

			System.out.println(all.get(i).getText());
		}

	}

	@Test(groups = {"smoke","e2e"})
	public void selectCountry() {
		WebElement allele = driver.findElement(By.xpath("//select[@id='country']"));
		Select sel = new Select(allele);
		List<WebElement> allElments = sel.getOptions();

		for (WebElement ele : allElments) {
                  System.out.println(ele.getText());
		}
	}
	@Test(groups={"e2e"})
	public void mouseInterction() {
		
		WebElement target =driver.findElement(By.xpath("//a[starts-with(text(),'Interactio')]"));
		Actions act = new Actions(driver);
		act.moveToElement(target).build().perform();
		WebElement tarElement =driver.findElement(By.xpath("//*[starts-with(text(),'Drag and Drop ')]"));
		act.moveToElement(tarElement).build().perform();
		
		WebElement dragdrop = driver.findElement(By.xpath("//a[starts-with(text(),'Static')]"));
		dragdrop.click();
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
