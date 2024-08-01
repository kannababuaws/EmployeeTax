package com.imaginnvoate.Employee.Details.Service;

public interface TaxCalculator {
    boolean accept(int salary);
    int calculateTax(int salary);
}
