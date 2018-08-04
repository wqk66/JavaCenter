package com.windfarm.bean;

import java.util.List;

public class WindEntity {

	
	private String realDate;
	private List<String> realPowerList;
	public String getRealDate() {
		return realDate;
	}
	public void setRealDate(String realDate) {
		this.realDate = realDate;
	}
	public List<String> getRealPowerList() {
		return realPowerList;
	}
	public void setRealPowerList(List<String> realPowerList) {
		this.realPowerList = realPowerList;
	}
	
	
}
