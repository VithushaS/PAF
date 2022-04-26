package com.example.bill.bill.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.bill.bill.model.billmodel;



public class billservice {
Connection con;
	
	public billservice(){
		try {
			String url = String.format("jdbc:mysql://localhost:3306/bill?useSSL=false");
			String uname = "root";
			String pwd = "root";
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,uname,pwd);
		} catch(Exception e) {
			System.out.println(e+"data insert was unsuccessful");
		}
	}
	
	public billmodel insertBill(billmodel bill) {
		String insert = "insert into bill(bid,account,paid,topay) values(?,?,?,?)";
		
		try {
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setString(1, bill.getBid());
			ps.setString(2, bill.getAccount());
			ps.setLong(3, bill.getPaid());
			ps.setLong(4, bill.getTopay());
			
			ps.execute();
			
			
		}catch(Exception e){
			System.out.println(e+"data insert was unsuccessful");
		}
		
		return bill;  
	}
	
public ArrayList<billmodel> getBill() throws SQLException{
		
		ArrayList<billmodel> data = new ArrayList<billmodel>();
		
		String select = "select * from bill";
		PreparedStatement ps = con.prepareStatement(select);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			billmodel model = new billmodel();
			
			model.setBid(rs.getString("bid")); // column name
			model.setAccount(rs.getString("account"));
			model.setPaid(rs.getInt("paid"));
			model.setTopay(rs.getInt("topay"));
			
			data.add(model);
			
		}
		
		return data;
		
	}
	
	
	public ArrayList<billmodel> getBillById(int id) throws SQLException{
		
		ArrayList<billmodel> data = new ArrayList<billmodel>();
		String select = "select * from bill where id =?";
		PreparedStatement ps = con.prepareStatement(select);
		ps.setInt(1,id);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			billmodel model = new billmodel();
			
			model.setBid(rs.getString("bid")); // column name
			model.setAccount(rs.getString("account"));
			model.setPaid(rs.getInt("paid"));
			model.setTopay(rs.getInt("topay"));	
			data.add(model);		
		}		
		return data;	
	}
	
	public billmodel updatetBill(billmodel bill) {
		String insert = "update bill set name=? , age=? where id =?";
		
		try {
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setString(1, bill.getBid());
			ps.setString(2, bill.getAccount());
			ps.setLong(3, bill.getPaid());
			ps.setLong(4, bill.getTopay());
			ps.setInt(5, bill.getId());
			
			ps.executeUpdate();
		}catch(Exception e) {
			System.out.println(e +"data insert unsuccess.");
		}
		
		return bill;
		
	}
	

	public int deletetBill(int id) {
		String insert = "delete from bill where id =?";
		
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
