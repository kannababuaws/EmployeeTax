package com.imaginnvoate.Employee.Details.Controller;

import com.imaginnvoate.Employee.Details.Dto.EmployeeDTO;
import com.imaginnvoate.Employee.Details.Entity.Employee;
import com.imaginnvoate.Employee.Details.Service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
   @PostMapping
    public ResponseEntity<Employee>addEmployee(@Valid @RequestBody EmployeeDTO employeeDTO){
        return new ResponseEntity<Employee>(employeeService.addEmployee(employeeDTO, HttpStatus.CREATED));

    }
    @GetMapping
    public ResponseEntity<List>getEmployeesTax(){
       return new ResponseEntity<>(employeeService.getEmployeeDetails(), HttpStatus.OK);
    }

}
