package org.igt.webtest;

import org.igt.cdputils.LoadInsecureWebSiteUsingDevTools;
import org.igt.driver.DriverManager;
import org.testng.annotations.Test;

public class LoadInsecureWebsiteTest {
	@Test
	public void openInsecureWebsiteTest() {
		LoadInsecureWebSiteUsingDevTools.loadInsecureWebsite();
		DriverManager.getDriver().get("https://www.expired.badssl.com");
	}
}
