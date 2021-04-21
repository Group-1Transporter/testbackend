package com.example.testapi;

import java.sql.Connection;
import java.sql.DriverManager;

public class GetConnection {
  private static Connection con;
  public static Connection getConnection() {
	  try {
		 Class.forName("com.mysql.jdbc.Driver");
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb","root","root");
	  }
	  catch (Exception e) {
		e.printStackTrace();
	  }
	  return con;
  }
}
