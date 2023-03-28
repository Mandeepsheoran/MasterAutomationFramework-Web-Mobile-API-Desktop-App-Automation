package org.igt.converters;

import java.lang.reflect.Method;
import org.aeonbits.owner.Converter;
import org.igt.enums.RunModeType;

/**
 * Converter class to convert String to RunModeType like LOCAL, REMOTE.
 * Mar 27, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @see Converter
 * @see RunModeType
 */
public class StringToDesktopRunModeTypeConverter implements Converter<RunModeType>{

	@Override
	public RunModeType convert(Method method, String runmodevalue) {
		return RunModeType.valueOf(runmodevalue.toUpperCase());
	}
}
