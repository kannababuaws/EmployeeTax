package com.imaginnvoate.Employee.Details.Repository;

import com.imaginnvoate.Employee.Details.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
