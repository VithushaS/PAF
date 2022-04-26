package com.example.employee.resource;

import java.sql.SQLException;
import java.util.ArrayList;

import com.example.employee.model.employeemodel;
import com.example.employee.service.employeeservice;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/employee")
public class employeeresource {
employeeservice service = new employeeservice();
	
	@Path("/add")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public employeemodel addEmployee(employeemodel employee) {
		return service.insertEmployee(employee);
	}
	
	@Path("/retrieve")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<employeemodel>  getEmployee() throws SQLException {
		 return service.getEmployee();
		
	}
	
	@Path("/retrieveById/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<employeemodel>  getEmployee(@PathParam("id") int id) throws SQLException {
		return service.getEmployeeById(id);
		
	}
	

	
	@Path("/updateEmployee")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public employeemodel updateEmployee(employeemodel employee) {
		 return service.updatetEmployee(employee);
		
	}
	
	@Path("/deleteEmployeeById/{id}")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public int deleteEmployee(@PathParam("id") int id) {
		return service.deletetEmployee(id);
		
	}
}
