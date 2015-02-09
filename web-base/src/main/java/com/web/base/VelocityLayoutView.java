package com.web.base;

import org.apache.velocity.Template;
import org.apache.velocity.context.Context;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.BeansException;
import org.springframework.core.NestedIOException;

import javax.servlet.http.HttpServletResponse;
import java.io.StringWriter;
import java.util.Locale;

public class VelocityLayoutView extends VelocityToolboxView{
	public static final String DEFAULT_LAYOUT_URL = "layout.vm";
	public static final String DEFAULT_LAYOUT_KEY = "layout";
	public static final String DEFAULT_SCREEN_CONTENT_KEY = "screen_content";
	
	private String layoutUrl;
	private String layoutDir;
	private String layoutKey = DEFAULT_LAYOUT_KEY;
	private String screenContentKey = DEFAULT_SCREEN_CONTENT_KEY;
	
	
	@Override
	protected void initApplicationContext() throws BeansException {
		super.initApplicationContext();
		this.layoutUrl = (String) getVelocityEngine().getProperty("tools.view.servlet.layout.default.template");
		this.layoutDir = (String) getVelocityEngine().getProperty("tools.view.servlet.layout.directory");
		if(this.layoutKey == ""){
			this.layoutUrl = DEFAULT_LAYOUT_KEY;
		}
		if(!this.layoutDir.endsWith("/")){
			this.layoutDir = this.layoutDir + "/";
		}
	}
	
	@Override
	public boolean checkResource(Locale locale) throws Exception {
		if(!super.checkResource(locale)){
			return false;
		}
		try {
			getTemplate(getTotalLayoutUrl(this.layoutUrl));
			return true;
		} catch (ResourceNotFoundException e) {
			throw new NestedIOException("cannot find Velocity template for URL",e);
		}catch (Exception e) {
			throw new NestedIOException("cannot load Velocity template for URL",e);
		}
	}

	@Override
	protected void doRender(Context context, HttpServletResponse response) throws Exception {
		renderScreenContent(context);
		String layoutUrlToUse = (String) context.get(this.layoutKey);
		if(layoutUrlToUse == null){
			layoutUrlToUse = this.layoutUrl;
		}
		mergeTemplate(getTemplate(getTotalLayoutUrl(layoutUrlToUse)), context, response);
	}
	
	private void renderScreenContent(Context velocityContext) throws Exception {
		StringWriter sw = new StringWriter();
		Template screenContentTemplate = getTemplate(getUrl());
		screenContentTemplate.merge((Context) velocityContext,sw);
		velocityContext.put(this.screenContentKey, sw.toString());
	}
	
	public String getTotalLayoutUrl(String layoutUrl){
		return layoutDir + layoutUrl;
	}
	public String getLayoutUrl() {
		return layoutUrl;
	}


	public void setLayoutUrl(String layoutUrl) {
		this.layoutUrl = layoutUrl;
	}


	public String getLayoutDir() {
		return layoutDir;
	}


	public void setLayoutDir(String layoutDir) {
		this.layoutDir = layoutDir;
	}


	public String getLayoutKey() {
		return layoutKey;
	}


	public void setLayoutKey(String layoutKey) {
		this.layoutKey = layoutKey;
	}


	public String getScreenContentKey() {
		return screenContentKey;
	}


	public void setScreenContentKey(String screenContentKey) {
		this.screenContentKey = screenContentKey;
	}
	
	
}
