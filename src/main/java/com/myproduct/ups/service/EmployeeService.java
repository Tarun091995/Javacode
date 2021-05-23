package com.myproduct.ups.service;

import com.myproduct.ups.model.Employee;
import com.myproduct.ups.model.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired //used to create obj automatically by spring
    private EmployeeRepository employeeRepository;

    public Employee createEmployee(Employee employee)
    {
        Employee employeeFromDB = employeeRepository.save(employee);
        return employeeFromDB;
    }

//public Employee createEmployee(String employeeId,String employeeName, String employeeAddress, String phoneNumber , Timestamp dateofJoining , String designation)
//    {
//        Employee employee = new Employee();
//        employee.setEmployeeName(employeeName);
//        employee.setEmployeeId(employeeId);
//        employee.setEmployeeAddress(employeeAddress);
//        employee.setPhoneNumber(phoneNumber);
//        employee.setDateOfJoining(dateofJoining);
//        employee.setDesignation(designation);
//
//        Employee employeeFromDB = employeeRepository.save(employee);
//        return employeeFromDB;
//
//    }

    public Employee updateEmployee(String employeeId,String employeeName,String employeeAddress, String phoneNumber,Timestamp dateofJoining,String designation)
    {
        Employee existingEmployee = employeeRepository.findEmployeeByEmployeeId(employeeId);
        existingEmployee.setEmployeeName(employeeName);
        existingEmployee.setEmployeeAddress(employeeAddress);
        existingEmployee.setPhoneNumber(phoneNumber);
        existingEmployee.setDateOfJoining(dateofJoining);
        existingEmployee.setDesignation(designation);

        Employee updatedEmployee = employeeRepository.save(existingEmployee);
        return updatedEmployee;
    }

    public void deleteEmployee(String employeeId)
    {
        Employee existingEmployee = employeeRepository.findEmployeeByEmployeeId(employeeId);
        employeeRepository.delete(existingEmployee);
    }


    public List<Employee> listAllEmployees()
    {
        return employeeRepository.findAll();
    }

}
