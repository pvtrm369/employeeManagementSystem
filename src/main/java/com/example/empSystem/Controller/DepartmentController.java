package com.example.empSystem.Controller;

import com.example.empSystem.Entity.Department;
import com.example.empSystem.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/api")
@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService service;
    @PostMapping("/addDepartment")
    public Department addDepartment(@RequestBody Department department) {
        return service.addDepartment(department);
    }
}
