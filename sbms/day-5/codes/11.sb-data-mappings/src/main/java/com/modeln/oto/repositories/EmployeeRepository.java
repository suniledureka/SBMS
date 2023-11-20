package com.modeln.oto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.modeln.oto.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
