package com.myproject.my_application.service.serviceimpl;

import java.time.LocalDate;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.myproject.my_application.entity.EmployeeDetails;
import com.myproject.my_application.repository.EmployeeDeatilsRepo;
import com.myproject.my_application.requests.AddEmployeeReq;
import com.myproject.my_application.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeDeatilsRepo empRepo;

    // Fetch All Employee
    @Override
    public Object fetchAllEmployees() {
        List<EmployeeDetails> empList = empRepo.findAll();
        if (empList.isEmpty()) {
            return "No employees found!";
        }
        return empList;
    }

    // Fetch Employee By Id
    @Override
    public Object fetchEmployeeId(int id) {
        Optional<EmployeeDetails> emp = empRepo.findById(id);
        if (emp.isEmpty()) {
            System.out.println("Employee not found");
            return "Employee not found!!";
        }
        return emp.get();
    }

    // Search Employee By Name
    @Override
    public List<EmployeeDetails> searchByName(String name) {
        List<EmployeeDetails> emp = empRepo.findByEmpName(name);
        if (emp.isEmpty()) {
            return Collections.emptyList();
        }
        return emp;
    }

    // Add New Employee
    @Override
    public String addNewEmployee(AddEmployeeReq addEmpReq) {
        EmployeeDetails empDetails = new EmployeeDetails();
        empDetails.setDept(addEmpReq.getDept());
        empDetails.setJoiningDt(LocalDate.now());
        empDetails.setEmpName(addEmpReq.getEmpName());
        empDetails.setMail(addEmpReq.getMail());
        empDetails.setSalary(addEmpReq.getSalary());

        empRepo.save(empDetails);

        return "Employee created successfully!!";
    }

    @Override
    public String updateEmployee(EmployeeDetails empDtls) {
        String response = "";
        Optional<EmployeeDetails> optl = empRepo.findById(empDtls.getEmpId());
        if (optl.isPresent()) {
            EmployeeDetails empDetails = optl.get();
            empDetails.setDept(empDtls.getDept());
            empDetails.setEmpName(empDtls.getEmpName());
            empDetails.setJoiningDt(empDtls.getJoiningDt());
            empDetails.setSalary(empDtls.getSalary());
            empDetails.setMail(empDtls.getMail());
            empRepo.save(empDetails);

            response = "Employe Updated successfully";

        } else {
            response = "Employee Not Exists";
        }
        return response;
    }

    // Delete an Employee
    @Override
    public String delEmployee(int id) {
        if (empRepo.existsById(id)) {
            empRepo.deleteById(id);
            return "Employee Deleted Successfully!!";
        } else {
            return "Employee Not found!!";
        }

    }

}
