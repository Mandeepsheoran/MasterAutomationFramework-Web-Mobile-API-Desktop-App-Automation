package org.igt.webtest;

import org.igt.cdputils.InterceptNetworkTrafficLogsFromBrowser;
import org.igt.driver.DriverManager;
import org.testng.annotations.Test;

public class NetworkInterceptTest {
	@Test
	public void getNetworkLogsTest() {
		InterceptNetworkTrafficLogsFromBrowser.getNetworkLogs();
		DriverManager.getDriver().get("https://the-internet.herokuapp.com/broken_images");
	}
}
