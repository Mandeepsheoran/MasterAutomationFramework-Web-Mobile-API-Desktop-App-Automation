package org.igt.requestbuilder;

import org.igt.configfactory.APIConfigFactory;
import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class APIRequestBuilder {

	private APIRequestBuilder() {};

	/**
	 * Reusable method to construct the request for GET calls.
	 * @author Mandeep Sheoran
	 * @see PropertiesType
	 * @see PropertyUtils
	 */
	public static RequestSpecification buildRequestForGetCalls() {
		RestAssured.useRelaxedHTTPSValidation();
		return given()
				.baseUri(APIConfigFactory.getConfig().baseUrl())
				.log()
				.all();
	}

	/**
	 * Reusable to method to construct the request for POST calls.
	 * @author Mandeep Sheoran
	 * @see PropertiesType
	 * @see PropertyUtils
	 */
	public static RequestSpecification buildRequestForPostCalls() {
		RestAssured.useRelaxedHTTPSValidation();
		Map<String, String> headers = new HashMap<String, String>();
	//	headers.put("X-k8s-microservice-call", "14309F2F-81F0-4399-A168-8248763A95E3");
		return given().baseUri(APIConfigFactory.getConfig().baseUrl())
				.contentType(ContentType.JSON).headers(headers)
				.log()
				.all();
	}
}
