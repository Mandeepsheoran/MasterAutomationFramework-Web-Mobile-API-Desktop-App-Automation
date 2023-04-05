package org.igt.config;

import org.aeonbits.owner.Config;

/**
 * Configuration interface to provide method name for OWASP ZAP related configuration keys.
 * Mar 27, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @see Config
 */
@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({ 
	"system:properties", 
	"system:env",
	"file:${user.dir}/src/test/resources/zapproxy.properties"
	})
public interface ZapProxyConfig extends Config{
	
	@Key("ZAP_PROXY_ADDRESS")
	String zapProxyHost();
	
	@Key("ZAP_PROXY_PORT")
	int zapProxyHostPort();
	
	@Key("ZAP_PROXY_KEY")
	String zapProxyAPIKey();
}
