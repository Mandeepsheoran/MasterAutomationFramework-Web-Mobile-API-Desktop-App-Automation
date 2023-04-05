package org.igt.cdputils;

import java.util.Optional;
import org.openqa.selenium.devtools.v107.network.Network;

/**
 * Class to provide methods to intercept the network call from application along with details
 * April 4, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0   
 * @see Network
 * @see CreateChromeDevToolsConnection
 */
public class InterceptNetworkTrafficLogsFromBrowser extends CreateChromeDevToolsConnection {
	/**
	 * Method to enable the network and print the URl and methods from network calls.
	 * April 4, 2023
	 * @author Mandeep Sheoran
	 */
	public static void getNetworkLogs() {
		CreateChromeDevToolsConnection.createConnection();		
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		devTools.addListener(Network.requestWillBeSent(), 
				request -> {
		          	System.out.println(request.getRequest().getUrl());
			        System.out.println(request.getRequest().getMethod());
		});
	}
}
