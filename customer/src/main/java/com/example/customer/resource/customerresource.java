package com.example.customer.resource;

import java.sql.SQLException;
import java.util.ArrayList;

import com.example.customer.model.customermodel;
import com.example.customer.service.customerservice;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/customer")
public class customerresource {
customerservice service = new customerservice();
	
	@Path("/add")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public customermodel addCustomer(customermodel customer) {
		return service.insertCustomer(customer);
	}
	
	@Path("/retrieve")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<customermodel>  getCustomer() throws SQLException {
		 return service.getCustomer();
		
	}
	
	@Path("/retrieveById/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<customermodel>  getCustomer(@PathParam("id") int id) throws SQLException {
		return service.getCustomerById(id);
		
	}
	

	
	@Path("/updateCustomer")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public customermodel updateCustomer(customermodel customer) {
		 return service.updatetCustomer(customer);
		
	}
	
	@Path("/deleteCustomerById/{id}")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public int deleteCustomer(@PathParam("id") int id) {
		return service.deletetCustomer(id);
		
	}
}
