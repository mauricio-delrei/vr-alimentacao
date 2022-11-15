package com.br.vr.transaction.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class ResourceExistsException extends RuntimeException{

    private static final long serialVersionUID = 1L;


    public ResourceExistsException(String exception) {
        super(exception);
    }
}
