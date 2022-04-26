package com.example.customer.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.example.customer.model.customermodel;

public class customerservice {
Connection con;
	
	public customerservice(){
		try {
			String url = String.format("jdbc:mysql://localhost:3306/customer?useSSL=false");
			String uname = "root";
			String pwd = "root";
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,uname,pwd);
		} catch(Exception e) {
			System.out.println(e+"data insert was unsuccessful");
		}
	}
	
	public customermodel insertCustomer(customermodel customer) {
		String insert = "insert into customer(name,address,account,contact) values(?,?,?,?)";
		
		try {
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setString(1, customer.getName());
			ps.setString(2, customer.getAddress());
			ps.setLong(3, customer.getAccount());
			ps.setLong(4, customer.getContact());
			
			ps.execute();
			
			
		}catch(Exception e){
			System.out.println(e+"data insert was unsuccessful");
		}
		
		return customer;  
	}
	
public ArrayList<customermodel> getCustomer() throws SQLException{
		
		ArrayList<customermodel> data = new ArrayList<customermodel>();
		
		String select = "select * from customer";
		PreparedStatement ps = con.prepareStatement(select);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			customermodel model = new customermodel();
			
			model.setName(rs.getString("name")); // column name
			model.setAddress(rs.getString("address"));
			model.setAccount(rs.getInt("account"));
			model.setContact(rs.getInt("contact"));
			
			data.add(model);
			
		}
		
		return data;
		
	}
	
	
	public ArrayList<customermodel> getCustomerById(int id) throws SQLException{
		
		ArrayList<customermodel> data = new ArrayList<customermodel>();
		String select = "select * from customer where id =?";
		PreparedStatement ps = con.prepareStatement(select);
		ps.setInt(1,id);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			customermodel model = new customermodel();
			
			model.setName(rs.getString("name")); // column name
			model.setAddress(rs.getString("address"));
			model.setAccount(rs.getInt("account"));
			model.setContact(rs.getInt("contact"));	
			data.add(model);		
		}		
		return data;	
	}
	
	public customermodel updatetCustomer(customermodel customer) {
		String insert = "update customer set name=? , age=? where id =?";
		
		try {
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setString(1, customer.getName());
			ps.setString(2, customer.getAddress());
			ps.setLong(3, customer.getAccount());
			ps.setLong(4, customer.getContact());
			ps.setInt(5, customer.getId());
			
			ps.executeUpdate();
		}catch(Exception e) {
			System.out.println(e +"data insert unsuccess.");
		}
		
		return customer;
		
	}
	

	public int deletetCustomer(int id) {
		String insert = "delete from customer where id =?";
		
		try {
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setInt(1,id);
			
			ps.executeUpdate();
		}catch(Exception e) {
			System.out.println(e +"data insert unsuccess.");
		}
		
		return id;
		
	}
}
