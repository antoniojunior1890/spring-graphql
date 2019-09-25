package com.devaj.graphql.controller;

import com.devaj.graphql.model.Employee;
import com.devaj.graphql.model.Project;
import com.devaj.graphql.repository.EmployeeRepository;
import com.devaj.graphql.repository.ProjectRepository;
import com.devaj.graphql.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private EmployeeService employeeService;

//    @GetMapping
//    public ResponseEntity<List<Employee>> listAll(){
//        return ResponseEntity.ok(employeeService.listAll());
//    }

    @GetMapping
    public Page<Employee> list(@PageableDefault(page = 0, size = 2)
                           @SortDefault.SortDefaults({
                                   @SortDefault(sort = "id", direction = Sort.Direction.ASC)
                           }) Pageable pageable) {

        return employeeService.listAll(pageable);
    }

    @PostMapping
    public ResponseEntity<Employee> save(@RequestBody Employee employee) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.save(employee));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable("id") Long id){

        Employee employee = employeeService.getById(id);

        return ResponseEntity.ok(employee);
    }

    @GetMapping("/{id}/projects")
    public ResponseEntity<List<Project>> getProjectByEmployeeId(@PathVariable Long id) {
//        List<Project> projects = projectRepository.findByEmployeeId(id);
        return ResponseEntity.ok(projectRepository.findByEmployeeId(id));
    }
}
