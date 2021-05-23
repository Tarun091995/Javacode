package com.myproduct.ups.controller;

import com.myproduct.ups.common.UPSDateUtils;
import com.myproduct.ups.model.Employee;
import com.myproduct.ups.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
@Api(value = "Employee Controller")

@RequestMapping("/rest")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/helloWorld", method = RequestMethod.GET)
    public ResponseEntity<String> helloWorld()
    {
        return  new ResponseEntity<String>("hello world", HttpStatus.OK);
    }

    @RequestMapping( value = "/employees", method = RequestMethod.POST )
    @ApiOperation("creates employees")
    @CrossOrigin(origins = "http://localhost:4200")
    public @ResponseBody ResponseEntity createEmployee(@RequestBody Employee emp)
    {
        System.out.println("Employee Name" + emp.getEmployeeName());

        System.out.println("Employee Address" + emp.getEmployeeAddress());
        System.out.println("Phone Number " + emp.getPhoneNumber());
        System.out.println("employee Id" + emp.getEmployeeId());
        System.out.println("dateOfJoining" + emp.getDateOfJoining());
        System.out.println("designation"+emp.getDesignation());
        Timestamp doj = UPSDateUtils.convertStringToTimeStamp("15-03-2021");
        emp.setDateOfJoining(doj);
        Employee employeeFromDb = employeeService.createEmployee(emp);
        return new ResponseEntity<Employee> (employeeFromDb,HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value =  "/employees",method = RequestMethod.GET)
    @ApiOperation("fetch all employees")
    public @ResponseBody ResponseEntity getAllEmployees()
    {
        List<Employee> allEmployees = employeeService.listAllEmployees();
        return new ResponseEntity<List<Employee>>(allEmployees,HttpStatus.OK);
    }


    @RequestMapping(value="/update/employeeId/{employeeId}/employeeName/{employeeName}/employeeAddress/{employeeAddress}/phoneNumber/{phoneNumber}/dateOfJoining/{dateOfJoining}/designation{designation}/",method = RequestMethod.PUT)
    @ApiOperation("Updates an employee")
    public @ResponseBody ResponseEntity updateEmployee(

            @PathVariable("employeeId") String employeeId,
            @PathVariable("employeeName") String employeeName,
            @PathVariable("employeeAddress") String employeeAddress,
            @PathVariable("phoneNumber") String phoneNumber,
            @PathVariable("dateOfJoining") String dateOfJoining,
            @PathVariable("designation") String designation)
    {
        System.out.println("Employee Name" +employeeName);
        System.out.println("Employee Id" + employeeId);
        System.out.println("Employee Address"+employeeAddress);
        System.out.println("phoneNumber" + phoneNumber);
        System.out.println("dateOfJoining"+dateOfJoining);
        System.out.println("designation"+designation);
        Timestamp doj = UPSDateUtils.convertStringToTimeStamp(dateOfJoining);

        Employee updatedEmployee = employeeService.updateEmployee(employeeId,employeeName,employeeAddress,phoneNumber,doj,designation);

        return new ResponseEntity<Employee> (updatedEmployee,HttpStatus.OK);

    }

    @RequestMapping(value="/employees/{id}",method = RequestMethod.DELETE)
    @ApiOperation("delete employees")
    @CrossOrigin(origins = "http://localhost:4200")
    public @ResponseBody ResponseEntity deleteEmployee(@PathVariable("id") String id)
    {
       /* System.out.println("Employee Name" + emp.getEmployeeName());

        System.out.println("Employee Address" + emp.getEmployeeAddress());
        System.out.println("Phone Number " + emp.getPhoneNumber());
        System.out.println("employee Id" + emp.getEmployeeId());
        System.out.println("dateOfJoining" + emp.getDateOfJoining());
        System.out.println("designation"+emp.getDesignation());*/
        System.out.println("ID" + id);
        employeeService.deleteEmployee(id);
        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    }
}
