package org.igt.utils;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.igt.configfactory.ZapProxyFactory;
import org.zaproxy.clientapi.core.ClientApi;

import io.restassured.response.Response;
import lombok.SneakyThrows;
/**
 * Class to read and write api request and response in external file.
 * Mar 4, 2023
 * @author Mandeep Sheoran
 * @see Files
 * @see SneakyThrows
 */
public class APIUtils {

	private APIUtils() {};

	/**
	 * Method to provide implementation of reading content from external files.
	 * @author Mandeep Sheoran
	 */
	@SneakyThrows
	public static String readFromExternalFile(String filepath) {
		return new String(Files.readAllBytes(Paths.get(filepath)));
	}

	/**
	 * Method to provide implementation for storing response in external files.
	 * @author Mandeep Sheoran
	 */
	@SneakyThrows
	public static void saveReturnedPostResponse(String filepath, Response response) {
		Files.write(Paths.get(filepath), response.asByteArray());

	}

}
