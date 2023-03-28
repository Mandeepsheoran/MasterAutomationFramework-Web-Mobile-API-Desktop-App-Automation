package org.igt.configfactory;

import org.aeonbits.owner.ConfigCache;
import org.igt.config.FrameworkConfig;

/**
 * Factory class to provide get method to fetch configuration values from configuration interface.
 * Mar 27, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @see ConfigCache
 */
public class ConfigFactory {
	
	private ConfigFactory() {}
		
	public static FrameworkConfig getConfig() {
		return ConfigCache.getOrCreate(FrameworkConfig.class);
	}
}
