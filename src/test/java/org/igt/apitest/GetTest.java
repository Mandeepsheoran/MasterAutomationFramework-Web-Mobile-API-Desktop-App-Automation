package org.igt.apitest;

import static io.restassured.RestAssured.*;

import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.assertj.core.api.Assertions;
import org.igt.annotations.FrameworkAnnotations;
import org.igt.enums.CategoryType;
import org.igt.enums.LogType;
import org.igt.enums.TestType;
import org.igt.pageactionutil.SeleniumPageActions;
import org.igt.reports.ExtentLogger;
import org.igt.reports.FrameworkLogger;
import org.igt.requestbuilder.APIRequestBuilder;
import org.igt.utils.DateFormatUtils;
import static org.igt.enums.LogType.*;
import io.restassured.response.Response;

public class GetTest{	
	
	@BeforeMethod
	public static void beforeTest(ITestResult result) {
		FrameworkLogger.log(LogType.CONSOLE, "TEST STARTED : " + result.getMethod().getMethodName() + " at ["
				+ DateFormatUtils.regionalCurrentDateTimeFormat() + "]");
	}
	@Test(description="Get complete user details")
	@FrameworkAnnotations(author="Mandeep",category= CategoryType.REGRESSION , baseType=TestType.GET)
	public void getUserDetails() {
		Response response = APIRequestBuilder.buildRequestForGetCalls()
				.get("/api/users?page=2");
		String resp=response.prettyPrint();
		FrameworkLogger.log(LogType.CONSOLEANDEXTENTINFO, response.prettyPrint());
		ExtentLogger.logResponse(response.asPrettyString());
		Assertions.assertThat(response.getStatusCode())
		.as("Checking status code")
		.isEqualTo(200)
		.isNotEqualTo(201)
		.isNotNull();
	
	}
}
