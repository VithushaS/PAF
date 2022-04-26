package com.example.bill.bill.resource;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.bill.bill.model.billmodel;
import com.example.bill.bill.service.billservice;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/bill")
public class billresource {
billservice service = new billservice();
	
	@Path("/add")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public billmodel addBill(billmodel bill) {
		return service.insertBill(bill);
	}
	
	@Path("/retrieve")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<billmodel>  getBill() throws SQLException {
		 return service.getBill();
		
	}
	
	@Path("/retrieveById/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<billmodel>  getBill(@PathParam("id") int id) throws SQLException {
		return service.getBillById(id);
		
	}
	

	
	@Path("/updateBill")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public billmodel updateBill(billmodel bill) {
		 return service.updatetBill(bill);
		
	}
	
	@Path("/deleteBillById/{id}")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public int deleteBill(@PathParam("id") int id) {
		return service.deletetBill(id);
		
	}
}
