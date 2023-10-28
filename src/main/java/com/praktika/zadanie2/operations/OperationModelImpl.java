package com.praktika.zadanie2.operations;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class OperationModelImpl implements OperationModel{
    private Map<Long, Operation> operations = new HashMap<>();
    private Long id = (long) -1;

    private Long getNextId() {
        return ++id;
    }

    @Override
    public void create(Operation operation) {
        operations.put(getNextId(), operation);
    }

    @Override
    public Map<Long, Operation> findAll() {
        return operations;
    }

    @Override
    public Operation findById(Long id) {
        return operations.get(id);
    }

    @Override
    public void update(Long id, Operation operation) {
        operations.replace(id, operation);
    }

    @Override
    public void delete(Long id) {
        operations.remove(id);
    }
}
