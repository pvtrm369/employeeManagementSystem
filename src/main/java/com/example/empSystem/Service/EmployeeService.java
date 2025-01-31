package com.example.empSystem.Service;

import com.example.empSystem.Entity.Department;
import com.example.empSystem.Entity.Employee;
import com.example.empSystem.Entity.EmployeeDTO;
import com.example.empSystem.Repository.DepartmentRepo;
import com.example.empSystem.Repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class EmployeeService {
    @Autowired
   EmployeeRepo repo;
    @Autowired
    DepartmentRepo departmentRepo;
    public Employee createEmployee(EmployeeDTO employeeDTO) {
        Department department = departmentRepo.findById(employeeDTO.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Department not found"));

        Employee employee = new Employee(
                employeeDTO.getName(),
                employeeDTO.getEmail(),
                employeeDTO.getPosition(),
                employeeDTO.getSalary(),
                department
        );
         return  repo.save(employee);

    }

    public void deleteEmployee(long id) {
        repo.deleteById(id);
    }

    public List<Employee> getEmployees() {
        return repo.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return repo.findById(id).orElse(null);
    }
}
