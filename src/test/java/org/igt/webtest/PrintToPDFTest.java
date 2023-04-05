package org.igt.webtest;

import java.io.IOException;
import org.igt.driver.DriverManager;
import org.igt.utils.PrintWebPageToPDF;
import org.testng.annotations.Test;

public class PrintToPDFTest {
	@Test
	public void getPDFForWebPage() throws IOException {
		PrintWebPageToPDF.printToPdf();
		DriverManager.getDriver().get("http://www.google.com");
		PrintWebPageToPDF.printToPdf();
	}
}
