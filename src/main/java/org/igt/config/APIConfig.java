package org.igt.config;

import org.aeonbits.owner.Config;

/**
 * Configuration interface to provide method name for API related configuration keys.
 * Mar 27, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @see Config
 */

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({ 
	"system:properties", 
	"system:env",
	"file:${user.dir}/src/test/resources/config.properties",
	"file:${user.dir}/src/test/resources/dev-config.properties",
	"file:${user.dir}/src/test/resources/staging-config.properties" 
	})
public interface APIConfig extends Config {
	
	@DefaultValue("dev")
	String environment();
	
	@Key("${environment}.apiURL")
	String baseUrl();
}
