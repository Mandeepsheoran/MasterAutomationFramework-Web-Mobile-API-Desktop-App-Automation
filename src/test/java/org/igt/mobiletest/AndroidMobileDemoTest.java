package org.igt.mobiletest;

import org.igt.annotations.FrameworkAnnotations;
import org.igt.basetest.AndroidMobileBase;
import org.igt.enums.CategoryType;
import org.igt.enums.LogType;
import org.igt.enums.TestType;
import org.igt.pommobilepages.HomeScreen;
import org.igt.reports.FrameworkLogger;
import org.igt.utils.DateFormatUtils;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AndroidMobileDemoTest extends AndroidMobileBase{
	
	@BeforeMethod
	public static void beforeTest(ITestResult result) {
		FrameworkLogger.log(LogType.CONSOLE, "TEST STARTED : " + result.getMethod().getMethodName() + " at ["
				+ DateFormatUtils.regionalCurrentDateTimeFormat() + "]");
	}
	
	
	@Test(description="Launch demo android mobile app",enabled=false)
	@FrameworkAnnotations(author="Mike", category=CategoryType.SMOKE, baseType=TestType.ANDROID)
	public void mobTest1() {
		HomeScreen.getHomeScreen().navigateToViewScreen().clickViewScreenElement("WebView");
	}

}
