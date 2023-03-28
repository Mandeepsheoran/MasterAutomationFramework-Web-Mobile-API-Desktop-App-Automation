package org.igt.listeners;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.igt.constants.FrameworkConstant;
import org.igt.utils.ExcelUtils;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

/**
 * Class to provide methods which will extract list of applicable test data <p>
 * from complete list of data gathered using ExcelUtils.<p>
 * Mar 21, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see ExcelUtils
 */
public class MethodInterceptor implements IMethodInterceptor {
	/**
	 * Method to find the test case name and other details along with status of execution, priority and no of execution.
	 * @author Mandeep.Sheoran
	 */
	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
		List<Map<String, String>> list = ExcelUtils.getTestDetails(FrameworkConstant.getTESTCASESHEET());
		System.out.println("got list : "+ list);
		List<IMethodInstance> result = new ArrayList<>();
			for(int i=0;i<methods.size();i++) {
			for(int j=0;j<list.size();j++) {
				if(methods.get(i).getMethod().getMethodName().equalsIgnoreCase(list.get(j).get("testname")) &&
					(list.get(j).get("Execute").equalsIgnoreCase("yes"))) {
						methods.get(i).getMethod().setDescription(list.get(j).get("testdescription"));
						methods.get(i).getMethod().setInvocationCount(Integer.parseInt(list.get(j).get("count")));
						methods.get(i).getMethod().setPriority(Integer.parseInt(list.get(j).get("priority")));
						result.add(methods.get(i));
					}
				}
		}	
		return result;
	}
}
