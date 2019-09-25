package com.devaj.graphql.controller;

import com.devaj.graphql.model.Employee;
import com.devaj.graphql.repository.EmployeeRepository;
import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
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

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable("id") Long id) throws NotFoundException {
        Optional<Employee> result = employeeRepository.findById(id);
        return ResponseEntity.ok(result.orElseThrow(()-> new NotFoundException("Não há Employee com id "+id)));
    }
}
