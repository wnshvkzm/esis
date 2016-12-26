package com.daou.go.cgmetal.domain;

public class OutsourceStatus {
	private String makeDate;
	private String orderNum;
	private double orderSeq;
	private String customCode;
	private String customName;
	private String itemAccount;
	private String itemAccountName;
	private String itemName;
	private String itemCode;
	private String treeCode;
	private String treeName;
	private String orderQ;
	private String notinstockQ;
	private String dvryDate;
	private String mailId;
	private String stockUnit;
	private String insertDbUser;
	private String insertDbTime;
	public String getMakeDate() {
		return makeDate;
	}
	public void setMakeDate(String makeDate) {
		this.makeDate = makeDate;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public double getOrderSeq() {
		return orderSeq;
	}
	public void setOrderSeq(double orderSeq) {
		this.orderSeq = orderSeq;
	}
	public String getCustomCode() {
		return customCode;
	}
	public void setCustomCode(String customCode) {
		this.customCode = customCode;
	}
	public String getCustomName() {
		return customName;
	}
	public void setCustomName(String customName) {
		this.customName = customName;
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
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getTreeCode() {
		return treeCode;
	}
	public void setTreeCode(String treeCode) {
		this.treeCode = treeCode;
	}
	public String getTreeName() {
		return treeName;
	}
	public void setTreeName(String treeName) {
		this.treeName = treeName;
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
	public String getStockUnit() {
		return stockUnit;
	}
	public void setStockUnit(String stockUnit) {
		this.stockUnit = stockUnit;
	}
	public String getInsertDbUser() {
		return insertDbUser;
	}
	public void setInsertDbUser(String insertDbUser) {
		this.insertDbUser = insertDbUser;
	}
	public String getInsertDbTime() {
		return insertDbTime;
	}
	public void setInsertDbTime(String insertDbTime) {
		this.insertDbTime = insertDbTime;
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OutsourceStatus [makeDate=");
		builder.append(makeDate);
		builder.append(", orderNum=");
		builder.append(orderNum);
		builder.append(", orderSeq=");
		builder.append(orderSeq);
		builder.append(", customCode=");
		builder.append(customCode);
		builder.append(", customName=");
		builder.append(customName);
		builder.append(", itemAccount=");
		builder.append(itemAccount);
		builder.append(", itemAccountName=");
		builder.append(itemAccountName);
		builder.append(", itemName=");
		builder.append(itemName);
		builder.append(", itemCode=");
		builder.append(itemCode);
		builder.append(", treeCode=");
		builder.append(treeCode);
		builder.append(", treeName=");
		builder.append(treeName);
		builder.append(", orderQ=");
		builder.append(orderQ);
		builder.append(", notinstockQ=");
		builder.append(notinstockQ);
		builder.append(", dvryDate=");
		builder.append(dvryDate);
		builder.append(", mailId=");
		builder.append(mailId);
		builder.append(", stockUnit=");
		builder.append(stockUnit);
		builder.append(", insertDbUser=");
		builder.append(insertDbUser);
		builder.append(", insertDbTime=");
		builder.append(insertDbTime);
		builder.append("]");
		return builder.toString();
	}
	
}
