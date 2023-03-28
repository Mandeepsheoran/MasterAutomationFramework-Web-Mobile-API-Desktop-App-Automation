package org.igt.converters;

import java.lang.reflect.Method;
import org.aeonbits.owner.Converter;
import org.igt.enums.BrowserRemoteRunMode;

/**
 * Converter class to convert String to BrowserRemoteRunMode like SELENOID and others.
 * Mar 27, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @see Converter
 * @see BrowserRemoteRunMode
 */
public class StringToBrowserRemoteModeTypeConverter implements Converter<BrowserRemoteRunMode>{

	@Override
	public BrowserRemoteRunMode convert(Method method, String remotemodevalue) {
		return BrowserRemoteRunMode.valueOf(remotemodevalue.toUpperCase());
	}
}
