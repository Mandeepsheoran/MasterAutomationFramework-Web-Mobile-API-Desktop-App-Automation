package org.igt.dashboardtest;


import org.assertj.core.api.Assertions;
import org.igt.annotations.FrameworkAnnotations;
import org.igt.basetest.WebBase;
import org.igt.driver.DriverManager;
import org.igt.enums.CategoryType;
import org.igt.enums.TestType;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;



public class ReportPortalWebTest extends WebBase {


	@Test(description = "Web test to send results to ReportPortal.io")
	@FrameworkAnnotations(author = "Mandeep", category = CategoryType.REGRESSION, baseType = TestType.WEB)
	public void rpDashboardTest() { 
		String title =DriverManager.getDriver().getTitle();
		
		Assertions.assertThat(title).withFailMessage("Incorrect page title on OrangeHRM.").isEqualTo("IGT");
	}
	
	

}
