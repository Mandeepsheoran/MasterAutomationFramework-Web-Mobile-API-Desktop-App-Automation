package org.igt.visualtest;

import org.igt.basetest.WebBase;
import org.igt.enums.CategoryType;
import org.igt.enums.LogType;
import org.igt.enums.TestType;
import org.igt.reports.FrameworkLogger;
import org.igt.utils.DateFormatUtils;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.igt.visualautomation.ApplitoolEyesClassicRunnerWeb.*;
import org.igt.annotations.FrameworkAnnotations;

public class ApplitoolEyesWebTest extends WebBase{
	
	@BeforeMethod
	public static void beforeTest(ITestResult result) {
		FrameworkLogger.log(LogType.CONSOLE, "TEST STARTED : " + result.getMethod().getMethodName() + " at ["
				+ DateFormatUtils.regionalCurrentDateTimeFormat() + "]");
	}
	
	@Test(description="Visual test on web browser")
	@FrameworkAnnotations(author="Mandeep", category=CategoryType.SMOKE, baseType=TestType.WEB)
	public void eyesFirstTestWeb() { 
		eyesSetup();
		openEyes("OrangeHRM", "Login Page");
		checkLayout("Login Page - Layout check");
		checkStrict("Login Page - Strict check");
		tearDownEyes();
	}
}
