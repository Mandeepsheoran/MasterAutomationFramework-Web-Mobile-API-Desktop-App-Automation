package org.igt.converters;

import java.lang.reflect.Method;
import org.aeonbits.owner.Converter;
import org.igt.enums.BrowserType;

/**
 * Converter class to convert String to BrowserType like CHROME, FIREFOX.
 * Mar 27, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @see Converter
 * @see BrowserType
 */
public class StringToBrowserTypeConverter implements Converter<BrowserType>{

	@Override
	public BrowserType convert(Method method, String browsername) {
		return BrowserType.valueOf(browsername.toUpperCase());
	}
}
