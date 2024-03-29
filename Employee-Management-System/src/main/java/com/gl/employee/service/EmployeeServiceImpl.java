package com.gl.employee.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.employee.model.Employee;
import com.gl.employee.repository.EmployeeJpaRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeJpaRepository employeeJpaRepository;

	@Override
	public Employee saveEmployee(Employee employee) {
		return this.employeeJpaRepository.save(employee);
	}

	@Override
	public Set<Employee> fetchAll() {
		return Set.copyOf(this.employeeJpaRepository.findAll());
	}

	@Override
	public Employee findEmployeeById(long id) {
		return this.employeeJpaRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Employee Id"));
	}

	@Override
	public Employee updateEmployeeById(long employeeId, Employee employee) {
		Employee employeeFromRepository = this.findEmployeeById(employeeId);
		employeeFromRepository.setFirstName(employee.getFirstName());
		employeeFromRepository.setLastName(employee.getLastName());
		employeeFromRepository.setEmail(employee.getEmail());
		return this.employeeJpaRepository.save(employeeFromRepository);
	}

	@Override
	public void deleteEmployeeById(long EmployeeId) {
		this.employeeJpaRepository.deleteById(EmployeeId);
	}

	@Override
	public Set<Employee> searchEmployees(String keyword) {
		return employeeJpaRepository.searchEmployees(keyword);
	}

	@Override
	public List<Employee> getAllEmployeesSortedByFirstName() {
		return employeeJpaRepository.findByOrderByFirstNameAsc();
	}
	
	@Override
    public List<Employee> getAllEmployeesSortedByFirstNameDesc() {
        return employeeJpaRepository.findAllByOrderByFirstNameDesc();
    }

}
