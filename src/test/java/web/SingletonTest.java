package web;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SingletonTest {
	
	
	@Test
	public void setUp() {
		
		SingletonDesign.getInstance();
		SingletonDesign.runner();
	}

}
