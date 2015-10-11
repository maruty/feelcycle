package com.marublo.feelcycle.dto;

/**
 * 集計情報を格納するDTO
 *
 * @author Y.Yanagisawa / tiritiri / maruty
 * @version 1.0
 */
public class ShukeiDataDto {
	
	private String 	shukeiName; //集計用項目名
	private String shukeiValue; //レッスン名
	
	
	
	public String getShukeiName() {
		return shukeiName;
	}
	public void setShukeiName(String shukeiName) {
		this.shukeiName = shukeiName;
	}
	public String getShukeiValue() {
		return shukeiValue;
	}
	public void setShukeiValue(String shukeiValue) {
		this.shukeiValue = shukeiValue;
	}


}
