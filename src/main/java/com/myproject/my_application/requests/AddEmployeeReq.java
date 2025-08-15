package com.myproject.my_application.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddEmployeeReq {

    private String empName;
    private String mail;
    private String dept;
    private double salary;
    

}
