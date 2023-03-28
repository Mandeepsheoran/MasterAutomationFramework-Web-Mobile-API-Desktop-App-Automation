package org.igt.desktopapptest;

import org.igt.annotations.FrameworkAnnotations;
import org.igt.basetest.DesktopBase;
import org.igt.enums.CategoryType;
import org.igt.enums.LogType;
import org.igt.enums.TestType;
import org.igt.pomdesktopscreen.NotepadPOMScreen;
import org.igt.reports.FrameworkLogger;
import org.igt.utils.DateFormatUtils;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NotepadTest extends DesktopBase{
	
	@BeforeMethod
	public static void beforeTest(ITestResult result) {
		FrameworkLogger.log(LogType.CONSOLE, "TEST STARTED : " + result.getMethod().getMethodName() + " at ["
				+ DateFormatUtils.regionalCurrentDateTimeFormat() + "]");
	}
	
	@Test(description="Launch and check help in Notepad application")
	@FrameworkAnnotations(author="Mandeep", category=CategoryType.SMOKE, baseType=TestType.DESKTOP)
	public  void notepadHelpTest() {	
		NotepadPOMScreen.openHelpMenu();	
	}
}
