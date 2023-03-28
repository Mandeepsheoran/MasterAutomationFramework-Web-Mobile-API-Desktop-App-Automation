package org.igt.configfactory;

import org.aeonbits.owner.ConfigCache;
import org.igt.config.ZapProxyConfig;

/**
 * Factory class to provide get method to fetch configuration values from configuration interface for OWASP ZAP testing.
 * Mar 27, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @see ConfigCache
 */
public class ZapProxyFactory {
	
private ZapProxyFactory() {}
	
	public static ZapProxyConfig getConfig() {	
		return ConfigCache.getOrCreate(ZapProxyConfig.class);
	}
}
