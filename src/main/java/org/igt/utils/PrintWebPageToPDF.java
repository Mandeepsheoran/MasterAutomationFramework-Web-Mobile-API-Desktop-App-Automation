package org.igt.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.igt.driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Pdf;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.print.PrintOptions;

/**
 * Class to provide methods to print the currently opened page to PDF format. This will work only in headless mode.
 * April 4, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see DriverManager
 * @see Paths
 */
public class PrintWebPageToPDF {
	/**
	 * Method to print the web page to PDF. This wil print the currently opened page only. Make sure to run the test in headless mode.
	 * April 4, 2023
	 * @author Mandeep Sheoran
	 */
	public static void printToPdf() throws IOException {
		Pdf pdf=((ChromeDriver)DriverManager.getDriver()).print(new PrintOptions());
		Files.write(Paths.get("./PDFPrint.pdf"), OutputType.BYTES.convertFromBase64Png(pdf.getContent()));
	}
}
