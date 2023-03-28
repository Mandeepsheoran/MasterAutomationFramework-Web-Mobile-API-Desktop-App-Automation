package org.igt.utils;

/**
 * Class to provide implementation of Faker data class. <p>This will hide the acual implementation of Faker class using Singleton pattern.
 * Mar 14, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see FakerDataUtils
 */
public class RandomDataUtils {
	
	private RandomDataUtils() {};	
	/**
	 * Method to call fake integer generator method of Faker class.
	 * @author Mandeep Sheoran
	 */
	public static int getID() {
		return FakerDataUtils.getFakeId(10, 1000);
	}	
	/**
	 * Method to call fake integer generator method of Faker class.
	 * @author Mandeep Sheoran
	 */
	public static int getStand() {
		return FakerDataUtils.getFakeId(40, 47);
	}	
	/**
	 * Method to call fake integer generator method of Faker class.
	 * @author Mandeep Sheoran
	 */
	public static int getGate() {
		return FakerDataUtils.getFakeId(11, 28);
	}
	/**
	 * Method to call fake String generator method of Faker class.
	 * @author Mandeep Sheoran
	 */
	public static String getFirstName() {
		return FakerDataUtils.getFakeFirstName().toLowerCase();
	}
	/**
	 * Method to call fake String generator method of Faker class.
	 * @author Mandeep Sheoran
	 */
	public static String getLastName() {
		return FakerDataUtils.getFakeLastName().toLowerCase();
	}
	/**
	 * Method to call fake integer generator method of Faker class.
	 * @author Mandeep Sheoran
	 */
	public static int getAge() {
		return FakerDataUtils.getFakeId(10, 100);
	}
	
	/**
	 * Method to call UUID to generate unique string in UUID format
	 * @author Mandeep Sheoran
	 */
	public static String getFlightId() {
		return FakerDataUtils.getUUID();
	}
	
	/**
	 * Method to call fake String generator method of Faker class.
	 * @author Mandeep Sheoran
	 */
	public static String getRandomEmail() {
		return FakerDataUtils.getFakeFirstName().toLowerCase().concat("@gmail.com");
	}
}
