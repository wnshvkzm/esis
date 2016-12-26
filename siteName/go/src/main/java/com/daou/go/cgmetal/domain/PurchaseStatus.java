package com.daou.go.cgmetal.domain;

public class PurchaseStatus {
	
	private String customName;
	private String customCode;
	private String itemAccountName;
	private String itemName;
	private String orderQ;
	private String notinstockQ;
	private String dvryDate;
	private String mailId;
	private String makeDate;
	
	public String getMakeDate() {
		return makeDate;
	}
	public void setMakeDate(String makeDate) {
		this.makeDate = makeDate;
	}
	public String getCustomName() {
		return customName;
	}
	public void setCustomName(String customName) {
		this.customName = customName;
	}
	public String getItemAccountName() {
		return itemAccountName;
	}
	public String getCustomCode() {
		return customCode;
	}
	public void setCustomCode(String customCode) {
		this.customCode = customCode;
	}
	public void setItemAccountName(String itemAccountName) {
		this.itemAccountName = itemAccountName;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getOrderQ() {
		return orderQ;
	}
	public void setOrderQ(String orderQ) {
		this.orderQ = orderQ;
	}
	public String getNotinstockQ() {
		return notinstockQ;
	}
	public void setNotinstockQ(String notinstockQ) {
		this.notinstockQ = notinstockQ;
	}
	public String getDvryDate() {
		return dvryDate;
	}
	public void setDvryDate(String dvryDate) {
		this.dvryDate = dvryDate;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PurchaseStatus [customName=");
		builder.append(customName);
		builder.append(", customCode=");
		builder.append(customCode);
		builder.append(", itemAccountName=");
		builder.append(itemAccountName);
		builder.append(", itemName=");
		builder.append(itemName);
		builder.append(", orderQ=");
		builder.append(orderQ);
		builder.append(", notinstockQ=");
		builder.append(notinstockQ);
		builder.append(", dvryDate=");
		builder.append(dvryDate);
		builder.append(", mailId=");
		builder.append(mailId);
		builder.append(", makeDate=");
		builder.append(makeDate);
		builder.append("]");
		return builder.toString();
	}

}
