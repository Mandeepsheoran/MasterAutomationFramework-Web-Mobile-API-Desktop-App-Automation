package org.igt.visualtest;

import static org.igt.visualautomation.ApplitoolEyesClassicRunnerMobile.*;
import org.igt.annotations.FrameworkAnnotations;
import org.igt.enums.CategoryType;
import org.igt.enums.LogType;
import org.igt.enums.TestType;
import org.igt.reports.FrameworkLogger;
import org.igt.utils.DateFormatUtils;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ApplitoolEyesMobileTest {
	
	@BeforeMethod
	public static void beforeTest(ITestResult result) {
		FrameworkLogger.log(LogType.CONSOLE, "TEST STARTED : " + result.getMethod().getMethodName() + " at ["
				+ DateFormatUtils.regionalCurrentDateTimeFormat() + "]");
	}

	@Test(description="Visual test on Android app")
	@FrameworkAnnotations(author="Mandeep", category=CategoryType.SMOKE, baseType=TestType.ANDROID)
	public void eyesFirstTestInMobile() {
		eyesSetup("Android-IGT", "First Test in Mobile");
		performVisualTest("HomePage");
		eyesTearDown();
	}
}