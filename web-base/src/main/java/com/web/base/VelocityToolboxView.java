package com.web.base;

import org.apache.velocity.context.Context;
import org.apache.velocity.tools.Scope;
import org.apache.velocity.tools.ToolboxFactory;
import org.apache.velocity.tools.config.XmlFactoryConfiguration;
import org.apache.velocity.tools.view.ViewToolContext;
import org.springframework.core.io.Resource;
import org.springframework.web.context.support.ServletContextResource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URL;
import java.util.Map;

public class VelocityToolboxView extends
		org.springframework.web.servlet.view.velocity.VelocityToolboxView {

	private Resource toolboxConfigResource;
	public Resource getToolboxConfigResource() {
		return toolboxConfigResource;
	}
	public void setToolboxConfigResource(Resource toolboxConfigResource) {
		this.toolboxConfigResource = toolboxConfigResource;
	}
	@Override
	protected Context createVelocityContext(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ViewToolContext velocityContext = new ViewToolContext(getVelocityEngine(), request, response, getServletContext());
		velocityContext.putAll(model);
		if(getToolboxConfigLocation() != null ||getToolboxConfigResource() != null){
			XmlFactoryConfiguration cfg = new XmlFactoryConfiguration();
			URL cfgUrl;
			if(getToolboxConfigLocation() != null){
				cfgUrl = new ServletContextResource(getServletContext(), getToolboxConfigLocation()).getURL();
				cfg.read(cfgUrl);
			}else if(getToolboxConfigResource() != null){
				cfgUrl = getToolboxConfigResource().getURL();
				cfg.read(cfgUrl);
				ToolboxFactory factory = cfg.createFactory();
				
				velocityContext.addToolbox(factory.createToolbox(Scope.APPLICATION));
				velocityContext.addToolbox(factory.createToolbox(Scope.REQUEST));
				velocityContext.addToolbox(factory.createToolbox(Scope.SESSION));
			}
		}
		return velocityContext;
	}
	
	

}
