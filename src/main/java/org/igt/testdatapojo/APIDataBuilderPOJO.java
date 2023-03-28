package org.igt.testdatapojo;

import lombok.Builder;
import lombok.Getter;

/**
 * POJO class to build the message for request creation using Lombak and builder design pattern.
 * Mar 14, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 */
@Builder(setterPrefix="set")
@Getter
public class APIDataBuilderPOJO {		
		private int id;
		private String firstname;
		private String lastname;
	}



