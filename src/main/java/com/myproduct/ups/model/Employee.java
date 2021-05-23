package com.myproduct.ups.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.sql.Timestamp;
//import javax.persistence.Id;


@Entity
@Table(name="employees")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Employee {

    @Id
    @Column(name="id",nullable = false,unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="employee_id")
    private String employeeId;


    @Column(name="employee_name")
    private String employeeName;

    @Column(name="employee_address")
    private String employeeAddress;

    @Column(name="phone_number")
    private String phoneNumber;

    @Column(name="date_of_joining")
    private Timestamp dateOfJoining;

    @Column(name="designation")
    private String designation;


    @Override
    public String toString() {
        return "employee_details{" +
                "employee_id" + employeeId +
                "employee_name" + employeeName +
                "employee_address" + employeeAddress +
                "employee_phone_number" + phoneNumber +
                "employee_date_of_joining" + dateOfJoining +
                "employee_designation " + designation +
     "}";

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Timestamp getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(Timestamp dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
