package org.igt.webtest;

import org.igt.basetest.WebBase;
import org.igt.cdputils.BrowserGeoLocationChange;
import org.igt.driver.DriverManager;
import org.testng.annotations.Test;

public class SetBrowserGeoLocationTest extends WebBase{
	@Test
	public void changeGeoLocation() {
		BrowserGeoLocationChange.changeGeoLocation(52.5043, 13.4501);
		DriverManager.getDriver().get("https://my-location.org/");
	}
}
