package org.igt.converters;

import java.lang.reflect.Method;
import org.aeonbits.owner.Converter;
import org.igt.enums.MobileOSType;

/**
 * Converter class to convert String to MobileOSType like iOS, ANDROID.
 * Mar 27, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @see Converter
 * @see MobileOSType
 */
public class StringToMobileOSTypeConverter implements Converter<MobileOSType>{

	@Override
	public MobileOSType convert(Method method, String platformvalue) {
		return MobileOSType.valueOf(platformvalue.toUpperCase());
	}
}
