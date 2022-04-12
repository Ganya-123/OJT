package com.main.first.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.main.first.MyResource;
import com.main.first.User;

import com.main.first.dto.LoginRequestDto;
import com.main.first.dto.UserResponseDto;
import com.main.first.repo.UserRepo;

import jdk.internal.org.jline.utils.Log;

public class UserService {
	private static Logger logger= LogManager.getLogger(UserService.class);

	UserRepo userRepo = new UserRepo();
	User usersix=new User();

	public UserResponseDto validate(LoginRequestDto loginRequestDto) throws IOException, ParseException {
		logger.info("entered to validate method to fetch details by id");

		User val=userRepo.findById(loginRequestDto.getUser_id());
		
		if(val==null) {
			logger.info("exit : validate method");
			
			return null;
		}
		else if(loginRequestDto.getPassword().equals(val.getPassword())){
			logger.info("entered to password validation block");
			
			
			UserResponseDto userResponseDto=new UserResponseDto();
			userResponseDto.setUser_id(val.getUser_id());
			userResponseDto.setFull_name(val.getFull_name());
			userResponseDto.setDate_of_birth(val.getDate_of_birth());
			userResponseDto.setUser_name(val.getUser_name());
			
			logger.info("exit : validate method");
			return userResponseDto;
			
			
		}
		else {
			logger.info("exit : validate method");
			return null;
		}
	}
	public String readFilee(Long user_id,String password) throws IOException, ParseException, SQLException {
		logger.info("entered to readfile method to read from properties file");
		JSONParser jsonparse=new JSONParser();
		JSONObject jsonobject=(JSONObject) jsonparse.parse(new FileReader("C:\\Users\\ganya_thimmappa\\eclipse-workspace\\first\\json\\prop.json"));
		String addcase= (String) jsonobject.get("addUserAllowed");
		String user_name= (String) jsonobject.get("default user_name");
		String full_name= (String) jsonobject.get("default full_name");
		String date_of_birth= (String) jsonobject.get("default date_of_birth");

		usersix.setUser_id(user_id);
		usersix.setUser_name(user_name);
		usersix.setFull_name(full_name);
		usersix.setPassword(password);
		usersix.setDate_of_birth(date_of_birth);

		if(addcase.equals("true")) {
			User valone=userRepo.findById(user_id);
			
			if(valone==null) {
				Boolean bool=	userRepo.create(usersix );	
				logger.info("user registered successfully");
				logger.info("exit : readFilee method");
				return "user registered successfully";
			}
			else {
				logger.info("User already exists , enter valid password");
				logger.info("exit : readFilee method");
				return "User already exists , enter valid password";
			}
		}

		else {
			logger.info("false given in properties login unsuccessful");
			logger.info("exit : readFilee method");
			return "login unsuccessful";
		}
	}
}