package org.igt.webtest;

import org.igt.annotations.FrameworkAnnotations;
import org.igt.basetest.WebBase;
import org.igt.enums.CategoryType;
import org.igt.enums.LogType;
import org.igt.enums.TestType;
import org.igt.pomwebpages.LoginPage;
import org.igt.reports.FrameworkLogger;
import org.igt.utils.DateFormatUtils;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OrangeHRMTest extends WebBase{
	
	@BeforeMethod
	public static void beforeTest(ITestResult result) {
		FrameworkLogger.log(LogType.CONSOLE, "TEST STARTED : " + result.getMethod().getMethodName() + " at ["
				+ DateFormatUtils.regionalCurrentDateTimeFormat() + "]");
	}
	
	@Test(description="Get page title")
	@FrameworkAnnotations(author="Mandeep",category= CategoryType.REGRESSION , baseType=TestType.GET)
	public void getTitle() {
		String title =new LoginPage()
			      .getPageTitle();
		System.out.println("Page title of orange hrm is : "+title);
	}

}
