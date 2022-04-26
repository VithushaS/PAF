package com.example.employee.model;

public class employeemodel {
	private int id;
	private String name;
	private String nic;
	private int age;
	private int contact;
	
	public employeemodel() {}
	
	public employeemodel(int id, String name, String nic, int age, int contact) {
		super();
		this.id = id;
		this.name = name;
		this.nic = nic;
		this.age = age;
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

	public String getNic() {
		return nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getContact() {
		return contact;
	}

	public void setContact(int contact) {
		this.contact = contact;
	}
}
