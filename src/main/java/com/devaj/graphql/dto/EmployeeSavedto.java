package com.devaj.graphql.dto;

import com.devaj.graphql.model.Employee;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.time.LocalDate;

@Getter
@Setter
public class EmployeeSavedto {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false)
    private String birth;

    public Employee transformToEmployee(){
        Employee employee  = new Employee(null, this.name, this.age, LocalDate.parse(birth), null);

        return employee;
    }
}
