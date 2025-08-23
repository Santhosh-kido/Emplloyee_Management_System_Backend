package com.myproject.my_application.service;

import java.util.List;

import com.myproject.my_application.entity.EmployeeDetails;
import com.myproject.my_application.requests.AddEmployeeReq;

public interface EmployeeService {

    Object fetchAllEmployees();

    EmployeeDetails fetchEmployeeId(int id);

    String addNewEmployee(AddEmployeeReq addEmpReq);

    String updateEmployee(EmployeeDetails empDtls);

    String delEmployee(int id);

    List<EmployeeDetails> searchByName(String param);
}

