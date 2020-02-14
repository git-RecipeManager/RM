package com.manager.recipe.model;
/*
import java.sql.Connection;
import java.sql.DriverManager;
public class DBManager {  
  
public static Connection getConnection(){  
    Connection con=null;  
    try{  
        Class.forName("com.mysql.cj.jdbc.Driver");  
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/extraordinary-italy?serverTimezone=EST5EDT","root","gaeamo77WD");  
    }catch(Exception e){System.out.println(e);}  
    return con;  
}  

}  
*/	

/**
 * @author Mattia De Rosa
 *
 */
import java.sql.Connection;
import java.sql.SQLException;
import java.util.TimeZone;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

public class DBManager {
	private static DataSource datasource;

	public static Connection getConnection() throws SQLException {
		if (datasource == null) {
			PoolProperties p = new PoolProperties();
			p.setUrl("jdbc:mysql://localhost:3306/extraordinary-italy?serverTimezone=" + TimeZone.getDefault().getID());
			p.setDriverClassName("com.mysql.cj.jdbc.Driver");
			p.setUsername("root");
			p.setPassword("gaeamo77WD");
			p.setMaxActive(100);
			p.setInitialSize(10);
			p.setMinIdle(10);
			p.setRemoveAbandonedTimeout(60);
			p.setRemoveAbandoned(true);
			datasource = new DataSource();
			datasource.setPoolProperties(p);
			
		}
		return datasource.getConnection();
	}
}
