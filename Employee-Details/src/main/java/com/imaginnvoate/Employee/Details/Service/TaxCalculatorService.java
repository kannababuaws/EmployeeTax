package com.imaginnvoate.Employee.Details.Service;

import com.imaginnvoate.Employee.Details.Entity.Employee;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class TaxCalculatorService {
    private final List<TaxCalculator>taxCalculatorList;

    public int calculateTax(int salary) {
        return taxCalculatorList.stream()
                .filter(taxCalculator -> taxCalculator.accept(salary))
                .map(taxCalculator -> taxCalculator.calculateTax(salary))
                .reduce(0,Integer::sum);

    }
    public int calculateCessAmount(int salary) {
      return salary>2500000 ? (int) ((salary-2500000)*0.02 ):0;
    }
}
