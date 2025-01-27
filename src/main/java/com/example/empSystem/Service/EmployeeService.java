package com.example.empSystem.Service;

import com.example.empSystem.Entity.Employee;
import com.example.empSystem.Repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class EmployeeService {
    @Autowired
   EmployeeRepo repo;
    public void createEmployee(Employee employee) {
         repo.save(employee);

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
