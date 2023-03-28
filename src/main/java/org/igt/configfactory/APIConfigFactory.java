package org.igt.configfactory;

import org.aeonbits.owner.ConfigCache;
import org.igt.config.APIConfig;

/**
 * Factory class to provide get method to fetch configuration values from configuration interface for API testing.
 * Mar 27, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @see ConfigCache
 */
public class APIConfigFactory {
	
	private APIConfigFactory() {}
	
	public static APIConfig getConfig() {
		return ConfigCache.getOrCreate(APIConfig.class);
	}
}
