package org.igt.config;

import java.net.URL;

import org.aeonbits.owner.Config;
import org.igt.converters.StringToURLConverter;

/**
 * Configuration interface to provide method name for BrowserStack configuration keys.
 * Mar 27, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @see Config
 */
@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({ 
	"system:properties", 
	"system:env",
	"file:${user.dir}/src/test/resources/browser-stack.properties" 
	})
public interface BrowserStackConfig extends Config{
	
	@Key("username")
	String userName();
	
	@Key("password")
	String passWord();
	
	@DefaultValue("http://${username}:${password}@hub-cloud.browserstack.com/wd/hub")
	@ConverterClass(StringToURLConverter.class)
	URL browserStackURL();

}
