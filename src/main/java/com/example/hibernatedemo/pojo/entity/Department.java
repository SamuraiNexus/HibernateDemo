package com.example.hibernatedemo.pojo.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int department_id;
    @Column(name = "department_name")
    private String name;

    @ManyToMany(mappedBy = "departmentList")
    @JsonBackReference
    private Set<Employee> employeeList = new HashSet<>();

}
