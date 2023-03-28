package org.igt.visualtest;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.igt.annotations.FrameworkAnnotations;
import org.igt.basetest.WebBase;
import org.igt.driver.DriverManager;
import org.igt.enums.CategoryType;
import org.igt.enums.TestType;
import org.testng.annotations.Test;
import io.percy.selenium.Percy;

public class PercyWebTest extends WebBase{
	
	public  Percy percy;

	@Test(description = "Visual test using Percy.io")
	@FrameworkAnnotations(author = "Mandeep", category = CategoryType.SMOKE, baseType = TestType.WEB)
	public  void percyTest() throws InterruptedException {
		percy = new Percy(DriverManager.getDriver());
		Thread.sleep(5000);
		percy.snapshot("First Snapshot");
		}
	
	@Test(description = "Use different screen width for visual comparison")
	@FrameworkAnnotations(author = "Mandeep", category = CategoryType.REGRESSION, baseType = TestType.WEB)
	public  void percyTestWithDifferentWidth() throws InterruptedException {
		percy = new Percy(DriverManager.getDriver());
		Thread.sleep(5000);
		List<Integer> list = new ArrayList<>();
		list.add(1200);
		list.add(1300);
 		percy.snapshot("Different Pixel Width", list);
		}

}
