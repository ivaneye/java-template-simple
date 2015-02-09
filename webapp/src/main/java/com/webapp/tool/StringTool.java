package com.webapp.tool;

import org.apache.commons.lang.StringUtils;
import org.apache.velocity.tools.generic.FormatConfig;

public class StringTool extends FormatConfig{
	
	public boolean isContains(String origin, String key){
		origin = StringUtils.trimToEmpty(origin);
//		key = StringUtils.trimToEmpty(key);
		return origin.contains(key);
	}
	
	public String addToOrigin(String prefix, String origin, String suffix){
		origin = StringUtils.trimToEmpty(origin);
		prefix = StringUtils.trimToEmpty(prefix);
		suffix = StringUtils.trimToEmpty(suffix);
		return prefix + origin + suffix;
	}

}
