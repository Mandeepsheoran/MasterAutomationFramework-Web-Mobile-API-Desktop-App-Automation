package org.igt.configfactory;

import org.aeonbits.owner.ConfigCache;
import org.igt.config.InfluxDBConfig;

/**
 * Factory class to provide get method to fetch configuration values from configuration interface for InfluxDB testing.
 * Mar 27, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @see ConfigCache
 */
public class InfluxDBFactory {
	
	private InfluxDBFactory() {}
	
	public static InfluxDBConfig getConfig() {	
		return ConfigCache.getOrCreate(InfluxDBConfig.class);
	}

}
