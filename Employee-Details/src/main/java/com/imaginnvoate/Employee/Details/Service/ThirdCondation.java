package com.imaginnvoate.Employee.Details.Service;

import org.springframework.stereotype.Component;

@Component
public class ThirdCondation implements TaxCalculator{
    @Override
    public boolean accept(int salary) {
        return salary>=1000000;
    }

    @Override
    public int calculateTax(int salary) {
        return (int) ((salary -1000000)* 0.2);
    }
}
