package com.writer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DatabaseConn {
	static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";  
	static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:dbName";

	
	static final String USER = "username";
	static final String PASS = "password";

	public List<String> Connect() throws SQLException{
		Connection conn = null;
		Statement stmt = null;
		List<String> envelopeList=new ArrayList<String>();
		try{
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			stmt = conn.createStatement();
			ResultSet set = stmt.executeQuery(
					"Select * from table_name"
						);
			
			
			while(set.next()){
				envelopeList.add(set.getString("columnName"));
		
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(stmt != null) stmt.close();
			if(conn!=null) conn.close();
		}
		return envelopeList;
	}
}