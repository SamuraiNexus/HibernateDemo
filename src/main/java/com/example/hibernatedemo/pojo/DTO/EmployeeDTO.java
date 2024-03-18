package com.example.hibernatedemo.pojo.DTO;

import com.example.hibernatedemo.pojo.entity.Department;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class EmployeeDTO {
    private int employee_id;
    private String email;
    private List<Department> departmentList = new ArrayList<>();
}
