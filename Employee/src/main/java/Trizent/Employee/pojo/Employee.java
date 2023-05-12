package Trizent.Employee.pojo;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class Employee {
	private int id;
@NotBlank(message = "name must not be blank")
	private String name;
	@Email(regexp = "^[A-Za-z0-9._%+-]+@trizent\\.com$", message = "Please enter a valid email address ending with @trizent.com")

	private String email;
	private List<Address> address;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Address> getAddress() {
		return address;
	}
	public void setAddress(List<Address> address) {
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

}
