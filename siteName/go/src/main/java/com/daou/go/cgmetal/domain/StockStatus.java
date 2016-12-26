package com.daou.go.cgmetal.domain;


public class StockStatus {
	
	private String makeDay;
	private String itemAccount;
	private String itemAccountName;
	private String itemCode;
	private String itemName;
	private String stockUnit;
	private String stockQ;
	private String safeStockQ;
	private int safeStockPer;
	public String getMakeDay() {
		return makeDay;
	}
	public void setMakeDay(String makeDay) {
		this.makeDay = makeDay;
	}
	public String getItemAccount() {
		return itemAccount;
	}
	public void setItemAccount(String itemAccount) {
		this.itemAccount = itemAccount;
	}
	public String getItemAccountName() {
		return itemAccountName;
	}
	public void setItemAccountName(String itemAccountName) {
		this.itemAccountName = itemAccountName;
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
	public String getStockUnit() {
		return stockUnit;
	}
	public void setStockUnit(String stockUnit) {
		this.stockUnit = stockUnit;
	}
	public String getStockQ() {
		return stockQ;
	}
	public void setStockQ(String stockQ) {
		this.stockQ = stockQ;
	}
	public String getSafeStockQ() {
		return safeStockQ;
	}
	public void setSafeStockQ(String safeStockQ) {
		this.safeStockQ = safeStockQ;
	}
	public int getSafeStockPer() {
		return safeStockPer;
	}
	public void setSafeStockPer(int safeStockPer) {
		this.safeStockPer = safeStockPer;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("StockStatus [makeDay=");
		builder.append(makeDay);
		builder.append(", itemAccount=");
		builder.append(itemAccount);
		builder.append(", itemAccountName=");
		builder.append(itemAccountName);
		builder.append(", itemCode=");
		builder.append(itemCode);
		builder.append(", itemName=");
		builder.append(itemName);
		builder.append(", stockUnit=");
		builder.append(stockUnit);
		builder.append(", stockQ=");
		builder.append(stockQ);
		builder.append(", safeStockQ=");
		builder.append(safeStockQ);
		builder.append(", safeStockPer=");
		builder.append(safeStockPer);
		builder.append("]");
		return builder.toString();
	}
	
	
}
