package com.example.empSystem.Entity;

import jakarta.persistence.*;
//import lombok.Data;
//import lombok.NoArgsConstructor;

import java.io.Serializable;

//@NoArgsConstructor  // default constructor
//@Data  // generates getters, setters, toString, equals, and hashCode

@Entity  // indicates that this class is a JPA entity
public class Employee implements Serializable {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Id  // this marks the 'id' field as the primary key for the entity
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // this specifies auto-generation for the 'id'
    private Long id;

    private String name;
    private String email;
    private String position;
    private Double salary;

    // Constructor excluding the 'id' field since it's auto-generated
    public Employee(String name, String email, String position, Double salary) {
        this.name = name;
        this.email = email;
        this.position = position;
        this.salary = salary;
    }
    public Employee() {
    }
}
