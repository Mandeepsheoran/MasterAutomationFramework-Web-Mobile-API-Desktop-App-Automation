package org.igt.converters;

import java.lang.reflect.Method;
import org.aeonbits.owner.Converter;
import org.igt.enums.MobileRemoteRunMode;

/**
 * Converter class to convert String to MobileRemoteRunMode like BROWSERSTACK, SAUCELAB.
 * Mar 27, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @see Converter
 * @see MobileRemoteRunMode
 */
public class StringToMobileRemoteModeTypeConverter implements Converter<MobileRemoteRunMode>{

	@Override
	public MobileRemoteRunMode convert(Method method, String remotemodevalue) {
		return MobileRemoteRunMode.valueOf(remotemodevalue.toUpperCase());
	}
}
