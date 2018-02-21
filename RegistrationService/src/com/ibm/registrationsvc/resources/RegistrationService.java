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

@Path("/registrations")
@Consumes(MediaType.APPLICATION_JSON)
public class RegistrationService {
	
	@Path("/users")
	   public Users UsersResource() {
		Users userResource = new Users();
	      return userResource;
	   }

}
