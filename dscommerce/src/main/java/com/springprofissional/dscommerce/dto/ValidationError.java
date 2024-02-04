package com.springprofissional.dscommerce.dto;

import java.sql.Array;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends CustomError{

    private List<FieldMessege> errors = new ArrayList<>();

    public ValidationError(List<FieldMessege> errors) {
        this.errors = errors;
    }

    public ValidationError(Instant timestap, Integer status, String error, String path) {
        super(timestap, status, error, path);
    }

    public List<FieldMessege> getErrors() {
        return errors;
    }

    

    public void addError(String fieldName, String messege){
        errors.removeIf(x -> x.getFieldName().equals(fieldName));
        errors.add(new FieldMessege(fieldName,messege));
    }
}
