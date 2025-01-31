package com.example.empSystem.Controller;

import com.example.empSystem.Entity.Department;
import com.example.empSystem.Entity.Employee;
import com.example.empSystem.Entity.EmployeeDTO;
import com.example.empSystem.Repository.DepartmentRepo;
import com.example.empSystem.Repository.EmployeeRepo;
import com.example.empSystem.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeRepo repo;
//    @Autowired
//    private DepartmentRepo repo;
    private final EmployeeService service;


    public EmployeeController(EmployeeService service){
        this.service=service;
    }
    @GetMapping("/")
    public String greet(){
        return "hello";
    }
    @PostMapping("/addemployee")
    public Employee createEmployee(@RequestBody EmployeeDTO employeeDTO) {

        // Assign the department

//        System.out.println("Received Employee: " + employee);
        return service.createEmployee(employeeDTO);
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
    public void updateEmployee(@PathVariable long id,@RequestBody EmployeeDTO employeeDetails){
        Employee employeeDTO=service.getEmployeeById(id);
        employeeDTO.setName(employeeDetails.getName());
        employeeDTO.setEmail(employeeDetails.getEmail());
        employeeDTO.setPosition(employeeDetails.getPosition());
        employeeDTO.setSalary(employeeDetails.getSalary());
//        employeeDTO.setINNartmentId());
//         service.createEmployee(employeeDTO);
        repo.save(employeeDTO);
    }

}
