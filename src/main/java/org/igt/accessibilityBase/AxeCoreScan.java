package org.igt.accessibilityBase;

import java.util.List;
import org.igt.constants.FrameworkConstant;
import org.igt.driver.DriverManager;
import java.io.FileReader;
import java.util.Arrays;
import com.deque.html.axecore.selenium.AxeBuilder;
import com.deque.html.axecore.selenium.AxeReporter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import lombok.SneakyThrows;

import com.deque.html.axecore.results.Results;

/**
 * Axe Core base class to initialize the Axe builder and save the report.
 * Mar 20, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 */
public class AxeCoreScan {

	static Results results;
	static AxeBuilder builder;

	private static List<String> tags = Arrays.asList("wcag2a", "wcag2aa", "wcag21aa");

	/**
	 * Method to initialize the axe builder to create tags and Webdriver connection
	 * @author Mandeep Sheoran
	 * @see AxeBuilder
	 * @see DriverManager
	 */
	public static Results getAccessibilityScanResult() {
		builder = new AxeBuilder();
		builder.withTags(tags);
		results = builder.analyze(DriverManager.getDriver());
		return results;
	}
	
	/**
	 * Method to parse the report content and save it on mentioned path.
	 * @author Mandeep Sheoran
	 * @see FrameworkConstant
	 * @see AxeReporter
	 */

	@SneakyThrows
	public static void saveReports(Results res) {
		JsonParser jsonParser = new JsonParser();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		AxeReporter.writeResultsToJsonFile(FrameworkConstant.accessibilityReportPath, res);
		JsonElement jsonElement = jsonParser.parse(new FileReader(FrameworkConstant.accessibilityReportPath + ".json"));
		String prettyJson = gson.toJson(jsonElement);
		AxeReporter.writeResultsToTextFile(FrameworkConstant.accessibilityReportPath, prettyJson);
	}
}
