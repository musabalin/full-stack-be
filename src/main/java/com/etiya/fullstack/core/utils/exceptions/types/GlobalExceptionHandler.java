package com.etiya.fullstack.core.utils.exceptions.types;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.etiya.fullstack.core.utils.exceptions.types.BusinessException;


import java.util.HashMap;
import java.util.Map;

/**
 * @author musa.balin
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse<Object> handleValidationException(MethodArgumentNotValidException exception)
    {
        Map<String,String> errors = new HashMap<>();

        for(FieldError fieldError: exception.getBindingResult().getFieldErrors()){
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return new ExceptionResponse<>("ValidationException",errors);
    }

    @ExceptionHandler({BusinessException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse<String> handleBusinessException(BusinessException exception)
    {
        return new ExceptionResponse<>("BusinessException",exception.getMessage());
    }
}
