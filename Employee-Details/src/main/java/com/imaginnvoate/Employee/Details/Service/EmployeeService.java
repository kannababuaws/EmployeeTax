package com.imaginnvoate.Employee.Details.Service;

import com.imaginnvoate.Employee.Details.Dto.EmPTaxDTO;
import com.imaginnvoate.Employee.Details.Dto.EmployeeDTO;
import com.imaginnvoate.Employee.Details.Entity.Employee;
import com.imaginnvoate.Employee.Details.Repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.*;

@Service
@AllArgsConstructor
@Transactional
public class EmployeeService {
@Autowired
    private EmployeeRepository employeeRepository;

private final TaxCalculatorService taxCalculatorService;

    private Employee addEmployee(EmployeeDTO employeeDTO) {
        Employee employee=Employee.builder()
                .FirstName(employeeDTO.getFirstName())
                .LastName(employeeDTO.getLastName())
                .Email(employeeDTO.getEmail())
                .PhoneNumbers(employeeDTO.getPhoneNumbers())
                .Salary(employeeDTO.getSalary()).DOJ(employeeDTO.getDOJ())
                .build();
     return employeeRepository.save(employee);
    }
public List<EmPTaxDTO>getEmployeeDetails() {
        List<Employee> employees=employeeRepository.findAll();
//        List<EmPTaxDTO> emPTaxDTOs=new ArrayList<>();
    return employees.stream()
            .map(this::EmpTaxDto)
            .toList();
}
private EmPTaxDTO EmpTaxDto(Employee employee) {
        int salary=calculateSalary(employee.getSalary(),employee.getDOJ());
        return EmPTaxDTO.builder()
                .employeeId(employee.getEmployeeId())
                .FirstName(employee.getFirstName())
                .LastName(employee.getLastName())
                .Email(employee.getEmail())
                .PhoneNumbers(employee.getPhoneNumbers())
                .Salary(employee.getSalary())
                .DOJ(employee.getDOJ()).TaxAmount(taxCalculatorService.calculateTax(salary))
                .CessAmount(taxCalculatorService.calculateCessAmount(salary))
                .build();
}

private int calculateSalary(int salary, LocalDate DOJ) {

        LocalDate currentYear=fetchcurrentYear();
        if (currentYear.isBefore(DOJ)){
            Period period=Period.between(currentYear,DOJ);
            int months=period.getMonths();
            int days=period.getDays();
            int monthlySalary=salary/12;
            return salary-((months*monthlySalary)+(monthlySalary/30)* days);
        }
        return salary;
}
//private static final List<Integer>currentyearList=List.of(1,2,3);
private LocalDate fetchcurrentYear() {
    LocalDate currentDate = LocalDate.now();
//        if(currentDate.contains(currentDate.getMonthValue())){
//            return currentDate.of()
}
}


