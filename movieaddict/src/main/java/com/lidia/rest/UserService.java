package com.lidia.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.lidia.User;
import com.lidia.manager.UserManager;

@Path("/MovieAddict")
@RestController
public class UserService {

	@Autowired
	UserManager userManager;
	
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getEntities(){
		return userManager.findAllUsers();
	}
	
	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public void postEntity(User user){
		userManager.saveUser(user);
	}
}
