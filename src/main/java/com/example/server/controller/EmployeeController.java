package com.example.server.controller;

import com.example.server.entity.Employee;
import com.example.server.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {

    public EmployeeService employeeService;

    //In-memory storage
    private final Map<String, Employee> employeeMap = new HashMap<>();

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee) throws InterruptedException, ExecutionException {
        employeeMap.put(employee.getDocumentId(), employee);
        employeeService.createEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body("Employee created successfully");
    }
    @GetMapping("/get")
    public Employee getEmployee(@RequestParam String documentId) throws InterruptedException, ExecutionException {
        return employeeService.getEmployee(documentId);
    }

    @GetMapping("/getAll")
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }
    @PutMapping("/update")
    public String updateEmployee(@RequestBody Employee employee) throws InterruptedException, ExecutionException {
        return employeeService.updateEmployee(employee);
    }
    @PutMapping("/delete")
    public String deleteEmployee(@RequestParam String documentId) throws InterruptedException, ExecutionException {
        return employeeService.deleteEmployee(documentId);
    }

    @GetMapping("/test")
    public ResponseEntity<String> testGetEndPoint(){return ResponseEntity.ok("Test Get Endpoint is Working"); }

}
