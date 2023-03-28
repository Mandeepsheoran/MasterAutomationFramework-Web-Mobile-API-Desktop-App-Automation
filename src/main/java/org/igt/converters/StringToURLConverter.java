package org.igt.converters;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import org.aeonbits.owner.Converter;
import lombok.SneakyThrows;

/**
 * Converter class to convert String to URL.
 * Mar 27, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @see Converter
 * @see URL
 */
public class StringToURLConverter implements Converter<URL>{

	@SneakyThrows
	@Override
	public URL convert(Method method, String stringUrl) {
		try {
			return new URL(stringUrl);
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
