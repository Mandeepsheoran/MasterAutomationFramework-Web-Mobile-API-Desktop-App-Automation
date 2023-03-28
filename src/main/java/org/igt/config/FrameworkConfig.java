package org.igt.config;

import java.net.URL;

import org.aeonbits.owner.Config;
import org.igt.converters.StringToBrowserRemoteModeTypeConverter;
import org.igt.converters.StringToBrowserRunModeTypeConverter;
import org.igt.converters.StringToBrowserTypeConverter;
import org.igt.converters.StringToDesktopRunModeTypeConverter;
import org.igt.converters.StringToMobileOSTypeConverter;
import org.igt.converters.StringToMobileRemoteModeTypeConverter;
import org.igt.converters.StringToURLConverter;
import org.igt.enums.BrowserRemoteRunMode;
import org.igt.enums.BrowserType;
import org.igt.enums.MobileOSType;
import org.igt.enums.MobileRemoteRunMode;
import org.igt.enums.RunModeType;

/**
 * Configuration interface to provide method name for framework configuration keys.
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
public interface FrameworkConfig extends Config {
	
	@DefaultValue("dev")
	String environment();
	
	@Key("${environment}.webURL")
	String webUrl();	
	
	@DefaultValue("CHROME")
	@ConverterClass(StringToBrowserTypeConverter.class)
	BrowserType browser();
	
	@Key("runModeWeb")
	@ConverterClass(StringToBrowserRunModeTypeConverter.class)
	RunModeType browserRunMode();
	
	@Key("runModeMobile")
	@ConverterClass(StringToBrowserRunModeTypeConverter.class)
	RunModeType mobileRunMode();
	
	
	@Key("runModeDesktop")
	@ConverterClass(StringToDesktopRunModeTypeConverter.class)
	RunModeType desktopRunMode();
	
	@Key("browserRemoteRunMode")
	@ConverterClass(StringToBrowserRemoteModeTypeConverter.class)
	BrowserRemoteRunMode browserRemoteMode();
	
	@Key("mobileRemoteRunMode")
	@ConverterClass(StringToMobileRemoteModeTypeConverter.class)
	MobileRemoteRunMode mobileRemoteMode();
	
	@ConverterClass(StringToURLConverter.class)
	URL seleniumGridUrl();
	
	@Key("selenoidUrl")
	@ConverterClass(StringToURLConverter.class)
	URL selenoidGrid();
	
	@DefaultValue("http://127.0.0.1:4723/wd/hub")
	@ConverterClass(StringToURLConverter.class)
	URL localAppiumServerURL();
	
	@DefaultValue("http://127.0.0.1:4723")
	@ConverterClass(StringToURLConverter.class)
	URL localWinAppDriverServerURL();
	
	@Key("mobileBase")
	@ConverterClass(StringToMobileOSTypeConverter.class)
	MobileOSType mobileBase();
	
	@DefaultValue("No")
	@Key("sendresultstoelk")
	String isELKEnabled();
	
	@Key("elkdashboardurl")
	String elastickibanaUrl();
	
	@DefaultValue("No")
	@Key("sendresultstoinfluxdb")
	String isInfluxDbGrafanaEnabled();
	
	@Key("influxdbgrafanadashboardurl")
	String influxdbGrafanaUrl();
	
	@DefaultValue("No")
	@Key("zapscanrequired")
	String isZapScanRequired();
	
	@Key("OVERRIDEREPORTS")
	String isOverrideRequired();
	
	@Key("PASSEDSTEPSSCREENSHOT")
	String isPassedScreenshotRequired();
	
	@Key("FAILEDSTEPSSCREENSHOT")
	String isFailedScreenshotRequired();
	
	@Key("failedretrytests")
	@DefaultValue("No")
	String isRetryRequired();
	
	@Key("0Zh7z102BMYNslOLMs71Nyaci2P6n3o38P0ubC103q2V2Zc110")
	String eyesapikey();
}
