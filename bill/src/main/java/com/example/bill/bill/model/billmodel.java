package com.example.bill.bill.model;

public class billmodel {
	private int id;
	private String bid;
	private String account;
	private int paid;
	private int topay;
	
	public billmodel(int id, String bid, String account, int paid, int topay) {
		super();
		this.id = id;
		this.bid = bid;
		this.account = account;
		this.paid = paid;
		this.topay = topay;
	}

	public billmodel() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public int getPaid() {
		return paid;
	}

	public void setPaid(int paid) {
		this.paid = paid;
	}

	public int getTopay() {
		return topay;
	}

	public void setTopay(int topay) {
		this.topay = topay;
	}
	
	
}
