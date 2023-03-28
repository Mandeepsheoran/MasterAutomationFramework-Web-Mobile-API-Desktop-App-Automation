package org.igt.reports;

import org.igt.configfactory.ConfigFactory;
import org.igt.utils.ScreenShotUtils;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import io.restassured.http.Header;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

/**
 * External interface class to hide the unwanted implementations of Extent Report library <p>which are not required for API automation.
 * Mar 14, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see ExtentManager
 */
public final class ExtentLogger {

	private ExtentLogger() {};
	/**
	 * Method to mark the test as Pass to log it in reports.
	 * @author Mandeep Sheoran
	 * @see ExtentManager
	 */
	public static void pass(String message) {
		ExtentTest test =ExtentManager.getExtenttest();
		test.pass(message);
	}

	/**
	 * Method to mark the test as Fail to log it in reports.
	 * @author Mandeep Sheoran
	 * @see ExtentManager
	 */
	public static void fail(String message) {
		ExtentManager.getExtenttest().fail(MarkupHelper.createLabel(message,ExtentColor.RED));
	}

	/**
	 * Method to mark the test as Info to log it in reports.
	 * @author Mandeep Sheoran
	 * @see ExtentManager
	 */
	public static void info(String message) {
		ExtentManager.getExtenttest().info(MarkupHelper.createLabel(message,ExtentColor.BLUE));	
	}

	/**
	 * Method to mark the test as Skipped to log it in reports.
	 * @author Mandeep Sheoran
	 * @see ExtentManager
	 */
	public static void skip(String message) {
		ExtentManager.getExtenttest().skip(MarkupHelper.createLabel(message,ExtentColor.PURPLE));
	}
	
	/**
	 * To display test case pass log in report with screenshot requirement functionality.
	 * @param message
	 * @param isScreenshotNeeded
	 */
	public static void pass(String message, Boolean isScreenshotNeeded) {
		if(ConfigFactory.getConfig().isPassedScreenshotRequired().equalsIgnoreCase("yes")&& isScreenshotNeeded){
			ExtentManager.getExtenttest().pass(message, 
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtils.getBase64Image()).build());
		} else {
			pass(message);
		}
	}
	/**
	 * To display test case fail logs in report with screenshot requirement functionality.
	 * @param message
	 * @param isScreenshotNeeded
	 */
	public static void fail(String message, Boolean isScreenshotNeeded) {
		if(ConfigFactory.getConfig().isFailedScreenshotRequired().equalsIgnoreCase("yes")&& isScreenshotNeeded){
			ExtentManager.getExtenttest().fail(message, 
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtils.getBase64Image()).build());
		} else {
			fail(message);
		}
	}
	/**
	 * Method to log the response in reports.<p> Response message will be passed from test.
	 * @author Mandeep Sheoran
	 * @see ExtentManager
	 */
	public static void logResponse(String resmessage) {
		info("Response is given below");
		ExtentManager.getExtenttest().info(MarkupHelper.createCodeBlock(resmessage,CodeLanguage.JSON));
	}
	
	/**
	 * Method to log the request in reports.<p> Request will be passed from test specially POST related test.
	 * @author Mandeep Sheoran
	 * @see ExtentManager
	 */
	public static void logRequest(RequestSpecification reqspecification) {
		QueryableRequestSpecification query = SpecificationQuerier.query(reqspecification);
		info("Request body is given below");
		ExtentManager.getExtenttest().info(MarkupHelper.createCodeBlock(query.getBody(),CodeLanguage.JSON));
		for(Header header : query.getHeaders()) {
			info(header.getName() + " : " + header.getValue());
		}
	}
}
