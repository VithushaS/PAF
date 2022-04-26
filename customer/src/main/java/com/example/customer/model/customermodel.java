package com.example.customer.model;

public class customermodel {
	private int id;
	private String name;
	private String address;
	private int account;
	private int contact;
	
	public customermodel() {}

	public customermodel(int id, String name, String address, int account, int contact) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.account = account;
		this.contact = contact;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAccount() {
		return account;
	}

	public void setAccount(int account) {
		this.account = account;
	}

	public int getContact() {
		return contact;
	}

	public void setContact(int contact) {
		this.contact = contact;
	}
	
	
	
	
	
}
