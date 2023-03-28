package org.igt.monkeytesting;

import org.igt.constants.FrameworkConstant;
import org.igt.driver.DriverManager;
import org.igt.enums.ConsoleLogType;
import org.igt.utils.APIUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import com.machinezoo.noexception.Exceptions;

/**
 * Class to inject Gremlin Script and get browser console browser.
 * Mar 4, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see Exceptions
 * @see JavascriptExecutor
 */
public class GremlinsUtil {

	static JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
	/**
	 * Method to inject Gremlins script using JavaScriptExecuter.
	 * Mar 4, 2023
	 * @author Mandeep Sheoran
	 */
	public static void injectGremlins(String script) {
		Exceptions.sneak().get(() -> js
				.executeAsyncScript(APIUtils.readFromExternalFile(FrameworkConstant.gremlinsjsfolderpath + script)));
	}
	/**
	 * Method to get browser console logs to check execptions.
	 * Mar 4, 2023
	 * @author Mandeep Sheoran
	 */
	public static LogEntries getConsoleLogs(ConsoleLogType logtype) {
		return logtype == ConsoleLogType.BROWSER ? DriverManager.getDriver().manage().logs().get(LogType.BROWSER)
				: DriverManager.getDriver().manage().logs().get(LogType.CLIENT);
	}
}
