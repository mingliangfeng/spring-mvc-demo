package me.mingliangfeng.spring.demo.util;

import org.springframework.util.StringUtils;

public class Utils {
	
	public static String formatDomainName(String domainName) {
		String name = StringUtils.trimAllWhitespace(domainName);
		if (name != null) name = name.toLowerCase();
		
		return name;
	}

}
