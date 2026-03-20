package datadriven;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class DemoTest {

	public static void main(String[] args) {

		double maxNetworkValue = 0.0;
		List<String> lst = List.of("6.1 Mbps", "3.6 Mbps", "8.9 Mbps", "6.7 Mbps");

		for (String s : lst) {
			String text = s.replaceAll("Mbps", "");
			double value = Double.parseDouble(text);
			if(value>maxNetworkValue) {
				maxNetworkValue=value;
			}

		}
		
		System.out.println(maxNetworkValue);

	}
}
