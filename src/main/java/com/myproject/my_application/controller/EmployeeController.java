package com.myproject.my_application.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.my_application.entity.EmployeeDetails;
import com.myproject.my_application.requests.AddEmployeeReq;
import com.myproject.my_application.service.EmployeeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;





@RestController
public class EmployeeController {
    @Autowired
    EmployeeService empService;

    @GetMapping("/get-employee")
    public Object  getAllEmployees() {
        return empService.fetchAllEmployees();
    }


    @GetMapping("/get-employee/{id}")
    public Object getEmployeeById(@PathVariable int id) {
        return empService.fetchEmployeeId(id);
    }

    @GetMapping("/search-by-name")
    public ResponseEntity<?> getMethodName(@RequestParam String name) {
        List<EmployeeDetails> response = new ArrayList<>();
        response = empService.searchByName(name);
        if(response.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found!!");
        }
        return ResponseEntity.ok().body(response);
       
    }
    

    @PostMapping("/add-employee")
    public String postMethodName(@RequestBody AddEmployeeReq addEmpReq) {
        return empService.addNewEmployee(addEmpReq);
    }


   @PutMapping("/update-emp")
   public String putMethodName(@RequestBody EmployeeDetails empDtls) {
       return empService.updateEmployee(empDtls);
   } 


    @DeleteMapping("/delete-employee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id){
        String result = empService.delEmployee(id);
        if(result.equals("Employee Deleted Successfully!!")){
            return ResponseEntity.ok(result);
        }else{
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }
    }

}
