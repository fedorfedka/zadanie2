package com.praktika.zadanie2.operations;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/operations")
public class OperationsServiceController {
    @Autowired 
    OperationsService operationsService;

    @GetMapping
    public Map<Long, Operation> getAllUsersOperations() {
        return operationsService.getAllUsersOperations();
    }

    @PostMapping
    public Operation createUser(@RequestBody Operation operation) {
        operationsService.createUser(operation);
        return operation;
    }
    
    @GetMapping("/{id}")
    public Operation getOperationById(@PathVariable(value = "id") Long id) {
        return operationsService.getOperationById(id);
    }

    @PatchMapping("/{id}")
    public void updateOperationById(@PathVariable(value = "id") Long id, @RequestBody Operation operation) {
        operationsService.updateOperationById(id, operation);
    }
}
