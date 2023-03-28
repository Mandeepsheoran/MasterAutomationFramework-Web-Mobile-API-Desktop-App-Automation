package org.igt.mobiletest;

import org.igt.annotations.FrameworkAnnotations;
import org.igt.basetest.IOSMobileBase;
import org.igt.enums.CategoryType;
import org.igt.enums.LogType;
import org.igt.enums.TestType;
import org.igt.pommobilepages.IosHomeScreen;
import org.igt.reports.FrameworkLogger;
import org.igt.utils.DateFormatUtils;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IOSMobileDemoTest extends IOSMobileBase{
	
	@BeforeMethod
	public static void beforeTest(ITestResult result) {
		FrameworkLogger.log(LogType.CONSOLE, "TEST STARTED : " + result.getMethod().getMethodName() + " at ["
				+ DateFormatUtils.regionalCurrentDateTimeFormat() + "]");
	}
	
	@Test(description="Launch demo IOS mobile app",enabled=false)
	@FrameworkAnnotations(author="Sumit", category=CategoryType.QUICKREGRESSION, baseType=TestType.IOS)
	public void iosTest() {
		IosHomeScreen.getInstance().addANewTask();
	}
}