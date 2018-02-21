package com.ibm.registrationsvc.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.ibm.registrationsvc.dto.User;
import com.ibm.registrationsvc.services.UserService;

public class Users {
	UserService userService = new UserService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllUsers()
	{
		List<User> userList = userService.getAllUsers();
		if(userList.size() == 0){
			return Response.status(Status.NO_CONTENT).build();
		}
		else
		{
			GenericEntity<List<User>> userGenList = new GenericEntity<List<User>>(userList){};
			return Response.status(Status.OK).entity(userGenList).build();
		}
	}
	
	@GET
	@Path("/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findUserById(@PathParam("userId") int userId)
	{
		   Response response = null ;
		   try {
			 User user = userService.findUserById(userId);
				if(!user.equals(null) ) {
					response  = Response.status(Status.OK).entity(user).build(); 
				}
		    } catch (NullPointerException  e) {
			   return Response.status(Status.NOT_FOUND).entity("No such User id: "+ userId).build();
			}
		return response;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response addUser(User user)
	{
		
		try {
			userService.addUser(user);
		   return Response.status(Status.CREATED).entity(user).build();
		 } catch (Exception  e) {
			   return Response.status(Status.BAD_REQUEST).entity("Failed to Process Adding User" ).build();
		 }
	}
	
	@PUT
	@Path("/{userId}")
	public Response updateUser(@PathParam("userId") int userId, User user)
	{
		Response response = null ;
		try {
			User searchedUser = userService.findUserById(userId);
			if(!searchedUser.equals(null)){
				user.setId(userId);
				userService.updateUser(user);
				response = Response.status(Status.OK).entity(user).build();
			}
		 } catch (NullPointerException  e) {
			   return Response.status(Status.BAD_REQUEST).entity("User id #" + userId + "not avialable" ).build();
		 }
		return response;
	}
	
	@DELETE
	@Path("/{userId}")
	public Response deleteUser(@PathParam("userId") int userId)
	{
		Response response = null ;
		try {
			User searchedUser = userService.findUserById(userId);
			if(!searchedUser.equals(null)){
				userService.deleteUser(userId);
				response = Response.status(Status.OK).entity("User Deleted : "+userId).build();
			}
		 } catch (NullPointerException  e) {
			   return Response.status(Status.BAD_REQUEST).entity("User id #" + userId + " not avialable" ).build();
		 }
		return  response;
	}
}
