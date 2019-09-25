package com.devaj.graphql.controller;

import com.devaj.graphql.model.Employee;
import com.devaj.graphql.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public ResponseEntity<List<Employee>> getMessage(){

        List<Employee> employees=  employeeRepository.findAll();
        return ResponseEntity.ok(employees);
    }

    @PostMapping
    public Employee save(@RequestBody Employee employee) {

        return employeeRepository.save(employee);
    }
}
