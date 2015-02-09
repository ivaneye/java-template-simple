package com.webapp.util;

import org.springframework.web.context.WebApplicationContext;

public class ApplicationContext {

	private static WebApplicationContext webContext;

	public static void init(WebApplicationContext context) {
		webContext = context;
	}
	
	public static <T> T getBean(String id){
		return (T) webContext.getBean(id);
	}
}
