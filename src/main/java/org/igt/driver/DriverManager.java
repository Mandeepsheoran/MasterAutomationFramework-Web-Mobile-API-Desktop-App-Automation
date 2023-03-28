package org.igt.driver;

import java.util.EnumMap;
import java.util.Map;
import org.igt.enums.PlatformType;
import org.openqa.selenium.WebDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

/**
 * Thread safety class with context switching for web and mobile driver initialization. 
 * Mar 1, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see ThreadLocal
 */
public final class DriverManager {

	private DriverManager() {
	}

	private static final ThreadLocal<WebDriver> WEB_DRIVER_THREAD_LOCAL = new ThreadLocal<>();
	private static final ThreadLocal<WebDriver> MOBILE_DRIVER_THREAD_LOCAL = new ThreadLocal<>();
	private static final ThreadLocal<PlatformType> CONTEXT = ThreadLocal.withInitial(() -> PlatformType.WEB);
	private static final Map<PlatformType, ThreadLocal<WebDriver>> map = new EnumMap<>(PlatformType.class);

	/**
	 * Get method to provide active driver instance based on context value 
	 * Mar 1, 2023
	 * @author Mandeep Sheoran
	 * @version 1.0
	 * @since 1.0
	 * @see PlatformType
	 */
	public static WebDriver getDriver() {
		return CONTEXT.get() == PlatformType.WEB ? WEB_DRIVER_THREAD_LOCAL.get() : MOBILE_DRIVER_THREAD_LOCAL.get();
	}

	/**
	 * Set method to initialize the driver instance based on context value and type of driver 
	 * Mar 1, 2023
	 * @author Mandeep Sheoran
	 * @version 1.0
	 * @since 1.0
	 * @see PlatformType
	 */
	public static void setDriver(WebDriver driver) {
		if (driver instanceof AndroidDriver || driver instanceof IOSDriver) {
			MOBILE_DRIVER_THREAD_LOCAL.set(driver);
			map.put(PlatformType.MOBILE, MOBILE_DRIVER_THREAD_LOCAL);
			CONTEXT.set(PlatformType.MOBILE);
		} else {
			WEB_DRIVER_THREAD_LOCAL.set(driver);
			map.put(PlatformType.WEB, WEB_DRIVER_THREAD_LOCAL);
			CONTEXT.set(PlatformType.WEB);
		}
	}

	/**
	 * Method to unload values after execution completion 
	 * Mar 1, 2023
	 * @author Mandeep Sheoran
	 * @version 1.0
	 * @since 1.0
	 */
	public static void unload() {
		WEB_DRIVER_THREAD_LOCAL.remove();
		MOBILE_DRIVER_THREAD_LOCAL.remove();
	}
}
