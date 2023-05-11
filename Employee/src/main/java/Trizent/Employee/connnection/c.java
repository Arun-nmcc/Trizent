package Trizent.Employee.connnection;

import java.sql.Connection;
import java.sql.SQLException;

public class c {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	Connections con = new Connections();
		Connection connection = con.getConnection();
		System.out.println(connection);
	}

}
