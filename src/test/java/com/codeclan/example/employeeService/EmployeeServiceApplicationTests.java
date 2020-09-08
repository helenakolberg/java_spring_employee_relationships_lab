package com.codeclan.example.employeeService;

import com.codeclan.example.employeeService.models.Department;
import com.codeclan.example.employeeService.models.Employee;
import com.codeclan.example.employeeService.models.Project;
import com.codeclan.example.employeeService.repositories.DepartmentRepository;
import com.codeclan.example.employeeService.repositories.EmployeeRepository;
import com.codeclan.example.employeeService.repositories.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class EmployeeServiceApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	ProjectRepository projectRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void createEmployeeAndDepartment() {
		Department department = new Department("Technology");
		departmentRepository.save(department);

		Employee employee = new Employee("Sky", "Su", "E41I", department);
		employeeRepository.save(employee);
	}

	@Test
	public void addEmployeesAndProject() {
		Department department = new Department("Technology");
		departmentRepository.save(department);

		Employee employee = new Employee("Sky", "Su", "E41I", department);
		employeeRepository.save(employee);

		Project project = new Project("New app", 14);
		projectRepository.save(project);

		project.addEmployee(employee);
		projectRepository.save(project);

		department.addEmployee(employee);
		departmentRepository.save(department);
	}

}
