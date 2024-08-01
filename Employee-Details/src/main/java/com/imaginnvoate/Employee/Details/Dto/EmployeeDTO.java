package com.imaginnvoate.Employee.Details.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDTO {
    @NotBlank(message = "The First name should not be empty.")
    private String FirstName;
    @NotBlank(message = "The Last name should not be empty.")
    private String LastName;
    @Email(message = "Invalid email address.")
    @NotBlank(message = "email id should not empty.")
    private String Email;
    @NotNull(message = "phone number required.")
    private List<String> PhoneNumbers;
    @JsonFormat(pattern = "dd-MM-YYYY")
    @NotNull(message = "DOJ Should not be empty.")
    private LocalDate DOJ;
    @NotNull(message = "salary should not be null")
    private int Salary;
}
