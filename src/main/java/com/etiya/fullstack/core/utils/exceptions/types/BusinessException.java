package com.etiya.fullstack.core.utils.exceptions.types;

/**
 * @author musa.balin
 */
public class BusinessException extends RuntimeException{
    public BusinessException(String message) {
        super(message);
    }
}