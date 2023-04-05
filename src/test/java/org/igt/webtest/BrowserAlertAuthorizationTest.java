package org.igt.webtest;

import org.igt.basetest.WebBase;
import org.igt.driver.DriverManager;
import org.igt.utils.BrowserBasicAuthAlertPopup;
import org.testng.annotations.Test;

public class BrowserAlertAuthorizationTest extends WebBase{
	@Test
	public void authorizationTest() {
		BrowserBasicAuthAlertPopup.basicAuthBrowserAlert();
		DriverManager.getDriver().get("https://the-internet.herokuapp.com/basic_auth");
	}
}
