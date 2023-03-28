package org.igt.configfactory;

import org.aeonbits.owner.ConfigCache;
import org.igt.config.BrowserStackConfig;

/**
 * Factory class to provide get method to fetch configuration values from configuration interface for BrowserStack.
 * Mar 27, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @see ConfigCache
 */
public final class BrowserStackConfigFactory {
	
	private BrowserStackConfigFactory() {}
	
	public static BrowserStackConfig getConfig() {
		return ConfigCache.getOrCreate(BrowserStackConfig.class);
	}
}
