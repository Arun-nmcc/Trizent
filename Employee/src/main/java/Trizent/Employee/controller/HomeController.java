package Trizent.Employee.controller;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
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

	@RequestMapping(value = "update")
	public String update(@RequestParam("id") String id, Model model) {
		List<Address> updateEmployee = service.updateEmployee(id);
		// System.out.println(updateEmployee);
		Employee emp = new Employee();
		emp.setAddress(updateEmployee);
		model.addAttribute("employee", emp);
		return "updateEmployee";

	}

	@RequestMapping("updateEmployee")
	public String update1(@ModelAttribute("employee") Employee employee, @RequestParam("id1") String id1,
			@RequestParam("id2") String id2, @RequestParam("empid") String empid) {
		// System.out.println(employee.getAddress());
		// String line1 = employee.getAddress().get(1).getLine1();
		// System.out.println(line1);
		boolean updateAddress = service.updateAddress(employee.getAddress(), id1, id2, empid);

		System.out.println(updateAddress);
		return "Header";

	}

	@RequestMapping(value = "create")
	public String create1(@Valid @ModelAttribute("employee")  Employee employee,BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			for (ObjectError objectError : allErrors) {
				//System.out.println(objectError.getDefaultMessage());
			//	System.out.println(objectErrobjectError.getArguments();
				//System.out.println(objectError.getObjectName());
				
				
				
			}model.addAttribute("errors", allErrors);
			return "createEmployee";
		}
		System.out.println(employee.getEmail());
		System.out.println(employee.getAddress());
		try {
			if (service.createEmployee(employee))

				return "Header";

		} catch (SQLIntegrityConstraintViolationException e) {
			// TODO Auto-generated catch block

			String errorMessage = "Email already exists. Please enter a unique email.";
			model.addAttribute("errorMessage", errorMessage);
			return "createEmployee";
		}
		return "error";

	}

	@RequestMapping(value = "createEmployee2")
	public String test2(@ModelAttribute("employee") Employee employee) {

		return "createEmployee";

	}

}
