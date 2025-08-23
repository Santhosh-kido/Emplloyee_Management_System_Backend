package com.myproject.my_application.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.my_application.entity.EmployeeDetails;
import com.myproject.my_application.requests.AddEmployeeReq;
import com.myproject.my_application.service.EmployeeService;

@RestController
// @CrossOrigin(origins = "*", allowedHeaders = "*", methods =
// {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
// RequestMethod.DELETE})
@CrossOrigin(origins = "http://127.0.0.1:5500")

public class EmployeeController {
    @Autowired
    EmployeeService empService;

    @GetMapping("/get-employee")
    public ResponseEntity<Object> getAllEmployees() {
        return new ResponseEntity<>(empService.fetchAllEmployees(), HttpStatus.OK);
    }

    @GetMapping("/employees")
    public Object getEmployees() {
        return empService.fetchAllEmployees();
    }

    @GetMapping("/get-employees")
    public Object getAllEmployeesPlural() {
        return empService.fetchAllEmployees();
    }

    @GetMapping("/get-employee/{id}")
    public ResponseEntity<Object> getEmployeeById(@PathVariable int id) {
        EmployeeDetails emp = empService.fetchEmployeeId(id);
        if(emp != null){
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }else{
        return new ResponseEntity<>("Employee Not Found!!",HttpStatusCode.valueOf(404));
    }
    }

    @GetMapping("/search-by-name")
    public ResponseEntity<?> getMethodName(@RequestParam String name) {
        List<EmployeeDetails> response = new ArrayList<>();
        response = empService.searchByName(name);
        if (response.isEmpty()) {
            return new ResponseEntity<>("Employee not found!!", HttpStatusCode.valueOf(404));
        }
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @PostMapping("/add-employee")
    public ResponseEntity<String> postMethodName(@RequestBody AddEmployeeReq addEmpReq) {
        String result =  empService.addNewEmployee(addEmpReq);
        if(result.equals("Employee alreday Exists!!")){
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/update-emp")
    public ResponseEntity<String> putMethodName(@RequestBody EmployeeDetails empDtls) {
        String result = empService.updateEmployee(empDtls);
        if(result.equalsIgnoreCase("SUCCESS")){
            return new ResponseEntity<>("Employee Updated Successfully!!", HttpStatus.OK);
        }
        return new ResponseEntity<>(result,HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete-employee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
        String result = empService.delEmployee(id);
        if (result.equals("Employee Deleted Successfully!!")) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }
    }

}
