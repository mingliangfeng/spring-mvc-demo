package me.mingliangfeng.spring.demo.service;

import me.mingliangfeng.spring.demo.util.Utils;

public class RegistarInfo {
	private String fullName;	
	private int registerYear;
	
	public RegistarInfo() {		
	}
	
	public RegistarInfo(String fullName, int registerYear) {
		super();
		this.fullName = fullName;
		this.registerYear = registerYear;
	}
	
	public String getDomainZone() {
		if (getFullName() == null) return "";
		
		int index = getFullName().indexOf(".");
		if (index == -1) return "";
		return getFullName().substring(index);
	}
	
	public String getFormatedFullName() {
		return Utils.formatDomainName(getFullName()) ;
	}
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public int getRegisterYear() {
		return registerYear;
	}
	public void setRegisterYear(int registerYear) {
		this.registerYear = registerYear;
	}
	
}
