package com.myproject.my_application.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee_details", schema = "employee")
public class EmployeeDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_details_seq") // match this name
    @SequenceGenerator(name = "employee_details_seq",
    sequenceName = "employee.employee_details_emp_id_seq", allocationSize = 1)
    @Column(name = "emp_id")
    private Integer empId;
    @Column(name = "emp_name")
    private String empName;
    @Column(name = "email")
    private String mail;
    @Column(name = "department")
    private String dept;
    @Column(name = "salary")
    private double salary;
    @Column(name = "joining_date")
    private LocalDate joiningDt;
}
