package saucelabtest;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

public class Seleniumgrid extends Basetest{
	
	
	@Test
	public void launch() throws MalformedURLException {
		driver = setUp("chrome");
		driver.get("https://github.com/SeleniumHQ/docker-selenium");
		System.out.println(driver.getTitle());
		
	}

}
