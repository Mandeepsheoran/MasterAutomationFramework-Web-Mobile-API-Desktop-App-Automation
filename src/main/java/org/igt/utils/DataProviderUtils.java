package org.igt.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.igt.constants.FrameworkConstant;
import org.testng.annotations.DataProvider;

/**
 * Class having method to control the test case execution from excel sheet.<p>
 * No need to use enabled=false against test cases in testng annotations.
 * Mar 31, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see ExcelUtils
 */
public class DataProviderUtils {
	
	protected static List<Map<String,String>> list = new ArrayList<>();   
	/**
	 * This method will find out list of test cases<p>
	 * which from excel sheet which are applicable for test case execution
	 * @param m
	 * @return
	 */
	@DataProvider(parallel=true)
	public static Object[] getTestData(Method m) {   
		String testcasename = m.getName();		
		if(list.isEmpty()) {   
			list = ExcelUtils.getTestDetails(FrameworkConstant.getTESTDATASHEET());
		}				
		List<Map<String,String>> iterationlist = new ArrayList<>();			
		for(int i=0;i<list.size();i++) {
			if(list.get(i).get("testname").equalsIgnoreCase(testcasename) &&
				(list.get(i).get("execute").equalsIgnoreCase("yes"))) {
					iterationlist.add(list.get(i));
				}								
		}
		return iterationlist.toArray();		
	}
}
