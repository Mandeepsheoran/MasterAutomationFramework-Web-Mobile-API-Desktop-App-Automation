package org.igt.webaccessibilitytest;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.igt.accessibilityBase.AxeCoreScan;
import org.igt.annotations.FrameworkAnnotations;
import org.igt.basetest.WebBase;
import org.igt.enums.CategoryType;
import org.igt.enums.LogType;
import org.igt.enums.TestType;
import org.igt.reports.FrameworkLogger;
import org.igt.utils.DateFormatUtils;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.deque.html.axecore.results.Results;
import com.deque.html.axecore.results.Rule;
import com.deque.html.axecore.selenium.AxeBuilder;

public class AccessibilityScan extends WebBase{
	
	@BeforeMethod
	public static void beforeTest(ITestResult result) {
		FrameworkLogger.log(LogType.CONSOLE, "TEST STARTED : " + result.getMethod().getMethodName() + " at ["
				+ DateFormatUtils.regionalCurrentDateTimeFormat() + "]");
	}

	@Test(description="Accessibility testing on Web Application")
	@FrameworkAnnotations(author="Mandeep", category=CategoryType.SMOKE, baseType=TestType.WEB)
	public void accessibilityTest() {
		Results result = AxeCoreScan.getAccessibilityScanResult();
		List<Rule> violations = result.getViolations();
		if (violations.size() == 0) {
			System.out.println("No violations found, hence accessibility testing is passesd.");
		} else {
			AxeCoreScan.saveReports(result);
			Assertions.assertThat(violations.size())
			     .as("Total violations found in application : "+ violations.size())
			     .withFailMessage("List of violations : "+ violations.toString())
			     .isEqualTo(0);
		}
	}
}
