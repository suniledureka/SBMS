package com.modeln.oto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.modeln.oto.entities.Address;
import com.modeln.oto.entities.Employee;
import com.modeln.oto.services.EmployeeAddressServices;
import com.modeln.oto.services.PersonServices;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);
		Employee emp = new Employee();
		emp.setEmployeeName("Sanjay Patil");

		Address addr = new Address();
		addr.setStreet("Mothinagar");
		addr.setCity("Hyderabad");
		addr.setState("Telangana");

		emp.setEmployeeAddress(addr);

		//EmployeeAddressServices service = context.getBean(EmployeeAddressServices.class);
		//service.saveEmployeeAddress(emp);
		
		//emp = service.searchEmployeeById(1L);
		//System.out.println(emp);
		
		PersonServices pService = context.getBean(PersonServices.class);
		pService.saveData();
	}

}
