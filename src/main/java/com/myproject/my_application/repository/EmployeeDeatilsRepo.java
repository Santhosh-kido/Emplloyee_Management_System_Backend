package com.myproject.my_application.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject.my_application.entity.EmployeeDetails;

public interface EmployeeDeatilsRepo extends JpaRepository<EmployeeDetails, Integer> {

    List<EmployeeDetails> findByEmpName(String param);

    List<EmployeeDetails> findByEmpNameIgnoreCaseContaining(String name);

    Optional<EmployeeDetails> findByEmpNameAndDeptAndMailAndSalary(String empName, String dept, String mail,
            double salary);

    
}
