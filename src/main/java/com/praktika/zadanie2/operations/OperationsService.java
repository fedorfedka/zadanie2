package com.praktika.zadanie2.operations;

import java.util.Map;

public interface OperationsService {
    public abstract Map<Long, Operation> getAllUsersOperations();
    public abstract void createUser(Operation operation);
    public abstract Operation getOperationById(Long id);
    public abstract void updateOperationById(Long id, Operation operation);
}
