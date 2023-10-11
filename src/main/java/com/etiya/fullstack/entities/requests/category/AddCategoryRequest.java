package com.etiya.fullstack.entities.requests.category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author musa.balin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCategoryRequest {
    @NotBlank()
    @Size(min = 3, max = 10, message = "{fieldShouldBeMinimum}")
    private String name;
}