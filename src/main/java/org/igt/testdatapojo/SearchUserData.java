package org.igt.testdatapojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
 * Class to construct user data to build test case input
 * Mar 4, 2023
 * @author Mandeep Sheoran
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Getter
public class SearchUserData {	
	private String userName;
	private String employeeName;
	private String userRole;
	private String status;
}
