package com.example.hibernatedemo.controller;

import com.example.hibernatedemo.pojo.DTO.EmployeeDTO;
import com.example.hibernatedemo.pojo.entity.Employee;
import com.example.hibernatedemo.service.EmployeeService;
import com.mysql.cj.x.protobuf.Mysqlx;
import lombok.Generated;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(@Qualifier("employeeServiceImpl") EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        List<Employee> employees = employeeService.findAllEmployees();
        List<EmployeeDTO> list = employees.stream().map((e) -> {
            EmployeeDTO employeeDTO = new EmployeeDTO();
            employeeDTO.setEmail(e.getEmail());
            employeeDTO.setEmployee_id(e.getEmployee_id());
            employeeDTO.setDepartmentList(e.getDepartmentList());
            return employeeDTO;
        }).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable int id) {
        Employee employee = employeeService.findById(id);
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setEmployee_id(employee.getEmployee_id());
        employeeDTO.setEmail(employee.getEmail());
        employeeDTO.setDepartmentList(employee.getDepartmentList());
        return new ResponseEntity<>(employeeDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> updateEmployee(@RequestBody Employee employee) {
        employeeService.updateEmployee(employee);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping("/departments")
    public ResponseEntity<List<Employee>> getEmployeesByDepartmentId(@RequestParam int department_id) {
        List<Employee> employees = employeeService.findEmployeeWithDepartmentId(department_id);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

}
