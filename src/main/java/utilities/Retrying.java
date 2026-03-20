package utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retrying implements IRetryAnalyzer {

	private int count = 0; // Instance variable to track retry attempts
	private static final int maxCount = 3; // Max retries allowed

	@Override
	public boolean retry(ITestResult result) {

		while (count < maxCount) {
			count++;
			return true;
		}

		return false;
	}

}
