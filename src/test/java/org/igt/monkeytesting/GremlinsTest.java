package org.igt.monkeytesting;

import static org.igt.enums.LogType.CONSOLEANDEXTENTINFO;
import static org.igt.reports.FrameworkLogger.log;
import java.util.logging.Level;
import org.assertj.core.api.Assertions;
import org.igt.annotations.FrameworkAnnotations;
import org.igt.basetest.WebBase;
import org.igt.driver.DriverManager;
import org.igt.enums.CategoryType;
import org.igt.enums.ConsoleLogType;
import org.igt.enums.LogType;
import org.igt.enums.TestType;
import org.igt.reports.FrameworkLogger;
import org.igt.utils.DateFormatUtils;
import org.openqa.selenium.logging.LogEntry;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GremlinsTest extends WebBase {

	@BeforeMethod
	public static void beforeTest(ITestResult result) {
		FrameworkLogger.log(LogType.CONSOLE, "TEST STARTED : " + result.getMethod().getMethodName() + " at ["
				+ DateFormatUtils.regionalCurrentDateTimeFormat() + "]");
	}

	@Test(description = "Full horde Monkey Test")
	@FrameworkAnnotations(author = "Mandeep", category = CategoryType.REGRESSION, baseType = TestType.WEB)
	public void allSpeciesTest() {
		DriverManager.getDriver().get("https://google.com/");
		GremlinsUtil.injectGremlins("allSpecies.txt");
		for (LogEntry logs : GremlinsUtil.getConsoleLogs(ConsoleLogType.BROWSER)) {
			if (logs.getLevel() == Level.SEVERE) {
				log(CONSOLEANDEXTENTINFO, "Found browser logs with level : " + logs.getLevel() + " : " + logs.getMessage()); 
				Assertions.assertThat(logs.getLevel())
						.withFailMessage("JavaScript exceptions on Browser, hence marking test as fail.")
						.isEqualTo("SSS");
			} else { 
				for (LogEntry ll : GremlinsUtil.getConsoleLogs(ConsoleLogType.CLIENT)) {
					if (ll.getLevel() == Level.SEVERE) {
						log(CONSOLEANDEXTENTINFO, "Found browser logs with level : " + logs.getLevel() + " : " + logs.getMessage());
						Assertions.assertThat(ll.getLevel())
								.withFailMessage("JavaScript exceptions on Client side, hence marking test as fail.")
								.isEqualTo("SSS");
					} else {
						System.out.println("No SEVERE exceptions found on console.");
					}
				}
			}

		}
	}

	@Test(description = "Monkey Testing - Clicker Species")
	@FrameworkAnnotations(author = "Mandeep", category = CategoryType.REGRESSION, baseType = TestType.WEB)
	public void gremlinsClickerTest() {
		DriverManager.getDriver().get("https://google.com/");
		GremlinsUtil.injectGremlins("clickerSpecies.txt");
		for (LogEntry logs : GremlinsUtil.getConsoleLogs(ConsoleLogType.BROWSER)) {
			if (logs.getLevel() == Level.SEVERE) {
				log(CONSOLEANDEXTENTINFO, "Found browser logs with level : " + logs.getLevel() + " : " + logs.getMessage());
				Assertions.assertThat(logs.getLevel())
						.withFailMessage("JavaScript exceptions on Browser, hence marking test as fail.")
						.isEqualTo("SSS");
			} else {
				for (LogEntry ll : GremlinsUtil.getConsoleLogs(ConsoleLogType.CLIENT)) {
					if (ll.getLevel() == Level.SEVERE) {
						log(CONSOLEANDEXTENTINFO, "Found browser logs with level : " + logs.getLevel() + " : " + logs.getMessage());
						Assertions.assertThat(ll.getLevel())
								.withFailMessage("JavaScript exceptions on Client side, hence marking test as fail.")
								.isEqualTo("SSS");
					}
				}
			}

		}
	}

	@Test(description = "Monkey Testing - Toucher and Scroller Species")
	@FrameworkAnnotations(author = "Mandeep", category = CategoryType.REGRESSION, baseType = TestType.WEB)
	public void gremlinsScrollerAndToucherTest() {
		DriverManager.getDriver().get("https://google.com/");
		GremlinsUtil.injectGremlins("toucherScrollerSpecies.txt");
		for (LogEntry logs : GremlinsUtil.getConsoleLogs(ConsoleLogType.BROWSER)) {
			if (logs.getLevel() == Level.SEVERE) {
				log(CONSOLEANDEXTENTINFO, "Found browser logs with level : " + logs.getLevel() + " : " + logs.getMessage());
				Assertions.assertThat(logs.getLevel())
						.withFailMessage("JavaScript exceptions on Browser, hence marking test as fail.")
						.isEqualTo("SSS");
			} else {
				for (LogEntry ll : GremlinsUtil.getConsoleLogs(ConsoleLogType.CLIENT)) {
					if (ll.getLevel() == Level.SEVERE) {
						log(CONSOLEANDEXTENTINFO, "Found browser logs with level : " + logs.getLevel() + " : " + logs.getMessage());
						Assertions.assertThat(ll.getLevel())
								.withFailMessage("JavaScript exceptions on Client side, hence marking test as fail.")
								.isEqualTo("SSS");
					}
				}
			}

		}
	}

	@Test(description = "Monkey Testing - Typer Species")
	@FrameworkAnnotations(author = "Mandeep", category = CategoryType.REGRESSION, baseType = TestType.WEB)
	public void gremlinsTyperTest() {
		DriverManager.getDriver().get("https://google.com/");
		GremlinsUtil.injectGremlins("typerSpecies.txt");
		for (LogEntry logs : GremlinsUtil.getConsoleLogs(ConsoleLogType.BROWSER)) {
			if (logs.getLevel() == Level.SEVERE) {
				log(CONSOLEANDEXTENTINFO, "Found browser logs with level : " + logs.getLevel() + " : " + logs.getMessage());
				Assertions.assertThat(logs.getLevel())
						.withFailMessage("JavaScript exceptions on Browser, hence marking test as fail.")
						.isEqualTo("SSS");
			} else {
				for (LogEntry ll : GremlinsUtil.getConsoleLogs(ConsoleLogType.CLIENT)) {
					if (ll.getLevel() == Level.SEVERE) {
						log(CONSOLEANDEXTENTINFO, "Found browser logs with level : " + logs.getLevel() + " : " + logs.getMessage());
						Assertions.assertThat(ll.getLevel())
								.withFailMessage("JavaScript exceptions on Client side, hence marking test as fail.")
								.isEqualTo("SSS");
					}
				}
			}

		}
	}

	@Test(description = "Monkey Testing - Test using By Species Strategy")
	@FrameworkAnnotations(author = "Mandeep", category = CategoryType.REGRESSION, baseType = TestType.WEB)
	public void gremlinsBySpeciesTest() {
		DriverManager.getDriver().get("https://google.com/");
		GremlinsUtil.injectGremlins("strategyBySpecies.txt");
		for (LogEntry logs : GremlinsUtil.getConsoleLogs(ConsoleLogType.BROWSER)) {
			if (logs.getLevel() == Level.SEVERE) {
				log(CONSOLEANDEXTENTINFO, "Found browser logs with level : " + logs.getLevel() + " : " + logs.getMessage());
				Assertions.assertThat(logs.getLevel())
						.withFailMessage("JavaScript exceptions on Browser, hence marking test as fail.")
						.isEqualTo("SSS");
			} else {
				for (LogEntry ll : GremlinsUtil.getConsoleLogs(ConsoleLogType.CLIENT)) {
					if (ll.getLevel() == Level.SEVERE) {
						log(CONSOLEANDEXTENTINFO, "Found browser logs with level : " + logs.getLevel() + " : " + logs.getMessage());
						Assertions.assertThat(ll.getLevel())
								.withFailMessage("JavaScript exceptions on Client side, hence marking test as fail.")
								.isEqualTo("SSS");
					}
				}
			}

		}
	}

	@Test(description = "Monkey Testing - Test using Distribution Strategy")
	@FrameworkAnnotations(author = "Mandeep", category = CategoryType.REGRESSION, baseType = TestType.WEB)
	public void gremlinsDistributionTest() {
		DriverManager.getDriver().get("https://google.com/");
		GremlinsUtil.injectGremlins("strategyByDistribution.txt");
		for (LogEntry logs : GremlinsUtil.getConsoleLogs(ConsoleLogType.BROWSER)) {
			if (logs.getLevel() == Level.SEVERE) {
				log(CONSOLEANDEXTENTINFO, "Found browser logs with level : " + logs.getLevel() + " : " + logs.getMessage());
				Assertions.assertThat(logs.getLevel())
						.withFailMessage("JavaScript exceptions on Browser, hence marking test as fail.")
						.isEqualTo("SSS");
			} else {
				for (LogEntry ll : GremlinsUtil.getConsoleLogs(ConsoleLogType.CLIENT)) {
					if (ll.getLevel() == Level.SEVERE) {
						log(CONSOLEANDEXTENTINFO, "Found browser logs with level : " + logs.getLevel() + " : " + logs.getMessage());
						Assertions.assertThat(ll.getLevel())
								.withFailMessage("JavaScript exceptions on Client side, hence marking test as fail.")
								.isEqualTo("SSS");
					}
				}
			}

		}
	}

}
