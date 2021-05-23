package com.myproduct.ups.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>, JpaSpecificationExecutor<Employee>
{
    @Query("select emp from Employee emp where employee_id = ?1")
    public Employee findEmployeeByEmployeeId(String employeeId);

}
