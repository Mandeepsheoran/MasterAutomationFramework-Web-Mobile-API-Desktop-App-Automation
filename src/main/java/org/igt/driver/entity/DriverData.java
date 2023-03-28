package org.igt.driver.entity;

import org.igt.enums.BrowserRemoteRunMode;
import org.igt.enums.BrowserType;
import org.igt.enums.MobileOSType;
import org.igt.enums.MobileRemoteRunMode;
import org.igt.enums.RunModeType;
import lombok.Builder;
import lombok.Getter;

/**
 * Method to declare the driver data for different ENUM types.
 * Feb 15, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 */
@Builder
@Getter
public class DriverData {
	private RunModeType runModeType;
	private BrowserType browserType;
	private BrowserRemoteRunMode browserRemoteRunMode;
	private MobileOSType mobileOSType;
	private MobileRemoteRunMode mobileRemoteRunMode;
}
