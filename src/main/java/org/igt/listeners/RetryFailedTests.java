package org.igt.listeners;

import org.igt.configfactory.ConfigFactory;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This will control the retry mechanism of failed test cases.<p>
 * By default we are using only one retry on failed cases.<p>
 * Mar 11, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see PropertyUtils
 */
public class RetryFailedTests implements IRetryAnalyzer {
	int count =0;
	int maxretry =1;
	@Override
	public boolean retry(ITestResult result) {
		boolean run = false;
			if((ConfigFactory.getConfig().isRetryRequired()).equalsIgnoreCase("yes")) {
			 run = count< maxretry;
			count++;
			return run;
         }		
		return run;
    }
}
