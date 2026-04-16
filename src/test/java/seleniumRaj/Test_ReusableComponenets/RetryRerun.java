package seleniumRaj.Test_ReusableComponenets;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryRerun implements IRetryAnalyzer {
	int count = 0;
	int maxTry = 1;
	@Override
	public boolean retry(ITestResult result) {
		
		if (count < maxTry) {
			count++;
			return true; //retry test
		}

		return false; // retry stop
	}

}
