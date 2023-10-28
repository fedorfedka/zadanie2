package com.praktika.zadanie2.operations;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationsServiceImpl implements OperationsService {

    @Autowired
    OperationModel operationModel;

    @Override
    public Map<Long, Operation> getAllUsersOperations() {
        return operationModel.findAll();
    }

    @Override
    public void createUser(Operation operation) {
        operationModel.create(operation);
    }

    @Override
    public Operation getOperationById(Long id) {
        return operationModel.findById(id);
    }

    @Override
    public void updateOperationById(Long id, Operation operation) {
        operationModel.update(id, operation);
    }
}
