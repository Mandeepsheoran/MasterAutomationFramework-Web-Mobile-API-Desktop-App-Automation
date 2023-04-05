package org.igt.cdputils;

import java.util.Optional;

import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.ConnectionType;

/**
 * Class to emulate the slow network in browser using different Cellular type.
 * April 4, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0   
 * @see Network
 * @see CreateChromeDevToolsConnection
 */
public class EmulateSlowNetworkInBrowser extends CreateChromeDevToolsConnection{
	/**
	 * Method to create new connection with Network class and emulate the slow network using emulate conditions.
	 * April 4, 2023
	 * @author Mandeep Sheoran
	 */
	public static void setNetworktoSlowMode(Boolean offlineflag, Number latencyvalue, Number downloadthroughputvalue, Number uploadthroughputvalue) {
		CreateChromeDevToolsConnection.createConnection();
		devTools.send(Network.emulateNetworkConditions( 
				offlineflag,
				latencyvalue,
				downloadthroughputvalue,
				uploadthroughputvalue,
                Optional.of(ConnectionType.CELLULAR2G)));
	}
}
