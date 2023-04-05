package org.igt.webtest;

import org.igt.cdputils.EmulateOfflineNetworkInBrowser;
import org.igt.driver.DriverManager;
import org.testng.annotations.Test;

public class TestInSlowNetworkMode {
    @Test
	public void slowNetworkTest() {
		Integer aa = 100;
		Number freqvalue = (Number) aa;
		boolean value = false;
		Boolean offlinemode = (Boolean) value;
		EmulateOfflineNetworkInBrowser.setNetworkToOffline(offlinemode, freqvalue, freqvalue, freqvalue);
		DriverManager.getDriver().get("http://www.google.com");	
	}
}
