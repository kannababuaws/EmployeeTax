package com.imaginnvoate.Employee.Details.Service;

import org.springframework.stereotype.Component;

@Component
public class SecondCondation implements  TaxCalculator{
    @Override
    public boolean accept(int salary) {
        return salary>=500000;
    }

    @Override
    public int calculateTax(int salary) {

        if(salary>1000000){
            return 500000;

        }
        return (int) ((salary -500000)* 0.1);
    }
}
