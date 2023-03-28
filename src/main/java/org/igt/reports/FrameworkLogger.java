package org.igt.reports;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Consumer;

import org.igt.enums.LogType;
import org.igt.utils.ScreenShotUtils;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

/**
 * Logger to set the status of the log
 * Mar 30, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see ExtentManager
 */
public class FrameworkLogger {

	private FrameworkLogger() {
	}

	public static final Consumer<String> PASS = (message) -> ExtentManager.getExtenttest().pass(MarkupHelper.createLabel(message,ExtentColor.GREEN));
	public static final Consumer<String> Fail = (message) -> ExtentManager.getExtenttest().fail(message);
	public static final Consumer<String> Skip = (message) -> ExtentManager.getExtenttest().skip(message);
	private static final Consumer<String> INFO = (message)->ExtentManager.getExtenttest().info(MarkupHelper.createLabel(message,ExtentColor.BLUE));
	public static final Consumer<String> Console = (message) -> System.out.println("Info-->"+message);
	public static  final Consumer<String> ConsoleAndExtentReportPass = PASS.andThen(Console);
	public static final  Consumer<String> ConsoleAndExtentReportFail = Fail.andThen(Console);
	public static final  Consumer<String> ConsoleAndExtentReportInfo = INFO.andThen(Console);
	private static final Consumer<String> TAKESCREENSHOT = (message)-> ExtentManager.getExtenttest().info("",
			MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtils.getBase64Image()).build());

	public static Map<LogType, Consumer<String>> map = new EnumMap<>(LogType.class);
	private static final Map<LogType,Consumer<String>> SCREENSHOTMAP = new EnumMap<>(LogType.class);

	static {
		map.put(LogType.PASS, PASS);
		map.put(LogType.FAIL, Fail.andThen(TAKESCREENSHOT));
		map.put(LogType.SKIP, Skip);
		map.put(LogType.INFO, INFO);
		map.put(LogType.CONSOLE, Console);
		map.put(LogType.CONSOLEANDEXTENTPASS, ConsoleAndExtentReportPass);
		map.put(LogType.CONSOLEANDEXTENTINFO, ConsoleAndExtentReportInfo);
		map.put(LogType.CONSOLEANDEXTENTFAIL, ConsoleAndExtentReportFail);
		SCREENSHOTMAP.put(LogType.PASS, PASS.andThen(TAKESCREENSHOT));
		SCREENSHOTMAP.put(LogType.FAIL, Fail.andThen(TAKESCREENSHOT));
		SCREENSHOTMAP.put(LogType.SKIP, Skip.andThen(TAKESCREENSHOT));
		SCREENSHOTMAP.put(LogType.INFO, INFO);
		SCREENSHOTMAP.put(LogType.CONSOLE, Console);
		SCREENSHOTMAP.put(LogType.CONSOLEANDEXTENTPASS, ConsoleAndExtentReportPass.andThen(TAKESCREENSHOT));
	}

	public static void log(LogType status, String message) {
		 map.getOrDefault(status,PASS).accept(message);
	}
}
