package org.igt.cdputils;

import org.openqa.selenium.devtools.v107.security.Security;

public class LoadInsecureWebSiteUsingDevTools extends CreateChromeDevToolsConnection{
	
	public static void loadInsecureWebsite() {
		CreateChromeDevToolsConnection.createConnection();
		devTools.send(Security.enable());
		devTools.send(Security.setIgnoreCertificateErrors(true));	
	}
}
