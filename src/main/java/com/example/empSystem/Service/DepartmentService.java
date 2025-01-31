package com.example.empSystem.Service;

import com.example.empSystem.Entity.Department;
import com.example.empSystem.Repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepo repo;

    public Department addDepartment(Department department) {
         return repo.save(department);
    }
}
