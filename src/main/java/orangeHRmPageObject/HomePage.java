package orangeHRmPageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	private By usernamefield = By.xpath("//input[@name='username']");
	private By password= By.xpath("//input[@name='password']");
	private By loginButton =  By.xpath("//button[@type='submit']");
	private By admin = By.xpath("//span[normalize-space()='Admin']");
	
	public void doLogin(String username, String Password) {
		
		driver.findElement(usernamefield).sendKeys(username);
		driver.findElement(password).sendKeys(Password);
		driver.findElement(loginButton).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(admin));
		
	}
}
