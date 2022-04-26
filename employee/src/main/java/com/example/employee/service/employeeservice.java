package com.example.employee.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.example.employee.model.employeemodel;

public class employeeservice {
Connection con;
	
	public employeeservice(){
		try {
			String url = String.format("jdbc:mysql://localhost:3306/employee?useSSL=false");
			String uName = "root";
			String pwd = "root";
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,uName,pwd);
		} catch(Exception e) {
			System.out.println(e+"data insert was unsuccessful");
		}
	}
	
	public employeemodel insertEmployee(employeemodel employee) {
		String insert = "insert into employee(name,nic,age,contact) values(?,?,?,?)";
		
		try {
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setString(1, employee.getName());
			ps.setString(2, employee.getNic());
			ps.setLong(3, employee.getAge());
			ps.setLong(4, employee.getContact());
			
			ps.execute();
			
			
		}catch(Exception e){
			System.out.println(e+"data insert was unsuccessful");
		}
		
		return employee;  
	}
	
public ArrayList<employeemodel> getEmployee() throws SQLException{
		
		ArrayList<employeemodel> data = new ArrayList<employeemodel>();
		
		String select = "select * from employee";
		PreparedStatement ps = con.prepareStatement(select);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			employeemodel model = new employeemodel();
			
			model.setName(rs.getString("name")); // column Name
			model.setNic(rs.getString("nic"));
			model.setAge(rs.getInt("age"));
			model.setContact(rs.getInt("contact"));
			
			data.add(model);
			
		}
		
		return data;
		
	}
	
	
	public ArrayList<employeemodel> getEmployeeById(int id) throws SQLException{
		
		ArrayList<employeemodel> data = new ArrayList<employeemodel>();
		String select = "select * from employee where id =?";
		PreparedStatement ps = con.prepareStatement(select);
		ps.setInt(1,id);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			employeemodel model = new employeemodel();
			
			model.setName(rs.getString("name")); // column Name
			model.setNic(rs.getString("nic"));
			model.setAge(rs.getInt("age"));
			model.setContact(rs.getInt("contact"));	
			data.add(model);		
		}		
		return data;	
	}
	
	public employeemodel updatetEmployee(employeemodel employee) {
		String insert = "update employee set Name=? , age=? where id =?";
		
		try {
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setString(1, employee.getName());
			ps.setString(2, employee.getNic());
			ps.setLong(3, employee.getAge());
			ps.setLong(4, employee.getContact());
			ps.setInt(5, employee.getId());
			
			ps.executeUpdate();
		}catch(Exception e) {
			System.out.println(e +"data insert unsuccess.");
		}
		
		return employee;
		
	}
	

	public int deletetEmployee(int id) {
		String insert = "delete from employee where id =?";
		
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
