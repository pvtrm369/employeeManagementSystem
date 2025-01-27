package com.example.empSystem.Controller;

import com.example.empSystem.Entity.Employee;
import com.example.empSystem.Service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")

@RestController
public class EmployeeController {
    private final EmployeeService service;


    public EmployeeController(EmployeeService service){
        this.service=service;
    }
    @GetMapping("/")
    public String greet(){
        return "hello";
    }
    @PostMapping("/employees")
    public void createEmployee(@RequestBody Employee employee) {
        System.out.println("Received Employee: " + employee);
       service.createEmployee(employee);
    }
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable long id){
        service.deleteEmployee(id);
    }
    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return service.getEmployees();

    }
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return service.getEmployeeById(id);
    }

    @PostMapping("/{id}")
    public void updateEmployee(@PathVariable long id,@RequestBody Employee employeeDetails){
        Employee employee=service.getEmployeeById(id);
        employee.setName(employeeDetails.getName());
        employee.setEmail(employeeDetails.getEmail());
        employee.setPosition(employeeDetails.getPosition());
        employee.setSalary(employeeDetails.getSalary());
         service.createEmployee(employee);
    }

}
