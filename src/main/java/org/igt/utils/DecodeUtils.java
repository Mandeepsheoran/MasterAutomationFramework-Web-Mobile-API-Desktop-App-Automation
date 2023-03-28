package org.igt.utils;

import java.util.Base64;

/**
 * 
 * Class to provide method for decoding an encoded String like Password and other sensitive information<p>
 * Mar 21, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see ExcelUtils
 * @see Base64
 */

public class DecodeUtils {
	
	private DecodeUtils() {		
	}	
	/**
	 * This will decode the encoded password passed from excel sheet.
	 * @author Mandeep.Sheoran
	 * @param encodedString
	 * @return String
	 * @see java.util.Base64
	 */
	public static String getDecodedString(String encodedString) {
		return new String(Base64.getDecoder().decode(encodedString.getBytes()));
	}
}
