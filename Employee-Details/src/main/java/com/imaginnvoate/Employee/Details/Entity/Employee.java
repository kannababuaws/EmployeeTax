package com.imaginnvoate.Employee.Details.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table(name= "employee")
public class Employee {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long EmployeeId;
    private String FirstName;
    private String LastName;
    private String Email;
    private List<String> PhoneNumbers;
    private LocalDate DOJ;
    private int Salary;
}


