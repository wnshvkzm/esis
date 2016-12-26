package com.daou.go.cgmetal.domain;

public class ManufactureStatus {
	
	private String makeDate;
	private String prodtNum;
	private String workShopCode;
	private String workShopName;
	private String itemCode;
	private String itemName;
	private String wkordQ;
	private double prodtQ;
	private double manHour;
	private double tempn01;
	private double tempn02;
	private int tempn03;
	private int timeRate;
	private int goodRate;
	private int totalRate;
	public String getMakeDate() {
		return makeDate;
	}
	public void setMakeDate(String makeDate) {
		this.makeDate = makeDate;
	}
	public String getProdtNum() {
		return prodtNum;
	}
	public void setProdtNum(String prodtNum) {
		this.prodtNum = prodtNum;
	}
	public String getWorkShopCode() {
		return workShopCode;
	}
	public void setWorkShopCode(String workShopCode) {
		this.workShopCode = workShopCode;
	}
	public String getWorkShopName() {
		return workShopName;
	}
	public void setWorkShopName(String workShopName) {
		this.workShopName = workShopName;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getWkordQ() {
		return wkordQ;
	}
	public void setWkordQ(String wkordQ) {
		this.wkordQ = wkordQ;
	}
	public double getProdtQ() {
		return prodtQ;
	}
	public void setProdtQ(double prodtQ) {
		this.prodtQ = prodtQ;
	}
	public double getManHour() {
		return manHour;
	}
	public void setManHour(double manHour) {
		this.manHour = manHour;
	}
	public double getTempn01() {
		return tempn01;
	}
	public void setTempn01(double tempn01) {
		this.tempn01 = tempn01;
	}
	public double getTempn02() {
		return tempn02;
	}
	public void setTempn02(double tempn02) {
		this.tempn02 = tempn02;
	}
	public int getTempn03() {
		return tempn03;
	}
	public void setTempn03(int tempn03) {
		this.tempn03 = tempn03;
	}
	public int getTimeRate() {
		return timeRate;
	}
	public void setTimeRate(int timeRate) {
		this.timeRate = timeRate;
	}
	public int getGoodRate() {
		return goodRate;
	}
	public void setGoodRate(int goodRate) {
		this.goodRate = goodRate;
	}
	public int getTotalRate() {
		return totalRate;
	}
	public void setTotalRate(int totalRate) {
		this.totalRate = totalRate;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ManufactureStatus [makeDate=");
		builder.append(makeDate);
		builder.append(", prodtNum=");
		builder.append(prodtNum);
		builder.append(", workShopCode=");
		builder.append(workShopCode);
		builder.append(", workShopName=");
		builder.append(workShopName);
		builder.append(", itemCode=");
		builder.append(itemCode);
		builder.append(", itemName=");
		builder.append(itemName);
		builder.append(", wkordQ=");
		builder.append(wkordQ);
		builder.append(", prodtQ=");
		builder.append(prodtQ);
		builder.append(", manHour=");
		builder.append(manHour);
		builder.append(", tempn01=");
		builder.append(tempn01);
		builder.append(", tempn02=");
		builder.append(tempn02);
		builder.append(", tempn03=");
		builder.append(tempn03);
		builder.append(", timeRate=");
		builder.append(timeRate);
		builder.append(", goodRate=");
		builder.append(goodRate);
		builder.append(", totalRate=");
		builder.append(totalRate);
		builder.append("]");
		return builder.toString();
	}
	
	
}
