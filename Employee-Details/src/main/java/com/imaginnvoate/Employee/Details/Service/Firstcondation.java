package com.imaginnvoate.Employee.Details.Service;

import org.springframework.stereotype.Component;

@Component
public class Firstcondation implements TaxCalculator {
    @Override
    public boolean accept(int salary) {
//        return false;
        return salary >= 250000;
    }

    @Override
    public int calculateTax(int salary) {
//
        if (salary >=5000000) {
            return salary;

        }
        return (int) ((salary -250000)* 0.05);
    }
}
