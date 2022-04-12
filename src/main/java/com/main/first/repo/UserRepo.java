package com.main.first.repo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.main.first.MyResource;
import com.main.first.User;
import com.sun.tools.sjavac.Log;


public class UserRepo {
	private static Logger logger= LogManager.getLogger(UserRepo.class);
	List<User> user=new ArrayList<User>();
	Connection con=null;
	public void Connection()
	{
		String url="jdbc:mysql://localhost:3306/trainingone";
		String username="root";
		String password="Shimoga@60";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con= DriverManager.getConnection(url, username, password);
			logger.info("connection open");
			
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	public User findById(Long user_id) {
		Connection();
		logger.info("Entered method findById");
		

		String sql="select * from user_details where user_id="+user_id;
		User userone=new User();
		try
		{
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);

			if(rs.next())
			{

				userone.setUser_id(rs.getLong("user_id"));
				userone.setFull_name(rs.getString("full_name"));
				userone.setUser_name(rs.getString("user_name"));
				userone.setPassword(rs.getString("password"));
				userone.setDate_of_birth(rs.getString("date_of_birth"));
				logger.info("find by id has sent details");
				logger.info("Exit method findById");
				con.close();
				logger.info("connection close");
				return userone;	
			}
			else {
				logger.info("find by id has sent null ");
				logger.info("Exit method findById");
				con.close();
				logger.info("connection close");
				return null;
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			logger.error("Not able to execute try block");
			logger.info("Exit method findById");
		}
		return null;
	}
	public Boolean create(User usersix) throws SQLException {
		Connection();
		logger.info("Entered to method create ");

		String sql="insert into user_details values (?,?,?,?,?)";
		User userthree=new User();
		userthree.setUser_id(usersix.getUser_id());
		userthree.setPassword(usersix.getPassword());
		userthree.setUser_name(usersix.getUser_name());
		userthree.setFull_name(usersix.getFull_name());
		userthree.setDate_of_birth(usersix.getDate_of_birth());
		logger.info("Entered to create method to add DB ");
		logger.info("user_id :" + userthree.getUser_id());
		logger.info("full_name :"+userthree.getFull_name());
		logger.info("user_name :"+userthree.getUser_name());
		logger.info("Password : *****");


		try
		{
			PreparedStatement st=con.prepareStatement(sql);
			st.setLong(1,userthree.getUser_id());
			st.setString(2,userthree.getFull_name());
			st.setString(3,userthree.getUser_name());
			st.setString(4,userthree.getPassword());
			st.setString(5,userthree.getDate_of_birth());
			st.executeUpdate();
			logger.info("try block executed and added succeessfully to DB");
			logger.info("Exit :method create ");
			con.close();
			logger.info("connection close");
			return true;

		}
		catch(Exception e){
			System.out.println(e.getMessage());
			logger.error("catch block executed and error not able to add user to  db");
			logger.info("Exit : method create ");
			con.close();
			logger.info("connection close");
			return false;
		}
	}

}
