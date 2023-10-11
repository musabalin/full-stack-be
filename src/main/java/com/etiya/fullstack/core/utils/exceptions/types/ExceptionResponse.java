package com.etiya.fullstack.core.utils.exceptions.types;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author musa.balin
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse<T> {
    private String type;
    private T detail;
}
