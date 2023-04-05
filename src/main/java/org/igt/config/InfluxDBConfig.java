package org.igt.config;

import org.aeonbits.owner.Config;

/**
 * Configuration interface to provide method name for InfluxDB related configuration keys.
 * Mar 27, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @see Config
 */
@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({ 
	"system:properties", 
	"system:env",
	"file:${user.dir}/src/test/resources/influxdb.properties"
	})
public interface InfluxDBConfig extends Config {
	
	@Key("token")
	String influxDBToken();
	
	@Key("bucket")
	String influxdbBucket();
	
	@Key("org")
	String influxdbUserOrg();
	
	@Key("url")
	String influxdbURL();

}
