package com.devaj.graphql.service;

import com.devaj.graphql.exception.NotFoundException;
import com.devaj.graphql.model.Employee;
import com.devaj.graphql.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> listAll(){
        return employeeRepository.findAll();
    }

    public Employee getById(Long id){
        Optional<Employee> result = employeeRepository.findById(id);
        return result.orElseThrow(()-> new NotFoundException("Não há Employee com id "+id));
    }

    public Employee save(Employee user){
        return employeeRepository.save(user);
    }

    public Page<Employee> listAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }



}
