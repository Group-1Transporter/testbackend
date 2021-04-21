package com.example.testapi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class UserDAO {
  public static ArrayList<User> getUserList(){
	  Connection con = null;
	  ArrayList<User> al = new ArrayList<>();
	  try {
		 con =  GetConnection.getConnection();
	     String sql = "select * from user";
	     PreparedStatement ps = con.prepareStatement(sql);
	     
	     ResultSet rs = ps.executeQuery();
	     while(rs.next()) {
	    	 int id = rs.getInt(1);
	    	 String name = rs.getString(2);
	    	 String mobile = rs.getString(3);
	    	 int age  = rs.getInt(4);
	    	 
	    	 User user = new User(id,name,mobile,age);
	    	 al.add(user);
	     }
	  }
	  catch (Exception e) {
		 e.printStackTrace();
	  }
	  finally {
		  try {
			  con.close();
		  }
		  catch (Exception e) {
			e.printStackTrace();
		  }
	  }
	  return al;
  }
  public static User save(User user) {
    Connection con = null;
    try {
    	int maxId = 0;
    	con = GetConnection.getConnection();
    	String sql = "select max(id) from user";
    	PreparedStatement ps = con.prepareStatement(sql);
    	ResultSet rs = ps.executeQuery();
    	if(rs.next())
    		maxId = rs.getInt(1);
    	
        sql = "insert into user(id,name,mobile,age) values(?,?,?,?)";
    
        PreparedStatement ps2 = con.prepareStatement(sql);
        ps2.setInt(1, maxId+1);
        ps2.setString(2, user.getName());
        ps2.setString(3,user.getMobile());
        ps2.setInt(4, user.getAge());
       
        int x = ps2.executeUpdate();
        if(x!=0)
        	user.setId(maxId+1);
    }
    catch(Exception e) {
    	
    }
    finally {
    	try {
    		con.close();
    	}
    	catch (Exception e) {
			// TODO: handle exception
		}
    }
    return user;
  }
}





























