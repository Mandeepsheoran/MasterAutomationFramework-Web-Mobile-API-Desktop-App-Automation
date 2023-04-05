package org.igt.webtest;

import org.igt.cdputils.ResponsiveTestingInMobileModeInBrowser;
import org.igt.driver.DriverManager;
import org.testng.annotations.Test;

public class ResponsiveModeTest {
	@Test
	public void iphoneDimensionInBrowserTest() throws InterruptedException {
		ResponsiveTestingInMobileModeInBrowser.runInResponsiveMode("390", "844", "100", true);
		DriverManager.getDriver().get("https://the-internet.herokuapp.com");	
		Thread.sleep(9000);
	}
}
