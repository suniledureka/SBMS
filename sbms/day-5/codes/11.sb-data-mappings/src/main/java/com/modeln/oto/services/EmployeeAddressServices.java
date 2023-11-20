package com.modeln.oto.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.modeln.oto.entities.Employee;
import com.modeln.oto.repositories.EmployeeRepository;

@Service
public class EmployeeAddressServices {
	//@Autowired
	private EmployeeRepository employeeRepo;
	
	public EmployeeAddressServices(EmployeeRepository employeeRepo) {
		super();
		this.employeeRepo = employeeRepo;
	}

	public void saveEmployeeAddress(Employee emp) {
		employeeRepo.save(emp);
		
	}
	
	public Employee searchEmployeeById(long id) {
		Employee emp = null;
		
		Optional<Employee> optEmp = employeeRepo.findById(id);
		if(optEmp.isPresent())
			emp = optEmp.get();
		return emp;
	}
}
