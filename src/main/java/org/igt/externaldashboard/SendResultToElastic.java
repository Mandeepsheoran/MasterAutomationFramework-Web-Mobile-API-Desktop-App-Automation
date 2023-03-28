package org.igt.externaldashboard;

import static io.restassured.RestAssured.given;
import java.util.HashMap;
import java.util.Map;
import org.igt.configfactory.ConfigFactory;
import org.igt.utils.DateFormatUtils;
import org.testng.Assert;
import io.restassured.response.Response;

/**
 * Send test execution status to elastic store to display these data on Kibana dashboard to see live execution.
 * Mar 14, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see ConfigFactory
 * @see DateFormatUtils
 */
public class SendResultToElastic {
	/**
	 * Method to check configuration and send results to database by calling the exposed API endpoint.
	 * Mar 14, 2023
	 * @author Mandeep Sheoran
	 */
	public static void sendStatusToElastic(String testname, String status) {	
		if((ConfigFactory.getConfig().isELKEnabled()).toLowerCase().equalsIgnoreCase("yes")) {		
			Map<String,String> map = new HashMap<>();
			map.put("TestCaseName", testname);
			map.put("TestStatus", status);
			map.put("executiontime",DateFormatUtils.currentUTCDateTimeFormat());		
			Response response = given().header("Content-Type", "application/json")
					.log()
					.all()
					.body(map)
					.post(ConfigFactory.getConfig().elastickibanaUrl().toLowerCase());
			Assert.assertEquals(response.statusCode(), 201);
			response.prettyPrint();
		} else {
			System.out.println("Config key to send results to ElasticSearch is off hence not sending data to Elastic.");
		}		
	}
}
