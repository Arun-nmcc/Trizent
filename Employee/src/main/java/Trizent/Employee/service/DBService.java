package Trizent.Employee.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Trizent.Employee.connnection.Connections;
import Trizent.Employee.pojo.Address;
import Trizent.Employee.pojo.Employee;

@Service
public class DBService {
	@Autowired
	Connections conn;
	Connection connection;
	Statement createStatement;
	PreparedStatement pstmt;
	ResultSet rs;

	public List<Employee> getAllEmployee(List<Employee> employees) {
		String sql = "SELECT * from employee";

		try {
			connection = conn.getConnection();

			createStatement = connection.createStatement();
			rs = createStatement.executeQuery(sql);
			while (rs.next()) {
				System.out.println("select all loop employee");

				Employee employee = new Employee();
				employee.setId(rs.getInt(1));
				int id = rs.getInt(1);
				employee.setName(rs.getString(2));
				employee.setEmail(rs.getString(3));
				createStatement = connection.createStatement();

				ResultSet rs = createStatement.executeQuery("select * from address where employeeId='" + id + "'");
				List<Address> addresses = new ArrayList<Address>();
				while (rs.next()) {
					System.out.println("select all loop address");
					Address address = new Address();
					address.setId(rs.getInt(1));

					address.setEmployeeId(rs.getInt(2));

					address.setAddressType(rs.getString(3));

					address.setLine1(rs.getString(4));

					address.setLine2(rs.getString(5));

					address.setState(rs.getString(7));

					address.setCity(rs.getString(6));

					address.setCountry(rs.getString(8));

					address.setZipcode(rs.getString(9));

					addresses.add(address);

				}
				employee.setAddress(addresses);
				employees.add(employee);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return employees;
	}

	public boolean updateAddress(List<Address> addresses, String id1, String id2,String empid) {
		// TODO Auto-generated method stub
		//System.out.println(id1+empid+id2);
		String sql = "UPDATE Address SET  line1=?, line2=?, city=?, state=?, country=?, zipcode=? WHERE employeeId ='"+empid+"'AND id ='"+id1+"'";

		try {
			for (Address add : addresses) {

				connection = conn.getConnection();
				 pstmt = connection.prepareStatement(sql);
				 pstmt.setString(1, add.getLine1());
					pstmt.setString(2, add.getLine2());
					pstmt.setString(3, add.getCity());
					pstmt.setString(4, add.getState());
					pstmt.setString(5, add.getCountry());
					pstmt.setString(6, add.getZipcode());
					
					
				 
				int i = pstmt.executeUpdate();
				sql = "UPDATE Address SET  line1=?, line2=?, city=?, state=?, country=?, zipcode=? WHERE employeeId ='"+empid+"'AND id ='"+id2+"'";
			//	System.out.println(i);
				if(i>0)
					return true;
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return false;

	}

	public boolean createEmployee(Employee employee) {

		String empsql = "insert into employee(name,email) values('" + employee.getName() + "','" + employee.getEmail()
				+ "')";
		try {
			connection = conn.getConnection();
			createStatement = connection.createStatement();
			int id = 0;
			int i = createStatement.executeUpdate(empsql);
			createStatement = connection.createStatement();

			ResultSet rs = createStatement
					.executeQuery("select id from employee where email ='" + employee.getEmail() + "'");
			if (rs.next())
				id = rs.getInt(1);
			System.out.println("fitst " + i);
			if (i > 0) {
				int a = 0;

				for (Address add : employee.getAddress()) {
					System.out.println("indsie loob");

					String insertQuery = "INSERT INTO Address ( employeeId, addressType, line1, line2, city, state, country, zipcode) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?)";
					pstmt = connection.prepareStatement(insertQuery);
					// pstmt.setInt(1, address.getId());
					pstmt.setInt(1, id);
					System.out.println("id" + add.getAddressType());
					pstmt.setString(2, add.getAddressType());

					pstmt.setString(3, add.getLine1());
					pstmt.setString(4, add.getLine2());
					pstmt.setString(5, add.getCity());
					pstmt.setString(6, add.getState());
					pstmt.setString(7, add.getCountry());
					pstmt.setString(8, add.getZipcode());
					a = pstmt.executeUpdate();

				}
				if (a > 0)
					return true;

			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("exception");
			return false;
		}

		return false;
	}

	public List<Address> updateEmployee(String id) {
		String str = "select * from Address where employeeId= '" + id + "' ";
		List<Address> addresses = new ArrayList<Address>();
		try {
			connection = conn.getConnection();
			createStatement = connection.createStatement();
			rs = createStatement.executeQuery(str);
			while (rs.next()) {
				Address address = new Address();
				address.setId(rs.getInt(1));

				address.setEmployeeId(rs.getInt(2));

				address.setAddressType(rs.getString(3));

				address.setLine1(rs.getString(4));

				address.setLine2(rs.getString(5));

				address.setState(rs.getString(7));

				address.setCity(rs.getString(6));

				address.setCountry(rs.getString(8));
				// System.out.println(rs.getString(8));

				address.setZipcode(rs.getString(9));
				addresses.add(address);

			}

		} catch (Exception e) {
			e.printStackTrace();

			System.out.println("");
		}

		// TODO Auto-generated method stub
		return addresses;

	}

	public boolean deleteEmployee(String id) {
		// TODO Auto-generated method stub
		String sql1 ="delete from address where employeeId = '"+id+"'";
		String sql2 = "delete from employee where id = '"+id+"'";
		try {
			connection = conn.getConnection();
			createStatement = connection.createStatement();
			int executeUpdate = createStatement.executeUpdate(sql1);
			int executeUpdate2 = createStatement.executeUpdate(sql2);
			System.out.println(executeUpdate+"  "+executeUpdate2);
			if(executeUpdate>0&&executeUpdate2>0)
				return true;
			
			
			
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
		
		
	}

}
