package org.igt.apitest;

import static org.igt.enums.LogType.CONSOLEANDEXTENTINFO;
import static org.igt.reports.FrameworkLogger.log;
import java.io.IOException;
import org.assertj.core.api.Assertions;
import org.igt.annotations.FrameworkAnnotations;
import org.igt.constants.FrameworkConstant;
import org.igt.enums.CategoryType;
import org.igt.enums.TestType;
import org.igt.enums.LogType;
import org.igt.reports.ExtentLogger;
import org.igt.reports.FrameworkLogger;
import org.igt.requestbuilder.APIRequestBuilder;
import org.igt.utils.APIUtils;
import org.igt.utils.DateFormatUtils;
import org.igt.utils.RandomDataUtils;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostTest {
	
	@BeforeMethod
	public static void beforeTest(ITestResult result) {
		FrameworkLogger.log(LogType.CONSOLE, "TEST STARTED : " + result.getMethod().getMethodName() + " at ["
				+ DateFormatUtils.regionalCurrentDateTimeFormat() + "]");
	}
	
	@Test(description="Post user and other details",enabled=true)
	@FrameworkAnnotations(author="Krishna", category=CategoryType.SMOKE, baseType=TestType.POST)
	public void postDetails() throws IOException {
		String request = APIUtils.readFromExternalFile(FrameworkConstant.requestjsonfolderpath+"requestSC_Arr.json");
		//System.out.println("====== Request ===================="+request);
		RequestSpecification reqspecification =
				APIRequestBuilder.buildRequestForPostCalls()
				.body(request);
		ExtentLogger.logRequest(reqspecification);
		Response response = reqspecification
				.post("/api/users");
		ExtentLogger.logResponse(response.asPrettyString());
		//response.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema.json"));
	//	ApiUtils.saveReturnedPostResponse(FrameworkConstants.responsejsonfolderpath+"response.json", response);
		//ApiUtils.saveReturnedPostResponse(FrameworkConstants.responsejsonfolderpath+"response.json", response);
	//	log(CONSOLEANDEXTENTINFO,"API response is : " + response.getStatusCode());
		Assertions.assertThat(response.getStatusCode()).isEqualTo(201);
	}	
}
