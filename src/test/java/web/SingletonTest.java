package web;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SingletonTest {

	@Test
	public void setUp() {

		Runnable task = () -> {
			SingletonDesign.getInstance();
			SingletonDesign.runner();
		};

		Thread t1 = new Thread(task);
		Thread t2 = new Thread(task);
		Thread t3 = new Thread(task);
		
		t1.start();
		t2.start();
		t3.start();

		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
