package me.mingliangfeng.spring.demo.controller;

import java.util.ArrayList;
import java.util.List;

import me.mingliangfeng.spring.demo.service.RegistarInfo;

public class RegistarForm {
	
	private List<RegistarInfo> registarInfos = new ArrayList<RegistarInfo>();

	public List<RegistarInfo> getRegistarInfos() {
		return registarInfos;
	}

	public void setRegistarInfos(List<RegistarInfo> registarInfos) {
		this.registarInfos = registarInfos;
	}


}
