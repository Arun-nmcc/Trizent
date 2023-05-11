package Trizent.Employee.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import Trizent.Employee.pojo.Address;
import Trizent.Employee.pojo.Employee;
import Trizent.Employee.service.DBService;

@Controller
public class HomeController {
	@Autowired
	DBService service;

	@RequestMapping(value = "/")
	public String test() {
		return "Header";

	}	@RequestMapping(value = "createEmployee2")
	public String test2() {
		return "createEmployee2";

	}

	@RequestMapping(value = "update")
	public String update(@RequestParam("id") String id, Model model) {
		List<Address> updateEmployee = service.updateEmployee(id);
		// System.out.println(updateEmployee);
		model.addAttribute("address", updateEmployee);
		return "updateEmployee";

	}

//@ResponseBody
	@RequestMapping(value = "delete")
	public String delete(@RequestParam("id") String id) {
		if (service.deleteEmployee(id)) {
			return "redirect:/list";
		}
		return "error";

	}

	@RequestMapping(value = "list")
	public String listEmp(Model model) {
		List<Employee> employees = new ArrayList<Employee>();

		List<Employee> allEmployee = service.getAllEmployee(employees);
		model.addAttribute("employees", allEmployee);
		return "listEmployee";

	}

	@RequestMapping("updateEmployee")

	public String update2(@RequestParam("permanentAddressLine1") String permanentAddressLine1,
			@RequestParam("permanentAddressLine2") String permanentAddressLine2,
			@RequestParam("permanentCity") String permanentCity, @RequestParam("permanentState") String permanentState,
			@RequestParam("permanentCountry") String permanentCountry,
			@RequestParam("permanentZipcode") String permanentZipcode,

			@RequestParam("correspondenceAddressLine1") String correspondenceAddressLine1,
			@RequestParam("correspondenceAddressLine2") String correspondenceAddressLine2,
			@RequestParam("correspondenceCity") String correspondenceCity,
			@RequestParam("correspondenceState") String correspondenceState,
			@RequestParam("correspondenceCountry") String correspondenceCountry,
			@RequestParam("correspondenceZipcode") String correspondenceZipcode, @RequestParam("id1") String id1,
			@RequestParam("id2") String id2, @RequestParam("empid") String empid) {
		List<Address> addresses = new ArrayList<>();
		Address permanentAddress = new Address();
		permanentAddress.setLine1(permanentAddressLine1);
		permanentAddress.setLine2(permanentAddressLine2);
		permanentAddress.setCity(permanentCity);
		permanentAddress.setState(permanentState);
		permanentAddress.setCountry(permanentCountry);
		permanentAddress.setZipcode(permanentZipcode);

		Address correspondenceAddress = new Address();
		correspondenceAddress.setLine1(correspondenceAddressLine1);
		correspondenceAddress.setLine2(correspondenceAddressLine2);
		correspondenceAddress.setCity(correspondenceCity);
		correspondenceAddress.setState(correspondenceState);
		correspondenceAddress.setCountry(correspondenceCountry);
		correspondenceAddress.setZipcode(correspondenceZipcode);
		addresses.add(permanentAddress);
		addresses.add(correspondenceAddress);
		boolean updateAddress = service.updateAddress(addresses, id1, id2, empid);

		System.out.println(updateAddress);
		return "Header";

	}

	@RequestMapping(value = "create")
	public String create(@RequestParam("permanentAddressType") String permanentAddressType,
			@RequestParam("permanentAddressLine1") String permanentAddressLine1,
			@RequestParam("permanentAddressLine2") String permanentAddressLine2,
			@RequestParam("permanentCity") String permanentCity, @RequestParam("permanentState") String permanentState,
			@RequestParam("permanentCountry") String permanentCountry,
			@RequestParam("permanentZipcode") String permanentZipcode,
			@RequestParam("correspondenceAddressType") String correspondenceAddressType,
			@RequestParam("correspondenceAddressLine1") String correspondenceAddressLine1,
			@RequestParam("correspondenceAddressLine2") String correspondenceAddressLine2,
			@RequestParam("correspondenceCity") String correspondenceCity,
			@RequestParam("correspondenceState") String correspondenceState,
			@RequestParam("correspondenceCountry") String correspondenceCountry,
			@RequestParam("correspondenceZipcode") String correspondenceZipcode, @RequestParam String name,
			@RequestParam String email) {
		Employee employee = new Employee();
		employee.setEmail(email);
		employee.setName(name);
		List<Address> addresses = new ArrayList<>();
		Address permanentAddress = new Address();
		permanentAddress.setAddressType(permanentAddressType);
		permanentAddress.setLine1(permanentAddressLine1);
		permanentAddress.setLine2(permanentAddressLine2);
		permanentAddress.setCity(permanentCity);
		permanentAddress.setState(permanentState);
		permanentAddress.setCountry(permanentCountry);
		permanentAddress.setZipcode(permanentZipcode);

		Address correspondenceAddress = new Address();
		correspondenceAddress.setAddressType(correspondenceAddressType);
		correspondenceAddress.setLine1(correspondenceAddressLine1);
		correspondenceAddress.setLine2(correspondenceAddressLine2);
		correspondenceAddress.setCity(correspondenceCity);
		correspondenceAddress.setState(correspondenceState);
		correspondenceAddress.setCountry(correspondenceCountry);
		correspondenceAddress.setZipcode(correspondenceZipcode);
		addresses.add(permanentAddress);
		addresses.add(correspondenceAddress);
		// permanantAddress.getCity();
		employee.setAddress(addresses);
		if (service.createEmployee(employee))

			return "Header";
		else
			return "error";
	}
}
