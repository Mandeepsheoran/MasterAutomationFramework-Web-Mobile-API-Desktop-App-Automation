package org.igt.listeners;

import org.igt.annotations.FrameworkAnnotations;
import org.igt.enums.CategoryType;
import org.igt.enums.TestType;
import org.igt.externaldashboard.SendResultToElastic;
import org.igt.externaldashboard.SendResultToInfluxDB;
import org.igt.reports.ExtentLogger;
import org.igt.reports.ExtentReport;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import com.influxdb.client.domain.WritePrecision;
import com.influxdb.client.write.Point;
import static org.igt.enums.LogType.PASS;
import static org.igt.reports.FrameworkLogger.log;
import java.io.IOException;
import java.time.Instant;

/**
 * Test Listener class to control the test execution as well as initiate/flush extent report.
 * Mar 4, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see ExtentReport
 * @see ExtentLogger
 */
public class TestListener implements ITestListener, ISuiteListener {	
	/**
	 * Method to create Extent report object to initialize the report creation.
	 * @author Mandeep Sheoran
	 * @see ExtentReport
	 */
	@Override
	public void onStart(ISuite suite) {
		try {
			ExtentReport.initReport();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method to execute Extent Report flush operation to create the report.
	 * @author Mandeep Sheoran
	 * @see ExtentReport
	 */
	@Override
	public void onFinish(ISuite suite) {
		ExtentReport.tearDownReport();
	}

	/**
	 * Create Extent report to log the data in Extent HTML report and pass the test case description.
	 * @author Mandeep Sheoran
	 * @see ExtentReport
	 */
	@Override
	public  void onTestStart(ITestResult result) {
		/*
		 * In case we want to print desc from execet sheet in extent report rather than desc from test annotation.		 	
             String description =result.getMethod().getDescription();
		 */		
		System.out.println("Just before test start");
		String description =result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Test.class).description();
		ExtentReport.createTest(description);
		System.out.println("AFter create test");
		/*
		 * In case we want to print actual method name in report.		 	
	            ExtentReport.createTest(result.getName());
		 */	
	}

	/**
	 * Log the data in Extent Report, Elastic Search and influxDB for passed test and pass the annotated values from test case.
	 * @author Mandeep Sheoran
	 * @see ExtentReport
	 * @see SendResultToElastic
	 */
	@Override
	public void onTestSuccess(ITestResult result) {		
		log(PASS,result.getMethod().getMethodName() +" is passed");
		String[] authors =result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).author();
		ExtentReport.addAuthors(authors);
		CategoryType categories =result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).category();
		ExtentReport.addCategory(categories);
		TestType method =result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).baseType();
		ExtentReport.addMethod(method);
		SendResultToElastic.sendStatusToElastic(result.getMethod().getDescription(), "PASS");
		postTestStatusToInfluxDB(result,"PASS");
	}

	/**
	 * Log the data in Extent Report, Elastic Search and InfluxDB for failed test and pass the annotated values from test case.
	 * @author Mandeep Sheoran
	 * @see ExtentReport
	 * @see SendResultToElastic
	 */
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Starting new test");
		ExtentLogger.fail(String.valueOf(result.getThrowable()));
		ExtentLogger.fail(result.getMethod().getMethodName()+" is failed",true);
		String[] authors =result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).author();
		ExtentReport.addAuthors(authors);
		CategoryType categories =result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).category();
		ExtentReport.addCategory(categories);
		TestType method =result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).baseType();
		ExtentReport.addMethod(method);
		SendResultToElastic.sendStatusToElastic(result.getMethod().getDescription(), "FAIL");
		postTestStatusToInfluxDB(result,"FAIL");
	}

	/**
	 * Log the data in Extent Report, Elastic Search, InfluxDB for skipped test and pass the annotated values from test case.
	 * @author Mandeep Sheoran
	 * @see ExtentReport
	 * @see SendResultToElastic
	 */
	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentLogger.skip(result.getMethod().getMethodName()+" is skipped");
		SendResultToElastic.sendStatusToElastic(result.getMethod().getDescription(), "SKIP");
		postTestStatusToInfluxDB(result,"SKIP");

	}
	
	/**
	 * Method to call InfluxDb post method at the end of complete execution.
	 * @author Mandeep Sheoran
	 */
	@Override
	public void onFinish(ITestContext context) {
		postTestClassStatusToInfluxDB(context);

	}
	
	/**
	 * Method to push data to InfluxDB with test related information.
	 * @author Mandeep Sheoran
	 * @see Point
	 * @see SendResultToInfluxDB
	 */
	private void postTestStatusToInfluxDB(ITestResult iTestResult, String status) {
	    Point point = Point.measurement("testmethod") .time(Instant.now(), WritePrecision.MS)
	        .addTag("testclass", iTestResult.getTestClass().getName()).addTag("name", iTestResult.getName())
	        .addTag("description", iTestResult.getMethod().getDescription()).addTag("result", status)
	        .addField("duration", (iTestResult.getEndMillis() - iTestResult.getStartMillis()));
	    SendResultToInfluxDB.sendStatusToInfluxDB(point);
	  }
	
	/**
	 * Method to push data to InfluxDB with class related information.
	 * @author Mandeep Sheoran
	 * @see Point
	 * @see SendResultToInfluxDB
	 */
	  private void postTestClassStatusToInfluxDB(ITestContext iTestContext) {
	    Point point = Point.measurement("testclass").time(Instant.now(), WritePrecision.MS)
	        .addTag("name", iTestContext.getAllTestMethods()[0].getTestClass().getName())
	        .addField("duration", (iTestContext.getEndDate().getTime() - iTestContext.getStartDate().getTime()));
	    SendResultToInfluxDB.sendStatusToInfluxDB(point);
	  }
}
