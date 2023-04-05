package org.igt.webtest;

import org.igt.cdputils.EmulateOfflineNetworkInBrowser;
import org.igt.driver.DriverManager;
import org.testng.annotations.Test;

public class TestInOfflineNetworkMode {
	@Test
	public void offlineModeTest() {
		Integer aa = 100;
		Number freqvalue = (Number) aa;
		boolean value = true;
		Boolean offlinemode = (Boolean) value;
		EmulateOfflineNetworkInBrowser.setNetworkToOffline(offlinemode, freqvalue, freqvalue, freqvalue);
		try {
		DriverManager.getDriver().get("http://www.google.com");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
