package com.web.base;

import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class DownloadView extends AbstractView {
	
	public static final String DEFAULT_CONTENT_TYPE="application/xls";
	
	public DownloadView(String contentType){
		if(null == contentType){
			setContentType(DEFAULT_CONTENT_TYPE);
		}else{
			setContentType(contentType);
		}
	}
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType(getContentType());
	}
	

}
