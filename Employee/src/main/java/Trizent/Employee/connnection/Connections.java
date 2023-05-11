package Trizent.Employee.connnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class Connections {
	private Connection con = null;
	// we can also use properties file to load the properties..
	// @Value("jdbc:mysql://localhost:3306/trizent")
	@Value("${url}")
	private String url;
//	@Value("07042002")	
	@Value("${password}")

	private String password;
	// @Value("root")
	@Value("${usernam}")
	private String username;

	Connections() {
	}

public	Connection getConnection()  {
		if (con != null)

			return con;
		else {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println(url+password+username);
			try {
				con = DriverManager.getConnection(url, username, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return con;
		}

	}

}