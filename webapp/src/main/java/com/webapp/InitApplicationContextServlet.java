package com.webapp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.webapp.util.ApplicationContext;

/**
 * 初始化ApplicationContext
 * 方便在非Spring管理的类中获取Spring中的bean
 */
public class InitApplicationContextServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		super.init();
		
		//初始化SpringContext
		ApplicationContext.init(WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext()));
	}
}
