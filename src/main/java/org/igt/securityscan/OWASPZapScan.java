package org.igt.securityscan;

import java.util.concurrent.TimeUnit;
import org.igt.configfactory.ZapProxyFactory;
import org.igt.constants.FrameworkConstant;
import org.openqa.selenium.Proxy;
import org.zaproxy.clientapi.core.ApiResponse;
import org.zaproxy.clientapi.core.ApiResponseElement;
import org.zaproxy.clientapi.core.ClientApi;
import org.zaproxy.clientapi.core.ClientApiException;
import com.google.common.util.concurrent.Uninterruptibles;
/**
 * Class to setup ZAP proxy scan.
 * Mar 4, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see ClientApi
 * @see ZapProxyFactory
 */
public class OWASPZapScan {

	private OWASPZapScan() {}

	public static ClientApi apiclient;
	public static String proxyserverurl;
	public static String scanVal;
	public static ApiResponse apiResponse;
	public static String ZAP_PROXY_ADDRESS = ZapProxyFactory.getConfig().zapProxyHost();
	public static int ZAP_PROXY_PORT = ZapProxyFactory.getConfig().zapProxyHostPort();

	/**
	 * Method to configure ZAP with unique key, proxy address and port.
	 * Mar 4, 2023
	 * @author Mandeep Sheoran
	 */
	public static void setZAPConfig() {
		String ZAP_PROXY_KEY = ZapProxyFactory.getConfig().zapProxyAPIKey();
		apiclient = new ClientApi(ZAP_PROXY_ADDRESS, ZAP_PROXY_PORT, ZAP_PROXY_KEY);
	}
	/**
	 * Method to set ZAP proxy using Selenium Proxy class.
	 * Mar 4, 2023
	 * @author Mandeep Sheoran
	 */
	public static Proxy setZAPScanProxy() {
		proxyserverurl = ZAP_PROXY_ADDRESS + ":" + ZAP_PROXY_PORT;
		Proxy proxy = new Proxy(); 
		proxy.setHttpProxy(proxyserverurl);
		proxy.setSslProxy(proxyserverurl);
		return proxy;
	}
	/**
	 * Method to perform passive scan
	 * Mar 4, 2023
	 * @author Mandeep Sheoran
	 */
	public static void passiveScan() {
		try {
			apiResponse = apiclient.pscan.recordsToScan();
			Uninterruptibles.sleepUninterruptibly(10, TimeUnit.SECONDS);
			scanVal = ((ApiResponseElement) apiResponse).getValue();
			while (!scanVal.equals("0")) {
				System.out.println("Passive scan is in progress");
				apiResponse = apiclient.pscan.recordsToScan();
				scanVal = ((ApiResponseElement) apiResponse).getValue();
			}
			System.out.println("Passive scan is completed");
		} catch (ClientApiException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method to generate report for ZAP passive scan.
	 * Mar 4, 2023
	 * @author Mandeep Sheoran
	 */
	public static void generateReport() {
		if (apiclient != null) {
			String title = "ZAP Demo Report";
			String template = "traditional-html";
			String theme = null;
			String description = "Report description";
			String contexts = null;
			String sites = null;
			String sections = null;
			String includedconfidences = null;
			String includedrisks = null;
			String reportfilenamepattern = null;
			String reportdir = FrameworkConstant.securityScanReportDir;
			String display = null;
			String reportfilename = "SecurityScan-report.html";
			try {
				apiclient.reports.generate(title, template, theme, description, contexts, sites, sections,
						includedconfidences, includedrisks, reportfilename, reportfilenamepattern, reportdir, display);
			} catch (ClientApiException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("ZAP client connection is null hence nothing to print in scan report.");
		}
	}
}
