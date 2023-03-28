package org.igt.reports;

import java.util.Objects;

import com.aventstack.extentreports.ExtentTest;

/**
 * Class to implement ThreadLocal to handle multi-threading cases. 
 * Mar 4, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see ThreadLocal
 */
public final class ExtentManager {

	private ExtentManager() {};

	private static ThreadLocal<ExtentTest> extenttest = new ThreadLocal<>();

	/**
	 * Getter method for Extent Report using ThreadLocal.
	 * 
	 * @author Mandeep Sheoran
	 */
	public static ExtentTest getExtenttest() {
		if (Objects.isNull(extenttest)) {
			return extenttest.get();
		} else {
			return extenttest.get();
		}
	}

	/**
	 * Setter method for Extent Report using ThreadLocal.
	 * @author Mandeep Sheoran
	 */
	static void setExtent(ExtentTest test) {
		extenttest.set(test);
		/**
		 * if(Objects.isNull(test)) { extenttest.set(test); }
		 **/
	}
	/**
	 * Unload method to remove the content from thread.
	 * @author Mandeep Sheoran
	 */
	static void unload() {
		extenttest.remove();
	}
}
