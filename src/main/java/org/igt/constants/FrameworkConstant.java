package org.igt.constants;

import java.time.Duration;
import org.igt.configfactory.ConfigFactory;
import lombok.Getter;

/**
 * Constant class to provide folder and file path for framework detailed files.
 * Mar 27, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @see lombok
 */
public class FrameworkConstant {
			
		static long waitTimeOut =30;	
		public static @Getter final String requestjsonfolderpath = System.getProperty("user.dir")+"/src/test/resources/json/";
		public static @Getter final String gremlinsjsfolderpath = System.getProperty("user.dir")+"/src/test/resources/gremlins-javaScript/";
		public static @Getter final String responsejsonfolderpath = System.getProperty("user.dir")+"/JsonOutput/";
		public static final String configFilePath = System.getProperty("user.dir")+"/src/test/resources/config.properties";
		public static final String devconfigFilePath = System.getProperty("user.dir")+"/src/test/resources/dev-config.properties";
		public static final String stagingconfigFilePath = System.getProperty("user.dir")+"/src/test/resources/staging-config.properties";
		public static final String browserstackconfigFilePath = System.getProperty("user.dir")+"/src/test/resources/browser-stack.properties";
		public static final String saucelabconfigFilePath = System.getProperty("user.dir")+"/src/test/resources/sauce-labs.properties";		
		public static final String iosAppFilePath = System.getProperty("user.dir")+"/src/test/resources/mobile-app/ios-app.zip";
		public static final String androidAppFilePath = System.getProperty("user.dir")+"/src/test/resources/mobile-app/ApiDemos-debug.apk";
		public static final String extentconfigFilePath = System.getProperty("user.dir")+"/src/test/resources/extentconfig.xml";	
		private static final String RESOURCEPATH = System.getProperty("user.dir") + "/src/test/resources";
		private static final String EXCELPATH = RESOURCEPATH + "/Excel/testdata.xlsx";
		private static @Getter final String TESTCASESHEET = "TestMethods";
		private static @Getter final String TESTDATASHEET = "TestData";
		private static final String EXTENTREPORTFOLDERPATH =System.getProperty("user.dir") + "/ExtentTest-Output/";
		private static String extentreportfilepath="";
		private static final Duration EXPLICITWAITTIME = Duration.ofMinutes(30);
		public static final String accessibilityReportPath = System.getProperty("user.dir")+"/src/test/resources/accessibility-report/axe-core";
		public static final String applitoolseyeslogs = System.getProperty("user.dir")+"/src/test/resources/applitoolseyes-logs/eyes-runner.log";
		public static final String securityScanReportDir = System.getProperty("user.dir") + "/src/test/resources/ZAPSecurity-Report/";
		public static Duration getExplicitwaittime() {
			return EXPLICITWAITTIME;
		}
		public static String getExcelpath() {
			return EXCELPATH;
		}
		public static String getExtentreportfilepath() {
			if(extentreportfilepath.isEmpty()) { 
				extentreportfilepath = createExtentReportPath();
			}
			return extentreportfilepath;
		}	
		private static String createExtentReportPath()  {
			if(ConfigFactory.getConfig().isOverrideRequired().equalsIgnoreCase("no")) {
				return EXTENTREPORTFOLDERPATH + System.currentTimeMillis()+"/index.html";
			}
			else {
				return EXTENTREPORTFOLDERPATH + "/index.html";
			}
		}
	}

