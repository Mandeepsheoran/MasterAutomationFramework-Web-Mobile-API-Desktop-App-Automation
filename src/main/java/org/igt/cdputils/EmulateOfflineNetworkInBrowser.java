package org.igt.cdputils;

import java.util.Optional;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.ConnectionType;

/**
 * Class to provide methods to change the Geo location of the browser to test certain functionalities.
 * April 4, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see Network
 * @see CreateChromeDevToolsConnection
 */
public class EmulateOfflineNetworkInBrowser extends CreateChromeDevToolsConnection {
	/**
	 * Method to enable network connection and setup different connection type.
	 * April 4, 2023
	 * @author Mandeep Sheoran
	 */
	public static void setNetworkToOffline(Boolean offlineflag, Number latencyvalue, Number downloadthroughputvalue, Number uploadthroughputvalue) {
		CreateChromeDevToolsConnection.createConnection();
		devTools.send(Network.emulateNetworkConditions( 
				offlineflag,
				latencyvalue,
				downloadthroughputvalue,
				uploadthroughputvalue,
                Optional.of(ConnectionType.WIFI)));
	}
}
