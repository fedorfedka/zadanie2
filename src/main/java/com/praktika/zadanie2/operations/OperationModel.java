package com.praktika.zadanie2.operations;

import java.util.Map;

public interface OperationModel {
    public abstract void create(Operation operation);
    public abstract Map<Long, Operation> findAll();
    public abstract Operation findById(Long id);
    public abstract void update(Long id, Operation operation);
    public abstract void delete(Long id);
}
