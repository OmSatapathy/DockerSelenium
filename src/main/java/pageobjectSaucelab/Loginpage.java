package pageobjectSaucelab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {

	WebDriver driver;

    public Loginpage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='user-name']")
    private WebElement username;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement password;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement loginBTN;

    public void login(String email, String pwd) {
        username.sendKeys(email);
        password.sendKeys(pwd);
        loginBTN.click();
    }
}
