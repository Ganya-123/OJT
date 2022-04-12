package com.main.first;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.parser.ParseException;

import com.main.first.dto.LoginRequestDto;
import com.main.first.dto.UserResponseDto;
import com.main.first.repo.UserRepo;
import com.main.first.service.UserService;



@Path("myresource")
public class MyResource {
	private static Logger logger= LogManager.getLogger(MyResource.class);



	UserService userservice=new UserService();


	@POST
	@Path("login")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces({ MediaType.APPLICATION_JSON})
	public Response loginrequest(LoginRequestDto loginRequestDto) throws IOException, ParseException, SQLException {

		logger.info("Hitting the post API");
		logger.info("Entered to loginrequest method");

		UserResponseDto response= userservice.validate(loginRequestDto);
		if(response!=null)
		{

			String details="login successful"+"\nuser_id : "+response.getUser_id()+"\nuser_name : "+response.getUser_name()+"\nfullname : "+response.getFull_name()+"\ndate_of_birth : "+response.getDate_of_birth()+"\npassword : ***** ";
			logger.info("if block executed :"+details);	
			logger.info("Exit from loginrequest method");
			logger.info("---------------------------------------------------------------");
			return Response.ok(details).build();

		}
		else
		{
			logger.error("login unsuccessful and going through else block");
			String str=	userservice.readFilee(loginRequestDto.getUser_id(),loginRequestDto.getPassword());

			logger.info("Exit from loginrequest method");
			logger.info("---------------------------------------------------------------");
			return Response.status(Response.Status.BAD_REQUEST).entity(str).build();
		}

	}

	@GET
	@Path("show")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public String show(LoginRequestDto loginRequestDto){

		return " i am displaying";
	}
};

