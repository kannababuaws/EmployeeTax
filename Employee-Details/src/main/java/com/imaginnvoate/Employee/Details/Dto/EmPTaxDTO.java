package com.imaginnvoate.Employee.Details.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@Builder
public class EmPTaxDTO {
    private Long employeeId;
    private String FirstName;
    private String LastName;
    private String Email;
    private List<String> PhoneNumbers;
    private LocalDate DOJ;
    private int Salary;
    private int TaxAmount;
    private int CessAmount;
}
