package org.igt.websecurityscan;

import org.igt.annotations.FrameworkAnnotations;
import org.igt.basetest.WebBase;
import org.igt.enums.CategoryType;
import org.igt.enums.TestType;
import org.igt.securityscan.OWASPZapScan;
import org.testng.annotations.Test;

public class ZAPScanTest extends WebBase {

	@Test(description = "Passive security scan using OWASP ZAP tool")
	@FrameworkAnnotations(author = "Mandeep", category = CategoryType.REGRESSION, baseType = TestType.WEB)
	public void zapTest() {
		OWASPZapScan.setZAPConfig();;
		System.out.println("Starting OWASP ZAP...");
		OWASPZapScan.passiveScan();;
		OWASPZapScan.generateReport();
	}
}
