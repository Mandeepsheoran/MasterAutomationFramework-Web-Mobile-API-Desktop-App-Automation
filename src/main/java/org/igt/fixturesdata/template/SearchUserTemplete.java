package org.igt.fixturesdata.template;

import org.igt.testdatapojo.SearchUserData;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
/**
 * Fixture factory class to create test data for test cases.
 * Mar 14, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see Fixture
 */
public class SearchUserTemplete implements TemplateLoader{

	@Override
	public void load() {
		Fixture.of(SearchUserData.class).addTemplate("fulldata",new Rule() {{
			add("userName", random("Mandeep", "SK", "Sudhanshu"));
			add("employeeName", random("Krishna", "Kumar", "Suri"));
			add("userRole", random("Admin", "ESS"));
			add("status", random("Enabled", "Disabled"));
		}});
		
		Fixture.of(SearchUserData.class).addTemplate("usernamedata",new Rule() {{
			add("userName", random("Mandeep", "SK", "Sudhanshu"));
		}});
	}
	
	

}
