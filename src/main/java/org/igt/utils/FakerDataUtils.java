package org.igt.utils;

import java.util.UUID;

import com.github.javafaker.Faker;

/**
 * Class to help in creating Fake data which will be used in Test classes for POST calls.
 * Mar 14, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see Faker
 */
public class FakerDataUtils {
	
	private FakerDataUtils() {};	
	private static final Faker faker = new Faker();
	/**
	 * Method to provide fake data to generate random integer.
	 * @author Mandeep Sheoran
	 */
	protected static int getFakeId(int start, int end) {
		return faker.number().numberBetween(start, end);
	}
	
	/**
	 * Method to provide fake data to generate random String in form of valid names..
	 * @author Mandeep Sheoran
	 */
	protected static String getFakeFirstName() {
		return faker.name().firstName();
	}
	
	/**
	 * Method to provide fake data to generate random String in form of valid names..
	 * @author Mandeep Sheoran
	 */
	protected static String getFakeLastName() {
		return faker.funnyName().name();
	}
	
	/**
	 * Method to provide fake data to generate random integer.
	 * @author Mandeep Sheoran
	 */
	protected static int getFakeAgeNo(int start, int end) {
		return faker.number().numberBetween(start, end);
	}
	
	/**
	 * Method to provide unique uuid data in string format
	 * @author Mandeep Sheoran
	 */
	protected static String getUUID() {
		UUID uuid = UUID. randomUUID();
		return uuid.toString();
	}
}
